package com.geektime.service;

import com.geektime.datasource.annotation.TargetDataSource;
import com.geektime.datasource.routing.DynamicDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author YangMin
 * @date 2020/12/6 21:57
 */
@Service
public class UserService {

    @Autowired
    private DynamicDatasource dynamicDatasource;

    private JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dynamicDatasource);
    }

    @TargetDataSource("ds1")
    public void addUser() {
        String sql = "insert into t_user(id,username) values(?,?)";
        Object[] params = new Object[]{1l,"username1"};
        getJdbcTemplate().update(sql,params);
    }

    @TargetDataSource("ds2")
    public List<Map<String,Object>> getAllUser() {
        String sql = "select * from t_user";
        List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
        return list;
    }

    @TargetDataSource("ds1")
    public void deleteAllUser() {
        String sql = "delete from t_user";
        getJdbcTemplate().update(sql);
    }

}
