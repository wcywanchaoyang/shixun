package com.hqyj.controller;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.hqyj.pojo.Info;
import com.hqyj.service.InfoService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet({"/info","/info/selectCurYingqing","/selectPName","/selectyiqingPName","/info/selectFiveConfrimByPName"})
public class InfoController extends HttpServlet {

    InfoService infoService =  new InfoService();
    //增加功能
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
//        System.out.println(method);
        if (method.equals("Confirm")){
            int i = selectConfirm();
            String s = JSONArray.fromObject(i).toString();
            String substring = s.substring(1, 6);
//            System.out.println(substring);
            resp.getWriter().write(substring);
        }else if (method.equals("selectCurYingqing")){
            List<HashMap<String, Object>> list = selectCurYingqing();
            String s = JSONArray.fromObject(list).toString();
//            System.out.println(s);
            resp.getWriter().write(s);
        }else if (method.equals("selectPName")){
            try {
                List<HashMap<String, Object>> hashMaps = selectPName();
                String s = JSONArray.fromObject(hashMaps).toString();
//                System.out.println(s);
                resp.getWriter().write(s);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if(method.equals("selectyiqingPName")){
            try {

                String pName = req.getParameter("pName");
                List<HashMap<String, Object>> list = selectyiqingPName(pName);
                String s = JSONArray.fromObject(list).toString();
//                System.out.println(pName);
//                System.out.println(s);
                resp.getWriter().write(s);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if(method.equals("selectFiveConfrimByPName")){
            String pName = req.getParameter("pName");
            try {
                HashMap<String, List<Object>> stringListHashMap = selectFiveConfrimByPName(pName);
                String s = JSONArray.fromObject(stringListHashMap).toString();
                System.out.println(s);
                resp.getWriter().write(s);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private HashMap<String, List<Object>> selectFiveConfrimByPName(String pName) throws SQLException {
        return infoService.selectFiveConfrimByPName(pName);
    }

//    private void selectPName(HttpServletResponse resp) throws SQLException, IOException {
//        List<String> list = infoService.selectPName();
//        String s = JSONArray.fromObject(list).toString();
//        System.out.println(s);
//        resp.getWriter().write(s);
//    }
    //List<HashMap<String, Object>>

    private List<HashMap<String, Object>> selectPName() throws SQLException, IOException {
//        List<HashMap<String, Object>> hashMaps = infoService.selectPName();
//        String s = JSONArray.fromObject(hashMaps).toString();
//        System.out.println(s);
//        resp.getWriter().write(s);
        return infoService.selectPName();

    }

    private List<HashMap<String, Object>> selectyiqingPName(String pName) throws SQLException {
        return infoService.selectyiqingPName(pName);
    }

    private int selectConfirm() {
        return infoService.selectConfirm();
    }

//    private void selectCurYingqing(HttpServletResponse resp) throws SQLException, IOException {
//        List<Info> list = infoService.selectCurYingqing();
//        String s = JSONArray.fromObject(list).toString();
////        System.out.println(s);
//
//        resp.getWriter().write(s);
//    }

    public List<HashMap<String,Object>> selectCurYingqing(){
        return infoService.selectCurYingqing();
    }


}
