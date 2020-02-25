package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName NextBusesDTO
 * @Author zy
 * @Date 2020/2/25 17:15
 * @Description NextBusesDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NextBusesDTO implements Serializable {

    private Long routeId;

    private Integer seqNo;

    private Long stopId;

    private Long amapRouteId;

    private String stopName;

    private List<BusesDTO> buses;
}
