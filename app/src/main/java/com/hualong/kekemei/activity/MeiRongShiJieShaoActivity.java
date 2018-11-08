package com.hualong.kekemei.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.GridViewAdapter;
import com.hualong.kekemei.bean.BeauticianDetailBean;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.MultipleStatusView;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;

/**
 * 美容师介绍
 */

public class MeiRongShiJieShaoActivity extends BaseActivity {
    private static final String EXTRA_KEY_BEAUTICIAN_ID = "beauticianId";
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.shop_detail_icon)
    ImageView shop_detail_icon;

    @BindView(R.id.shopName)
    TextView shopName;

    @BindView(R.id.tvOrderCount)
    TextView tvOrderCount;

    @BindView(R.id.tvCollectionCount)
    TextView tvCollectionCount;

    @BindView(R.id.tvFollow)
    TextView tvFollow;

    @BindView(R.id.tvSatisfaction)
    TextView tvSatisfaction;

    @BindView(R.id.shopStar)
    StarBar shopStar;

    @BindView(R.id.jiedan_num)
    TextView jiedanNum;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.jiguan)
    TextView jiguan;
    @BindView(R.id.techang)
    TextView techang;
    @BindView(R.id.jianjie)
    TextView jianjie;
    @BindView(R.id.grid)
    GridView gridView;

    @BindView(R.id.scrollLayout)
    ScrollView scrollLayout;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private String beauticianId;

    public static void start(Context context, int beauticianId) {
        Intent intent = new Intent(context, MeiRongShiJieShaoActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, String.valueOf(beauticianId));
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_meirongshijieshao;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        beauticianId = super.getStringExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        toolbar.setNavigationIcon(R.mipmap.back);
        beauticianId = super.getStringExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle.setText("美容师介绍");
        setGridView();
    }

    @Override
    protected void initData() {
        super.initData();

        OkGo.<String>post(URLs.BEAUTICIAN_DETAILS).params("id", beauticianId).execute(new StringCallback() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ProjectDetailActivity", response.body());
                multipleStatusView.showOutContentView(scrollLayout);
                Gson gson = new Gson();
                BeauticianDetailBean detailBean = gson.fromJson(response.body(), BeauticianDetailBean.class);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + detailBean.getData().getImage(), shop_detail_icon);
                shopName.setText(detailBean.getData().getName());
                shopStar.setStarMark(detailBean.getData().getStart());
                tvOrderCount.setText(getString(R.string.shop_detail_server_number, detailBean.getData().getOrder_count()));
                tvCollectionCount.setText(getString(R.string.shop_detail_fensi_number, detailBean.getData().getFriend_count()));
                tvSatisfaction.setText(getString(R.string.shop_detail_satisfaction, detailBean.getData().getSatisfaction() + "%"));
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                multipleStatusView.showError();
            }
        });
    }

    /**
     * 设置GirdView参数，绑定数据
     */
    private void setGridView() {
//        int size = cityList.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
//        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                4, LinearLayout.LayoutParams.MATCH_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setColumnWidth(itemWidth); // 设置列表项宽
        gridView.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(4); // 设置列数量=列表集合数

        GridViewAdapter adapter = new GridViewAdapter(getApplicationContext());
        gridView.setAdapter(adapter);
    }


}
