package com.kekemei.kekemei.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.ShopListAdapter;
import com.kekemei.kekemei.bean.BannerBean;
import com.kekemei.kekemei.bean.DetailEnum;
import com.kekemei.kekemei.bean.ShopListBean;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopListActivity extends BaseActivity {


    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rv_meirongshi)
    RecyclerView rvMeirongshi;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static void start(Activity context) {
        Intent intent = new Intent(context, ShopListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_meirongshi;
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        tvTitle.setText("店铺");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        String latitude = SPUtils.getString(this, "latitude", "");
        String longitude = SPUtils.getString(this, "longitude", "");
        OkGo.<String>get(URLs.SHOP_NEAR).params("longitude", longitude)
                .params("latitude", latitude).params("page", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.d("ShopListActivity", response.body());

                Gson gson = new Gson();
                final ShopListBean shopListBean = gson.fromJson(response.body(), ShopListBean.class);

                xbanner.setData(shopListBean.getData().getBanner(), null);
                initBanner();


                rvMeirongshi.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                ShopListAdapter adapter = new ShopListAdapter(ShopListActivity.this, R.layout.list_shop

                        , shopListBean.getData().getData());
                rvMeirongshi.setAdapter(adapter);

                adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        switch (view.getId()) {
                            case R.id.ll_shop_list_item:
                                ShopActivity.start(ShopListActivity.this, shopListBean.getData().getData().get(position).getId(),
                                        shopListBean.getData().getData().get(position).getUser_id(), DetailEnum.SHOP);
                                break;
                        }
                    }
                });


            }
        });
    }


    /**
     * 初始化XBanner
     */
    private void initBanner() {
        //设置广告图片点击事件
        xbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                //                Toast.makeText(MainActivity.this, "点击了第" + (position+1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //在此处使用图片加载框架加载图片，demo中使用glide加载，可替换成自己项目中的图片加载框架
                //                Glide.with(MainActivity.this).load(((AdvertiseEntity.OthersBean) model).getThumbnail()).placeholder(R.drawable.default_image).error(R.drawable.default_image).into((ImageView) view);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + ((BannerBean) model).getImage(), (ImageView) view);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
