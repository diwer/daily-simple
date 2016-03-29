package cn.whatisee.cache;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ppc on 2016/3/22.
 */
public interface ICacheClient<T> {
    <T> T get(String key) throws CacheException;

    <T> T getRange(String key, int start, int end) throws CacheException;

    Set<String> keys(String key) throws CacheException;

    <T> Map<String, T> getMulti(List<String> keys) throws CacheException;

    <T> void set(String key, T value) throws CacheException;

    <T> void set(String key, T value, int expire) throws CacheException;

    void delete(String key) throws CacheException;

    void delete(Collection<String> keys) throws CacheException;

    <T> void replace(String key, T value) throws CacheException;

    <T> void replace(String key, T value, int expire) throws CacheException;

    void setType(Class<T> type);
}
