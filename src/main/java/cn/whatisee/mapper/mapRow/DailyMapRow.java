package cn.whatisee.mapper.mapRow;

import cn.whatisee.model.Daily;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ppc on 2016/3/10.
 */
public  final class DailyMapRow implements RowMapper<Daily> {

    public  Daily mapRow(ResultSet resultSet,int rowNum)throws SQLException{
        Daily daily=new Daily();

        daily.setId(resultSet.getString("id"));
        daily.setWeather(resultSet.getString("weather"));
        daily.setReportCount(resultSet.getInt("reportcount"));
        daily.setCreateDate(resultSet.getDate("createdate"));
        daily.setContent(resultSet.getString("content"));
        daily.setLocation(resultSet.getString("location"));
        daily.setDeleteDate(resultSet.getDate("deletedate"));
        daily.setIsDelete(resultSet.getBoolean("isdelete"));
        daily.setLikeCount(resultSet.getInt("likecount"));
        daily.setDailystatus(resultSet.getInt("dailystatus"));
        daily.setUserId(resultSet.getString(("userid")));
        daily.setVideoUrl(resultSet.getString("videoUrl"));
        daily.setTitle(resultSet.getString("title"));
        daily.setTag(resultSet.getString("Tag"));
        return daily;
    }

}
