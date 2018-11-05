package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.platform.comapi.map.J;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.JiFenAdapter;
import com.hualong.kekemei.bean.JiFenBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class JiFenActivity extends BaseActivity {
    @BindView(R.id.rv_jifen_list)
    RecyclerView rvJifenList;
    private JiFenAdapter adapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_jifen;
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

        JiFenBean jiFenBean = new JiFenBean();
        jiFenBean.setZongfen("192929");
        ArrayList<JiFenBean.JIFEN> jifens = new ArrayList<>();
        JiFenBean.JIFEN e = new JiFenBean.JIFEN();
        for (int i = 0; i < 10; i++) {

            e.setData("2019-12-12   12:30");
            e.setPrice("+  10.00");
            jifens.add(e);
        }
        jiFenBean.setJifens(jifens);
        adapter = new JiFenAdapter();
        rvJifenList.setLayoutManager(new LinearLayoutManager(this));
        rvJifenList.setAdapter(adapter);
        rvJifenList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter.setNewData(jiFenBean.getJifens());
        View header_view = getLayoutInflater().inflate(R.layout.hear_jifen, (ViewGroup) rvJifenList.getParent(), false);
        adapter.addHeaderView(header_view);
    }
}
