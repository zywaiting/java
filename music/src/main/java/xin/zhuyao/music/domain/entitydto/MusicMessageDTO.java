package xin.zhuyao.music.domain.entitydto;

import com.alibaba.fastjson.annotation.JSONField;
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
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Api(value = "歌曲数据信息")
public class MusicMessageDTO implements Serializable {
    /**
     * album: "我想和你唱 第二季 第4期"
     * artist: ["张碧晨", "陈奕夫", "傲日其愣", "唐倩"]
     * id: 479408220
     * lyric_id: 479408220
     * name: "凉凉"
     * pic_id: "19212866183896782"
     * source: "netease"
     * url_id: 479408220
     */

    @ApiModelProperty(value = "歌曲id",dataType = "String")
    String id;

    @ApiModelProperty(value = "歌曲名",dataType = "String")
    String name;

    @ApiModelProperty(value = "歌手",dataType = "String")
    String[] artist;

    @ApiModelProperty(value = "专辑",dataType = "String")
    String album;

    @JSONField(name = "pic_id")
    @ApiModelProperty(value = "图片id",dataType = "String")
    String picId;

    @JSONField(name = "url_id")
    @ApiModelProperty(value = "歌曲路径id",dataType = "String")
    String urlId;

    @JSONField(name = "lyric_id")
    @ApiModelProperty(value = "歌词路径id",dataType = "String")
    String lyricId;

    @ApiModelProperty(value = "歌曲来源",dataType = "String")
    String source;
}
