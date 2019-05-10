package xin.zhuyao.wechat_article;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.zhuyao.wechat_article.service.ArticleContentService;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WeChatArticleApplicationTests {

    @Autowired
    private ArticleContentService articleContentService;

    @Test
    public void contextLoads() {
        List<Boolean> booleans = articleContentService.saveArticle();
        for (Boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }


}
