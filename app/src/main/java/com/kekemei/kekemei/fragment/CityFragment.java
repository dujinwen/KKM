package com.kekemei.kekemei.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.ClassifyActivity;
import com.kekemei.kekemei.adapter.FindOrderListAdapter;
import com.kekemei.kekemei.bean.BannerBean;
import com.kekemei.kekemei.bean.BaseBean;
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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class CityFragment extends Fragment {


    @BindView(R.id.rv_remenxiangmu)
    RecyclerView rvRemenxiangmu;

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
    private FindOrderListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;
    private XBanner xBanner;
    private View llHotProject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_city, container, false);

        unbinder = ButterKnife.bind(this, inflate);
        initData();
        return inflate;
    }

    private void initData() {

        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvRemenxiangmu.setLayoutManager(linearLayoutManager);
        listAdapter = new FindOrderListAdapter(getActivity());
        View header_view = getActivity().getLayoutInflater().inflate(R.layout.layout_city_header, (ViewGroup) rvRemenxiangmu.getParent(), false);
        listAdapter.addHeaderView(header_view);
        xBanner = header_view.findViewById(R.id.xbanner);
        llHotProject = header_view.findViewById(R.id.ll_hot_project);
        llHotProject.setVisibility(View.GONE);
        rvRemenxiangmu.setAdapter(listAdapter);
        rvRemenxiangmu.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
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
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                //                Toast.makeText(MainActivity.this, "点击了第" + (position+1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //在此处使用图片加载框架加载图片，demo中使用glide加载，可替换成自己项目中的图片加载框架
                //                Glide.with(MainActivity.this).load(((AdvertiseEntity.OthersBean) model).getThumbnail()).placeholder(R.drawable.default_image).error(R.drawable.default_image).into((ImageView) view);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + ((BannerBean) model).getImage(), (ImageView) view);
            }
        });
    }

    private int page = 1;
    private ArrayList<BaseBean> arrayList = new ArrayList<>();

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
                        Gson gson = new Gson();
                        ProjectListBean projectListBean = gson.fromJson(response.body(), ProjectListBean.class);
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(response.body());
                            if (obj.getString("data").equals("null") || obj.getString("data") == null || obj.getString("data").isEmpty()) {
                                multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (page == 1) {
                            listAdapter.setNewData(projectListBean.getData());
                        } else {
                            arrayList.addAll(projectListBean.getData());
                            listAdapter.setNewData(arrayList);
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
