package com.hqyj.dao;

import com.hqyj.Utils.JDBCUtils;
import com.hqyj.pojo.User;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public User selectUser(String username,String password) throws SQLException {
        try{
            connection = JDBCUtils.getConnection();

        //获取connection连接,需要三个参数,链接地址,数据库用户名,数据库密码
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "123456");
        //编写sql语句
            String sql = "SELECT * from user WHERE username =? and password =? ";
//        String sql = "SELECT * from user ";

        //通过connection创建预编译对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        preparedStatement.setString(1,username);
//        preparedStatement.setString(2,password);
        //通过预编译对象执行sql,查询使用executeQuery,增删改使用executeUpdate
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
        //使用while循环遍历结果集,result.next如果有值返回true没有值返回false
            while (resultSet.next()) {
                //resultSet.getXXX获取值,参数为值的位置
                int id = resultSet.getInt(1);
                String s1 = resultSet.getString(2);
                String s2 = resultSet.getString(3);
                String s3 = resultSet.getString(4);
                String s4 = resultSet.getString(5);
                //通过全参构造创建user对象
                user = new User(id, s1, s2, s3, s4);
            }

            //如果user不是null说明查询到结果,返回创建好的user对象
            if (user != null) {
                return user;
            } else {
                //如果没有查询到返回null
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public List<User> queryAllUser() throws SQLException {
        connection = JDBCUtils.getConnection();
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "123456");
        //编写sql语句
        String sql = "SELECT * from user ";
        //通过connection创建预编译对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //通过预编译对象执行sql,查询使用executeQuery,增删改使用executeUpdate
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> list = new ArrayList<>();
        User user = null;
        //使用while循环遍历结果集,result.next如果有值返回true没有值返回false
        while (resultSet.next()) {
            //resultSet.getXXX获取值,参数为值的位置
            int id = resultSet.getInt(1);
            String s1 = resultSet.getString(2);
            String s2 = resultSet.getString(3);
            String s3 = resultSet.getString(4);
            String s4 = resultSet.getString(5);
            //通过全参构造创建user对象
            list.add(new User(id, s1, s2, s3, s4));
        }

        JDBCUtils.close(connection,preparedStatement,resultSet);
        //如果user不是null说明查询到结果,返回创建好的user对象
        return list;
    }

    public int addUser(String userName,String userAccount,String userPassword,String state) throws SQLException {
        connection= JDBCUtils.getConnection();
        String sql = "INSERT INTO user (name,username,password,state) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,userAccount);
        preparedStatement.setString(3,userPassword);
        preparedStatement.setString(4,state);
        int result = preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return result;
    }

    public void updateUserById() throws SQLException {
        connection =  JDBCUtils.getConnection();

        String sql = "";

    }

    public User queryUserByUserName(String userName) throws SQLException {
        connection = JDBCUtils.getConnection();

        String sql = "SELECT * FROM user WHERE username=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();


//        User user = null;
        //使用while循环遍历结果集,result.next如果有值返回true没有值返回false
        while (resultSet.next()) {
            //resultSet.getXXX获取值,参数为值的位置
            int id = resultSet.getInt(1);
            String s1 = resultSet.getString(2);
            String s2 = resultSet.getString(3);
            String s3 = resultSet.getString(4);
            String s4 = resultSet.getString(5);
            //通过全参构造创建user对象
            JDBCUtils.close(connection,preparedStatement, resultSet);
            return new User(id, s1, s2, s3, s4);

        }
        return null;

    }

    public int updateUserById(String id,String name,String username,String password,String state) throws SQLException {
        connection = JDBCUtils.getConnection();

        String sql = "UPDATE user SET name =?,username =?,password =? ,state =? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,username);
        preparedStatement.setString(3,password);
        preparedStatement.setString(4,state);
        preparedStatement.setString(5,id);

        int result = preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement, resultSet);
        return result;

    }


    public int delUserById(String id) throws SQLException {
        //通过JDBCUtils 类方法创建MySQL连接
        connection = JDBCUtils.getConnection();

        String sql = "DELETE FROM user WHERE id = ?";
        //执行sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //替换 ？ 1为第一个位置的值
        preparedStatement.setString(1,id);

        int result = preparedStatement.executeUpdate();

        return result;

    }

    public User userLogin(String userName, String userPassword) throws SQLException {

        connection = JDBCUtils.getConnection();

        String sql = "SELECT * FROM user WHERE username = ? and password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,userPassword);

        ResultSet resultSet = preparedStatement.executeQuery();


//        User user = null;
        //使用while循环遍历结果集,result.next如果有值返回true没有值返回false
        while (resultSet.next()) {
            //resultSet.getXXX获取值,参数为值的位置
            String s1 = resultSet.getString(2);
            String s2 = resultSet.getString(3);
            //通过全参构造创建user对象
            JDBCUtils.close(connection,preparedStatement, resultSet);
            return new User(s1, s2);

        }
        return null;

    }
}
