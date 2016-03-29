package cn.whatisee.cache.redis;

import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.ICacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ppc on 2016/3/29.
 */
public abstract class AbstractRedisClient<T> implements ICacheClient<T> {

    @Autowired
    protected StringRedisTemplate client;

    @Override
    public <T> T get(String key) throws CacheException {
        return null;
    }

    @Override
    public <T> T getRange(String key, int start, int end) throws CacheException {
        return null;
    }

    @Override
    public Set<String> keys(String key) throws CacheException {
        return null;
    }

    @Override
    public <T> Map<String, T> getMulti(List<String> keys) throws CacheException {
        return null;
    }

    @Override
    public <T> void set(String key, T value) throws CacheException {

    }

    @Override
    public <T> void set(String key, T value, int expire) throws CacheException {

    }

    @Override
    public void delete(String key) throws CacheException {

    }

    @Override
    public void delete(Collection<String> keys) throws CacheException {

    }

    @Override
    public <T> void replace(String key, T value) throws CacheException {

    }

    @Override
    public <T> void replace(String key, T value, int expire) throws CacheException {

    }
}
