package com.hualong.kekemei.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.Utills.LogUtil;
import com.hualong.kekemei.fragment.CityFragment;
import com.hualong.kekemei.fragment.HomeFragment;
import com.hualong.kekemei.fragment.MessageFragment;
import com.hualong.kekemei.fragment.PersonFragment;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements AMapLocationListener {
    public static final int TAB_HOME = 0;
    private static final String KEY_TAB = "tab";

    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "发现";
    //    private static final String TAG_PAGE_PUBLISH = "预约";
    private static final String TAG_PAGE_MESSAGE = "订单";
    private static final String TAG_PAGE_PERSON = "我的";

    @BindView(R.id.mainTabBar)
    MainNavigateTabBar mNavigateTabBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private int mCurrentTab = TAB_HOME;
    private boolean hasTitle = false;
    private boolean hasCoupons = false;

    public static void start(Context context, int tab) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_TAB, tab);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    //    @Override
    //    protected View setTitleBar() {
    //        if (hasTitle)
    //            return toolbar;
    //        else
    //            return super.setTitleBar();
    //    }


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
    protected void initData() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            AppUtil.getUserPoint(getApplicationContext(), this);
            Toast.makeText(MainActivity.this, "已开启定位权限", Toast.LENGTH_LONG).show();
        }
        if (hasCoupons)
            initCouponsView();

    }

    private void initCouponsView() {
        startActivity(new Intent(MainActivity.this,CouponsActivity.class));
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
        //        mNavigateTabBar.setTabSelectListener(new MainNavigateTabBar.OnTabSelectedListener() {
        //            @Override
        //            public void onTabSelected(MainNavigateTabBar.ViewHolder holder) {
        //                if (holder.tabIndex == 2 || holder.tabIndex == 6) {
        //                    hasTitle = true;
        //                    tvTitle.setText("订单");
        //                } else {
        //                    hasTitle = false;
        //                }
        //            }
        //        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }


    public void onClickPublish(View v) {
        Toast.makeText(this, "预约", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = amapLocation.getLatitude();//获取纬度
                double longitude = amapLocation.getLongitude();//获取经度
                //                mPoint = new DPoint(latitude,longitude);
                //                loadData();//后续操作
                LogUtil.d("APPLOCALTION", "LATITUDE : " + latitude + " --  LONGITUDE : " + longitude);
                Toast.makeText(MainActivity.this, "LATITUDE : " + latitude + " --  LONGITUDE : " + longitude, Toast.LENGTH_SHORT).show();
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                LogUtil.d("APPLOCALTION", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
                Toast.makeText(MainActivity.this, "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo(), Toast.LENGTH_SHORT).show();

            }
        }

    }
}
