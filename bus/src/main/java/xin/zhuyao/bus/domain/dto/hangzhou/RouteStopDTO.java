package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RouteStopDTO
 * @Author zy
 * @Date 2020/2/25 17:03
 * @Description RouteStopDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopDTO implements Serializable {

    private Long staId;
    private Long routeId;
    private Integer seqNo;
    private Integer direction;
    private Long stopId;
    private String stopName;
    private String amapId;
    private String cityCode;
    private String cityName;
    private Double lng;
    private Double lat;
    private Boolean metroTrans;
    private Boolean favorite;
    private String metroLines;
}
