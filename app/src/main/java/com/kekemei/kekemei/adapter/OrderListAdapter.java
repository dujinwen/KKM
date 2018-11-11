package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.bean.DataBean;
import com.jcloud.image_loader_module.ImageLoaderUtil;


public class OrderListAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {
    private Context jContext;
    private String showOrHide;

    public OrderListAdapter(Context context) {
        super(R.layout.work_refund_list_item, null);
        jContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        helper.addOnClickListener(R.id.quxiaodingdan);
        helper.addOnClickListener(R.id.chakan);
        helper.addOnClickListener(R.id.querenfuwu);
        helper.addOnClickListener(R.id.lijifukuan);
        helper.addOnClickListener(R.id.zaicigoumai);
        helper.addOnClickListener(R.id.qupingjia);
        helper.addOnClickListener(R.id.cuiwuliu);
        helper.setText(R.id.order_status_tv, item.getState_text());
        helper.setText(R.id.order_id_tv, "222");
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getImage(), (ImageView) helper.getView(R.id.goods_img));
        helper.setText(R.id.goods_title, item.getName());
        helper.setText(R.id.goods_price, "333");
        //个数
        //        helper.setText(R.id.goods_count, item.get);


        setShowOrHide(item.getState(), helper);

    }


    public void setShowOrHide(String showOrHide, BaseViewHolder helper) {
        //状态值:0=待支付,1=待预约,2=待服务,3=待评价,4=完成
        switch (showOrHide) {
            case "0":  //待支付
                helper.setGone(R.id.quxiaodingdan, true);
                helper.setGone(R.id.chakan, false);
                helper.setGone(R.id.querenfuwu, false);
                helper.setGone(R.id.lijifukuan, true);
                helper.setGone(R.id.zaicigoumai, false);
                helper.setGone(R.id.qupingjia, false);
                helper.setGone(R.id.cuiwuliu, false);
                helper.setGone(R.id.yuyue, false);
                break;
            case "1": //待预约
                helper.setGone(R.id.quxiaodingdan, true);
                helper.setGone(R.id.chakan, false);
                helper.setGone(R.id.querenfuwu, false);
                helper.setGone(R.id.lijifukuan, false);
                helper.setGone(R.id.zaicigoumai, false);
                helper.setGone(R.id.qupingjia, false);
                helper.setGone(R.id.cuiwuliu, false);
                helper.setGone(R.id.yuyue, true);
                break;
            case "2": //待服务
                helper.setGone(R.id.quxiaodingdan, true);
                helper.setGone(R.id.chakan, true);
                helper.setGone(R.id.querenfuwu, false);
                helper.setGone(R.id.lijifukuan, false);
                helper.setGone(R.id.zaicigoumai, false);
                helper.setGone(R.id.qupingjia, false);
                helper.setGone(R.id.cuiwuliu, false);
                helper.setGone(R.id.yuyue, true);
                break;
            case "3": //待评价
                helper.setGone(R.id.quxiaodingdan, false);
                helper.setGone(R.id.chakan, false);
                helper.setGone(R.id.querenfuwu, false);
                helper.setGone(R.id.lijifukuan, false);
                helper.setGone(R.id.zaicigoumai, true);
                helper.setGone(R.id.qupingjia, true);
                helper.setGone(R.id.cuiwuliu, false);
                helper.setGone(R.id.yuyue, false);
                break;
            case "4": //完成
                helper.setGone(R.id.quxiaodingdan, false);
                helper.setGone(R.id.chakan, false);
                helper.setGone(R.id.querenfuwu, false);
                helper.setGone(R.id.lijifukuan, false);
                helper.setGone(R.id.zaicigoumai, true);
                helper.setGone(R.id.qupingjia, false);
                helper.setGone(R.id.cuiwuliu, false);
                helper.setGone(R.id.yuyue, true);
                break;
            default:

                break;
        }
    }

}

