package com.hualong.kekemei.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.Utills.SPUtils;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.ShopBean;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;

import java.util.List;

public class ShopListAdapter extends BaseQuickAdapter<ShopBean, BaseViewHolder> {
    private Context mContext;

    public ShopListAdapter(Context mContext, int layoutResId, @Nullable List<ShopBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @SuppressLint("NewApi")
    @Override
    protected void convert(BaseViewHolder helper, ShopBean item) {
        helper.setText(R.id.tv_name, item.getName());
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.iv_shop_pic));
        helper.setText(R.id.tv_juli,
                "距离" +
                        AppUtil.getDistance(
                                Double.parseDouble(SPUtils.getString(mContext, "latitude", "")),
                                Double.parseDouble(SPUtils.getString(mContext, "longitude", "")),
                                Double.parseDouble(item.getLatitude()),
                                Double.parseDouble(item.getLongitude())) + "M");
//        LinearLayout view = helper.getView(R.id.ll_pingjia);
//        int size = item.getTag_text().size();
//        if (size != 0) {
//            view.setVisibility(View.VISIBLE);
//            for (int i = 0; i < size; i++) {
//                TextView textView = new TextView(mContext);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                params.setMargins(0,AppUtil.px2dip(mContext,27),AppUtil.px2dip(mContext,30),0);
//                textView.setLayoutParams(params);
//                textView.setText(item.getTag_text().get(i));
//                textView.setTextSize(AppUtil.px2dip(mContext,29));
//                textView.setPadding(AppUtil.px2dip(mContext,7), AppUtil.px2dip(mContext,4), AppUtil.px2dip(mContext,9), AppUtil.px2dip(mContext,4));
//                textView.setTextColor(mContext.getResources().getColor(R.color.FF7AD2D2, null));
//                textView.setBackgroundResource(R.drawable.btn_blue_with_corners_background);
//                view.addView(textView);
//            }
//        } else {
//            view.setVisibility(View.GONE);
//        }

        helper.addOnClickListener(R.id.ll_shop_list_item);
        StarBar star_bar = helper.getView(R.id.star_bar);
        star_bar.setStarMark(2.5f);
    }
}
