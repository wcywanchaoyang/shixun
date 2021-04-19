package com.hqyj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hqyj.pojo.User;
import com.hqyj.service.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/*
    model view controller
    controller:控制层
    dao持久层,主要用于交互数据库
    service:逻辑层,主要用于处理逻辑代码
    pojo:实体类，充当model
 */
@WebServlet({"/login","/loginAjax","/user","/user/addUser","/user/updateUserById","/user/queryUserByUserName",
        "/user/delUserById"})
public class UserController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("请求到了这里");
//    }
        UserService userService = new UserService();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            login(req,resp);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try {
//            login(req,resp);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        req.setCharacterEncoding("utf-8");

        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
//        System.out.println(method);
        if (method.equals("login")){
            String userAccount = req.getParameter("userAccount");
            String userPassword = req.getParameter("userPassword");
//            System.out.println(userAccount+userPassword);
            try {
                userLogin(userAccount,userPassword,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (method.equals("queryAllUser")){
            try {
                queryAllUser(resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if(method.equals("addUser")){
            String userName = req.getParameter("userName");
            String userAccount = req.getParameter("userAccount");
            String userPassword = req.getParameter("userPassword");
            String state = req.getParameter("state");
            addUser(userName,userAccount,userPassword,state,resp);
//            System.out.println("success");
        }else  if (method.equals("queryUserByUserName")){
            String userName = req.getParameter("userName");
//            System.out.println(userName);
            try {
                queryUserByUserName(userName,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (method.equals("updateUserById")){
            String id = req.getParameter("id");
            String userName = req.getParameter("userName");
            String userAccount = req.getParameter("userAccount");
            String userPassword = req.getParameter("userPassword");
            String state = req.getParameter("state");
            try {
                updateUserById(id,userName,userAccount,userPassword,state,resp);
//                System.out.println();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if (method.equals("delUserById")){
            String id = req.getParameter("id");
            try {
                delUserById(id,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private void userLogin(String userName, String userPassword, HttpServletResponse resp) throws IOException, SQLException {
        User user =  userService.userLogin(userName,userPassword);
//        String s = JSONArray.fromObject(user).toString();
//        resp.getWriter().write(s);
//        resp.getWriter().write("success");
        resp.sendRedirect("page.jsp");

    }



    private void delUserById(String id, HttpServletResponse resp) throws SQLException, IOException {
        String s = userService.delUserById(id);
        resp.getWriter().write(s);

    }

    private void updateUserById(String id,String name,String username,String password,String state, HttpServletResponse resp) throws SQLException, IOException {
        String s = userService.updateUserById(id,name,username,password,state);
        resp.getWriter().write(s);
    }

    public void queryUserByUserName (String userName,HttpServletResponse resp) throws SQLException, IOException {
        User user =  userService.queryUserByUserName(userName);
        String s = JSONArray.fromObject(user).toString();
        resp.getWriter().write(s);
    }


    public void queryAllUser(HttpServletResponse resp) throws SQLException, IOException {
        List<User> users = userService.queryAllUser();
        String s = JSONArray.fromObject(users).toString();
//        System.out.println(s);
        ObjectMapper objectMapper = new ObjectMapper();
        String s1 = objectMapper.writeValueAsString(users);

        resp.getWriter().write(s1);

//        for (User user : users) {
//            System.out.println(user);
//        }
    }

    public void addUser (String userName,String userAccount,String userPassword,String state, HttpServletResponse resp){
//        System.out.println("success");
        try {
            String s = userService.addUser(userName,userAccount,userPassword,state);
            resp.setContentType("text/html;charset=utf-8");
//            resp.sendRedirect("page.jsp");
            resp.getWriter().write(s);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void updateUserById() throws SQLException {
        userService.updateUserById();
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
        String s = userService.selectUser(username, password);
//        System.out.println(s);

//        Cookie cookie = new Cookie("str", s);
//        resp.addCookie(cookie);
//        Cookie[] cookies = req.getCookies();
//        System.out.println(cookies);



//        if(s.equals("success")){
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
            /*
                Application: 作用域范围，整个项目
                Session: 当前会话，默认时长30分钟，可以通过web.xml修改时长
                request: 当前请求，转发之后也可以拿到数据
                page: 当前页面
             */
            //Ajax登录
//            resp.getWriter().write("success");

//        }else {
//            req.setAttribute("info","登录失败，请您重新登录");
            //使用request对象进行转发到index.jsp页面上
//            req.getRequestDispatcher("login.jsp").forward(req,resp);

            //重定向
//            resp.setContentType("text/html;charset=utf-8");
//            resp.getWriter().println("登录失败，请您重新登录");
//            resp.sendRedirect("login.jsp");

            //作用域练习
//            ServletContext servletContext = req.getServletContext();
//            servletContext.setAttribute("info","这是Application");

//            HttpSession session = req.getSession();
//            session.setAttribute("info","这是Session");

//            req.setAttribute("info","这是Requestion");

//            req.getRequestDispatcher("login.jsp").forward(req,resp);
            //Ajax登录
//            resp.getWriter().write("error");

//        }
    }
}
