package com.duanjiefei.github.moocshop.application;

import android.app.Application;

public class MoocApplication extends Application {

    private static MoocApplication mApplication =  null;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static MoocApplication getInstance(){
        return mApplication;
    }
}
