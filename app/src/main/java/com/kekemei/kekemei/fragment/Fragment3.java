package com.kekemei.kekemei.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    Unbinder unbinder;
    private View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_3, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }
//此方法在Fragment中

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //Fragment隐藏时调用
            Toast.makeText(getActivity(), "隐藏fragment 3", Toast.LENGTH_SHORT).show();
        } else {
            //Fragment显示时调用
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_finish)
    public void onViewClicked() {
        LoginActivity.start(getActivity());
    }
}
