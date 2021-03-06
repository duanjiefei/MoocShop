package com.duanjiefei.github.moocshop.fragement;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.adapter.CourseAdapter;
import com.duanjiefei.github.moocshop.bean.home.DataList;
import com.duanjiefei.github.moocshop.bean.home.RequestData;
import com.duanjiefei.github.moocshop.bean.home.RequestHomeData;
import com.duanjiefei.github.moocshop.http.RequestCenter;
import com.commonsdk.okhttp.response.ResposeHandleListener;

import com.duanjiefei.github.moocshop.bean.user.UserBean;
import com.duanjiefei.github.moocshop.utils.GlideImageUtils;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener {

    private static  final String TAG = "HomeFragment";

    /**
     * UI View
     */
    private View homeContent;
    private TextView mQRCodeView;
    private TextView mSearchView;
    private TextView mCategoryView;
    private ImageView mLoadingView;
    private ListView mHomeListView;

    private RequestHomeData  requestHomeData;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendHomeRequestData();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        homeContent = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        return homeContent;
    }

    private void initView() {
        mQRCodeView = homeContent.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
        mSearchView = homeContent.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
        mCategoryView = homeContent.findViewById(R.id.category_view);
        mCategoryView.setOnClickListener(this);
        mHomeListView =  homeContent.findViewById(R.id.home_list_view);
        mHomeListView.setOnItemClickListener(this);

        mLoadingView = homeContent.findViewById(R.id.loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) mLoadingView.getDrawable();
        animationDrawable.start();
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


    private void sendHomeRequestData() {
        RequestCenter.sendHomeRequest(new ResposeHandleListener() {
            @Override
            public void onResponseFailure(Object object) {
                Log.d(TAG, "onResponseFailure: ");
                showErrorView();
            }

            @Override
            public void onResponseSucess(Object object) {
                Log.d(TAG, "onResponseSucess: ");
                requestHomeData = (RequestHomeData) object;
                showSuccessView();
            }
        });
    }

    //显示请求成功UI
    private void showSuccessView() {
        if (requestHomeData.data.list != null && requestHomeData.data.list.size() > 0) {
            mLoadingView.setVisibility(View.GONE);
            mHomeListView.setVisibility(View.VISIBLE);
            //为listview添加头
            CourseAdapter courseAdapter = new CourseAdapter(addData(), mContext);
            mHomeListView.setAdapter(courseAdapter);
        }
    }

    private ArrayList<DataList> addData() {
        ArrayList<DataList> addData = new ArrayList<>();
        int size = requestHomeData.data.list.size();
        for (int j = 0; j<10; j++){
            for (int i = 0; i < size;i++){
                addData.add(requestHomeData.data.list.get(i));
            }
        }
        return addData;
    }

    private void showErrorView() {
        Toast.makeText(mContext,"数据获取失败",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
