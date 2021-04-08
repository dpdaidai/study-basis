package top.dpdaidai.basis.jdbc.util;

import java.sql.*;

/**
 * @Author chenpantao
 * @Date 4/8/21 5:07 PM
 * @Version 1.0
 */
public class DBUtil {

    public static final String URL = "jdbc:mysql://URL:3306/mashibing?characterEncoding=utf8&useSSL=false";

    public static final String USER_NAME = "root";

    public static final String PASSWORD = "PS";

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void closeConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 关闭statement
     * @param statement
     */
    public static void closeStatement(Statement statement) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeResultSet(ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
