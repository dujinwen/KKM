package com.hualong.kekemei.activity;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.EvaluateBean;
import com.hualong.kekemei.bean.VoucherData;

import java.util.List;

/**
 * Created by peiyangfan on 2018/11/5.
 */

class VoucherDataAdapter extends BaseQuickAdapter<VoucherData, BaseViewHolder> {
    public VoucherDataAdapter() {
        super(R.layout.layout_voucher);
    }

    @Override
    protected void convert(BaseViewHolder helper, VoucherData item) {

    }
}
