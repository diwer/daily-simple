package cn.whatisee.service.impl;

import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.redis.RedisClient;
import cn.whatisee.core.util.StringUtils;
import cn.whatisee.model.User;
import cn.whatisee.service.ISessionService;
import cn.whatisee.service.exception.NullSessionIdException;

import java.lang.String;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mingsheng on 16/4/28.
 */
@Service
public class SessionServiceImpl implements ISessionService {

    private RedisClient<User> userClient;
    private RedisClient<String> stringClient;

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public void setUserClient(RedisClient<User> userClient) {
        this.userClient = userClient;
        this.userClient.setType(User.class);
    }

    @Autowired
    public void setStringClient(RedisClient<String> stringClient) {
        this.stringClient = stringClient;
        this.stringClient.setType(String.class);
    }


    @Override
    public User getUser(String sessionId) throws NullSessionIdException {
        try {
            if (StringUtils.isNotEmpty(sessionId)) {
                return (User) userClient.get(sessionId);
            } else {
                throw new NullSessionIdException(sessionId + "sessionId is null exception");
            }
        } catch (CacheException e) {
            logger.error(e.getMessage());
            return null;

        }

    }

    @Override
    public void setUser(User user) throws NullSessionIdException {

        setUser(user, 0);
    }

    @Override
    public void setUser(User user, int expire) throws NullSessionIdException {
        try {
            if (user != null && user.getId() != null) {
                userClient.set(user.getId(), user, expire);
            } else {
                throw new NullSessionIdException("setUsr method user is null or user.getId() is null");
            }
        } catch (CacheException e) {
            logger.error(e.getMessage());

        }
    }

    @Override
    public void setString(String sessionId, String value) throws NullSessionIdException {
        setString(sessionId, value, 0);
    }

    @Override
    public void setString(String sessionId, String value, int expire) throws NullSessionIdException {
        try {

            if (StringUtils.isNotEmpty(sessionId)) {
                stringClient.set(sessionId, value, expire);
            } else {
                throw new NullSessionIdException("setUsr method user is null or user.getId() is null");
            }
        } catch (CacheException e) {
            logger.error(e.getMessage());

        }
    }

    @Override
    public String getString(String sessionId) throws NullSessionIdException {
        try {
            if (StringUtils.isNotEmpty(sessionId)) {
                return (String) stringClient.get(sessionId);
            } else {
                throw new NullSessionIdException(sessionId + "sessionId is null exception");
            }
        } catch (CacheException e) {
            logger.error(e.getMessage());
            return null;

        }
    }


}
