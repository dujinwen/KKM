package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hualong.kekemei.R;
import com.hualong.kekemei.fragment.adapter.PicAdapter;
import com.hejunlin.superindicatorlibray.LoopViewPager;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LoopViewPager viewpager = (LoopViewPager) view.findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewpager.setAdapter(new PicAdapter(getActivity()));
        viewpager.setLooperPic(true);
        indicator.setViewPager(viewpager);


        return view;
    }

}
