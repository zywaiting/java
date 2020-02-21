package xin.zhuyao.tencent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.zhuyao.tencent.domian.dto.SmartChatDTO;
import xin.zhuyao.tencent.service.smart_chat.SmartChatService;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TencentApplicationTests {


    @Autowired
    private SmartChatService smartChatService;

    @Test
    public void contextLoads() {
        SmartChatDTO smartChatDTO = smartChatService.getSmartChat("10000", "lol");
        System.out.println(smartChatDTO);
    }


}
