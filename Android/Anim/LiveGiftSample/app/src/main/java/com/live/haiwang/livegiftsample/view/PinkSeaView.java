package com.live.haiwang.livegiftsample.view;

import android.content.Context;

import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/7/17.
 */

public class PinkSeaView extends CustomBaseViewRelative {

    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public PinkSeaView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                isDisplaying = false;
                if(mListener != null)mListener.b();
            }
        }, 14000L);
    }

    @Override
    protected void a() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.petal_sea_view;
    }
}
