package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/6/28.
 */

public class EnterRoomEffectsView extends CustomBaseViewLinear implements Animator.AnimatorListener{

    private View mRoot;
    private ImageView mTwinkleView;
    private ImageView mBackgroundView;
    private ImageView mMedalView;
    private TextView mNameView;
    private ImageView mScrollView;
    private ObjectAnimator twinkleAnim;
    private ObjectAnimator nameAnim;
    private AnimatorSet mEnterAnimSet;
    private AnimatorSet mMedalAnimSet;
    private AnimatorSet mMedalAnimSet1;
    private ObjectAnimator mMedalRotation;
    private ObjectAnimator mEnterAnim;
    private ObjectAnimator scrollViewTrans;
    private GiftDisplayListener mListener;

    public EnterRoomEffectsView(Context context, GiftDisplayListener listener) {
        super(context);
        mListener = listener;
        initAnims();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_room_special_vew;
    }

    @Override
    protected void initView() {
        mRoot = findViewById(R.id.rl_enter_room);
        mTwinkleView = (ImageView) findViewById(R.id.enter_room_twinkle);
        mNameView = (TextView) findViewById(R.id.enter_room_name);
        mScrollView = (ImageView) findViewById(R.id.enter_room_scroll);
        mBackgroundView = (ImageView) findViewById(R.id.enter_room_bg);
        mMedalView = (ImageView) findViewById(R.id.enter_room_medal);
    }

    public void start() {
//        if (mEnterAnimSet == null || mEnterAnimSet.isStarted() || mEnterAnimSet.isRunning()) {
//            return;
//        }
//        mEnterAnimSet.start();
        mEnterAnim.start();
    }

