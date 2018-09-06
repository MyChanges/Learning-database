package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/6.
 */

public class MeteorRainView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mRootView;
    private ImageView mMeteor1;
    private ImageView mMeteor2;
    private ImageView mMeteor3;
    private ImageView mMeteor4;
    private ImageView mMeteor5;
    private ImageView mMeteor6;
    private ImageView mMeteor7;
    private AnimatorSet mMeteor1Anim;
    private AnimatorSet mMeteor2Anim;
    private AnimatorSet mMeteor3Anim;
    private AnimatorSet mMeteor4Anim;
    private AnimatorSet mMeteor5Anim;
    private AnimatorSet mMeteor6Anim;
    private AnimatorSet mMeteor7Anim;
    private ObjectAnimator mStarrySkyAnim;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public MeteorRainView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mMeteor1Anim = new AnimatorSet();
        ObjectAnimator transX1 = ObjectAnimator.ofFloat(mMeteor1, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 460F));
        transX1.setDuration(1500L);
        transX1.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY1 = ObjectAnimator.ofFloat(mMeteor1, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 460F));
        transY1.setDuration(1500L);
        transY1.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(mMeteor1, SCALE_X, 1F, 1.5F);
        scaleX1.setDuration(1000L);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(mMeteor1, SCALE_Y, 1F, 1.5F);
        scaleY1.setDuration(1000L);
        mMeteor1Anim.play(transX1).with(transY1).with(scaleX1).with(scaleY1);
        mMeteor1Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor2Anim = new AnimatorSet();
        ObjectAnimator transX2 = ObjectAnimator.ofFloat(mMeteor2, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 380F));
        transX2.setDuration(1500L);
        transX2.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY2 = ObjectAnimator.ofFloat(mMeteor2, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 360F));
        transY2.setDuration(1500L);
        transY2.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator scaleX2 = ObjectAnimator.ofFloat(mMeteor2, SCALE_X, 1F, 1.8F);
        scaleX2.setDuration(1000L);
        ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(mMeteor2, SCALE_Y, 1F, 1.8F);
        scaleY2.setDuration(1000L);
        mMeteor2Anim.play(transX2).with(transY2).with(scaleX2).with(scaleY2);
        mMeteor2Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor2Anim.setStartDelay(800L);
        mMeteor3Anim = new AnimatorSet();
        ObjectAnimator transX3 = ObjectAnimator.ofFloat(mMeteor3, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 420F));
        transX3.setDuration(1500L);
        transX3.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY3 = ObjectAnimator.ofFloat(mMeteor3, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 420F));
        transY3.setDuration(1500L);
        transY3.setRepeatCount(ValueAnimator.INFINITE);
        mMeteor3Anim.play(transX3).with(transY3);
        mMeteor3Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor3Anim.setStartDelay(500L);
        mMeteor4Anim = new AnimatorSet();
        ObjectAnimator transX4 = ObjectAnimator.ofFloat(mMeteor4, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 440F));
        transX4.setDuration(1500L);
        transX4.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY4 = ObjectAnimator.ofFloat(mMeteor4, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 420F));
        transY4.setDuration(1500L);
        transY4.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator scaleX4 = ObjectAnimator.ofFloat(mMeteor4, SCALE_X, 1F, 1.8F);
        scaleX4.setDuration(1000L);
        ObjectAnimator scaleY4 = ObjectAnimator.ofFloat(mMeteor4, SCALE_Y, 1F, 1.8F);
        scaleY4.setDuration(1000L);
        mMeteor4Anim.play(transX4).with(transY4).with(scaleX4).with(scaleY4);
        mMeteor4Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor4Anim.setStartDelay(1000L);
        mMeteor5Anim = new AnimatorSet();
        ObjectAnimator transX5 = ObjectAnimator.ofFloat(mMeteor5, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 280F));
        transX5.setDuration(1500L);
        transX5.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY5 = ObjectAnimator.ofFloat(mMeteor5, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 280F));
        transY5.setDuration(1500L);
        transY5.setRepeatCount(ValueAnimator.INFINITE);
        mMeteor5Anim.play(transX5).with(transY5);
        mMeteor5Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor5Anim.setStartDelay(500L);
        mMeteor6Anim = new AnimatorSet();
        ObjectAnimator transX6 = ObjectAnimator.ofFloat(mMeteor6, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 360F));
        transX6.setDuration(1500L);
        transX6.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY6 = ObjectAnimator.ofFloat(mMeteor6, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 340F));
        transY6.setDuration(1500L);
        transY6.setRepeatCount(ValueAnimator.INFINITE);
        mMeteor6Anim.play(transX6).with(transY6);
        mMeteor6Anim.setInterpolator(new AccelerateInterpolator());
