package cn.whatisee.service.impl;

import cn.whatisee.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mingsheng on 16/4/29.
 */
public class BaseServiceImpl {

    @Autowired
    protected ISessionService sessionService;
}
