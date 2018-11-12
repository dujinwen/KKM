package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.VoucherDataAdapter;
import com.kekemei.kekemei.bean.CouponDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class MyVoucherActivity extends BaseActivity {
    private static CouponDataBean couponDataBean;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private VoucherDataAdapter adapter;

    public static void start(Context context, CouponDataBean couponDataBean) {
        MyVoucherActivity.couponDataBean = couponDataBean;
        Intent intent = new Intent(context, MyVoucherActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        tvTitle.setText("代金券");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_my_voucher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        super.initData();

        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VoucherDataAdapter();
        rvList.setAdapter(adapter);
        adapter.addData(couponDataBean.getData());
    }
}
