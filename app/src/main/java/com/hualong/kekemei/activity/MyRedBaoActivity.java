package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.HongBaoDataAdapter;
import com.hualong.kekemei.bean.CouponDataBean;
import com.hualong.kekemei.bean.HongBaoDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class MyRedBaoActivity extends BaseActivity {
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private static HongBaoDataBean hongBaoDataBean;
    private BaseQuickAdapter adapter;

    public static void start(Context context, HongBaoDataBean hongBaoDataBean) {
        MyRedBaoActivity.hongBaoDataBean = hongBaoDataBean;

        Intent intent = new Intent(context, MyRedBaoActivity.class);
        context.startActivity(intent);
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
        adapter = new HongBaoDataAdapter();
        rvList.setAdapter(adapter);
        adapter.addData(hongBaoDataBean.getData());
    }
}
