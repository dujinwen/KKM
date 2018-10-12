package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;

/**
 * 帮助中心页面
 */
public class HelpCenterActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, HelpCenterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_help_center;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        tv_title.setText("帮助中心");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
