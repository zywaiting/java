package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName RouteMessageDTO
 * @Author zy
 * @Date 2020/2/25 16:13
 * @Description RouteMessageDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteMessageDTO implements Serializable {

    /**
     * 线路站首id
     */
    private Long routeId;

    /**
     * 线路站末id
     */
    private Long oppositeId;

    /**
     * 线路名称
     */
    private String routeName;

    /**
     * 全名id
     */
    private Long amapId;
    /**
     * 全名
     */
    private String amapName;

    /**
     * 城市代码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 未知
     */
    private Integer direction;

    /**
     * 起始站
     */
    private String origin;

    /**
     * 终点站
     */
    private String terminal;

    /**
     * 票价
     */
    private Integer airPrice;

    /**
     * 始发时间
     */
    private String firstBus;

    /**
     * 末班时间
     */
    private String lastBus;

    /**
     * 未知
     */
    private Integer stationCnt;

    /**
     * 未知
     */
    private Double distance;

    /**
     * 未知
     */
    private Boolean regular;

    /**
     * 是否带gps
     */
    private Boolean hasGps;

    /**
     * 未知
     */
    private Boolean favorite;

    /**
     * 未知
     */
    private Long routeNo;

    /**
     * 未知
     */
    private Integer subsidiary;
}
