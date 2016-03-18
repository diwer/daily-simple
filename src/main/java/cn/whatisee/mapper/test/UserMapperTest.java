package cn.whatisee.mapper.test;

import cn.whatisee.mapper.impl.UserMapperImpl;
import cn.whatisee.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ppc on 2016/3/17.
 */
@ContextConfiguration("classpath:/spring-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapperImpl userMapper;

    @Test
    public void TestCreateUser() {

//        Daily daily=new Daily();
//        daily.setWeather("晴");
//        daily.setLocation("本地");
//        daily.setContent("这是个日子");
        User user = new User();
        user.setEmail("diwers@163.com");
        user.setPhone("13041110273");
        user.setNikcName("diwer");
        user.setPassword("123qaz");
        User ouser = userMapper.findUserByEmail("diwers@163.com");
        Assert.assertNotNull(ouser);
        if (ouser != null) {


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
