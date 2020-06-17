package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User loginByNameAndPassword(String n,String p) {
        try {
            String sql = "select * from tb_user where user_name = ? and user_password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),n,p);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}