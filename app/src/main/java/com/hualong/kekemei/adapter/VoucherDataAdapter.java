package com.hualong.kekemei.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.CouponDataBean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class VoucherDataAdapter extends BaseQuickAdapter<CouponDataBean.DataBean.CouponBean, BaseViewHolder> {
    public VoucherDataAdapter() {
        super(R.layout.layout_voucher);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponDataBean.DataBean.CouponBean item) {

    }
}
