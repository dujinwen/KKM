package com.kekemei.kekemei.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.CreditBean;

public class CreditAdapter extends BaseQuickAdapter<CreditBean.DataBean.IntegralBean, BaseViewHolder> {
    public CreditAdapter() {
        super(R.layout.layout_credit_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, CreditBean.DataBean.IntegralBean item) {
        helper.setText(R.id.tv_price,item.getPrice()+"");
        helper.setText(R.id.tv_date,item.getFinishtime_text());

    }
}
