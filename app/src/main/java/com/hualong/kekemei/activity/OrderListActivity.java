package com.hualong.kekemei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.ActivityUtils;
import com.hualong.kekemei.bean.OrderListBean;
import com.hualong.kekemei.fragment.OrderListFragment;

import butterknife.BindView;

/**
 * Created by peiyangfan on 2018/10/10.
 */

public class OrderListActivity extends BaseActivity {
    @Override
    protected int setLayoutId() {
        return R.layout.common_content_frag_act;
    }
    OrderListFragment orderListFragment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected View setTitleBar() {
        return toolbar;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setTitle("我的订单");

        orderListFragment = (OrderListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        int orderStatus = OrderListBean.ORDER_STATUS_ALL;
        if (null != getIntent() && null != getIntent().getExtras())
            orderStatus = getIntent().getExtras().getInt(OrderListFragment.ARG_ORDER_STATUS, OrderListBean.ORDER_STATUS_ALL);
        if (orderListFragment == null) {
            orderListFragment = OrderListFragment.newInstance(orderStatus);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    orderListFragment, R.id.contentFrame);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("mDefaultSelectedTab",3);
        startActivity(intent);
    }
}
