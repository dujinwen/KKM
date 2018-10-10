package com.hualong.kekemei.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangshaoming on 2018/1/31.
 */

public class OrderListBean implements Serializable {

    public static final int ORDER_STATUS_ORTHER = -20;     //全部订单
    public static final int ORDER_STATUS_ALL = -10;     //全部订单
    public static final int ORDER_STATUS_TO_BE_PAID = 10;     //待支付
    public static final int ORDER_STATUS_TO_BE_DELIVERED = 20; //待发货
    public static final int ORDER_STATUS_TO_RECEIVE_GOODS = 40; //待收货
    public static final int ORDER_STATUS_FINISHED = 50;      //已完成
    public static final int ORDER_STATUS_CANCLE = 80;


    /**
     * stayPayNum : 0
     * stayDeliverNum : 1
     * partDeliverNum : 0
     * stayReceiptNum : 0
     * stayAssessNum : 0
     * pageResultVo : {"pageNum":1,"pageSize":10,"totalCount":5,"totalPageCount":1,"result":[{"id":null,"platformId":40,"orderNo":1802024011001,"purchaseNo":null,"orderType":1,"paymentType":1,"paymentTypeView":"在线支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010394,"orderTime":1517555641000,"orderTimeStr":"2018-02-02 15:14:01","primitivePrice":null,"totalDiscount":null,"paymentPrice":12,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180202151406921","receiverName":"test","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1802024011001,"skuId":10008359,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/8812c36aa5ae336c2a77bf63211d899a20180117144309670.jpg","altImage":null,"itemId":100001255,"itemName":"测试发布商品","attributes":"2323:2323;","attributeIds":"[{\"vid\":\"6521\",\"aid\":\"2631\"}]","sendPeriod":1,"primitivePrice":null,"num":1,"paymentPrice":12,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":12,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/e68a9471-e17f-4050-af52-f0a515e01ee2.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"11011011011","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000494,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514457670000,"orderTimeStr":"2017-12-28 18:41:10","primitivePrice":null,"totalDiscount":null,"paymentPrice":311,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191759721","receiverName":"张三","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000494,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/c58b88b2-95c2-4a43-bf83-632752ad6851.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"15211112222","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000493,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514457507000,"orderTimeStr":"2017-12-28 18:38:27","primitivePrice":null,"totalDiscount":null,"paymentPrice":111,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191759309","receiverName":"张三","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000493,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/10efd596-8b88-469a-9bbd-be6213968aaf.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"15211112222","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000492,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514456270000,"orderTimeStr":"2017-12-28 18:17:50","primitivePrice":null,"totalDiscount":null,"paymentPrice":555,"modfiyPrice":null,"freight":null,"orderStatus":80,"orderStatusView":"已取消","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191758849","receiverName":"xiaowei","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000492,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":5,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/b930a3c4-6ddd-40c3-b16e-b7619c1c7016.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区东城区西单","mobile":"11011011011","skuNum":5},{"id":null,"platformId":40,"orderNo":1712284011000489,"purchaseNo":null,"orderType":1,"paymentType":1,"paymentTypeView":"在线支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514451974000,"orderTimeStr":"2017-12-28 17:06:14","primitivePrice":null,"totalDiscount":null,"paymentPrice":111,"modfiyPrice":null,"freight":null,"orderStatus":80,"orderStatusView":"已取消","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180104165347854","receiverName":"xiaowei","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000489,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/cca7abc6-f40c-486f-8a19-05e11d3ae1d5.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区东城区西单","mobile":"11011011011","skuNum":1}],"nextPage":2,"lastPage":true,"firstPage":true,"prevPage":1}
     */

    private int stayPayNum;
    private int stayDeliverNum;
    private int partDeliverNum;
    private int stayReceiptNum;
    private int stayAssessNum;
    private PageResultVoBean pageResultVo;

    public int getStayPayNum() {
        return stayPayNum;
    }

    public void setStayPayNum(int stayPayNum) {
        this.stayPayNum = stayPayNum;
    }

    public int getStayDeliverNum() {
        return stayDeliverNum;
    }

    public void setStayDeliverNum(int stayDeliverNum) {
        this.stayDeliverNum = stayDeliverNum;
    }

    public int getPartDeliverNum() {
        return partDeliverNum;
    }

    public void setPartDeliverNum(int partDeliverNum) {
        this.partDeliverNum = partDeliverNum;
    }

    public int getStayReceiptNum() {
        return stayReceiptNum;
    }

