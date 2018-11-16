package com.kekemei.kekemei.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.bean.ShopBean;
import com.kekemei.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;

import java.util.List;

public class ShopListAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    private Context mContext;

    public ShopListAdapter(Context mContext, int layoutResId) {
        super(layoutResId, null);
        this.mContext = mContext;
    }

    @SuppressLint("NewApi")
    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        helper.setText(R.id.tv_name, item.getName());
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.iv_shop_pic));
        helper.setText(R.id.tv_juli,
                "距离" +
                        AppUtil.getDistance(
                                Double.parseDouble(SPUtils.getString(mContext, "latitude", "")),
                                Double.parseDouble(SPUtils.getString(mContext, "longitude", "")),
                                Double.parseDouble(item.getLatitude()),
                                Double.parseDouble(item.getLongitude())) + "M");

        StarBar star_bar = helper.getView(R.id.star_bar);
        star_bar.setStarMark(item.getStart());
    }
}
