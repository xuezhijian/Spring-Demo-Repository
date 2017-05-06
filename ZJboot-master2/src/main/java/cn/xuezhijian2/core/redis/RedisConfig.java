package cn.xuezhijian2.core.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.redis
 * User         : zj
 * Date         : 17/4/15
 * Time         : 下午3:23
 * Description  :
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator biliKeyGenerator(){
        return new KeyGenerator() {

            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };

    }

    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
