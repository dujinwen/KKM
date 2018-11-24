package com.kekemei.kekemei.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.BeauticianBean;
import com.kekemei.kekemei.view.StarBar;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiListAdapter extends BaseQuickAdapter<BeauticianBean, BaseViewHolder> {
    private Context mContext;

    public MeiRongShiListAdapter(Context mContext, int layoutResId) {
        super(layoutResId, null);
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
                    String text = item.getTag_text().get(i);
                    if (text!=null&&!text.isEmpty()&&text!="")
                    {TextView textView = new TextView(mContext);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, 9, 10, 0);
                    textView.setLayoutParams(params);
                    textView.setText(text);
                    textView.setTextSize(9);
                    textView.setPadding(3, 2, 3, 2);
                    textView.setTextColor(mContext.getResources().getColor(R.color.FF7AD2D2, null));
                    textView.setBackgroundResource(R.drawable.btn_blue_with_corners_background);
                    view.addView(textView);}
                }
            } else {
                view.setVisibility(View.GONE);
            }
        }
//        helper.addOnClickListener(R.id.ll_meirongshi);
//        helper.addOnClickListener(R.id.btn_buy_now);
        StarBar star_bar = helper.getView(R.id.star_bar);
        star_bar.setStarMark(item.getStart());
    }
}
