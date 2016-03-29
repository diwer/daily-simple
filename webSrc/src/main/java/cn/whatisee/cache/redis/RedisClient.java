package cn.whatisee.cache.redis;

import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.ICacheClient;
import cn.whatisee.core.util.CollectionUtil;
import cn.whatisee.core.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by ppc on 2016/3/28.
 */
public class RedisClient<T> implements ICacheClient<T> {
    private StringRedisTemplate client;
    private Class<T> type;
    private ObjectMapper objectMapper;

    @Autowired
    public RedisClient(StringRedisTemplate template, Class<T> type) {
        this.client = template;
        this.type = type;
        objectMapper = new ObjectMapper();

    }

    private Object readValue(String jsonValue, Class<T> type) throws IOException {
        if (StringUtils.isNotEmpty(jsonValue)) {
            return null;
        }
        Reader reader = new StringReader(jsonValue);
        JsonParser parser = objectMapper.getFactory().createParser(reader);
        return objectMapper.readValues(parser, type);
    }

    @Override
    public <T> T get(String key) throws CacheException {
        try {
            String jsonStr = this.client.opsForValue().get(key);
            return (T) readValue(jsonStr, type);

        } catch (Exception exception) {
            throw new CacheException("Error occured while getting T from cache, key = " + key, exception);
        }
    }

    @Override
    public <T> T getRange(String key, int start, int end) throws CacheException {
        try {
            return (T) readValue(this.client.opsForValue().get(key, start, end), type);
        } catch (Exception exception) {
            throw new CacheException("Error occured while getting T from cache, key = " + key, exception);
        }
    }


    @Override
    public Collection<String> keys(String key) throws CacheException {
        try {
            return client.keys(key);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
            throw new CacheException("Error occured while getting T from cache, key = " + key, exception);
        }

    }

    @Override
    public <T> Map<String, T> getMulti(Collection<String> keys) throws CacheException {
        try {
            if (CollectionUtil.isEmpty(keys))
                return new HashMap<>();
            List listKey = Arrays.asList(keys);
            List listValue = this.client.opsForValue().multiGet(keys);
            if (listValue == null) {
                return null;
            } else {
                Map<String, T> values = new HashMap<>();

                for (int i = 0; i < listValue.size(); ++i) {
                    values.put((String) listKey.get(i), (T)readValue((String) listValue.get(i), type));
                }
                return values;
            }
        } catch (Exception exception) {
            String keyStr = StringUtils.getStringByList(keys);
            throw new CacheException("Error occured while setting T from cache,key=" + keyStr, exception);
        }
    }


    @Override
    public <T> void set(String key, T value) throws CacheException {
        try {
            String jsonInString = objectMapper.writeValueAsString(value);
            this.client.opsForValue().set(key, jsonInString);

        } catch (Exception exception) {
            throw new CacheException("Error occured while setting T from cache,key=" + key, exception);
        }
    }

    @Override
    public <T> void set(String key, T value, int expire) throws CacheException {
        try {
            String jsonInString = objectMapper.writeValueAsString(value);
            this.client.opsForValue().set(key, jsonInString, expire, TimeUnit.SECONDS);

        } catch (Exception exception) {
            throw new CacheException("Error occured while setting T from cache,key=" + key, exception);
        }
    }


    @Override
    public void delete(String key) throws CacheException {
        try {

            this.client.delete(key);

        } catch (Exception exception) {
            throw new CacheException("Error occured while setting T from cache,key=" + key, exception);
        }
    }

    @Override
    public void delete(Collection<String> keys) throws CacheException {
        try {

            this.client.delete(keys);

        } catch (Exception exception) {
            String keyStr = StringUtils.getStringByList(keys);
            throw new CacheException("Error occured while setting T from cache,key=" + keyStr, exception);
        }
    }

    @Override
    public <T> void replace(String key, T value) throws CacheException {

        set(key, value);
    }


    @Override
    public <T> void replace(String key, T value, int expire) throws CacheException {
        set(key, value, expire);
    }


}
