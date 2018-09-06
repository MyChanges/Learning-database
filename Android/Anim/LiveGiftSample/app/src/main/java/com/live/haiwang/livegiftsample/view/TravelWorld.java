package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/8/4.
 */

public class TravelWorld extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mTravelWorldRoot;
    private TravelWorldBezierView mBezierView;
    private RelativeLayout mFireBalloonContainer;
    private ImageView mEarthView;
    private ImageView mParachuteLeft;
    private ImageView mParachuteRight;
    private SimpleDraweeView bu, bv;

    private ObjectAnimator mEarthViewScaleX;
    private ObjectAnimator mEarthViewScaleY;
    private ObjectAnimator mEarthViewTransY;
    private ObjectAnimator mEarthViewRotation;
    private ObjectAnimator mFireBalloonScaleX;
    private ObjectAnimator mFireBalloonScaleY;
    private ObjectAnimator mFireBalloonScaleX1;
    private ObjectAnimator mFireBalloonScaleY1;
    private ObjectAnimator mFireBalloonScaleX2;
    private ObjectAnimator mFireBalloonScaleY2;
    private ObjectAnimator mParachuteLeftRotation;
    private ObjectAnimator mParachuteRightRotation;
    private ObjectAnimator mRootAlpha;
    private ValueAnimator mFireBalloonAnimator;
    private ValueAnimator mParachuteLeftAnimator;
    private ValueAnimator mParachuteRightAnimator;
    private float[] bA = new float[2];
    private RelativeLayout mParachuteLeftContainer;
    private float[] bC = new float[2];
    private RelativeLayout mParachuteRightContainer;
    private float[] bE = new float[2];
    private GiftDisplayListener mGiftDisplayListener;
    private AnimatorSet mFireBalloonAnimSet;
    private AnimatorSet mCombinedAnimSet;
    private boolean isDisplaying = false;

    public TravelWorld(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        createAnimation();
    }

    public TravelWorld(Context paramContext, GiftDisplayListener parama) {
        super(paramContext);
        this.mGiftDisplayListener = parama;
        createAnimation();
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if (animation.equals(mEarthViewTransY)) {
            mEarthView.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if (animation.equals(mFireBalloonScaleX1)) {
            mFireBalloonScaleX2.start();
            mFireBalloonScaleY2.start();
        }
        if(animation.equals(mParachuteLeftAnimator)){
            mRootAlpha.start();
        }
        if (animation.equals(mRootAlpha)) {
            mEarthView.setVisibility(INVISIBLE);
            stop();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    public void start() {
        if (mGiftDisplayListener != null) {
            mGiftDisplayListener.a();
        }
        if (isDisplaying) {
            return;
        }
        isDisplaying = true;
//        mCombinedAnimSet.play(mEarthViewTransX).with(mSendViewTransX);
        mCombinedAnimSet.play(mEarthViewScaleX).with(mEarthViewScaleY).before(mEarthViewTransY);
        mCombinedAnimSet.play(mEarthViewRotation).after(mEarthViewTransY);
        mCombinedAnimSet.play(mFireBalloonScaleX1).with(mFireBalloonScaleY1);
        mCombinedAnimSet.play(mParachuteLeftRotation).with(mParachuteRightRotation);
        mCombinedAnimSet.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                startFireBalloonAnim();
            }
        },2000L);
    }

    private void createAnimation(){
//        ViewGroup.LayoutParams lp = mEarthView.getLayoutParams();
//        int size = ScreenUtil.b(getContext(), 600) + ScreenUtil.a(getContext());
//        lp.width = size;
//        lp.height = size;
//        mEarthView.setLayoutParams(lp);
        mEarthViewScaleX = ObjectAnimator.ofFloat(mEarthView, SCALE_X, 1.0F, 2.5F);
        mEarthViewScaleX.setDuration(100L);
        mEarthViewScaleY = ObjectAnimator.ofFloat(mEarthView, SCALE_Y, 1.0F, 2.5F);
        mEarthViewScaleY.setDuration(100L);
        mEarthViewTransY = ObjectAnimator.ofFloat(mEarthView, TRANSLATION_Y, ScreenUtil.a(getContext()), ScreenUtil.a(getContext()) / 2);
        mEarthViewTransY.setInterpolator(new LinearInterpolator());
        mEarthViewTransY.setDuration(700L);
        this.mEarthViewRotation = ObjectAnimator.ofFloat(mEarthView, ROTATION, 0.0F, 360.0F);
        this.mEarthViewRotation.setInterpolator(new LinearInterpolator());
        this.mEarthViewRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mEarthViewRotation.setRepeatCount(-1);
        this.mEarthViewRotation.setDuration(20000L);
        this.mFireBalloonScaleX = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_X, 1.0F, 0.5F);
        this.mFireBalloonScaleX.setInterpolator(new LinearInterpolator());
        this.mFireBalloonScaleX.setDuration(1000L);
        this.mFireBalloonScaleY = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_Y, 1.0F, 0.5F );
        this.mFireBalloonScaleY.setInterpolator(new LinearInterpolator());
        this.mFireBalloonScaleY.setDuration(1000L);
        this.mFireBalloonScaleX1 = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_X, 0.5F, 0.8F);
        this.mFireBalloonScaleX1.setInterpolator(new LinearInterpolator());
        this.mFireBalloonScaleX1.setDuration(4000L);
        this.mFireBalloonScaleY1 = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_Y, 0.5F, 0.8F);
        this.mFireBalloonScaleY1.setInterpolator(new LinearInterpolator());
        this.mFireBalloonScaleY1.setDuration(4000L);
        this.mFireBalloonScaleX2 = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_X, 0.8F, 1.2F);
        this.mFireBalloonScaleX2.setInterpolator(new LinearInterpolator());
