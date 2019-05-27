package xin.zhuyao.music.domain.entitydto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Api(value = "歌词信息")
public class MusicDTO {
    /**
     * " lyrics": "就是你现在的歌词格式",
     *   "audioUrl": "
     */
    @ApiModelProperty(value = "歌词",dataType = "String")
    String lyrics;

    @ApiModelProperty(value = "歌曲url",dataType = "String")
    String audioUrl;
}
