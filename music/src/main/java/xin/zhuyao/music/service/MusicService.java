package xin.zhuyao.music.service;

import xin.zhuyao.music.domain.entitydto.MusicDTO;
import xin.zhuyao.music.domain.entitydto.MusicMessageDTO;
import xin.zhuyao.music.domain.entityvm.SongIdVM;
import xin.zhuyao.music.domain.entityvm.SongNameVM;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface MusicService {

    List<MusicMessageDTO> getMusicList(SongNameVM songNameVM);

    MusicDTO getSong(SongIdVM songIdVM);
}
