package cn.whatisee.service.impl.jdbc;

import cn.whatisee.config.StoreConfig;
import cn.whatisee.core.util.QniuUtil;
import cn.whatisee.core.util.UUIDUtil;
import cn.whatisee.mapper.ImageMapper;
import cn.whatisee.model.Image;
import cn.whatisee.model.ImageExample;
import cn.whatisee.service.IImageService;
import cn.whatisee.service.impl.BaseServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by mingsheng on 16/4/7.
 */
@Service
public class ImageServiceImpl extends BaseServiceImpl implements IImageService {


    private Logger logger = Logger.getLogger(ImageServiceImpl.class);

    private final ImageMapper imageMapper;

    @Autowired
    public ImageServiceImpl(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public Image uploadAndCreateImage(byte[] bytes, final String fileName, String userId) throws IOException {

        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String id = UUIDUtil.getUUID();
        Image image = new Image();
        image.setId(id);
        image.setFilename(fileName);
        image.setUsedid(userId);
        image.setCreatetdate(new Date());
        image.setIsdelete((byte) 0);
        image.setUrl(id + suffix);
        image.setFilepath(StoreConfig.Image.getName());
        try {
            QniuUtil.getInstance().uploadByByte(bytes, fileName, StoreConfig.Image.getName());

            imageMapper.insert(image);
        } catch (Exception excp) {
            logger.error(excp);
            return null;
        }
        return image;
    }

    @Override
    public List<Image> getImagesByCreateId(String id) {

        List<Image> list = new ArrayList<>();
        ImageExample example = new ImageExample();
        example.createCriteria().andCreateridEqualTo(id);
        try {
            list = imageMapper.selectByExample(example);
        } catch (Exception ex) {
            logger.error("获取图片失败" + ex);
        }
        return list;

    }

    @Override
    public boolean deleteImage(String id) {
        int result = imageMapper.deleteByPrimaryKey(id);
        return result == 0;
    }

    @Override
    public Image getImageById(String id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Image> getImagesByIds(List<String> ids) {
        ImageExample example = new ImageExample();
        example.createCriteria().andIdIn(ids);

        return imageMapper.selectByExample(example);
    }
}
