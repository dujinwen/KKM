package com.kekemei.kekemei.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.BeauticianDetailBean;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.kekemei.kekemei.view.StarBar;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 美容师介绍
 */

public class BeauticianInfoActivity extends BaseActivity {
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
    @BindView(R.id.workPhotoList)
    RecyclerView workPhotoList;
    private WorkPhotoListAdapter adapter;

    @BindView(R.id.scrollLayout)
    ScrollView scrollLayout;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private int beauticianId;

    public static void start(Context context, int beauticianId) {
        Intent intent = new Intent(context, BeauticianInfoActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, beauticianId);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_beautician_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        beauticianId = super.getIntExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        toolbar.setNavigationIcon(R.mipmap.back);
        tvTitle.setText("美容师介绍");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        multipleStatusView.showOutContentView(scrollLayout);

        LinearLayoutManager layout_meirongshi = new LinearLayoutManager(this);
        layout_meirongshi.setOrientation(LinearLayoutManager.HORIZONTAL);
        workPhotoList.setLayoutManager(layout_meirongshi);
        adapter = new WorkPhotoListAdapter();
        workPhotoList.setAdapter(adapter);
        //        setGridView();
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
                jiedanNum.setText(detailBean.getData().getOrder_count() + "");
                tvPrice.setText("￥ " + detailBean.getData().getAverage_price());
                jiguan.setText(detailBean.getData().getPlace());
                techang.setText(detailBean.getData().getSpeciality());
                jianjie.setText(detailBean.getData().getContent());
                if (detailBean.getData().getIsfriend() == 1) {
                    tvFollow.setText("已关注");
                    tvFollow.setClickable(false);
                    tvFollow.setTextColor(ContextCompat.getColor(BeauticianInfoActivity.this, R.color.common_text_dark));
                    tvFollow.setBackground(ContextCompat.getDrawable(BeauticianInfoActivity.this, R.mipmap.orderform_determine_btn_1));
                } else {
                    tvFollow.setText("关注");
                    tvFollow.setClickable(true);
                    tvFollow.setTextColor(ContextCompat.getColor(BeauticianInfoActivity.this, R.color.white));
                    tvFollow.setBackground(ContextCompat.getDrawable(BeauticianInfoActivity.this, R.mipmap.orderform_determine_btn));
                }
                if (StringUtils.isNotEmpty(detailBean.getData().getImages())) {
                    String[] split = detailBean.getData().getImages().split(",");
                    adapter.replaceData(Arrays.asList(split));
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                multipleStatusView.showError();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvFollow)
    public void onViewClicked() {
        if (tvFollow.getText().toString().equals("关注"))
            follow();
    }

    /**
     * 关注
     */
    private void follow() {
        OkGo.<String>post(URLs.FOLLOW_BEAUTICIAN)
                .params("beautician_id", beauticianId)
                .params("user_id", UserHelp.getUserId(BeauticianInfoActivity.this))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e("Me", "follow beautician:" + response.body());
                        Gson gson = new Gson();
                        tvFollow.setText("已关注");
                    }
                });
    }

    private class WorkPhotoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public WorkPhotoListAdapter() {
            super(R.layout.item_work_photo_list);
        }

        @Override
        protected void convert(BaseViewHolder helper, String url) {
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + url, (ImageView) helper.getView(R.id.icon_pic));
        }

    }

}