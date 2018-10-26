package com.hualong.kekemei.activity.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.hualong.kekemei.activity.LoginActivity;
import com.hualong.kekemei.activity.MainActivity;

/**
 * Created by zhangshaoming on 2017/12/12.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private final SplashContract.View jSettingView;
    private static final int TIMEOUT_SECONDS = 3000;
    private Context jContext;
    private final int SKIP_NUMBER = 100;
    private boolean isLogin = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startMainPageActivity();
        }
    };

       public SplashPresenter(SplashContract.View view) {
        jSettingView = view;
        jContext = (Context) view;
    }

    private void initApp() {

//        OkGo.<String>post(Urls.UPDATE_PROTECT_STATUS)
//                .params("platformId", 81)
//                .params("id", 385)
//                .params("protectStatus", 0)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        LogUtil.d(response.body().toString());
//                    }
//                });

//        Push.init("2882303761517635501", "5511763534501", "111031", "c71eee8ae7994ca19d76d07e79ee27b4");//小米和魅族的appid
//        Push.register(App.getAppContext());


        skipDelayTime(2000);
    }


    public void skipDelayTime(long time) {
        handler.sendEmptyMessageDelayed(SKIP_NUMBER, time);
    }



    private void startMainPageActivity() {
           jContext.startActivity(new Intent(jContext, MainActivity.class));
    }

    private void startLoginActivity() {
        jContext.startActivity(new Intent(jContext, LoginActivity.class));
    }



    @Override
    public void start() {
        initApp();
    }


}
