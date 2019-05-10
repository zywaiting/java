package xin.zhuyao.wechat_article.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatAppMsgExtInfoDTO;
import xin.zhuyao.wechat_article.domain.entitydto.WeChatCommMsgInfoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "t_article_content")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleContentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "公众号名称",dataType = "String")
    String name;

    @ApiModelProperty(value = "文章标题",dataType = "String")
    String title;

    @ApiModelProperty(value = "文章描述",dataType = "String")
    String digest;

    @Lob
    @ApiModelProperty(value = "文章链接",dataType = "String")
    String contentUrl;

    @Lob
    @ApiModelProperty(value = "首图链接",dataType = "String")
    String cover;

    @ApiModelProperty(value = "作者",dataType = "String")
    String author;

    @ApiModelProperty(value = "文件生成时间",dataType = "String")
    String fileTime;

    @ApiModelProperty(value = "创建时间",dataType = "String")
    String createTime;


    public ArticleContentEntity(WeChatAppMsgExtInfoDTO weChatAppMsgExtInfoDTO) {
        BeanUtils.copyProperties(weChatAppMsgExtInfoDTO,this);
    }

    public ArticleContentEntity(WeChatCommMsgInfoDTO weChatCommMsgInfoDTO) {
        this.fileTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochSecond(weChatCommMsgInfoDTO.getDatetime()), ZoneId.systemDefault()));
    }
}
