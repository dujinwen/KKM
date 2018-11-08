package com.hualong.kekemei.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.CouponDataBean;
import com.hualong.kekemei.bean.HongBaoDataBean;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class HongBaoDataAdapter extends BaseQuickAdapter<HongBaoDataBean.DataBean, BaseViewHolder> {
    public HongBaoDataAdapter() {
        super(R.layout.layout_voucher);
    }

    @Override
    protected void convert(BaseViewHolder helper, HongBaoDataBean.DataBean item) {
        helper.setBackgroundRes(R.id.ll_voucher_bg, R.mipmap.orderform_youhuijuan_youhuijuan_);
        helper.setText(R.id.tv_price, item.getRedenvelopes().getPrice_reduction() + "");
        helper.setText(R.id.data, strSub(item.getRedenvelopes().getActivitytime()) + " — " + strSub(item.getRedenvelopes().getActivitytime_end()));
    }


    private String strSub(String string) {
        return string.substring(0, 11);
    }
}
