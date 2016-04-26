package cn.whatisee.web.controller;

import cn.whatisee.model.Daily;
import cn.whatisee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ppc on 2016/3/7.
 */
@Controller
@RequestMapping(value = "/daily")
public class DailyController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/daily/")
    public String dailyIndex(){
        return  "/daily/index.jsp";
    }
    @RequestMapping(value = "/daily/addDaily",method = RequestMethod.GET)
    public String addDaily(){
        return "/daily/Add.jsp";
    }
    @RequestMapping(value = "/daily/Post",method = RequestMethod.POST)
    public String addDaily(@Validated Daily daily){
       // dailyService.Add(daily);
        return  null;
    }
}
