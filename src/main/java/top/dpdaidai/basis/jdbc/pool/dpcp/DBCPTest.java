package top.dpdaidai.basis.jdbc.pool.dpcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author chenpantao
 * @Date 4/13/21 4:11 PM
 * @Version 1.0
 */
public class DBCPTest {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mashibing");
        dataSource.setUsername("root");
        dataSource.setPassword("ps");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //从池中取出一个连接
            connection = dataSource.getConnection();
            String sql = "select * from psn";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //将连接放回连接池中
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
