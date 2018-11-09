package com.kekemei.kekemei.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.JiFenBean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class JiFenAdapter extends BaseQuickAdapter<JiFenBean.JIFEN, BaseViewHolder> {
    public JiFenAdapter() {
        super(R.layout.layout_jifen);
    }

    @Override
    protected void convert(BaseViewHolder helper, JiFenBean.JIFEN item) {
        helper.setText(R.id.tv_price,item.getPrice());
        helper.setText(R.id.tv_date,item.getData());

    }
}
