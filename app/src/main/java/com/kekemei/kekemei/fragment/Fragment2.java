package com.kekemei.kekemei.fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kekemei.kekemei.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    @BindView(R.id.sq_zhengjian)
    ImageView sqZhengjian;
    @BindView(R.id.sq_ziliao)
    ImageView sqZiliao;
    @BindView(R.id.sq_wait_shenhe)
    ImageView sqWaitShenhe;
    @BindView(R.id.tv_btn)
    TextView tvBtn;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.changesex_button)
    Button changesexButton;
    @BindView(R.id.changesex_textview)
    TextView changesexTextview;
    @BindView(R.id.changebirth_button)
    Button changebirthButton;
    @BindView(R.id.changebirth_textview)
    TextView changebirthTextview;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.changeaddress_button)
    Button changeaddressButton;
    @BindView(R.id.item_city_name_tv)
    TextView itemCityNameTv;

    private View mView;
    private OnButtonClick onButtonClick;
//东城，西城，海淀，朝阳，石景山，丰台 近郊： 昌平，通州，顺义，大兴，房山，门头沟 远郊： 平谷，密云，怀柔，延庆
    private String[] sexArry = new String[]{"女", "男"};// 性别选择
    private String[] addressList = new String[]{"东城", "西城","朝阳","昌平","海淀","石景山"
            ,"丰台","通州","顺义","大兴","房山","门头沟","平谷","密云","怀柔","延庆"};// 城市选择
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_2, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }
//此方法在Fragment中

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //Fragment隐藏时调用
            Toast.makeText(getActivity(), "隐藏fragment 2", Toast.LENGTH_SHORT).show();
        } else {
            //Fragment显示时调用
        }

    }


    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private boolean flag = false;


    private AlertDialog dlg;

    @OnClick({ R.id.tv_btn, R.id.btn_next,
            R.id.changesex_button, R.id.changebirth_button, R.id.changeaddress_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_btn:
                if (!flag)
                    tvBtn.setBackground(getResources().getDrawable(R.drawable.text_bg_shap));
                else {
                    tvBtn.setBackground(getResources().getDrawable(R.drawable.text_bg_shap_null));
                }
                flag = !flag;
                break;
            case R.id.btn_next:
                onButtonClick.onClick(btnNext);
                break;

            case R.id.changebirth_button:
                Calendar nowdate = Calendar.getInstance();
                final int mYear = nowdate.get(Calendar.YEAR);
                final int mMonth = nowdate.get(Calendar.MONTH);
                final int mDay = nowdate.get(Calendar.DAY_OF_MONTH);
                //调用DatePickerDialog
                new DatePickerDialog(getActivity(), onDateSetListener, mYear, mMonth, mDay).show();
                break;
            case R.id.changesex_button:
                showSexChooseDialog();
                break;
            case R.id.changeaddress_button:
                showAddressChooseDialog();
                break;
        }
    }

    private void showAddressChooseDialog() {
        AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());// 自定义对话框
        builder3.setSingleChoiceItems(addressList, 0, new DialogInterface.OnClickListener() {// 2默认的选中

            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                // showToast(which+"");
                itemCityNameTv.setText(addressList[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder3.show();// 让弹出框显示
    }

    private void showSexChooseDialog() {
        AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());// 自定义对话框
        builder3.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {// 2默认的选中

            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                // showToast(which+"");
                changesexTextview.setText(sexArry[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder3.show();// 让弹出框显示
    }
    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            String days;
            days = new StringBuffer().append(mYear).append("年").append(mMonth).append("月").append(mDay).append("日").toString();
            changebirthTextview.setText(days);
        }
    };

    public interface OnButtonClick {
        public void onClick(View view);
    }
}
