package xin.zhuyao.wechat_bot;

import lombok.extern.slf4j.Slf4j;
import xin.zhuyao.wechat_bot.api.annotation.Bind;
import xin.zhuyao.wechat_bot.api.constant.Config;
import xin.zhuyao.wechat_bot.api.enums.AccountType;
import xin.zhuyao.wechat_bot.api.enums.MsgType;
import xin.zhuyao.wechat_bot.api.model.WeChatMessage;
import xin.zhuyao.wechat_bot.utils.StringUtils;

@Slf4j
public class HelloBot extends WeChatBot {


    public HelloBot(Config config) {
        super(config);
    }

    //个人
    @Bind(msgType = MsgType.TEXT, accountType = AccountType.TYPE_FRIEND)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            if ("开机".equals(message.getText())) {
                this.sendMsg(message.getFromUserName(), "瑶瑶以准备好，要和你大战300个回合![色][色][色]");
//                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot( message.getFromUserName(), message.getText());
                return;
            } else if ("关机".equals(message.getText())) {
//                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot(message.getFromUserName(), message.getText());
                this.sendMsg(message.getFromUserName(), "瑶瑶要走了,别想我![可怜][可怜][可怜]");
                return;
            } else {
//                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot(message.getFromUserName(), message.getText());
//                if (!"关机".equals(tencentBotDto.getMsg())) {
//                    if (tencentBotDto.getRet() == 0) {
//                        this.sendMsg(message.getFromUserName(), tencentBotDto.getData().getAnswer().replaceAll("豪豪", "瑶瑶"));
//                    } else {
//                        this.sendMsg(message.getFromUserName(), "信息量太大，容瑶瑶想想。。。[晕][晕][晕]");
//                    }
//                }
            }

        }
    }


    //群组
    @Bind(msgType = MsgType.TEXT, accountType = AccountType.TYPE_GROUP)
    public void handleGroupText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            if (message.isAtMe()) {
//                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot(message.getFromUserName(), message.getText());
//                if (tencentBotDto.getRet() == 0) {
//                    this.sendMsg(message.getFromUserName(), tencentBotDto.getData().getAnswer().replaceAll("豪豪", "瑶瑶"));
//                } else {
//                    this.sendMsg(message.getFromUserName(), "信息量太大，容瑶瑶想想。。。[晕][晕][晕]");
//                }
            }
        }
    }


    @Bind(msgType = MsgType.VOICE)
    public void handleVideo(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
//            KeDaXuFeiUtils.Result result = KeDaXuFeiUtils.speechRecognizer(message.getVoicePath());
//            if (result != null && "success".equals(result.getDesc())) {
//                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot(message.getFromUserName(), result.getData());
//                if (!"关机".equals(tencentBotDto.getMsg())) {
//                    if (tencentBotDto.getRet() == 0) {
//                        this.sendMsg(message.getFromUserName(), tencentBotDto.getData().getAnswer().replaceAll("豪豪", "瑶瑶"));
//                    } else {
//                        this.sendMsg(message.getFromUserName(), "信息量太大，容瑶瑶想想。。。[晕][晕][晕]");
//                    }
//                }
//            }
        }
    }

    @Bind(msgType = MsgType.IMAGE)
    public void handleImage(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
//            TencentPictureReturn tencentPictureReturn = TencentPictureUtils.tencentPicture(message.getImagePath(), "5");
//            if (!"关机".equals(tencentPictureReturn.getMsg()) && tencentPictureReturn.getRet() == 0 &&
//                    tencentPictureReturn.getData().getImage() != null && StringUtils.isNotEmpty(tencentPictureReturn.getData().getImage())) {
//                String imageUrl = Base64TestUtils.GenerateImage(tencentPictureReturn.getData().getImage());
//                this.sendImg(message.getFromUserName(), imageUrl);
//            }
        }
    }

    public static void main(String[] args) {
        new HelloBot(Config.me().autoLogin(false).showTerminal(true)).start("1234");
    }
}