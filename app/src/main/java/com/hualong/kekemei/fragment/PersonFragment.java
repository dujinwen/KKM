package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.CircleImageView;
import com.hualong.kekemei.Utills.NoScrollGridView;
import com.hualong.kekemei.bean.UserBean;
import com.hualong.kekemei.fragment.adapter.GridAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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


    private String[] userForwardArray = {"我的订单", "我的钱包", "我的美容师", "我的收藏", "我的积分","客户服务"};
    private int[] userForwardIconArray = {R.mipmap.user_dingdan_btn, R.mipmap.user_qianbao_btn,
            R.mipmap.user_meirongshi_btn, R.mipmap.user_soucang_btn, R.mipmap.user_dizhi_btn,R.mipmap.user_kefu_btn};

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
