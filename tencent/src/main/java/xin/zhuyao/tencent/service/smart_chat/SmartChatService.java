package xin.zhuyao.tencent.service.smart_chat;

import xin.zhuyao.tencent.domian.dto.ReturnDTO;
import xin.zhuyao.tencent.domian.dto.SmartChatDTO;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName SmartChatService
 * @Author zy
 * @Date 2020/2/21 15:23
 * @Description SmartChatService
 * @Version 1.0
 */
public interface SmartChatService {

    /**
     * 智能闲聊
     * @param session
     * @param question
     * @return
     */
    SmartChatDTO getSmartChat(String session, String question);
}
