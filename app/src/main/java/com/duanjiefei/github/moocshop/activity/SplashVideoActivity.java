package com.duanjiefei.github.moocshop.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.activity.base.BaseActivity;
import com.duanjiefei.github.moocshop.view.CountDownTimerView;

import java.io.File;

public class SplashVideoActivity extends BaseActivity {


    private TextView tv_Timer;
    private VideoView vv_Splash;
    private CountDownTimerView countDownTimerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashvideo_layout);
        vv_Splash = findViewById(R.id.vv_splash);
        tv_Timer = findViewById(R.id.tv_splash_timer);

        vv_Splash.setVideoURI(Uri.parse("android.resource://"+getPackageName()+File.separator+R.raw.splash));
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

        countDownTimerView = new CountDownTimerView(5, new CountDownTimerView.ICountDownHandle() {
            @Override
            public void onTicker(int time) {
                tv_Timer.setText(time+"秒");
            }

            @Override
            public void finish() {
                tv_Timer.setText("跳过");
                startActivity(new Intent(SplashVideoActivity.this,HomeActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimerView.startTimer();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimerView.cancle();
    }
}
