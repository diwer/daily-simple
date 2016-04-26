package cn.whatisee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mingsheng on 16/4/26.
 */
@Controller

public class IndexController extends BaseController {

    @RequestMapping(value = "/")
    public String Index(){
        return "/index/index";
    }

}
