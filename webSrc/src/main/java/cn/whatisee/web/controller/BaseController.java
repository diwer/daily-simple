package cn.whatisee.web.controller;

import cn.whatisee.cache.CacheException;
import cn.whatisee.config.ResponseConfig;
import cn.whatisee.core.util.JsonUtil;
import cn.whatisee.model.BaseJsonModel;
import cn.whatisee.model.User;
import cn.whatisee.service.IImageService;
import cn.whatisee.service.ISessionService;
import cn.whatisee.service.exception.NullSessionIdException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by mingsheng on 16/4/6.
 */


public class BaseController {

    @Autowired
    protected ISessionService sessionService;
    @Autowired
    private IImageService imageService;

    private Logger logger = Logger.getLogger(BaseController.class);

    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file, @RequestParam("sessionId") String sessionId) {

        BaseJsonModel reponse = new BaseJsonModel();

        if (file.getSize() > 0) {
            try {
                User user=sessionService.getUser(sessionId);
                if(user==null)
                    throw new NullSessionIdException("");
                imageService.uploadAndCreateImage(file.getBytes(),file.getOriginalFilename(),sessionId);
            } catch (CacheException e) {

                reponse.setErrCode(ResponseConfig.NoLogin.getIndex());
                reponse.setErrMessage("用户未登录");
                logger.error(e);
            } catch (IOException e) {

                reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
                reponse.setErrMessage("上传发生错误");

                logger.error(e);
            } catch (NullSessionIdException e) {
                reponse.setErrCode(ResponseConfig.NoLogin.getIndex());
                reponse.setErrMessage(ResponseConfig.NoLogin.getName());
            }

        } else {
            reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
            reponse.setErrMessage("文件大小错误");
        }

        return JsonUtil.toJson(reponse);
    }


}
