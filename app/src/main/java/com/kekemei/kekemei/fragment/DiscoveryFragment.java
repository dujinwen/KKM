package com.kekemei.kekemei.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.ClassifyActivity;
import com.kekemei.kekemei.activity.ProjectDetailActivity;
import com.kekemei.kekemei.activity.ShopActivity;
import com.kekemei.kekemei.activity.WebActivity;
import com.kekemei.kekemei.adapter.ProjectListAdapter;
import com.kekemei.kekemei.bean.BannerBean;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.DetailEnum;
import com.kekemei.kekemei.bean.ProjectListBean;
import com.kekemei.kekemei.utils.EndLessOnScrollListener;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class DiscoveryFragment extends Fragment {
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.fenlei)
    ImageView fenlei;
    Unbinder unbinder;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.ll_fanhui)
    LinearLayout llFanhui;
    private ProjectListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_discovery, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();
        return inflate;
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setHasFixedSize(true);
        rvList.setNestedScrollingEnabled(false);
        rvList.setLayoutManager(linearLayoutManager);
        listAdapter = new ProjectListAdapter(getActivity());
        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BaseBean data = (BaseBean) adapter.getItem(position);
                ProjectDetailActivity.start(getActivity(), data.getId());
            }
        });

        rvList.setAdapter(listAdapter);
        rvList.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        getData(page);
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
                BannerBean bannerBean = (BannerBean) model;
                switch (bannerBean.getJumbdata()) {
                    case "shop":
                        ShopActivity.start(getActivity(), bannerBean.getShop_shop_id() + "", DetailEnum.SHOP);
                        break;
                    case "project":
                        ProjectDetailActivity.start(getActivity(), bannerBean.getProject_project_id() + "");
                        break;
                    case "web":
                        WebActivity.start(getActivity(),bannerBean.getUrl());
                        break;
                    case "url":
                        break;
                }
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

    private int page = 1;

    private void getData(final int page) {
        String latitude = SPUtils.getString(getActivity(), "latitude", "");
        String longitude = SPUtils.getString(getActivity(), "longitude", "");

        OkGo.<String>post(URLs.DISCOVE)
                .params("page", page)
                .params("longitude", longitude)
                .params("latitude", latitude)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e("ShopActivity", "project list:" + response.body());
                        try {
                            JSONObject obj = new JSONObject(response.body());
                            if (obj.getString("data").equals("null") || obj.getString("data") == null || obj.getString("data").isEmpty()) {
                                multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                                return;
                            }
                            Gson gson = new Gson();
                            ProjectListBean projectListBean = gson.fromJson(response.body(), ProjectListBean.class);
                            if (page == 1) {
                                listAdapter.setNewData(projectListBean.getData().getData());
                            } else {
                                listAdapter.addData(projectListBean.getData().getData());
                            }
                            initBanner();
                            xbanner.setData(projectListBean.getData().getBanner(), null);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void loadMoreData() {
        page = page++;
        getData(page);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fenlei)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), ClassifyActivity.class));
    }
}
