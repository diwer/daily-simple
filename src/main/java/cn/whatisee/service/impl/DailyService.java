package cn.whatisee.service.impl;

import cn.whatisee.mapper.DailyMapper;
import cn.whatisee.service.IBaseService;
import cn.whatisee.service.IDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by ppc on 2016/3/8.
 */
@Component
public class DailyService implements IDailyService,IBaseService {

    @Autowired
     private DailyMapper dailyMapper;

}
