package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/3.
 */

public class RabbitAndEggView extends CustomBaseViewRelative  implements Animation.AnimationListener {

    private RelativeLayout mThreeRabbitContainer;
    private ImageView mGrassLandView;
    private ImageView mInvisibleLeftRabbitView;
    private ImageView mInvisibleMidRabbitView;
    private ImageView mInvisibleRightRabbitView;
    private ImageView mLeftRabbitView;
    private ImageView mMidRabbitView;
    private ImageView mRightRabbitView;
    private AnimationSet mMainAnim;
    private AnimatorSet mContainerAnimSet;
    private ObjectAnimator mRabbitContainerAnim;
    private ObjectAnimator mLeftRabbitAnim;
    private ObjectAnimator mRightRabbitAnim;
    private ObjectAnimator mMidRabbitAnim;
    private ObjectAnimator mContainerRotationAnim;
    private ObjectAnimator rotation2;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public RabbitAndEggView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mMainAnim = new AnimationSet(false);
        TranslateAnimation translate = new TranslateAnimation(0.0F, 0.0F, ScreenUtil.b(getContext(), 168.0F), 0.0F);
        translate.setDuration(500L);
        ScaleAnimation scale1 = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.9F, 1, 0.5F, 1, 1.0F);
        scale1.setInterpolator(new OvershootInterpolator());
        scale1.setDuration(150L);
        scale1.setRepeatMode(ValueAnimator.REVERSE);
        scale1.setStartOffset(450L);
        ScaleAnimation scale2 = new ScaleAnimation(1.0F, 1.0F, 1.0F, 1.1F, 1, 0.5F, 1, 1.0F);
        scale2.setInterpolator(new OvershootInterpolator());
        scale2.setDuration(150L);
        scale2.setRepeatMode(ValueAnimator.REVERSE);
        scale2.setStartOffset(600L);
        mMainAnim.addAnimation(translate);
        mMainAnim.addAnimation(scale1);
        mMainAnim.addAnimation(scale2);

        mRabbitContainerAnim = ObjectAnimator.ofFloat(mThreeRabbitContainer, View.TRANSLATION_Y, ScreenUtil.b(getContext(), 430.0F), 0.0F);
        mRabbitContainerAnim.setInterpolator(new OvershootInterpolator());
        mRabbitContainerAnim.setDuration(1000L);
        mRabbitContainerAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isDisplaying) return;
                mLeftRabbitAnim.start();
                mRightRabbitAnim.start();
                mMidRabbitAnim.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mLeftRabbitAnim = ObjectAnimator.ofFloat(mInvisibleLeftRabbitView, View.TRANSLATION_X, ScreenUtil.b(getContext(), 66.0F), -ScreenUtil.b(getContext(), 8.0F));
        mLeftRabbitAnim.setInterpolator(new AccelerateInterpolator());
        mLeftRabbitAnim.setRepeatCount(1);
        mLeftRabbitAnim.setRepeatMode(ValueAnimator.REVERSE);
        mLeftRabbitAnim.setDuration(800L);
        mLeftRabbitAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mInvisibleLeftRabbitView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isDisplaying) return;
                mInvisibleLeftRabbitView.setVisibility(GONE);
//                mLeftRabbitView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mRightRabbitAnim = ObjectAnimator.ofFloat(mInvisibleRightRabbitView, View.TRANSLATION_X, ScreenUtil.b(getContext(), -70.0F), ScreenUtil.b(getContext(), 10.0F));
        mRightRabbitAnim.setDuration(800L);
        mRightRabbitAnim.setRepeatCount(1);
        mRightRabbitAnim.setRepeatMode(ValueAnimator.REVERSE);
        mRightRabbitAnim.setInterpolator(new AccelerateInterpolator());
        mRightRabbitAnim.setStartDelay(1500L);
        mRightRabbitAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mInvisibleRightRabbitView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isDisplaying) return;
                mInvisibleRightRabbitView.setVisibility(GONE);
