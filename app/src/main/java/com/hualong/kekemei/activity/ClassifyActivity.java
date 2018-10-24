package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by peiyangfan on 2018/10/24.
 */

public class ClassifyActivity extends BaseActivity {


    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.fenlei)
    ImageView fenlei;
    @BindView(R.id.tv_meirong)
    TextView tvMeirong;
    @BindView(R.id.v_meirong)
    View vMeirong;
    @BindView(R.id.tal_meirong)
    LinearLayout talMeirong;
    @BindView(R.id.tv_meiti)
    TextView tvMeiti;
    @BindView(R.id.v_meiti)
    View vMeiti;
    @BindView(R.id.tal_meiti)
    LinearLayout talMeiti;
    @BindView(R.id.tv_yangsheng)
    TextView tvYangsheng;
    @BindView(R.id.v_yangsheng)
    View vYangsheng;
    @BindView(R.id.tal_yangsheng)
    LinearLayout talYangsheng;
    @BindView(R.id.tv_qita)
    TextView tvQita;
    @BindView(R.id.v_qita)
    View vQita;
    @BindView(R.id.tal_qita)
    LinearLayout talQita;
    @BindView(R.id.tv_shaixuan)
    TextView tvShaixuan;
    @BindView(R.id.iv_shaixuan)
    ImageView ivShaixuan;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @Override
    protected int setLayoutId() {
        return R.layout.classify_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        fanhui.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.fanhui, R.id.tal_meirong, R.id.tal_meiti, R.id.tal_yangsheng, R.id.tal_qita, R.id.tv_shaixuan, R.id.iv_shaixuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                break;
            case R.id.tal_meirong:
            case R.id.tal_meiti:
            case R.id.tal_yangsheng:
            case R.id.tal_qita:
                setSelect(view.getId());
                break;
            case R.id.tv_shaixuan:
            case R.id.iv_shaixuan:
                break;
        }
    }

    private void setSelect(int id) {
        tvMeirong.setSelected(id == R.id.tal_meirong);
        vMeirong.setVisibility(id == R.id.tal_meirong ? View.VISIBLE : View.INVISIBLE);

        tvMeiti.setSelected(id == R.id.tal_meiti);
        vMeiti.setVisibility(id == R.id.tal_meiti ? View.VISIBLE : View.INVISIBLE);

        tvYangsheng.setSelected(id == R.id.tal_yangsheng);
        vYangsheng.setVisibility(id == R.id.tal_yangsheng ? View.VISIBLE : View.INVISIBLE);

        tvQita.setSelected(id == R.id.tal_qita);
        vQita.setVisibility(id == R.id.tal_qita ? View.VISIBLE : View.INVISIBLE);
    }
}
