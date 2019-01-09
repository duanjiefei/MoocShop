package com.duanjiefei.github.moocshop.fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.http.RequestCenter;
import com.commonsdk.okhttp.response.ResposeHandleListener;

import modle.UserBean;

public class HomeFragment extends BaseFragment{

    private static  final String TAG = "HomeFragment";

    private View homeContent;
    private TextView home_TextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        homeContent = inflater.inflate(R.layout.fragment_home,container,false);
        home_TextView = homeContent.findViewById(R.id.home_text);
        return homeContent;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        RequestCenter.SendUserRequest(new ResposeHandleListener() {
            @Override
            public void onResponseFailure(Object object) {
                Log.d(TAG, "onResponseFailure: ");
            }

            @Override
            public void onResponseSucess(Object object) {
                Log.d(TAG, "onResponseSucess: ");
                UserBean user  = (UserBean) object;
                home_TextView.setText(user.data.name);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
