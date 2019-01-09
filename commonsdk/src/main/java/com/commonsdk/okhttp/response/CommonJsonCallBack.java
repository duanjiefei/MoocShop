package com.commonsdk.okhttp.response;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.commonsdk.okhttp.listener.DataProcessListener;
import com.commonsdk.okhttp.exception.OkHttpException;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class CommonJsonCallBack implements Callback {

    private static final String TAG = "CommonJsonCallBack";
    private ResposeHandleListener listener;
    private Class clz;
    private Handler mHandler;


    protected final String EMPTY_MSG = "";
    /**
     * the java layer exception, do not same to the logic error
     */
    protected final int NETWORK_ERROR = -1; // the network relative error
    protected final int JSON_ERROR = -2; // the JSON relative error
    protected final int OTHER_ERROR = -3; // the unknow error


    public CommonJsonCallBack(DataProcessListener dataProcessListener) {
        this.clz = dataProcessListener.clz;
        this.listener = dataProcessListener.resposeHandleListener;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: "+e.getMessage());
                listener.onResponseFailure(new OkHttpException(e.getMessage(),NETWORK_ERROR));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        Log.d(TAG, "onResponse: result  "+result);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    private void handleResponse(Object result) {
        if (result == null || result.toString().trim().equals("")){
            listener.onResponseFailure(new OkHttpException(EMPTY_MSG,NETWORK_ERROR));
            return;
        }

        if (clz == null){
            //直接将返回结果丢给上层处理
            listener.onResponseSucess(result);
        }else {
            //将结果转化为对应的  java 对象类型
            Gson gson = new Gson();
            Object obj  = gson.fromJson(result.toString(),clz);
            if (obj == null){
                //解析失败
                listener.onResponseFailure(new OkHttpException(EMPTY_MSG,JSON_ERROR));
            }else {
                //解析成功
                listener.onResponseSucess(obj);
            }
        }
    }
}
