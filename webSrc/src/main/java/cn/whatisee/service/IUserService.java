package cn.whatisee.service;

import cn.whatisee.model.User;
import cn.whatisee.service.exception.EmailHaveUsedException;
import cn.whatisee.service.exception.PhoneHaveUsedException;

/**
 * Created by ppc on 2016/3/21.
 */
public interface IUserService {

    User RegistryUserByPhone(String phone, String password) throws PhoneHaveUsedException;

    User RegistryUserByEmail(String email, String password) throws EmailHaveUsedException;

    boolean ExChangePasswordByOldPassword(String userId, String oldPassword, String newPassword) throws Exception;
}
