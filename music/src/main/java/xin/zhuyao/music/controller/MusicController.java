package xin.zhuyao.music.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.music.domain.entitydto.MusicDTO;
import xin.zhuyao.music.domain.entitydto.MusicMessageDTO;
import xin.zhuyao.music.domain.entityvm.SongIdVM;
import xin.zhuyao.music.domain.entityvm.SongNameVM;
import xin.zhuyao.music.service.MusicService;
import xin.zhuyao.music.utils.ResponseMessageUtils;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "api",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "歌曲", description = "歌曲")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @ApiOperation(value = "获取歌曲列表", notes = "获取歌曲列表")
    @RequestMapping(value = "getMusicList",method = RequestMethod.POST)
    public ResponseMessageUtils<List<MusicMessageDTO>> getMusicList(@RequestBody SongNameVM songNameVM) {
        return ResponseMessageUtils.ok(musicService.getMusicList(songNameVM));
    }

    @ApiOperation(value = "获取歌曲信息", notes = "获取歌曲信息")
    @RequestMapping(value = "getSong",method = RequestMethod.POST)
    public ResponseMessageUtils<MusicDTO> getSong(@RequestBody SongIdVM songIdVM) {
        return ResponseMessageUtils.ok(musicService.getSong(songIdVM));
    }

}