//        this.mFireBalloonScaleX2.setStartDelay(1500L);
        this.mFireBalloonScaleX2.setDuration(2000L);
        this.mFireBalloonScaleY2 = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_Y, 0.8F, 1.2F);
        this.mFireBalloonScaleY2.setInterpolator(new LinearInterpolator());
//        this.mFireBalloonScaleY2.setStartDelay(1500L);
        this.mFireBalloonScaleY2.setDuration(2000L);
        this.mParachuteLeftRotation = ObjectAnimator.ofFloat(this.mParachuteLeft, ROTATION, 9.0F, 17.0F);
        this.mParachuteLeft.setPivotX(this.mParachuteLeft.getMeasuredWidth());
        this.mParachuteLeft.setPivotY(this.mParachuteLeft.getMeasuredHeight());
        this.mParachuteLeftRotation.setInterpolator(new LinearInterpolator());
        this.mParachuteLeftRotation.setRepeatMode(ValueAnimator.REVERSE);
        this.mParachuteLeftRotation.setRepeatCount(-1);
        this.mParachuteLeftRotation.setDuration(1000L);
        this.mParachuteRightRotation = ObjectAnimator.ofFloat(this.mParachuteRight, ROTATION, -5.0F, 5.0F);
        this.mParachuteRight.setPivotX(this.mParachuteRight.getMeasuredWidth());
        this.mParachuteRight.setPivotY(this.mParachuteRight.getMeasuredHeight());
        this.mParachuteRightRotation.setInterpolator(new LinearInterpolator());
        this.mParachuteRightRotation.setStartDelay(100L);
        this.mParachuteRightRotation.setRepeatMode(ValueAnimator.REVERSE);
        this.mParachuteRightRotation.setRepeatCount(-1);
        this.mParachuteRightRotation.setDuration(1000L);
        this.mRootAlpha = ObjectAnimator.ofFloat(this.mTravelWorldRoot, View.ALPHA,1.0F, 0.0F);
        this.mRootAlpha.setInterpolator(new LinearInterpolator());
        this.mRootAlpha.setStartDelay(1000L);
        this.mRootAlpha.setDuration(1000L);
        mFireBalloonAnimSet = new AnimatorSet();
        mCombinedAnimSet = new AnimatorSet();
        mEarthViewTransY.addListener(this);
        this.mParachuteLeftRotation.addListener(this);
        this.mFireBalloonScaleX1.addListener(this);
        this.mFireBalloonScaleX2.addListener(this);
        mRootAlpha.addListener(this);
        if (mGiftDisplayListener != null) {
//            InKeLog.TAG(TAG, "onAnimationReady mListener != null");
            mGiftDisplayListener.a();
        }
    }

    @Override
    protected void a() {
        mTravelWorldRoot = (RelativeLayout)findViewById(R.id.travel_world_releative);
        mEarthView = (ImageView) findViewById(R.id.iv_travel_world_earth);
        mBezierView = (TravelWorldBezierView)findViewById(R.id.bezier_path_veiw);
        mParachuteLeftContainer = (RelativeLayout) findViewById(R.id.travel_world_earth_parachute_left_container);
        mParachuteLeft = (ImageView)findViewById(R.id.travel_world_earth_parachute_left);
        mParachuteRightContainer = (RelativeLayout) findViewById(R.id.travel_world_earth_parachute_right_container);
        mParachuteRight = (ImageView)findViewById(R.id.travel_world_earth_parachute_right);
        bu = (SimpleDraweeView)findViewById(R.id.img_travel_world_fireballoon_left);
        bv = (SimpleDraweeView)findViewById(R.id.img_travel_world_fireballoon_right);
        mFireBalloonContainer = (RelativeLayout)findViewById(R.id.travel_world_fireballoon_container);
        createAnimation();
    }

    public void startFireBalloonAnim() {
        this.mFireBalloonContainer.setVisibility(VISIBLE);
        final PathMeasure pathMeasure = new PathMeasure(this.mBezierView.getFireBalloonPath(), false);
        this.mFireBalloonAnimator = ValueAnimator.ofFloat(0.0F, pathMeasure.getLength());
        this.mFireBalloonAnimator.setDuration(8000L);
        this.mFireBalloonAnimator.setInterpolator(new LinearInterpolator());
        this.mFireBalloonAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animator) {
                float f = (Float)animator.getAnimatedValue();
                pathMeasure.getPosTan(f, bE, null);
                mFireBalloonContainer.setTranslationX(bE[0] - ScreenUtil.b(getContext(), 130.0F));
                mFireBalloonContainer.setTranslationY(bE[1] - ScreenUtil.b(getContext(), 270.0F));
            }
        });
        this.mFireBalloonAnimator.start();
