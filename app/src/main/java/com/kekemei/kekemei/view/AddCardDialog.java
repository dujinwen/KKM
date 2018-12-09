package com.kekemei.kekemei.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddCardDialog extends Dialog {
    private Unbinder bind;
    @BindView(R.id.et_bank_card_name)
    EditText et_bank_card_name;
    @BindView(R.id.et_bank_card_id)
    EditText et_bank_card_id;
    @BindView(R.id.et_your_name)
    EditText et_your_name;
    @BindView(R.id.et_phone_num)
    EditText et_phone_num;
    @BindView(R.id.btn_submit)
    TextView btn_submit;

    public AddCardDialog(@NonNull Context context) {
        super(context, R.style.common_dialog);
        setContentView(R.layout.dialog_add_bank_car);
        bind = ButterKnife.bind(this);
        initDialog();
    }

    private void initDialog() {
        Window window = getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);
    }

    @OnClick({R.id.btn_submit, R.id.ib_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                addBankCard();
                break;
            case R.id.ib_close:
                dismiss();
                break;
        }
    }

    private void addBankCard() {
        String cardName = et_bank_card_name.getText().toString();
        if (StringUtils.isEmpty(cardName)) {
            ToastUtil.showToastMsg(getContext(), "请输入卡片所属行");
            return;
        }
        String cardNumber = et_bank_card_id.getText().toString();
        if (StringUtils.isEmpty(cardNumber)) {
            ToastUtil.showToastMsg(getContext(), "请输入卡号");
            return;
        }
        String name = et_your_name.getText().toString();
        if (StringUtils.isEmpty(name)) {
            ToastUtil.showToastMsg(getContext(), "请输入卡片所属人姓名");
            return;
        }
        String phone = et_phone_num.getText().toString();
        if (StringUtils.isEmpty(phone)) {
            ToastUtil.showToastMsg(getContext(), "请输入卡片绑定的手机号");
            return;
        }
        OkGo.<String>get(URLs.ADD_BANK_CARD).params("name", name).params("cardnumber", cardNumber)
                .params("openingbank", cardName).params("beautician_id", UserHelp.getUserId(getContext()))
                .params("mobel", phone).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    ToastUtil.showToastMsg(getContext(), msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                ToastUtil.showToastMsg(getContext(), "添加失败");
            }
        });
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bind.unbind();
    }
}