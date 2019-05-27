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
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Api(value = "歌词信息")
public class LyricDTO implements Serializable {

    @ApiModelProperty(value = "歌词",dataType = "String")
    String lyric;

    @ApiModelProperty(value = "未知",dataType = "String")
    String tlyric;
}
