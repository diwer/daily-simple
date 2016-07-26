package cn.whatisee.web.controller;


import cn.whatisee.service.impl.jdbc.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ppc on 2016/2/29.
 */
@Controller
@RequestMapping(value = "hello")
public class HelloController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return  userService.getUserByPhone("13041110273").getPhone();
        //return "helloWorld";
    }

    @RequestMapping(value = "/json", consumes = "application/json")
    @ResponseBody
    public String helloJson() {

        return "{test:json}";
    }


}

