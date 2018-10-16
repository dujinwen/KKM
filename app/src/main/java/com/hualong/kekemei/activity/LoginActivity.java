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
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.Utills.LogUtil;
import com.hualong.kekemei.Utills.ToastUtil;
import com.hualong.kekemei.Utills.URLs;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

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
                sendYanZhengMa();
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.weibo_login:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, authListener);
                break;
            case R.id.weixin_login:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.qq_login:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
                break;


        }
    }

    private void sendYanZhengMa() {

        String phoneNum = etPhoneNum.getText().toString().trim();
        if (phoneNum.isEmpty()) {
            ToastUtil.showToastMsg(LoginActivity.this, "请输入手机号");
            return;
        }
        AppUtil.sendYanZhengMa(phoneNum, "login", new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {

            }
        });
    }

    private void login() {
//        AppUtil.checkCaptcha(etPhoneNum.getText().toString().trim(),
//                etYanzhengma.getText().toString().trim(),
//                "login",
//                new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//
//                    }
//                });
        OkGo.<String>get(URLs.MOBILE_LOGIN)
                .params("mobile", etPhoneNum.getText().toString().trim())
                .params("event", "login")
                .params("captcha", etYanzhengma.getText().toString().trim())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }


    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data == null && action == 1) {
                LogUtil.d("LoginActivity", platform + "取消授权成功");
                return;
            }
            if (data != null) {
                String temp = "";
                for (String key : data.keySet()) {
                    temp = temp + key + " : " + data.get(key) + "\n";
                }
                LogUtil.d("LoginActivity", temp);
//                if (platform == SHARE_MEDIA.QQ) {
//                    verifyBind("1", data.get("unionid"));
//                    UMAnalytics.getInstance().sendPoint(UMConstants.THIRD_PARTY_LOGIN, data.get("unionid"), "qq");
//                } else if (platform == SHARE_MEDIA.WEIXIN) {
//                    verifyBind("2", data.get("openid"));
//                    UMAnalytics.getInstance().sendPoint(UMConstants.THIRD_PARTY_LOGIN, data.get("unionid"), "weixin");
//                }
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            if (platform == SHARE_MEDIA.WEIXIN) {
                if (!UMShareAPI.get(LoginActivity.this).isInstall(LoginActivity.this, SHARE_MEDIA.WEIXIN)) {
                    ToastUtil.showToastMsg(LoginActivity.this, "请安装微信客户端");
                    return;
                }
            } else if (platform == SHARE_MEDIA.QQ) {
                if (!UMShareAPI.get(LoginActivity.this).isInstall(LoginActivity.this, SHARE_MEDIA.QQ)) {
                    ToastUtil.showToastMsg(LoginActivity.this, "请安装腾讯QQ客户端");
                    return;
                }
            }
            ToastUtil.showToastMsg(LoginActivity.this, "错误" + t.getMessage());
            LogUtil.e("LoginActivity", t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ToastUtil.showToastMsg(LoginActivity.this, "授权取消");
        }
    };
}
