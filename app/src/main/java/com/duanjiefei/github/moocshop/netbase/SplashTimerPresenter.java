package com.duanjiefei.github.moocshop.netbase;

import android.content.Intent;
import android.view.View;

import com.duanjiefei.github.moocshop.netbase.activity.HomeActivity_;
import com.duanjiefei.github.moocshop.netbase.view.CountDownTimerView;

class SplashTimerPresenter {

    private SplashVideoActivity splashVideoActivity;
    private CountDownTimerView countDownTimerView;

    public SplashTimerPresenter(SplashVideoActivity splashVideoActivity){
        this.splashVideoActivity = splashVideoActivity;
        initTimer();
    }

    private void initTimer() {
        countDownTimerView = new CountDownTimerView(5, new CountDownTimerView.ICountDownHandle() {
            @Override
            public void onTicker(int time) {
                splashVideoActivity.onTicker(time);

            }

            @Override
            public void finish() {
                splashVideoActivity.completed();

            }
        });

        countDownTimerView.startTimer();
    }


    public void cancle() {
        countDownTimerView.cancle();
    }
}
