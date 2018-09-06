package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/10.
 */

public class HerdBoyAndSpinningGirlView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private View mRootView;
    private ImageView mBoyView;
    private ImageView mGirlView;
    private ImageView mLeftBridgeView;
    private ImageView mRightBridgeView;
    private ImageView mLeftButterflyView;
    private ImageView mRightButterflyView;
    private ObjectAnimator mRootAnim;
    private AnimatorSet mBoyAnim;
    private AnimatorSet mGirlAnim;
    private AnimatorSet mLeftBridgeAnim;
    private AnimatorSet mRightBridgeAnim;
    private AnimatorSet mLeftButterflyAnim;
    private AnimatorSet mRightButterflyAnim;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public HerdBoyAndSpinningGirlView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    public void start() {
        isDisplaying = true;
        mRootAnim.start();
    }

    public void stop() {
        isDisplaying = false;
        if (mRootAnim != null) {
            mRootAnim.removeAllListeners();
            mRootAnim.cancel();
            mRootAnim = null;
        }
        if (mLeftBridgeAnim != null) {
            mLeftBridgeAnim.removeAllListeners();
            mLeftBridgeAnim.cancel();
            mLeftBridgeAnim = null;
        }
        if (mRightBridgeAnim != null) {
            mRightBridgeAnim.removeAllListeners();
            mRightBridgeAnim.cancel();
            mRightBridgeAnim = null;
        }
        if (mGirlAnim != null) {
            mGirlAnim.removeAllListeners();
            mGirlAnim.cancel();
            mGirlAnim = null;
        }
        if (mBoyAnim != null) {
            mBoyAnim.removeAllListeners();
            mBoyAnim.cancel();
            mBoyAnim = null;
        }
        if (mLeftButterflyAnim != null) {
            mLeftButterflyAnim.removeAllListeners();
            mLeftButterflyAnim.cancel();
            mLeftButterflyAnim = null;
        }
        if (mRightButterflyAnim != null) {
            mRightButterflyAnim.removeAllListeners();
            mRightButterflyAnim.cancel();
            mRightButterflyAnim = null;
        }
        if(mListener != null)mListener.b();
    }

    private void d() {
        mRootAnim = ObjectAnimator.ofFloat(mRootView, ALPHA, 0F, 1F);
        mRootAnim.setDuration(1500L);
        ObjectAnimator leftBridgeAnimX = ObjectAnimator.ofFloat(mLeftBridgeView, TRANSLATION_X, -ScreenUtil.b(getContext(), 180), 0);
        leftBridgeAnimX.setDuration(1500L);
        ObjectAnimator leftBridgeAnimY = ObjectAnimator.ofFloat(mLeftBridgeView, TRANSLATION_Y, ScreenUtil.b(getContext(), 60), 0);
        leftBridgeAnimY.setDuration(1500L);
        mLeftBridgeAnim = new AnimatorSet();
        mLeftBridgeAnim.play(leftBridgeAnimX).with(leftBridgeAnimY);
        ObjectAnimator rightBridgeAnimX = ObjectAnimator.ofFloat(mRightBridgeView, TRANSLATION_X, ScreenUtil.b(getContext(), 180), 0);
        rightBridgeAnimX.setDuration(1500L);
        ObjectAnimator rightBridgeAnimY = ObjectAnimator.ofFloat(mRightBridgeView, TRANSLATION_Y, ScreenUtil.b(getContext(), 60), 0);
        rightBridgeAnimY.setDuration(1500L);
        mRightBridgeAnim = new AnimatorSet();
        mRightBridgeAnim.play(rightBridgeAnimX).with(rightBridgeAnimY);
        ObjectAnimator boyX = ObjectAnimator.ofFloat(mBoyView, TRANSLATION_X, -ScreenUtil.b(getContext(), 180), 0);
        boyX.setDuration(1500L);
        ObjectAnimator boyY = ObjectAnimator.ofFloat(mBoyView, TRANSLATION_Y, ScreenUtil.b(getContext(), 60), 0);
        boyY.setDuration(1500L);
        mBoyAnim = new AnimatorSet();
        mBoyAnim.play(boyX).with(boyY);
        ObjectAnimator girlX = ObjectAnimator.ofFloat(mGirlView, TRANSLATION_X, ScreenUtil.b(getContext(), 180), 0);
        girlX.setDuration(1500L);
        ObjectAnimator girlY = ObjectAnimator.ofFloat(mGirlView, TRANSLATION_Y, ScreenUtil.b(getContext(), 60), 0);
        girlY.setDuration(1500L);
        mGirlAnim = new AnimatorSet();
        mGirlAnim.play(girlX).with(girlY);
        ObjectAnimator leftButterflyAnimY = ObjectAnimator.ofFloat(mLeftButterflyView, TRANSLATION_Y, 0, -ScreenUtil.b(getContext(), 120));
        leftButterflyAnimY.setDuration(2000L);
        ObjectAnimator leftButterflyAnimX = ObjectAnimator.ofFloat(mLeftButterflyView, TRANSLATION_X, 0, ScreenUtil.b(getContext(), 20));
        leftButterflyAnimX.setDuration(2000L);
        ObjectAnimator leftButterflyAnimY1 = ObjectAnimator.ofFloat(mLeftButterflyView, TRANSLATION_Y, -ScreenUtil.b(getContext(), 120), -ScreenUtil.b(getContext(), 110), -ScreenUtil.b(getContext(), 120));
        leftButterflyAnimY1.setDuration(2500L);
        leftButterflyAnimY1.setRepeatMode(ValueAnimator.REVERSE);
        leftButterflyAnimY1.setRepeatCount(ValueAnimator.INFINITE);
        mLeftButterflyAnim = new AnimatorSet();
        mLeftButterflyAnim.play(leftButterflyAnimY).with(leftButterflyAnimX).before(leftButterflyAnimY1);
        ObjectAnimator rightButterflyAnimY = ObjectAnimator.ofFloat(mRightButterflyView, TRANSLATION_Y, 0, -ScreenUtil.b(getContext(), 100));
        rightButterflyAnimY.setDuration(2000L);
        ObjectAnimator rightButterflyAnimX = ObjectAnimator.ofFloat(mRightButterflyView, TRANSLATION_X, 0, -ScreenUtil.b(getContext(), 5));
        rightButterflyAnimX.setDuration(2000L);
        ObjectAnimator rightButterflyAnimY1 = ObjectAnimator.ofFloat(mRightButterflyView, TRANSLATION_Y, -ScreenUtil.b(getContext(), 100), -ScreenUtil.b(getContext(), 120), -ScreenUtil.b(getContext(), 100));
        rightButterflyAnimY1.setDuration(2500L);
        rightButterflyAnimY1.setRepeatMode(ValueAnimator.REVERSE);
        rightButterflyAnimY1.setRepeatCount(ValueAnimator.INFINITE);
        mRightButterflyAnim = new AnimatorSet();
        mRightButterflyAnim.play(rightButterflyAnimY).with(rightButterflyAnimX).before(rightButterflyAnimY1);
        mLeftBridgeAnim.addListener(this);
        mRootAnim.addListener(this);
        mBoyAnim.addListener(this);
        if(mListener != null)mListener.a();
    }

    @Override
    protected void a() {
        mRootView = findViewById(R.id.rl_milky_way_bg);
        mLeftBridgeView = (ImageView) findViewById(R.id.iv_left_milky_way);
        mRightBridgeView = (ImageView) findViewById(R.id.iv_right_milky_way);
        mLeftButterflyView = (ImageView) findViewById(R.id.iv_left_butterfly);
        mRightButterflyView = (ImageView) findViewById(R.id.iv_right_butterfly);
        mBoyView = (ImageView) findViewById(R.id.iv_herd_boy);
        mGirlView = (ImageView) findViewById(R.id.iv_spinning_maid);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.milky_way_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
            if(!isDisplaying) return;
        if(animation.equals(mRootAnim)){
            mLeftBridgeView.setVisibility(VISIBLE);
            mRightBridgeView.setVisibility(VISIBLE);
            mLeftBridgeAnim.start();
            mRightBridgeAnim.start();
        }
        if(animation.equals(mLeftBridgeAnim)){
            mGirlView.setVisibility(VISIBLE);
            mBoyView.setVisibility(VISIBLE);
            mGirlAnim.start();
            mBoyAnim.start();
        }
        if(animation.equals(mBoyAnim)){
            mLeftButterflyView.setVisibility(VISIBLE);
            mRightButterflyView.setVisibility(VISIBLE);
            mLeftButterflyAnim.start();
            mRightButterflyAnim.start();
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    stop();
                }
            }, 6000L);
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

}
