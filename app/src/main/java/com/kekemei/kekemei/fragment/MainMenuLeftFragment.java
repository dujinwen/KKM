package com.kekemei.kekemei.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.HelpCenterActivity;
import com.kekemei.kekemei.activity.UserInfoActivity;
import com.kekemei.kekemei.activity.WebActivity;
import com.kekemei.kekemei.bean.BeauticianHomeBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainMenuLeftFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.headerImageView)
    CircleImageView headerImageView;
    @BindView(R.id.userNameText)
    TextView userNameText;
    @BindView(R.id.version)
    TextView version;

    private BeauticianHomeBean beauticianHomeBean;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_layout_left_menu, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.userSetting, R.id.helpCenter, R.id.contractServer, R.id.aboutUs})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userSetting:
                UserInfoActivity.start(getActivity(), UserHelp.getUserId(getActivity()) + "", true);
                break;
            case R.id.helpCenter:
                HelpCenterActivity.start(getActivity());
                break;
            case R.id.contractServer:
                if (StringUtils.isNotEmpty(beauticianHomeBean.getAdmin_tel())) {
                    AppUtil.callPhone(getActivity(), beauticianHomeBean.getAdmin_tel());
                }
                break;
            case R.id.aboutUs:
                WebActivity.start(getActivity(), URLs.ABOUS + 1);
                break;
        }
    }

    /**
     * 初始化默认数据【这个需要在activity中执行，原因是：在布局文件中通过<fragment>的方式引用Fragment，打开Activity的时候，Fragment的生命周期函数均执行了】
     * 那么就存在一个问题，初始化fragment中的数据，可能会在activity数据初始化之前执行
     */
    public void setDefaultDatas(BeauticianHomeBean beauticianHomeBean) {
        this.beauticianHomeBean = beauticianHomeBean;
        Glide.with(getActivity()).load(URLs.BASE_URL + beauticianHomeBean.getImage()).into(headerImageView);
//        ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + beauticianHomeBean.getImage(), headerImageView);
        userNameText.setText(beauticianHomeBean.getName());
        version.setText("版本号" + beauticianHomeBean.getVersion());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
