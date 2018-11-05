package com.hualong.kekemei.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.CouponDataBean;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class HongBaoDataAdapter extends BaseQuickAdapter<CouponDataBean.DataBean.CouponBean, BaseViewHolder> {
    public HongBaoDataAdapter() {
        super(R.layout.layout_voucher);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponDataBean.DataBean.CouponBean item) {

    }
}
