package com.hualong.kekemei.fragment.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.activity.MeiRongShiActivity;
import com.hualong.kekemei.bean.HomeBean;
import com.hualong.kekemei.bean.MeiRongShiListBean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiListAdapter extends BaseQuickAdapter<MeiRongShiListBean.DataBean, BaseViewHolder> {
    private MeiRongShiActivity mContext;

    public MeiRongShiListAdapter(MeiRongShiActivity meiRongShiActivity, int layoutResId, @Nullable List<MeiRongShiListBean.DataBean> data) {
        super(layoutResId, data);
        this.mContext = meiRongShiActivity;
    }

    @SuppressLint("NewApi")
    @Override
    protected void convert(BaseViewHolder helper, MeiRongShiListBean.DataBean item) {
        helper.setText(R.id.tv_name, item.getName());
        LinearLayout view = helper.getView(R.id.ll_pingjia);
        int size = item.getTag_text().size();
        if (size != 0) {
            view.setVisibility(View.VISIBLE);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(0,0,AppUtil.px2dip(mContext,30),0);
                textView.setLayoutParams(params);
                textView.setText(item.getTag_text().get(i));
                textView.setTextSize(AppUtil.px2dip(mContext,29));
                textView.setPadding(AppUtil.px2dip(mContext,7), AppUtil.px2dip(mContext,4), AppUtil.px2dip(mContext,9), AppUtil.px2dip(mContext,4));
                textView.setTextColor(mContext.getResources().getColor(R.color.FF7AD2D2, null));
                textView.setBackgroundResource(R.drawable.btn_blue_with_corners_background);
                view.addView(textView);
            }
        } else {
            view.setVisibility(View.GONE);
        }
    }
}
