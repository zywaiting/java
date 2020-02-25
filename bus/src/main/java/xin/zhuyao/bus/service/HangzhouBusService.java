package xin.zhuyao.bus.service;

import xin.zhuyao.bus.domain.dto.hangzhou.BusPositionDTO;
import xin.zhuyao.bus.domain.dto.hangzhou.RouteDTO;

import java.util.List;

/**
 * @ClassName HangzhouBusService
 * @Author zy
 * @Date 2020/2/25 15:54
 * @Description HangzhouBusService
 * @Version 1.0
 */
public interface HangzhouBusService {


    /**
     * 根据输入查询线路信息
     * @param routeName
     * @return
     */
    List<RouteDTO> findRouteByName(String routeName);


    /**
     * 根据线路id查询数据
     * @param routeId
     * @return
     */
    List<BusPositionDTO> getBusPositionByRouteId(Long routeId);

}
