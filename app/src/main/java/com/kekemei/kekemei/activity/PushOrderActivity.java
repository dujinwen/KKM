package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.CircleImageView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created 订单提交 by peiyangfan on 2018/10/23.
 */

public class PushOrderActivity extends BaseActivity {
    private static String icon_name;
    private static String icon_url;
    private static String order_name;
    private static String order_price;
    private static String image_url;
    private static String shop_place;
    private static long server_time;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_order_icon)
    ImageView ivOrderIcon;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_jia)
    TextView tvJia;
    @BindView(R.id.civ_icon)
    CircleImageView civIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
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
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
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
    @BindView(R.id.ll_youhuiquan)
    ConstraintLayout llYouhuiquan;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_juli)
    TextView tvJuli;
    @BindView(R.id.ll_julli)
    LinearLayout llJulli;
    private int project_id = 0;
    private String name = "";
    private int orderNumber = 0;

    public static String ICON_URL = "ICON_URL";
    public static String ICON_NAME = "ICON_NAME";
    public static String ORDER_NAME = "ORDER_NAME";
    public static String ORDER_PRICE = "ORDER_PRICE";
    public static String IMAGE_URL = "IMAGE_URL";
    public static String SHOP_PLACE = "SHOP_PLACE";
    public static String SERVER_TIME = "SERVER_TIME";
    private Intent intent;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_push_order;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PushOrderActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        super.initData();


        icon_name = intent.getStringExtra(ICON_NAME);
        icon_url = intent.getStringExtra(ICON_URL);
        order_name = intent.getStringExtra(ORDER_NAME);
        order_price = intent.getStringExtra(ORDER_PRICE);
        image_url = intent.getStringExtra(IMAGE_URL);
        shop_place = intent.getStringExtra(SHOP_PLACE);
        server_time = intent.getLongExtra(SERVER_TIME, -1L);

        tvNum.setText(orderNumber);
        tvPrice.setText(order_price);
        tvName.setText(icon_name);
        tvOrderName.setText(order_name);
        tvPlace.setText(shop_place);
        tvTime.setText(AppUtil.getFormatTime(server_time));

        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + image_url, ivOrderIcon);
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + icon_url, ivMan);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);


        toolbar.setNavigationIcon(R.mipmap.back);
        tvTitle.setText("设置");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        llAdd.setVisibility(View.VISIBLE);
        tvOrderNum.setVisibility(View.GONE);
    }

    @OnClick({R.id.tv_title, R.id.tv_submit, R.id.toolbar, R.id.iv_order_icon, R.id.tv_price, R.id.tv_jian, R.id.tv_num, R.id.tv_jia, R.id.civ_icon, R.id.tv_name, R.id.tv_place, R.id.ll_shop_place, R.id.tv_time, R.id.ll_service_time, R.id.btn_yuyue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                break;
            case R.id.tv_submit:
                break;
            case R.id.toolbar:
                break;
            case R.id.iv_order_icon:
                break;
            case R.id.tv_price:
                break;
            case R.id.tv_jian:
                tvNum.setText(--orderNumber);
                break;
            case R.id.tv_num:
                break;
            case R.id.tv_jia:
                tvNum.setText(++orderNumber);
                break;
            case R.id.civ_icon:
                break;
            case R.id.tv_name:
                break;
            case R.id.tv_place:
                break;
            case R.id.ll_shop_place:
                break;
            case R.id.tv_time:
                break;
            case R.id.ll_service_time:
                break;
            case R.id.btn_yuyue:

                OkGo.<String>get(URLs.ORDER_GENERATING)
                        .params("user_id", UserHelp.getUserId(PushOrderActivity.this))
                        .params("name", name)
                        .params("project_id", project_id)
                        .params("count", tvNum.getText().toString().trim())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {

                            }
                        });
                break;
        }
    }
}
