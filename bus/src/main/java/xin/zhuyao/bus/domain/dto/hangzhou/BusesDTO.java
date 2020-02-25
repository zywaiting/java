package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName BusesDTO
 * @Author zy
 * @Date 2020/2/25 17:10
 * @Description BusesDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusesDTO implements Serializable {

    /**
     * "busId":1001017255,
     *                                     "busNo":"1-7662",
     *                                     "lng":120.13670851,
     *                                     "lat":30.27114018,
     *                                     "angle":165,
     *                                     "passedSeqNo":12,
     *                                     "nextSeqNo":13,
     *                                     "nextDistance":164,
     *                                     "isArrive":false,
     *                                     "lastBus":false,
     *                                     "targetSeconds":36,
     *                                     "sign":false,
     *                                     "type":0
     */

    /**
     * "busId":1001017398,
     *                                 "busNo":"1-7482",
     *                                 "lng":120.16881235,
     *                                 "lat":30.26490208,
     *                                 "angle":158,
     *                                 "passedSeqNo":20,
     *                                 "nextSeqNo":21,
     *                                 "nextStation":"杭州高级中学",
     *                                 "isArrive":false,
     *                                 "lastBus":false,
     *                                 "targetDistance":248,
     *                                 "targetSeconds":72,
     *                                 "targetStopCount":1,
     *                                 "sign":false,
     *                                 "type":0
     */

    private Long busId;

    private String busNo;

    private Double lng;

    private Double lat;

    private Integer angle;

    private Integer passedSeqNo;

    private Integer nextSeqNo;

    private String nextStation;

    private Boolean isArrive;

    private Boolean lastBus;

    private Integer targetDistance;

    private Integer targetSeconds;

    private Integer targetStopCount;

    private Boolean sign;

    private Integer type;

}
