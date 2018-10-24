package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.GridViewAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created 美容师介绍 by peiyangfan on 2018/10/22.
 */

public class MeiRongShiJieShaoActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.jiedan_num)
    TextView jiedanNum;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.jiguan)
    TextView jiguan;
    @BindView(R.id.techang)
    TextView techang;
    @BindView(R.id.jianjie)
    TextView jianjie;
    @BindView(R.id.grid)
    GridView gridView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_meirongshijieshao;
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



        setGridView();
    }

    /**设置GirdView参数，绑定数据*/
    private void setGridView() {
//        int size = cityList.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
//        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                4, LinearLayout.LayoutParams.MATCH_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setColumnWidth(itemWidth); // 设置列表项宽
        gridView.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(4); // 设置列数量=列表集合数

        GridViewAdapter adapter = new GridViewAdapter(getApplicationContext());
        gridView.setAdapter(adapter);
    }
}
