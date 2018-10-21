package com.hualong.kekemei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.activity.AddCommentActivity;
import com.hualong.kekemei.adapter.base.BaseListViewAdapter;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * 提交评价上传图片
 */
public class GridImageAdapter extends BaseListViewAdapter {

    public GridImageAdapter(Context context) {
        super(context);
    }

    public int getCount() {
        if (infos.size() == AddCommentActivity.MAX_PIC) {
            return AddCommentActivity.MAX_PIC;
        }
        return (infos.size() + 1);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.comment_pic_item, parent, false);
        ImageView evaluate_pic = convertView.findViewById(R.id.evaluate_pic);
        ImageView ivDelete = convertView.findViewById(R.id.ivDelete);
        if (position == infos.size()) {
            ivDelete.setVisibility(View.GONE);
            evaluate_pic.setImageResource(R.mipmap.evaluate_add_photo);
            if (position == 10) {
                evaluate_pic.setVisibility(View.GONE);
            }
        } else {
            ivDelete.setVisibility(View.VISIBLE);
            String item = (String) getItem(position);
            ImageLoaderUtil.getInstance().loadImage(item, evaluate_pic);
        }
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }
}
