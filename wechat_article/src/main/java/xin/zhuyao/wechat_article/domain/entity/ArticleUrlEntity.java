package xin.zhuyao.wechat_article.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "t_article_url")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleUrlEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ApiModelProperty(value = "公众号名称",dataType = "String")
    String name;

    @Lob
    @ApiModelProperty(value = "公众号文章链接",dataType = "String")
    String ArticleUrl;

    @ApiModelProperty(value = "是否抓取过---true已抓取，false未抓取",dataType = "String")
    Boolean status;

}
