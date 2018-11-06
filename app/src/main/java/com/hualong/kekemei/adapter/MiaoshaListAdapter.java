package com.hualong.kekemei.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;

import java.util.List;

public class MiaoshaListAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    private Context mContext;

    public MiaoshaListAdapter(Context mContext, int layoutResId, @Nullable List<BaseBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @SuppressLint("NewApi")
    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.title, item.getName());
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.icon));
        helper.setText(R.id.price, "￥  "+String.valueOf(item.getPrice_newmember()));
        helper.setText(R.id.costPrice, "￥"+String.valueOf(item.getPrice_market()));
        helper.addOnClickListener(R.id.rootLayout);
    }
}
