package cn.whatisee.mapper.test;

import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.mapper.impl.UserMapperImpl;
import cn.whatisee.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ppc on 2016/3/17.
 */
public class UserMapperTest extends BaseTestCase {

    @Autowired
    private UserMapperImpl userMapper;

    @Test
    public void TestCreateUser() {

        User user = new User();
        user.setEmail("diwers@163.com");
        user.setPhone("13041110273");
        user.setNickName("diwer");
        user.setPassword("123qaz");
        User ouser = userMapper.findUserByEmail("diwers@163.com");
        Assert.assertNotNull(ouser);
        if (null == ouser) {

            userMapper.CreateUser(user);
            Assert.assertNotEquals(user.getId(), null);
            Assert.assertNotEquals(user.getId(), "");
        }
    }

    @Test
    public void TestUpdateUserPassword() {
        User user = userMapper.findUserByPhone("13041110273");
        Assert.assertNotNull(user);
        user.setPassword("123456");
        userMapper.ExchangePassword(user.getId(), user.getPassword());
        User nuser = userMapper.findUserById(user.getId());
        Assert.assertNotNull(user);
        Assert.assertNotEquals(user.getPassword(), nuser.getPassword());
    }

}
