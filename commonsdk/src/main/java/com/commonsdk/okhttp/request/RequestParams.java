package com.commonsdk.okhttp.request;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 请求参数信息的封装
 */
public class RequestParams {

    public ConcurrentHashMap<String,String>  urlParams = new ConcurrentHashMap<String, String>();
    public ConcurrentHashMap<String,Object>  fileParams = new ConcurrentHashMap<String, Object>();

    public RequestParams() {
    }

    public void put(String key,String value){
        if (key != null && value != null){
            urlParams.put(key,value);
        }
    }

    public void put(String key,Object value){
        if (key != null){
            fileParams.put(key,value);
        }
    }

    public boolean hasParams(){
        if (urlParams.size() > 0 || fileParams.size() > 0){
            return true;
        }
        return false;
    }
}
