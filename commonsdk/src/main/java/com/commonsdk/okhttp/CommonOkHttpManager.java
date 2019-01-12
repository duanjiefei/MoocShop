package com.commonsdk.okhttp;

import com.commonsdk.okhttp.listener.DataProcessListener;
import com.commonsdk.okhttp.response.CommonJsonCallBack;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class CommonOkHttpManager {

    private static final long CONNECTION_TIME_OUT = 30;

    private static OkHttpClient mOkHttpManager;

    static {
        OkHttpClient.Builder builder  = new OkHttpClient.Builder();

        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        builder.connectTimeout(CONNECTION_TIME_OUT,TimeUnit.SECONDS);
        builder.followRedirects(true);//允许重定向
        builder.readTimeout(CONNECTION_TIME_OUT,TimeUnit.SECONDS);
        builder.writeTimeout(CONNECTION_TIME_OUT,TimeUnit.SECONDS);

        mOkHttpManager = builder.build();

    }

    public static OkHttpClient getmOkHttpManager(){
        return mOkHttpManager;
    }

    public static Call sendGetRequest(Request request, DataProcessListener dataProcessListener){
        Call call = mOkHttpManager.newCall(request);
        call.enqueue(new CommonJsonCallBack(dataProcessListener));
        return call;
    }

    public static Call sendPostRequest(Request request, DataProcessListener dataProcessListener){
        Call call = mOkHttpManager.newCall(request);
        call.enqueue(new CommonJsonCallBack(dataProcessListener));
        return  call;
    }
}
