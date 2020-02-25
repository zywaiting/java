package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName StopsDTO
 * @Author zy
 * @Date 2020/2/25 17:17
 * @Description StopsDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopsDTO implements Serializable {

    private RouteStopDTO routeStop;

    private List<BusesDTO> buses;

    private List<TrackDTO> track;
}
