package cn.whatisee.mapper;

import cn.whatisee.mapper.exception.NotFindException;
import cn.whatisee.model.User;

/**
 * Created by ppc on 2016/3/8.
 */
public interface UserMapper {

    User findUserByPhone(String phone);
    User findUserByEmail(String email);
    User findUserById(String userId);
    User CreateUser(User user);
    boolean IsExistUserByPhone(String phone);
    boolean isExistUserByEmail(String email);
    boolean ExchangePassword(String userId,String password) throws NotFindException;
}
