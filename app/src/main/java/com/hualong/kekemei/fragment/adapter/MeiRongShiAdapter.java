package com.hualong.kekemei.fragment.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.bean.HomeBean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class MeiRongShiAdapter extends BaseQuickAdapter<HomeBean.DataBean.BeauticianBean, BaseViewHolder> {
    private Context context;

    public MeiRongShiAdapter( Context context) {
        super(R.layout.meirongshi_layout, null);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.BeauticianBean item) {
        helper.setText(R.id.name,item.getName());
        helper.setText(R.id.num,item.getContent());
    }

}


