package top.dpdaidai.basis.jdbc.dao.impl;

import top.dpdaidai.basis.jdbc.dao.PersonDao;
import top.dpdaidai.basis.jdbc.entity.Person;
import top.dpdaidai.basis.jdbc.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenpantao
 * @Date 4/8/21 5:24 PM
 * @Version 1.0
 */
public class PersonDaoImpl implements PersonDao {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person();
        person.setId(22);
        person.setName("dda");
        person.setAge(18);
//        personDao.insert(person);
//        personDao.delete(person);
//        person.setName("xiugaihou");
//        personDao.update(person);

//        List<Person> select = personDao.select();
//        System.out.println(select);
        Person person1 = personDao.selectById(10);
        System.out.println(person1);

    }

    /**
     * 当插入数据得时候要注意属性类型得匹配
     * 1 Date
     * 2 String 需要添加单引号
     * @param person
     */
    @Override
    public void insert(Person person) {
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        //设置事务是否自动提交
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();

            //拼接sql
            String sql = "insert psn values (" + person.getId() + ",'" + person.getName() + "'," + person.getAge() + ")";
            System.out.println(sql);
            int i = statement.executeUpdate(sql);
            System.out.println("插入数据量 : " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }

    }

    @Override
    public void delete(Person person) {
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        //设置事务是否自动提交
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();

            //拼接sql
            String sql = "delete from psn where id = " + person.getId();
            System.out.println(sql);
            int i = statement.executeUpdate(sql);
            System.out.println("插入数据量 : " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void update(Person person) {

        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        //设置事务是否自动提交
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();

            //拼接sql
            String sql = "update psn set name = '" + person.getName() + "' where id = " + person.getId();
            System.out.println(sql);
            int i = statement.executeUpdate(sql);
            System.out.println("插入数据量 : " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }

    }

    @Override
    public List<Person> select() {

        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        //设置事务是否自动提交
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            //拼接sql
            String sql = "select * from psn";
            System.out.println(sql);

            resultSet = statement.executeQuery(sql);
            ArrayList<Person> personArrayList = new ArrayList<>();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                personArrayList.add(person);
            }
            return personArrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);

            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(connection);
        }

        return null;
    }

    @Override
    public Person selectById(Integer id) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //设置事务是否自动提交
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //拼接sql
            String sql = "select * from psn where id = ?";
            System.out.println(sql);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                return person;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }

        return null;
    }
}
