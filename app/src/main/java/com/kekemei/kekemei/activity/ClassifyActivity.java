package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.FindOrderListAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.ProjectListBean;
import com.kekemei.kekemei.bean.ProjectShaiXuanListBean;
import com.kekemei.kekemei.utils.EndLessOnScrollListener;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created 分类 by peiyangfan on 2018/10/24.
 */

public class ClassifyActivity extends BaseActivity {


    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.fenlei)
    ImageView fenlei;
    @BindView(R.id.tv_meirong)
    TextView tvMeirong;
    @BindView(R.id.v_meirong)
    View vMeirong;
    @BindView(R.id.tal_meirong)
    LinearLayout talMeirong;
    @BindView(R.id.tv_meiti)
    TextView tvMeiti;
    @BindView(R.id.v_meiti)
    View vMeiti;
    @BindView(R.id.tal_meiti)
    LinearLayout talMeiti;
    @BindView(R.id.tv_yangsheng)
    TextView tvYangsheng;
    @BindView(R.id.v_yangsheng)
    View vYangsheng;
    @BindView(R.id.tal_yangsheng)
    LinearLayout talYangsheng;
    @BindView(R.id.tv_qita)
    TextView tvQita;
    @BindView(R.id.v_qita)
    View vQita;
    @BindView(R.id.tal_qita)
    LinearLayout talQita;
    @BindView(R.id.tv_shaixuan)
    TextView tvShaixuan;
    @BindView(R.id.iv_shaixuan)
    ImageView ivShaixuan;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.ll_fanhui)
    LinearLayout llFanhui;
    @BindView(R.id.rv_pinglunbiaoqian)
    RecyclerView rvPinglunbiaoqian;
    @BindView(R.id.ll_pop)
    LinearLayout llPop;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.rl_list)
    RelativeLayout rlList;
    private PingLunBiaoQianGridViewAdapter pingLunBiaoQianGridViewAdapter;
    private ArrayList<SelectBean> objects;
    private FindOrderListAdapter listAdapter;
    @SuppressWarnings("unchecked")
    private static HashSet<Integer> positionArrayList = new HashSet<>();
    private LinearLayoutManager linearLayoutManager;
    private int type = R.id.tal_meirong;
    private int isCheck = -1;

    @Override
    protected int setLayoutId() {
        return R.layout.classify_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        llFanhui.setVisibility(View.VISIBLE);
        getPingLunBiaoQian();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @OnClick({R.id.fanhui, R.id.tal_meirong, R.id.tal_meiti, R.id.tal_yangsheng, R.id.tal_qita, R.id.tv_shaixuan,
            R.id.iv_shaixuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.tal_meirong:
            case R.id.tal_meiti:
            case R.id.tal_yangsheng:
            case R.id.tal_qita:
                setSelect(view.getId());
                tvShaixuan.setSelected(false);
                llPop.setVisibility(View.GONE);
                break;
            case R.id.tv_shaixuan:
            case R.id.iv_shaixuan:
                tvShaixuan.setSelected(tvShaixuan.isSelected() ? false : true);
                llPop.setVisibility(llPop.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;
        }
    }

    private void getPingLunBiaoQian() {
        //        OkGo.<String>get(URLs.COMMENT_TAG_URL)
        objects = new ArrayList<>();

        objects.add(new SelectBean("收藏最多", false));
        objects.add(new SelectBean("评论最多", false));
        objects.add(new SelectBean("销量最多", false));
        //        pingLunBiaoQianGridViewAdapter.notifyDataSetChanged();
    }


    private void setSelect(int id) {

        tvMeirong.setSelected(id == R.id.tal_meirong);
        vMeirong.setVisibility(id == R.id.tal_meirong ? View.VISIBLE : View.INVISIBLE);

        tvMeiti.setSelected(id == R.id.tal_meiti);
        vMeiti.setVisibility(id == R.id.tal_meiti ? View.VISIBLE : View.INVISIBLE);

        tvYangsheng.setSelected(id == R.id.tal_yangsheng);
        vYangsheng.setVisibility(id == R.id.tal_yangsheng ? View.VISIBLE : View.INVISIBLE);

        tvQita.setSelected(id == R.id.tal_qita);
        vQita.setVisibility(id == R.id.tal_qita ? View.VISIBLE : View.INVISIBLE);
        switch (id) {
            case R.id.tal_meirong:
                page = 1;
                category = 1;
                getData(page, category, isCheck);
                break;
            case R.id.tal_meiti:
                category = 2;
                page = 1;
                getData(page, category, isCheck);
                break;
            case R.id.tal_yangsheng:
                category = 3;
                page = 1;
                getData(page, category, isCheck);
                break;
            case R.id.tal_qita:
                category = 4;
                page = 1;
                getData(page, category, isCheck);
                break;
            default:

                break;
        }

    }


    @Override
    protected void initData() {
        super.initData();
        linearLayoutManager = new LinearLayoutManager(getBaseContext());
        rvList.setLayoutManager(linearLayoutManager);
        listAdapter = new FindOrderListAdapter(getBaseContext());
        rvList.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BaseBean data = listAdapter.getItem(position);
                ProjectDetailActivity.start(ClassifyActivity.this, data.getId(), -1,-1L);
            }
        });


        rvList.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 1);
        //        setSelect(type);
        switch (type) {
            case 1:
                onViewClicked(talMeirong);
                break;
            case 2:
                onViewClicked(talMeiti);
                break;
            case 3:
                onViewClicked(talYangsheng);
                break;
            case 4:
                onViewClicked(talQita);
                break;
            default:

                break;
        }
        rvPinglunbiaoqian.setLayoutManager(new GridLayoutManager(ClassifyActivity.this, 3));
        pingLunBiaoQianGridViewAdapter = new PingLunBiaoQianGridViewAdapter();
        rvPinglunbiaoqian.setAdapter(pingLunBiaoQianGridViewAdapter);
    }


    private void loadMoreData() {
        page = page++;
        getData(page, category, isCheck);
    }

    private int page = 1;
    private int category = 1;
    private ArrayList<BaseBean> arrayList = new ArrayList<>();

    private void getData(final int page, int category, final int isCheck) {
        String latitude = SPUtils.getString(ClassifyActivity.this, "latitude", "");
        String longitude = SPUtils.getString(ClassifyActivity.this, "longitude", "");
        String url = "";
        switch (isCheck) {
            case -1:
                url = URLs.DISCOVE;
                break;
            case 0:
                url = URLs.PROJECT_SORT_COLLECTION;
                break;
            case 1:
                url = URLs.PROJECT_SORT;
                break;
            case 2:
                url = URLs.PROJECT_SORT_ORDER;
                break;

        }

        OkGo.<String>post(url)
                .params("page", page)
                .params("longitude", longitude)
                .params("latitude", latitude)
                .params("category", category).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ShopActivity", "project list:" + response.body());

                try {
                    JSONObject obj = new JSONObject(response.body());


                    Gson gson = new Gson();
                    List<BaseBean> baseBeans = null;
                    if (isCheck == -1) {
                        ProjectListBean.DataBeanX data = gson.fromJson(response.body(), ProjectListBean.class).getData();
                        if (data.getData().size() == 0 || data.getData().isEmpty()) {
                            multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                            return;
                        }
                        baseBeans = data.getData();
                    } else {
                        if (obj.getString("data").equals("null")
                                || obj.getString("data") == null
                                || obj.getString("data").isEmpty()
                                ) {
                            multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                            return;
                        }
                        baseBeans = gson.fromJson(response.body(), ProjectShaiXuanListBean.class).getData();
                    }
                    multipleStatusView.showOutContentView(rvList);
                    if (page == 1) {
                        arrayList.clear();
                    }
                    arrayList.addAll(baseBeans);
                    listAdapter.setNewData(arrayList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }


    private class PingLunBiaoQianGridViewAdapter extends RecyclerView.Adapter<PingLunBiaoQianGridViewAdapter.MyViewHolder> {
        private boolean isClick = false;

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ClassifyActivity.this).inflate(R.layout.item_pinglun, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            holder.tv.setText(objects.get(position).getName());
            if (objects.get(position).isSelected()) {
                holder.tv.setBackgroundResource(R.mipmap.classification_shaixuan_xuanze_btn_s);
                holder.tv.setTextColor(0xFF7AD2D2);
            } else {
                holder.tv.setBackgroundResource(R.drawable.btn_line_background);
                holder.tv.setTextColor(0xFF999999);
            }
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (SelectBean object : objects) {
                        object.setSelected(false);
                        holder.tv.setBackgroundResource(R.drawable.btn_line_background);
                        holder.tv.setTextColor(0xFF999999);
                    }
                    page = 1;
                    objects.get(position).setSelected(true);
                    if (isClick) {
                        isCheck = -1;
                    } else {
                        isCheck = position;
                    }
                    notifyDataSetChanged();
                    isClick = !isClick;
                    getData(page, category, isCheck);

                    tvShaixuan.setSelected(tvShaixuan.isSelected() ? false : true);
                    llPop.setVisibility(llPop.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                }
            });
        }


        @Override
        public int getItemCount() {
            return objects.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.btn_pingjia);
            }

        }
    }

    class SelectBean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        private boolean isSelected;

        public SelectBean(String name, boolean isSelected) {
            this.name = name;
            this.isSelected = isSelected;
        }
    }

}
