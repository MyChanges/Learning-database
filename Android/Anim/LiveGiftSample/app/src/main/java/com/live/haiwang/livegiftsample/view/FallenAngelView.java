package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.io.File;

/**
 * Created by haiwang on 2017/7/5.
 */

public class FallenAngelView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mRootView;
    private ImageView mLeftWingView;
    private ImageView mRightWingView;
    private ImageView mBgPetalsView;
    private AnimatorSet mFlowerAnimSet;
    private ObjectAnimator mFallingAnim;
    private ObjectAnimator mFloatAnim;
    private ObjectAnimator mFlowerRotation;
    private ObjectAnimator mFlowerScaleX;
    private ObjectAnimator mFlowerScaleY;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public FallenAngelView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mRootView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        mFallingAnim = ObjectAnimator.ofFloat(mRootView, TRANSLATION_Y,  -ScreenUtil.b(getContext(), 352.0F), ScreenUtil.b(getContext(), 50.0F));
        mFallingAnim.setInterpolator(new DecelerateInterpolator());
        mFallingAnim.setStartDelay(500L);
        mFallingAnim.setDuration(2000L);
        mFloatAnim = ObjectAnimator.ofFloat(mRootView, TRANSLATION_Y, ScreenUtil.b(getContext(), 50.0F), ScreenUtil.b(getContext(), 30.0F), ScreenUtil.b(getContext(), 50.0F));
        mFloatAnim.setRepeatMode(ValueAnimator.REVERSE);
        mFloatAnim.setRepeatCount(ValueAnimator.INFINITE);
        mFloatAnim.setInterpolator(new LinearInterpolator());
        mFloatAnim.setDuration(2000L);
        mFlowerRotation = ObjectAnimator.ofFloat(mBgPetalsView, ROTATION, 0.0F, 112.0F );
        mFlowerRotation.setInterpolator(new LinearInterpolator());
        mFlowerRotation.setDuration(3000L);
        mFlowerScaleX = ObjectAnimator.ofFloat(mBgPetalsView, SCALE_X, 1.0F, 1.638F );
        mFlowerScaleX.setInterpolator(new LinearInterpolator());
        mFlowerScaleX.setDuration(3000L);
        mFlowerScaleY = ObjectAnimator.ofFloat(mBgPetalsView, SCALE_Y, 1.0F, 1.638F);
        mFlowerScaleY.setInterpolator(new LinearInterpolator());
        mFlowerScaleY.setDuration(3000L);
        mFlowerAnimSet = new AnimatorSet();
        mFlowerAnimSet.play(mFlowerRotation).with(mFlowerScaleX).with(mFlowerScaleY);
        mFallingAnim.addListener(this);
        if(mListener != null) mListener.a();
    }

    private void flapWing(View view, boolean left) {
        float startDegree, toDegree;
        if (left) {
            startDegree = -2F;
            toDegree = 12.0F;
            view.setPivotY(view.getMeasuredHeight() / 2);
            view.setPivotX(view.getMeasuredWidth());
        } else {
            startDegree = 2F;
            toDegree = -12.0F;
            view.setPivotY(view.getMeasuredHeight() / 2);
            view.setPivotX(0.0F);
        }
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, ROTATION, startDegree, toDegree);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setRepeatMode(ValueAnimator.REVERSE);
        rotation.setRepeatCount(ValueAnimator.INFINITE);
        rotation.setStartDelay(1000L);
        rotation.setDuration(1000L);
        ObjectAnimator scale = ObjectAnimator.ofFloat(view, SCALE_X, 1.05F, 0.95F);
        scale.setInterpolator(new LinearInterpolator());
        scale.setRepeatMode(ValueAnimator.REVERSE);
        scale.setRepeatCount(ValueAnimator.INFINITE);
        scale.setDuration(1000L);
        rotation.start();
        scale.start();
    }

    public void start(){
        isDisplaying = true;
        mFallingAnim.start();
        flapWing(mLeftWingView, true);
        flapWing(mRightWingView, false);
    }

    public void stop() {
        isDisplaying = false;
        if (mFallingAnim != null) {
            mFallingAnim.removeAllListeners();
            mFallingAnim.cancel();
            mFallingAnim = null;
        }
        if (mFloatAnim != null) {
            mFloatAnim.removeAllListeners();
            mFloatAnim.cancel();
            mFloatAnim = null;
        }
        if (mFlowerRotation != null) {
            mFlowerRotation.removeAllListeners();
            mFlowerRotation.cancel();
            mFlowerRotation = null;
        }
        if (mFlowerScaleX != null) {
            mFlowerScaleX.removeAllListeners();
            mFlowerScaleX.cancel();
            mFlowerScaleX = null;
        }
        if (mFlowerScaleY != null) {
            mFlowerScaleY.removeAllListeners();
            mFlowerScaleY.cancel();
            mFlowerScaleY = null;
        }
        if(mFlowerAnimSet != null){
            mFlowerAnimSet.removeAllListeners();
            mFlowerAnimSet.cancel();
            mFlowerAnimSet = null;
        }
        if(mListener != null) mListener.b();
    }

    @Override
    protected void a() {
        mRootView = (RelativeLayout) findViewById(R.id.angle_container);
        mLeftWingView = (ImageView) findViewById(R.id.angel_left_wing);
        mRightWingView = (ImageView) findViewById(R.id.angel_right_wing);
        mBgPetalsView = (ImageView) findViewById(R.id.bg_flower_effects);
        ImageView girl = (ImageView) findViewById(R.id.cherry_flower_girl_body);
        File user = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation");
        Glide.with(getContext()).load(user.getPath() + File.separator + "angel_left_wing.png").
                apply(RequestOptions.overrideOf(ScreenUtil.b(getContext(), 218), ScreenUtil.b(getContext(), 352))).into(mLeftWingView);
        Glide.with(getContext()).load(user.getPath() + File.separator + "angel_right_wing.png").
                apply(RequestOptions.overrideOf(ScreenUtil.b(getContext(), 218), ScreenUtil.b(getContext(), 352))).into(mRightWingView);
        Glide.with(getContext()).load(user.getPath() + File.separator + "angel_body.png").
                apply(RequestOptions.overrideOf(ScreenUtil.b(getContext(), 195), ScreenUtil.b(getContext(), 282))).into(girl);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.angel_fall_view;
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if (animation.equals(mFallingAnim)) {
            mRootView.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying) return;
        mFlowerAnimSet.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 6000L);
        if (animation.equals(mFallingAnim)) {
            mFloatAnim.start();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

}
