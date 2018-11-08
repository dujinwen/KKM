package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.NewPeopleBean;
import com.hualong.kekemei.fragment.CityFragment;
import com.hualong.kekemei.fragment.HomeFragment;
import com.hualong.kekemei.fragment.MessageFragment;
import com.hualong.kekemei.fragment.PersonFragment;
import com.hualong.kekemei.utils.ShowPopupWindow;
import com.hualong.kekemei.utils.ToastUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.utils.UserHelp;
import com.hualong.kekemei.view.CustomDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.sina.weibo.sdk.utils.LogUtil;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import java.net.URL;
import java.security.interfaces.ECKey;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
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
    private View iv_btn_lingqu;
    private AlertDialog dlg;
    private CustomDialog mDialog;
    private CustomDialog.Builder builder;
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
        //        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
        //                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
        //            //开启定位权限,200是标识码
        //            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        //        } else {
        //            AppUtil.getUserPoint(getApplicationContext(), this);
        //            Toast.makeText(MainActivity.this, "已开启定位权限", Toast.LENGTH_LONG).show();
        //        }

        initCouponsView();

    }

    private void initCouponsView() {
        OkGo.<String>get(URLs.PROJECT_NEW_PEOPLE).params("user_id", UserHelp.getUserId(this)).params("page", 1)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        NewPeopleBean newPeopleBean = gson.fromJson(response.body(), NewPeopleBean.class);
                        Intent intent = null;
                        if (newPeopleBean.getData().getIsnew() == 0) {
                            showDIYDialog();
                        } else {

                        }

                    }
                });
    }

    public void showDIYDialog() {
        builder = new CustomDialog.Builder(MainActivity.this);
        builder.setTvOneName("￥8");
        builder.setTvOneNeirong("红包");
        mDialog = builder
                .setSingleButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OkGo.<String>get(URLs.COUPON_ONE_RECEIVE)
                                .params("user_id", UserHelp.getUserId(MainActivity.this))
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        LogUtil.d("MAINACTIVITY", response.body().toString());
                                    }
                                                });
                        mDialog.dismiss();
                    }
                })
                .createDialog(MainActivity.this,1);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.show();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
