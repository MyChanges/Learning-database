package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PathMeasure;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created mSenderView haiwang on 2017/6/10.
 */

public class TravelWorldView  extends CustomBaseViewRelative implements Animator.AnimatorListener {
    public static final String TAG = TravelWorldView.class.getSimpleName();
    ObjectAnimator mBuildFirstTransY2;
    ObjectAnimator mBuildATransY2;
    ObjectAnimator mBuildBTransY2;
    ObjectAnimator mBuildCTransY2;
    ObjectAnimator mBuildDTransY2;
    ObjectAnimator mBuildETransY2;
    ObjectAnimator mBuildFirstRotation;
    ObjectAnimator mBuildARotation;
    ObjectAnimator mBuildBRotation;
    ObjectAnimator mBuildCRotation;
    ObjectAnimator mBuildDRotation;
    ObjectAnimator mBuildERotation;
    ObjectAnimator mBuildFRotation;
    ObjectAnimator mBuildGRotation;
    ObjectAnimator mBuildHRotation;
    ObjectAnimator mBuildIRotation;
    ObjectAnimator mPlaneViewRotation;
    ObjectAnimator mPlaneViewRotation2;
    ObjectAnimator mFireBalloonScaleX;
    ObjectAnimator mFireBalloonScaleY;
    ObjectAnimator mFireBalloonScaleX1;
    ObjectAnimator mFireBalloonScaleY1;
    ObjectAnimator mFireBalloonScaleX2;
    ObjectAnimator mFireworksTransX;
    ObjectAnimator mFireworksRotation;
    ObjectAnimator mEarthViewAlpha;
    ObjectAnimator mEarthLightAlpha;
    ObjectAnimator mRootAlpha;
    AnimatorSet mCombinedAnimSet;
    AnimatorSet mFireBalloonAnimSet;
    AnimatorSet mPlaneViewAnimSet;
    AnimatorSet mHeartAnimSet;
    AnimatorSet mFireworksAnimSet;
    ValueAnimator mFireBalloonAnimator;
    ValueAnimator mParachuteLeftAnimator;
    ValueAnimator mParachuteRightAnimator;
    private int mScreenWidth;
    private int mScreenHeight;
    private Context mContext;
    private RelativeLayout mTravelWorldRoot;
    private RelativeLayout mEarthContainer;
    private TravelWorldBezierView mBezierView;
    private GiftDisplayListener mGiftDisplayListener;
    private boolean isRecycled = false;
    private boolean isDisplaying = false;
    private TravelWorldEarthView mEarthView;
    private ImageView mBuildFirst;
    ObjectAnimator mFireBalloonScaleY2;
    ObjectAnimator mParachuteLeftRotation;
    ObjectAnimator mParachuteRightRotation;
    ObjectAnimator mParachuteBackgroundAlpha;
    ObjectAnimator mHeartAScaleX;
    ObjectAnimator mHeartAScaleY;
    ObjectAnimator mHeartBScaleX;
    ObjectAnimator mHeartBScaleY;
    ObjectAnimator mHeartBScaleX1;
    ObjectAnimator mHeartBScaleY1;
    ObjectAnimator mHeartCRotation;
    ObjectAnimator mHeartDRotation;
    ObjectAnimator mHeartCScaleX;
    ObjectAnimator mHeartCScaleY;
    ObjectAnimator mHeartDScaleX;
    ObjectAnimator mHeartDScaleY;
    ObjectAnimator mHeartCScaleX1;
    ObjectAnimator mHeartCScaleY1;
    ObjectAnimator mHeartDScaleX1;
    ObjectAnimator mHeartDScaleY1;
    ObjectAnimator mLoveTextScaleX;
    ObjectAnimator mLoveTextScaleY;
    ObjectAnimator mLoveTextScaleX1;
    ObjectAnimator mLoveTextScaleY1;
    ObjectAnimator mFireworksScaleX;
    ObjectAnimator mFireworksScaleY;
    ObjectAnimator mEarthViewTransY;
    private float[] bA = new float[2];
    private RelativeLayout mParachuteLeftContainer;
    private float[] bC = new float[2];
    private RelativeLayout mParachuteRightContainer;
    private float[] bE = new float[2];
    private AnimationDrawable mFireworksAnimDrawable;
    private ImageView mBuildA;
    private ImageView mBuildB;
    private ImageView mBuildC;
    private ImageView mBuildD;
    private ImageView mBuildE;
    private ImageView mBuildF;
    private ImageView mBuildG;
    private ImageView mBuildH;
    private ImageView mBuildI;
    private ImageView mEarthLight;
    private ImageView mPlaneView;
    private ImageView mParachuteLeft;
    private ImageView mParachuteRight;
    private ImageView mParachuteBackground;
    private ImageView mHeartA;
    private ImageView mHeartB;
    private ImageView mHeartC;
    private ImageView mHeartD;
    private ImageView mFireworks;
    private ImageView mLoveText;
    private SimpleDraweeView bu;
    private SimpleDraweeView bv;
    private SimpleDraweeView bw;
    private SimpleDraweeView bx;
    private TextView mSenderView;
    private RelativeLayout mFireBalloonContainer;
    ObjectAnimator mEarthViewRotation;
    ObjectAnimator mEarthViewTransX;
    ObjectAnimator mEarthLightTransY;
    ObjectAnimator mSendViewTransX;
    ObjectAnimator mBuildFirstTransX;
    ObjectAnimator mBuildFirstTransY1;
    ObjectAnimator mBuildATransX;
    ObjectAnimator mBuildATransY1;
    ObjectAnimator mBuildBTransX;
    ObjectAnimator mBuildBTransY1;
    ObjectAnimator mBuildCTransX;
    ObjectAnimator mBuildCTransY1;
    ObjectAnimator mBuildDTransX;
    ObjectAnimator mBuildDTransY1;
    ObjectAnimator mBuildETransX;
    ObjectAnimator mBuildETransY1;
    ObjectAnimator mBuildFTransX;
    ObjectAnimator mBuildFTransY;
    ObjectAnimator mBuildGTransX;
    ObjectAnimator mBuildGTransY;
    ObjectAnimator mBuildHTransX;
    ObjectAnimator mBuildHTransY;
    ObjectAnimator mBuildITransX;
    ObjectAnimator mBuildITransY;

