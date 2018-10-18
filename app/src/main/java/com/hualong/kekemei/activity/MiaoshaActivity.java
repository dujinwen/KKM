package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.IndictorWithNumber;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.MiaoshaBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import butterknife.BindView;

/**
 * 抢购页面
 */
public class MiaoshaActivity extends BaseActivity {
    public static final String TAG = MiaoshaActivity.class.getSimpleName();
    public static final String KEY_SKU_ID = "item_id";
    public static final String KEY_GROUP_ID = "groupId";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rushHallTabs)
    IndictorWithNumber tabs;
    @BindView(R.id.rushHallPager)
    ViewPager pagers;

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MiaoshaActivity.class);
        context.startActivity(intent);
    }

    public static void start(Context context, String skuId, String groupId) {
        Intent intent = new Intent(context, MiaoshaActivity.class);
        intent.putExtra(KEY_SKU_ID, skuId);
        intent.putExtra(KEY_GROUP_ID, groupId);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_miaosha;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        tv_title.setText("秒杀专场");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        super.initData();
        OkGo.<String>post(URLs.MIAOSHA).params("longitude", "116.4072154982")
                .params("latitude", "39.9047253699").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                MiaoshaBean miaoShaBean = gson.fromJson(response.body(), MiaoshaBean.class);
//                xbanner.setData(miaoShaBean.getData().getBanneradv(), null);
                initBanner();
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
//                                Glide.with(MainActivity.this).load(((AdvertiseEntity.OthersBean) model).getThumbnail()).placeholder(R.drawable.default_image).error(R.drawable.default_image).into((ImageView) view);
            }
        });
    }
}
