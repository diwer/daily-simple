package cn.whatisee.mapper.impl;

import cn.whatisee.core.util.UUIDUtil;
import cn.whatisee.mapper.ImageMapper;
import cn.whatisee.mapper.mapRow.ImageMapRow;
import cn.whatisee.model.Image;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by mingsheng on 16/4/6.
 */
@Repository
public class ImageMapperImpl implements ImageMapper {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private static String TableName = "dy_image";


    private JdbcTemplate jdbcTemplate;


    private SimpleJdbcInsert jdbcInsert;

    @Override
    public Image getImageById(String id) {
        final String SELECT_SQL_STR="select * from dy_image where id=?";
        return jdbcTemplate.queryForObject(SELECT_SQL_STR,new ImageMapRow(),id);
    }

    @Override
    public List<Image> getImageByIds(List<String> ids) {
        final String SELECT_SQL_STR="select * from dy_image where id in (?)";
        StringBuilder builder=new StringBuilder();
        for (String str:ids){
            builder.append("'").append(str).append("'").append(",");
        }
        builder.deleteCharAt(builder.length()-1);

        return jdbcTemplate.query(SELECT_SQL_STR,new ImageMapRow(),builder.toString());
    }

    @Override
    public Image createImage(Image image) {
        image.setId(UUIDUtil.getUUID());
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("id", image.getId());
        parameters.put("createdate", new Date());
        parameters.put("filename", image.getFileName());
        parameters.put("filepath", image.getStoreLocation());
        parameters.put("orderno", image.getOrderNo());
        parameters.put("url", image.getUrl());
        parameters.put("isdelete", 0);
        parameters.put("flagdesc", image.getFlagDesc());
        parameters.put("createid", image.getCreaterId());

        try {
            jdbcInsert.execute(parameters);
        } catch (DataAccessException ex) {
            logger.debug(ex);
            logger.info("创建image失败:",ex);
            return null;
        }
        return image;

    }

    @Override
    public boolean deleteImageById(String id) {
        try {
            jdbcTemplate.execute("delete from dy_image where id='" + id + ",");
            return  true;
        }
        catch (DataAccessException ex) {
            logger.debug(ex);
            logger.info("创建image失败:",ex);
            return  false;

        }
    }

    @Override
    public List<Image> getImageByCreateId(String createId) {
        final String SELECT_IMAGE_SQL_BY_CREATEID="select * from dy_daily where createid=?";
        try {
          return  jdbcTemplate.query(SELECT_IMAGE_SQL_BY_CREATEID,new ImageMapRow(),createId);
        }catch (DataAccessException e){
            logger.info("根据创建者Id 查询失败");
            logger.debug(e);
            return new ArrayList<>();
        }


    }
}
