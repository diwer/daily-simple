package cn.whatisee.controller;

import cn.whatisee.model.Daily;
import cn.whatisee.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ppc on 2016/3/7.
 */
@Controller
public class DailyController {

    @Autowired
    private UserService userService;

    @RequestMapping("/daily/")
    public String dailyIndex(){
        return  "/daily/Index.jsp";
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
