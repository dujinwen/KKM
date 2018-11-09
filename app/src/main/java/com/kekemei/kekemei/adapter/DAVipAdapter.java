package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.ShopBean;
import com.kekemei.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class DAVipAdapter
        extends BaseQuickAdapter<ShopBean, BaseViewHolder>

{
    private Context context;

    public DAVipAdapter(Context context) {
        super(R.layout.da_vip_layout, null);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        helper.setText(R.id.dianpuname, item.getName());
        helper.setText(R.id.pinglunnum, item.getContent()+"条评论");
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item.getImage(),(ImageView) helper.getView(R.id.iv_shop_pic));
    }

}

