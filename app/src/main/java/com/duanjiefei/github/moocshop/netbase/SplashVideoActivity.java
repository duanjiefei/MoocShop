package com.duanjiefei.github.moocshop.netbase;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.activity.HomeActivity;
import com.duanjiefei.github.moocshop.activity.base.BaseActivity;
import com.duanjiefei.github.moocshop.netbase.activity.HomeActivity_;
import com.duanjiefei.github.moocshop.netbase.view.CountDownTimerView;
import com.duanjiefei.github.moocshop.netbase.view.FullScreenVideoView;

import java.io.File;

public class SplashVideoActivity extends BaseActivity {


    private TextView tv_Timer;
    private FullScreenVideoView vv_Splash;
    private  SplashTimerPresenter timerPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashvideo_layout);
        initView();
        initData();
        initListener();

        timerPresenter = new SplashTimerPresenter(this);
    }



    private void initData() {
        vv_Splash.setVideoURI(Uri.parse("android.resource://"+getPackageName()+File.separator+R.raw.splash));
    }

    private void initListener() {
        vv_Splash.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        vv_Splash.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        tv_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashVideoActivity.this,HomeActivity_.class));
                finish();
            }
        });


    }

    private void initView() {
        vv_Splash = findViewById(R.id.vv_splash);
        tv_Timer = findViewById(R.id.tv_splash_timer);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerPresenter.cancle();
    }

    public void onTicker(int time) {
        tv_Timer.setText(time+"秒");
        tv_Timer.setEnabled(false);
    }

    public void completed() {
        tv_Timer.setText("跳过");
        tv_Timer.setEnabled(true);
    }
}
