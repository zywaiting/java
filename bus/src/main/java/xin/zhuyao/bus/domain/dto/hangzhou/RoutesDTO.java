package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RoutesDTO
 * @Author zy
 * @Date 2020/2/25 17:19
 * @Description RoutesDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutesDTO implements Serializable {

    private RouteMessageDTO route;

    private NextBusesDTO nextBuses;

    private List<StopsDTO> stops;
}
