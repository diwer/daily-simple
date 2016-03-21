package cn.whatisee.mapper.mapRow;

import cn.whatisee.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ppc on 2016/3/10.
 */
public  final class UserMapRow implements RowMapper<User> {
    public User mapRow(ResultSet rs , int rowNum)throws SQLException {
        User user=new User();
        user.setId(rs.getString("id"));
        user.setCreateTime(rs.getDate("createtime"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setLastLoginTime(rs.getDate("lastlogintime"));
        user.setNickName(rs.getString("nickname"));
        user.setPhone(rs.getString("phone"));
        return user;
    }
}
