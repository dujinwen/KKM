package com.hualong.kekemei.fragment.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.OrderListBean;
import com.jcloud.image_loader_module.ImageLoaderUtil;


public class OrderListAdapter extends BaseMultiItemQuickAdapter<OrderListBean.PageResultVoBean.ResultBean, BaseViewHolder> {
    private Context jContext;

    public OrderListAdapter(Context context) {
        super(null);
//        addItemType(OrderListBean.ORDER_STATUS_TO_BE_PAID, R.layout.work_order_list_item);
//        addItemType(OrderListBean.ORDER_STATUS_TO_BE_DELIVERED, R.layout.work_order_list_item_deliver);
//        addItemType(OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS, R.layout.work_order_list_item);
//        addItemType(OrderListBean.ORDER_STATUS_FINISHED, R.layout.work_order_list_item);
//        addItemType(OrderListBean.ORDER_STATUS_CANCLE, R.layout.work_order_list_item);
//        addItemType(OrderListBean.ORDER_STATUS_ORTHER, R.layout.work_order_list_item);
        jContext = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderListBean.PageResultVoBean.ResultBean item) {
//        helper.addOnClickListener(R.id.order_id_copy_tv);
//        helper.addOnClickListener(R.id.order_adress_copy_tv);
//        helper.addOnClickListener(R.id.deliver_btn_tv);
//        helper.addOnClickListener(R.id.phone_call_btn);
//        helper.setText(R.id.order_status_tv, item.getOrderStatusView());
//        helper.setText(R.id.order_id_tv,
//                String.format(jContext.getResources().getString(R.string.format_order_id), item.getOrderNo()));
//        String imageUrl = "http:" + item.getOrderItemSkuList().get(0).getSkuImageUrl() + "?img/s/116/116";
//        ImageLoaderUtil.getInstance().loadImage(imageUrl,
//                R.mipmap.lock_icon, (ImageView) helper.getView(R.id.goods_img));
//        helper.setText(R.id.goods_title, item.getOrderItemSkuList().get(0).getItemName());
//        helper.setText(R.id.goods_price, String.format(jContext.getResources().getString(R.string.format_order_price), item.getOrderItemSkuList().get(0).getPaymentPrice()));
//        helper.setText(R.id.goods_count, String.format(jContext.getResources().getString(R.string.format_order_goods_count), item.getOrderItemSkuList().get(0).getNum()));
//        if (item.getOrderStatus() == OrderListBean.ORDER_STATUS_TO_BE_DELIVERED) {
//            helper.setVisible(R.id.deliver_btn_tv, true);
//            helper.setVisible(R.id.deliver_id_tv, false);
//            helper.setVisible(R.id.qr_code_btn, false);
//            helper.setVisible(R.id.deliver_id_et, false);
//            helper.setVisible(R.id.rl_order_deliver, true);
//        }


//        helper.setText(R.id.price_deliver,
//                String.format(jContext.getResources().getString(R.string.format_deliver_price), item.getFreight()));
//        helper.setText(R.id.goods_count_tip,
//                String.format(jContext.getResources().getString(R.string.format_goods_count_tip), item.getSkuNum()));
//        helper.setText(R.id.goods_price_total,
//                String.format(jContext.getResources().getString(R.string.format_order_price), item.getPaymentPrice()));
//        helper.setText(R.id.buyer_name_tv,
//                String.format(jContext.getResources().getString(R.string.format_buyer_name_tv), item.getReceiverName()));
//        helper.setText(R.id.buyer_phone_tv, "电话："+item.getMobile());
//        helper.setText(R.id.buyer_address, String.format(jContext.getResources().getString(R.string.format_adress),
//                item.getFullAddress()));

    }


}


