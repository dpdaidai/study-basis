package top.dpdaidai.basis.jdbc.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author chenpantao
 * @Date 4/15/21 4:24 PM
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://url:3306/mashibing");
        config.setUsername("root");
        config.setPassword("ps");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
