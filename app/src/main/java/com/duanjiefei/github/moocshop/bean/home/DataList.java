package com.duanjiefei.github.moocshop.bean.home;

import java.util.ArrayList;

public class DataList {


    public int type;
    public String logo;
    public String title;
    public String info;
    public String price;
    public String text;

    public String from;
    public String zan;
    public ArrayList<String> url;

    /**
     * Type 0 特有数据类型字段
     */
    public String site;
    public String resource;
    public String adid;
    public String clickUrl;

    public ArrayList<MonitorData> clickMonitor;
    public ArrayList<MonitorData> startMonitor;
    public ArrayList<MonitorData> middleMonitor;
    public ArrayList<MonitorData> endMonitor;


}
