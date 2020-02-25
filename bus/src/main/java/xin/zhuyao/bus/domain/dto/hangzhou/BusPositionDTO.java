package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName BusPositionDTO
 * @Author zy
 * @Date 2020/2/25 17:21
 * @Description BusPositionDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusPositionDTO implements Serializable {

    private String routeName;

    private List<RoutesDTO> routes;
}
