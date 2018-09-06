package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/20.
 */

public class SunriseView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mRootView;
    private RelativeLayout mSunContainer;
    private ImageView mSunView;
    private ImageView mSunHaloView;
    private ImageView mCloud1View;
    private ImageView mCloud2View;

    private ObjectAnimator mRootAnim;
    private ObjectAnimator mSunContainerAnim;
    private AnimatorSet mSunAnim;
    private AnimatorSet mSunHaloAnim;
    private ObjectAnimator mCloud1Anim;
    private ObjectAnimator mCloud2Anim;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public SunriseView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    public void start() {
        isDisplaying = true;
        mRootAnim.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mSunAnim.start();
            }
        },3000L);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mCloud2Anim.start();
                mCloud2View.setVisibility(VISIBLE);
            }
        }, 5000L);
    }

    public void stop() {
        isDisplaying = false;
        if (mRootAnim != null) {
            mRootAnim.removeAllListeners();
            mRootAnim.cancel();
            mRootAnim = null;
        }
        if (mSunContainerAnim != null) {
            mSunContainerAnim.removeAllListeners();
            mSunContainerAnim.cancel();
            mSunContainerAnim = null;
        }
        if (mSunAnim != null) {
            mSunAnim.removeAllListeners();
            mSunAnim.cancel();
            mSunAnim = null;
        }
        if (mCloud1Anim != null) {
            mCloud1Anim.removeAllListeners();
            mCloud1Anim.cancel();
            mCloud1Anim = null;
        }
        if (mCloud2Anim != null) {
            mCloud2Anim.removeAllListeners();
            mCloud2Anim.cancel();
            mCloud2Anim = null;
        }
        if (mSunHaloAnim != null) {
            mSunHaloAnim.removeAllListeners();
            mSunHaloAnim.cancel();
            mSunHaloAnim = null;
        }
        if(mListener != null) mListener.b();
    }

    private void d() {
        mRootAnim = ObjectAnimator.ofFloat(mRootView, ALPHA, 0F, 1F);
        mRootAnim.setDuration(1000L);
        mRootAnim.addListener(this);
        mSunContainerAnim = ObjectAnimator.ofFloat(mSunContainer, TRANSLATION_Y, ScreenUtil.b(getContext(), 72), -ScreenUtil.b(getContext(), 80));
        mSunContainerAnim.setDuration(8000L);
        ObjectAnimator sunScaleX = ObjectAnimator.ofFloat(mSunView, SCALE_X, 1.0f, 1.8f);
        sunScaleX.setDuration(6000L);
        ObjectAnimator sunScaleY = ObjectAnimator.ofFloat(mSunView, SCALE_Y, 1.0f, 1.8f);
        sunScaleY.setDuration(6000L);
        mSunAnim = new AnimatorSet();
        mSunAnim.play(sunScaleX).with(sunScaleY);
        ObjectAnimator sunHaloScaleX = ObjectAnimator.ofFloat(mSunHaloView, SCALE_X, 1.0f, 1.8f);
        sunHaloScaleX.setDuration(3000L);
        ObjectAnimator sunHaloScaleY = ObjectAnimator.ofFloat(mSunHaloView, SCALE_Y, 1.0f, 1.8f);
        sunHaloScaleY.setDuration(3000L);
        ObjectAnimator sunHaloRotation = ObjectAnimator.ofFloat(mSunHaloView, ROTATION, 0, 360);
        sunHaloRotation.setDuration(8000L);
        mSunHaloAnim = new AnimatorSet();
        mSunHaloAnim.play(sunHaloScaleX).with(sunHaloScaleY).with(sunHaloRotation);
        mCloud1Anim = ObjectAnimator.ofFloat(mCloud1View, TRANSLATION_X, ScreenUtil.b(getContext(), 120), -ScreenUtil.a(getContext()) - ScreenUtil.b(getContext(), 120));
        mCloud1Anim.setDuration(16000L);
        mCloud2Anim = ObjectAnimator.ofFloat(mCloud2View, TRANSLATION_X, ScreenUtil.b(getContext(), 180), -ScreenUtil.a(getContext()) -ScreenUtil.b(getContext(), 180));
        mCloud2Anim.setDuration(20000L);
        mSunContainerAnim.addListener(this);
        mSunHaloAnim.addListener(this);
        if(mListener != null) mListener.a();
    }

    @Override
    protected void a() {
        mRootView = (RelativeLayout) findViewById(R.id.rl_sunrise_root);
        mSunContainer = (RelativeLayout) findViewById(R.id.rl_sun_container);
        mSunView = (ImageView) findViewById(R.id.iv_sun);
        mSunHaloView = (ImageView) findViewById(R.id.iv_sun_halo);
        mCloud1View = (ImageView) findViewById(R.id.iv_cloud1);
        mCloud2View = (ImageView) findViewById(R.id.iv_cloud2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.sun_rize_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying) return;
        if(animation.equals(mRootAnim)){
            mSunContainerAnim.start();
            mSunContainer.setVisibility(VISIBLE);
            mCloud1Anim.start();
            mCloud1View.setVisibility(VISIBLE);
        }
        if(animation.equals(mSunContainerAnim)){
            mSunHaloView.setVisibility(VISIBLE);
            mSunHaloAnim.start();
        }
        if(animation.equals(mSunHaloAnim)){
           stop();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
