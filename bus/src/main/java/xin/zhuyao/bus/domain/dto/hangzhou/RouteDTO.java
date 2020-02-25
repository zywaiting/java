package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RouteDTO
 * @Author zy
 * @Date 2020/2/25 16:11
 * @Description RouteDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 线路信息
     */
    private List<RouteMessageDTO> routes;
}
