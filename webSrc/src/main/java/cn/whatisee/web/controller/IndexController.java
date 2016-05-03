package cn.whatisee.web.controller;

import cn.whatisee.core.util.ImageUtil;
import cn.whatisee.core.util.StringUtils;
import cn.whatisee.service.exception.NullSessionIdException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingsheng on 16/4/26.
 */
@Controller

public class IndexController extends BaseController {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/")
    public String Index() {
        return "/index/index";
    }

    @RequestMapping(path = "/valicode")
    public void valiCode(HttpServletResponse response) {

        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        String valiCode = StringUtils.getRandomString(4);
        try {
            sessionService.setString("valicode_" + valiCode, String.valueOf(1), 60);

            ImageIO.write(ImageUtil.getRandcode(valiCode), "jpg", response.getOutputStream());
        } catch (NullSessionIdException e) {
            logger.debug(e);
        } catch (IOException e) {
            logger.debug(e);
        }

    }
}
