package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.HomeBean;
import com.hualong.kekemei.fragment.adapter.PicAdapter;
import com.hejunlin.superindicatorlibray.LoopViewPager;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class HomeFragment extends Fragment {

    private LoopViewPager viewpager;
    private CircleIndicator indicator;
    private XBanner mXBanner;
    private List<String> imgesUrl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mXBanner = (XBanner) view.findViewById(R.id.xbanner);
    }

    private void initData() {
        OkGo.<String>post(URLs.HOME_URL).params("longitude", "116.4072154982")
                .params("latitude", "39.9047253699").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                imgesUrl = new ArrayList<>();
                HomeBean homeBean = gson.fromJson(response.body(), HomeBean.class);
                //                viewpager.setAdapter(new PicAdapter(getActivity(),homeBean));
                //                viewpager.setLooperPic(true);
                //                indicator.setViewPager(viewpager);
                for (int i = 0; i < homeBean.getData().getBanneradv().size(); i++) {
                    imgesUrl.add(URLs.BASE_URL + homeBean.getData().getBanneradv().get(i).getImage());
                }
                mXBanner.setData(imgesUrl, null);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mXBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mXBanner.stopAutoPlay();
    }
}
