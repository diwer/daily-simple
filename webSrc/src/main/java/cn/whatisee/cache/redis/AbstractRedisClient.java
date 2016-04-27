package cn.whatisee.cache.redis;

import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.ICacheClient;
import cn.whatisee.core.util.CollectionUtil;
import cn.whatisee.core.util.StringUtils;
import com.fasterxml.jackson.databind.JavaType;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by ppc on 2016/3/29.
 */

public abstract class AbstractRedisClient extends RedisTemplate<String,Object> implements ICacheClient {


    public AbstractRedisClient(JavaType type){
        Jackson2JsonRedisSerializer<Object> serializer=new Jackson2JsonRedisSerializer<>(type);
        this.setDefaultSerializer(serializer);
    }

    @Autowired
    public void setRedisConnectionFactory(JedisConnectionFactory redisConnectionFactory) {
        this.setConnectionFactory(redisConnectionFactory);

    }


    @Override
    @SuppressWarnings("unchecked")
    public  Object get(String key) throws CacheException {
        try {

            return  this.opsForValue().get(key);

        } catch (Exception exception) {
            throw new CacheException("Error occured while getting Object from cache, key = " + key, exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public  Object getRange(String key, int start, int end) throws CacheException {
        try {

            return  this.opsForValue().get(key, start, end);
        } catch (Exception exception) {
            throw new CacheException("Error occured while getting Object from cache, key = " + key, exception);
        }
    }


    @Override
    public Set<String> keys(String key) {
            return keys(key + "*");


    }

    @Override
    public  Map<String, Object> getMulti(List<String> keys) throws CacheException {
        try {
            if (CollectionUtil.isEmpty(keys))
                return new HashMap<>();
            List listValue = this.opsForValue().multiGet(keys);
            if (listValue == null) {
                return null;
            } else {
                Map<String, Object> values = new HashMap<>();

                for (int i = 0; i < listValue.size(); ++i) {
                    values.put(keys.get(i), listValue.get(i));
                }
                return values;
            }
        } catch (Exception exception) {
            String keyStr = StringUtils.getStringByList(keys);
            throw new CacheException("Error occured while setting Object from cache,key=" + keyStr, exception);
        }
    }


    @Override
    public  void set(String key, Object value){
        this.opsForValue().set(key, value);
    }

    @Override
    public  void set(String key, Object value, int expire) throws CacheException {
        try {

            this.opsForValue().set(key,  value, expire, TimeUnit.SECONDS);

        } catch (Exception exception) {
            throw new CacheException("Error occured while setting Object from cache,key=" + key, exception);
        }
    }


    @Override
    public  void replace(String key, Object value) throws CacheException {

        set(key, value);
    }


    @Override
    public  void replace(String key, Object value, int expire) throws CacheException {
        set(key, value, expire);
    }

    @Override
    public void setObjectype(Class type) {
        throw new NotImplementedException();
    }

}
