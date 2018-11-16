package com.kekemei.kekemei.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.ALiPayResultBean;
import com.kekemei.kekemei.bean.WXPayResultBean;
import com.kekemei.kekemei.bean.YuYueActivityBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.Common;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.OrderInfoUtil;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.CheckBoxSample;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created 支付页面 by peiyangfan on 2018/10/23.
 */

public class PayActivity extends BaseActivity {
    public static final String EXTRA_KEY_YUYUE_BEAN = "ORDER_CREATE_TIME";


    private static final int PAY_TO_VOUCHER_CODE = 100;
    private static final int PAY_TO_RED_CODE = PAY_TO_VOUCHER_CODE + 1;
    private static final int PAY_TO_MAN_JIAN_CODE = PAY_TO_RED_CODE + 1;


    private IWXAPI api;


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.order_id)
    TextView orderId;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_order_icon)
    ImageView ivOrderIcon;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_jia)
    TextView tvJia;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.tv_youhuiquan_num)
    TextView tvYouhuiquanNum;
    @BindView(R.id.ll_toyouhuiquan)
    LinearLayout llToYouhuiquan;
    @BindView(R.id.tv_red_bao_num)
    TextView tvRedBaoNum;
    @BindView(R.id.ll_red_bao)
    LinearLayout llRedBao;
    @BindView(R.id.tv_man_jian_hint)
    TextView tvManJianHint;
    @BindView(R.id.tv_man_jian_num)
    TextView tvManJianNum;
    @BindView(R.id.ll_man_jian)
    LinearLayout llManJian;
    @BindView(R.id.iv_check_wechat)
    CheckBoxSample ivCheckWechat;
    @BindView(R.id.iv_check_ali)
    CheckBoxSample ivCheckAli;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_order_name)
    TextView tvOrderName;
    @BindView(R.id.iv_jian)
    ImageView ivJian;
    @BindView(R.id.iv_man)
    ImageView ivMan;
    @BindView(R.id.tv_man)
    TextView tvMan;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_juli)
    TextView tvJuli;
    @BindView(R.id.ll_julli)
    LinearLayout llJulli;
    @BindView(R.id.tv_wait_to_pay)
    TextView tvWaitToPay;

    private String order_Id;
    private long order_create_time;
    private int order_price, order_count;
    private String order_image;
    private String order_name;

    private int hongbaonum, youhuiqunnum, manjiannum = 0;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == Common.ACTIVITY_REQUEST_CODE_ALI_PAY) {
                handleAliPayResult(msg);
            } else if (msg.what == Common.ACTIVITY_REQUEST_CODE_WX_PAY) {
                handleWxPayResult(msg);
            }
        }
    };
    private YuYueActivityBean yuYueActivityBean;


    public static void start(Context context, YuYueActivityBean yuYueActivityBean) {
        Intent intent = new Intent(context, PayActivity.class);
        intent.putExtra(EXTRA_KEY_YUYUE_BEAN, yuYueActivityBean);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initData() {
        super.initData();
        registerReciver();
        yuYueActivityBean = (YuYueActivityBean) getIntent().getSerializableExtra(EXTRA_KEY_YUYUE_BEAN);
        order_Id = yuYueActivityBean.getOrderId();
        order_create_time = Long.valueOf(yuYueActivityBean.getOrderCreateTime());
        order_name = yuYueActivityBean.getOrderName();
        order_image = yuYueActivityBean.getOrderIconUrl();
        order_price = yuYueActivityBean.getOrderPrice();
        order_count = yuYueActivityBean.getOrderCount();


        orderId.setText(order_Id + "");
        tvTime.setText(AppUtil.getFormatTime3(order_create_time));
        tvOrderName.setText(order_name);
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + order_image, ivOrderIcon);
        tvPrice.setText("¥ " + order_price);
        tvOrderNum.setText("X" + order_count);

        money.setText("¥ " + (order_price * order_count));
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle.setText("支付");
        tvOrderNum.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        api = WXAPIFactory.createWXAPI(PayActivity.this, Common.WX_APP_ID);
        api.registerApp(Common.WX_APP_ID);
    }

    @OnClick({R.id.ll_toyouhuiquan, R.id.ll_red_bao, R.id.ll_man_jian, R.id.iv_check_wechat, R.id.iv_check_ali, R.id.btn_pay})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_toyouhuiquan:
                intent = new Intent(PayActivity.this, MyVoucherActivity.class);
                startActivityForResult(intent, PAY_TO_VOUCHER_CODE);
                break;
            case R.id.ll_red_bao:
                intent = new Intent(PayActivity.this, MyRedBaoActivity.class);
                startActivityForResult(intent, PAY_TO_RED_CODE);
                break;
            case R.id.ll_man_jian:
                intent = new Intent(PayActivity.this, MyVoucherActivity.class);
                startActivityForResult(intent, PAY_TO_MAN_JIAN_CODE);
                break;
            case R.id.iv_check_wechat:
                ivCheckWechat.toggle();
                ivCheckAli.setChecked(false);
                break;
            case R.id.iv_check_ali:
                ivCheckAli.toggle();
                ivCheckWechat.setChecked(false);
                break;
            case R.id.btn_pay:
                String payUrl = "";
