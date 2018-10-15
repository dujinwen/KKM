package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.flowlayouttag.FlowLayout;
import com.hualong.kekemei.R;
import com.hualong.kekemei.view.XEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListSearchActivity extends BaseActivity {
    @BindView(R.id.editTextSearch)
    XEditText editTextSearch;
    @BindView(R.id.txtSearch)
    TextView txtSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_order_list_search)
    RecyclerView rvOrderListSearch;
    @BindView(R.id.hot_flowLayout)
    FlowLayout hotFlowLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.order_list_search_activity;
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
    protected void initData() {
        super.initData();
    }
}