    public TravelWorldView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a();
    }

    public TravelWorldView(Context paramContext, GiftDisplayListener parama) {
        super(paramContext);
        this.mGiftDisplayListener = parama;
        a();
    }

    private void createAnims(){
        this.mTravelWorldRoot.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        Log.d(TAG, "dpToPx(mContext,200):" + ScreenUtil.b(this.mContext, 200.0F));
        Log.d(TAG, "dpToPx(mContext,500):" + ScreenUtil.b(this.mContext, 500.0F));
        this.mEarthViewTransX = ObjectAnimator.ofFloat(this.mEarthView, TRANSLATION_X, ScreenUtil.b(this.mContext, 0.0F), ScreenUtil.b(this.mContext, 175.0F));
        this.mEarthViewTransX.setInterpolator(new LinearInterpolator());
        this.mEarthViewTransX.setDuration(100L);
        this.mEarthViewTransY = ObjectAnimator.ofFloat(this.mEarthView, TRANSLATION_Y, this.mScreenHeight, ScreenUtil.b(this.mContext, 380.0F));
        this.mEarthViewTransY.setInterpolator(new LinearInterpolator());
        this.mEarthViewTransY.setDuration(700L);
        this.mEarthViewRotation = ObjectAnimator.ofFloat(this.mEarthView, ROTATION, 0.0F, 360.0F);
        this.mEarthViewRotation.setInterpolator(new LinearInterpolator());
        this.mEarthViewRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mEarthViewRotation.setRepeatCount(-1);
        this.mEarthViewRotation.setDuration(20000L);
        this.mSendViewTransX = ObjectAnimator.ofFloat(this.mSenderView, TRANSLATION_X, -this.mSenderView.getMeasuredWidth() - ScreenUtil.b(this.mContext, 100.0F), this.mSenderView.getMeasuredWidth() - ScreenUtil.b(this.mContext, 5.0F));
        this.mSendViewTransX.setInterpolator(new DecelerateInterpolator());
        this.mSendViewTransX.setDuration(800L);
        this.mEarthLightTransY = ObjectAnimator.ofFloat(this.mEarthLight, TRANSLATION_Y, this.mScreenHeight, -ScreenUtil.b(mContext, 30.0F));
        this.mEarthLightTransY.setInterpolator(new LinearInterpolator());
        this.mEarthLightTransY.setDuration(700L);
        this.mBuildFirstTransX = ObjectAnimator.ofFloat(this.mBuildFirst, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 200.0F) );
        this.mBuildFirstTransX.setInterpolator(new LinearInterpolator());
        this.mBuildFirstTransX.setDuration(400L);
        this.mBuildFirstTransY1 = ObjectAnimator.ofFloat(this.mBuildFirst, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 120.0F));
        this.mBuildFirstTransY1.setInterpolator(new LinearInterpolator());
        this.mBuildFirstTransY1.setDuration(400L);
        this.mBuildFirstTransY2 = ObjectAnimator.ofFloat(this.mBuildFirst, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 120.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 115.0F));
        this.mBuildFirstTransY2.setInterpolator(new LinearInterpolator());
        this.mBuildFirstTransY2.setDuration(100L);
        this.mBuildATransX = ObjectAnimator.ofFloat(this.mBuildA, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 200.0F));
        this.mBuildATransX.setInterpolator(new LinearInterpolator());
        this.mBuildATransX.setStartDelay(100L);
        this.mBuildATransX.setDuration(400L);
        this.mBuildATransY1 = ObjectAnimator.ofFloat(this.mBuildA, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 195.0F));
        this.mBuildATransY1.setInterpolator(new LinearInterpolator());
        this.mBuildATransY1.setStartDelay(100L);
        this.mBuildATransY1.setDuration(400L);
        this.mBuildATransY2 = ObjectAnimator.ofFloat(this.mBuildA, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 195.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 190.0F));
        this.mBuildATransY2.setInterpolator(new LinearInterpolator());
        this.mBuildATransY2.setDuration(100L);
        this.mBuildBTransX = ObjectAnimator.ofFloat(this.mBuildB, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 150.0F));
        this.mBuildBTransX.setInterpolator(new LinearInterpolator());
        this.mBuildBTransX.setStartDelay(200L);
        this.mBuildBTransX.setDuration(400L);
        this.mBuildBTransY1 = ObjectAnimator.ofFloat(this.mBuildB, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 200.0F));
        this.mBuildBTransY1.setInterpolator(new LinearInterpolator());
        this.mBuildBTransY1.setStartDelay(200L);
        this.mBuildBTransY1.setDuration(400L);
        this.mBuildBTransY2 = ObjectAnimator.ofFloat(this.mBuildB, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 200.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 195.0F) );
        this.mBuildBTransY2.setInterpolator(new LinearInterpolator());
        this.mBuildBTransY2.setDuration(100L);
        this.mBuildCTransX = ObjectAnimator.ofFloat(this.mBuildC, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 130.0F));
        this.mBuildCTransX.setInterpolator(new LinearInterpolator());
        this.mBuildCTransX.setStartDelay(300L);
        this.mBuildCTransX.setDuration(400L);
        this.mBuildCTransY1 = ObjectAnimator.ofFloat(this.mBuildC, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 255.0F));
        this.mBuildCTransY1.setInterpolator(new LinearInterpolator());
        this.mBuildCTransY1.setStartDelay(300L);
        this.mBuildCTransY1.setDuration(400L);
        this.mBuildCTransY2 = ObjectAnimator.ofFloat(this.mBuildC, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 250.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 245.0F));
        this.mBuildCTransY2.setInterpolator(new LinearInterpolator());
        this.mBuildCTransY2.setDuration(100L);
        this.mBuildDTransX = ObjectAnimator.ofFloat(this.mBuildD, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 80.0F));
        this.mBuildDTransX.setInterpolator(new LinearInterpolator());
        this.mBuildDTransX.setStartDelay(400L);
        this.mBuildDTransX.setDuration(400L);
        this.mBuildDTransY1 = ObjectAnimator.ofFloat(this.mBuildD, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 260.0F));
        this.mBuildDTransY1.setInterpolator(new LinearInterpolator());
        this.mBuildDTransY1.setStartDelay(400L);
        this.mBuildDTransY1.setDuration(400L);
        this.mBuildDTransY2 = ObjectAnimator.ofFloat(this.mBuildD, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 260.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 255.0F));
        this.mBuildDTransY2.setInterpolator(new LinearInterpolator());
        this.mBuildDTransY2.setDuration(100L);
        this.mBuildETransX = ObjectAnimator.ofFloat(this.mBuildE, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 15.0F));
        this.mBuildETransX.setInterpolator(new LinearInterpolator());
        this.mBuildETransX.setStartDelay(500L);
        this.mBuildETransX.setDuration(400L);
        this.mBuildETransY1 = ObjectAnimator.ofFloat(this.mBuildE, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 195.0F));
        this.mBuildETransY1.setInterpolator(new LinearInterpolator());
        this.mBuildETransY1.setStartDelay(500L);
        this.mBuildETransY1.setDuration(400L);
        this.mBuildETransY2 = ObjectAnimator.ofFloat(this.mBuildE, TRANSLATION_Y, this.mScreenHeight - ScreenUtil.b(this.mContext, 195.0F), this.mScreenHeight - ScreenUtil.b(this.mContext, 190.0F));
        this.mBuildETransY2.setInterpolator(new LinearInterpolator());
        this.mBuildETransY2.setDuration(100L);
        this.mBuildFTransX = ObjectAnimator.ofFloat(this.mBuildF, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 80.0F));
        this.mBuildFTransX.setInterpolator(new LinearInterpolator());
        this.mBuildFTransX.setStartDelay(600L);
        this.mBuildFTransX.setDuration(400L);
        this.mBuildFTransY = ObjectAnimator.ofFloat(this.mBuildF, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 200.0F));
        this.mBuildFTransY.setInterpolator(new LinearInterpolator());
        this.mBuildFTransY.setStartDelay(600L);
        this.mBuildFTransY.setDuration(400L);
        this.mBuildITransX = ObjectAnimator.ofFloat(this.mBuildI, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 100.0F));
        this.mBuildITransX.setInterpolator(new LinearInterpolator());
        this.mBuildITransX.setStartDelay(700L);
        this.mBuildITransX.setDuration(400L);
        this.mBuildITransY = ObjectAnimator.ofFloat(this.mBuildI, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 165.0F));
        this.mBuildITransY.setStartDelay(700L);
        this.mBuildITransY.setInterpolator(new LinearInterpolator());
        this.mBuildITransY.setDuration(400L);
        this.mBuildHTransX = ObjectAnimator.ofFloat(this.mBuildH, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 140.0F));
        this.mBuildHTransX.setInterpolator(new LinearInterpolator());
        this.mBuildHTransX.setStartDelay(800L);
        this.mBuildHTransX.setDuration(400L);
        this.mBuildHTransY = ObjectAnimator.ofFloat(this.mBuildH, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 135.0F) );
        this.mBuildHTransY.setInterpolator(new LinearInterpolator());
        this.mBuildHTransY.setStartDelay(800L);
        this.mBuildHTransY.setDuration(400L);
        this.mBuildGTransX = ObjectAnimator.ofFloat(this.mBuildG, TRANSLATION_X, this.mScreenWidth / 2, this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 135.0F));
        this.mBuildGTransX.setInterpolator(new LinearInterpolator());
        this.mBuildGTransX.setStartDelay(900L);
        this.mBuildGTransX.setDuration(400L);
        this.mBuildGTransY = ObjectAnimator.ofFloat(this.mBuildG, TRANSLATION_Y, this.mScreenHeight, this.mScreenHeight - ScreenUtil.b(this.mContext, 175.0F));
        this.mBuildGTransY.setInterpolator(new LinearInterpolator());
        this.mBuildGTransX.setStartDelay(900L);
        this.mBuildGTransY.setDuration(400L);
