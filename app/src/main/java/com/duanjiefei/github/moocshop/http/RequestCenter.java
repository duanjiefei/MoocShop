package com.duanjiefei.github.moocshop.http;


import modle.UserBean;
import com.commonsdk.okhttp.listener.DataProcessListener;
import com.commonsdk.okhttp.response.ResposeHandleListener;

import com.commonsdk.okhttp.request.RequestParams;

import static com.commonsdk.okhttp.CommonOkHttpManager.sendGetRequest;
import static com.commonsdk.okhttp.request.CommonRequest.createGetRequest;


public class RequestCenter {

    private static final String USER_URL = "http://www.mocky.io/v2/5c36035e300000780021b746";

    public static void SendRequest(String url, RequestParams params, ResposeHandleListener listener,Class clz){
        sendGetRequest(createGetRequest(url,params),new DataProcessListener(listener,clz));
    }

    public static void SendUserRequest(ResposeHandleListener listener){
        SendRequest(USER_URL,null,listener,UserBean.class);
    }
}
