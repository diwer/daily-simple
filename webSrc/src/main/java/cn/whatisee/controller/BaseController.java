package cn.whatisee.controller;

import cn.whatisee.Config.ResponseConfig;
import cn.whatisee.Config.StoreConfig;
import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.redis.RedisClient;
import cn.whatisee.core.util.JsonUtil;
import cn.whatisee.core.util.QnUtil;
import cn.whatisee.core.util.UUIDUtil;
import cn.whatisee.model.BaseJsonModel;
import cn.whatisee.model.Image;
import cn.whatisee.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Created by mingsheng on 16/4/6.
 */
@Controller
public class BaseController {

    private RedisClient<User> client = new RedisClient<>();
    private Logger logger = Logger.getLogger(BaseController.class);

    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file, @RequestParam("sessionId") String sessionId) {

        BaseJsonModel reponse = new BaseJsonModel();

        if (file.getSize() > 0) {
            User user;//上传文件的人
            String name = file.getOriginalFilename();
            String suffix = name.substring(name.lastIndexOf('.'));
            String id = UUIDUtil.getUUID();
            Image image = new Image();
            try {
                user = client.get(sessionId);

                image.setId(id);
                image.setFileName(name);
                image.setCreaterId(user.getId());
                image.setCreateDate(new Date());
                image.setisDelete(false);
                image.setUrl(id + suffix);
                image.setStoreLocation(StoreConfig.Image.getName());
                QnUtil.getInstance().uploadByByte(file.getBytes(), name, StoreConfig.Image.getName());

            } catch (CacheException e) {

                reponse.setErrCode(ResponseConfig.NoLogin.getIndex());
                reponse.setErrMessage("用户未登录");
                logger.error(e);
            } catch (IOException e) {

                reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
                reponse.setErrMessage("上传发生错误");

                logger.error(e);
            }

        }else{
            reponse.setErrCode(ResponseConfig.UploadFail.getIndex());
            reponse.setErrMessage("文件大小错误");
        }

        return JsonUtil.toJson(reponse);
    }
}