//        mEarthView.setRotationY(-10.0F);
        Log.d(TAG, "img_travel_earth.getRotationY():" + this.mEarthView.getRotationY());
        this.mBuildFirstRotation = ObjectAnimator.ofFloat(this.mBuildFirst, ROTATION, 0.0F, 360.0F);
        this.mBuildFirst.setPivotX(this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 10.0F));
        this.mBuildFirst.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 100.0F));
        this.mBuildFirstRotation.setInterpolator(new LinearInterpolator());
        this.mBuildFirstRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildFirstRotation.setRepeatCount(-1);
        this.mBuildFirstRotation.setDuration(22000L);
        this.mBuildARotation = ObjectAnimator.ofFloat(this.mBuildA, ROTATION, 0.0F, 360.0F);
        this.mBuildA.setPivotX(this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 10.0F));
        this.mBuildA.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 40.0F));
        this.mBuildARotation.setInterpolator(new LinearInterpolator());
        this.mBuildARotation.setStartDelay(100L);
        this.mBuildARotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildARotation.setRepeatCount(-1);
        this.mBuildARotation.setDuration(21000L);
        this.mBuildBRotation = ObjectAnimator.ofFloat(this.mBuildB, ROTATION, 0.0F, 360.0F );
        this.mBuildB.setPivotX(this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 40.0F));
        this.mBuildB.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 30.0F));
        this.mBuildBRotation.setInterpolator(new LinearInterpolator());
        this.mBuildBRotation.setStartDelay(200L);
        this.mBuildBRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildBRotation.setRepeatCount(-1);
        this.mBuildBRotation.setDuration(21000L);
        this.mBuildCRotation = ObjectAnimator.ofFloat(this.mBuildC, ROTATION, 0.0F, 360.0F );
        this.mBuildC.setPivotX(this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 60.0F));
        this.mBuildC.setPivotY(this.mScreenHeight / 2 + ScreenUtil.b(this.mContext, 30.0F));
        this.mBuildCRotation.setInterpolator(new LinearInterpolator());
        this.mBuildCRotation.setStartDelay(300L);
        this.mBuildCRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildCRotation.setRepeatCount(-1);
        this.mBuildCRotation.setDuration(21000L);
        this.mBuildDRotation = ObjectAnimator.ofFloat(this.mBuildD, ROTATION, 0.0F, 360.0F);
        this.mBuildD.setPivotX(this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 110.0F));
        this.mBuildD.setPivotY(this.mScreenHeight / 2 + ScreenUtil.b(this.mContext, 20.0F));
        this.mBuildDRotation.setInterpolator(new LinearInterpolator());
        this.mBuildDRotation.setStartDelay(400L);
        this.mBuildDRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildDRotation.setRepeatCount(-1);
        this.mBuildDRotation.setDuration(20000L);
        this.mBuildERotation = ObjectAnimator.ofFloat(this.mBuildE, ROTATION, 0.0F, 360.0F);
        this.mBuildE.setPivotX(-this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 165.0F));
        this.mBuildE.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 75.0F));
        this.mBuildERotation.setInterpolator(new LinearInterpolator());
        this.mBuildERotation.setStartDelay(500L);
        this.mBuildERotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildERotation.setRepeatCount(-1);
        this.mBuildERotation.setDuration(19000L);
        this.mBuildFRotation = ObjectAnimator.ofFloat(this.mBuildF, ROTATION, 0.0F, 360.0F );
        this.mBuildF.setPivotX(-ScreenUtil.b(this.mContext, 70.0F));
        this.mBuildF.setPivotY(ScreenUtil.b(this.mContext, 220.0F));
        this.mBuildFRotation.setInterpolator(new LinearInterpolator());
        this.mBuildFRotation.setStartDelay(600L);
        this.mBuildFRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildFRotation.setRepeatCount(-1);
        this.mBuildFRotation.setDuration(17000L);
        this.mBuildIRotation = ObjectAnimator.ofFloat(this.mBuildI, ROTATION, 0.0F, 360.0F );
        this.mBuildI.setPivotX(-this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 80.0F));
        this.mBuildI.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 50.0F));
        this.mBuildIRotation.setInterpolator(new LinearInterpolator());
        this.mBuildIRotation.setStartDelay(700L);
        this.mBuildIRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildIRotation.setRepeatCount(-1);
        this.mBuildIRotation.setDuration(20000L);
        this.mBuildGRotation = ObjectAnimator.ofFloat(this.mBuildG, ROTATION, 0.0F, 360.0F );
        this.mBuildG.setPivotX(-this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 40.0F));
        this.mBuildG.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 80.0F));
        this.mBuildGRotation.setInterpolator(new LinearInterpolator());
        this.mBuildGRotation.setStartDelay(800L);
        this.mBuildGRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildGRotation.setRepeatCount(-1);
        this.mBuildGRotation.setDuration(20000L);
        this.mBuildHRotation = ObjectAnimator.ofFloat(this.mBuildH, ROTATION, 0.0F, 360.0F);
        this.mBuildH.setPivotX(-this.mScreenWidth / 2 + ScreenUtil.b(this.mContext, 40.0F));
        this.mBuildH.setPivotY(this.mScreenHeight / 2 - ScreenUtil.b(this.mContext, 130.0F));
        this.mBuildHRotation.setInterpolator(new LinearInterpolator());
        this.mBuildHRotation.setStartDelay(900L);
        this.mBuildHRotation.setRepeatMode(ValueAnimator.RESTART);
        this.mBuildHRotation.setRepeatCount(-1);
        this.mBuildHRotation.setDuration(20000L);
        this.mPlaneViewRotation = ObjectAnimator.ofFloat(this.mPlaneView, ROTATION,  360.0F, 90.0F);
        this.mPlaneView.setPivotX(this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 100.0F));
        this.mPlaneView.setPivotY(this.mScreenHeight / 2 + ScreenUtil.b(this.mContext, 0.0F));
        this.mPlaneViewRotation.setDuration(1L);
        this.mPlaneViewRotation2 = ObjectAnimator.ofFloat(this.mPlaneView, ROTATION, 45.0F, -70.0F);
        this.mPlaneView.setPivotX(this.mScreenWidth / 2 - ScreenUtil.b(this.mContext, 130.0F));
        this.mPlaneView.setPivotY(this.mScreenHeight / 2 + ScreenUtil.b(this.mContext, 0.0F));
        this.mPlaneViewRotation2.setInterpolator(new LinearInterpolator());
        this.mPlaneViewRotation2.setDuration(6000L);
        this.mPlaneViewRotation2.setStartDelay(500L);
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
        this.mFireBalloonScaleX2.setStartDelay(1500L);
        this.mFireBalloonScaleX2.setDuration(2000L);
        this.mFireBalloonScaleY2 = ObjectAnimator.ofFloat(this.mFireBalloonContainer, SCALE_Y, 0.8F, 1.2F);
        this.mFireBalloonScaleY2.setInterpolator(new LinearInterpolator());
        this.mFireBalloonScaleY2.setStartDelay(1500L);
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
        this.mEarthViewAlpha = ObjectAnimator.ofFloat(this.mEarthView, View.ALPHA, 1.0F, 0.0F);
        this.mEarthViewAlpha.setInterpolator(new LinearInterpolator());
        this.mEarthViewAlpha.setStartDelay(4000L);
        this.mEarthViewAlpha.setDuration(500L);
        this.mEarthLightAlpha = ObjectAnimator.ofFloat(this.mEarthLight, View.ALPHA, 1.0F, 0.0F );
        this.mEarthLightAlpha.setInterpolator(new LinearInterpolator());
        this.mEarthLightAlpha.setStartDelay(4000L);
        this.mEarthLightAlpha.setDuration(10L);
        this.mParachuteBackgroundAlpha = ObjectAnimator.ofFloat(this.mParachuteBackground, View.ALPHA, 0.0F, 1.0F);
        this.mParachuteBackgroundAlpha.setInterpolator(new LinearInterpolator());
        this.mParachuteBackgroundAlpha.setDuration(1000L);
        this.mHeartBScaleX = ObjectAnimator.ofFloat(this.mHeartB, SCALE_X, 1.0F, 0.1F );
        this.mHeartBScaleX.setDuration(1L);
        this.mHeartBScaleY = ObjectAnimator.ofFloat(this.mHeartB, SCALE_Y, 1.0F, 0.1F );
        this.mHeartBScaleY.setDuration(1L);
        this.mHeartAScaleX = ObjectAnimator.ofFloat(this.mHeartA, SCALE_X, 0.1F, 0.6F );
        this.mHeartAScaleX.setInterpolator(new DecelerateInterpolator());
        this.mHeartAScaleX.setStartDelay(150L);
        this.mHeartAScaleX.setDuration(3000L);
        this.mHeartAScaleY = ObjectAnimator.ofFloat(this.mHeartA, SCALE_Y,  0.1F, 0.6F);
        this.mHeartAScaleY.setInterpolator(new DecelerateInterpolator());
        this.mHeartAScaleY.setStartDelay(150L);
        this.mHeartAScaleY.setDuration(3000L);
        this.mHeartBScaleX1 = ObjectAnimator.ofFloat(this.mHeartB, SCALE_X, 0.1F, 0.9F);
        this.mHeartBScaleX1.setInterpolator(new DecelerateInterpolator());
        this.mHeartBScaleX1.setStartDelay(500L);
        this.mHeartBScaleX1.setDuration(2000L);
        this.mHeartBScaleY1 = ObjectAnimator.ofFloat(this.mHeartB, SCALE_Y, 0.1F, 0.9F );
        this.mHeartBScaleY1.setInterpolator(new DecelerateInterpolator());
        this.mHeartBScaleY1.setStartDelay(500L);
        this.mHeartBScaleY1.setDuration(2000L);
        this.mHeartCRotation = ObjectAnimator.ofFloat(this.mHeartC, ROTATION, 0.0F, 12.0F);
        this.mHeartCRotation.setDuration(1L);
        this.mHeartDRotation = ObjectAnimator.ofFloat(this.mHeartD, ROTATION, 0.0F, 12.0F );
        this.mHeartDRotation.setDuration(1L);
        this.mHeartCScaleX = ObjectAnimator.ofFloat(this.mHeartC, SCALE_X, 1.0F, 0.1F );
        this.mHeartCScaleX.setDuration(1L);
        this.mHeartCScaleY = ObjectAnimator.ofFloat(this.mHeartC, SCALE_Y, 1.0F, 0.1F );
        this.mHeartCScaleY.setDuration(1L);
        this.mHeartDScaleX = ObjectAnimator.ofFloat(this.mHeartD, SCALE_X, 1.0F, 0.1F);
        this.mHeartDScaleX.setDuration(1L);
        this.mHeartDScaleY = ObjectAnimator.ofFloat(this.mHeartD, SCALE_Y, 1.0F, 0.1F );
        this.mHeartDScaleY.setDuration(1L);
        this.mHeartCScaleX1 = ObjectAnimator.ofFloat(this.mHeartC, SCALE_X, 0.1F, 0.5F );
        this.mHeartCScaleX1.setInterpolator(new LinearInterpolator());
        this.mHeartCScaleX1.setStartDelay(300L);
        this.mHeartCScaleX1.setDuration(2500L);
        this.mHeartCScaleY1 = ObjectAnimator.ofFloat(this.mHeartC, SCALE_Y, 0.1F, 0.5F);
        this.mHeartCScaleY1.setInterpolator(new LinearInterpolator());
        this.mHeartCScaleY1.setStartDelay(0L);
        this.mHeartCScaleY1.setDuration(2500L);
        this.mHeartDScaleX1 = ObjectAnimator.ofFloat(this.mHeartD, SCALE_X, 0.1F, 0.9F );
        this.mHeartDScaleX1.setInterpolator(new LinearInterpolator());
        this.mHeartDScaleX1.setStartDelay(300L);
        this.mHeartDScaleX1.setDuration(2000L);
        this.mHeartDScaleY1 = ObjectAnimator.ofFloat(this.mHeartD, SCALE_Y, 0.1F, 0.9F );
        this.mHeartDScaleY1.setInterpolator(new LinearInterpolator());
        this.mHeartDScaleY1.setStartDelay(300L);
        this.mHeartDScaleY1.setDuration(2000L);
        this.mFireworksScaleX = ObjectAnimator.ofFloat(this.mFireworks, SCALE_X, 1.0F, 0.6F);
        this.mFireworksScaleX.setStartDelay(200L);
        this.mFireworksScaleX.setDuration(1L);
        this.mFireworksScaleY = ObjectAnimator.ofFloat(this.mFireworks, SCALE_Y,1.0F, 0.6F );
        this.mFireworksScaleY.setDuration(1L);
        this.mFireworksRotation = ObjectAnimator.ofFloat(this.mFireworks, ROTATION, 0.0F, -15.0F);
        this.mFireworksRotation.setDuration(1L);
        this.mFireworksTransX = ObjectAnimator.ofFloat(this.mFireworks, TRANSLATION_X, 0.0F, 0 - ScreenUtil.b(this.mContext, 50.0F));
        this.mFireworksTransX.setDuration(1L);
        this.mLoveTextScaleX = ObjectAnimator.ofFloat(this.mLoveText, SCALE_X, 1.0F, 0.1F);
        this.mLoveTextScaleX.setDuration(1L);
        this.mLoveTextScaleY = ObjectAnimator.ofFloat(this.mLoveText, SCALE_Y, 1.0F, 0.1F);
        this.mLoveTextScaleY.setDuration(1L);
        this.mLoveTextScaleX1 = ObjectAnimator.ofFloat(this.mLoveText, SCALE_X, 0.1F, 1.0F);
        this.mLoveTextScaleX1.setInterpolator(new LinearInterpolator());
        this.mLoveTextScaleX1.setStartDelay(1000L);
        this.mLoveTextScaleX1.setDuration(1000L);
        this.mLoveTextScaleY1 = ObjectAnimator.ofFloat(this.mLoveText, SCALE_Y,0.1F, 1.0F);
        this.mLoveTextScaleY1.setInterpolator(new LinearInterpolator());
        this.mLoveTextScaleY1.setStartDelay(1000L);
        this.mLoveTextScaleY1.setDuration(1000L);
        this.mRootAlpha = ObjectAnimator.ofFloat(this.mTravelWorldRoot, View.ALPHA,1.0F, 0.0F);
        this.mRootAlpha.setInterpolator(new LinearInterpolator());
        this.mRootAlpha.setStartDelay(1000L);
        this.mRootAlpha.setDuration(1000L);
        this.mCombinedAnimSet = new AnimatorSet();
        this.mFireBalloonAnimSet = new AnimatorSet();
        this.mPlaneViewAnimSet = new AnimatorSet();
        this.mHeartAnimSet = new AnimatorSet();
        this.mFireworksAnimSet = new AnimatorSet();
        addListeners();
        if (mGiftDisplayListener != null) {
//            InKeLog.TAG(TAG, "onAnimationReady mListener != null");
            mGiftDisplayListener.a();
        }
    }

    private void recycle() {
        this.isDisplaying = false;
        if (isRecycled) return;
        cleanBuildingAnimListener();
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
        if (this.mEarthViewTransX != null) {
            this.mEarthViewTransX.removeAllListeners();
            this.mEarthViewTransX.cancel();
            this.mEarthViewTransX = null;
        }
        if (this.mEarthLightTransY != null) {
            this.mEarthLightTransY.removeAllListeners();
            this.mEarthLightTransY.cancel();
            this.mEarthLightTransY = null;
        }
        if (this.mPlaneViewRotation != null) {
            this.mPlaneViewRotation.removeAllListeners();
            this.mPlaneViewRotation.cancel();
            this.mPlaneViewRotation = null;
        }
        if (this.mPlaneViewRotation2 != null) {
            this.mPlaneViewRotation2.removeAllListeners();
            this.mPlaneViewRotation2.cancel();
            this.mPlaneViewRotation2 = null;
        }
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
        if (this.mParachuteBackgroundAlpha != null) {
            this.mParachuteBackgroundAlpha.removeAllListeners();
            this.mParachuteBackgroundAlpha.cancel();
            this.mParachuteBackgroundAlpha = null;
        }
        if (this.mHeartAScaleX != null) {
            this.mHeartAScaleX.removeAllListeners();
            this.mHeartAScaleX.cancel();
            this.mHeartAScaleX = null;
        }
        if (this.mHeartAScaleY != null) {
            this.mHeartAScaleY.removeAllListeners();
            this.mHeartAScaleY.cancel();
            this.mHeartAScaleY = null;
        }
        if (this.mHeartBScaleX != null) {
            this.mHeartBScaleX.removeAllListeners();
            this.mHeartBScaleX.cancel();
            this.mHeartBScaleX = null;
        }
        if (this.mHeartBScaleY != null) {
            this.mHeartBScaleY.removeAllListeners();
            this.mHeartBScaleY.cancel();
            this.mHeartBScaleY = null;
        }
        if (this.mHeartBScaleX1 != null) {
            this.mHeartBScaleX1.removeAllListeners();
            this.mHeartBScaleX1.cancel();
            this.mHeartBScaleX1 = null;
        }
        if (this.mHeartBScaleY1 != null) {
            this.mHeartBScaleY1.removeAllListeners();
            this.mHeartBScaleY1.cancel();
            this.mHeartBScaleY1 = null;
        }
        if (this.mHeartCRotation != null) {
            this.mHeartCRotation.removeAllListeners();
            this.mHeartCRotation.cancel();
            this.mHeartCRotation = null;
        }
        if (this.mHeartDRotation != null) {
            this.mHeartDRotation.removeAllListeners();
            this.mHeartDRotation.cancel();
            this.mHeartDRotation = null;
        }
        if (this.mHeartCScaleX != null) {
            this.mHeartCScaleX.removeAllListeners();
            this.mHeartCScaleX.cancel();
            this.mHeartCScaleX = null;
        }
        if (this.mHeartCScaleY != null) {
            this.mHeartCScaleY.removeAllListeners();
            this.mHeartCScaleY.cancel();
            this.mHeartCScaleY = null;
        }
        if (this.mHeartDScaleX != null) {
            this.mHeartDScaleX.removeAllListeners();
            this.mHeartDScaleX.cancel();
            this.mHeartDScaleX = null;
        }
        if (this.mHeartDScaleY != null) {
            this.mHeartDScaleY.removeAllListeners();
            this.mHeartDScaleY.cancel();
            this.mHeartDScaleY = null;
        }
        if (this.mHeartCScaleX1 != null) {
            this.mHeartCScaleX1.removeAllListeners();
            this.mHeartCScaleX1.cancel();
            this.mHeartCScaleX1 = null;
        }
        if (this.mHeartCScaleY1 != null) {
            this.mHeartCScaleY1.removeAllListeners();
            this.mHeartCScaleY1.cancel();
            this.mHeartCScaleY1 = null;
        }
        if (this.mHeartDScaleX1 != null) {
            this.mHeartDScaleX1.removeAllListeners();
            this.mHeartDScaleX1.cancel();
            this.mHeartDScaleX1 = null;
        }
        if (this.mHeartDScaleY1 != null) {
            this.mHeartDScaleY1.removeAllListeners();
            this.mHeartDScaleY1.cancel();
            this.mHeartDScaleY1 = null;
        }
        if (this.mLoveTextScaleX != null) {
            this.mLoveTextScaleX.removeAllListeners();
            this.mLoveTextScaleX.cancel();
            this.mLoveTextScaleX = null;
        }
        if (this.mLoveTextScaleY != null) {
            this.mLoveTextScaleY.removeAllListeners();
            this.mLoveTextScaleY.cancel();
            this.mLoveTextScaleY = null;
        }
        if (this.mLoveTextScaleX1 != null) {
            this.mLoveTextScaleX1.removeAllListeners();
            this.mLoveTextScaleX1.cancel();
            this.mLoveTextScaleX1 = null;
        }
        if (this.mLoveTextScaleY1 != null) {
            this.mLoveTextScaleY1.removeAllListeners();
            this.mLoveTextScaleY1.cancel();
            this.mLoveTextScaleY1 = null;
        }
        if (this.mFireworksScaleX != null) {
            this.mFireworksScaleX.removeAllListeners();
            this.mFireworksScaleX.cancel();
            this.mFireworksScaleX = null;
        }
        if (this.mFireworksScaleY != null) {
            this.mFireworksScaleY.removeAllListeners();
            this.mFireworksScaleY.cancel();
            this.mFireworksScaleY = null;
        }
        if (this.mFireworksTransX != null) {
            this.mFireworksTransX.removeAllListeners();
            this.mFireworksTransX.cancel();
            this.mFireworksTransX = null;
        }
        if (this.mFireworksRotation != null) {
            this.mFireworksRotation.removeAllListeners();
            this.mFireworksRotation.cancel();
            this.mFireworksRotation = null;
        }
        if (this.mEarthViewAlpha != null) {
            this.mEarthViewAlpha.removeAllListeners();
            this.mEarthViewAlpha.cancel();
            this.mEarthViewAlpha = null;
        }
        if (this.mEarthLightAlpha != null) {
            this.mEarthLightAlpha.removeAllListeners();
            this.mEarthLightAlpha.cancel();
            this.mEarthLightAlpha = null;
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
        if (this.mPlaneViewAnimSet != null) {
            this.mPlaneViewAnimSet.removeAllListeners();
            this.mPlaneViewAnimSet.cancel();
            this.mPlaneViewAnimSet = null;
        }
        if (this.mHeartAnimSet != null) {
            this.mHeartAnimSet.removeAllListeners();
            this.mHeartAnimSet.cancel();
            this.mHeartAnimSet = null;
        }
        if (this.mFireworksAnimSet != null) {
            this.mFireworksAnimSet.removeAllListeners();
            this.mFireworksAnimSet.cancel();
            this.mFireworksAnimSet = null;
        }
        if (this.mRootAlpha != null) {
            this.mRootAlpha.cancel();
            this.mRootAlpha = null;
        }
        if (this.mFireworksAnimDrawable != null) {
            this.mFireworksAnimDrawable.stop();
            this.mFireworksAnimDrawable = null;
        }
        this.mEarthView = null;
        this.mBuildFirst = null;
        this.mBuildA = null;
        this.mBuildB = null;
        this.mBuildC = null;
        this.mBuildD = null;
        this.mBuildE = null;
        this.mBuildF = null;
        this.mBuildG = null;
        this.mBuildH = null;
        this.mBuildI = null;
        this.mEarthLight = null;
        this.mPlaneView = null;
        this.mParachuteLeft = null;
        this.mParachuteRight = null;
        this.mParachuteBackground = null;
        this.mHeartA = null;
        this.mHeartB = null;
        this.mHeartC = null;
        this.mHeartD = null;
        this.mFireworks = null;
        this.mLoveText = null;
        this.bu = null;
        this.bv = null;
        this.bw = null;
        this.bx = null;
        if (this.mBezierView != null) {
            this.mBezierView.a();
            this.mBezierView = null;
        }
        this.mSenderView = null;
        this.mFireBalloonContainer = null;
        this.mParachuteLeftContainer = null;
        this.mParachuteRightContainer = null;
        this.mTravelWorldRoot = null;
        this.mContext = null;
        this.isRecycled = true;
        if (mGiftDisplayListener != null) {
            mGiftDisplayListener.b();
        }
    }

    private void cleanBuildingAnimListener() {
        if (this.isRecycled) return;
        if (this.mBuildFirstTransX != null) {
            this.mBuildFirstTransX.removeAllListeners();
            this.mBuildFirstTransX.cancel();
            this.mBuildFirstTransX = null;
        }
        if (this.mBuildFirstTransY1 != null) {
            this.mBuildFirstTransY1.removeAllListeners();
            this.mBuildFirstTransY1.cancel();
            this.mBuildFirstTransY1 = null;
        }
        if (this.mBuildATransX != null) {
            this.mBuildATransX.removeAllListeners();
            this.mBuildATransX.cancel();
            this.mBuildATransX = null;
        }
        if (this.mBuildATransY1 != null) {
            this.mBuildATransY1.removeAllListeners();
            this.mBuildATransY1.cancel();
            this.mBuildATransY1 = null;
        }
        if (this.mBuildBTransX != null) {
            this.mBuildBTransX.removeAllListeners();
            this.mBuildBTransX.cancel();
            this.mBuildBTransX = null;
        }
        if (this.mBuildBTransY1 != null) {
            this.mBuildBTransY1.removeAllListeners();
            this.mBuildBTransY1.cancel();
            this.mBuildBTransY1 = null;
        }
        if (this.mBuildCTransX != null) {
            this.mBuildCTransX.removeAllListeners();
            this.mBuildCTransX.cancel();
            this.mBuildCTransX = null;
        }
        if (this.mBuildCTransY1 != null) {
            this.mBuildCTransY1.removeAllListeners();
            this.mBuildCTransY1.cancel();
            this.mBuildCTransY1 = null;
        }
        if (this.mBuildDTransX != null) {
            this.mBuildDTransX.removeAllListeners();
            this.mBuildDTransX.cancel();
            this.mBuildDTransX = null;
        }
        if (this.mBuildDTransY1 != null) {
            this.mBuildDTransY1.removeAllListeners();
            this.mBuildDTransY1.cancel();
            this.mBuildDTransY1 = null;
        }
        if (this.mBuildETransX != null) {
            this.mBuildETransX.removeAllListeners();
            this.mBuildETransX.cancel();
            this.mBuildETransX = null;
        }
        if (this.mBuildETransY1 != null) {
            this.mBuildETransY1.removeAllListeners();
            this.mBuildETransY1.cancel();
            this.mBuildETransY1 = null;
        }
        if (this.mBuildFTransX != null) {
            this.mBuildFTransX.removeAllListeners();
            this.mBuildFTransX.cancel();
            this.mBuildFTransX = null;
        }
        if (this.mBuildFTransY != null) {
            this.mBuildFTransY.removeAllListeners();
            this.mBuildFTransY.cancel();
            this.mBuildFTransY = null;
        }
        if (this.mBuildGTransX != null) {
            this.mBuildGTransX.removeAllListeners();
            this.mBuildGTransX.cancel();
            this.mBuildGTransX = null;
        }
        if (this.mBuildGTransY != null) {
            this.mBuildGTransY.removeAllListeners();
            this.mBuildGTransY.cancel();
            this.mBuildGTransY = null;
        }
        if (this.mBuildHTransX != null) {
            this.mBuildHTransX.removeAllListeners();
            this.mBuildHTransX.cancel();
            this.mBuildHTransX = null;
        }
        if (this.mBuildHTransY != null) {
            this.mBuildHTransY.removeAllListeners();
            this.mBuildHTransY.cancel();
            this.mBuildHTransY = null;
        }
        if (this.mBuildITransX != null) {
            this.mBuildITransX.removeAllListeners();
            this.mBuildITransX.cancel();
            this.mBuildITransX = null;
        }
        if (this.mBuildITransY != null) {
            this.mBuildITransY.removeAllListeners();
            this.mBuildITransY.cancel();
            this.mBuildITransY = null;
        }
        if (this.mBuildFirstTransY2 != null) {
            this.mBuildFirstTransY2.removeAllListeners();
            this.mBuildFirstTransY2.cancel();
            this.mBuildFirstTransY2 = null;
        }
        if (this.mBuildATransY2 != null) {
            this.mBuildATransY2.removeAllListeners();
            this.mBuildATransY2.cancel();
            this.mBuildATransY2 = null;
        }
        if (this.mBuildBTransY2 != null) {
            this.mBuildBTransY2.removeAllListeners();
            this.mBuildBTransY2.cancel();
            this.mBuildBTransY2 = null;
        }
        if (this.mBuildCTransY2 != null) {
            this.mBuildCTransY2.removeAllListeners();
            this.mBuildCTransY2.cancel();
            this.mBuildCTransY2 = null;
        }
        if (this.mBuildDTransY2 != null) {
            this.mBuildDTransY2.removeAllListeners();
            this.mBuildDTransY2.cancel();
            this.mBuildDTransY2 = null;
        }
        if (this.mBuildETransY2 != null) {
            this.mBuildETransY2.removeAllListeners();
            this.mBuildETransY2.cancel();
            this.mBuildETransY2 = null;
        }
        if (this.mBuildFirstRotation != null) {
            this.mBuildFirstRotation.removeAllListeners();
            this.mBuildFirstRotation.cancel();
            this.mBuildFirstRotation = null;
        }
        if (this.mBuildARotation != null) {
            this.mBuildARotation.removeAllListeners();
            this.mBuildARotation.cancel();
            this.mBuildARotation = null;
        }
        if (this.mBuildBRotation != null) {
            this.mBuildBRotation.removeAllListeners();
            this.mBuildBRotation.cancel();
            this.mBuildBRotation = null;
        }
        if (this.mBuildCRotation != null) {
            this.mBuildCRotation.removeAllListeners();
            this.mBuildCRotation.cancel();
            this.mBuildCRotation = null;
        }
        if (this.mBuildDRotation != null) {
            this.mBuildDRotation.removeAllListeners();
            this.mBuildDRotation.cancel();
            this.mBuildDRotation = null;
        }
        if (this.mBuildERotation != null) {
            this.mBuildERotation.removeAllListeners();
            this.mBuildERotation.cancel();
            this.mBuildERotation = null;
        }
        if (this.mBuildFRotation != null) {
            this.mBuildFRotation.removeAllListeners();
            this.mBuildFRotation.cancel();
            this.mBuildFRotation = null;
        }
        if (this.mBuildGRotation != null) {
            this.mBuildGRotation.removeAllListeners();
            this.mBuildGRotation.cancel();
            this.mBuildGRotation = null;
        }
        if (this.mBuildHRotation != null) {
            this.mBuildHRotation.removeAllListeners();
            this.mBuildHRotation.cancel();
            this.mBuildHRotation = null;
        }

        if (this.mBuildIRotation != null) {
            this.mBuildIRotation.removeAllListeners();
            this.mBuildIRotation.cancel();
            this.mBuildIRotation = null;
        }
    }

    private void m() {}

    @Override
    protected void a() {
        this.mContext = getContext();
        this.mScreenWidth = ScreenUtil.a(this.mContext);
        this.mScreenHeight = ScreenUtil.b(this.mContext);
        this.mTravelWorldRoot = ((RelativeLayout)findViewById(R.id.travel_world_releative));
        this.mEarthContainer = ((RelativeLayout)findViewById(R.id.travel_world_earth_container));
        this.mBezierView = ((TravelWorldBezierView)findViewById(R.id.bezier_path_veiw));
        this.mEarthView = ((TravelWorldEarthView)findViewById(R.id.img_travel_earth));
        this.mBuildFirst = ((ImageView)findViewById(R.id.travel_world_earth_build_a_first));
        this.mBuildA = ((ImageView)findViewById(R.id.travel_world_earth_build_a));
        this.mBuildB = ((ImageView)findViewById(R.id.travel_world_earth_build_b));
        this.mBuildC = ((ImageView)findViewById(R.id.travel_world_earth_build_c));
        this.mBuildD = ((ImageView)findViewById(R.id.travel_world_earth_build_d));
        this.mBuildE = ((ImageView)findViewById(R.id.travel_world_earth_build_e));
        this.mBuildF = ((ImageView)findViewById(R.id.travel_world_earth_build_f));
        this.mBuildG = ((ImageView)findViewById(R.id.travel_world_earth_build_g));
        this.mBuildH = ((ImageView)findViewById(R.id.travel_world_earth_build_h));
        this.mBuildI = ((ImageView)findViewById(R.id.travel_world_earth_build_i));
        this.mEarthLight = ((ImageView)findViewById(R.id.travel_world_earth_light));
        this.mPlaneView = ((ImageView)findViewById(R.id.travel_world_plane));
        this.mParachuteLeft = ((ImageView)findViewById(R.id.travel_world_earth_parachute_left));
        this.mParachuteRight = ((ImageView)findViewById(R.id.travel_world_earth_parachute_right));
        this.mParachuteBackground = ((ImageView)findViewById(R.id.travel_world_earth_parachute_background));
        this.mHeartA = ((ImageView)findViewById(R.id.travel_world_earth_heart_a));
        this.mHeartB = ((ImageView)findViewById(R.id.travel_world_earth_heart_b));
        this.mHeartC = ((ImageView)findViewById(R.id.travel_world_earth_heart_c));
        this.mHeartD = ((ImageView)findViewById(R.id.travel_world_earth_heart_d));
        this.mFireworks = ((ImageView)findViewById(R.id.travel_world_earth_fireworks));
        this.mFireworks.setImageResource(R.drawable.travel_world_fireworks);
        this.mLoveText = ((ImageView)findViewById(R.id.travel_world_earth_test));
        this.bu = ((SimpleDraweeView)findViewById(R.id.img_travel_world_fireballoon_left));
        this.bv = ((SimpleDraweeView)findViewById(R.id.img_travel_world_fireballoon_right));
        this.bw = ((SimpleDraweeView)findViewById(R.id.img_travel_world_earth_parachute_left));
        this.bx = ((SimpleDraweeView)findViewById(R.id.img_travel_world_earth_parachute_right));
        this.mSenderView = ((TextView)findViewById(R.id.tv_travel_world_earth_sender));
        this.mFireBalloonContainer = ((RelativeLayout)findViewById(R.id.travel_world_fireballoon_container));
        this.mParachuteLeftContainer = ((RelativeLayout)findViewById(R.id.travel_world_earth_parachute_left_container));
        this.mParachuteRightContainer = ((RelativeLayout)findViewById(R.id.travel_world_earth_parachute_right_container));
        createAnims();
    }

    public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
//        InKeLog.TAG(TAG, "senderUrl��" + paramString1);
//        InKeLog.TAG(TAG, "creatorUrl��" + paramString2);
//        if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
//            mEarthViewRotation.mEarthViewTransY(paramString1, this.bu, 0, 70, 70);
//            mEarthViewRotation.mEarthViewTransY(paramString2, this.bv, 0, 70, 70);
//            mEarthViewRotation.mEarthViewTransY(paramString2, this.bw, 0, 80, 80);
//            mEarthViewRotation.mEarthViewTransY(paramString1, this.bx, 0, 80, 80);
//        }
//        if (!TextUtils.isEmpty(paramString3)) {
//            this.mSenderView.setText(paramString3 + getContext().getString(R.string.gift_send) + paramString4);
//            return;
//        }
//        this.mSenderView.setVisibility(INVISIBLE);
    }

    public void start() {
        if (mGiftDisplayListener != null) {
            mGiftDisplayListener.a();
        }
        if (isDisplaying) {
            return;
        }
        this.isDisplaying = true;
        this.mCombinedAnimSet.play(this.mEarthViewTransX).with(this.mSendViewTransX);
        this.mCombinedAnimSet.play(this.mEarthViewTransY).with(this.mEarthLightTransY).after(this.mEarthViewTransX);
        this.mCombinedAnimSet.play(this.mEarthViewRotation).after(this.mEarthViewTransY);
        this.mCombinedAnimSet.play(this.mBuildFirstTransX).with(this.mBuildFirstTransY1).with(this.mBuildFirstRotation).
                with(this.mBuildATransX).with(this.mBuildATransY1).with(this.mBuildARotation).with(this.mBuildBTransX).
                with(this.mBuildBTransY1).with(this.mBuildBRotation).with(this.mBuildCTransX).with(this.mBuildCTransY1).
                with(this.mBuildCRotation).with(this.mBuildDTransX).with(this.mBuildDTransY1).with(this.mBuildDRotation).
                with(this.mBuildETransX).with(this.mBuildETransY1).with(this.mBuildERotation).with(this.mBuildFTransX).
                with(this.mBuildFTransY).with(this.mBuildFRotation).with(this.mBuildITransX).with(this.mBuildITransY).
                with(this.mBuildIRotation).with(this.mBuildGTransX).with(this.mBuildGTransY).with(this.mBuildGRotation).
                with(this.mBuildHTransX).with(this.mBuildHTransY).with(this.mBuildHRotation).after(this.mEarthViewTransY);
        this.mCombinedAnimSet.play(this.mBuildFirstTransY2).after(this.mBuildFirstTransX);
        this.mCombinedAnimSet.play(this.mBuildATransY2).after(this.mBuildATransX);
        this.mCombinedAnimSet.play(this.mBuildBTransY2).after(this.mBuildBTransX);
        this.mCombinedAnimSet.play(this.mBuildCTransY2).after(this.mBuildCTransX);
        this.mCombinedAnimSet.play(this.mBuildDTransY2).after(this.mBuildDTransX);
        this.mCombinedAnimSet.play(this.mBuildETransY2).after(this.mBuildETransX);
        this.mCombinedAnimSet.play(this.mPlaneViewRotation).after(this.mBuildFTransX);
        this.mCombinedAnimSet.play(this.mPlaneViewRotation2).after(this.mPlaneViewRotation);
        this.mCombinedAnimSet.play(this.mFireBalloonScaleX).with(this.mFireBalloonScaleY);
        this.mCombinedAnimSet.play(this.mParachuteLeftRotation).with(this.mParachuteRightRotation);
        this.mCombinedAnimSet.start();
    }

    public void addListeners() {
        this.mEarthViewTransY.addListener(this);
        this.mEarthLightTransY.addListener(this);
        this.mBuildFirstTransX.addListener(this);
        this.mBuildATransX.addListener(this);
        this.mBuildBTransX.addListener(this);
        this.mBuildCTransX.addListener(this);
        this.mBuildDTransX.addListener(this);
        this.mBuildETransX.addListener(this);
        this.mBuildFTransX.addListener(this);
        this.mBuildITransX.addListener(this);
        this.mBuildGTransX.addListener(this);
        this.mBuildHTransX.addListener(this);
        this.mParachuteLeftRotation.addListener(this);
        this.mPlaneViewRotation2.addListener(this);
        this.mFireBalloonScaleX1.addListener(this);
        this.mFireBalloonScaleX2.addListener(this);
        this.mParachuteBackgroundAlpha.addListener(this);
        this.mHeartAScaleX.addListener(this);
        this.mHeartBScaleX1.addListener(this);
        this.mHeartBScaleX.addListener(this);
        this.mHeartCScaleX1.addListener(this);
        this.mFireworksScaleX.addListener(this);
        this.mLoveTextScaleX1.addListener(this);
        this.mPlaneViewRotation.addListener(this);
        this.mRootAlpha.addListener(this);
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
                mFireBalloonContainer.setTranslationX(bE[0] - ScreenUtil.b(TravelWorldView.this.getContext(), 130.0F));
                mFireBalloonContainer.setTranslationY(bE[1] - ScreenUtil.b(TravelWorldView.this.getContext(), 270.0F));
            }
        });
        this.mFireBalloonAnimator.start();
        this.mFireBalloonAnimSet.play(this.mFireBalloonScaleX1).with(this.mFireBalloonScaleY1);
        this.mFireBalloonAnimSet.start();
        this.mFireBalloonAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (isRecycled) {
                    return;
                }
                startParachuteLeftAnim();
                startParachuteRightAnim();
                mEarthViewAlpha.start();
                mEarthLightAlpha.start();
                mParachuteBackgroundAlpha.start();
                startHeartAnim();
                mBuildA.setVisibility(INVISIBLE);
                mBuildB.setVisibility(INVISIBLE);
                mBuildC.setVisibility(INVISIBLE);
                mBuildD.setVisibility(INVISIBLE);
                mBuildE.setVisibility(INVISIBLE);
                mBuildF.setVisibility(INVISIBLE);
                mBuildG.setVisibility(INVISIBLE);
                mBuildH.setVisibility(INVISIBLE);
                mBuildI.setVisibility(INVISIBLE);
                mBuildFirst.setVisibility(INVISIBLE);
