package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/5.
 */

public class RocketsLaunchingView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mRocketsContainer;
    private ImageView mFireView;
    private ImageView mFumeLayer1;
    private ImageView mFumeLayer2;
    private ObjectAnimator mRocketsFirstTrans;
    private ObjectAnimator mRocketsSecondTrans;
    private AnimatorSet mRocketsAnimSet;
    private AnimatorSet mFume1AnimSet;
    private AnimatorSet mFume2AnimSet;

    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public RocketsLaunchingView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    public void start() {
        isDisplaying = true;
        mRocketsAnimSet.start();
    }

    public void stop() {
        isDisplaying = false;

        if (mFume1AnimSet != null) {
            mFume1AnimSet.removeAllListeners();
            mFume1AnimSet.cancel();
            mFume1AnimSet = null;
        }
        if (mFume2AnimSet != null) {
            mFume2AnimSet.removeAllListeners();
            mFume2AnimSet.cancel();
            mFume2AnimSet = null;
        }
        if (mRocketsFirstTrans != null) {
            mRocketsFirstTrans.removeAllListeners();
            mRocketsFirstTrans.cancel();
            mRocketsFirstTrans = null;
        }
        if (mRocketsSecondTrans != null) {
            mRocketsSecondTrans.removeAllListeners();
            mRocketsSecondTrans.cancel();
            mRocketsSecondTrans = null;
        }
        if (mRocketsAnimSet != null) {
            mRocketsAnimSet.removeAllListeners();
            mRocketsAnimSet.cancel();
            mRocketsAnimSet = null;
        }
        if(mListener != null)mListener.b();
    }

    private void d() {

        mRocketsFirstTrans = ObjectAnimator.ofFloat(mRocketsContainer, TRANSLATION_Y, ScreenUtil.b(getContext(), 300), 0F);
        mRocketsFirstTrans.setDuration(500L);
        mRocketsFirstTrans.setInterpolator(new AccelerateInterpolator());

        mRocketsSecondTrans = ObjectAnimator.ofFloat(mRocketsContainer, TRANSLATION_Y, 0F, -ScreenUtil.b(getContext(), 275));
        mRocketsSecondTrans.setDuration(800L);
        mRocketsSecondTrans.setStartDelay(2000L);
        mRocketsSecondTrans.setInterpolator(new AccelerateInterpolator());

        mRocketsAnimSet = new AnimatorSet();
        mRocketsAnimSet.play(mRocketsFirstTrans).with(mRocketsSecondTrans);
        mFireView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.rockets_tail_fire));
        mRocketsFirstTrans.addListener(this);
        mRocketsSecondTrans.addListener(this);
        ObjectAnimator fume1TransY =  ObjectAnimator.ofFloat(mFumeLayer1, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 100));
        fume1TransY.setDuration(1000L);
        fume1TransY.setRepeatCount(1);
        fume1TransY.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator fume1ScaleX =  ObjectAnimator.ofFloat(mFumeLayer1, SCALE_X, 0F, 1.1F);
        fume1ScaleX.setDuration(1000L);
        fume1ScaleX.setRepeatCount(1);
        fume1ScaleX.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator fume1Alpha =  ObjectAnimator.ofFloat(mFumeLayer1, SCALE_X, 1F, 0F);
        fume1Alpha.setDuration(500L);
        fume1Alpha.setRepeatCount(1);
        fume1Alpha.setRepeatMode(ValueAnimator.RESTART);
        mFume1AnimSet = new AnimatorSet();
        mFume1AnimSet.play(fume1TransY).with(fume1ScaleX);
        mFume1AnimSet.play(fume1Alpha).after(fume1ScaleX);

        ObjectAnimator fume2TransY =  ObjectAnimator.ofFloat(mFumeLayer2, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 100));
        fume2TransY.setDuration(1000L);
        fume2TransY.setRepeatCount(1);
        fume2TransY.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator fume2ScaleX =  ObjectAnimator.ofFloat(mFumeLayer2, SCALE_X, 0F, 1.1F);
        fume2ScaleX.setDuration(1000L);
        fume2ScaleX.setRepeatCount(1);
        fume2ScaleX.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator fume2Alpha =  ObjectAnimator.ofFloat(mFumeLayer2, SCALE_X, 1F, 0F);
        fume2Alpha.setDuration(500L);
        fume2Alpha.setRepeatCount(1);
        fume2Alpha.setRepeatMode(ValueAnimator.RESTART);
        mFume2AnimSet = new AnimatorSet();
        mFume2AnimSet.play(fume2TransY).with(fume2ScaleX);
        mFume2AnimSet.play(fume2Alpha).after(fume2ScaleX);
        mFume1AnimSet.addListener(this);
        mFume2AnimSet.addListener(this);
        if(mListener != null)mListener.a();
    }

    @Override
    protected void a() {
        mFumeLayer1 = (ImageView) findViewById(R.id.rockets_fume_layer1);
        mFumeLayer2 = (ImageView) findViewById(R.id.rockets_fume_layer2);
        mFireView = (ImageView) findViewById(R.id.rockets_tail_fire);
        mRocketsContainer = (RelativeLayout) findViewById(R.id.rockets_container);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rockets_launching_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if(!isDisplaying)return;
        if(animation.equals(mRocketsFirstTrans)){
            mRocketsContainer.setVisibility(VISIBLE);
            AnimationDrawable drawable = (AnimationDrawable) mFireView.getDrawable();
            drawable.start();
        }

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying)return;
        if(animation.equals(mRocketsFirstTrans)){
            mFume1AnimSet.start();
            mFumeLayer1.setVisibility(VISIBLE);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFume2AnimSet.start();
                    mFumeLayer2.setVisibility(VISIBLE);
                }
            }, 500L);

        }
        if(animation.equals(mFume1AnimSet))
            mFumeLayer1.setVisibility(GONE);
        if(animation.equals(mFume2AnimSet))
            mFumeLayer2.setVisibility(GONE);
        if(animation.equals(mRocketsSecondTrans))
            stop();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
