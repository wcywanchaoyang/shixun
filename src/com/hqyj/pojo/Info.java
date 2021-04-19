package com.hqyj.pojo;

//对应数据表info，描述info表
public class Info {
    private  int code;
    private String time;
    private String provinceName;
    private String areaName;
    private int confirmCount;
    private int curedCount;
    private int deadCount;

    public Info() {
    }

    public Info(int code, String time, String provinceName, String areaName, int confirmCount, int curedCount, int deadCount) {
        this.code = code;
        this.time = time;
        this.provinceName = provinceName;
        this.areaName = areaName;
        this.confirmCount = confirmCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(int confirmCount) {
        this.confirmCount = confirmCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }


}
