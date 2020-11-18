package com.geektime.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author YangMin
 * @time 2020-11-16 16:45
 */
@Component
public class ConnectionManager {

    private Logger logger = Logger.getLogger(ConnectionManager.class);

    @Resource(description = "dataSource")
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