//                TravelWorldView.n(TravelWorldView.this);
            }
        });
    }

    public void startParachuteLeftAnim() {
        this.mParachuteLeftContainer.setVisibility(VISIBLE);
        final PathMeasure pathMeasure = new PathMeasure(this.mBezierView.getParachuteLeftPath(), false);
        Log.d(TAG, "getParachuteLeftPath" + pathMeasure.getLength());
        this.mParachuteLeftAnimator = ValueAnimator.ofFloat(0.0F, pathMeasure.getLength());
        this.mParachuteLeftAnimator.setDuration(8000L);
        this.mParachuteLeftAnimator.setInterpolator(new LinearInterpolator());
        this.mParachuteLeftAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animator) {
                float f = (Float)animator.getAnimatedValue();
                pathMeasure.getPosTan(f, bA, null);
                mParachuteLeftContainer.setTranslationX(bA[0] - ScreenUtil.b(getContext(), 80.0F));
                mParachuteLeftContainer.setTranslationY(bA[1] - ScreenUtil.b(getContext(), 100.0F));
            }
        });
        this.mParachuteLeftAnimator.start();
    }

    public void startParachuteRightAnim() {
        this.mParachuteRightContainer.setVisibility(VISIBLE);
        final PathMeasure pathMeasure = new PathMeasure(mBezierView.getParachuteRightPath(), false);
        Log.d(TAG, "getParachuteRightPath" + pathMeasure.getLength());
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

    public void startHeartAnim() {
        this.mFireworksAnimDrawable = (AnimationDrawable)mFireworks.getDrawable();
        this.mHeartAnimSet.play(this.mHeartBScaleX).with(this.mHeartBScaleY).with(this.mHeartCRotation).with(this.mHeartDRotation).with(this.mHeartDScaleX).with(this.mHeartDScaleY);
        this.mHeartAnimSet.play(this.mHeartAScaleY).with(this.mHeartAScaleX).after(this.mHeartBScaleX);
        this.mHeartAnimSet.setStartDelay(4000L);
        this.mHeartAnimSet.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gift_travel_world;
    }

    public void startFireworkAnim() {
        this.mFireworksAnimSet.play(this.mFireworksScaleY).with(this.mFireworksScaleX).with(this.mFireworksTransX).with(this.mFireworksRotation).with(this.mLoveTextScaleX).with(this.mLoveTextScaleY);
        this.mFireworksAnimSet.play(this.mHeartCScaleX1).with(this.mHeartCScaleY1).with(this.mHeartDScaleX1).with(this.mHeartDScaleY1).after(this.mFireworksScaleX);
        this.mFireworksAnimSet.start();
    }

    public void stop() {
        this.isDisplaying = false;
        m();
        recycle();
    }

    @Override
    public void onAnimationCancel(Animator animator) {}

    @Override
    public void onAnimationEnd(Animator animator) {
        if (animator.equals(this.mBuildGTransX)) {
            this.mBuildG.setVisibility(VISIBLE);
        }
        if ((animator.equals(this.mFireworksScaleX)) && (this.mFireworksAnimDrawable != null)) {
            this.mFireworks.setVisibility(VISIBLE);
            this.mFireworksAnimDrawable.start();
        }
        if (animator.equals(this.mFireBalloonScaleX1)) {
            this.mFireBalloonScaleX2.start();
            this.mFireBalloonScaleY2.start();
        }
        if (animator.equals(this.mHeartCScaleX1)) {
            this.mRootAlpha.start();
        }
        if (animator.equals(this.mPlaneViewRotation2)) {
            this.mPlaneView.setVisibility(INVISIBLE);
        }
        if (animator.equals(this.mRootAlpha)) {
            this.mEarthView.setVisibility(INVISIBLE);
            recycle();
        }
    }

    @Override
    public void onAnimationRepeat(Animator animator) {}

    @Override
    public void onAnimationStart(Animator animator) {
        if (animator.equals(mEarthViewTransY)) {
            mEarthView.setVisibility(VISIBLE);
        }
        if (animator.equals(mEarthLightTransY)) {
            mEarthLight.setVisibility(VISIBLE);
        }
        if (animator.equals(mBuildFirstTransX)) {
            Log.d(TAG, "onAnimationStartearthBeginRotation" + System.currentTimeMillis());
            this.mBuildFirst.setVisibility(VISIBLE);
        }
        if (animator.equals(mBuildATransX)) {
            Log.d(TAG, "onAnimationStart-buildAX" + System.currentTimeMillis());
            this.mBuildA.setVisibility(VISIBLE);
        }
        if (animator.equals(mBuildBTransX)) {
            Log.d(TAG, "onAnimationStart-buildBX" + System.currentTimeMillis());
            this.mBuildB.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mBuildCTransX)) {
            Log.d(TAG, "onAnimationStart-buildCX" + System.currentTimeMillis());
            this.mBuildC.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mBuildDTransX)) {
            Log.d(TAG, "onAnimationStart-buildDX" + System.currentTimeMillis());
            this.mBuildD.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mBuildETransX)) {
            Log.d(TAG, "onAnimationStart-buildEX" + System.currentTimeMillis());
            this.mBuildE.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mBuildFTransX)) {
            Log.d(TAG, "onAnimationStart-buildFX" + System.currentTimeMillis());
            this.mBuildF.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mBuildITransX)) {
            Log.d(TAG, "onAnimationStart-buildIX" + System.currentTimeMillis());
            this.mBuildI.setVisibility(VISIBLE);
            startFireBalloonAnim();
        }
        if (animator.equals(this.mBuildGTransX)) {
            Log.d(TAG, "onAnimationStart-buildGX" + System.currentTimeMillis());
        }
        if (animator.equals(this.mBuildHTransX)) {
            Log.d(TAG, "onAnimationStart-buildHX" + System.currentTimeMillis());
            this.mBuildH.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mPlaneViewRotation2)) {
            Log.d(TAG, "onAnimationStart-planeRotation" + System.currentTimeMillis());
            this.mPlaneView.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mPlaneViewRotation)) {
            this.mPlaneView.setVisibility(INVISIBLE);
        }
        if (animator.equals(this.mFireBalloonScaleX2)) {
            Log.d(TAG, "onAnimationStart-fireballoonSecondScaleX" + System.currentTimeMillis());
            if (this.mPlaneViewRotation2 != null) {
                this.mPlaneViewRotation2.cancel();
                this.mPlaneViewRotation2.setStartDelay(1000L);
                this.mPlaneViewAnimSet.play(this.mPlaneViewRotation);
                this.mPlaneViewAnimSet.play(this.mPlaneViewRotation2).after(this.mPlaneViewRotation);
                this.mPlaneViewAnimSet.start();
            }
        }
        if (animator.equals(this.mParachuteLeftRotation)) {
            Log.d(TAG, "onAnimationStart-parachuteLeftRotation" + System.currentTimeMillis());
        }
        if (animator.equals(this.mParachuteBackgroundAlpha)) {
            Log.d(TAG, "onAnimationStart-parachuteBackgroundStart" + System.currentTimeMillis());
            this.mParachuteBackground.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mHeartBScaleX)) {
            Log.d(TAG, "onAnimationStart-heartBResetX" + System.currentTimeMillis());
        }
        if (this.mFireworksAnimDrawable != null && mFireworksAnimDrawable.isRunning()) {
            this.mFireworksAnimDrawable.stop();
            this.mFireworks.setVisibility(VISIBLE);
            this.mFireworksAnimDrawable.start();
        }

        if (animator.equals(this.mHeartAScaleX)) {
            this.mFireworks.setVisibility(INVISIBLE);
            this.mHeartA.setVisibility(VISIBLE);
            if (this.mFireworksAnimDrawable != null) {
                this.mFireworksAnimDrawable.stop();
            }
            startFireworkAnim();
            this.mHeartBScaleX1.start();
            this.mHeartBScaleY1.start();
            this.mLoveTextScaleX1.start();
            this.mLoveTextScaleY1.start();
        }
        if (animator.equals(this.mHeartBScaleX1)) {
            this.mHeartB.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mHeartCScaleX1)) {
            this.mFireworks.setVisibility(INVISIBLE);
            if (this.mFireworksAnimDrawable != null) {
                this.mFireworksAnimDrawable.stop();
            }
            this.mHeartC.setVisibility(VISIBLE);
            this.mHeartD.setVisibility(VISIBLE);
        }
        if (animator.equals(this.mLoveTextScaleX1)) {
            this.mLoveText.setVisibility(VISIBLE);
        }

    }

}

