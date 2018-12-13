package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.InComeBean;


public class InComeChildListAdapter extends BaseQuickAdapter<InComeBean.InfoBeanX.InfoBean, BaseViewHolder> {
    private Context jContext;

    public InComeChildListAdapter(Context context) {
        super(R.layout.item_in_come_child_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, InComeBean.InfoBeanX.InfoBean item) {
        /*ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getAvatar(), (ImageView) helper.getView(R.id.image));*/
        helper.setText(R.id.day, item.getDate());
        helper.setText(R.id.dayTxt, item.getWeek());
        final RecyclerView childList = helper.getView(R.id.childList);
//        fillChildList(childList);
    }

    private void fillChildList(RecyclerView childList) {
        childList.setLayoutManager(new LinearLayoutManager(jContext));
        childList.setHasFixedSize(true);
        childList.setNestedScrollingEnabled(false);
        InComeGrandSunListAdapter adapter = new InComeGrandSunListAdapter(jContext);
        childList.setAdapter(adapter);
    }
}

