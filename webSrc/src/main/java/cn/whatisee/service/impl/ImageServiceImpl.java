package cn.whatisee.service.impl;

import cn.whatisee.config.StoreConfig;
import cn.whatisee.cache.CacheException;
import cn.whatisee.cache.redis.RedisClient;
import cn.whatisee.core.util.QnUtil;
import cn.whatisee.core.util.UUIDUtil;
import cn.whatisee.mapper.ImageMapper;
import cn.whatisee.model.Image;
import cn.whatisee.model.User;
import cn.whatisee.service.IImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * Created by mingsheng on 16/4/7.
 */
@Service
public class ImageServiceImpl implements IImageService {


    private Logger logger = Logger.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageMapper imageMapper;



    @Override
    public Image uploadAndCreateImage(byte[] bytes,final String fileName, String sessionId) throws IOException, CacheException {
        User user;//上传文件的人
        String name = fileName;
        String suffix = name.substring(name.lastIndexOf('.'));
        String id = UUIDUtil.getUUID();
        Image image = new Image();
//      //user = client.get(sessionId);
        user=new User();
        image.setId(id);
        image.setFileName(name);
        image.setCreaterId(user.getId());
        image.setCreateDate(new Date());
        image.setisDelete(false);
        image.setUrl(id + suffix);
        image.setStoreLocation(StoreConfig.Image.getName());
        QnUtil.getInstance().uploadByByte(bytes, name, StoreConfig.Image.getName());
        try {
            imageMapper.createImage(image);
        }catch (Exception excp){
            logger.error(excp);
            return null;
        }
        return image;
    }

    @Override
    public List<Image> getImagesByCreateId(String id) {

        return imageMapper.getImageByCreateId(id);

    }

    @Override
    public boolean deleteImage(String id) {
        return imageMapper.deleteImageById(id);
    }

    @Override
    public Image getImageById(String id) {
        return  imageMapper.getImageById(id);
    }

    @Override
    public List<Image> getImagesByIds(List<String> ids) {
       return imageMapper.getImageByIds(ids);
    }
}
