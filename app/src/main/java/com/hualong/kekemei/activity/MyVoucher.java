package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.VoucherData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class MyVoucher extends BaseActivity {
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private VoucherData voucherData;
    private BaseQuickAdapter adapter;

    public MyVoucher(VoucherData voucherData) {
        this.voucherData = voucherData;
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
        adapter.addData(voucherData);
    }
}
