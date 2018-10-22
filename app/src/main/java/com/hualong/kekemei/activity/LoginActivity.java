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
import android.widget.Toast;

import com.hualong.kekemei.R;
import com.hualong.kekemei.utills.AppUtil;
import com.hualong.kekemei.utills.LogUtil;
import com.hualong.kekemei.utills.ToastUtil;
import com.hualong.kekemei.utills.URLs;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
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
//                sendYanZhengMa();
                chatLogin();
                break;
            case R.id.btn_login:
                // 跳转到聊天界面，开始聊天
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

    public void chatLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EMClient.getInstance().login("pyf", "111111", new EMCallBack() {//回调
                    @Override
                    public void onSuccess() {
                        EMClient.getInstance().groupManager().loadAllGroups();
                        EMClient.getInstance().chatManager().loadAllConversations();
                        LogUtil.d("main", "pyf 登录聊天服务器成功！");
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String message) {
                        LogUtil.d("main", "登录聊天服务器失败！");
                    }
                });
            }
        }).start();

    }

    public void chatLoginOut() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EMClient.getInstance().logout(true, new EMCallBack() {

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(int code, String message) {
                        // TODO Auto-generated method stub

                    }
                });
            }

        }).start();
    }

//    private ProgressDialog mDialog;

    public void createAccount() {

//        mDialog = new ProgressDialog(this);
//        mDialog.setMessage("注册中，请稍后...");
//        mDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    EMClient.getInstance().createAccount("", "");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!LoginActivity.this.isFinishing()) {
//                                mDialog.dismiss();
                            }
                            Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (final HyphenateException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!LoginActivity.this.isFinishing()) {
//                                mDialog.dismiss();
                            }
                            /**
                             * 关于错误码可以参考官方api详细说明
                             * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1_e_m_error.html
                             */
                            int errorCode = e.getErrorCode();
                            String message = e.getMessage();
                            LogUtil.d("lzan13",
                                    String.format("sign up - errorCode:%d, errorMsg:%s", errorCode,
                                            e.getMessage()));
                            switch (errorCode) {
                                // 网络错误
                                case EMError.NETWORK_ERROR:
                                    Toast.makeText(LoginActivity.this,
                                            "网络错误 code: " + errorCode + ", message:" + message,
                                            Toast.LENGTH_LONG).show();
                                    break;
                                // 用户已存在
                                case EMError.USER_ALREADY_EXIST:
                                    Toast.makeText(LoginActivity.this,
                                            "用户已存在 code: " + errorCode + ", message:" + message,
                                            Toast.LENGTH_LONG).show();
                                    break;
                                // 参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册
                                case EMError.USER_ILLEGAL_ARGUMENT:
                                    Toast.makeText(LoginActivity.this,
                                            "参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册 code: "
                                                    + errorCode
                                                    + ", message:"
                                                    + message, Toast.LENGTH_LONG).show();
                                    break;
                                // 服务器未知错误
                                case EMError.SERVER_UNKNOWN_ERROR:
                                    Toast.makeText(LoginActivity.this,
                                            "服务器未知错误 code: " + errorCode + ", message:" + message,
                                            Toast.LENGTH_LONG).show();
                                    break;
                                case EMError.USER_REG_FAILED:
                                    Toast.makeText(LoginActivity.this,
                                            "账户注册失败 code: " + errorCode + ", message:" + message,
                                            Toast.LENGTH_LONG).show();
                                    break;
                                default:
                                    Toast.makeText(LoginActivity.this,
                                            "ml_sign_up_failed code: " + errorCode + ", message:" + message,
                                            Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
