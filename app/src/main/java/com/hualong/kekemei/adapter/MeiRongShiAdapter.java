package com.hualong.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BeauticianBean;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class MeiRongShiAdapter extends BaseQuickAdapter<BeauticianBean, BaseViewHolder> {
    private Context context;

    public MeiRongShiAdapter(Context context) {
        super(R.layout.meirongshi_layout, null);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BeauticianBean item) {
        helper.setText(R.id.name, item.getName());
        helper.setText(R.id.num, item.getContent());
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.icon_pic));
    }

}



