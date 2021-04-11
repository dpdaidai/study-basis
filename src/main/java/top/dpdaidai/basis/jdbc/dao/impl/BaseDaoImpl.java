package top.dpdaidai.basis.jdbc.dao.impl;

import top.dpdaidai.basis.jdbc.entity.Student;
import top.dpdaidai.basis.jdbc.util.DBUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 要查询N张表的数据，但是不想写N多的方法，
 * 能否编写一个统一查询数据库表得方法
 *
 * @Author chenpantao
 * @Date 4/11/21 2:49 PM
 * @Version 1.0
 */
public class BaseDaoImpl {


    public static void main(String[] args) {
        BaseDaoImpl baseDao = new BaseDaoImpl();
//        List<Person> rows = baseDao.getRows("select * from psn where age = ? and name = ?", new Object[]{1, "lisi"}, Person.class);
        List rows = baseDao.getRows("select * from student where age = ? and className = ?", new Object[]{15, "c"}, Student.class);
        for (Object row : rows) {
            System.out.println(row);
        }

    }

    /**
     * 统一得查询表得方法
     * @param sql  sql
     * @param params sql参数
     * @param objectClass 查询出来得对象类型
     * @return
     */
    public List getRows(String sql, Object[] params, Class objectClass) {
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnection();

            //创建ps对象
            preparedStatement = connection.prepareStatement(sql);

            //sql添加参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            //开始执行查询操作
            resultSet = preparedStatement.executeQuery();

            //获取集合得元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();

            //判断查询到得每一行记录包含多少个列
            int columnCount = metaData.getColumnCount();

            //循环遍历ResultSet
            while (resultSet.next()) {

                //创建放置具体结果得对象
                Object object = objectClass.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    //从结果集合中获取单一列得值
                    Object columnObject = resultSet.getObject(i + 1);

                    //获取列得名称 , 有必要得话 , 应该在这里将 class_name 这类命名方式转换 为 className 驼峰命名法
                    String columnName = metaData.getColumnName(i + 1);

                    //获取类中得属性值
                    // --> 理论上不应该直接获取私有得field , 而且这个方法能获取所有得field , 但是没有父类的field
                    //所有当有继承关系时 , 就失去了应该得效果 , 所以不从这里获取属性名
//                    Field declaredField = objectClass.getField(columnName);

                    //获取类中对应得set方法
                    Method method = objectClass.getMethod(getSetName(columnName), columnObject.getClass());

                    //使用反射 , 利用set方法为属性注入值
                    method.invoke(object, columnObject);

                }
                list.add(object);

            }

        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }

        return list;
    }

    public String getSetName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
