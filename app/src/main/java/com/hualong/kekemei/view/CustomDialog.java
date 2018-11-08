package com.hualong.kekemei.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;

import butterknife.BindView;


/**
 * Created by peiyangfan on 2018/3/21.
 */

public class CustomDialog extends Dialog {




    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {

        private View layout;
        private CustomDialog dialog;
        private Context mContext;
        private int count = 0;
        private View.OnClickListener singleButtonClickListener;

        private LinearLayout llOneRed;
        private LinearLayout llTowRed;
        private LinearLayout llThrRed;
        private TextView tvOneName,tvOneNeirong,tvNameOne2,tvNeirongOne2,tvNeirongTow2,tvNameTow2
                ,tvNameOne3,tvNeirongOne3,tvNameTow3,tvNeirongTow3,tvNameThr3,tvNeirongThr3;
        public Builder(Context context) {
            //这里传入自定义的style，直接影响此Dialog的显示效果。style具体实现见style.xml
            mContext = context;
            dialog = new CustomDialog(context, R.style.Dialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.activity_coupons, null);

            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


            llOneRed = layout.findViewById(R.id.ll_one_red);
            llTowRed = layout.findViewById(R.id.ll_tow_red);
            llThrRed = layout.findViewById(R.id.ll_thr_red);
             tvOneName = layout.findViewById(R.id.tv_one_name);
            tvNameTow2 = layout.findViewById(R.id.tv_name_tow_2);
            tvNameOne2 = layout.findViewById(R.id.tv_name_one_2);
            tvNameOne3 =  layout.findViewById(R.id.tv_name_one_3);
            tvNameTow3 =  layout.findViewById(R.id.tv_name_tow_3);
            tvNameThr3 = layout.findViewById(R.id.tv_name_thr_3);

            tvOneNeirong = layout.findViewById(R.id.tv_one_neirong);
            tvNeirongOne2 =  layout.findViewById(R.id.tv_neirong_one_2);
            tvNeirongTow2 =  layout.findViewById(R.id.tv_neirong_tow_2);
            tvNeirongOne3 = layout.findViewById(R.id.tv_neirong_one_3);
            tvNeirongTow3 = layout.findViewById(R.id.tv_neirong_tow_3);
            tvNeirongThr3 = layout.findViewById(R.id.tv_neirong_thr_3);
        }
        private String strOneXinxi,strOneName,strOneNeirong,strTowXinxi,strNameOne2,strNeirongOne2,strNameTow2,strNeirongTow2,
                strThrXinxi,strNameOne3,strNeirongOne3,strNameTow3,strNeirongTow3,strNameThr3,strNeirongThr3 = null;
        public Builder setTvOneXinxi(String strOneXinxi) {
            this.strOneXinxi = strOneXinxi;
            return this;
        }

        public Builder setTvOneName(String strOneName) {
            this.strOneName = strOneName;
            return this;
        }

        public Builder setTvOneNeirong(String strOneNeirong) {
            this.strOneNeirong = strOneNeirong;
            return this;
        }


        public Builder setTvTowXinxi(String strTowXinxi) {
            this.strTowXinxi = strTowXinxi;
            return this;
        }

        public Builder setTvNameOne2(String strNameOne2) {
            this.strNameOne2 = strNameOne2;
            return this;
        }

        public Builder setTvNeirongOne2(String strNeirongOne2) {
            this.strNeirongOne2 = strNeirongOne2;
            return this;
        }

        public Builder setTvNameTow2(String strNameTow2) {
            this.strNameTow2 = strNameTow2;
            return this;
        }

        public Builder setTvNeirongTow2(String strNeirongTow2) {
            this.strNeirongTow2 = strNeirongTow2;
            return this;
        }


        public Builder setTvThrXinxi(String strThrXinxi) {
            this.strThrXinxi = strThrXinxi;
            return this;
        }

        public Builder setTvNameOne3(String strNameOne3) {
            this.strNameOne3 = strNameOne3;
            return this;
        }

        public Builder setTvNeirongOne3(String strNeirongOne3) {
            this.strNeirongOne3 = strNeirongOne3;
            return this;
        }

        public Builder setTvNameTow3(String strNameTow3) {
            this.strNameTow3 = strNameTow3;
            return this;
        }

        public Builder setTvNeirongTow3(String strNeirongTow3) {
            this.strNeirongTow3 = strNeirongTow3;
            return this;
        }

        public Builder setTvNameThr3(String strNameThr3) {
            this.strNameThr3 = strNameThr3;
            return this;
        }

        public Builder setTvNeirongThr3(String strNeirongThr3) {
            this.strNeirongThr3 = strNeirongThr3;
            return this;
        }
        public Builder setSingleButton( View.OnClickListener listener) {
            this.singleButtonClickListener = listener;
            return this;
        }

        public CustomDialog createDialog(Context context,int count) {
            layout.findViewById(R.id.iv_btn_lingqu).setOnClickListener(singleButtonClickListener);
            switch (count) {
                case 1:
                    llOneRed.setVisibility(View.VISIBLE);
                    llTowRed.setVisibility(View.GONE);
                    llThrRed.setVisibility(View.GONE);
                    break;
                case 2:
                    llOneRed.setVisibility(View.GONE);
                    llTowRed.setVisibility(View.VISIBLE);
                    llThrRed.setVisibility(View.GONE);
                    break;
                case 3:
                    llOneRed.setVisibility(View.GONE);
                    llTowRed.setVisibility(View.GONE);
                    llThrRed.setVisibility(View.VISIBLE);
                    break;

                default:

                    break;
            }
            setText();
            createWith();
            return dialog;
        }
        private void setText() {
            tvOneName.setText(strOneName);
            tvOneNeirong.setText(strOneNeirong);

            tvNameOne2.setText(strNameOne2);
            tvNeirongOne2.setText(strNeirongOne2);
            tvNameTow2.setText(strNameTow2);
            tvNeirongTow2.setText(strNeirongTow2);

            tvNameOne3.setText(strNameOne3);
            tvNeirongOne3.setText(strNeirongOne3);
            tvNameTow3.setText(strNameTow3);
            tvNeirongTow3.setText(strNeirongTow3);
            tvNameThr3.setText(strNameThr3);
            tvNeirongThr3.setText(strNeirongThr3);
        }


        private void createWith() {


            dialog.setContentView(layout);
            dialog.setCancelable(true);     //用户可以点击手机Back键取消对话框显示
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}
