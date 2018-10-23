package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.view.CheckBoxSample;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by peiyangfan on 2018/10/23.
 */

public class PayActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.order_id)
    TextView orderId;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_order_icon)
    ImageView ivOrderIcon;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_jia)
    TextView tvJia;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.tv_youhuiquan_num)
    TextView tvYouhuiquanNum;
    @BindView(R.id.ll_youhuiquan)
    LinearLayout llYouhuiquan;
    @BindView(R.id.tv_red_bao_num)
    TextView tvRedBaoNum;
    @BindView(R.id.ll_red_bao)
    LinearLayout llRedBao;
    @BindView(R.id.tv_man_jian_hint)
    TextView tvManJianHint;
    @BindView(R.id.tv_man_jian_num)
    TextView tvManJianNum;
    @BindView(R.id.ll_man_jian)
    LinearLayout llManJian;
    @BindView(R.id.iv_check_wechat)
    CheckBoxSample ivCheckWechat;
    @BindView(R.id.iv_check_ali)
    CheckBoxSample ivCheckAli;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.btn_pay)
    Button btnPay;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_add, R.id.ll_red_bao, R.id.ll_man_jian, R.id.iv_check_wechat, R.id.iv_check_ali, R.id.btn_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_add:
                break;
            case R.id.ll_red_bao:
                break;
            case R.id.ll_man_jian:
                break;
            case R.id.iv_check_wechat:
                ivCheckWechat.toggle();
                break;
            case R.id.iv_check_ali:
                ivCheckAli.toggle();
                break;
            case R.id.btn_pay:
                break;
        }
    }
}
