package com.hualong.kekemei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.utils.AppUtil;
import com.hualong.kekemei.utils.CollectionUtils;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.bean.HotSearchBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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
    @BindView(R.id.historyEmpty)
    TextView historyEmpty;

    @BindView(R.id.layoutHotSearchFlowLayout)
    FlexboxLayout layoutHotSearchFlowLayout;

    private Unbinder unbinder;

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
        initData();
        return view;
    }

    private void initData() {
        OkGo.<String>post(URLs.HOT_SEARCH)
                .tag(this)
                .params("user_id", "1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e("Search", "body:" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            if (msg.equals("暂无数据")) {
                                onResult(null);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Gson gson = new Gson();
                        HotSearchBean hotSearchBean = gson.fromJson(response.body(), HotSearchBean.class);
                        onResult(hotSearchBean);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAG", response.message());
                        onResult(null);
                    }
                });
    }

    private void onResult(Object response) {
        HotSearchBean hotSearchBean = (HotSearchBean) response;
        if (null == response || null == hotSearchBean.getData()) {
            historyEmpty.setVisibility(View.VISIBLE);
        } else {
            if (CollectionUtils.isNotEmpty(hotSearchBean.getData().getHistory())) {
                fillHistoryWordArea(hotSearchBean.getData().getHistory());
            } else {
                historyEmpty.setVisibility(View.VISIBLE);
            }
            if (CollectionUtils.isNotEmpty(hotSearchBean.getData().getHost())) {
                fillHotWordArea(hotSearchBean.getData().getHost());
            } else {
            }
        }
    }

    /**
     * 填充历史搜索区域
     */
    private void fillHistoryWordArea(final List<String> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        layoutHistoryFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_search_history_item, layoutHistoryFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i))) {
                txt.setText(result.get(i));
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                    }
                });
                layoutHistoryFlowLayout.addView(txt);
            }
        }
    }

    /**
     * 填充热门搜索区域
     */
    private void fillHotWordArea(final List<String> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        layoutHotSearchFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_search_history_item, layoutHotSearchFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i))) {
                txt.setText(result.get(i));
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                    }
                });
                layoutHotSearchFlowLayout.addView(txt);
            }
        }
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
