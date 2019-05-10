package xin.zhuyao.test.domain.entitydto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 9:53
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeChatArticleDTO implements Serializable {
    /**
     * can_msg_continue: 0
     * errmsg: "ok"
     * general_msg_list: ""
     * home_page_list: []
     * msg_count: 5
     * next_offset: 66
     * real_type: 0
     * ret: 0
     * use_video_tab: 1
     * video_count: 0
     */
    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JsonProperty(value = "can_msg_continue")
    Integer canMsgContinue;

    @ApiModelProperty(value = "返回结果",dataType = "String")
    @JsonProperty(value = "errmsg")
    String errmsg;

    @ApiModelProperty(value = "文章内容",dataType = "String")
    @JsonProperty(value = "general_msg_list")
    String generalMsgList;

    @ApiModelProperty(value = "未知",dataType = "List")
    @JsonProperty(value = "home_page_list")
    List homePageList;

    @ApiModelProperty(value = "返回数量",dataType = "Integer")
    @JsonProperty(value = "msg_count")
    Integer msgCount;

    @ApiModelProperty(value = "下次开始数",dataType = "Integer")
    @JsonProperty(value = "next_offset")
    Integer nextOffset;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JsonProperty(value = "real_type")
    Integer realType;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JsonProperty(value = "ret")
    Integer ret;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JsonProperty(value = "use_video_tab")
    Integer useVideoTab;

    @ApiModelProperty(value = "视频数量",dataType = "Integer")
    @JsonProperty(value = "video_count")
    Integer videoCount;

}