    public void changeVisibility(View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    private void initAnims() {
        mEnterAnim = ObjectAnimator.ofFloat(mRoot, TRANSLATION_X, -ScreenUtil.a(getContext()), 0);
        mEnterAnim.setDuration(1500L);
        mEnterAnim.addListener(this);
        twinkleAnim = ObjectAnimator.ofFloat(mTwinkleView, View.ALPHA, 0.0F, 1.0F).setDuration(300L);
        twinkleAnim.setRepeatCount(2);
        twinkleAnim.setRepeatMode(ValueAnimator.REVERSE);
        float f1 = ScreenUtil.a(getContext());
        ObjectAnimator bgAnim = ObjectAnimator.ofFloat(mBackgroundView, View.TRANSLATION_X, -f1, 0.0F, 0.0F).setDuration(1000L);
        bgAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        nameAnim = ObjectAnimator.ofFloat(mNameView, View.TRANSLATION_X, 0.0F, 0.0F, 0.0F).setDuration(100L);
        nameAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        scrollViewTrans = ObjectAnimator.ofFloat(mScrollView, View.TRANSLATION_X, 0.0F, f1 + ScreenUtil.b(getContext(), 30));
        scrollViewTrans.setDuration(1000L);
        scrollViewTrans.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator scrollViewAlpha = ObjectAnimator.ofFloat(mScrollView, View.ALPHA, 0.0F, 1.0F);
        scrollViewAlpha.setRepeatCount(3);
        scrollViewAlpha.setRepeatMode(ValueAnimator.REVERSE);
//        AnimatorSet scrollAnim = new AnimatorSet();
//        scrollAnim.setDuration(1000L);
//        scrollAnim.playTogether(scrollViewTrans, scrollViewAlpha);
        nameAnim.addListener(this);
        twinkleAnim.addListener(this);
//        mEnterAnimSet = new AnimatorSet();
//        mEnterAnimSet.playSequentially(twinkleAnim, bgAnim, nameAnim, scrollViewTrans);
//        mEnterAnimSet.addListener(this);
        ObjectAnimator medalTransX = ObjectAnimator.ofFloat(mMedalView, TRANSLATION_X, 0, ScreenUtil.a(getContext()) / 2 - ScreenUtil.b(getContext(), 25));
        medalTransX.setDuration(1000L);
        ObjectAnimator medalTransY = ObjectAnimator.ofFloat(mMedalView, TRANSLATION_Y, 0, -ScreenUtil.a(getContext()) * 3 / 5);
        medalTransY.setDuration(1000L);
        ObjectAnimator medalScaleX = ObjectAnimator.ofFloat(mMedalView, SCALE_X, 1.0F, 2.0F);
        medalScaleX.setDuration(1000L);
        ObjectAnimator medalScaleY = ObjectAnimator.ofFloat(mMedalView, SCALE_Y, 1.0F, 2.0F);
        medalScaleY.setDuration(1000L);
        mMedalAnimSet = new AnimatorSet();
        mMedalAnimSet.play(medalTransX).with(medalTransY).with(medalScaleX).with(medalScaleY);
        mMedalAnimSet.addListener(this);
        mMedalRotation = ObjectAnimator.ofFloat(mMedalView, ROTATION_Y, 0, 360);
        mMedalRotation.setDuration(800L);
        mMedalRotation.addListener(this);
        ObjectAnimator medalTransXX = ObjectAnimator.ofFloat(mMedalView, TRANSLATION_X, ScreenUtil.a(getContext()) / 2 - ScreenUtil.b(getContext(), 25) , 0);
        medalTransXX.setDuration(1000L);
        ObjectAnimator medalTransYY = ObjectAnimator.ofFloat(mMedalView, TRANSLATION_Y, -ScreenUtil.a(getContext()) * 3 / 5, 0);
        medalTransYY.setDuration(1000L);
        ObjectAnimator medalScaleXX = ObjectAnimator.ofFloat(mMedalView, SCALE_X, 2.0F, 1.0F);
        medalScaleXX.setDuration(1000L);
        ObjectAnimator medalScaleYY = ObjectAnimator.ofFloat(mMedalView, SCALE_Y, 2.0F, 1.0F);
        medalScaleYY.setDuration(1000L);
        mMedalAnimSet1 = new AnimatorSet();
        mMedalAnimSet1.play(medalTransXX).with(medalTransYY).with(medalScaleXX).with(medalScaleYY);
        mMedalAnimSet1.addListener(this);
        if(mListener != null)mListener.a();
    }

    private void e() {
        changeVisibility(mScrollView, View.GONE);
        changeVisibility(mTwinkleView, View.GONE);
        changeVisibility(mNameView, View.INVISIBLE);
        changeVisibility(mBackgroundView, View.GONE);
    }

    public void b() {
        e();
//        if (this.j != null) {
//            this.j.clear();
//        }
        if (mEnterAnimSet != null && (mEnterAnimSet.isRunning() || mEnterAnimSet.isStarted())) {
            mEnterAnimSet.cancel();
        }
        if (mMedalAnimSet != null) {
            mMedalAnimSet.removeAllListeners();
            mMedalAnimSet.cancel();
            mMedalAnimSet = null;
        }
        if (mMedalAnimSet1 != null) {
            mMedalAnimSet1.removeAllListeners();
            mMedalAnimSet1.cancel();
            mMedalAnimSet1 = null;
        }
        if (mMedalRotation != null) {
            mMedalRotation.removeAllListeners();
            mMedalRotation.cancel();
            mMedalRotation = null;
        }
        if (mEnterAnim != null) {
            mEnterAnim.removeAllListeners();
            mEnterAnim.cancel();
            mEnterAnim = null;
        }
        if (scrollViewTrans != null) {
            scrollViewTrans.removeAllListeners();
            scrollViewTrans.cancel();
            scrollViewTrans = null;
        }
//        this.k = 0;
        if(mListener != null)mListener.b();
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if(animation.equals(twinkleAnim)) {
            changeVisibility(mTwinkleView, View.VISIBLE);
        }
        if(animation.equals(nameAnim)) {
            changeVisibility(mNameView, View.VISIBLE);
        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(animation.equals(mEnterAnim)){
            changeVisibility(mScrollView, View.VISIBLE);
            mMedalAnimSet.start();
            scrollViewTrans.start();
        }
//        if(animation.equals(twinkleAnim)){
//            changeVisibility(mBackgroundView, View.VISIBLE);
//        }
//        if(animation.equals(nameAnim)){
//            changeVisibility(mScrollView, View.VISIBLE);
//        }
//        if(animation.equals(mEnterAnimSet)){
//            mMedalAnimSet.start();
//        }
        if(animation.equals(mMedalAnimSet)){
            mMedalRotation.start();
        }
        if(animation.equals(mMedalRotation)){
            mMedalAnimSet1.start();
        }
        if(animation.equals(mMedalAnimSet1)){
            post(new Runnable() {
                @Override
                public void run() {
                    b();
                }
            });
        }

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
