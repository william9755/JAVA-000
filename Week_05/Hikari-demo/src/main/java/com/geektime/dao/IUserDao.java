package com.geektime.dao;

import com.geektime.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author YangMin
 * @time 2020-11-16 17:09
 */
public interface IUserDao {

    User getFirstUser(Connection conn) throws SQLException, ClassNotFoundException;

    boolean addUser(Connection conn, User user) throws SQLException, ClassNotFoundException;

    boolean updateUser(Connection conn, User user) throws SQLException, ClassNotFoundException;

    boolean deleteUserById(Connection conn, int id) throws SQLException, ClassNotFoundException;

    boolean batchAddUser(Connection conn, List<User> users) throws SQLException, ClassNotFoundException;

    boolean deleteAllUser(Connection conn) throws SQLException, ClassNotFoundException;

}
