package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.EvaluateBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.StarBar;


public class CommentListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;

    public CommentListAdapter(Context context) {
        super(R.layout.item_comment_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, EvaluateBean item) {
        Glide.with(jContext).load(URLs.BASE_URL + item.getAvatar()).into((ImageView) helper.getView(R.id.image));
//        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getAvatar(), (ImageView) helper.getView(R.id.image));
//        helper.setText(R.id.name, item.getNickname());
        helper.setText(R.id.satisfaction, item.getSatisfaction_text());
        helper.setText(R.id.commentContent, item.getContent());
        helper.setText(R.id.date, AppUtil.getFormatTime2(item.getCreatetime()));
        StarBar startBar = helper.getView(R.id.star_bar);
        startBar.setStarMark(Float.parseFloat(item.getStart()));
        if (item.getReply() == null) {
            helper.setGone(R.id.bottomLayout, true);
            helper.setGone(R.id.replyContent, false);
            helper.getView(R.id.reply).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else {
            helper.setGone(R.id.bottomLayout, false);
            helper.setGone(R.id.replyContent, true);
            helper.setText(R.id.replyContent, item.getReply().get(0).getContent());
        }
    }
}


