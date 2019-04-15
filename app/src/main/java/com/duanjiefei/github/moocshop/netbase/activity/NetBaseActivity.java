package com.duanjiefei.github.moocshop.netbase.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.duanjiefei.github.moocshop.Constant;
import com.duanjiefei.github.moocshop.netbase.anoation.ViewInject;
import com.duanjiefei.github.moocshop.utils.StatusBarUtil;

public class NetBaseActivity extends AppCompatActivity {

    private final String TAG = NetBaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation!= null){
            int id = annotation.BindViewId();
            if (id > 0){
                setContentView(id);
            }else {
                throw  new RuntimeException("id < 0");
            }
        }else {
            throw  new RuntimeException("the annotation is null");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void hideStatusBar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    /**
     * 改变状态栏颜色
     *
     * @param color
     */
    public void changeStatusBarColor(@ColorRes int color) {
        StatusBarUtil.setStatusBarColor(this, color);
    }

    /**
     * 检查是否有权限
     * @param permissions
     * @return
     */
    public boolean hasPermission(String... permissions){
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(this,permission) !=
                    PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /**
     * 动态申请权限之后的回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case Constant.WRITE_READ_EXTERNAL_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doSDCard();
                }
                break;
        }
    }

    public void doSDCard() {
    }
}
