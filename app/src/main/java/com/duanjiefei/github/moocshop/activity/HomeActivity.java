package com.duanjiefei.github.moocshop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.duanjiefei.github.moocshop.R;
import com.duanjiefei.github.moocshop.activity.base.BaseActivity;
import com.duanjiefei.github.moocshop.fragement.HomeFragment;
import com.duanjiefei.github.moocshop.fragement.MessageFragment;
import com.duanjiefei.github.moocshop.fragement.MineFragment;
import com.duanjiefei.github.moocshop.fragement.PondFragment;


public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "HomeActivity";
    private RelativeLayout content_layout;
    private LinearLayout tab_layout;

    private LinearLayout home_view;
    private ImageView home_view_img;

    private LinearLayout pond_view;
    private ImageView pond_view_img;

    private LinearLayout message_view;
    private ImageView message_view_img;

    private LinearLayout mine_view;
    private ImageView mine_view_img;


    private FragmentManager fm;

    private HomeFragment homeFragment;
    private PondFragment pondFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

    private Fragment mCurrentFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();

    }

    private void initView() {
        home_view = findViewById(R.id.home_view);
        home_view.setOnClickListener(this);
        home_view_img =  findViewById(R.id.home_img_view);

        pond_view = findViewById(R.id.pond_view);
        pond_view.setOnClickListener(this);
        pond_view_img = findViewById(R.id.pond_img_view);

        message_view = findViewById(R.id.message_view);
        message_view.setOnClickListener(this);
        message_view_img = findViewById(R.id.message_img_view);

        mine_view = findViewById(R.id.mine_view);
        mine_view.setOnClickListener(this);
        mine_view_img = findViewById(R.id.mine_img_view);

        home_view_img.setImageResource(R.mipmap.comui_tab_home_selected);

        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,homeFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId()){
            case R.id.home_view:
                home_view_img.setImageResource(R.mipmap.comui_tab_home_selected);
                pond_view_img.setImageResource(R.mipmap.comui_tab_pond);
                message_view_img.setImageResource(R.mipmap.comui_tab_message);
                mine_view_img.setImageResource(R.mipmap.comui_tab_person);

                hideFragment(pondFragment,ft);
                hideFragment(messageFragment,ft);
                hideFragment(mineFragment,ft);

                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    ft.add(R.id.content_layout,homeFragment);
                }else {
                    mCurrentFragment = homeFragment;
                    ft.show(homeFragment);
                }
                break;
            case R.id.pond_view:
                home_view_img.setImageResource(R.mipmap.comui_tab_home);
                pond_view_img.setImageResource(R.mipmap.comui_tab_pond_selected);
                message_view_img.setImageResource(R.mipmap.comui_tab_message);
                mine_view_img.setImageResource(R.mipmap.comui_tab_person);

                hideFragment(homeFragment,ft);
                hideFragment(messageFragment,ft);
                hideFragment(mineFragment,ft);

                if (pondFragment == null){
                    pondFragment = new PondFragment();
                    ft.add(R.id.content_layout,pondFragment);
                }else {
                    mCurrentFragment = pondFragment;
                    ft.show(pondFragment);
                }
                break;
            case R.id.message_view:
                home_view_img.setImageResource(R.mipmap.comui_tab_home);
                pond_view_img.setImageResource(R.mipmap.comui_tab_pond);
                message_view_img.setImageResource(R.mipmap.comui_tab_message_selected);
                mine_view_img.setImageResource(R.mipmap.comui_tab_person);

                hideFragment(homeFragment,ft);
                hideFragment(pondFragment,ft);
                hideFragment(mineFragment,ft);

                if (messageFragment == null){
                    messageFragment = new MessageFragment();
                    ft.add(R.id.content_layout,messageFragment);
                }else {
                    mCurrentFragment = messageFragment;
                    ft.show(messageFragment);
                }
                break;
            case R.id.mine_view:
                home_view_img.setImageResource(R.mipmap.comui_tab_home);
                pond_view_img.setImageResource(R.mipmap.comui_tab_pond);
                message_view_img.setImageResource(R.mipmap.comui_tab_message);
                mine_view_img.setImageResource(R.mipmap.comui_tab_person_selected);


                hideFragment(homeFragment,ft);
                hideFragment(pondFragment,ft);
                hideFragment(messageFragment,ft);

                if (mineFragment == null){
                    mineFragment = new MineFragment();
                    ft.add(R.id.content_layout,mineFragment);
                }else {
                    mCurrentFragment = mineFragment;
                    ft.show(mineFragment);
                }
                break;
            default:
                    break;
        }
        ft.commit();
    }

    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null){
            ft.hide(fragment);
        }
    }
}
