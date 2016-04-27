package cn.whatisee.web.controller;

import cn.whatisee.cache.ICacheClient;
import cn.whatisee.cache.redis.RedisClient;
import cn.whatisee.model.User;
import cn.whatisee.service.IUserService;
import cn.whatisee.service.exception.EmailHaveUsedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by mingsheng on 16/4/25.
 */
@Controller
@RequestMapping(value = "/sso")
public class SSOController {

    private Logger logger = Logger.getLogger(this.getClass());

    private ICacheClient<User> userSession=new RedisClient<>();

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage(HttpServletRequest request, ModelAndView mv) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        List<String> errorList = null;
        if (map != null) {
            @SuppressWarnings("unchecked")
            List<String> readList = (List<String>) map.get("errorList");
            errorList = readList;
        }
        if (errorList == null) errorList = new ArrayList<>();
        mv.addObject("errors", errorList);
        mv.setViewName("/sso/register");
        return mv;
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView registerByEmail(ModelAndView mv, @ModelAttribute User user, RedirectAttributes attr) {
        List<String> errorlist = new ArrayList<>();
        User nuser = null;
        try {
            nuser = userService.RegistryUserByEmail(user.getEmail(), user.getPassword(), user.getNickName());
        } catch (EmailHaveUsedException e) {

            errorlist.add("邮箱已被注册,请更换邮箱");
            attr.addFlashAttribute("errorList", errorlist);
            return new ModelAndView("redirect:/sso/register.html");
        }
//        mv.addObject("blogTitle", "你好 Template Demo using Spring");
//        mv.addObject("message", "Getting started with Freemarker.<br/>Find a Freemarker template demo using Spring.");
//        mv.addObject("references", url.getUrlList());

        attr.addFlashAttribute("user", nuser);
        mv.setViewName("redirect:/sso/registerSuccess");

        return mv;
    }

    @RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
    public ModelAndView registerSuccess(HttpServletRequest request, RedirectAttributes attr, ModelAndView mv) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        try {

            User user = (User) map.get("user");


            mv.addObject("user", user);
            mv.setViewName("/sso/registerSuccess");

        } catch (Exception ex) {
//            System.out.print("注册成功页面,无User传入");
            logger.info("注册成功页面,无User传入");
            throw ex;
        }

        return mv;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request, RedirectAttributes attr, ModelAndView mv) {


        mv.setViewName("/sso/login");
        return mv;
    }

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, @RequestParam int loginCount,@RequestParam String email,@RequestParam String  phone,@RequestParam String password, RedirectAttributes attr, ModelAndView mv) {





        mv.setViewName("/sso/login");
        return mv;
    }
}
