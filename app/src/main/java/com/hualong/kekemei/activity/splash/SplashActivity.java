package com.hualong.kekemei.activity.splash;

import android.os.Bundle;
import android.widget.ImageView;

import com.hualong.kekemei.activity.BaseActivity;

/**
 * Created by zhangshaoming on 2017/12/12.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    private SplashPresenter jSplashPresenter;
    private ImageView iv;


    @Override
    protected void initView(Bundle savedInstanceState) {

        jSplashPresenter = new SplashPresenter(this);
//        iv = findViewById(R.id.iv);
//
//        ImageLoaderUtil.getInstance().loadGifImage(R.mipmap.sp,R.mipmap.sp,iv);
    }

    @Override
    protected int setLayoutId() {
        return 0;
    }

    @Override
    protected void initData() {
        jSplashPresenter.start();
    }



    @Override
    public void setTitle(String title) {

    }

    @Override
    public void finishSP() {
        finish();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {

    }
}
