package com.hualong.kekemei.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.activity.HuiYuanctivity;
import com.hualong.kekemei.activity.JiFenActivity;
import com.hualong.kekemei.activity.MainActivity;
import com.hualong.kekemei.bean.UserBean;

import java.util.List;

/**
 * Created by caozhimin on 2018/8/6.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;

    private List<UserBean> list;

    public GridAdapter(Context mContext, List<UserBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_status_item, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.order_status_icon);
            viewHolder.name = convertView.findViewById(R.id.order_status_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.icon.setImageResource(list.get(position).getUserIcon());
        viewHolder.name.setText(list.get(position).getUserName());

        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        MainActivity.start(mContext,2);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        mContext.startActivity(new Intent(mContext, JiFenActivity.class));
                        break;
                    case 5:
                        mContext.startActivity(new Intent(mContext, HuiYuanctivity.class));
                        break;
                    case 6:

                        break;
                    default:

                        break;
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
    }
}