    public void setStayReceiptNum(int stayReceiptNum) {
        this.stayReceiptNum = stayReceiptNum;
    }

    public int getStayAssessNum() {
        return stayAssessNum;
    }

    public void setStayAssessNum(int stayAssessNum) {
        this.stayAssessNum = stayAssessNum;
    }

    public PageResultVoBean getPageResultVo() {
        return pageResultVo;
    }

    public void setPageResultVo(PageResultVoBean pageResultVo) {
        this.pageResultVo = pageResultVo;
    }

    public static class PageResultVoBean implements Serializable {
        /**
         * pageNum : 1
         * pageSize : 10
         * totalCount : 5
         * totalPageCount : 1
         * result : [{"id":null,"platformId":40,"orderNo":1802024011001,"purchaseNo":null,"orderType":1,"paymentType":1,"paymentTypeView":"在线支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010394,"orderTime":1517555641000,"orderTimeStr":"2018-02-02 15:14:01","primitivePrice":null,"totalDiscount":null,"paymentPrice":12,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180202151406921","receiverName":"test","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1802024011001,"skuId":10008359,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/8812c36aa5ae336c2a77bf63211d899a20180117144309670.jpg","altImage":null,"itemId":100001255,"itemName":"测试发布商品","attributes":"2323:2323;","attributeIds":"[{\"vid\":\"6521\",\"aid\":\"2631\"}]","sendPeriod":1,"primitivePrice":null,"num":1,"paymentPrice":12,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":12,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/e68a9471-e17f-4050-af52-f0a515e01ee2.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"11011011011","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000494,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514457670000,"orderTimeStr":"2017-12-28 18:41:10","primitivePrice":null,"totalDiscount":null,"paymentPrice":311,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191759721","receiverName":"张三","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000494,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/c58b88b2-95c2-4a43-bf83-632752ad6851.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"15211112222","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000493,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514457507000,"orderTimeStr":"2017-12-28 18:38:27","primitivePrice":null,"totalDiscount":null,"paymentPrice":111,"modfiyPrice":null,"freight":null,"orderStatus":20,"orderStatusView":"待发货","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191759309","receiverName":"张三","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000493,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/10efd596-8b88-469a-9bbd-be6213968aaf.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区朝阳区北辰世纪中心","mobile":"15211112222","skuNum":1},{"id":null,"platformId":40,"orderNo":1712284011000492,"purchaseNo":null,"orderType":1,"paymentType":41,"paymentTypeView":"账期支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514456270000,"orderTimeStr":"2017-12-28 18:17:50","primitivePrice":null,"totalDiscount":null,"paymentPrice":555,"modfiyPrice":null,"freight":null,"orderStatus":80,"orderStatusView":"已取消","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180105191758849","receiverName":"xiaowei","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000492,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":5,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/b930a3c4-6ddd-40c3-b16e-b7619c1c7016.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区东城区西单","mobile":"11011011011","skuNum":5},{"id":null,"platformId":40,"orderNo":1712284011000489,"purchaseNo":null,"orderType":1,"paymentType":1,"paymentTypeView":"在线支付","parentOrderNo":0,"shopId":4021000057,"sellerId":1000010394,"buyerId":1000010373,"orderTime":1514451974000,"orderTimeStr":"2017-12-28 17:06:14","primitivePrice":null,"totalDiscount":null,"paymentPrice":111,"modfiyPrice":null,"freight":null,"orderStatus":80,"orderStatusView":"已取消","orderSnapshootKey":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180104165347854","receiverName":"xiaowei","refund":null,"refundView":null,"finishTime":null,"refundTime":null,"orderCommentStatus":null,"orderItemSkuList":[{"orderNo":1712284011000489,"skuId":10008178,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/f7f5e10b5faacb804a11e624b7dbb74f20171225103405542.jpg","altImage":null,"itemId":100001153,"itemName":"测试数据1225-01","attributes":null,"attributeIds":null,"sendPeriod":1,"primitivePrice":111,"num":1,"paymentPrice":111,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":111,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}],"detailPageQrcode":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/cca7abc6-f40c-486f-8a19-05e11d3ae1d5.png","qrCodeContent":null,"confirmReceiptPageQrcode":null,"orderEstimatePaymentResultVo":null,"hasPresell":0,"advancePrice":null,"finalPrice":null,"salePriceType":null,"applyAssembleTimeOut":null,"shopName":"songsong2ceshi","shopType":2,"fullAddress":"北京市市辖区东城区西单","mobile":"11011011011","skuNum":1}]
         * nextPage : 2
         * lastPage : true
         * firstPage : true
         * prevPage : 1
         */

