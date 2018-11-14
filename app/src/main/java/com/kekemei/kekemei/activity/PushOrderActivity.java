package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.YuYueActivityBean;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.CircleImageView;
import com.kekemei.kekemei.view.StarBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kekemei.kekemei.activity.PayActivity.EXTRA_KEY_YUYUE_BEAN;

/**
 * Created 订单提交 by peiyangfan on 2018/10/23.
 */

public class PushOrderActivity extends BaseActivity {

    private static String icon_name = "";
    private static String icon_url = "";
    private static String order_name = "";
    private static String order_price = "";
    private static String image_url = "";
    private static String shop_place = "";
    private static long server_time = -1L;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_order_icon)
    ImageView ivOrderIcon;
    @BindView(R.id.tv_order_name)
    TextView tvOrderName;
    @BindView(R.id.iv_jian)
    ImageView ivJian;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.iv_man)
    ImageView ivMan;
    @BindView(R.id.tv_man)
    TextView tvMan;
    @BindView(R.id.ll_youhuiquan)
    LinearLayout llYouhuiquan;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_juli)
    TextView tvJuli;
    @BindView(R.id.ll_julli)
    LinearLayout llJulli;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_jia)
    TextView tvJia;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.civ_icon)
    CircleImageView civIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.sb_num)
    StarBar sbNum;
    @BindView(R.id.ll_meirongshi_select)
    LinearLayout llMeirongshiSelect;
    @BindView(R.id.tv_place)
    TextView tvPlace;
    @BindView(R.id.ll_shop_place)
    LinearLayout llShopPlace;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_service_time)
    LinearLayout llServiceTime;
    @BindView(R.id.btn_yuyue)
    Button btnYuyue;

    private String name = "";
    private int orderNumber = 0;

    private YuYueActivityBean yuYueActivityBean;


    public static final String PROJECT_ID = "PROJECT_NAME";
    public static final String ICON_URL = "ICON_URL";
    public static final String ICON_NAME = "ICON_NAME";
    public static final String ORDER_NAME = "ORDER_NAME";
    public static final String ORDER_PRICE = "ORDER_PRICE";
    public static final String IMAGE_URL = "IMAGE_URL";
    public static final String SHOP_PLACE = "SHOP_PLACE";
    public static final String SERVER_TIME = "SERVER_TIME";
    private static int project_id = -1;

    public static void start(Context context, YuYueActivityBean yuYueActivityBean) {
        Intent intent = new Intent(context, PushOrderActivity.class);
        intent.putExtra(EXTRA_KEY_YUYUE_BEAN, yuYueActivityBean);
        context.startActivity(intent);
    }


    @Override
    protected int setLayoutId() {
        return R.layout.activity_push_order;
    }


    @Override
    protected void initData() {
        super.initData();

        // TODO: 2018/11/14   根據訂單號獲取訂單信息
        initOrderData();


        if (yuYueActivityBean.getBeauticianDetailBean() == null && yuYueActivityBean.getShopDetailBean() == null) {
            // TODO: 2018/11/14 从附近的店铺预约
        } else if (yuYueActivityBean.getShopDetailBean() != null) {
            // TODO: 2018/11/14  通过店铺查找美容师
        } else if (yuYueActivityBean.getBeauticianDetailBean() != null) {
            // TODO: 2018/11/14  店铺主页
        }


        if (yuYueActivityBean.getTimeSelect() != -1 && yuYueActivityBean.getDateSelect() != -1L) {
            llServiceTime.setClickable(false);
            tvTime.setText(AppUtil.getFormatTime1(yuYueActivityBean.getDateSelect()) + "  " + yuYueActivityBean.getTimeSelectName());
        }

    }

    private void initOrderData() {

    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);


        toolbar.setNavigationIcon(R.mipmap.back);
        tvTitle.setText("预约美容师");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llAdd.setVisibility(View.GONE);
        tvOrderNum.setVisibility(View.GONE);


        Intent intent = new Intent();
        yuYueActivityBean = (YuYueActivityBean) getIntent().getSerializableExtra(EXTRA_KEY_YUYUE_BEAN);
        order_name = yuYueActivityBean.getOrderName();
        image_url = yuYueActivityBean.getOrderIconUrl();
        order_price = yuYueActivityBean.getOrderPrice() + "";
        //        icon_name = intent.getStringExtra(ICON_NAME);
        //        icon_url = intent.getStringExtra(ICON_URL);
        //        shop_place = intent.getStringExtra(SHOP_PLACE);
        //        server_time = intent.getLongExtra(SERVER_TIME, -1L);
        tvNum.setText(orderNumber + "");
        //        tvPrice.setText(order_price);
        //        tvName.setText(icon_name);
        //        tvOrderName.setText(order_name);
        //        tvPlace.setText(shop_place);
        //        tvTime.setText(AppUtil.getFormatTime(server_time));

        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + image_url, ivOrderIcon);
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + icon_url, ivMan);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }


    @OnClick({R.id.ll_meirongshi_select, R.id.ll_shop_place, R.id.ll_service_time, R.id.btn_yuyue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_meirongshi_select:
                break;
            case R.id.ll_shop_place:
                break;
            case R.id.ll_service_time:
                break;
            case R.id.btn_yuyue:
                OkGo.<String>get(URLs.ADD_APPOINTMENT)
                        .params("user_id",UserHelp.getUserId(PushOrderActivity.this))
                        .params("shop_id",yuYueActivityBean.getShopDetailBean().getData().getId())
                        .params("beautician_id",yuYueActivityBean.getBeauticianDetailBean().getData().getId())
                        .params("timedata",yuYueActivityBean.getTimeSelect())
                        .params("timedstartdate",yuYueActivityBean.getDateSelect())
                        .params("order_id",yuYueActivityBean.getOrderId())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {

                            }
                        });
                break;
        }
    }
}
