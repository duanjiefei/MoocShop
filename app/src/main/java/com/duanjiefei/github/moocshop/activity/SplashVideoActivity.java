package com.duanjiefei.github.moocshop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.activity.base.BaseActivity;

public class SplashVideoActivity extends BaseActivity {


    private TextView tv_Timer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashvideo_layout);
        tv_Timer = findViewById(R.id.tv_splash_timer);
    }
}
