package top.dpdaidai.basis.jdbc;

import java.sql.*;

/**
 * @Author chenpantao
 * @Date 4/8/21 4:55 PM
 * @Version 1.0
 */
public class CreateTableTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://URL:3306/mashibing?characterEncoding=utf8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "PS");

        System.out.println(connection);

        String sql = " create table student (id int(11) primary key , name varchar(20))engine=innodb";

        Statement statement = connection.createStatement();

        //当执行DDL语句得时候 , 不会返回对应得结果
        boolean execute = statement.execute(sql);

        System.out.println(execute);

        statement.close();

        connection.close();


    }
}
