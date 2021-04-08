package top.dpdaidai.basis.jdbc.dao.impl;

import top.dpdaidai.basis.jdbc.util.DBUtil;

import java.sql.*;

/**
 *
 * 批量执行
 * @Author chenpantao
 * @Date 4/8/21 10:27 PM
 * @Version 1.0
 */
public class BatchDaoImpl {

    public static void main(String[] args) {
        insertBath();
    }

    public static void insertBath() {
        Connection connection = DBUtil.getConnection();
        String sql = "insert psn values (?,?,?,?)";
        //准备预处理块对象
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i + 30);
                preparedStatement.setString(2, "lisi");
                preparedStatement.setInt(3,i);
                preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
            for (int anInt : ints) {
                System.out.println(anInt);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
    }

}
