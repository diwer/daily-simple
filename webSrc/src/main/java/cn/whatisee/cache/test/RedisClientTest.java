package cn.whatisee.cache.test;

import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.ICacheClient;
import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.core.util.MD5Util;
import cn.whatisee.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by ppc on 2016/3/29.
 */

public class RedisClientTest extends BaseTestCase {
    @Autowired
    private ICacheClient<User> client;
    private User user = new User();
    private String id = UUID.randomUUID().toString();


    private void initUser() {
        client.setType(User.class);
        user.setId(id);
        user.setCreateTime(new Date());
        user.setEmail("diwers@163.com");
        user.setPhone("13041110273");
        user.setNickName("ming");
        user.setPassword(MD5Util.parseStrToMd5U16("123456"));
        user.setLastLoginTime(new Date());
    }

    @Test
    public void testSet() throws CacheException {
        initUser();
        client.set(user.getId(), user);

    }

    @Test
    public void testSet1() throws CacheException {
        initUser();
        client.set(user.getId(), user, 1000 * 30);
    }

    @Test
    public void testGet() throws CacheException {
        initUser();
        client.set(user.getId(),user);
        User cacheUser = client.get(user.getId());
        Assert.assertNotNull(cacheUser);
        Assert.assertEquals(cacheUser.getId(), user.getId());
        Assert.assertEquals(cacheUser.getEmail(), user.getEmail());

    }

    @Test
    public void testGetRange() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testKeys() throws CacheException {
        initUser();
        client.set(user.getId(),user);
        Collection<String> keys = client.keys(id.substring(0, 5));
        Assert.assertTrue(keys.contains(id));
    }

    @Test
    public void testGetMulti() throws CacheException {
        initUser();
        client.set(user.getId(),user);
        String nId = UUID.randomUUID().toString();
        user.setId(nId);
        user.setEmail("msheng@outlook.com");
        client.set(nId, user);
        List<String> keys = new ArrayList<>();
        keys.add(nId);
        keys.add(id);
        Map<String, User> map = client.getMulti(keys);
        Assert.assertNotNull(map);
        Assert.assertTrue(map.containsKey(nId));
        Assert.assertTrue(map.containsKey(id));
        User cUser = map.get(nId);
        Assert.assertEquals(user.getEmail(), cUser.getEmail());

    }


    public void testDelete() throws CacheException {

        client.delete(id);
        User cacheUser = client.get(user.getId());
        Assert.assertNull(cacheUser);

    }

    public void testDelete1() throws CacheException {
        testSet();
        String nId = UUID.randomUUID().toString();
        user.setId(nId);
        user.setEmail("msheng@outlook.com");
        client.set(nId, user);
        List<String> keys = new ArrayList<>();
        keys.add(nId);
        keys.add(id);
        client.delete(keys);
        Map<String, User> map = client.getMulti(keys);
        Assert.assertNull(map);
        Assert.assertFalse(map.containsKey(nId));
        Assert.assertFalse(map.containsKey(id));
    }
    @Test
    public  void deleteAll() throws CacheException {
        Collection<String> keys=client.keys("");
        client.delete(keys);
    }

}
