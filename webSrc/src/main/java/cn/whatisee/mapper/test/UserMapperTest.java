package cn.whatisee.mapper.test;

import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.model.User;
import cn.whatisee.model.UserExample;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ppc on 2016/3/17.
 */
public class UserMapperTest extends BaseTestCase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestCreateUser() {

        User user = new User();
        user.setEmail("diwers@163.com");
        user.setPhone("13041110273");
        user.setNickname("diwer");
        user.setPassword("123qaz");
        UserExample example=new UserExample();
        example.createCriteria().andEmailEqualTo("diwers@163.com");
        User ouser = userMapper.selectByExample(example);
        Assert.assertNotNull(ouser);
        if (null == ouser) {

            userMapper.insert(user);
            Assert.assertNotEquals(user.getId(), null);
            Assert.assertNotEquals(user.getId(), "");
        }
    }

    @Test
    public void TestUpdateUserPassword() {
        UserExample example=new UserExample();
        example.createCriteria().andPhoneEqualTo("13041110273");
        User user = userMapper.selectByExample(example);
        Assert.assertNotNull(user);
        user.setPassword("123456");
        example=new UserExample();
        example.createCriteri
        userMapper.updateByPrimaryKey(user);
        User nuser = userMapper.selectByPrimaryKey(user.getId());
        Assert.assertNotNull(user);
        Assert.assertNotEquals(user.getPassword(), nuser.getPassword());
    }

}
