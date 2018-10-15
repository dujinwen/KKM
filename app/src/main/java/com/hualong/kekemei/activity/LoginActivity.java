package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/10/15.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.top_bg)
    View topBg;
    @BindView(R.id.et_phone_num)
    EditText etPhoneNum;
    @BindView(R.id.et_yanzhengma)
    EditText etYanzhengma;
    @BindView(R.id.btn_yanzhengma)
    Button btnYanzhengma;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.weixin_login)
    ImageView weixinLogin;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    @BindView(R.id.weibo_login)
    ImageView weiboLogin;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
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
        tvTitle.setText("登录");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yanzhengma:
                break;
            case R.id.btn_login:
                break;
            case R.id.weibo_login:
                break;
            case R.id.weixin_login:
                break;
            case R.id.qq_login:
                break;


        }
    }
}
