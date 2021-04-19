package com.hqyj.service;

import com.hqyj.dao.UserDao;
import com.hqyj.pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    UserDao userDao = new UserDao();
    public String selectUser(String username, String password) throws SQLException {
        User user = userDao.selectUser(username,password);
//        System.out.println("id" + user.getId());
//        System.out.println("username" + user.getUsername());
//        System.out.println("password" + user.getPassword());
        if (user != null ){
            return "success";
        }else {
            return "error";
        }

    }

    public List<User> queryAllUser() throws SQLException {
        return userDao.queryAllUser();
    }

    public String addUser(String userName,String userAccount,String userPassword,String state) throws SQLException {
        int result = userDao.addUser(userName,userAccount,userPassword,state);
        if (result > 0){
//            System.out.println("success2");
            return "success";
        }
        return "error";

    }


    public void updateUserById() throws SQLException {
//        userDao.updateUserById();
    }

    public User queryUserByUserName(String userName) throws SQLException {

        User user =  userDao.queryUserByUserName(userName);

        return user;
    }

    public String updateUserById(String id,String name,String username,String password,String state) throws SQLException {
        int result =  userDao.updateUserById(id,name,username,password,state);
        if (result > 0){
            return "success";
        }
        return "error";
    }

    public String delUserById(String id) throws SQLException {
        int result = userDao.delUserById(id);
        if (result > 0){
            return "success";
        }
        return "error";
    }

    public User userLogin(String userName, String userPassword) throws SQLException {
        User user =  userDao.userLogin(userName,userPassword);

        return user;

    }
}
