package xin.zhuyao.test.domain.entitydto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeChatAppMsgExtInfoDTO implements Serializable {

    /**
     * "title":"使用Netty，我们到底在开发些什么？",
     *                 "digest":"本文将说明使用netty开发，都关注哪些通用的内容，然后附上单机支持100w连接的linux配置。本文并不关注netty的基础知识。",
     *                 "content":"",
     *                 "fileid":0,
     *                 "content_url":"http://mp.weixin.qq.com/s?__biz=MzA4MTc4NTUxNQ==&mid=2650519418&idx=1&sn=b465291cbc396a0b665ed120d1176f68&chksm=8780b0beb0f739a8650460fdb61496ac59ac0f5c6072510b370007d5d41b0a4d2f679e0b6322&scene=27#wechat_redirect",
     *                 "source_url":"",
     *                 "cover":"http://mmbiz.qpic.cn/mmbiz_jpg/cvQbJDZsKLrSTS4WE7Cdosgj3T01Tlpkwzph3lfiaBWgnDG9mJiard1EKKrlic4VYCQK4R0tG7PmJ6MxxfVhBdVMw/0?wx_fmt=jpeg",
     *                 "subtype":9,
     *                 "is_multi":0,
     *                 "multi_app_msg_item_list":[
     *
     *                 ],
     *                 "author":"小姐姐养的狗",
     *                 "copyright_stat":11,
     *                 "duration":0,
     *                 "del_flag":1,
     *                 "item_show_type":0,
     *                 "audio_fileid":0,
     *                 "play_url":"",
     *                 "malicious_title_reason_id":0,
     *                 "malicious_content_type":0
     */

    @ApiModelProperty(value = "文章标题",dataType = "String")
    @JSONField(name = "title")
    String title;

    @ApiModelProperty(value = "文章内容",dataType = "String")
    @JSONField(name = "content_url")
    String content;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "fileid")
    Integer fileid;

    @ApiModelProperty(value = "文章链接",dataType = "String")
    @JSONField(name = "content")
    String contentUrl;

    @ApiModelProperty(value = "未知",dataType = "String")
    @JSONField(name = "source_url")
    String sourceUrl;

    @ApiModelProperty(value = "首图链接",dataType = "String")
    @JSONField(name = "cover")
    String cover;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "subtype")
    Integer subtype;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "is_multi")
    Integer isMulti;

    @ApiModelProperty(value = "未知",dataType = "List")
    @JSONField(name = "multi_app_msg_item_list")
    List multiAppMsgItemList;

    @ApiModelProperty(value = "作者",dataType = "List")
    @JSONField(name = "author")
    String author;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "copyright_stat")
    Integer copyrightStat;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "duration")
    Integer duration;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "del_flag")
    Integer delFlag;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "item_show_type")
    Integer itemShowType;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "audio_fileid")
    Integer audioFileid;

    @ApiModelProperty(value = "未知",dataType = "String")
    @JSONField(name = "play_url")
    String playUrl;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "malicious_title_reason_id")
    Integer maliciousTitleReasonId;

    @ApiModelProperty(value = "未知",dataType = "Integer")
    @JSONField(name = "malicious_content_type")
    Integer maliciousContentType;
}
