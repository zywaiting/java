package xin.zhuyao.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import xin.zhuyao.test.domain.entitydto.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestApplicationTests {

    @Value("${WeChat.key}")
    private String key;

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeChatArticleDTO> forEntity = restTemplate.getForEntity(key, WeChatArticleDTO.class);
        WeChatArticleDTO body = forEntity.getBody();
        String generalMsgList = body.getGeneralMsgList();
        WeChatGeneralMsgDTO weChatGeneralMsgDTO = JSONObject.parseObject(generalMsgList, WeChatGeneralMsgDTO.class);
        String X = "123";
        System.out.println(body);
    }

    @Test
    public void test(){
        WeChatGeneralMsgDTO weChatGeneralMsgDTO = new WeChatGeneralMsgDTO();

        List<WeChatMsgDTO> weChatMsgDTOList = new ArrayList<>();
        WeChatMsgDTO weChatMsgDTO = new WeChatMsgDTO();

        WeChatCommMsgInfoDTO weChatCommMsgInfoDTO = new WeChatCommMsgInfoDTO();
        weChatCommMsgInfoDTO.setContent("123");
        WeChatAppMsgExtInfoDTO weChatAppMsgExtInfoDTO = new WeChatAppMsgExtInfoDTO();
        weChatAppMsgExtInfoDTO.setAuthor("234");
        weChatAppMsgExtInfoDTO.setAudioFileid(1);

        weChatMsgDTO.setWeChatCommMsgInfoDTO(weChatCommMsgInfoDTO);
        weChatMsgDTO.setWeChatAppMsgExtInfoDTO(weChatAppMsgExtInfoDTO);
        weChatMsgDTOList.add(weChatMsgDTO);
        weChatGeneralMsgDTO.setWeChatMsgDTOList(weChatMsgDTOList);

        System.out.println(JSONObject.toJSON(weChatGeneralMsgDTO));


    }

}
