package xin.zhuyao.wechat_article.domain.entitydto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeChatMsgDTO implements Serializable {

    @ApiModelProperty(value = "未知",dataType = "Object")
    @JSONField(name = "comm_msg_info")
    WeChatCommMsgInfoDTO weChatCommMsgInfoDTO;

    @ApiModelProperty(value = "未知",dataType = "Object")
    @JSONField(name = "app_msg_ext_info")
    WeChatAppMsgExtInfoDTO weChatAppMsgExtInfoDTO;

}
