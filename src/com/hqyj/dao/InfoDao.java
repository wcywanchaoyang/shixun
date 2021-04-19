package com.hqyj.dao;

import com.hqyj.Utils.JDBCUtils;
import com.hqyj.pojo.Info;
import net.sf.json.JSONArray;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoDao {

    public int selectConfirm() throws SQLException, SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "SELECT SUM(confirmCount) FROM info WHERE time = '2020-04-13' AND areaName is ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, null);

        ResultSet resultSet = preparedStatement.executeQuery();
        int result = 0;
        while (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        return result;
    }

//    public List<Info> selectCurYingqing() throws SQLException {
//        Connection connection = JDBCUtils.getConnection();
//
//        String sql = "SELECT SUM(confirmCount) AS 现有确诊,SUM(curedCount) AS  现有治愈,SUM(deadCount) AS 现有死亡 FROM info WHERE time = '2020-04-13' and areaName is null";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<Info> list = new ArrayList<>();
//        Info info = null;
//
//        while (resultSet.next()){
//            int value1 = resultSet.getInt(1);
//            int value2 = resultSet.getInt(2);
//            int value3 = resultSet.getInt(3);
//
//            //向list中添加数据
//            list.add(new Info("现有确诊",value1));
//            list.add(new Info("现有治愈",value2));
//            list.add(new Info("现有死亡",value3));
//
//        }
//        return list;
//
//    }

    public Info selectCurYingqing() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT sum(confirmCount), sum(curedCount), SUM(deadCount) from info WHERE time = '2020-04-13' AND areaName is ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, null);
        ResultSet resultSet = preparedStatement.executeQuery();
        Info info = new Info();

        while (resultSet.next()) {
            info.setConfirmCount(resultSet.getInt(1));
            info.setCuredCount(resultSet.getInt(2));
            info.setDeadCount(resultSet.getInt(3));
        }
        return info;
    }

//    public List<String> selectPName() throws SQLException {
//        Connection connection = JDBCUtils.getConnection();
//        String sql = "SELECT DISTINCT provinceName FROM info WHERE areaName is ?;";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
////        preparedStatement.setString(1,null);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        Info info = new Info();
//
//        List<String> list = new ArrayList<>();
//
//        while (resultSet.next()) {
//            info.setProvinceName(resultSet.getString(1));
//            list.add(info.getProvinceName());
//        }
//        return list;
//
//    }

    public List<HashMap<String, Object>> setletpName() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT DISTINCT 'provinceName',provinceName FROM info WHERE areaName is ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,null);
        ResultSet resultSet = preparedStatement.executeQuery();

        Info info = new Info();

        List<HashMap<String, Object>> list = new ArrayList<>();


        while (resultSet.next()) {
            HashMap<String, Object> hashMap = new HashMap<>();
            info.setProvinceName(resultSet.getString(2));
//            System.out.println(info.getProvinceName());
            hashMap.put("provinceName", info.getProvinceName());
            list.add(hashMap);

        }
        return list;
    }

    public Info selectyiqingPName(String pName) throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT sum(confirmCount), sum(curedCount), SUM(deadCount) from info WHERE time = '2020-04-13' AND provinceName = ? and areaName is ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,pName);
        preparedStatement.setString(2,null);
        ResultSet resultSet = preparedStatement.executeQuery();

        Info info = new Info();

        while (resultSet.next()) {
            info.setConfirmCount(resultSet.getInt(1));
            info.setCuredCount(resultSet.getInt(2));
            info.setDeadCount(resultSet.getInt(3));
        }
        return info;
    }

    public HashMap<String, List<Object>> selectFiveConfrimByPName(String pName) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT time,areaName,SUM(confirmCount) as confirmCount from info WHERE provinceName = ? and areaName is NOT NULL and time = '2020-04-13' GROUP BY areaName  ORDER BY confirmCount desc LIMIT 5;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,pName);

        ResultSet resultSet = preparedStatement.executeQuery();

        Info info = new Info();
        List<Object> timelist = new ArrayList<>();
        List<Object> arealist = new ArrayList<>();
        List<Object> conFirmCountlist = new ArrayList<>();

        HashMap<String, List<Object>> hashMap = new HashMap<>();

        while (resultSet.next()) {
            info.setTime(resultSet.getString(1));
            info.setAreaName(resultSet.getString(2));
            info.setConfirmCount(resultSet.getInt(3));
            timelist.add(info.getTime());
            arealist.add(info.getAreaName());
            conFirmCountlist.add(info.getConfirmCount());

        }

        hashMap.put("time",timelist);
        hashMap.put("areaName",arealist);
        hashMap.put("data",conFirmCountlist);

        return hashMap;
    }

//    public static void main(String[] args) throws SQLException{
//        InfoDao infoDao = new InfoDao();
//        List<HashMap<String, Object>> hashMaps = infoDao.setletpName();
//        String s = JSONArray.fromObject(hashMaps).toString();
//        infoDao.selectFiveConfrimByPName("重庆");
//        System.out.println(s);
//    }

}
