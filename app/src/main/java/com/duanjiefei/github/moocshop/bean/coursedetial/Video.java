package com.duanjiefei.github.moocshop.bean.coursedetial;

import com.duanjiefei.github.moocshop.bean.home.MonitorData;

import java.util.ArrayList;

public class Video {
    public String resource;
    public String adid;
    public String clickUrl;

    public ArrayList<MonitorData> clickMonitor;
    public ArrayList<MonitorData> startMonitor;
    public ArrayList<MonitorData> middleMonitor;
    public ArrayList<MonitorData> endMonitor;
}
