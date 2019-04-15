package com.duanjiefei.github.moocshop.netbase.activity;

import android.app.Activity;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.duanjiefei.github.moocshop.R;

public class NetHomeActivity extends Activity implements View.OnClickListener {
    private FloatingActionButton fac;
    private RadioGroup tab_one_page;
    private RadioGroup tab_two_page;
    private boolean one_page_visible = true;
    private RadioButton tab_one_page_home;
    private RadioButton tab_one_page_pond;
    private RadioButton tab_two_page_message;
    private RadioButton tab_two_page_mine;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout_test);
        initView();
        initListener();
    }

    private void initListener() {
        fac.setOnClickListener(this);
        tab_one_page.setOnClickListener(this);
        tab_two_page.setOnClickListener(this);
    }


    private void initView() {
        fac = findViewById(R.id.fac);
        tab_one_page = findViewById(R.id.one_page);
        tab_one_page_home = findViewById(R.id.tab_home);
        tab_one_page_pond = findViewById(R.id.tab_pond);
        tab_one_page_home.setChecked(true);

        tab_two_page = findViewById(R.id.two_page);
        tab_two_page_message = findViewById(R.id.tab_message);
        tab_two_page_mine = findViewById(R.id.tab_mine);
        tab_two_page_message.setChecked(true);

        updateTable(one_page_visible);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fac:
                one_page_visible = !one_page_visible;
                updateTable(one_page_visible);
                break;
            case R.id.one_page:
                break;
            case R.id.two_page:
                break;
        }
    }

    private void updateTable(boolean one_page_visible) {
        if (one_page_visible){

            startAnimation(tab_two_page,R.anim.tab_translate_animation_hide);
            tab_two_page.setVisibility(View.GONE);

            startAnimation(tab_one_page,R.anim.tab_translate_animation_show);
            tab_one_page.setVisibility(View.VISIBLE);


        }else {
            startAnimation(tab_one_page,R.anim.tab_translate_animation_hide);
            tab_one_page.setVisibility(View.GONE);


            startAnimation(tab_two_page,R.anim.tab_translate_animation_show);
            tab_two_page.setVisibility(View.VISIBLE);
        }
    }

    private void startAnimation(View view, int res) {
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,res);
        view.startAnimation(animation);
    }


}
