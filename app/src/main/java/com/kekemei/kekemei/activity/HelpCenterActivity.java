package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kekemei.kekemei.R;
import com.hyphenate.easeui.EaseConstant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 帮助中心页面
 */
public class HelpCenterActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.txtSectionOne)
    TextView txtSectionOne;
    @BindView(R.id.txtSectionTwo)
    TextView txtSectionTwo;
    @BindView(R.id.txtSectionThree)
    TextView txtSectionThree;
    @BindView(R.id.txtContactService)
    TextView txtContactService;

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
        tv_title.setText("帮助中心");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.txtContactService)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txtContactService:
                Intent intent = new Intent(HelpCenterActivity.this, ChatActivity.class);
                // EaseUI封装的聊天界面需要这两个参数，聊天者的username，以及聊天类型，单聊还是群聊
                intent.putExtra("userId", "hjdudu");
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_GROUP);
                startActivity(intent);
                break;
        }
    }
}
