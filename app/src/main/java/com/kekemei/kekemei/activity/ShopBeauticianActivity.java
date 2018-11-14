package com.kekemei.kekemei.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.SelectBeauticianAdapter;
import com.kekemei.kekemei.adapter.SelectShopAdapter;
import com.kekemei.kekemei.bean.BeauticianBean;
import com.kekemei.kekemei.bean.ShopBean;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;

public class ShopBeauticianActivity extends BaseActivity {
    public static final String TAG = ShopBeauticianActivity.class.getSimpleName();
    private static final String EXTRA_KEY_SHOP_ID = "shopId";
    private static final String EXTRA_KEY_SHOW_SHOP = "showShop";
    public static final int EXTRA_KEY_START_CODE = 1000;
    public static final int EXTRA_KEY_RESULT_CODE = 1001;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    private SelectBeauticianAdapter beauticianAdapter;
    private SelectShopAdapter shopAdapter;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private int jPageNum = 1;

    private String shopId;
    private boolean showShop;
    private String latitude, longitude;

    public static void start(Activity activity, String shopId, boolean showShop,int code) {
        Intent intent = new Intent(activity, ShopBeauticianActivity.class);
        intent.putExtra(EXTRA_KEY_SHOP_ID, shopId);
        intent.putExtra(EXTRA_KEY_SHOW_SHOP, showShop);
        activity.startActivityForResult(intent, code);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_shop_beautician;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        shopId = super.getStringExtraSecure(EXTRA_KEY_SHOP_ID);
        showShop = getIntent().getBooleanExtra(EXTRA_KEY_SHOW_SHOP, false);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText(showShop ? "选择店铺" : "选择美容师");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        latitude = SPUtils.getString(this, "latitude", "");
        longitude = SPUtils.getString(this, "longitude", "");

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        multipleStatusView.showOutContentView(refresh_layout);

        if (showShop) {
            refresh_layout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadData(true);
                }

                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    loadMoreData();
                }
            });
            refresh_layout.setRefreshHeader(new ClassicsHeader(this));
        } else {
            refresh_layout.setEnableRefresh(false);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        rvList.setLayoutManager(linearLayoutManager);

        if (showShop) {
            shopAdapter = new SelectShopAdapter(getBaseContext());
            rvList.setAdapter(shopAdapter);
        } else {
            beauticianAdapter = new SelectBeauticianAdapter(getBaseContext());
            rvList.setAdapter(beauticianAdapter);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        if (showShop) {
            loadData(true);
        } else {
            multipleStatusView.showLoading();
            loadBeauticianList();
        }
    }

    private void loadBeauticianList() {
        if (shopId.contains(",")) {
            String[] shopIds = shopId.split(",");
            for (String id : shopIds) {
                loadList(true, id);
            }
        } else {
            loadList(false, shopId);
        }
    }

    private void loadList(final boolean loadMoreData, String id) {
        OkGo.<String>post(URLs.SHOP_BEAUTICIAN).params("shop_id", id).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        return;
                    }
                    Gson gson = new Gson();
                    List<BeauticianBean> listResult = gson.fromJson(jsonObject.optString("data"), new TypeToken<List<BeauticianBean>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(listResult)) {
                        if (loadMoreData) {
                            beauticianAdapter.addData(listResult);
                        } else {
                            beauticianAdapter.replaceData(listResult);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData(jPageNum);
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData(jPageNum);
    }

    private void getData(int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.COORDINATE_SHOP).params("longitude", longitude).params("page", pageNum)
                .params("latitude", latitude).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "response:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        onResult(null);
                        return;
                    }
                    Gson gson = new Gson();
                    List<ShopBean> listResult = gson.fromJson(jsonObject.optString("data"), new TypeToken<List<ShopBean>>() {
                    }.getType());
                    onResult(listResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                onResultError(response);
            }
        });
    }

    public void onResult(List<ShopBean> listResult) {
        if (!isLoadMore) {
            jPageNum++;

            if (CollectionUtils.isEmpty(listResult)) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                shopAdapter.replaceData(listResult);
            }

            if (listResult.size() < 10)
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            loadMoreSuccess(listResult);
            if (listResult.size() < 10) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    public void onResultError(Object response) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showError();
        if (isLoadMore)
            shopAdapter.loadMoreFail();
        if (isRefresh)
            showRefreshLoading(false);
    }

    public void showEmpty() {
        multipleStatusView.showEmpty();
    }

    public void loadMoreSuccess(List<ShopBean> dataList) {
        refresh_layout.finishLoadMore();
        shopAdapter.addData(dataList);
    }

    public void showLoadMoreEnd() {
        shopAdapter.loadMoreEnd(false);
    }

    public void showLoadMoreComplete() {
        shopAdapter.loadMoreComplete();
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }
}
