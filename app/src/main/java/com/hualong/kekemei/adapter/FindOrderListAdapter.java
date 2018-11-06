package com.hualong.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;


public class FindOrderListAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    private Context jContext;

    public FindOrderListAdapter(Context context) {
        super(R.layout.layout_shop_, null);
        jContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.tv_order_name, item.getName());
        helper.setText(R.id.tv_price, "¥ " + item.getPrice_newmember());
        helper.setVisible(R.id.ll_youhuiquan, true);

        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.iv_order_icon));
    }


}


