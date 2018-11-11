package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.NewPeopleBean;
import com.kekemei.kekemei.fragment.CityFragment;
import com.kekemei.kekemei.fragment.HomeFragment;
import com.kekemei.kekemei.fragment.MessageFragment;
import com.kekemei.kekemei.fragment.PersonFragment;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

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


    private LinearLayout llOneRed;
    private LinearLayout llTowRed;
    private LinearLayout llThrRed;
    private TextView tvOneName,tvOneNeirong,tvNameOne2,tvNeirongOne2,tvNeirongTow2,tvNameTow2
            ,tvNameOne3,tvNeirongOne3,tvNameTow3,tvNeirongTow3,tvNameThr3,tvNeirongThr3;


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
                            showDIYDialog(3);
                        } else {

                        }

                    }
                });
    }
    public void showDIYDialog(int a) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.Dialog);
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.activity_coupons, null);//获取自定义布局
        builder.setView(layout);

        initDialogViiew(layout,a);
        iv_btn_lingqu.setOnClickListener(new View.OnClickListener() {
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

                dlg.dismiss();
            }
        });

        dlg = builder.create();
        dlg.setCanceledOnTouchOutside(false);
        dlg.show();
    }

    private void initDialogViiew(View layout,int type) {
        llOneRed = layout.findViewById(R.id.ll_one_red);
        llTowRed = layout.findViewById(R.id.ll_tow_red);
        llThrRed = layout.findViewById(R.id.ll_thr_red);
        tvOneName = layout.findViewById(R.id.tv_one_name);
        tvNameTow2 = layout.findViewById(R.id.tv_name_tow_2);
        tvNameOne2 = layout.findViewById(R.id.tv_name_one_2);
        tvNameOne3 =  layout.findViewById(R.id.tv_name_one_3);
        tvNameTow3 =  layout.findViewById(R.id.tv_name_tow_3);
        tvNameThr3 = layout.findViewById(R.id.tv_name_thr_3);

        tvOneNeirong = layout.findViewById(R.id.tv_one_neirong);
        tvNeirongOne2 =  layout.findViewById(R.id.tv_neirong_one_2);
        tvNeirongTow2 =  layout.findViewById(R.id.tv_neirong_tow_2);
        tvNeirongOne3 = layout.findViewById(R.id.tv_neirong_one_3);
        tvNeirongTow3 = layout.findViewById(R.id.tv_neirong_tow_3);
        tvNeirongThr3 = layout.findViewById(R.id.tv_neirong_thr_3);
        iv_btn_lingqu = layout.findViewById(R.id.iv_btn_lingqu);


        switch (type) {
            case 1:
                llOneRed.setVisibility(View.VISIBLE);
                llTowRed.setVisibility(View.GONE);
                llThrRed.setVisibility(View.GONE);
                break;
            case 2:
                llOneRed.setVisibility(View.GONE);
                llTowRed.setVisibility(View.VISIBLE);
                llThrRed.setVisibility(View.GONE);
                break;
            case 3:
                llOneRed.setVisibility(View.GONE);
                llTowRed.setVisibility(View.GONE);
                llThrRed.setVisibility(View.VISIBLE);
                break;

            default:

                break;
        }


        setText();
    }
    private void setText() {

//        tvOneName.setText(strOneName);
//        tvOneNeirong.setText(strOneNeirong);
//        tvNameOne2.setText(strNameOne2);
//        tvNeirongOne2.setText(strNeirongOne2);
//        tvNameTow2.setText(strNameTow2);
//        tvNeirongTow2.setText(strNeirongTow2);
//
//        tvNameOne3.setText(strNameOne3);
//        tvNeirongOne3.setText(strNeirongOne3);
//        tvNameTow3.setText(strNameTow3);
//        tvNeirongTow3.setText(strNeirongTow3);
//        tvNameThr3.setText(strNameThr3);
//        tvNeirongThr3.setText(strNeirongThr3);
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