//        this.mFireBalloonAnimSet.play(mFireBalloonScaleX1).with(mFireBalloonScaleY1);
//        this.mFireBalloonAnimSet.start();
        this.mFireBalloonAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!isDisplaying) {
                    return;
                }
                startParachuteLeftAnim();
                startParachuteRightAnim();
//                mEarthViewAlpha.start();
//                mParachuteBackgroundAlpha.start();
            }
        });
    }

    public void startParachuteLeftAnim() {
        this.mParachuteLeftContainer.setVisibility(VISIBLE);
        final PathMeasure pathMeasure = new PathMeasure(this.mBezierView.getParachuteLeftPath(), false);
        mParachuteLeftAnimator = ValueAnimator.ofFloat(0.0F, pathMeasure.getLength());
        mParachuteLeftAnimator.setDuration(8000L);
        mParachuteLeftAnimator.setInterpolator(new LinearInterpolator());
        mParachuteLeftAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animator) {
                float f = (Float)animator.getAnimatedValue();
                pathMeasure.getPosTan(f, bA, null);
                mParachuteLeftContainer.setTranslationX(bA[0] - ScreenUtil.b(getContext(), 80.0F));
                mParachuteLeftContainer.setTranslationY(bA[1] - ScreenUtil.b(getContext(), 100.0F));
            }
        });
        mParachuteLeftAnimator.start();
        mParachuteLeftAnimator.addListener(this);
    }

    public void startParachuteRightAnim() {
        this.mParachuteRightContainer.setVisibility(VISIBLE);
        final PathMeasure pathMeasure = new PathMeasure(mBezierView.getParachuteRightPath(), false);
        this.mParachuteRightAnimator = ValueAnimator.ofFloat(0.0F, pathMeasure.getLength());
        this.mParachuteRightAnimator.setDuration(8000L);
        this.mParachuteRightAnimator.setInterpolator(new LinearInterpolator());
        this.mParachuteRightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animator) {
                float f = (Float)animator.getAnimatedValue();
                pathMeasure.getPosTan(f, bC, null);
                mParachuteRightContainer.setTranslationX(bC[0] - ScreenUtil.b(getContext(), 80.0F));
                mParachuteRightContainer.setTranslationY(bC[1] - ScreenUtil.b(getContext(), 100.0F));
            }
        });
        mParachuteRightAnimator.start();
    }

    public void stop(){
        this.isDisplaying = false;
        if (this.mFireBalloonAnimator != null) {
            this.mFireBalloonAnimator.removeAllListeners();
            this.mFireBalloonAnimator.cancel();
            this.mFireBalloonAnimator = null;
        }
        if (this.mParachuteLeftAnimator != null) {
            this.mParachuteLeftAnimator.removeAllListeners();
            this.mParachuteLeftAnimator.cancel();
            this.mParachuteLeftAnimator = null;
        }
        if (this.mParachuteRightAnimator != null) {
            this.mParachuteRightAnimator.removeAllListeners();
            this.mParachuteRightAnimator.cancel();
            this.mParachuteRightAnimator = null;
        }
        if (this.mEarthViewTransY != null) {
            this.mEarthViewTransY.removeAllListeners();
            this.mEarthViewTransY.cancel();
            this.mEarthViewTransY = null;
        }
        if (this.mEarthViewRotation != null) {
            this.mEarthViewRotation.removeAllListeners();
            this.mEarthViewRotation.cancel();
            this.mEarthViewRotation = null;
        }
//        if (this.mEarthViewTransX != null) {
//            this.mEarthViewTransX.removeAllListeners();
//            this.mEarthViewTransX.cancel();
//            this.mEarthViewTransX = null;
//        }
        if (this.mFireBalloonScaleX != null) {
            this.mFireBalloonScaleX.removeAllListeners();
            this.mFireBalloonScaleX.cancel();
            this.mFireBalloonScaleX = null;
        }
        if (this.mFireBalloonScaleY != null) {
            this.mFireBalloonScaleY.removeAllListeners();
            this.mFireBalloonScaleY.cancel();
            this.mFireBalloonScaleY = null;
        }
        if (this.mFireBalloonScaleX1 != null) {
            this.mFireBalloonScaleX1.removeAllListeners();
            this.mFireBalloonScaleX1.cancel();
            this.mFireBalloonScaleX1 = null;
        }
        if (this.mFireBalloonScaleY1 != null) {
            this.mFireBalloonScaleY1.removeAllListeners();
            this.mFireBalloonScaleY1.cancel();
            this.mFireBalloonScaleY1 = null;
        }
        if (this.mFireBalloonScaleX2 != null) {
            this.mFireBalloonScaleX2.removeAllListeners();
            this.mFireBalloonScaleX2.cancel();
            this.mFireBalloonScaleX2 = null;
        }
        if (this.mFireBalloonScaleY2 != null) {
            this.mFireBalloonScaleY2.removeAllListeners();
            this.mFireBalloonScaleY2.cancel();
            this.mFireBalloonScaleY2 = null;
        }
        if (this.mParachuteLeftRotation != null) {
            this.mParachuteLeftRotation.removeAllListeners();
            this.mParachuteLeftRotation.cancel();
            this.mParachuteLeftRotation = null;
        }
        if (this.mParachuteRightRotation != null) {
            this.mParachuteRightRotation.removeAllListeners();
            this.mParachuteRightRotation.cancel();
            this.mParachuteRightRotation = null;
        }
//        if (this.mParachuteBackgroundAlpha != null) {
//            this.mParachuteBackgroundAlpha.removeAllListeners();
//            this.mParachuteBackgroundAlpha.cancel();
//            this.mParachuteBackgroundAlpha = null;
//        }
        if (mRootAlpha != null) {
            mRootAlpha.removeAllListeners();
            mRootAlpha.cancel();
            mRootAlpha = null;
        }
        if (this.mCombinedAnimSet != null) {
            this.mCombinedAnimSet.removeAllListeners();
            this.mCombinedAnimSet.cancel();
            this.mCombinedAnimSet = null;
        }
        if (this.mFireBalloonAnimSet != null) {
            this.mFireBalloonAnimSet.removeAllListeners();
            this.mFireBalloonAnimSet.cancel();
            this.mFireBalloonAnimSet = null;
        }
        if (this.mBezierView != null) {
            this.mBezierView.a();
            this.mBezierView = null;
        }
        if (mGiftDisplayListener != null) {
            mGiftDisplayListener.b();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.travel_world;
    }

}
