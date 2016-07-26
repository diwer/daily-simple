package cn.whatisee.service.impl.mybaties;

import cn.whatisee.cache.CacheException;
import cn.whatisee.model.Image;
import cn.whatisee.service.IImageService;
import cn.whatisee.service.exception.NullSessionIdException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by ming on 16/7/25.
 */
@Service
public class ImageServiceImpl implements IImageService {
    @Override
    public Image uploadAndCreateImage(byte[] bytes, String fileName, String sessionId) throws IOException, CacheException, NullSessionIdException {
        return null;
    }

    @Override
    public List<Image> getImagesByCreateId(String id) {
        return null;
    }

    @Override
    public boolean deleteImage(String id) {
        return false;
    }

    @Override
    public Image getImageById(String id) {
        return null;
    }

    @Override
    public List<Image> getImagesByIds(List<String> ids) {
        return null;
    }
}
