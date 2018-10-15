package com.hualong.kekemei;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.amap.api.location.AMapLocationClient;
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

        AMapLocationClient.setApiKey("6159adc2dcc7373849ef0633357a7f62");
    }

}

