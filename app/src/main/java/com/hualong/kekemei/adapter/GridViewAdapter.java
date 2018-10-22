package com.hualong.kekemei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hualong.kekemei.R;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/22.
 */

/**GirdView 数据适配器*/
public class GridViewAdapter extends BaseAdapter {
    Context context;
//    List<CityItem> list;
    public GridViewAdapter(Context _context) {
//        this.list = _list;
        this.context = _context;
    }

    @Override
    public int getCount() {
//        return list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
//        return list.get(position);
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item, null);
        TextView tvCity = (TextView) convertView.findViewById(R.id.tvCity);
        TextView tvCode = (TextView) convertView.findViewById(R.id.tvCode);
//        CityItem city = list.get(position);
//
//        tvCity.setText(city.getCityName());
//        tvCode.setText(city.getCityCode());
        return convertView;
    }
}

