package com.duanjiefei.github.moocshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.activity.base.BaseActivity;
import com.duanjiefei.github.moocshop.manager.SPManager;

public class SplashActivity extends BaseActivity {

    private static final  int MSG_EMPTY = 0;
    private boolean isShowGuide = false;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (!isShowGuide){
                startGuideActivity();
            }else {
                startHomeActivity();
            }
            finish();
        }
    };

    private void startGuideActivity() {
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }



    private void startHomeActivity() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_splash_layout);
        initData();
        handler.sendEmptyMessageDelayed(MSG_EMPTY,5000);
    }

    private void initData() {
        isShowGuide = SPManager.getInstance().getBoolean(SPManager.IS_SHOW_GUIDE,false);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



}
