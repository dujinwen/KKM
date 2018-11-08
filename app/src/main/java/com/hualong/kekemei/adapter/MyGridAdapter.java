package com.hualong.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class MyGridAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    public static final int PERSON_TUI_JIAN = 5;
    private Context context;
    private int type;

    public static final int NewmemberdataBean = 0;
    public static final int HotdataBean= 1;
    public static final int MemberdataBean = 2;
    public static final int SpecialdataBean = 3;
    public static final int ORDER_HOT_BEAN = 4;

    public MyGridAdapter(Context context, int type) {
        super(R.layout.huodong_layout);
        this.context = context;

        this.type = type;

    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
            //                setData(item1);
            helper.setText(R.id.tv_name, item.getName());
            helper.setText(R.id.now_price, item.getPrice_newmember() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item.getImage(), (ImageView) helper.getView(R.id.iv_beautician_photo));
            //        helper.setText(R.id.tv_renshu,item1.getPrice()+"");
        helper.addOnClickListener(R.id.ll_huodong);

    }

}
