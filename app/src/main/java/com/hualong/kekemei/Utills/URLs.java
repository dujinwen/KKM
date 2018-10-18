package com.hualong.kekemei.Utills;

/**
 * Created by peiyangfan on 2018/10/9.
 */

public class URLs {

    public static final String BASE_URL = "http://kekemei.ecooth.com";
    //首页数据
    public static final String HOME_URL = BASE_URL + "/api/index";
    public static final String MY_ORDER = BASE_URL + "/api/order/myorder";

    public static final String MIAOSHA = BASE_URL + "/api/project/second";

    public static final String WEINITUIJIAN = BASE_URL + "/api/project/foryou";

    public static final String HONGBAO = BASE_URL + "/api/user/myRedenvelopes";
    public static final String YOUHUIQUAN = BASE_URL + "/api/user/mycoupon";

    public static final String SEARCH = BASE_URL + "/api/index/search";
    public static final String MEIRONGSHILIST = BASE_URL + "/api/beautician/nearbyBeautician";
    public static final String SHOP_LIST = BASE_URL + "/api/shop/nearbyShop";

    public static final String SHOP_DETAIL = BASE_URL + "/api/shop/details";

    public static final String PROJECT_LIST = BASE_URL + "/api/project/projectList";

    //检测验证码
    public static final String CHECK = BASE_URL + "api/sns/check";
    //发送个人信息
    public static final String USER_PROFILE = BASE_URL + "/api/user/profile";
    //发送验证码
    public static final String SEND = BASE_URL + "/api/sms/send";
    //手机验证码登陆
    public static final String MOBILE_LOGIN = BASE_URL + "/api/user/mobilelogin";

    //手机验证码注册
    public static final String REGISTER = BASE_URL + "/api/user/register";
}
