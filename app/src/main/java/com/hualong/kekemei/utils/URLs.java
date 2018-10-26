package com.hualong.kekemei.utils;

/**
 * Created by peiyangfan on 2018/10/9.
 */

public class URLs {

    public static final String BASE_URL = "http://kekemei.ecooth.com";

    /**
     * 支付
     */
    //支付宝支付
    public static final String ORDER_ALI_PAY = "http://kekemei.ecooth.com/api/order/zfbapppays";
    //微信支付
    public static final String ORDER_WX_PAY = " http://kekemei.ecooth.com/api/order/wxappzf";
    //检查所有支付是否成功，并修改订单状态
    public static final String ORDER_REFUND = "http://kekemei.ecooth.com/api/order/refund";
    //生成订单
    public static final String ORDER_GENERATING = "http://kekemei.ecooth.com/api/order/generatingOrder";


    /**
     * 评论
     */
    //评论发布
    public static final String ADD_COMMENT = " http://kekemei.ecooth.com/api/comment/addcomment";
    //评论标签
    public static final String COMMENT_TAG = "http://kekemei.ecooth.com/api/comment/commenttag";
    //图片上传
    public static final String UPLOAD_IMAGE = "http://kekemei.ecooth.com/api/common/upload";
    //评论列表
    public static final String COMMENT_LIST = "http://kekemei.ecooth.com/api/comment/commentlist";


    /**
     * 我的
     */

    //重置密码
    public static final String RESET_PASSWORD = "http://kekemei.ecooth.com/api/user/resetpwd";
    //我的首页
    public static final String MY_INFO = "http://kekemei.ecooth.com/api/order/myinfo";
    //我的红包
    public static final String MY_RED_ENVELOPES = "http://kekemei.ecooth.com/api/user/myRedenvelopes";
    //我的订单
    public static final String MY_ORDER = "http://kekemei.ecooth.com/api/order/myorder";
    //我的优惠券
    public static final String MY_COUPON = " http://kekemei.ecooth.com/api/user/mycoupon";
    //为你推荐
    public static final String FOR_YOU = "http://kekemei.ecooth.com/api/project/foryou";


    /**
     * 首页
     */

    //消息列表
    public static final String NOTICE_LIST = "http://kekemei.ecooth.com/api/notice/noticelist";
    //首页
    public static final String INDEX = "http://kekemei.ecooth.com/api/index";


    /**
     * 美容师
     */
    //美容师主页
    public static final String BEAUTICIAN_DETAILS = "http://kekemei.ecooth.com/api/beautician/details";
    //附近的美容师
    public static final String BEAUTICIAN_NEAR = "http://kekemei.ecooth.com/api/beautician/nearbyBeautician";

    /**
     * 搜索
     */
    //热搜&amp;搜索历史
    public static final String HOT_SEARCH = "http://kekemei.ecooth.com/api/index/hotsearch";
    //为你推荐
    public static final String INDEX_SEARCH = "http://kekemei.ecooth.com/api/index/search";

    /**
     * 店铺
     */
    //我的优惠券
    public static final String SHOP_NEAR = "http://kekemei.ecooth.com/api/shop/nearbyShop";
    //为你推荐
    public static final String SHOP_DETAILS = "http://kekemei.ecooth.com/api/shop/details";



    /**
     * 登录注册
     */

    //第三方绑定用户
    public static final String USER_BINDING = "http://kekemei.ecooth.com/api/user/binding";
    //第三方登陆
    public static final String APP_THIRD = " http://kekemei.ecooth.com/api/user/appThird";
    //检测验证码
    public static final String SNS_CHECK = "http://kekemei.ecooth.com/api/sns/check";
    //手机验证码登陆
    public static final String MOBILE_LOGIN = "http://kekemei.ecooth.com/api/user/mobilelogin";
    //手机号注册
    public static final String USER_REGISTER = "http://kekemei.ecooth.com/api/user/register";
    //退出登陆
    public static final String USER_LOGIN_OUT = "http://kekemei.ecooth.com/api/user/loginout";
    //发送验证码
    public static final String SEND = "http://kekemei.ecooth.com/api/sms/send";
    //修改个人信息
    public static final String USER_PROFILE = " http://kekemei.ecooth.com/api/user/profile";



    /**
     * 项目
     */

    //项目详情
    public static final String PROJECT_DETAILS = "http://kekemei.ecooth.com/api/project/details";
    //秒杀列表
    public static final String SECOND_LIST = "http://kekemei.ecooth.com/api/project/secondlist";
    //秒杀
    public static final String SECOND = "http://kekemei.ecooth.com/api/project/second";
    //项目列表
    public static final String PROJECT_LIST = "http://kekemei.ecooth.com/api/project/projectList";

}
