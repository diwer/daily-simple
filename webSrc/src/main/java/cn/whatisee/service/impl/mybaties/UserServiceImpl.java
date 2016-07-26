package cn.whatisee.service.impl.mybaties;

import cn.whatisee.mapper.UserMapper;
import cn.whatisee.model.User;
import cn.whatisee.model.UserExample;
import cn.whatisee.service.IUserService;
import cn.whatisee.service.exception.EmailHaveUsedException;
import cn.whatisee.service.exception.PhoneHaveUsedException;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by ming on 16/7/25.
 */
@Service
public class  UserServiceImpl implements IUserService {
    private UserMapper userMapper;
    @Override
    public User RegistryUserByPhone(String phone, String password, String nickName) throws PhoneHaveUsedException {

        return null;
    }

    @Override
    public User RegistryUserByEmail(String email, String password, String nickName) throws EmailHaveUsedException {
        return null;
    }

    @Override
    public boolean exchangePasswordByOldPassword(String userId, String oldPassword, String newPassword) throws Exception {
        return false;
    }

    @Override
    public User getUserByPhone(String phone) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