//        mMeteor6Anim.setStartDelay(500L);
        mMeteor7Anim = new AnimatorSet();
        ObjectAnimator transX7 = ObjectAnimator.ofFloat(mMeteor7, TRANSLATION_X, 0F, -ScreenUtil.b(getContext(), 450F));
        transX7.setDuration(1500L);
        transX7.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator transY7 = ObjectAnimator.ofFloat(mMeteor7, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 450F));
        transY7.setDuration(1500L);
        transY7.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator scaleX7 = ObjectAnimator.ofFloat(mMeteor7, SCALE_X, 1F, 1.8F);
        scaleX7.setDuration(1000L);
        ObjectAnimator scaleY7 = ObjectAnimator.ofFloat(mMeteor7, SCALE_Y, 1F, 1.8F);
        scaleY7.setDuration(1000L);
        mMeteor7Anim.play(transX7).with(transY7).with(scaleX7).with(scaleY7);
        mMeteor7Anim.setInterpolator(new AccelerateInterpolator());
        mMeteor7Anim.setStartDelay(500L);
        mStarrySkyAnim = ObjectAnimator.ofFloat(mRootView, ALPHA, 0F, 1.0F);
        mStarrySkyAnim.setDuration(800L);
        mStarrySkyAnim.addListener(this);
        if(mListener != null)mListener.a();
    }

    public void start() {
        isDisplaying = true;
        mRootView.setVisibility(VISIBLE);
        mStarrySkyAnim.start();
    }

    public void stop() {
        this.isDisplaying = false;

        if (mStarrySkyAnim != null) {
            mStarrySkyAnim.removeAllListeners();
            mStarrySkyAnim.cancel();
            mStarrySkyAnim = null;
        }
        if (mMeteor1Anim != null) {
            mMeteor1Anim.removeAllListeners();
            mMeteor1Anim.cancel();
            mMeteor1Anim = null;
        }
        if (mMeteor2Anim != null) {
            mMeteor2Anim.removeAllListeners();
            mMeteor2Anim.cancel();
            mMeteor2Anim = null;
        }
        if (mMeteor3Anim != null) {
            mMeteor3Anim.removeAllListeners();
            mMeteor3Anim.cancel();
            mMeteor3Anim = null;
        }
        if (mMeteor4Anim != null) {
            mMeteor4Anim.removeAllListeners();
            mMeteor4Anim.cancel();
            mMeteor4Anim = null;
        }
        if (mMeteor5Anim != null) {
            mMeteor5Anim.removeAllListeners();
            mMeteor5Anim.cancel();
            mMeteor5Anim = null;
        }
        if (mMeteor6Anim != null) {
            mMeteor6Anim.removeAllListeners();
            mMeteor6Anim.cancel();
            mMeteor6Anim = null;
        }
        if (mMeteor7Anim != null) {
            mMeteor7Anim.removeAllListeners();
            mMeteor7Anim.cancel();
            mMeteor7Anim = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    protected void a() {
        mRootView = (RelativeLayout) findViewById(R.id.rl_meteor_bg);
        mMeteor1 = (ImageView) findViewById(R.id.iv_meteor1);
        mMeteor2 = (ImageView) findViewById(R.id.iv_meteor2);
        mMeteor3 = (ImageView) findViewById(R.id.iv_meteor3);
        mMeteor4 = (ImageView) findViewById(R.id.iv_meteor4);
        mMeteor5 = (ImageView) findViewById(R.id.iv_meteor5);
        mMeteor6 = (ImageView) findViewById(R.id.iv_meteor6);
        mMeteor7 = (ImageView) findViewById(R.id.iv_meteor7);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.meteor_rain_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying)return;
        if(animation.equals(mStarrySkyAnim)){
            mMeteor1Anim.start();
            mMeteor2Anim.start();
            mMeteor3Anim.start();
            mMeteor4Anim.start();
            mMeteor5Anim.start();
            mMeteor6Anim.start();
            mMeteor7Anim.start();
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
}
