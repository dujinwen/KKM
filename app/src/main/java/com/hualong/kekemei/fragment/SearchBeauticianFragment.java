package com.hualong.kekemei.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualong.kekemei.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hualong.kekemei.activity.SearchActivity.EXTRA_KEY_KEYWORD;


/**
 * 搜索-美容师
 */
public class SearchBeauticianFragment extends Fragment implements SearchIPage {

    private Unbinder unbinder;

    public static SearchBeauticianFragment newInstance(String keyWord) {
        SearchBeauticianFragment fragment = new SearchBeauticianFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY_KEYWORD, keyWord);
        fragment.setArguments(bundle);
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

    @Override
    public void onEnter(String keyWord) {

    }

    @Override
    public void onLeave() {

    }
}
