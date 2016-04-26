package cn.whatisee.mapper;

import cn.whatisee.model.Image;

import java.util.List;

/**
 * Created by mingsheng on 16/4/6.
 */
public interface ImageMapper {

    Image getImageById(String  id);
    List<Image> getImageByIds(List<String> ids);
    Image createImage(Image image);
    boolean deleteImageById(String id);

    List<Image> getImageByCreateId(String createId);

}
