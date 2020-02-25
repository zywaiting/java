package xin.zhuyao.test.test;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName BaiduApiTest
 * @Author zy
 * @Date 2020/2/24 9:52
 * @Description BaiduApiTest
 * @Version 1.0
 */
public class BaiduApiTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "18563545";
    public static final String API_KEY = "kr8TzTMGdSNGCsGkRpWGhCT6";
    public static final String SECRET_KEY = "a2VGTIlfVm2X3vGPeFUih7dzGzuI1HC6";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");

        // 调用接口
        String path = "D:\\test.jpg";
        JSONObject res = client.advancedGeneral(path, options);
        JSONArray result = (JSONArray)res.get("result");
        Object o = result.get(0);
        System.out.println(res.toString(2));

    }
}
