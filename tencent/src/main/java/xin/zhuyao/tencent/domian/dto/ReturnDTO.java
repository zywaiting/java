package xin.zhuyao.tencent.domian.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @Author: zy
 * @Date: 2019/3/7 12:54
 * @Version 1.0
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReturnDTO implements Serializable {

    /**
     * {
     *   "ret": 0,
     *   "msg": "ok",
     *   "data": {
     *       "session": "10000",
     *       "answer": "我叫小豪豪~"
     *   }
     * }
     */
    /**
     * 返回码； 0表示成功，非0表示出错
     */
    Integer ret;

    /**
     * 返回信息；ret非0时表示出错时错误原因
     */
    String msg;

    /**
     * 返回数据；ret为0时有意义
     */
    SmartChatDTO data;



}
