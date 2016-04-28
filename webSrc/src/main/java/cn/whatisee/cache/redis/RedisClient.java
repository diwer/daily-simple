package cn.whatisee.cache.redis;

import cn.whatisee.cache.CacheException;
import cn.whatisee.core.util.CollectionUtil;
import cn.whatisee.core.util.StringUtils;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by ppc on 2016/3/28.
 */
@Component
public class RedisClient<T> extends AbstractRedisClient<T> {


    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.setConnectionFactory(jedisConnectionFactory);
    }
}
