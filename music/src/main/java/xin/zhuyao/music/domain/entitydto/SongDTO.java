package xin.zhuyao.music.domain.entitydto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Api(value = "歌曲数据")
public class SongDTO implements Serializable {

    @ApiModelProperty(value = "未知",dataType = "Integer")
    Integer br;

    @ApiModelProperty(value = "歌曲大小",dataType = "Long")
    Long size;

    @ApiModelProperty(value = "歌曲路径",dataType = "String")
    String url;

}
