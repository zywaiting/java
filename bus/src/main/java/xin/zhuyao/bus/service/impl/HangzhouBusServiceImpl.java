package xin.zhuyao.bus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xin.zhuyao.bus.domain.dto.hangzhou.BusPositionDTO;
import xin.zhuyao.bus.domain.dto.hangzhou.FindRouteByNameDTO;
import xin.zhuyao.bus.domain.dto.hangzhou.GetBusPositionByRouteIdDTO;
import xin.zhuyao.bus.domain.dto.hangzhou.RouteDTO;
import xin.zhuyao.bus.service.HangzhouBusService;

import java.util.List;

/**
 * @ClassName HangzhouBusServiceImpl
 * @Author zy
 * @Date 2020/2/25 15:57
 * @Description HangzhouBusServiceImpl
 * @Version 1.0
 */
@Service
public class HangzhouBusServiceImpl implements HangzhouBusService {

    private static final String FIND_ROUTE_BY_NAME_URL = "https://app.ibuscloud.com/v1/bus/findRouteByName?city=330100&h5Platform=6&routeName=";
    private static final String GET_BUS_POSITION_BY_ROUTEID_URL = "https://app.ibuscloud.com/v1/bus/getBusPositionByRouteId?city=330100&h5Platform=6&routeId=";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<RouteDTO> findRouteByName(String routeName) {
        FindRouteByNameDTO findRouteByNameDTO = restTemplate.getForObject(FIND_ROUTE_BY_NAME_URL + routeName, FindRouteByNameDTO.class);
        if (findRouteByNameDTO.getResult() == 0) {
            return findRouteByNameDTO.getItems();
        }
        return null;
    }

    @Override
    public List<BusPositionDTO> getBusPositionByRouteId(Long routeId) {
        GetBusPositionByRouteIdDTO getBusPositionByRouteIdDTO = restTemplate.getForObject(GET_BUS_POSITION_BY_ROUTEID_URL + routeId, GetBusPositionByRouteIdDTO.class);
        if (getBusPositionByRouteIdDTO.getResult() == 0) {
            return getBusPositionByRouteIdDTO.getItems();
        }
        return null;
    }

}
