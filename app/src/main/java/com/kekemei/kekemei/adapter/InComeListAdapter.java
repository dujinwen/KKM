package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.InComeBean;
import com.kekemei.kekemei.utils.CollectionUtils;

import java.util.List;


public class InComeListAdapter extends BaseQuickAdapter<InComeBean.InfoBeanX, BaseViewHolder> {
    private Context jContext;

    public InComeListAdapter(Context context) {
        super(R.layout.item_in_come_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, InComeBean.InfoBeanX item) {
        helper.setText(R.id.month, item.getMonth(helper.getLayoutPosition()));
        helper.setText(R.id.inCome, "￥ " + item.getOrdersum());
        helper.setText(R.id.realInCome, "￥ " + item.getCount());

        final View arrow = helper.getView(R.id.arrow);
        final RecyclerView childList = helper.getView(R.id.childList);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrow.isSelected()) {
                    arrow.setSelected(false);
                    childList.setVisibility(View.GONE);
                } else {
                    arrow.setSelected(true);
                    childList.setVisibility(View.VISIBLE);
                }
            }
        });
        if (CollectionUtils.isNotEmpty(item.getInfo())) {
            arrow.setClickable(true);
            fillChildList(childList, item.getInfo());
        } else {
            arrow.setClickable(false);
        }
    }

    private void fillChildList(RecyclerView childList, List<InComeBean.InfoBeanX.InfoBean> info) {
        childList.setLayoutManager(new LinearLayoutManager(jContext));
        childList.setHasFixedSize(true);
        childList.setNestedScrollingEnabled(false);
        InComeChildListAdapter adapter = new InComeChildListAdapter(jContext);
        childList.setAdapter(adapter);
        adapter.replaceData(info);
    }
}


