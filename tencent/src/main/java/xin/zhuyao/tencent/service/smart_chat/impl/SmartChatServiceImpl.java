package xin.zhuyao.tencent.service.smart_chat.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xin.zhuyao.tencent.domian.dto.ReturnDTO;
import xin.zhuyao.tencent.domian.dto.SmartChatDTO;
import xin.zhuyao.tencent.service.smart_chat.SmartChatService;
import xin.zhuyao.tencent.utils.MapToStringUrlUtils;
import xin.zhuyao.tencent.utils.SortUtils;

import java.util.*;

/**
 * @ClassName SmartChatServiceImpl
 * @Author zy
 * @Date 2020/2/21 15:24
 * @Description SmartChatServiceImpl
 * @Version 1.0
 */
@Service
public class SmartChatServiceImpl implements SmartChatService {

    @Value("${tencent.smart_chat.url}")
    private String URL;
    @Value("${tencent.smart_chat.app_id}")
    private String appId;
    @Value("${tencent.smart_chat.app_key}")
    private String appKey;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SmartChatDTO getSmartChat(String session, String question) {
        HashMap<String,String> hashMapParams = new HashMap<>(16);
        hashMapParams.put("app_id",appId);
        hashMapParams.put("time_stamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMapParams.put("nonce_str", UUID.randomUUID().toString().replaceAll("-",""));
        hashMapParams.put("session",session);
        hashMapParams.put("question",question);
        hashMapParams.put("sign", DigestUtils.md5Hex(SortUtils.formatUrlParam(hashMapParams, "UTF-8", true, appKey)).toUpperCase());
        ReturnDTO returnDTO = restTemplate.getForObject(URL + MapToStringUrlUtils.getParams(hashMapParams), ReturnDTO.class);
        if (returnDTO.getRet() == 0) {
            return returnDTO.getData();
        }
        return null;
    }

}
