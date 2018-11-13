package com.kekemei.kekemei.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.PayResultBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.CheckBoxSample;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kekemei.kekemei.activity.ProjectDetailActivity.EXTRA_KEY_BEAUTICIAN_ID;
import static com.kekemei.kekemei.activity.ProjectDetailActivity.EXTRA_KEY_DAY_SELECT;
import static com.kekemei.kekemei.activity.ProjectDetailActivity.EXTRA_KEY_ORDER_ID;
import static com.kekemei.kekemei.activity.ProjectDetailActivity.EXTRA_KEY_PLACE;
import static com.kekemei.kekemei.activity.ProjectDetailActivity.EXTRA_KEY_TIME_SELECT;

/**
 * Created 支付页面 by peiyangfan on 2018/10/23.
 */

public class PayActivity extends BaseActivity {
    private static final String EXTRA_KEY_TIME = "ORDER_CREATE_TIME";
    private static final String EXTRA_KEY_ORDER_NAME = "ORDER_NAME";
    private static final String EXTRA_KEY_ORDER_IMAGE = "ORDER_IMAGE";
    private static final String EXTRA_KEY_ORDER_PRICE = "ORDER_PRICE";
    private static final String EXTRA_KEY_ORDER_COUNT = "ORDER_COUNT";
    private static final int PAY_TO_VOUCHER_CODE = 100;
    private static final int PAY_TO_RED_CODE = PAY_TO_VOUCHER_CODE + 1;
    private static final int PAY_TO_MAN_JIAN_CODE = PAY_TO_RED_CODE + 1;

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

    private int beauticianId;
    private int timeSelect;
    private long dateSelect;
    private String order_Id;
    private String place;
    private long order_create_time;
    private int order_price, order_count;
    private String order_image;
    private String order_name;

    private int hongbaonum, youhuiqunnum, manjiannum = 0;

    public static void start(Context context, int beauticianId,
                             int timeSelectPosition, long daySelectPosition,
                             String order_id, String time, String place,
                             String name, String image, int price_newmember
            , int count) {
        Intent intent = new Intent(context, PayActivity.class);
        intent.putExtra(EXTRA_KEY_ORDER_ID, order_id);
        intent.putExtra(EXTRA_KEY_TIME_SELECT, timeSelectPosition);
        intent.putExtra(EXTRA_KEY_DAY_SELECT, daySelectPosition);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, beauticianId);
        intent.putExtra(EXTRA_KEY_PLACE, place);
        intent.putExtra(EXTRA_KEY_TIME, Long.valueOf(time).longValue());
        intent.putExtra(EXTRA_KEY_ORDER_NAME, name);
        intent.putExtra(EXTRA_KEY_ORDER_IMAGE, image);
        intent.putExtra(EXTRA_KEY_ORDER_PRICE, price_newmember);
        intent.putExtra(EXTRA_KEY_ORDER_COUNT, count);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initData() {
        super.initData();
        order_Id = super.getStringExtraSecure(EXTRA_KEY_ORDER_ID);
        beauticianId = super.getIntExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        timeSelect = super.getIntExtraSecure(EXTRA_KEY_TIME_SELECT);
        dateSelect = super.getLongExtraSecure(EXTRA_KEY_DAY_SELECT);
        place = super.getStringExtraSecure(EXTRA_KEY_PLACE);
        order_create_time = super.getLongExtraSecure(EXTRA_KEY_TIME);
        order_name = super.getStringExtraSecure(EXTRA_KEY_ORDER_NAME);
        order_image = super.getStringExtraSecure(EXTRA_KEY_ORDER_IMAGE);
        order_price = super.getIntExtraSecure(EXTRA_KEY_ORDER_PRICE);
        order_count = super.getIntExtraSecure(EXTRA_KEY_ORDER_COUNT);


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
                if (!ivCheckAli.isChecked() && !ivCheckWechat.isChecked()){
                    ToastUtil.showToastMsg(PayActivity.this,"请选择一种支付方式");
                    return;
                }
                if (ivCheckAli.isChecked()) {
                    payUrl = URLs.ORDER_ALI_PAY;
                } else {
                    payUrl = URLs.ORDER_WX_PAY;
                }
                OkGo.<String>get(payUrl).params("order_id",order_Id).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        PayResultBean payResultBean = gson.fromJson(response.body(), PayResultBean.class);
                        // TODO: 2018/11/13 进行支付操作
                        if (ivCheckAli.isChecked()) {

                        } else {

                        }
                    }
                });
                break;
        }
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
    private void toSelectActivity(){
        PushOrderActivity.start(PayActivity.this);
    }
}
