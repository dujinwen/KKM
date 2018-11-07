package com.hualong.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.EvaluateBean;
import com.hualong.kekemei.utils.AppUtil;
import com.hualong.kekemei.utils.StringUtils;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.NoScrollGridView;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;

import java.util.Arrays;


public class EvaluateListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;
    private boolean isMyComment;

    public EvaluateListAdapter(Context context, boolean isMyComment) {
        super(isMyComment ? R.layout.item_my_evaluate_list_layout : R.layout.item_evaluate_list_layout, null);
        this.jContext = context;
        this.isMyComment = isMyComment;
    }


    @Override
    protected void convert(BaseViewHolder helper, EvaluateBean item) {
        if (isMyComment) {

        } else {
            /*helper.setText(R.id.name, "222");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.get(), (ImageView) helper.getView(R.id.icon));
            helper.setText(R.id.content, item.getName());*/
        }
        if (StringUtils.isNotEmpty(item.getImages())) {
            String[] split = item.getImages().split(",");
            NoScrollGridView noScrollGridView = helper.getView(R.id.ncgv);
            CommentGridAdapter gridAdapter = new CommentGridAdapter(jContext, Arrays.asList(split));
            noScrollGridView.setAdapter(gridAdapter);
//            gridAdapter.replaceData(Arrays.asList(split));
        }
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getUser_avatar(), (ImageView) helper.getView(R.id.icon));
        helper.setText(R.id.name, item.getNickname());
        helper.setText(R.id.commentContent, item.getContent());
        helper.setText(R.id.date, AppUtil.getFormatTime2(item.getCreatetime()));
        StarBar startBar = helper.getView(R.id.star_bar);
        startBar.setStarMark(Float.parseFloat(item.getStart()));
    }
}


