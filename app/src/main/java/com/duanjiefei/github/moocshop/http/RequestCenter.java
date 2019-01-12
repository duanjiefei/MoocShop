package com.duanjiefei.github.moocshop.http;


import com.commonsdk.okhttp.CommonOkHttpManager;
import com.commonsdk.okhttp.request.CommonRequest;
import com.duanjiefei.github.moocshop.bean.home.RequestHomeData;
import com.duanjiefei.github.moocshop.bean.user.UserBean;
import com.commonsdk.okhttp.listener.DataProcessListener;
import com.commonsdk.okhttp.response.ResposeHandleListener;

import com.commonsdk.okhttp.request.RequestParams;


public class RequestCenter {

    private static  String USER_URL = "http://www.mocky.io/v2/5c36035e300000780021b746";
    private static  String HOME_REQUEST_URL = "http://www.mocky.io/v2/5c3a018c2f00002c00b5dbe4";


    public static void SendRequest(String url, RequestParams params, ResposeHandleListener listener,Class clz){
       CommonOkHttpManager.sendGetRequest(CommonRequest.createGetRequest(url,params),new DataProcessListener(listener,clz));
    }

    public static void sendUserRequest(ResposeHandleListener listener){
        SendRequest(USER_URL,null,listener,UserBean.class);
    }

    public static void sendHomeRequest(ResposeHandleListener listener){
        SendRequest(HOME_REQUEST_URL,null,listener,RequestHomeData.class);
    }
}
