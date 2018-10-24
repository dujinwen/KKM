package com.hualong.kekemei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.utils.StringUtils;

import butterknife.BindView;

/**
 * Created by peiyangfan on 2018/10/24.
 */

public class TextAndLineView extends LinearLayout {

    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.v_line)
    View vLine;
    private CharSequence titleText;
    private int lineColor;
    private TypedArray ta;
    private float titleTxtSize;
    private float lineHeight;
    private boolean textAndLineViewSelect;

    public TextAndLineView(Context context) {
        this(context, null);
    }

    public TextAndLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextAndLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.text_line, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextAndLineView);
        titleText = ta.getString(R.styleable.TextAndLineView_TextAndLineTitleText);
        lineColor = ta.getColor(R.styleable.TextAndLineView_lineColor, 0xFF7AD2D2);
        titleTxtSize = ta.getDimension(R.styleable.TextAndLineView_TextAndLineTitleTextSize, context.getResources().getDimension(R.dimen.dimen_18sp));
        lineHeight = ta.getDimension(R.styleable.TextAndLineView_lineHeight, context.getResources().getDimension(R.dimen.dimen_16sp));
        textAndLineViewSelect = ta.getBoolean(R.styleable.TextAndLineView_TextAndLineViewSelect, false);
        ta.recycle();
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {

        setTitleText(checkStringAttr(titleText));
        setTitleTxtSize(titleTxtSize);
        setSelect(textAndLineViewSelect);
    }


    public void setSelect(boolean flag) {
        tvText.setSelected(flag);
        vLine.setSelected(flag);
    }

    public CharSequence getTitleText() {
        return titleText;
    }

    public void setTitleText(CharSequence titleText) {
        this.titleText = titleText;
        tvText.setText(titleText);
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public TypedArray getTa() {
        return ta;
    }

    public void setTa(TypedArray ta) {
        this.ta = ta;
    }

    public float getTitleTxtSize() {
        return titleTxtSize;
    }

    public void setTitleTxtSize(float titleTxtSize) {
        this.titleTxtSize = titleTxtSize;
        tvText.setTextSize(titleTxtSize);
    }

    public float getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(float lineHeight) {
        this.lineHeight = lineHeight;
    }

    public boolean isTextAndLineViewSelect() {
        return textAndLineViewSelect;
    }

    public void setTextAndLineViewSelect(boolean textAndLineViewSelect) {
        this.textAndLineViewSelect = textAndLineViewSelect;
    }

    private CharSequence checkStringAttr(CharSequence attr) {
        if (StringUtils.isNotBlank(attr)) {
            return attr;
        }
        return "";
    }
}
