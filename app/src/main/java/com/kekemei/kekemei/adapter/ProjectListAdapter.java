package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;

public class ProjectListAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    private Context jContext;

    public ProjectListAdapter(Context context) {
        super(R.layout.item_project_list_layout, null);
        jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.tv_order_name, item.getName());
        helper.setText(R.id.tv_price, "¥ " + item.getPrice_discount());
        TextView oldPrice = helper.getView(R.id.tv_old_price);
        oldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
        oldPrice.getPaint().setAntiAlias(true);// 抗锯齿
        helper.setText(R.id.tv_old_price, "¥ " + item.getPrice_market());
        helper.setVisible(R.id.ll_youhuiquan, true);
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.iv_order_icon));
        if (item.getCoupon().size()==0)
            helper.setVisible(R.id.tv_man,false);
        helper.setText(R.id.tv_man,item.getCoupon().get(0));
        if (item.getRedenvelopes().size() == 0)
            helper.setVisible(R.id.tv_jian,false);
        helper.setText(R.id.tv_jian,item.getCoupon().get(0));
    }
}


