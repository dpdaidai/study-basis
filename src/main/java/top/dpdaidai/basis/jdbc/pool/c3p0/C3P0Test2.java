package top.dpdaidai.basis.jdbc.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 使用配置文件配置datasource
 * @Author chenpantao
 * @Date 4/13/21 4:35 PM
 * @Version 1.0
 */
public class C3P0Test2 {
    public static Connection connection;

    public static ComboPooledDataSource dataSource;

    //c3p0默认配置文件在根目录 ,
    // c3p0.properties 或者c3p0-config.xml
    //  /com/mchange/v2/c3p0/cfg/C3P0ConfigFinder.class
    public static void getConnection() throws SQLException {
        dataSource = new ComboPooledDataSource();
    }

    public static void queryData(){
        try {
            connection = dataSource.getConnection();
            String sql = "select * from psn";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws SQLException {
        getConnection();
        queryData();
    }


}
