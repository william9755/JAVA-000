package com.geektime.dao.impl;

import com.geektime.dao.IUserDao;
import com.geektime.pojo.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author YangMin
 * @time 2020-11-16 17:09
 */
@Component
public class UserDaoImpl implements IUserDao {

    public User getFirstUser(Connection conn) throws SQLException {
        String sql = "SELECT * FROM user LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);

        User user = null;
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPhone(resultSet.getString("phone"));
        }

        resultSet.close();
        ps.close();
        return user;
    }

    public boolean addUser(Connection conn,User user) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO user(username, phone) ");
        sql.append("VALUES(?,?)");

        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPhone());
        boolean result = ps.execute();

        ps.close();
        return result;
    }

    public boolean updateUser(Connection conn,User user) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE user SET username = ?,phone = ? ");
        sql.append(" WHERE id = ?");

        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPhone());
        ps.setInt(3,user.getId());
        boolean result = ps.execute();

        ps.close();
        return result;
    }

    public boolean deleteUserById(Connection conn,int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        boolean result = ps.execute();

        ps.close();
        return result;
    }

    public boolean batchAddUser(Connection conn,List<User> users) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO user(username, phone) ");
        sql.append("VALUES(?,?)");

        PreparedStatement ps = conn.prepareStatement(sql.toString());
        for(User user : users) {
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPhone());
            ps.addBatch();
        }
        int[] batchResults = ps.executeBatch();

        ps.close();
        boolean result = true;
        for(int batchResult : batchResults) {
            if(batchResult <= 0) {
                result = false;
            }
        }

        return result;
    }

    public boolean deleteAllUser(Connection conn) throws SQLException {
        String sql = "DELETE FROM user";
        PreparedStatement ps = conn.prepareStatement(sql);
        boolean result = ps.execute();

        ps.close();
        return result;
    }

}
