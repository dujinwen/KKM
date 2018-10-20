package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.activity.LoginActivity;
import com.hualong.kekemei.activity.SettingActivity;
import com.hualong.kekemei.activity.UserEvaluateActivity;
import com.hualong.kekemei.activity.UserInfoActivity;
import com.hualong.kekemei.adapter.GridAdapter;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.ForYouBean;
import com.hualong.kekemei.bean.UserBean;
import com.hualong.kekemei.view.CircleImageView;
import com.hualong.kekemei.view.NoScrollGridView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class PersonFragment extends Fragment {

    @BindView(R.id.top_bg)
    View topBg;
    @BindView(R.id.icon)
    CircleImageView icon;

    Unbinder unbinder;
    @BindView(R.id.ncgv)
    NoScrollGridView ncgv;
    @BindView(R.id.tiyan)
    LinearLayout tiyan;
    @BindView(R.id.daijinquan)
    LinearLayout daijinquan;
    @BindView(R.id.hongbao)
    LinearLayout hongbao;
    @BindView(R.id.ll_foryou)
    LinearLayout llForyou;
    @BindView(R.id.rv_tuijian)
    RecyclerView rvTuijian;
    @BindView(R.id.user_set_btn)
    ImageView userSetBtn;
    @BindView(R.id.user_message_btn)
    ImageView userMessageBtn;

    private String[] userForwardArray = {"我的订单", "我的钱包", "我的美容师", "我的收藏", "我的积分", "客户服务"};
    private int[] userForwardIconArray = {R.mipmap.user_dingdan_btn, R.mipmap.user_qianbao_btn,
            R.mipmap.user_meirongshi_btn, R.mipmap.user_soucang_btn, R.mipmap.user_dizhi_btn, R.mipmap.user_kefu_btn};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        List<UserBean> list = new ArrayList<>();

        for (int i = 0; i < userForwardArray.length; i++) {
            UserBean model = new UserBean(userForwardArray[i], userForwardIconArray[i]);
            list.add(model);
        }
        GridAdapter gridAdapter = new GridAdapter(getActivity(), list);
        ncgv.setAdapter(gridAdapter);


        OkGo.<String>get(URLs.WEINITUIJIAN).params("page", 1).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                ForYouBean forYouBean = gson.fromJson(response.body(), ForYouBean.class);
                if (forYouBean.getCode() == 1 && forYouBean.getData().size() != 0) {
                    llForyou.setVisibility(View.VISIBLE);
                } else {
                    llForyou.setVisibility(View.GONE);
                    return;
                }

                rvTuijian.setLayoutManager(new GridLayoutManager(getActivity(), 2));

                MyGridAdapter adapter = new MyGridAdapter(getActivity(), MyGridAdapter.PERSON_TUI_JIAN);
                rvTuijian.setAdapter(adapter);
                adapter.addData(forYouBean.getData());
            }
        });
    }

    @OnClick({R.id.user_set_btn, R.id.userName, R.id.icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_set_btn:
                SettingActivity.start(getActivity());
//                MiaoshaActivity.start(getActivity());
//                UserEvaluateActivity.start(getActivity(), true);
                break;
            case R.id.icon:
                LoginActivity.start(getActivity());
                break;
            case R.id.userName:
                UserInfoActivity.start(getActivity());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
