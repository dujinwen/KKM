package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created 分类 by peiyangfan on 2018/10/24.
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
    @BindView(R.id.ll_fanhui)
    LinearLayout llFanhui;
    @BindView(R.id.rv_pinglunbiaoqian)
    RecyclerView rvPinglunbiaoqian;
    @BindView(R.id.ll_pop)
    LinearLayout llPop;
    private PingLunBiaoQianGridViewAdapter pingLunBiaoQianGridViewAdapter;
    private ArrayList<String> objects;


    private static ArrayList<Integer> positionArrayList = new ArrayList();

    @Override
    protected int setLayoutId() {
        return R.layout.classify_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        llFanhui.setVisibility(View.VISIBLE);
        getPingLunBiaoQian();
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
                tvShaixuan.setSelected(false);
                llPop.setVisibility(View.GONE);
                break;
            case R.id.tv_shaixuan:
            case R.id.iv_shaixuan:

                setSelect(view.getId());

                tvShaixuan.setSelected(tvShaixuan.isSelected() ? false : true);
                llPop.setVisibility(llPop.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
        }
    }

    private void getPingLunBiaoQian() {
        //        OkGo.<String>get(URLs.COMMENT_TAG_URL)
        objects = new ArrayList<>();
        objects.add("距离最近");
        objects.add("满意度高");
        objects.add("距离最近");
        objects.add("评论最高");
        objects.add("评星最高");
        objects.add("收藏组多");

        //        pingLunBiaoQianGridViewAdapter.notifyDataSetChanged();
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


    @Override
    protected void initData() {
        super.initData();


        //        rvList.setAdapter(new ClassifyAdater());

        setSelect(R.id.tal_meirong);


        rvPinglunbiaoqian.setLayoutManager(new GridLayoutManager(ClassifyActivity.this, 3));
        pingLunBiaoQianGridViewAdapter = new PingLunBiaoQianGridViewAdapter();
        rvPinglunbiaoqian.setAdapter(pingLunBiaoQianGridViewAdapter);
    }

    private class PingLunBiaoQianGridViewAdapter extends RecyclerView.Adapter<PingLunBiaoQianGridViewAdapter.MyViewHolder> {
        private boolean isClick = false;

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ClassifyActivity.this).inflate(R.layout.item_pinglun, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            holder.tv.setText(objects.get(position));
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isClick) {
                        holder.tv.setBackgroundResource(R.drawable.btn_line_background);
                        holder.tv.setTextColor(0xFF999999);
                    } else {
                        holder.tv.setBackgroundResource(R.mipmap.classification_shaixuan_xuanze_btn_s);
                        holder.tv.setTextColor(0xFF7AD2D2);
                    }

                    savePosition(position);
                    isClick = !isClick;
                }
            });
        }


        @Override
        public int getItemCount() {
            return objects.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.btn_pingjia);
            }

        }
    }

    private void savePosition(int position) {
        if (positionArrayList.contains(position)) {
            positionArrayList.remove(position);
        } else {
            positionArrayList.add(position);
        }
    }
}
