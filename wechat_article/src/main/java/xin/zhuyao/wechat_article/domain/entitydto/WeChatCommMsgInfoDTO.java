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
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeChatCommMsgInfoDTO implements Serializable {

    /**
     *  "id":1000000049,
     *                 "type":49,
     *                 "datetime":1551179028,
     *                 "fakeid":"3081785515",
     *                 "status":2,
     *                 "content":""
     */

    @ApiModelProperty(value = "ID",dataType = "Double")
    @JSONField(name = "id")
    Long id;

    @ApiModelProperty(value = "类型",dataType = "Integer")
    @JSONField(name = "type")
    Integer type;

    @ApiModelProperty(value = "时间",dataType = "Double")
    @JSONField(name = "datetime")
    Long datetime;

    @ApiModelProperty(value = "未知",dataType = "Double")
    @JSONField(name = "fakeid")
    Long fakeid;

    @ApiModelProperty(value = "状态",dataType = "Integer")
    @JSONField(name = "status")
    Integer status;

    @ApiModelProperty(value = "文章内容",dataType = "String")
    @JSONField(name = "content")
    String content;
}
