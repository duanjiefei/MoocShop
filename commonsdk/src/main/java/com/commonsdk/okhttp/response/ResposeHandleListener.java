package com.commonsdk.okhttp.response;

public interface ResposeHandleListener {

    public void onResponseFailure(Object object);
    public void onResponseSucess(Object object);
}
