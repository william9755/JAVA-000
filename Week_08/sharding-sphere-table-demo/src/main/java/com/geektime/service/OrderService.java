package com.geektime.service;

import com.geektime.pojo.Order;
import com.geektime.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author YangMin
 * @date 2020/12/9 13:57
 */
@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addOrder() {
        String sql = "INSERT INTO t_order_(order_id,user_id,user_address_id,order_paystate) values(?,?,?,?)";
        List<Order> orders = buildOrderData();
        int[] value = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Order order = orders.get(i);
                ps.setObject(1, order.getOrderId());
                ps.setObject(2, order.getUserId());
                ps.setObject(3, order.getUserAddressId());
                ps.setObject(4, order.getOrderPaystate());
            }
            @Override
            public int getBatchSize() {
                return orders.size();
            }
        });
    }

    public List<Map<String,Object>> getOrder() {
        String sql = "select * from t_order_ where order_paystate = 0";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public void updateOrder() {
        String sql = "update t_order_ set order_paystate = 1 where order_paystate = 0";
        jdbcTemplate.update(sql);
    }

    public void deleteOrder() {
        String sql = "delete from t_order_";
        jdbcTemplate.update(sql);
    }

    private List<Order> buildOrderData() {
        IdWorker idWorker = new IdWorker(1,1,1);
        final int userLen = 16;
        List<Long> userIds = new ArrayList<>(userLen);
        for(int i = 1;i <= userLen;i++) {
            userIds.add(idWorker.nextId());
        }

        final int orderLen = 160;
        List<Order> orders = new ArrayList<>(orderLen);
        Order order = null;
        for(int i = 1;i <= orderLen;i++) {
            order = new Order();
            order.setOrderId(idWorker.nextId());
            order.setUserId(userIds.get(i % userLen));
            order.setUserAddressId(System.currentTimeMillis());
            order.setOrderPaystate(i % 3);
            orders.add(order);
        }

        return orders;
    }
}
