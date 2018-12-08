package com.kekemei.kekemei.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.HelpCenterActivity;
import com.kekemei.kekemei.activity.SettingActivity;
import com.kekemei.kekemei.utils.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainMenuLeftFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.version)
    TextView version;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_layout_left_menu, container, false);
        unbinder = ButterKnife.bind(this, view);
        version.setText("版本号" + AppUtil.getVersionName(getActivity()));
        return view;
    }

    @OnClick({R.id.headerImageView, R.id.userNameText, R.id.userSetting,
            R.id.changePhone, R.id.helpCenter, R.id.contractServer, R.id.aboutUs})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.headerImageView:
                break;
            case R.id.userNameText:
                break;
            case R.id.userSetting:
                SettingActivity.start(getActivity());
                break;
            case R.id.changePhone:
                break;
            case R.id.helpCenter:
                HelpCenterActivity.start(getActivity());
                break;
            case R.id.contractServer:
                break;
            case R.id.aboutUs:
                break;
        }
    }

    /**
     * 初始化默认数据【这个需要在activity中执行，原因是：在布局文件中通过<fragment>的方式引用Fragment，打开Activity的时候，Fragment的生命周期函数均执行了】
     * 那么就存在一个问题，初始化fragment中的数据，可能会在activity数据初始化之前执行
     */
    public void setDefaultDatas() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
