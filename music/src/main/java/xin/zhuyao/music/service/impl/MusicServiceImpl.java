package xin.zhuyao.music.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.music.domain.entitydto.LyricDTO;
import xin.zhuyao.music.domain.entitydto.MusicDTO;
import xin.zhuyao.music.domain.entitydto.MusicMessageDTO;
import xin.zhuyao.music.domain.entitydto.SongDTO;
import xin.zhuyao.music.domain.entityvm.SongIdVM;
import xin.zhuyao.music.domain.entityvm.SongNameVM;
import xin.zhuyao.music.service.MusicService;
import xin.zhuyao.music.utils.UnicodeToStringUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/27
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class MusicServiceImpl implements MusicService {

    private static final String URL = "https://music.laod.cn/api.php";

    @Override
    public List<MusicMessageDTO> getMusicList(SongNameVM songNameVM) {
        List<String> sourceList = Arrays.asList("netease","xiami","kugou","baidu");
        Map<String, List<MusicMessageDTO>> sourceMap = new HashMap<>();
        Map<String, String> musicMessageMap = new HashMap<>();
        musicMessageMap.put("types", "search");
        musicMessageMap.put("count", songNameVM.getSongNum() == 0 ? "20" : songNameVM.getSongNum().toString());
        musicMessageMap.put("pages", "1");
        musicMessageMap.put("name", songNameVM.getSongName());
        for (String source : sourceList) {
            musicMessageMap.put("source", source);
            String musicMessage = HttpUtils.posts(URL, musicMessageMap);
            List<MusicMessageDTO> musicMessageDTOList = JSONObject.parseArray(musicMessage, MusicMessageDTO.class);
            sourceMap.put(source,musicMessageDTOList);
        }
        List<MusicMessageDTO> musicMessageDTOList = new ArrayList<>();
        List<MusicMessageDTO> musicMessageDTOListNetease = sourceMap.get("netease");
//        List<MusicMessageDTO> musicMessageDTOListTencent = sourceMap.get("tencent");
        List<MusicMessageDTO> musicMessageDTOListXiami = sourceMap.get("xiami");
        List<MusicMessageDTO> musicMessageDTOListKugou = sourceMap.get("kugou");
//        List<MusicMessageDTO> musicMessageDTOListBaidu = sourceMap.get("baidu");
        for (int i = 0;
                i < musicMessageDTOListNetease.size() ||
//                i < musicMessageDTOListTencent.size() ||
                i < musicMessageDTOListXiami.size() ||
                i < musicMessageDTOListKugou.size()
//                i < musicMessageDTOListBaidu.size()
                ; i++) {
            if (i < musicMessageDTOListNetease.size()) {
                musicMessageDTOList.add(musicMessageDTOListNetease.get(i));
            }
//            if (i < musicMessageDTOListTencent.size()) {
//                musicMessageDTOList.add(musicMessageDTOListTencent.get(i));
//            }
            if (i < musicMessageDTOListXiami.size()) {
                musicMessageDTOList.add(musicMessageDTOListXiami.get(i));
            }
            if (i < musicMessageDTOListKugou.size()) {
                musicMessageDTOList.add(musicMessageDTOListKugou.get(i));
            }
//            if (i < musicMessageDTOListBaidu.size()) {
//                musicMessageDTOList.add(musicMessageDTOListBaidu.get(i));
//            }
        }
        System.out.println((musicMessageDTOList.size() > (songNameVM.getSongNum() == 0 ? 20 : songNameVM.getSongNum())));
        return musicMessageDTOList.subList(0, (musicMessageDTOList.size() > (songNameVM.getSongNum() == 0 ? 20 : songNameVM.getSongNum())) ? (songNameVM.getSongNum() == 0 ? 20 : songNameVM.getSongNum()) : musicMessageDTOList.size());
    }

    @Override
    public MusicDTO getSong(SongIdVM songIdVM) {
        Map<String, String> lyricMap = new HashMap<>();
        lyricMap.put("types", "lyric");
        lyricMap.put("source", songIdVM.getSource());
        lyricMap.put("id", songIdVM.getId());
        String s1 = HttpUtils.posts(URL, lyricMap);
        LyricDTO lyricDTO = JSONObject.parseObject(UnicodeToStringUtils.unicodeToString(s1), LyricDTO.class);

        Map<String, String> songMap = new HashMap<>();
        songMap.put("types", "url");
        songMap.put("source", songIdVM.getSource());
        songMap.put("id", songIdVM.getId());
        String s2 = HttpUtils.posts(URL, songMap);
        SongDTO songDTO = JSONObject.parseObject(s2, SongDTO.class);
        return MusicDTO.builder().lyrics(lyricDTO.getLyric()).audioUrl(songDTO.getUrl()).build();
    }



}
