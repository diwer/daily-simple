package cn.whatisee.service;

import cn.whatisee.model.User;
import cn.whatisee.service.exception.NullSessionIdException;

/**
 * Created by mingsheng on 16/4/28.
 */
public interface ISessionService {

    User getUser(String sessionId) throws NullSessionIdException;

    void setUser(User user) throws NullSessionIdException;

    void setUser(User user, int expire) throws NullSessionIdException;

    void setString(String sessionId, String value) throws NullSessionIdException;

    void setString(String sessionId, String value, int expire) throws NullSessionIdException;

    String getString(String sessionId) throws NullSessionIdException;

}
