package cn.whatisee.mapper.test;

import cn.whatisee.mapper.DailyMapper;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.mapper.exception.NotFindException;
import cn.whatisee.model.Daily;
import cn.whatisee.model.DailyStatus;
import cn.whatisee.model.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by ppc on 2016/3/17.
 */
@ContextConfiguration("/spring-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DailyMapperTest {

    @Autowired
    private DailyMapper dailyMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestDailyCreate() {
        User user = userMapper.findUserByPhone("13041110273");
        Daily daily = new Daily();
        daily.setContent("这是一个内容");
        daily.setLocation("北京");
        daily.setWeather("晴");
        daily.setReportCount(0);
        daily.setUserId(user.getId());
        daily.setDailystatus(DailyStatus.Nomal.getIndex());
        dailyMapper.createDaily(daily);
        Assert.assertNotNull(daily.getId());
        Daily sdaily = dailyMapper.findDailyById(daily.getId());
        Assert.assertNotNull(sdaily);
        Assert.assertEquals(daily.getContent(), sdaily.getContent());
    }

    @Test
    public void TestDailyUpdate() {
        User user = userMapper.findUserByPhone("13041110273");
        List<Daily> dailyList = dailyMapper.findDailiesByUserId(user.getId());
        Assert.assertNotNull(dailyList);
        if (dailyList.size() > 0) {
            Daily daily = dailyList.get(0);
            daily.setContent("我修改了内容");
            try {

                dailyMapper.UpdateDaily(daily);
            } catch (NotFindException e) {

                e.printStackTrace();
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            }
            Daily ndaily =dailyMapper.findDailyById(daily.getId());
            Assert.assertNotNull(ndaily);
            Assert.assertEquals("我修改了内容",ndaily.getContent());

        }

    }
}
