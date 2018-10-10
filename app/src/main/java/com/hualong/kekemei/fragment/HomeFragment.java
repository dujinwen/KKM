package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.HomeBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

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
public class HomeFragment extends Fragment {

    @BindView(R.id.place)
    TextView place;
    @BindView(R.id.ll_place)
    LinearLayout llPlace;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.id_msg)
    LinearLayout idMsg;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    Unbinder unbinder;
    private List<String> imgesUrl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        initData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    private void initData() {
        OkGo.<String>post(URLs.HOME_URL).params("longitude", "116.4072154982")
                .params("latitude", "39.9047253699").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                imgesUrl = new ArrayList<>();
                HomeBean homeBean = gson.fromJson(response.body(), HomeBean.class);
                for (int i = 0; i < homeBean.getData().getBanneradv().size(); i++) {
                    imgesUrl.add(URLs.BASE_URL + homeBean.getData().getBanneradv().get(i).getImage());
                }
                xbanner.setData(imgesUrl, null);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        xbanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        xbanner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
