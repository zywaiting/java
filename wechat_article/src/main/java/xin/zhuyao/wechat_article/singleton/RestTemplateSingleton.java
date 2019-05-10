package xin.zhuyao.wechat_article.singleton;

import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class RestTemplateSingleton {

    private volatile static RestTemplate restTemplate;

    //私有构造
    private RestTemplateSingleton(){

    }

    public static RestTemplate getRestTemplate(){
        if (restTemplate == null) {
            synchronized (RestTemplateSingleton.class) {
                if (restTemplate == null) {
                    restTemplate = new RestTemplate();
                }
            }
        }
        return restTemplate;
    }
}
