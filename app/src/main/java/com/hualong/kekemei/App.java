package com.hualong.kekemei;

import android.app.Application;

import com.hualong.kekemei.init.OkHttpInit;

/**
 * Created by peiyangfan on 2018/10/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();


    }

    private void init() {
        OkHttpInit jOkHttpInit = new OkHttpInit();
        jOkHttpInit.initOkGo(this);
    }


}

