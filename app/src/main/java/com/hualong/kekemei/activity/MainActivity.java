package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hualong.kekemei.R;
import com.hualong.kekemei.fragment.CityFragment;
import com.hualong.kekemei.fragment.HomeFragment;
import com.hualong.kekemei.fragment.MessageFragment;
import com.hualong.kekemei.fragment.PersonFragment;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;
import com.startsmake.mainnavigatetabbar.widget.TabBarCallback;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    public static final int TAB_HOME = 0;
    private static final String KEY_TAB = "tab";

    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "附近";
    //    private static final String TAG_PAGE_PUBLISH = "预约";
    private static final String TAG_PAGE_MESSAGE = "会员";
    private static final String TAG_PAGE_PERSON = "我的";

    @BindView(R.id.mainTabBar)
    MainNavigateTabBar mNavigateTabBar;

    private int mCurrentTab = TAB_HOME;

    public static void start(Context context, int tab) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_TAB, tab);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        getIntentData(intent);
    }

    private void getIntentData(Intent intent) {
        if (intent != null) {
            mCurrentTab = intent.getIntExtra(KEY_TAB, mCurrentTab);
            mNavigateTabBar.setCurrentSelectedTab(mCurrentTab);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mNavigateTabBarAddTab();
    }

    private void mNavigateTabBarAddTab() {
        mNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.home_shouye_btn_n, R.mipmap.home_shouye_btn_d, TAG_PAGE_HOME));
        mNavigateTabBar.addTab(CityFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.home_faxian_btn_n, R.mipmap.home_faxian_btn_d, TAG_PAGE_CITY));
        //        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(MessageFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.home_dingdan_btn_n, R.mipmap.home_dingdan_btn_d, TAG_PAGE_MESSAGE));
        mNavigateTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.home_wode_btn_n, R.mipmap.home_wode_btn_d, TAG_PAGE_PERSON));
        mNavigateTabBar.setCallBack(new TabBarCallback() {
            @Override
            public void goToOrder() {
                startActivity(new Intent(MainActivity.this, OrderListActivity.class));
            }
        });
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
