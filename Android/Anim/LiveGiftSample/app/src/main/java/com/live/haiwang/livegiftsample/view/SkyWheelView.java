package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/12.
 */

public class SkyWheelView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private ImageView mCityView;
    private ImageView mSkyWheelView;
    private ImageView mSkyWheelAxleView;
    private ObjectAnimator mCityTransAnim;
    private ObjectAnimator mSkyWheelAlpha;
    private ObjectAnimator mSkyWheelAxleAlpha;
    private ObjectAnimator mSkyWheelRotation;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public SkyWheelView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mCityTransAnim = ObjectAnimator.ofFloat(mCityView, TRANSLATION_Y, ScreenUtil.b(getContext(), 220), 0F);
        mCityTransAnim.setDuration(1500L);
        mSkyWheelAlpha = ObjectAnimator.ofFloat(mSkyWheelView, ALPHA, 0F, 1F);
        mSkyWheelAlpha.setDuration(800L);
        mSkyWheelAxleAlpha = ObjectAnimator.ofFloat(mSkyWheelAxleView, ALPHA, 0F, 1F);
        mSkyWheelAxleAlpha.setDuration(800L);
        mSkyWheelRotation = ObjectAnimator.ofFloat(mSkyWheelView, ROTATION, 0F, 360F);
        mSkyWheelRotation.setDuration(8000L);
        mSkyWheelRotation.setInterpolator(new LinearInterpolator());
        mSkyWheelRotation.setRepeatCount(ValueAnimator.INFINITE);
        mSkyWheelRotation.setRepeatMode(ValueAnimator.RESTART);
        mCityTransAnim.addListener(this);
        mSkyWheelAlpha.addListener(this);
        if(mListener != null)mListener.a();
    }

    public void start() {
        isDisplaying = true;
        mCityView.setVisibility(VISIBLE);
        mCityTransAnim.start();
    }

    public void stop() {
        this.isDisplaying = false;
        if (mCityTransAnim != null) {
            mCityTransAnim.removeAllListeners();
            mCityTransAnim.cancel();
            mCityTransAnim = null;
        }
        if (mSkyWheelAlpha != null) {
            mSkyWheelAlpha.removeAllListeners();
            mSkyWheelAlpha.cancel();
            mSkyWheelAlpha = null;
        }
        if (mSkyWheelAxleAlpha != null) {
            mSkyWheelAxleAlpha.removeAllListeners();
            mSkyWheelAxleAlpha.cancel();
            mSkyWheelAxleAlpha = null;
        }
        if (mSkyWheelRotation != null) {
            mSkyWheelRotation.removeAllListeners();
            mSkyWheelRotation.cancel();
            mSkyWheelRotation = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying) return;
        if(animation.equals(mCityTransAnim)){
            mSkyWheelView.setVisibility(VISIBLE);
            mSkyWheelAxleView.setVisibility(VISIBLE);
            mSkyWheelAlpha.start();
            mSkyWheelAxleAlpha.start();
        }
        if(animation.equals(mSkyWheelAlpha)){
            mSkyWheelRotation.start();
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    stop();
                }
            }, 8000L);
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    protected void a() {
        mCityView = (ImageView) findViewById(R.id.iv_night_city);
        mSkyWheelView = (ImageView) findViewById(R.id.iv_sky_wheel);
        mSkyWheelAxleView = (ImageView) findViewById(R.id.iv_sky_wheel_axle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sky_wheel_view;
    }
}
