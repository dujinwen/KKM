package com.hualong.kekemei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.Utills.CollectionUtils;
import com.hualong.kekemei.bean.SearchHistoryBean;
import com.hualong.kekemei.manager.SearchHistoryManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hualong.kekemei.activity.SearchActivity.EXTRA_KEY_KEYWORD;


/**
 * 搜索-全部
 */
public class SearchAllFragment extends Fragment implements SearchIPage {

    @BindView(R.id.layoutHistoryFlowLayout)
    FlexboxLayout layoutHistoryFlowLayout;

    @BindView(R.id.layoutHotSearchFlowLayout)
    FlexboxLayout layoutHotSearchFlowLayout;

    private Unbinder unbinder;
    private SearchHistoryManager searchHistoryManager;
    private static final int historyMax = 10;

    private String keyWord = "";

    public static SearchAllFragment newInstance(String keyWord) {
        SearchAllFragment fragment = new SearchAllFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY_KEYWORD, keyWord);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        keyWord = getArguments().getString(EXTRA_KEY_KEYWORD);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_all, container, false);
        unbinder = ButterKnife.bind(this, view);
        initSearchHistoryArea();
        return view;
    }

    /**
     * 初始化历史搜索区域
     */
    @SuppressWarnings("ConstantConditions")
    private void initSearchHistoryArea() {
        searchHistoryManager = SearchHistoryManager.getInstance(getActivity(), historyMax);
        searchHistoryManager.setOnSearchListener(new SearchHistoryManager.OnSearchListener() {
            @Override
            public void onSortSuccess(ArrayList<SearchHistoryBean> results) {
                fillHistoryWordArea(results);
            }
        });
        searchHistoryManager.sortHistory();
    }

    /**
     * 填充历史搜索区域
     *
     * @param result 本地保存的历史搜索内容
     */
    private void fillHistoryWordArea(final ArrayList<SearchHistoryBean> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        layoutHistoryFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_search_history_item, layoutHistoryFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i).getContent())) {
                txt.setText(result.get(i).getContent());
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                        searchHistoryManager.save(content);
                    }
                });
                layoutHistoryFlowLayout.addView(txt);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        searchHistoryManager.setOnSearchListener(null);
        unbinder.unbind();
    }

    @Override
    public void onEnter(String keyWord) {

    }

    @Override
    public void onLeave() {

    }
}
