package com.hualong.kekemei.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.utills.LogUtil;
import com.hualong.kekemei.utills.URLs;
import com.hualong.kekemei.bean.BannerBean;
import com.hualong.kekemei.bean.MeiRongShiListBean;
import com.hualong.kekemei.adapter.MeiRongShiListAdapter;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiActivity extends BaseActivity {


    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rv_meirongshi)
    RecyclerView rvMeirongshi;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.fenlei)
    ImageView fenlei;

    public static void start(Activity context) {
        Intent intent = new Intent(context, MeiRongShiActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_meirongshi;
    }

    @Override
    protected void initData() {
        OkGo.<String>get(URLs.MEIRONGSHILIST).params("longitude", 116.4072154982)
                .params("latitude", 39.9047253699).params("page", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.d("MeiRongShiActivity", response.body());

                Gson gson = new Gson();
                MeiRongShiListBean meiRongShiListBean = gson.fromJson(response.body(), MeiRongShiListBean.class);

//                xbanner.setData(meiRongShiListBean.getData().getBanneradv(), null);
                initBanner();


                rvMeirongshi.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                rvMeirongshi.setAdapter(new MeiRongShiListAdapter(MeiRongShiActivity.this, R.layout.list_meirongshi, meiRongShiListBean.getData()));

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
