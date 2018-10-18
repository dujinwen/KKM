package com.hualong.kekemei.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.HomeBean;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class DAVipAdapter
        extends BaseQuickAdapter<HomeBean.DataBean.ShopBean, BaseViewHolder>

{
    private Context context;

    public DAVipAdapter(Context context) {
        super(R.layout.da_vip_layout, null);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.ShopBean item) {
        helper.setText(R.id.dianpuname, item.getName());
        helper.setText(R.id.pinglunnum, item.getContent()+"条评论");
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item.getImage(),R.mipmap.shop_detail_photo_pic,(ImageView) helper.getView(R.id.iv_shop_pic));
    }

}

