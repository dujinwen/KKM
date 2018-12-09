package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.EvaluateBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.StarBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;


public class CommentListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;

    public CommentListAdapter(Context context) {
        super(R.layout.item_comment_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final EvaluateBean item) {
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
            final EditText inputReply = helper.getView(R.id.inputReply);
            helper.getView(R.id.reply).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String inputContent = inputReply.getText().toString();
                    if (StringUtils.isNotEmpty(inputContent)) {
                        reply(inputContent, item.getId() + "");
                    } else {
                        ToastUtil.showToastMsg(jContext, "请输入回复内容");
                    }
                }
            });
        } else {
            helper.setGone(R.id.bottomLayout, false);
            helper.setGone(R.id.replyContent, true);
            helper.setText(R.id.replyContent, item.getReply().get(0).getContent());
        }
    }

    private void reply(String content, String id) {
        OkGo.<String>get(URLs.COMMENT_REPLY).params("comment_id", id).params("beautician_id", UserHelp.getUserId(jContext))
                .params("content", content).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    String data = jsonObject.optString("data");
                    if (msg.equals("暂无数据") || StringUtils.isEmpty(data)) {
                        return;
                    }
                    ToastUtil.showToastMsg(jContext, msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                ToastUtil.showToastMsg(jContext, "回复失败");
            }
        });
    }
}


