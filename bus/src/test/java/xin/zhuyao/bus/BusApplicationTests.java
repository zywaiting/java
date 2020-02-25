package xin.zhuyao.bus;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.zhuyao.bus.domain.dto.hangzhou.BusPositionDTO;
import xin.zhuyao.bus.domain.dto.hangzhou.RouteDTO;
import xin.zhuyao.bus.service.HangzhouBusService;

import java.util.List;

/**
 * @ClassName BusApplicationTests
 * @Author zy
 * @Date 2020/2/25 16:28
 * @Description BusApplicationTests
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BusApplicationTests {

    @Autowired
    private HangzhouBusService hangzhouBusService;

    @Test
    public void test(){
        List<RouteDTO> routeByName = hangzhouBusService.findRouteByName("24");

        List<BusPositionDTO> busPositionByRouteId = hangzhouBusService.getBusPositionByRouteId(routeByName.get(0).getRoutes().get(0).getRouteId());
        System.out.println(busPositionByRouteId);
    }

}
