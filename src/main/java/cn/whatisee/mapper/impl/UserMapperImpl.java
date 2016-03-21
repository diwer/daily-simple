package cn.whatisee.mapper.impl;

import cn.whatisee.core.util.MD5Util;
import cn.whatisee.mapper.UserMapper;
import cn.whatisee.mapper.mapRow.UserMapRow;
import cn.whatisee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ppc on 2016/3/8.
 */

@Service
public class UserMapperImpl implements UserMapper {

    private String SQL_SELECT_DAILY_BY_PHONE = "select * from dy_user where phone=?";
    private String SQL_SELECT_DAILY_BY_EMAIL = "select * from dy_user where email=?";
    private String SQL_SELECT_DAILY_BY_ID = "select * from dy_user where id=?";
    private String SQL_INSERT_USER = "insert into dy_user (id,phone,email,password,createtime,lastlogintime,nickname) values (?,?,?,?,?,?,?)";
    private String SQL_UPDATE_PASSWORD = "update dy_user set passoword=? where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findUserByPhone(String phone) {
        return jdbcTemplate.queryForObject(SQL_SELECT_DAILY_BY_PHONE, new UserMapRow(), phone);
    }

    @Override
    public User findUserByEmail(String email) {

        return jdbcTemplate.queryForObject(SQL_SELECT_DAILY_BY_EMAIL, new UserMapRow(), email);
    }

    @Override
    public User findUserById(String userId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_DAILY_BY_ID, new UserMapRow(), userId);
    }

    @Override
    public User CreateUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setPassword(MD5Util.parseStrToMd5U32(user.getPassword()));

        jdbcTemplate.update(SQL_INSERT_USER, user.getId(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
                new Date(),
                new Date(),
                user.getNickName()
        );
        return user;
    }

    @Override
    public boolean IsExistUserByPhone(String phone) {
        User user = findUserByPhone(phone);
        return user == null;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        User user = findUserByEmail(email);
        return user == null;
    }

    @Override
    public boolean ExchangePassword(String userId, String password) {
        try {
            String newPassword = MD5Util.parseStrToMd5U32(password);
            jdbcTemplate.update(SQL_UPDATE_PASSWORD, newPassword, userId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
