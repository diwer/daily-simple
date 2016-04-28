package cn.whatisee.service;

import cn.whatisee.cache.redis.RedisClient;
import cn.whatisee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by mingsheng on 16/4/28.
 */
@Service
public class SessionService {
    @Autowired
    private RedisClient client;
}
