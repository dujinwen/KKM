package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.view.SectionRowView;

import butterknife.BindView;

/**
 * 设置页面
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
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
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        tv_title.setText("设置");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
