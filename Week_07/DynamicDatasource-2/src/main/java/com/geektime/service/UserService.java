package com.geektime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author YangMin
 * @date 2020/12/7 21:00
 */
@Service
public class UserService {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    public void addUser() {
        String sql = "insert into t_user(id,username) values(?,?)";
        Object[] params = new Object[]{1l,"username1"};
        getJdbcTemplate().update(sql,params);
    }

    public List<Map<String,Object>> getAllUser() {
        String sql = "select * from t_user";
        List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
        return list;
    }

    public void deleteAllUser() {
        String sql = "delete from t_user";
        getJdbcTemplate().update(sql);
    }

}
