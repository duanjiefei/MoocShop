package com.commonsdk.okhttp.listener;

import com.commonsdk.okhttp.response.ResposeHandleListener;

public class DataProcessListener  {
    public ResposeHandleListener resposeHandleListener = null;
    public Class clz = null;
    public String responseString = null;

    public DataProcessListener(ResposeHandleListener resposeHandleListener) {
        this.resposeHandleListener = resposeHandleListener;
    }

    /**
     * 直接将返回数据 转化为 用户需要的对象类型
     * @param resposeHandleListener
     * @param clz
     */
    public DataProcessListener(ResposeHandleListener resposeHandleListener, Class clz) {
        this.resposeHandleListener = resposeHandleListener;
        this.clz = clz;
    }

    /***
     * 直接返回 数据，有上层进行具体处理
     * @param resposeHandleListener
     * @param responseString
     */
    public DataProcessListener(ResposeHandleListener resposeHandleListener, String responseString) {
        this.resposeHandleListener = resposeHandleListener;
        this.responseString = responseString;
    }
}
