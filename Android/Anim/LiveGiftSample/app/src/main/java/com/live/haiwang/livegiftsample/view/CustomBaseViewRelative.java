package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by haiwang on 2017/6/10.
 */

public abstract class CustomBaseViewRelative extends RelativeLayout {
    public Context aN;
    public LayoutInflater aO;

    public CustomBaseViewRelative(Context context) {
        super(context);
        this.aN = context;
        this.aO = LayoutInflater.from(this.aN);
        try {
            if (getLayoutId() != -1) {
                this.aO.inflate(getLayoutId(), this, true);
            }
            a();
            return;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public CustomBaseViewRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.aN = context;
        this.aO = LayoutInflater.from(this.aN);
        try {
            if (getLayoutId() != -1) {
                this.aO.inflate(getLayoutId(), this, true);
                a();
            }
            return;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    protected abstract void a();

    protected abstract int getLayoutId();
}

