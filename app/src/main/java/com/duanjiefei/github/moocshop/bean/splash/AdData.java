package com.duanjiefei.github.moocshop.bean.splash;

import com.duanjiefei.github.moocshop.bean.home.MonitorData;

import java.util.ArrayList;

public class AdData {
    public String adid;
    public String resourceID;
    public String resource;
    public String clickUrl;

    public ArrayList<MonitorData> clickMonitor;
    public ArrayList<MonitorData> startMonitor;
    public ArrayList<MonitorData> middleMonitor;
    public ArrayList<MonitorData> endMonitor;
}
