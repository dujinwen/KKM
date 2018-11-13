package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.HongBaoDataAdapter;
import com.kekemei.kekemei.bean.CouponDataBean;
import com.kekemei.kekemei.bean.HongBaoDataBean;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peiyangfan on 2018/11/5.
 */

public class MyRedBaoActivity extends BaseActivity {
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private static HongBaoDataBean hongBaoDataBean;
    private HongBaoDataAdapter adapter;

    public static void start(Context context) {

        Intent intent = new Intent(context, MyRedBaoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_my_voucher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        super.initData();

        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HongBaoDataAdapter();
        rvList.setAdapter(adapter);


        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //数据是使用Intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("result", hongBaoDataBean.getData().get(position).getRedenvelopes().getPrice_reduction());
                setResult(RESULT_OK, intent);
                finish();
            }
        });


        OkGo.<String>get(URLs.MY_RED_ENVELOPES).params("page", 1).params("user_id",
                UserHelp.getUserId(this)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                hongBaoDataBean = gson.fromJson(response.body(), HongBaoDataBean.class);
                adapter.setNewData(hongBaoDataBean.getData());
            }
        });
    }
}
