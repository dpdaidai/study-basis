package top.dpdaidai.basis.jdbc.apacheDBUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import top.dpdaidai.basis.jdbc.entity.Person;
import top.dpdaidai.basis.jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * 测试使用apache DBUtil包
 * @Author chenpantao
 * @Date 4/13/21 2:36 PM
 * @Version 1.0
 */
public class DBUtilTest {

    public static void main(String[] args) throws SQLException {
//        testQuery();
//        testList();
//        testArray();
//        testArrayList();
//        testMap();
//        testScalarHandler();
//        testMyHandler();
//        insert();
//        update();
//        delete();
    }

    public static void testQuery() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn where id = ?";

        QueryRunner queryRunner = new QueryRunner();

        Person query = queryRunner.query(connection, sql, new BeanHandler<>(Person.class), 20);

        System.out.println(query);

        connection.close();
    }

    public static void testList() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn";

        QueryRunner queryRunner = new QueryRunner();

        List<Person> query = queryRunner.query(connection, sql, new BeanListHandler<>(Person.class));

        connection.close();

        query.stream().forEach(System.out::println);

    }

    public static void testArray() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn";
        QueryRunner runner = new QueryRunner();
        Object[] object = runner.query(connection, sql, new ArrayHandler());

        connection.close();

        for (Object o : object) {
            System.out.println(o);
        }
    }

    public static void testArrayList() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn";
        QueryRunner runner = new QueryRunner();
        List<Object[]> query = runner.query(connection, sql, new ArrayListHandler());
        for (Object[] objects : query) {
            System.out.println(objects[0] + "--" + objects[1] + "--" + objects[2]);
        }
        connection.close();
    }


    public static void testMap() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn";
        QueryRunner runner = new QueryRunner();
        Map<String, Object> query = runner.query(connection, sql, new MapHandler());
        Set<Map.Entry<String, Object>> entries = query.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
        connection.close();
    }

    public static void testScalarHandler() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select count(*) from psn";
        QueryRunner runner = new QueryRunner();
        Object query = runner.query(connection, sql, new ScalarHandler<>());
        System.out.println(query);
        connection.close();
    }

    /**
     * 自定义handler对象
     * @throws SQLException
     */
    public static void testMyHandler() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from psn where id = ?";
        QueryRunner runner = new QueryRunner();
        Person emp = runner.query(connection, sql, new ResultSetHandler<Person>() {
            @Override
            public Person handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    return person;
                }
                return null;
            }
        }, 20);
        System.out.println(emp);
        connection.close();
    }


    public static void insert() throws SQLException {
        String sql = "insert into psn(name) values(?)";
        Connection connection = DBUtil.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(connection, sql, "msb");
        connection.close();
    }


    public static void update() throws SQLException {
        String sql = "update psn set name=? where id = ?";
        Connection connection = DBUtil.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(connection, sql, "mashibing", 36);
        connection.close();
    }

    public static void delete() throws SQLException {
        String sql = "delete from psn where id=?";
        Connection connection = DBUtil.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(connection, sql, 36);
        connection.close();
    }

}
