package com.duanjiefei.github.moocshop.fragement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {


    protected static final int CAMERA_CODE = 0;
    protected static final int STORAGE_CODE = 1;
    protected Context mContext;

    public boolean hasPermission(String... permissions){
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(mContext,permission)!=PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    public void requestPermission(int requestCode,String[] permissions){
        if (Build.VERSION.SDK_INT>23){
            requestPermissions(permissions,requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CAMERA_CODE:
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doCamera();
                }
                break;
            case STORAGE_CODE:
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    downLoadFile();
                }
                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected void downLoadFile() {
    }

    protected void doCamera() {
    }
}
