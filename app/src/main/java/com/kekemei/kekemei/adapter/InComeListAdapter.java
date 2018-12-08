package com.kekemei.kekemei.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.EvaluateBean;


public class InComeListAdapter extends BaseQuickAdapter<EvaluateBean, BaseViewHolder> {
    private Context jContext;

    public InComeListAdapter(Context context) {
        super(R.layout.item_in_come_list_layout, null);
        this.jContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, EvaluateBean item) {
        /*ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + item.getAvatar(), (ImageView) helper.getView(R.id.image));
        helper.setText(R.id.month, item.getNickname());
          helper.setText(R.id.inCome, item.getSatisfaction_text());
        helper.setText(R.id.realInCome, item.getContent());*/

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

        fillChildList(childList);
    }

    private void fillChildList(RecyclerView childList) {
        childList.setLayoutManager(new LinearLayoutManager(jContext));
        childList.setHasFixedSize(true);
        childList.setNestedScrollingEnabled(false);
        InComeChildListAdapter adapter = new InComeChildListAdapter(jContext);
        childList.setAdapter(adapter);

    }
}


