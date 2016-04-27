package cn.whatisee.service.impl;

import cn.whatisee.core.util.StringUtils;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.model.User;
import cn.whatisee.service.IBaseService;
import cn.whatisee.service.IUserService;
import cn.whatisee.service.exception.EmailHaveUsedException;
import cn.whatisee.service.exception.NotFindException;
import cn.whatisee.service.exception.PhoneHaveUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by ppc on 2016/3/8.
 */
@Service
public class UserServiceImpl implements IUserService, IBaseService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User RegistryUserByEmail(String email, String password,String nickName) throws EmailHaveUsedException {
        if (StringUtils.isNotEmpty(email)) {
            if (userMapper.isExistUserByEmail(email)) {
                throw new EmailHaveUsedException(email);
            }
        }
        return RegisterUser(email, null, password,nickName);
    }


    @Override
    public User RegistryUserByPhone(String phone, String password,String nickName) throws PhoneHaveUsedException {
        if (StringUtils.isNotEmpty(phone)) {
            if (userMapper.isExistUserByEmail(phone)) {
                throw new PhoneHaveUsedException(phone);
            }
        }
        return RegisterUser(null, phone, password,nickName);
    }

    @Override
    public boolean exchangePasswordByOldPassword(String userId, String oldPassword, String newPassword) throws Exception {

        User user = userMapper.findUserById(userId);
        if (user == null) {
            throw new NotFindException(userId, this.getClass().getName());
        }
        if (!Objects.equals(user.getPassword(), oldPassword)) {
            throw new Exception("密码错误");
        }
        return userMapper.ExchangePassword(userId, newPassword);

    }

    @Override
    public User getUserByPhone(String phone) {
        return  userMapper.findUserByPhone(phone);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    private User RegisterUser(String email, String phone, String password,String nickName) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setNickName(nickName);
        return userMapper.CreateUser(user);
    }

}
