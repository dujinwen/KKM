package com.hualong.kekemei;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.amap.api.location.AMapLocationClient;
import com.hualong.kekemei.init.OkHttpInit;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by peiyangfan on 2018/10/9.
 */

public class App extends Application {

    {
        PlatformConfig.setWeixin(ApplicationConstant.WX_APP_ID, ApplicationConstant.WX_APP_SECRET);
        PlatformConfig.setQQZone(ApplicationConstant.QQ_APP_ID, ApplicationConstant.QQ_APP_SECRET);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        init();


    }

    private void init() {
        OkHttpInit jOkHttpInit = new OkHttpInit();
        jOkHttpInit.initOkGo(this);

        AMapLocationClient.setApiKey("6159adc2dcc7373849ef0633357a7f62");


//
//        /**
//         * 设置组件化的Log开关
//         * 参数: boolean 默认为false，如需查看LOG设置为true
//         */
//        UMConfigure.setLogEnabled(true);
    }

}

