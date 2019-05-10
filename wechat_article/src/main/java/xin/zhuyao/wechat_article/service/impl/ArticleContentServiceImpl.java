package xin.zhuyao.wechat_article.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.zhuyao.wechat_article.domain.entity.ArticleContentEntity;
import xin.zhuyao.wechat_article.domain.entity.ArticleUrlEntity;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatAppMsgExtInfoDTO;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatArticleDTO;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatGeneralMsgDTO;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatMsgDTO;
import xin.zhuyao.wechat_article.repository.ArticleContentRepository;
import xin.zhuyao.wechat_article.repository.ArticleUrlRepository;
import xin.zhuyao.wechat_article.service.ArticleContentService;
import xin.zhuyao.wechat_article.singleton.RestTemplateSingleton;
import xin.zhuyao.wechat_article.utils.ThreadPoolUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class ArticleContentServiceImpl implements ArticleContentService {

    @Autowired
    private ArticleUrlRepository articleUrlRepository;
    @Autowired
    private ArticleContentRepository articleContentRepository;

    public List<Boolean> saveArticle(){
        List<Callable<Boolean>> callables = new ArrayList<>();
        List<ArticleUrlEntity> articleUrlEntityList = articleUrlRepository.findByStatus(false);
        for (ArticleUrlEntity articleUrlEntity : articleUrlEntityList) {
            articleUrlEntity.setStatus(true);
        }
        articleUrlRepository.saveAll(articleUrlEntityList);
        for (ArticleUrlEntity articleUrlEntity : articleUrlEntityList) {
            callables.add(() -> getArticle(articleUrlEntity, 0));
        }
        List<Boolean> result = ThreadPoolUtils.addTask(callables);
        return result;
    }

    private Boolean getArticle(ArticleUrlEntity articleUrlEntity,Integer offset) throws InterruptedException {
        Thread.sleep(1000);
        String articleUrl = articleUrlEntity.getArticleUrl();
        int bizStart = articleUrl.indexOf("__biz=");
        int bizEnd = articleUrl.indexOf("&",bizStart);
        int uinStart = articleUrl.indexOf("uin=");
        int uinEnd = articleUrl.indexOf("&",uinStart);
        int keyStart = articleUrl.indexOf("key=");
        int keyEnd = articleUrl.indexOf("&",keyStart);
        ResponseEntity<WeChatArticleDTO> weChatArticleDTOResponseEntity = RestTemplateSingleton.getRestTemplate().getForEntity(
                "https://mp.weixin.qq.com/mp/profile_ext?action=getmsg&" + articleUrl.substring(bizStart, bizEnd) +
                        "&f=json&offset=" + offset + "&" + articleUrl.substring(uinStart, uinEnd) + "&" + articleUrl.substring(keyStart, keyEnd), WeChatArticleDTO.class);
        if (weChatArticleDTOResponseEntity.getStatusCodeValue() == 200) {
            WeChatArticleDTO weChatArticleDTO = weChatArticleDTOResponseEntity.getBody();
            WeChatGeneralMsgDTO weChatGeneralMsgDTO = JSONObject.parseObject(weChatArticleDTO.getGeneralMsgList(), WeChatGeneralMsgDTO.class);
            List<WeChatMsgDTO> weChatMsgDTOList = weChatGeneralMsgDTO.getWeChatMsgDTOList().stream().filter(weChatMsgDTO -> !StringUtils.isEmpty(weChatMsgDTO.getWeChatAppMsgExtInfoDTO().getTitle())).collect(Collectors.toList());

            List<ArticleContentEntity> articleContentEntityList1 = weChatMsgDTOList.stream().map(WeChatMsgDTO::getWeChatAppMsgExtInfoDTO).map(ArticleContentEntity::new).collect(Collectors.toList());
            List<ArticleContentEntity> articleContentEntityList2 = weChatMsgDTOList.stream().map(WeChatMsgDTO::getWeChatCommMsgInfoDTO).map(ArticleContentEntity::new).collect(Collectors.toList());

            for (int i = 0; i < articleContentEntityList1.size(); i++) {
                articleContentEntityList1.get(i).setName(articleUrlEntity.getName());
                articleContentEntityList1.get(i).setCreateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
                articleContentEntityList1.get(i).setFileTime(articleContentEntityList2.get(i).getFileTime());
            }
            articleContentRepository.saveAll(articleContentEntityList1);
            if (!(weChatArticleDTO.getMsgCount() < 10)) {
                getArticle(articleUrlEntity, weChatArticleDTO.getNextOffset());
            }
            return true;
        }
        return false;
    }

}
