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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
