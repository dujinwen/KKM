package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kekemei.kekemei.R;

import butterknife.BindView;

/**
 * 服务订单详情
 */
public class ServiceOrderDetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.orderId)
    TextView orderId;
    @BindView(R.id.orderTime)
    TextView orderTime;
    @BindView(R.id.orderStatus)
    TextView orderStatus;
    @BindView(R.id.serviceProject)
    TextView serviceProject;
    @BindView(R.id.countNum)
    TextView countNum;
    @BindView(R.id.orderPrice)
    TextView orderPrice;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.callPhone)
    ImageView callPhone;


    public static void start(Context context) {
        Intent intent = new Intent(context, ServiceOrderDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_service_order_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText("订单详情");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}