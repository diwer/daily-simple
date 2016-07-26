package cn.whatisee.service.impl.jdbc;

import cn.whatisee.core.util.MD5Util;
import cn.whatisee.core.util.StringUtils;
import cn.whatisee.core.util.UUIDUtil;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.model.User;
import cn.whatisee.model.UserExample;
import cn.whatisee.service.IUserService;
import cn.whatisee.service.exception.EmailHaveUsedException;
import cn.whatisee.service.exception.HaveUsedException;
import cn.whatisee.service.exception.NotFindException;
import cn.whatisee.service.exception.PhoneHaveUsedException;
import cn.whatisee.service.impl.BaseServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * Created by ppc on 2016/3/8.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserMapper userMapper;

    private UserExample userExample;

    @Override
    public User RegistryUserByEmail(String email, String password, String nickName) throws EmailHaveUsedException {
        if (!StringUtils.isNotEmpty(email) && vailExsitUserbyEmail(email)) {
            throw new EmailHaveUsedException(email);
        }
        return RegisterUser(email, null, password, nickName);
    }


    @Override
    public User RegistryUserByPhone(String phone, String password, String nickName) throws PhoneHaveUsedException {
        if (!StringUtils.isNotEmpty(phone) && vailExsitUserbyPhone(phone)) {
            throw new PhoneHaveUsedException(phone);
        }
        return RegisterUser(null, phone, password, nickName);
    }

    private boolean vailExsitUserbyPhone(String phone) {
        return vailExsitUser(phone, null);
    }

    private boolean vailExsitUserbyEmail(String email) {
        return vailExsitUser(null, email);
    }

    private boolean vailExsitUser(String phone, String email) {
        userExample = new UserExample();
        if (StringUtils.isNotEmpty(phone)) {

            userExample.createCriteria().andPhoneEqualTo(phone);
        } else {
            userExample.createCriteria().andEmailEqualTo(email);
        }
        List<User> users = null;
        try {
            users = userMapper.selectByExample(userExample);
        } catch (Exception ex) {
            logger.error("获取用户信息失败" + ex);
        }
        if (users != null && users.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean exchangePasswordByOldPassword(String userId, String oldPassword, String newPassword) throws Exception {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new NotFindException(userId, this.getClass().getName());
        }
        if (!Objects.equals(user.getPassword(), oldPassword)) {
            throw new Exception("密码错误");
        }
        int result = 0;
        user.setPassword(MD5Util.parseStrToMd5U16(newPassword));
        try {
            result = userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception ex) {
            logger.error("修改密码失败:" + ex);
        }
        return result != 0;

    }

    @Override
    public User getUserByPhone(String phone) {
        userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        List<User> users = null;
        try {
            userMapper.selectByExample(userExample);
        } catch (Exception ex) {
            logger.error("获取用户信息失败:" + ex);
        }
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {

        userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        List<User> users = null;
        try {
            userMapper.selectByExample(userExample);
        } catch (Exception ex) {
            logger.error("获取用户信息失败:" + ex);
        }
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    private User RegisterUser(String email, String phone, String password, String nickName) {

        User user = new User();
        user.setId(UUIDUtil.getUUID());
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setNickname(nickName);
        try {


            int result = userMapper.insert(user);
        } catch (Exception ex) {
            logger.error("创建用户失败:" + ex);
        }
        return user;
    }

}
