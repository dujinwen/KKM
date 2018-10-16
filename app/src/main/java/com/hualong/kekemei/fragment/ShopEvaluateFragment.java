package com.hualong.kekemei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualong.kekemei.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 店铺评价
 */
public class ShopEvaluateFragment extends Fragment {

    private Unbinder unbinder;

    public static ShopEvaluateFragment newInstance() {
        ShopEvaluateFragment fragment = new ShopEvaluateFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_beautician, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
