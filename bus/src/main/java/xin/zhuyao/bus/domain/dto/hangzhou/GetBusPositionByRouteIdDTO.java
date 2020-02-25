package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName GetBusPositionByRouteIdDTO
 * @Author zy
 * @Date 2020/2/25 17:23
 * @Description GetBusPositionByRouteIdDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBusPositionByRouteIdDTO implements Serializable {

    /**
     * 返回状态码
     */
    private Integer result;

    /**
     * 返回状态信息
     */
    private String message;

    /**
     * 返回总条数
     */
    private Integer total;

    /**
     * 返回页数
     */
    private Integer pageCount;

    /**
     * 返回结果
     */
    private List<BusPositionDTO> items;
}
