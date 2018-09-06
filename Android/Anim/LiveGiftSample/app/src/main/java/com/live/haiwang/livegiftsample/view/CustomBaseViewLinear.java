package com.live.haiwang.livegiftsample.view;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by haiwang on 2017/6/28.
 */
public abstract class CustomBaseViewLinear extends LinearLayout {
    public Context mContext;
    public LayoutInflater mInflater;

    public CustomBaseViewLinear(Context context) {
        super(context);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        try {
            if (getLayoutId() != -1) {
                mInflater.inflate(getLayoutId(), this, true);
            }
            initView();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public CustomBaseViewLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        try {
            if (getLayoutId() != -1) {
                mInflater.inflate(getLayoutId(), this, true);
            }
            initView();
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    public void hideSoftInput(Activity activity) {
        if (activity != null) {
            try {
                View view = activity.getCurrentFocus();
                if (view != null) {
                    ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void hideSoftInputForce(Activity activity, IBinder binder) {
        ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(binder, 0);
    }

    public boolean showSoftInput(Context context, EditText editText) {
        try {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            return ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

