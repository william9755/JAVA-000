package com.geektime.service;

import com.geektime.pojo.Order;
import com.geektime.util.IdWorker;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YangMin
 * @date 2020/12/8 13:57
 */
@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void addOrder() {
        String sql = "INSERT INTO t_order_(order_id,user_id,user_address_id) values(?,?,?)";
        List<Order> orders = buildOrderData();
//        Order errorOrder = buildErrorData();
//        orders.add(0,errorOrder);
//        orders.add(orders.size() - 1,errorOrder);
        int[] value = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Order order = orders.get(i);
                ps.setObject(1, order.getOrderId());
                ps.setObject(2, order.getUserId());
                ps.setObject(3, order.getUserAddressId());
            }
            @Override
            public int getBatchSize() {
                return orders.size();
            }
        });
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
            orders.add(order);
        }

        return orders;
    }

    private Order buildErrorData() {
        Order order = new Order();
        order.setOrderId(1111111111l);
        order.setUserId(1111111111l);
        order.setUserAddressId(1111111111l);
        return order;
    }
}
