package com.geektime.util;

import com.geektime.config.JdbcConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author YangMin
 * @time 2020-11-16 16:45
 */
@Component
public class ConnectionManager {

    private Logger logger = Logger.getLogger(ConnectionManager.class);

    @Autowired
    private JdbcConfig jdbcConfig;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Thread.currentThread().getContextClassLoader().loadClass(jdbcConfig.getDriver());
        } catch (ClassNotFoundException e) {
            Class.forName(jdbcConfig.getDriver());
        }
        return DriverManager.getConnection(jdbcConfig.getUrl(), jdbcConfig.getUser(), jdbcConfig.getPassword());
    }

    public void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("关闭数据库连接出错！");
            e.printStackTrace();
        }
    }

    public void rollback(Connection conn) {
        try {
            if(conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            logger.error("回滚时出现错误！");
            e.printStackTrace();
        }
    }

}
