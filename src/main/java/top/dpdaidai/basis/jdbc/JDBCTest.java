package top.dpdaidai.basis.jdbc;

import java.sql.*;

/**
 * @Author chenpantao
 * @Date 4/7/21 9:48 PM
 * @Version 1.0
 */
public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1 加载驱动
        /*
        当前语句会实例化一个myql的Driver对象 ,
        当执行了当前代码后 , 会返回一个CLass对象 , 在此对象的创建过程中 , 会调用具体类的静态代码块
         */
        Class.forName("com.mysql.jdbc.Driver");

        //2 建立连接
        //第一步中已经将Driver对象注册倒了DriverManager中, 所以此时可以直接通过DriverManager来获取数据库连接
        //需要输入连接数据库的参数 : 数据库的地址 , 用户名 , 密码
        String url = "jdbc:mysql://url:3306/mashibing?characterEncoding=utf8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "password");

        //3 测试连接是否成功
        System.out.println(connection);

        //4 定义SQL语句
        String sql = " select * from psn";

        //5 注备静态处理块对象 . 将sql语句放置倒静态处理块中 , 理解为SQL语句放置对象
        //用于执行静态SQL 并返回其生成结果的对象
        /*
        在执行sql语句的过程中 , 需要一个对象来存放sql语句 , 将对象进行执行的时候调用的是数据库的服务 ,
        数据库会从当前对象中取出对应的sql语句进行执行
         */
        Statement statement = connection.createStatement();

        //6执行sql语句, 返回值对象是结果集合
        //将结果放到resultSet中 , 是返回结果的一个集合
        //需要经过循环迭代才能获取到其中的每一条记录
        //execute : 任何sql语句都能执行
        //executeQuery: 只能执行查询语句
        //executeUpdate : 增删改查
        ResultSet resultSet = statement.executeQuery(sql);

        //7 循环处理
        //使用while循环 , 有两种获取具体值的方式
        //第一种 : 通过下标索引编号来获取( 编号从1开始 )
        //第二种 : 通过列名来获取 . 建议使用列名来获取 .
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String name = resultSet.getString("name");
            System.out.println(name);
            System.out.println("===============");
        }

        //8 关闭连接
        statement.close();
        connection.close();

    }


}
