package cn.whatisee.web.controller;

import cn.whatisee.config.ResponseConfig;
import cn.whatisee.cache.CacheException;
import cn.whatisee.core.util.JsonUtil;
import cn.whatisee.model.BaseJsonModel;
import cn.whatisee.service.IImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * Created by mingsheng on 16/4/6.
 */


public class BaseController {

    @Autowired
    private IImageService imageService;

    private Logger logger = Logger.getLogger(BaseController.class);

    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file, @RequestParam("sessionId") String sessionId) {

        BaseJsonModel reponse = new BaseJsonModel();

        if (file.getSize() > 0) {
            try {

                imageService.uploadAndCreateImage(file.getBytes(),file.getOriginalFilename(),sessionId);
            } catch (CacheException e) {

                reponse.setErrCode(ResponseConfig.NoLogin.getIndex());
                reponse.setErrMessage("用户未登录");
                logger.error(e);
            } catch (IOException e) {

                reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
                reponse.setErrMessage("上传发生错误");

                logger.error(e);
            }

        } else {
            reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
            reponse.setErrMessage("文件大小错误");
        }

        return JsonUtil.toJson(reponse);
    }
}
