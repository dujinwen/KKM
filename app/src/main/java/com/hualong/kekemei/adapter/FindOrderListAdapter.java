package com.hualong.kekemei.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.DataBean;
import com.hualong.kekemei.bean.HotdataBean;
import com.hualong.kekemei.bean.ProjectListBean;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;


public class FindOrderListAdapter extends BaseQuickAdapter<HotdataBean, BaseViewHolder> {
    private Context jContext;

    public FindOrderListAdapter(Context context) {
        super(R.layout.layout_shop_, null);
        jContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, HotdataBean item) {
        helper.setText(R.id.tv_order_name, item.getName());
        helper.setText(R.id.tv_price, "¥ " + item.getPrice());
        helper.setVisible(R.id.ll_youhuiquan, true);

        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.iv_order_icon));
    }


}


