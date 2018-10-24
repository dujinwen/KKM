package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created "新人优惠券" by peiyangfan on 2018/10/16.
 */

class CouponsActivity extends BaseActivity {
    @BindView(R.id.tv_one_xinxi)
    TextView tvOneXinxi;
    @BindView(R.id.tv_one_name)
    TextView tvOneName;
    @BindView(R.id.tv_one_neirong)
    TextView tvOneNeirong;
    @BindView(R.id.ll_one_red)
    LinearLayout llOneRed;
    @BindView(R.id.tv_tow_xinxi)
    TextView tvTowXinxi;
    @BindView(R.id.tv_name_one_2)
    TextView tvNameOne2;
    @BindView(R.id.tv_neirong_one_2)
    TextView tvNeirongOne2;
    @BindView(R.id.tv_name_tow_2)
    TextView tvNameTow2;
    @BindView(R.id.tv_neirong_tow_2)
    TextView tvNeirongTow2;
    @BindView(R.id.ll_tow_red)
    LinearLayout llTowRed;
    @BindView(R.id.tv_thr_xinxi)
    TextView tvThrXinxi;
    @BindView(R.id.tv_name_one_3)
    TextView tvNameOne3;
    @BindView(R.id.tv_neirong_one_3)
    TextView tvNeirongOne3;
    @BindView(R.id.tv_name_tow_3)
    TextView tvNameTow3;
    @BindView(R.id.tv_neirong_tow_3)
    TextView tvNeirongTow3;
    @BindView(R.id.tv_name_thr_3)
    TextView tvNameThr3;
    @BindView(R.id.tv_neirong_thr_3)
    TextView tvNeirongThr3;
    @BindView(R.id.ll_thr_red)
    LinearLayout llThrRed;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_coupons;
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
}
