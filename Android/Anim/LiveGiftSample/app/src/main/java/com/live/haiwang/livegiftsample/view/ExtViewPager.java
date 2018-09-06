package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by haiwang on 2017/7/9.
 */

public class ExtViewPager extends ViewPager {

    public ExtViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(getCurrentItem() == getAdapter().getCount() - 1)
            getParent().requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//
//        return true;
//    }

}
