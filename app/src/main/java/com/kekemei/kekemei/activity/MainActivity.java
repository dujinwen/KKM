package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.fragment.MainMenuLeftFragment;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.view.CircleImageView;
import com.nineoldandroids.view.ViewHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.headIcon)
    CircleImageView headIcon;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.serviceCount)
    TextView serviceCount;
    @BindView(R.id.orderCount)
    TextView orderCount;
    @BindView(R.id.messageLayout)
    LinearLayout messageLayout;
    @BindView(R.id.receiveOrder)
    LinearLayout receiveOrder;
    @BindView(R.id.commentLayout)
    LinearLayout commentLayout;
    @BindView(R.id.orderLayout)
    LinearLayout orderLayout;
    @BindView(R.id.enterAccount)
    LinearLayout enterAccount;
    @BindView(R.id.cashLayout)
    LinearLayout cashLayout;

    /**
     * 导航栏左侧的侧边栏碎片界面
     */
    private MainMenuLeftFragment leftMenuFragment;

    public static void start(Context context, int tab) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.home_left_icon);
        //关闭手势滑动：DrawerLayout.LOCK_MODE_LOCKED_CLOSED（Gravity.LEFT：代表左侧的）
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);

        leftMenuFragment = (MainMenuLeftFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_leftmenu);
        initEvent();
    }

    private void initEvent() {
        //用户图标的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLeftMenu();
            }
        });

        //侧边栏的事件监听
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            /**
             * 当抽屉滑动状态改变的时候被调用
             * 状态值是STATE_IDLE（闲置-0），STATE_DRAGGING（拖拽-1），STATE_SETTLING（固定-2）中之一。
             */
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            /**
             * 当抽屉被滑动的时候调用此方法
             * slideOffset 表示 滑动的幅度(0-1)
             */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.w("onDrawerSlide", "slideOffset=" + slideOffset);//0.0 -- 0.56 -- 1.0

                View mContent = drawerLayout.getChildAt(0);//内容区域view
                View mMenu = drawerView;

                float scale = 1 - slideOffset;

                if (drawerView.getTag().equals("LEFT")) {//左侧的侧边栏动画效果
                    //设置左侧区域的透明度0.6f + 0.4f * (0.0 ... 1.0)【也就是打开的时候透明度从0.6f ... 1.0f，关闭的时候反之】
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * slideOffset);
                    //移动内容区域：左侧侧边栏宽度 * (0.0 ... 1.0)【也就是打开的时候，内容区域移动从0 ... 左侧侧边栏宽度】
                    ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * slideOffset);
                    mContent.invalidate();//重绘view

                } else {//右侧的侧边栏动画效果
                    //移动内容区域：-右侧侧边栏宽度 * (0.0 ... 1.0)【也就是打开的时候，内容区域移动从-0 ... -左侧侧边栏宽度】
                    ViewHelper.setTranslationX(mContent, -mMenu.getMeasuredWidth() * slideOffset);
                    mContent.invalidate();
                }

            }

            /**
             * 当一个抽屉被完全打开的时候被调用
             */
            @Override
            public void onDrawerOpened(View drawerView) {
                if (drawerView.getTag().equals("LEFT")) {//如果感觉显示有延迟的话，可以放到nav_userImg的点击事件监听中执行
                    leftMenuFragment.setDefaultDatas();//打开的时候初始化默认数据【比如：请求网络，获取数据】
                }
            }

            /**
             * 当一个抽屉被完全关闭的时候被调用
             */
            @Override
            public void onDrawerClosed(View drawerView) {
                //关闭手势滑动：DrawerLayout.LOCK_MODE_LOCKED_CLOSED（Gravity.LEFT：代表左侧的）
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);
            }
        });
    }

    /**
     * 打开左侧的侧边栏
     */
    public void OpenLeftMenu() {
        drawerLayout.openDrawer(Gravity.LEFT);
        //打开手势滑动：DrawerLayout.LOCK_MODE_UNLOCKED（Gravity.LEFT：代表左侧的）
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.LEFT);
    }

    @OnClick({R.id.messageLayout, R.id.receiveOrder, R.id.commentLayout, R.id.orderLayout, R.id.enterAccount, R.id.cashLayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.messageLayout:
                MessageActivity.start(this);
                break;
            case R.id.receiveOrder:
                ServiceOrderListActivity.start(this, OrderListBean.ORDER_STATUS_TO_WAIT_SERVER);
                break;
            case R.id.commentLayout:
                CommentActivity.start(this);
                break;
            case R.id.orderLayout:
                ServiceOrderListActivity.start(this);
                break;
            case R.id.enterAccount:
                InComeActivity.start(this);
                break;
            case R.id.cashLayout:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private long lastTime;

    @Override
    public void onBackPressed() {//@TODO 此方法无效
        long currentTime = System.currentTimeMillis();
        long period = currentTime - lastTime;
        if (period < 2 * 1000) {
            super.onBackPressed();
            this.finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        } else {
            ToastUtil.showToastMsg(this, "再按一次退出");
            lastTime = currentTime;
        }
    }
}
