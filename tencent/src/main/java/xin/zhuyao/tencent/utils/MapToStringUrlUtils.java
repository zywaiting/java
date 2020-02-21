package xin.zhuyao.tencent.utils;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapToStringUrlUtils
 * @Author zy
 * @Date 2020/2/21 17:36
 * @Description MapToStringUrlUtils
 * @Version 1.0
 */
public class MapToStringUrlUtils {

    public static
    String getParams(Map map) {
        StringBuffer params = new StringBuffer();
        Set set = map.keySet();
        for (Object o : set) {
            params.append("&");
            //key
            params.append(o.toString());
            params.append("=");
            //value
            params.append(map.get(o).toString());
        }
        return "?" + params.toString().substring(1);
    }
}
