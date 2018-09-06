package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.ImageView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/13.
 */

public class GuardSwordView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private ImageView mSwordView;
//    private ImageView mLightView;
    private ImageView mCircle1View;
    private ImageView mCircle2View;
    private ImageView mTrayView;
//    private ObjectAnimator mLightAnim;
    private ObjectAnimator mSwordRotation;
    private AnimatorSet mSwordAnimSet;
    private AnimatorSet mCircle1AnimSet;
    private AnimatorSet mCircle2AnimSet;

    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public GuardSwordView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
//        mLightAnim = ObjectAnimator.ofFloat(mLightView, ALPHA, 0F, 1F);
//        mLightAnim.setDuration(2000L);
//        mLightAnim.setRepeatCount(ValueAnimator.INFINITE);
//        mLightAnim.setRepeatMode(ValueAnimator.REVERSE);

        mSwordRotation = ObjectAnimator.ofFloat(mSwordView, ROTATION, 0F, 1080F);
        mSwordRotation.setDuration(1800L);
        mSwordRotation.setStartDelay(500L);
        ObjectAnimator swordTransX = ObjectAnimator.ofFloat(mSwordView, TRANSLATION_X, ScreenUtil.b(getContext(), 200), 0);
        swordTransX.setDuration(2000L);
        ObjectAnimator swordTransY = ObjectAnimator.ofFloat(mSwordView, TRANSLATION_Y, -ScreenUtil.b(getContext(), 200), 0);
        swordTransY.setDuration(2000L);

        mSwordAnimSet = new AnimatorSet();
        mSwordAnimSet.play(mSwordRotation).with(swordTransX).with(swordTransY);
        mSwordRotation.addListener(this);

        ObjectAnimator circle1ScaleX = ObjectAnimator.ofFloat(mCircle1View, SCALE_X, 0F, 2.5F);
        circle1ScaleX.setDuration(1000L);
        circle1ScaleX.setRepeatMode(ValueAnimator.RESTART);
        circle1ScaleX.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator circle1ScaleY = ObjectAnimator.ofFloat(mCircle1View, SCALE_Y, 0F, 2.5F);
        circle1ScaleY.setDuration(1000L);
        circle1ScaleY.setRepeatMode(ValueAnimator.RESTART);
        circle1ScaleY.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator circle1Alpha = ObjectAnimator.ofFloat(mCircle1View, ALPHA, 1F, 0F);
        circle1Alpha.setDuration(1000L);
        circle1Alpha.setRepeatMode(ValueAnimator.RESTART);
        circle1Alpha.setRepeatCount(ValueAnimator.INFINITE);
        mCircle1AnimSet = new AnimatorSet();
        mCircle1AnimSet.play(circle1ScaleX).with(circle1ScaleY).with(circle1Alpha);
        ObjectAnimator circle2ScaleX = ObjectAnimator.ofFloat(mCircle2View, SCALE_X, 0F, 2F);
        circle2ScaleX.setDuration(1000L);
        circle2ScaleX.setRepeatMode(ValueAnimator.RESTART);
        circle2ScaleX.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator circle2ScaleY = ObjectAnimator.ofFloat(mCircle2View, SCALE_Y, 0F, 2F);
        circle2ScaleY.setDuration(1000L);
        circle2ScaleY.setRepeatMode(ValueAnimator.RESTART);
        circle2ScaleY.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator circle2Alpha = ObjectAnimator.ofFloat(mCircle2View, ALPHA, 1F, 0F);
        circle2Alpha.setDuration(1000L);
        circle2Alpha.setRepeatMode(ValueAnimator.RESTART);
        circle2Alpha.setRepeatCount(ValueAnimator.INFINITE);
        mCircle2AnimSet = new AnimatorSet();
        mCircle2AnimSet.play(circle2ScaleX).with(circle2ScaleY).with(circle2Alpha);
        if(mListener != null)mListener.a();
    }

    public void start() {
        isDisplaying = true;
//        mLightAnim.start();
        mSwordAnimSet.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        },6000L);
    }

    public void stop() {
        isDisplaying = false;
//        if (mLightAnim != null) {
//            mLightAnim.removeAllListeners();
//            mLightAnim.cancel();
//            mLightAnim = null;
//        }
        if (mSwordAnimSet != null) {
            mSwordAnimSet.removeAllListeners();
            mSwordAnimSet.cancel();
            mSwordAnimSet = null;
        }
        if (mCircle1AnimSet != null) {
            mCircle1AnimSet.removeAllListeners();
            mCircle1AnimSet.cancel();
            mCircle1AnimSet = null;
        }
        if (mCircle2AnimSet != null) {
            mCircle2AnimSet.removeAllListeners();
            mCircle2AnimSet.cancel();
            mCircle2AnimSet = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    protected void a() {
        mSwordView = (ImageView) findViewById(R.id.iv_sword);
        mTrayView = (ImageView) findViewById(R.id.iv_sword_tray);
        mCircle1View = (ImageView) findViewById(R.id.iv_light_circle1);
        mCircle2View = (ImageView) findViewById(R.id.iv_light_circle2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.guard_sword_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if(animation.equals(mSwordRotation))
            mSwordView.setVisibility(VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(animation.equals(mSwordRotation)){
            mCircle1View.setVisibility(VISIBLE);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    mCircle2View.setVisibility(VISIBLE);
                    mCircle2AnimSet.start();
                }
            }, 500L);

            mTrayView.setVisibility(VISIBLE);
            mCircle1AnimSet.start();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
