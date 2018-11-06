package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.view.CheckBoxSample;
import com.hualong.kekemei.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/6.
 */

public class HuiYuanctivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.top_bg)
    View topBg;
    @BindView(R.id.icon)
    CircleImageView icon;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.tv_daoqishijian)
    TextView tvDaoqishijian;
    @BindView(R.id.iv_check_wechat)
    CheckBoxSample ivCheckWechat;
    @BindView(R.id.iv_check_ali)
    CheckBoxSample ivCheckAli;
    @BindView(R.id.btn_pay)
    Button btnPay;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_huiyuan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tvTitle.setText("会员优惠");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });}
}
