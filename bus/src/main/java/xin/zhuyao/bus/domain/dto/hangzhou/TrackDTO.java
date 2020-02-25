package xin.zhuyao.bus.domain.dto.hangzhou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName TrackDTO
 * @Author zy
 * @Date 2020/2/25 17:08
 * @Description TrackDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO implements Serializable {

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;
}
