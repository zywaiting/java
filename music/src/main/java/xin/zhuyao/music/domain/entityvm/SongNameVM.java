package xin.zhuyao.music.domain.entityvm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Api(value = "歌曲名")
public class SongNameVM implements Serializable {

    @NonNull
    @ApiModelProperty(value = "歌曲名称",dataType = "String")
    String songName;

    @NonNull
    @ApiModelProperty(value = "歌曲数量，开始为0会反20条",dataType = "String")
    Integer songNum;
}
