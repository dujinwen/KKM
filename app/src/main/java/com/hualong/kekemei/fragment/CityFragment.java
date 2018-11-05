package com.hualong.kekemei.fragment;

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
import com.hualong.kekemei.R;
import com.hualong.kekemei.activity.ClassifyActivity;
import com.hualong.kekemei.adapter.FindOrderListAdapter;
import com.hualong.kekemei.bean.HotdataBean;
import com.hualong.kekemei.bean.ProjectListBean;
import com.hualong.kekemei.utils.EndLessOnScrollListener;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

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

    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rv_remenxiangmu)
    RecyclerView rvRemenxiangmu;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.fenlei)
    ImageView fenlei;
    Unbinder unbinder;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    private FindOrderListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;

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
        rvRemenxiangmu.setAdapter(listAdapter);
        rvRemenxiangmu.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });


        getData(page);

    }

    private int page = 1;
    private ArrayList<HotdataBean> arrayList = new ArrayList<>();

    private void getData(final int page) {
        OkGo.<String>post(URLs.PROJECT_LIST).params("page", page).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ShopActivity", "project list:" + response.body());
                Gson gson = new Gson();
                ProjectListBean projectListBean = gson.fromJson(response.body(), ProjectListBean.class);

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