        private int pageNum;
        private int pageSize;
        private int totalCount;
        private int totalPageCount;
        private int nextPage;
        private boolean lastPage;
        private boolean firstPage;
        private int prevPage;
        private List<ResultBean> result;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPageCount() {
            return totalPageCount;
        }

        public void setTotalPageCount(int totalPageCount) {
            this.totalPageCount = totalPageCount;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrevPage() {
            return prevPage;
        }

        public void setPrevPage(int prevPage) {
            this.prevPage = prevPage;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable, MultiItemEntity {
            /**
             * id : null
             * platformId : 40
             * orderNo : 1802024011001
             * purchaseNo : null
             * orderType : 1
             * paymentType : 1
             * paymentTypeView : 在线支付
             * parentOrderNo : 0
             * shopId : 4021000057
             * sellerId : 1000010394
             * buyerId : 1000010394
             * orderTime : 1517555641000
             * orderTimeStr : 2018-02-02 15:14:01
             * primitivePrice : null
             * totalDiscount : null
             * paymentPrice : 12.0
             * modfiyPrice : null
             * freight : null
             * orderStatus : 20
             * orderStatusView : 待发货
             * orderSnapshootKey : //hnc-hb-01.oss.cn-north-1.jcloudcs.com/20180202151406921
             * receiverName : test
             * refund : null
             * refundView : null
             * finishTime : null
             * refundTime : null
             * orderCommentStatus : null
             * orderItemSkuList : [{"orderNo":1802024011001,"skuId":10008359,"skuImageUrl":"//hnc-hb-01.oss.cn-north-1.jcloudcs.com/8812c36aa5ae336c2a77bf63211d899a20180117144309670.jpg","altImage":null,"itemId":100001255,"itemName":"测试发布商品","attributes":"2323:2323;","attributeIds":"[{\"vid\":\"6521\",\"aid\":\"2631\"}]","sendPeriod":1,"primitivePrice":null,"num":1,"paymentPrice":12,"paymentPriceAmount":null,"supplyName":null,"purchaseNo":null,"purchaseStatus":null,"refundStatus":10,"refundNum":null,"refundStatusView":"------","refundTime":null,"modifiedPrice":null,"remark":null,"hasDelived":null,"advancePercent":null,"advancePrice":null,"salePriceType":null,"deliveryType":1,"deliveryTypeView":"包邮","discountedPrice":12,"promotionId":null,"assembleId":null,"assembleStatus":null,"assembleStatusView":null,"applyAssembleTimeOut":null,"afterSaleState":null,"shopId":null,"sellerId":null}]
             * detailPageQrcode : //hnc-hb-01.oss.cn-north-1.jcloudcs.com/e68a9471-e17f-4050-af52-f0a515e01ee2.png
             * qrCodeContent : null
             * confirmReceiptPageQrcode : null
             * orderEstimatePaymentResultVo : null
             * hasPresell : 0
             * advancePrice : null
             * finalPrice : null
             * salePriceType : null
             * applyAssembleTimeOut : null
             * shopName : songsong2ceshi
             * shopType : 2
             * fullAddress : 北京市市辖区朝阳区北辰世纪中心
             * mobile : 11011011011
             * skuNum : 1
             */

            private Object id;
            private int platformId;
            private Long orderNo;
            private Object purchaseNo;
            private int orderType;
            private int paymentType;
            private String paymentTypeView;
            private long parentOrderNo;
            private long shopId;
            private int sellerId;
            private int buyerId;
            private long orderTime;
            private String orderTimeStr;
            private Object primitivePrice;
            private Object totalDiscount;
            private double paymentPrice;
            private Object modfiyPrice;
            private double freight;
            private int orderStatus;
            private String orderStatusView;
            private String orderSnapshootKey;
            private String receiverName;
            private Object refund;
            private Object refundView;
            private Object finishTime;
            private Object refundTime;
            private Object orderCommentStatus;
            private String detailPageQrcode;
            private Object qrCodeContent;
            private Object confirmReceiptPageQrcode;
            private Object orderEstimatePaymentResultVo;
            private int hasPresell;
            private Object advancePrice;
            private Object finalPrice;
            private Object salePriceType;
            private Object applyAssembleTimeOut;
            private String shopName;
            private int shopType;
            private String fullAddress;
            private String mobile;
            private int skuNum;
            private List<OrderItemSkuListBean> orderItemSkuList;

            //add by app
            private String edit_deliver_code;
            private boolean isChecked = false;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public int getPlatformId() {
                return platformId;
            }

            public void setPlatformId(int platformId) {
                this.platformId = platformId;
            }

            public Long getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(Long orderNo) {
                this.orderNo = orderNo;
            }

            public Object getPurchaseNo() {
                return purchaseNo;
            }

            public void setPurchaseNo(Object purchaseNo) {
                this.purchaseNo = purchaseNo;
            }

            public int getOrderType() {
                return orderType;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
            }

            public int getPaymentType() {
                return paymentType;
            }

            public void setPaymentType(int paymentType) {
                this.paymentType = paymentType;
            }

            public String getPaymentTypeView() {
                return paymentTypeView;
            }

            public void setPaymentTypeView(String paymentTypeView) {
                this.paymentTypeView = paymentTypeView;
            }

            public long getParentOrderNo() {
                return parentOrderNo;
            }

            public void setParentOrderNo(long parentOrderNo) {
                this.parentOrderNo = parentOrderNo;
            }

            public long getShopId() {
                return shopId;
            }

            public void setShopId(long shopId) {
                this.shopId = shopId;
            }

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public int getBuyerId() {
                return buyerId;
            }

            public void setBuyerId(int buyerId) {
                this.buyerId = buyerId;
            }

            public long getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(long orderTime) {
                this.orderTime = orderTime;
            }

            public String getOrderTimeStr() {
                return orderTimeStr;
            }

            public void setOrderTimeStr(String orderTimeStr) {
                this.orderTimeStr = orderTimeStr;
            }

            public Object getPrimitivePrice() {
                return primitivePrice;
            }

            public void setPrimitivePrice(Object primitivePrice) {
                this.primitivePrice = primitivePrice;
            }

            public Object getTotalDiscount() {
                return totalDiscount;
            }

            public void setTotalDiscount(Object totalDiscount) {
                this.totalDiscount = totalDiscount;
            }

            public double getPaymentPrice() {
                return paymentPrice;
            }

            public void setPaymentPrice(double paymentPrice) {
                this.paymentPrice = paymentPrice;
            }

            public Object getModfiyPrice() {
                return modfiyPrice;
            }

            public void setModfiyPrice(Object modfiyPrice) {
                this.modfiyPrice = modfiyPrice;
            }

            public double getFreight() {
                return freight;
            }

            public void setFreight(double freight) {
                this.freight = freight;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getOrderStatusView() {
                return orderStatusView;
            }

            public void setOrderStatusView(String orderStatusView) {
                this.orderStatusView = orderStatusView;
            }

            public String getOrderSnapshootKey() {
                return orderSnapshootKey;
            }

            public void setOrderSnapshootKey(String orderSnapshootKey) {
                this.orderSnapshootKey = orderSnapshootKey;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public Object getRefund() {
                return refund;
            }

            public void setRefund(Object refund) {
                this.refund = refund;
            }

            public Object getRefundView() {
                return refundView;
            }

            public void setRefundView(Object refundView) {
                this.refundView = refundView;
            }

            public Object getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(Object finishTime) {
                this.finishTime = finishTime;
            }

            public Object getRefundTime() {
                return refundTime;
            }

            public void setRefundTime(Object refundTime) {
                this.refundTime = refundTime;
            }

            public Object getOrderCommentStatus() {
                return orderCommentStatus;
            }

            public void setOrderCommentStatus(Object orderCommentStatus) {
                this.orderCommentStatus = orderCommentStatus;
            }

            public String getDetailPageQrcode() {
                return detailPageQrcode;
            }

            public void setDetailPageQrcode(String detailPageQrcode) {
                this.detailPageQrcode = detailPageQrcode;
            }

            public Object getQrCodeContent() {
                return qrCodeContent;
            }

            public void setQrCodeContent(Object qrCodeContent) {
                this.qrCodeContent = qrCodeContent;
            }

            public Object getConfirmReceiptPageQrcode() {
                return confirmReceiptPageQrcode;
            }

            public void setConfirmReceiptPageQrcode(Object confirmReceiptPageQrcode) {
                this.confirmReceiptPageQrcode = confirmReceiptPageQrcode;
            }

            public Object getOrderEstimatePaymentResultVo() {
                return orderEstimatePaymentResultVo;
            }

            public void setOrderEstimatePaymentResultVo(Object orderEstimatePaymentResultVo) {
                this.orderEstimatePaymentResultVo = orderEstimatePaymentResultVo;
            }

            public int getHasPresell() {
                return hasPresell;
            }

            public void setHasPresell(int hasPresell) {
                this.hasPresell = hasPresell;
            }

            public Object getAdvancePrice() {
                return advancePrice;
            }

            public void setAdvancePrice(Object advancePrice) {
                this.advancePrice = advancePrice;
            }

            public Object getFinalPrice() {
                return finalPrice;
            }

            public void setFinalPrice(Object finalPrice) {
                this.finalPrice = finalPrice;
            }

            public Object getSalePriceType() {
                return salePriceType;
            }

            public void setSalePriceType(Object salePriceType) {
                this.salePriceType = salePriceType;
            }

            public Object getApplyAssembleTimeOut() {
                return applyAssembleTimeOut;
            }

            public void setApplyAssembleTimeOut(Object applyAssembleTimeOut) {
                this.applyAssembleTimeOut = applyAssembleTimeOut;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public int getShopType() {
                return shopType;
            }

            public void setShopType(int shopType) {
                this.shopType = shopType;
            }

            public String getFullAddress() {
                return fullAddress;
            }

            public void setFullAddress(String fullAddress) {
                this.fullAddress = fullAddress;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getSkuNum() {
                return skuNum;
            }

            public void setSkuNum(int skuNum) {
                this.skuNum = skuNum;
            }

            public List<OrderItemSkuListBean> getOrderItemSkuList() {
                return orderItemSkuList;
            }

            public void setOrderItemSkuList(List<OrderItemSkuListBean> orderItemSkuList) {
                this.orderItemSkuList = orderItemSkuList;
            }

            public String getEdit_deliver_code() {
                return edit_deliver_code;
            }

            public void setEdit_deliver_code(String edit_deliver_code) {
                this.edit_deliver_code = edit_deliver_code;
            }

            @Override
            public int getItemType() {
                if (orderStatus == ORDER_STATUS_TO_BE_PAID ||
                        orderStatus == ORDER_STATUS_TO_BE_DELIVERED ||
                        orderStatus == ORDER_STATUS_TO_RECEIVE_GOODS ||
                        orderStatus == ORDER_STATUS_FINISHED ||
                        orderStatus == ORDER_STATUS_CANCLE)
                    return orderStatus;
                else
                    return ORDER_STATUS_ORTHER;
            }

            public static class OrderItemSkuListBean implements Serializable {
                /**
                 * orderNo : 1802024011001
                 * skuId : 10008359
                 * skuImageUrl : //hnc-hb-01.oss.cn-north-1.jcloudcs.com/8812c36aa5ae336c2a77bf63211d899a20180117144309670.jpg
                 * altImage : null
                 * itemId : 100001255
                 * itemName : 测试发布商品
                 * attributes : 2323:2323;
                 * attributeIds : [{"vid":"6521","aid":"2631"}]
                 * sendPeriod : 1
                 * primitivePrice : null
                 * num : 1
                 * paymentPrice : 12.0
                 * paymentPriceAmount : null
                 * supplyName : null
                 * purchaseNo : null
                 * purchaseStatus : null
                 * refundStatus : 10
                 * refundNum : null
                 * refundStatusView : ------
                 * refundTime : null
                 * modifiedPrice : null
                 * remark : null
                 * hasDelived : null
                 * advancePercent : null
                 * advancePrice : null
                 * salePriceType : null
                 * deliveryType : 1
                 * deliveryTypeView : 包邮
                 * discountedPrice : 12.0
                 * promotionId : null
                 * assembleId : null
                 * assembleStatus : null
                 * assembleStatusView : null
                 * applyAssembleTimeOut : null
                 * afterSaleState : null
                 * shopId : null
                 * sellerId : null
                 */

                private long orderNo;
                private String skuImageUrl;
                private String itemName;
                private String attributes;
                private int num;
                private double paymentPrice;
                private Object shopId;

                public long getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(long orderNo) {
                    this.orderNo = orderNo;
                }

                public String getSkuImageUrl() {
                    return skuImageUrl;
                }

                public void setSkuImageUrl(String skuImageUrl) {
                    this.skuImageUrl = skuImageUrl;
                }


                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public String getAttributes() {
                    return attributes;
                }

                public void setAttributes(String attributes) {
                    this.attributes = attributes;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public double getPaymentPrice() {
                    return paymentPrice;
                }

                public void setPaymentPrice(double paymentPrice) {
                    this.paymentPrice = paymentPrice;
                }

                public Object getShopId() {
                    return shopId;
                }

                public void setShopId(Object shopId) {
                    this.shopId = shopId;
                }

            }
        }
    }
}
