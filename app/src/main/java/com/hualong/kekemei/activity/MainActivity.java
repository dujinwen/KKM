package com.hualong.kekemei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.hualong.kekemei.R;
import com.hualong.kekemei.fragment.CityFragment;
import com.hualong.kekemei.fragment.HomeFragment;
import com.hualong.kekemei.fragment.MessageFragment;
import com.hualong.kekemei.fragment.PersonFragment;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "附近";
    private static final String TAG_PAGE_PUBLISH = "预约";
    private static final String TAG_PAGE_MESSAGE = "会员";
    private static final String TAG_PAGE_PERSON = "我的";

    @BindView(R.id.mainTabBar)
    MainNavigateTabBar mNavigateTabBar;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);

        mNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_home, R.mipmap.comui_tab_home_selected, TAG_PAGE_HOME));
        mNavigateTabBar.addTab(CityFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_city, R.mipmap.comui_tab_city_selected, TAG_PAGE_CITY));
        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(MessageFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_message, R.mipmap.comui_tab_message_selected, TAG_PAGE_MESSAGE));
        mNavigateTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_person, R.mipmap.comui_tab_person_selected, TAG_PAGE_PERSON));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }


    public void onClickPublish(View v) {
        Toast.makeText(this, "预约", Toast.LENGTH_LONG).show();
    }
}
