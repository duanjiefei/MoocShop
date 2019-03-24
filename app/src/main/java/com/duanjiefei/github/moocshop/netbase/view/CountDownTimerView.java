package com.duanjiefei.github.moocshop.netbase.view;


import android.os.Handler;

public class CountDownTimerView implements Runnable{
    private int time;//传入的总时间
    private int countDownTime;//剩余时间
    private ICountDownHandle iCountDownHandle;
    private Handler handler;
    private boolean isRun;

    public CountDownTimerView(int time,ICountDownHandle iCountDownHandle) {
        this.time = time;
        countDownTime = time;
        this.iCountDownHandle = iCountDownHandle;
        handler = new Handler();
    }

    public void startTimer(){
        isRun = true;
        iCountDownHandle.onTicker(countDownTime);
        handler.postDelayed(this,1000);
    }

    //通过该方法实现
    @Override
    public void run() {
        if (isRun){
            if (time > 1){
                time --;
                countDownTime = time;
                if (iCountDownHandle!=null){
                    iCountDownHandle.onTicker(countDownTime);
                    handler.postDelayed(this,1000);
                }
            }else {
                if (iCountDownHandle!=null){
                    iCountDownHandle.finish();
                    cancle();
                }
            }
        }
    }

    public void cancle() {
        isRun =false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownHandle{
        void onTicker(int time);
        void finish();
    }
}