//                toSelectActivity();
                if (!ivCheckAli.isChecked() && !ivCheckWechat.isChecked()) {
                    ToastUtil.showToastMsg(PayActivity.this, "请选择一种支付方式");
                    return;
                }
                if (ivCheckAli.isChecked()) {
                    payUrl = URLs.ORDER_ALI_PAY;
                    toALiPay(payUrl);
                } else {
                    payUrl = URLs.ORDER_WX_PAY;
                    toWXPay(payUrl);
                }

                break;
        }
    }

    private void toWXPay(String payUrl) {
        OkGo.<String>get(payUrl).params("order_id", order_Id).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                WXPayResultBean payResult = gson.fromJson(response.body(), WXPayResultBean.class);
                // TODO: 2018/11/13 进行支付操作
                if (null != payResult && null != payResult.getData()) {
                    PayReq req = new PayReq();
                    WXPayResultBean.DataBean data = payResult.getData();
                    req.appId = data.getAppid();
                    req.partnerId = data.getMch_id();
                    req.prepayId = data.getPrepay_id();
                    req.packageValue = "Sign=WXPay";
                    req.nonceStr = data.getNonce_str();
                    req.timeStamp = data.getPay_time()+"";
                    req.sign = data.getSign2();
                    // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                    LogUtil.d("PAY_GET", req.toString());
                    if (!api.isWXAppInstalled()) {
                        ToastUtil.showToastMsg(PayActivity.this, "您还未安装微信客户端,请先安装微信客户端");
                        return;
                    }
                    api.sendReq(req);
                } else {
                    LogUtil.d("PAY_GET", "返回错误" + payResult.getMsg());
                }

            }
        });
    }
    private void toALiPay(String payUrl) {
        OkGo.<String>get(payUrl).params("order_id", order_Id).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                final ALiPayResultBean payResultBean = gson.fromJson(response.body(), ALiPayResultBean.class);
//                //秘钥验证的类型 true:RSA2 false:RSA
//                boolean rsa = false;
//                //构造支付订单参数列表
//                Map<String, String> params = OrderInfoUtil.buildOrderParamMap(Common.ALI_APP_ID, rsa);
//                //构造支付订单参数信息
//                String orderParam = OrderInfoUtil.buildOrderParam(params);
//                //对支付参数信息进行签名
//                String sign = OrderInfoUtil.getSign(params, Common.RSA_PRIVATE, rsa);
//                //订单信息
//                final String orderInfo = orderParam + "&" + sign;
                Runnable payRunnable = new Runnable() {


                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PayActivity.this);
                        Map<String, String> result = alipay.payV2(payResultBean.getData().getInfo(), true);
                        Message msg = handler.obtainMessage();
                        msg.what = Common.ACTIVITY_REQUEST_CODE_ALI_PAY;
                        msg.obj = result;
                        handler.sendMessage(msg);
                    }
                };
                Thread payThread = new Thread(payRunnable);
                payThread.start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAY_TO_RED_CODE && resultCode == Activity.RESULT_OK) {
            hongbaonum = data.getExtras().getInt("result");//得到新Activity 关闭后返回的数据
            tvRedBaoNum.setText("- ¥ " + hongbaonum);

        }

        if (requestCode == PAY_TO_VOUCHER_CODE && resultCode == Activity.RESULT_OK) {
            youhuiqunnum = data.getExtras().getInt("result");//得到新Activity 关闭后返回的数据
            tvYouhuiquanNum.setText("- ¥ " + youhuiqunnum);
        }

        if (requestCode == PAY_TO_MAN_JIAN_CODE && resultCode == Activity.RESULT_OK) {
            manjiannum = data.getExtras().getInt("result");//得到新Activity 关闭后返回的数据
            tvManJianNum.setText("- ¥ " + manjiannum);
        }

        money.setText("¥ " + (order_price * order_count - youhuiqunnum - hongbaonum - manjiannum));
    }


    // TODO: 2018/11/13 去预约美容师页面
    private void toSelectActivity() {
        PushOrderActivity.start(PayActivity.this, yuYueActivityBean);
    }


    private void handleWxPayResult(Message msg) {
        String str = "";
        int code = (int) msg.obj;
        switch (code) {
            case 0:
                str = "支付成功";
                toSelectActivity();
                break;
            case -1:
                str = "订单信息错误";
                break;
            case -2:
                str = "用户取消";
                break;
        }
        LogUtil.d("PAY_GET", code + "");
    }
    @SuppressWarnings("unchecked")
    private void handleAliPayResult(Message msg) {
        Map<String, String> result = (Map<String, String>) msg.obj;
        int resultStatus = Integer.parseInt(result.get("resultStatus"));
        switch (resultStatus) {
            //支付成功
            case 9000:
                toSelectActivity();
                break;
            //未知结果
            case 8000:
            case 6004:
                break;
            //取消支付
            case 6001:
                break;
            //其他情况,支付失败
            default:
                break;
        }
    }


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            int errCode;
            if (Common.WX_PAY_RESULT.equals(action)) {
                errCode = intent.getIntExtra(Common.ERROR_CODE, -9999);
                onWxPayResult(errCode);
            }
        }
    };

    public void onWxPayResult(int errCode) {
        Message message = handler.obtainMessage();
        message.what = Common.ACTIVITY_REQUEST_CODE_WX_PAY;
        message.obj = errCode;
        handler.sendMessage(message);
    }

    public void registerReciver() {

        //注册微信支付结果广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Common.WX_PAY_RESULT);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    public void unregisterReciver() {
        unregisterReceiver(mBroadcastReceiver); //取消监听
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReciver();
    }
}
