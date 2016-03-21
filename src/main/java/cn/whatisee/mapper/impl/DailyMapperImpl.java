package cn.whatisee.mapper.impl;

import cn.whatisee.mapper.DailyMapper;
import cn.whatisee.mapper.exception.NotFindException;
import cn.whatisee.mapper.mapRow.DailyMapRow;
import cn.whatisee.model.Daily;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by ppc on 2016/3/8.
 */

@Repository
public class DailyMapperImpl implements DailyMapper {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private static String TableName = "dy_daily";
    private String SQL_SELECT_DAILY_BY_USERID = "select * from dy_daily where userid=?";
    private String SQL_SELECT_DAILY_BY_ID = "select * from dy_daily where id=?";

    private String SQL_SELECT_DAILY_BY_USERID_PAGING = "SELECT * FROM dy_daily WHERE id <= " +
            "(SELECT id FROM dy_daily ORDER BY id desc LIMIT  ?, 1) and userid=? ORDER BY id desc LIMIT ?";


    private JdbcTemplate jdbcTemplate;


    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public DailyMapperImpl(BasicDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TableName);
    }


    @Override
    public List<Daily> findDailiesByUserIdPaging(String userId, int pageIndex, int pageSize) {

        //queryforList 不支持MapRow
        List<Daily> dailyList ;
        try {
            dailyList =
                    jdbcTemplate.query(SQL_SELECT_DAILY_BY_USERID_PAGING, new DailyMapRow(), (pageIndex - 1) * pageSize, userId, pageSize);
        } catch (DataAccessException ex) {

            logger.debug("根据userid获取Daily失败:", ex);
            return null;
        }
        return dailyList;
    }

    @Override
    public Daily UpdateDaily(Daily ndaily) throws IllegalAccessException, NotFindException {
        Daily oldDaily = findDailyById(ndaily.getId());
        if (oldDaily == null)
            throw new NotFindException(ndaily.getId(), this.getClass().getName());
        Field[] fields = Daily.class.getDeclaredFields();
        Map<String, Object> updateMap = new HashMap<>();
        for (Field obj : fields) {
            obj.setAccessible(true);
            Object fieldObject = obj.get(ndaily);
            if (fieldObject != obj.get(oldDaily)) {
                updateMap.put(obj.getName(), fieldObject);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("update dy_daily set ");
        String id="";
        for (Map.Entry<String, Object> entry : updateMap.entrySet()) {
            if(entry.getKey()=="id"){
                id=(String) entry.getValue();
            }else {
                if(entry.getValue() instanceof String||entry.getValue() instanceof Date){
                    builder.append(String.format(" %s='%s',", entry.getKey(), entry.getValue()));
                }else {
                    builder.append(String.format(" %s=%s,", entry.getKey(), entry.getValue()));
                }
            }

        }
        builder.delete(builder.length() - 1, builder.length());
        builder.append(String.format(" where id='%s'",id));
        try {
            jdbcTemplate.update(builder.toString());
        } catch (DataAccessException excp) {
            logger.info(builder.toString());
            logger.debug("更新Daily失败", excp);
        }


        return ndaily;
    }

    @Override
    public List<Daily> findDailiesByUserId(String userID) {

        return findDailiesByUserIdPaging(userID, 1, 20);
    }

    @Override
    public Daily findDailyById(String id) {
        Daily daily;
        try {

            daily = jdbcTemplate.queryForObject(SQL_SELECT_DAILY_BY_ID, new DailyMapRow(), id);

        } catch (DataAccessException ex) {
            logger.debug("根据ID获取daily失败", ex);
            return null;
        }
        return daily;
    }

    @Override
    public Daily createDaily(Daily daily) {
        daily.setId(UUID.randomUUID().toString());
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("id", daily.getId());
        parameters.put("content", daily.getContent());
        parameters.put("createdate", new Date());
        parameters.put("likecount", 0);
        parameters.put("reportcount", 0);
        parameters.put("isdelete", 0);
        parameters.put("userid", daily.getUserId());
        parameters.put("location", daily.getLocation());
        parameters.put("weather", daily.getWeather());
        parameters.put("dailystatus", daily.getDailystatus());
        parameters.put("videourl", daily.getVideoUrl());
        parameters.put("title", daily.getTitle());
        parameters.put("tag", daily.getTag());
        try {
            jdbcInsert.execute(parameters);
        } catch (DataAccessException ex) {
            logger.debug("创建daily失败:",ex);
            return null;
        }
        return daily;
    }


}
