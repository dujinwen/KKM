package com.hualong.kekemei.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.hualong.kekemei.R;

/**
 * Created by peiyangfan on 2018/10/15.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected int setLayoutId() {
        return R.layout.activity_login
                ;
    }

        public static void start(Context context) {
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }
}
