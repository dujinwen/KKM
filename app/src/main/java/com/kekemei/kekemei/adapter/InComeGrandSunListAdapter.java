package com.kekemei.kekemei.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.EvaluateBean;


public class InComeGrandSunListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;

    public InComeGrandSunListAdapter(Context context) {
        super(R.layout.item_in_come_grand_sun_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, EvaluateBean item) {
        /*ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getAvatar(), (ImageView) helper.getView(R.id.image));
        helper.setText(R.id.month, item.getNickname());
        helper.setText(R.id.inCome, item.getSatisfaction_text());
        helper.setText(R.id.realInCome, item.getContent());*/
    }
}


