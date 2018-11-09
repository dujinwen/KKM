package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.FeedBackActivity;
import com.kekemei.kekemei.activity.HelpCenterActivity;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.view.SectionRowView;

import butterknife.BindView;

/**
 * 设置页面
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.txtSafely)
    SectionRowView safelySetting;
    @BindView(R.id.txtFeedBack)
    SectionRowView feedBack;
    @BindView(R.id.txtHelpCenter)
    SectionRowView helpCenter;
    @BindView(R.id.txtAboutUs)
    SectionRowView aboutUs;
    @BindView(R.id.txtCleanMemory)
    SectionRowView cleanMemory;
    @BindView(R.id.txtVersion)
    SectionRowView version;

    public static void start(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText("设置");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        version.setContentTxt("V" + AppUtil.getVersionName(this));

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedBackActivity.start(SettingActivity.this);
            }
        });

        helpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpCenterActivity.start(SettingActivity.this);
            }
        });
    }
}
