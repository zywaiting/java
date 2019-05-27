package xin.zhuyao.music;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.zhuyao.music.domain.entitydto.MusicMessageDTO;
import xin.zhuyao.music.domain.entityvm.SongIdVM;
import xin.zhuyao.music.domain.entityvm.SongNameVM;
import xin.zhuyao.music.service.MusicService;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MusicApplicationTests {

    @Autowired
    private MusicService musicService;

    @Test
    public void contextLoads() {
        SongNameVM songNameVM = new SongNameVM();
        songNameVM.setSongName("凉凉");
        songNameVM.setSongNum(20);
        List<MusicMessageDTO> musicList = musicService.getMusicList(songNameVM);
        System.out.println(musicList);
    }

    @Test
    public void test() {

    }


}
