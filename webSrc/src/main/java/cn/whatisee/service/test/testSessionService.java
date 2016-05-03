package cn.whatisee.service.test;

import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.service.impl.SessionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mingsheng on 16/4/28.
 */
public class testSessionService extends BaseTestCase {
    @Autowired
    private SessionServiceImpl sessionService;

    @Test
    public void test(){

        Assert.assertTrue(true);
    }
}
