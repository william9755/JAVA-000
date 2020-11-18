package com.geektime.service.impl;

import com.geektime.dao.IUserDao;
import com.geektime.pojo.User;
import com.geektime.service.IUserService;
import com.geektime.util.ConnectionManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangMin
 * @time 2020-11-16 17:09
 */
@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private ConnectionManager connectionManager;

    @Autowired
    private IUserDao userDao;

    public void test() {
        Connection conn = null;
        try {
            logger.info("测试普通增删改查，开始......");
            conn = connectionManager.getConnection();
            conn.setAutoCommit(false);

            User addUser = new User();
            addUser.setUsername("test-user");
            addUser.setPhone("12345678911");
            logger.info("新增一个用户,待添加的用户信息为：" + addUser.toString());
            userDao.addUser(conn,addUser);

            User selUser = userDao.getFirstUser(conn);
            logger.info("获取第一个用户，用户信息为：" + selUser.toString());

            User updateUser = new User();
            updateUser.setUsername("test-user-update");
            updateUser.setPhone("987654321");
            updateUser.setId(selUser.getId());
            logger.info("修改用户信息,待修改的信息为：" + updateUser.toString());
            userDao.updateUser(conn,updateUser);

            logger.info("删除 id 为【" + selUser.getId() + "】的用户");
            userDao.deleteUserById(conn,selUser.getId());
            conn.commit();

            logger.info("测试普通增删改查，结束");
        } catch (SQLException e) {
            connectionManager.rollback(conn);
            logger.error("执行操作时发生异常，异常信息为：");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            connectionManager.rollback(conn);
            logger.error("执行操作时发生异常，异常信息为：");
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection(conn);
        }
    }

    public void testBatch() {
        Connection conn = null;
        try {
            logger.info("测试批处理操作，开始......");
            conn = connectionManager.getConnection();
            conn.setAutoCommit(false);

            logger.info("批量添加用户信息，开始......");
            List<User> users = new ArrayList<>();
            for(int i = 1;i <= 10;i++) {
                users.add(new User("test-username-" + i,"11111111111"));
            }
            userDao.batchAddUser(conn,users);
            logger.info("批量添加用户信息，结束");

            logger.info("删除全部用户信息");
            userDao.deleteAllUser(conn);
            conn.commit();

            logger.info("测试批处理操作，结束");
        } catch (SQLException e) {
            connectionManager.rollback(conn);
            logger.error("执行操作时发生异常，异常信息为：");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            connectionManager.rollback(conn);
            logger.error("执行操作时发生异常，异常信息为：");
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection(conn);
        }

    }
}
