package cn.whatisee.mapper.test;

import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.mapper.DailyMapper;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.mapper.exception.NotFindException;
import cn.whatisee.model.Daily;
import cn.whatisee.model.DailyStatus;
import cn.whatisee.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by ppc on 2016/3/17.
 */

public class DailyMapperTest extends BaseTestCase {

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
        daily.setDailystatus(DailyStatus.Normal.getIndex());
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
