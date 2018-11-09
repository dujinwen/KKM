package com.kekemei.kekemei.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.bean.SearchHistoryBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 搜索历史
 */

public class SearchHistoryManager {
    private static final String TAG = SearchHistoryManager.class.getSimpleName();
    private Context context;
    private int HISTORY_MAX = 20;
    private static SearchHistoryManager instance;
    private OnSearchListener listener;
    private SearchHistoryManager(Context context, int historyMax) {
        this.context = context.getApplicationContext();
        this.HISTORY_MAX = historyMax;
    }

    public static synchronized SearchHistoryManager getInstance(Context context, int historyMax) {
        if (instance == null) {
            synchronized (SearchHistoryManager.class) {
                if (instance == null) {
                    instance = new SearchHistoryManager(context, historyMax);
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void save(String value) {
        if(StringUtils.isEmpty(value)){
           return;
        }
        Map<String, String> histories = (Map<String, String>) getAll();
        for (Map.Entry<String, String> entry : histories.entrySet()) {
            if (value.equals(entry.getValue())) {
                remove(entry.getKey());
            }
        }
        LogUtil.d(TAG,"save:"+value);
        put(generateKey(), value);
    }

    public void remove(String key) {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear() {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    private String generateKey() {
        return System.currentTimeMillis()+"";
    }

    @SuppressWarnings("unchecked")
    public void sortHistory() {
        ArrayList<SearchHistoryBean> mResults = new ArrayList<>();
        Map<String, String> hisAll = (Map<String, String>) getAll();
        //将key排序升序
        Object[] keys = hisAll.keySet().toArray();
        Arrays.sort(keys);
        int keyLength = keys.length;
        //这里计算 如果历史记录条数是大于 可以显示的最大条数，则用最大条数做循环条件，防止历史记录条数-最大条数为负值，数组越界
        int hisLength = keyLength > HISTORY_MAX ? HISTORY_MAX : keyLength;
        for (int i = 1; i <= hisLength; i++) {
            String key = (String) keys[keyLength - i];
            mResults.add(new SearchHistoryBean(key, hisAll.get(key)));
        }
        if(keyLength > HISTORY_MAX){
            clear();
            putAll(mResults);
        }
        if(listener!=null){
            listener.onSortSuccess(mResults);
        }
    }

    public boolean contains(String key) {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    public Map<String, ?> getAll() {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

    public void put(String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }
    private void putAll(ArrayList<SearchHistoryBean> model) {
        SharedPreferences sp = context.getSharedPreferences(PrefManager.SEARCH_HISTORY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        for(int i=0;i<model.size();i++){
            editor.putString(model.get(i).getKey(), model.get(i).getContent());
        }
        editor.apply();
    }
    public void setOnSearchListener(OnSearchListener listener) {
        this.listener = listener;
    }
    public interface OnSearchListener {
        void onSortSuccess(ArrayList<SearchHistoryBean> results);
    }
}
