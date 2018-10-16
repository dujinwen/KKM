package com.hualong.kekemei.activity;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class ShopActivity extends BaseActivity{
    @Override
    protected int setLayoutId() {
        return 0;
    }

    public static void start(Activity context) {
        Intent intent = new Intent(context, ShopActivity.class);
        context.startActivity(intent);
    }
}