//                mRightRabbitView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mMidRabbitAnim = ObjectAnimator.ofFloat(mInvisibleMidRabbitView, View.TRANSLATION_Y, ScreenUtil.b(getContext(), 110.0F), 0F);
        mMidRabbitAnim.setDuration(800L);
        mMidRabbitAnim.setInterpolator(new AccelerateInterpolator());
        mMidRabbitAnim.setStartDelay(3000L);
        mMidRabbitAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mInvisibleMidRabbitView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isDisplaying) return;
                mInvisibleMidRabbitView.setVisibility(GONE);
                mMidRabbitView.setVisibility(VISIBLE);
                mContainerAnimSet.start();
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stop();
                    }
                }, 4000L);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mContainerAnimSet = new AnimatorSet();
        mContainerRotationAnim = ObjectAnimator.ofFloat(mThreeRabbitContainer, ROTATION, 0F, -20F);
        mThreeRabbitContainer.setPivotX(ScreenUtil.a(getContext()) / 2 - ScreenUtil.b(getContext(), 60.0F));
        mThreeRabbitContainer.setPivotY(ScreenUtil.b(getContext()) - ScreenUtil.b(getContext(), 300.0F));
        mContainerRotationAnim.setDuration(500L);
        rotation2 = ObjectAnimator.ofFloat(mThreeRabbitContainer, ROTATION, -20F, 20F);
        rotation2.setDuration(1000L);
        rotation2.setRepeatCount(ValueAnimator.INFINITE);
        rotation2.setRepeatMode(ValueAnimator.REVERSE);
        mContainerAnimSet.playSequentially(mContainerRotationAnim, rotation2);
        if(mListener != null) mListener.a();
    }

    public void start(){
        isDisplaying = true;
        mMainAnim.setAnimationListener(this);
        mGrassLandView.startAnimation(mMainAnim);
    }

    public void stop() {
        this.isDisplaying = false;
        if (mMainAnim != null) {
            mMainAnim.cancel();
            mMainAnim = null;
        }
        if (mRabbitContainerAnim != null) {
            mRabbitContainerAnim.removeAllListeners();
            mRabbitContainerAnim.cancel();
            mRabbitContainerAnim = null;
        }
        if (mLeftRabbitAnim != null) {
            mLeftRabbitAnim.removeAllListeners();
            mLeftRabbitAnim.cancel();
            mLeftRabbitAnim = null;
        }
        if (mRightRabbitAnim != null) {
            mRightRabbitAnim.removeAllListeners();
            mRightRabbitAnim.cancel();
            mRightRabbitAnim = null;
        }
        if (mMidRabbitAnim != null) {
            mMidRabbitAnim.removeAllListeners();
            mMidRabbitAnim.cancel();
            mMidRabbitAnim = null;
        }
        if (mContainerRotationAnim != null) {
            mContainerRotationAnim.removeAllListeners();
            mContainerRotationAnim.cancel();
            mContainerRotationAnim = null;
        }
        if (rotation2 != null) {
            rotation2.removeAllListeners();
            rotation2.cancel();
            rotation2 = null;
        }
        if (mContainerAnimSet != null) {
            mContainerAnimSet.removeAllListeners();
            mContainerAnimSet.cancel();
            mContainerAnimSet = null;
        }
        if(mListener != null) mListener.b();
    }

    @Override
    protected void a() {
        mThreeRabbitContainer = (RelativeLayout) findViewById(R.id.three_rabbit_container);
        mGrassLandView = (ImageView) findViewById(R.id.grass_land);
        mInvisibleLeftRabbitView = (ImageView) findViewById(R.id.left_rabbit_hide);
        mInvisibleMidRabbitView = (ImageView) findViewById(R.id.middle_rabbit_hide);
        mInvisibleRightRabbitView = (ImageView) findViewById(R.id.right_rabbit_hide);
        mLeftRabbitView = (ImageView) findViewById(R.id.left_rabbit);
        mMidRabbitView = (ImageView) findViewById(R.id.middle_rabbit);
        mRightRabbitView = (ImageView) findViewById(R.id.right_rabbit);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.egg_rabbit_view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mThreeRabbitContainer.setVisibility(VISIBLE);
        mRabbitContainerAnim.start();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
