package xin.zhuyao.tencent;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * @ClassName TencentApplication
 * @Author zy
 * @Date 2020/2/21 15:01
 * @Description TencentApplication
 * @Version 1.0
 */
@SpringBootApplication
public class TencentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TencentApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        //java访问https资源时,忽略证书信任问题
        TrustStrategy trustStrategy = (X509Certificate[] var1, String var2) -> true;
        //ssl
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null,trustStrategy).build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
        //httpClient添加ssl
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setHttpClient(closeableHttpClient);
        return new RestTemplate(httpRequestFactory);
    }
}
