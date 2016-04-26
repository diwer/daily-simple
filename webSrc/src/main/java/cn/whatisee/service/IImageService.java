package cn.whatisee.service;

import cn.whatisee.cache.CacheException;
import cn.whatisee.model.Image;

import java.io.IOException;
import java.util.List;

/**
 * Created by mingsheng on 16/4/7.
 */
public interface IImageService {

    Image uploadAndCreateImage(byte[] bytes, String fileName, String sessionId) throws IOException, CacheException;

    List<Image> getImagesByCreateId(String id);

    boolean deleteImage(String id);

    Image getImageById(String id);

    List<Image> getImagesByIds(List<String> ids);

}
