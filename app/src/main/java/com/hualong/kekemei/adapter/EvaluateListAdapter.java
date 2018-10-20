package com.hualong.kekemei.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.bean.EvaluateBean;
import com.hualong.kekemei.view.StarBar;


public class EvaluateListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;

    public EvaluateListAdapter(Context context) {
        super(R.layout.item_evaluate_list_layout, null);
        jContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, EvaluateBean item) {
        /*helper.setText(R.id.name, "222");
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.get(), (ImageView) helper.getView(R.id.icon));
        helper.setText(R.id.content, item.getName());*/
        helper.setText(R.id.commentContent, item.getContent());
        helper.setText(R.id.date, AppUtil.getFormatTime2(item.getCreatetime()));
        StarBar startBar = helper.getView(R.id.star_bar);
        startBar.setStarMark(item.getStart());
    }
}


