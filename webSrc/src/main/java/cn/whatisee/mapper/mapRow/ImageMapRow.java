package cn.whatisee.mapper.mapRow;

import cn.whatisee.model.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by mingsheng on 16/4/6.
 */
public class ImageMapRow implements RowMapper<Image>{



    @Override
    public Image mapRow(ResultSet resultSet, int i) throws SQLException {
        Image image=new Image();
        image.setId(resultSet.getNString("id"));
        image.setStoreLocation(resultSet.getString("storelocation"));
        image.setUrl(resultSet.getString("url"));
        image.setisDelete(resultSet.getBoolean("isdelete"));
        image.setCreateDate(resultSet.getDate("createdate"));
        image.setCreaterId(resultSet.getString("createid"));
        image.setFileName(resultSet.getString("filename"));
        image.setOrderNo(resultSet.getInt("orderno"));
        return  image;
    }
}
