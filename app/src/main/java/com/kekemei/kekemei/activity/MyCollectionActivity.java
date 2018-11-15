package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.FindOrderListAdapter;
import com.kekemei.kekemei.adapter.MeiRongShiListAdapter;
import com.kekemei.kekemei.adapter.ShopListAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.BeauticianBean;
import com.kekemei.kekemei.bean.DetailEnum;
import com.kekemei.kekemei.bean.ShopBean;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
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

public class MyCollectionActivity extends BaseActivity {
    public static final String TAG = MyCollectionActivity.class.getSimpleName();
    private static final String EXTRA_KEY_TYPE = "type";
    private static final String EXTRA_KEY_SHOW_SHOP = "showShop";
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

    private MeiRongShiListAdapter beauticianAdapter;
    private ShopListAdapter shopAdapter;
    private FindOrderListAdapter collectionAdapter;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private int jPageNum = 1;

    private String type;
    private boolean showShop;
    private String latitude, longitude;

    public static void start(Context mContext, String type, boolean showShop) {
        Intent intent = new Intent(mContext, MyCollectionActivity.class);
        intent.putExtra(EXTRA_KEY_TYPE, type);
        intent.putExtra(EXTRA_KEY_SHOW_SHOP, showShop);
        mContext.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        type = super.getStringExtraSecure(EXTRA_KEY_TYPE);
        showShop = getIntent().getBooleanExtra(EXTRA_KEY_SHOW_SHOP, false);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText(showShop ? (type.equals("1") ? "我的收藏" : "我的店铺") : "我的美容师");
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        rvList.setLayoutManager(linearLayoutManager);

        if (showShop) {
            if (type.equals("1")) {
                collectionAdapter = new FindOrderListAdapter(getBaseContext());
                rvList.setAdapter(collectionAdapter);
                collectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        BaseBean item = collectionAdapter.getItem(position);
                        ProjectDetailActivity.start(MyCollectionActivity.this, item.getId());
                    }
                });
            } else {
                shopAdapter = new ShopListAdapter(this, R.layout.list_shop);
                rvList.setAdapter(shopAdapter);
                shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ShopBean item = shopAdapter.getItem(position);
                        ShopActivity.start(MyCollectionActivity.this, item.getId(), item.getUser_id(), DetailEnum.SHOP);
                    }
                });
            }
        } else {
            beauticianAdapter = new MeiRongShiListAdapter(this, R.layout.list_meirongshi);
            rvList.setAdapter(beauticianAdapter);
            beauticianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    BeauticianBean item = beauticianAdapter.getItem(position);
                    ShopActivity.start(MyCollectionActivity.this, item.getId(), item.getUser_id(), DetailEnum.BEAUTICIAN);
                }
            });
        }
    }

    @Override
    protected void initData() {
        super.initData();
        multipleStatusView.showLoading();
        loadData(true);
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        if (showShop) {
            loadMyCollectionOrShop(jPageNum);
        } else {
            loadMyBeautician(jPageNum);
        }
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        if (showShop) {
            loadMyCollectionOrShop(jPageNum);
        } else {
            loadMyBeautician(jPageNum);
        }
    }

    private void loadMyCollectionOrShop(int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.MY_COLLECTION).params("user_id", UserHelp.getUserId(this))
                .params("type", type).params("page", pageNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e(TAG, "response:" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            if (msg.equals("暂无数据")) {
                                showEmpty();
                                return;
                            }
                            Gson gson = new Gson();
                            if (type.equals("1")) {
                                List<BaseBean> listResult = gson.fromJson(jsonObject.optString("data"), new TypeToken<List<BaseBean>>() {
                                }.getType());
                                if (CollectionUtils.isNotEmpty(listResult)) {
                                    onCollectionResult(listResult);
                                } else {
                                    multipleStatusView.showEmpty();
                                }
                            } else {
                                List<ShopBean> listResult = gson.fromJson(jsonObject.optString("data"), new TypeToken<List<ShopBean>>() {
                                }.getType());
                                if (CollectionUtils.isNotEmpty(listResult)) {
                                    onShopResult(listResult);
                                } else {
                                    multipleStatusView.showEmpty();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        onResultError();
                    }
                });
    }

    public void onCollectionResult(List<BaseBean> response) {
        if (!isLoadMore) {
            jPageNum++;
            if (isRefresh)
                showRefreshLoading(false);
            collectionAdapter.replaceData(response);
            if (response.size() < 10)
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            refresh_layout.finishLoadMore();
            collectionAdapter.addData(response);
            if (response.size() < 10) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    public void onShopResult(List<ShopBean> response) {
        if (!isLoadMore) {
            jPageNum++;
            if (isRefresh)
                showRefreshLoading(false);
            shopAdapter.replaceData(response);
            if (response.size() < 10)
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            refresh_layout.finishLoadMore();
            shopAdapter.addData(response);
            if (response.size() < 10) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    private void loadMyBeautician(int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.MY_BEAUTICIAN).params("user_id", UserHelp.getUserId(this))
                .params("page", pageNum).params("longitude", longitude)
                .params("latitude", latitude).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        showEmpty();
                        return;
                    }
                    Gson gson = new Gson();
                    List<BeauticianBean> listResult = gson.fromJson(jsonObject.optString("data"), new TypeToken<List<BeauticianBean>>() {
                    }.getType());
                    if (CollectionUtils.isNotEmpty(listResult)) {
                        onBeauticianResult(listResult);
                    } else {
                        multipleStatusView.showEmpty();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                onResultError();
            }
        });
    }

    public void onBeauticianResult(List<BeauticianBean> response) {
        if (!isLoadMore) {
            jPageNum++;
            if (isRefresh)
                showRefreshLoading(false);
            beauticianAdapter.replaceData(response);
            if (response.size() < 10)
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            refresh_layout.finishLoadMore();
            beauticianAdapter.addData(response);
            if (response.size() < 10) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    public void onResultError() {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showError();
        if (isLoadMore)
            if (showShop) {
                if (type.equals("1")) {
                    collectionAdapter.loadMoreFail();
                } else {
                    shopAdapter.loadMoreFail();
                }
            } else {
                beauticianAdapter.loadMoreFail();
            }
        if (isRefresh)
            showRefreshLoading(false);
    }

    public void showEmpty() {
        multipleStatusView.showEmpty();
    }

    public void showLoadMoreEnd() {
        if (showShop) {
            if (type.equals("1")) {
                collectionAdapter.loadMoreEnd(false);
            } else {
                shopAdapter.loadMoreEnd(false);
            }
        } else {
            beauticianAdapter.loadMoreEnd(false);
        }
    }

    public void showLoadMoreComplete() {
        if (showShop) {
            if (type.equals("1")) {
                collectionAdapter.loadMoreComplete();
            } else {
                shopAdapter.loadMoreComplete();
            }
        } else {
            beauticianAdapter.loadMoreComplete();
        }
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }
}
