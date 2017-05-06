package cn.xuezhijian2.core.httpClient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.httpClient
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午3:15
 * Description  : http请求连接池
 */

@Component(value="HttpClientConnectionPooling")
public class HttpClientConnectionPooling {

    // 连接池管理器
    private PoolingHttpClientConnectionManager cm;

    // 链接创建器
    private HttpClientBuilder builder;

    /**
     * 初始化方法
     */
    @PostConstruct
    private void createHttpClientBuilder() {
        // 新建连接管理器
        cm = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        cm.setMaxTotal(300);
        // 设置默认每个路由最大连接数
        cm.setDefaultMaxPerRoute(200);
        // 检测链接
        cm.setValidateAfterInactivity(2000);

        // 创建request配置
        RequestConfig.Builder requestBuilder = RequestConfig.custom();

        // 设置超时
        requestBuilder = requestBuilder.setConnectTimeout(2000);
        requestBuilder = requestBuilder.setSocketTimeout(10000);
        // 设置链接超时
        requestBuilder = requestBuilder.setConnectionRequestTimeout(5000);

        builder = HttpClientBuilder.create();
        // 设置request配置
        builder.setDefaultRequestConfig(requestBuilder.build());
        // 设置连接池配置
        builder.setConnectionManager(cm);
    }

    /**
     * 销毁bean
     */
    @PreDestroy
    private void Shutdown() {
        cm.shutdown();
    }

    /**
     * 定时任务,每隔5秒清除池中残余的链接
     */
    @Scheduled(fixedRate = 5000)
    private void CheckConnection() {
        // Close expired connections
        cm.closeExpiredConnections();
        // Optionally, close connections
        // that have been idle longer than 30 sec
        cm.closeIdleConnections(30, TimeUnit.SECONDS);
    }

    /**
     * 获取链接CloseableHttpClient
     * @return
     */
    public CloseableHttpClient getClient() {
        if (builder == null) {
            // 执行创建方法
            createHttpClientBuilder();
        }
        return builder.build();
    }

}
