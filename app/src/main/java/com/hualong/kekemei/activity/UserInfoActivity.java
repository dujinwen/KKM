package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;

/**
 * 用户中心
 */
public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static void start(Context context) {
        Intent intent = new Intent(context, UserInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setBackgroundColor(Color.parseColor("#00000000"));
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        tv_title.setText("个人资料修改");
        TextView tv_submit = toolbar.findViewById(R.id.tv_submit);
        tv_submit.setVisibility(View.VISIBLE);
    }
}
