package com.kekemei.kekemei.fragment;

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
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.LoginActivity;
import com.kekemei.kekemei.activity.MessageActivity;
import com.kekemei.kekemei.activity.MyRedBaoActivity;
import com.kekemei.kekemei.activity.MyVoucherActivity;
import com.kekemei.kekemei.activity.SettingActivity;
import com.kekemei.kekemei.activity.UserInfoActivity;
import com.kekemei.kekemei.adapter.GridAdapter;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.bean.CouponDataBean;
import com.kekemei.kekemei.bean.ForYouBean;
import com.kekemei.kekemei.bean.HongBaoDataBean;
import com.kekemei.kekemei.bean.UserBean;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.CircleImageView;
import com.kekemei.kekemei.view.NoScrollGridView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

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
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.tv_tiyannum)
    TextView tvTiyannum;
    @BindView(R.id.tv_daijinnum)
    TextView tvDaijinnum;
    @BindView(R.id.tv_hongbaonum)
    TextView tvHongbaonum;

    private String[] userForwardArray = {"我的好友", "关注的店铺", "我的美容师", "我的收藏",
            "我的订单", "我的积分", "会员优惠", "客户服务"};
    private int[] userForwardIconArray = {
            R.mipmap.user_haoyou_btn, R.mipmap.user_dianpu_btn,
            R.mipmap.user_meirongshi_btn, R.mipmap.user_soucang_btn,
            R.mipmap.user_dingdan_btn, R.mipmap.user_dizhi_btn,
            R.mipmap.user_qianbao_btn, R.mipmap.user_kefu_btn};

    private CouponDataBean couponBean;
    private HongBaoDataBean hongBaoBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + UserHelp.getAvatar(getActivity()), icon);
        userName.setText(UserHelp.getUserName(getActivity()));
    }


    private void initData() {
        List<UserBean> list = new ArrayList<>();

        for (int i = 0; i < userForwardArray.length; i++) {
            UserBean model = new UserBean(userForwardArray[i], userForwardIconArray[i]);
            list.add(model);
        }
        GridAdapter gridAdapter = new GridAdapter(getActivity(), list);
        ncgv.setAdapter(gridAdapter);


        OkGo.<String>get(URLs.FOR_YOU).params("page", 1).execute(new StringCallback() {
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


        OkGo.<String>get(URLs.MY_RED_ENVELOPES).params("page", 1).params("user_id", UserHelp.getUserId(getActivity())).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        tvHongbaonum.setText("0");
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                hongBaoBean = gson.fromJson(response.body(), HongBaoDataBean.class);
                tvHongbaonum.setText(hongBaoBean.getData().size() + "");

            }
        });

        OkGo.<String>get(URLs.MY_COUPON).params("page", 1).params("user_id", UserHelp.getUserId(getActivity())).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        tvDaijinnum.setText("0");
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                couponBean = gson.fromJson(response.body(), CouponDataBean.class);
                tvDaijinnum.setText(couponBean.getData().size() + "");
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
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
                UserInfoActivity.start(getActivity(), UserHelp.getUserId(getActivity()) + "");
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tiyan, R.id.daijinquan, R.id.hongbao, R.id.user_message_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tiyan:

                break;
            case R.id.daijinquan:
                if (couponBean == null) return;
                MyVoucherActivity.start(getActivity(), couponBean);
                break;
            case R.id.hongbao:
                if (hongbao == null) return;
                MyRedBaoActivity.start(getActivity(), hongBaoBean);
                break;
            case R.id.user_message_btn:
                MessageActivity.start(getActivity());
                break;
        }
    }

}
