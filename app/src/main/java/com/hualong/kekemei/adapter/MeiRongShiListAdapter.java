package com.hualong.kekemei.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.utills.AppUtil;
import com.hualong.kekemei.bean.BeauticianBean;
import com.hualong.kekemei.view.StarBar;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiListAdapter extends BaseQuickAdapter<BeauticianBean, BaseViewHolder> {
    private Context mContext;

    public MeiRongShiListAdapter(Context mContext, int layoutResId, @Nullable List<BeauticianBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @SuppressLint("NewApi")
    @Override
    protected void convert(BaseViewHolder helper, BeauticianBean item) {
        helper.setText(R.id.tv_name, item.getName());
        LinearLayout view = helper.getView(R.id.ll_pingjia);
        if (item.getTag_text() != null) {
            int size = item.getTag_text().size();
            if (size != 0) {
                view.setVisibility(View.VISIBLE);
                for (int i = 0; i < size; i++) {
                    TextView textView = new TextView(mContext);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, AppUtil.px2dip(mContext, 27), AppUtil.px2dip(mContext, 30), 0);
                    textView.setLayoutParams(params);
                    textView.setText(item.getTag_text().get(i));
                    textView.setTextSize(AppUtil.px2dip(mContext, 29));
                    textView.setPadding(AppUtil.px2dip(mContext, 7), AppUtil.px2dip(mContext, 4), AppUtil.px2dip(mContext, 9), AppUtil.px2dip(mContext, 4));
                    textView.setTextColor(mContext.getResources().getColor(R.color.FF7AD2D2, null));
                    textView.setBackgroundResource(R.drawable.btn_blue_with_corners_background);
                    view.addView(textView);
                }
            } else {
                view.setVisibility(View.GONE);
            }
        }

        StarBar star_bar = helper.getView(R.id.star_bar);
        star_bar.setStarMark(2.5f);
    }
}
