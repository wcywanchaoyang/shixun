package com.hqyj.service;

import com.hqyj.dao.InfoDao;
import com.hqyj.pojo.Info;
import net.sf.json.JSONArray;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoService {

    InfoDao infoDao =  new InfoDao();

    public int selectConfirm() {
        try {
            return infoDao.selectConfirm();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

//    public List<Info> selectCurYingqing() throws SQLException {
//        List<Info> list = infoDao.selectCurYingqing();
//
//        return list;
//
//    }

    public List<HashMap<String, Object>> selectCurYingqing() {
        try {
            Info info = infoDao.selectCurYingqing();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", "现有确诊");
            hashMap.put("value", info.getConfirmCount());

            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("name", "现有治愈");
            hashMap2.put("value", info.getCuredCount());

            HashMap<String, Object> hashMap3 = new HashMap<>();
            hashMap3.put("name", "现有死亡");
            hashMap3.put("value", info.getDeadCount());

            List<HashMap<String, Object>> list = new ArrayList<>();
            list.add(hashMap);
            list.add(hashMap2);
            list.add(hashMap3);

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<HashMap<String, Object>> selectyiqingPName(String pName) {
        try {
            Info info = infoDao.selectyiqingPName(pName);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", "现有确诊");
            hashMap.put("value", info.getConfirmCount());

            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("name", "现有治愈");
            hashMap2.put("value", info.getCuredCount());

            HashMap<String, Object> hashMap3 = new HashMap<>();
            hashMap3.put("name", "现有死亡");
            hashMap3.put("value", info.getDeadCount());

            List<HashMap<String, Object>> list = new ArrayList<>();
            list.add(hashMap);
            list.add(hashMap2);
            list.add(hashMap3);

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

//    public List<String> selectPName() throws SQLException {
//       return  infoDao.selectPName();
//    }

    public List<HashMap<String, Object>> selectPName() throws SQLException {
        return  infoDao.setletpName();
    }


    public HashMap<String, List<Object>> selectFiveConfrimByPName(String pName) throws SQLException {
        return infoDao.selectFiveConfrimByPName(pName);
    }
}
