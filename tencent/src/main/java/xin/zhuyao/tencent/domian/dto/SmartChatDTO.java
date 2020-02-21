package xin.zhuyao.tencent.domian.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @ClassName SmartChatDTO
 * @Author zy
 * @Date 2020/2/21 15:51
 * @Description SmartChatDTO
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SmartChatDTO implements Serializable {

    /**
     * UTF-8编码，非空且长度上限32字节
     */
    String session;
    /**
     * UTF-8编码，非空
     */
    String answer;
}
