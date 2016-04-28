package cn.whatisee.cache;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ppc on 2016/3/22.
 */
public interface ICacheClient<T> {
    Object get(String key) throws CacheException;

    Object getRange(String key, int start, int end) throws CacheException;

    Set<String> getKeys(String key) throws CacheException;

    Map<String, Object> getMulti(List<String> keys) throws CacheException;

    void set(String key, Object value) throws CacheException;

    void set(String key, Object value, int expire) throws CacheException;

    void delete(String key) throws CacheException;

    void delete(Collection<String> keys) throws CacheException;

    void replace(String key, Object value) throws CacheException;

    void replace(String key, Object value, int expire) throws CacheException;

    void setType(Class<T> type);
}
