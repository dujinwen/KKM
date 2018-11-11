package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.UserInfoBean;
import com.kekemei.kekemei.utils.URLs;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * 用户中心
 */
public class UserInfoActivity extends BaseActivity {
    private static final String EXTRA_KEY_USER_ID = "userId";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_submit)
    TextView tv_submit;

    @BindView(R.id.headIcon)
    ImageView headIcon;

    @BindView(R.id.txtNick)
    EditText txtNick;
    @BindView(R.id.txtSex)
    EditText txtSex;
    @BindView(R.id.txtBirth)
    EditText txtBirth;
    @BindView(R.id.txtSkin)
    EditText txtSkin;
    @BindView(R.id.txtHobby)
    EditText txtHobby;

    private String userId;

    public static void start(Context context, String userId) {
        Intent intent = new Intent(context, UserInfoActivity.class);
        intent.putExtra(EXTRA_KEY_USER_ID, userId);
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
        userId = super.getStringExtraSecure(EXTRA_KEY_USER_ID);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setBackgroundColor(Color.parseColor("#00000000"));
        tv_title.setText("个人资料修改");
        tv_submit.setVisibility(View.VISIBLE);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        OkGo.<String>post(URLs.MY_INFO).params("user_id", userId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                UserInfoBean userInfoBean = gson.fromJson(response.body(), UserInfoBean.class);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + userInfoBean.getData().getAvatar(), headIcon);
                txtNick.setText(userInfoBean.getData().getNickname());
                txtSex.setText(userInfoBean.getData().getNickname());
                txtBirth.setText(userInfoBean.getData().getNickname());
                txtSkin.setText(userInfoBean.getData().getNickname());
                txtHobby.setText(userInfoBean.getData().getNickname());
            }
        });
    }

    private void saveUserInfo(){
        String txtNickText = txtNick.getText().toString();
        String txtSexText = txtSex.getText().toString();
        OkGo.<String>post(URLs.USER_PROFILE).params("user_id", userId).params("username", userId)
                .params("nickname", txtNickText).params("bio", txtSexText)
                .params("avatar", userId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
            }
        });
    }
}
