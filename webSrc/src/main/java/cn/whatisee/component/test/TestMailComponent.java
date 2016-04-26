package cn.whatisee.component.test;

import cn.whatisee.component.IMailComponent;
import cn.whatisee.config.MailConfig;
import cn.whatisee.core.util.BaseTestCase;
import cn.whatisee.core.util.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mingsheng on 16/4/8.
 */
public class TestMailComponent extends BaseTestCase{

    @Autowired
    private IMailComponent mailComponent;

    @Test
    public void  TestSenMail(){


        Map<String,Object> map=new HashMap<>();
        map.put("username","mings");
        map.put("confirmCode", UUIDUtil.getUUID());

        mailComponent.sendMimeMail(map,"diwers@163.com",MailConfig.Validate);
        //mailComponent.SendSimpleMail(map,"diwers@163.com","你的日记发送来的邮件",MailConfig.Validate);
        Assert.assertTrue(true);
    }
}
