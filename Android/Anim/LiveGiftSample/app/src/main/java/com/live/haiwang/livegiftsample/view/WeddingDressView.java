package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/7/7.
 */

public class WeddingDressView extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private RelativeLayout mRootView;
    private RelativeLayout mWeddingDressContainer;
    private ImageView mWeddingDressView;
    private ImageView mHeadWearView;
    private ImageView mFlyingPetalsView1;
    private ImageView mFlyingPetalsView2;
    private ImageView mFlowerCarpetView1;
    private ImageView mFlowerCarpetView2;
    private ImageView mFlowerCarpetView3;
    private ImageView mFlowerCarpetView4;
    private ObjectAnimator mFlowerCarpet1Anim;
    private ObjectAnimator mFlowerCarpet2Anim;
    private ObjectAnimator mFlowerCarpet3Anim;
    private ObjectAnimator mFlowerCarpet4Anim;
    private ObjectAnimator mBgAnim;
    private AnimatorSet mWeddingDressAnim;
    private AnimatorSet mWeddingDressMaskAnim;
    private AnimatorSet mFlying1Anim;
    private AnimatorSet mFlying2Anim;
    private AnimatorSet mHeadWearAnim;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public WeddingDressView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mBgAnim = ObjectAnimator.ofFloat(mRootView, ALPHA, 0F, 1F);
        mBgAnim.setDuration(1500L);
        ObjectAnimator girlTransX1 = ObjectAnimator.ofFloat(mWeddingDressContainer, TRANSLATION_X, ScreenUtil.b(getContext(), 300), 0);
        girlTransX1.setDuration(5000L);
        ObjectAnimator girlTransY1 = ObjectAnimator.ofFloat(mWeddingDressContainer, TRANSLATION_Y, ScreenUtil.b(getContext(), 180), 0);
        girlTransY1.setDuration(5000L);
        mWeddingDressAnim = new AnimatorSet();
        mWeddingDressAnim.play(girlTransX1).with(girlTransY1);
//        ObjectAnimator headWearScaleX = ObjectAnimator.ofFloat(mHeadWearView, SCALE_X, 1F, 2.0F);
//        headWearScaleX.setDuration(3000L);
//        headWearScaleX.setRepeatCount(ValueAnimator.INFINITE);
//        headWearScaleX.setRepeatMode(ValueAnimator.REVERSE);
//        ObjectAnimator headWearScaleY = ObjectAnimator.ofFloat(mHeadWearView, SCALE_Y, 1F, 2.5F);
//        headWearScaleY.setDuration(3000L);
//        headWearScaleY.setRepeatCount(ValueAnimator.INFINITE);
//        headWearScaleY.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator headWearRotation = ObjectAnimator.ofFloat(mHeadWearView, ROTATION, 2F, 18F);
        headWearRotation.setDuration(3000L);
        headWearRotation.setRepeatCount(ValueAnimator.INFINITE);
        headWearRotation.setRepeatMode(ValueAnimator.REVERSE);
        mHeadWearView.setPivotX(ScreenUtil.b(getContext(), 30));
        mHeadWearView.setPivotY(0);
        mHeadWearAnim = new AnimatorSet();
        mHeadWearAnim.play(headWearRotation);//(headWearScaleX).with(headWearScaleY).with
        ObjectAnimator weddingDressScaleX = ObjectAnimator.ofFloat(mWeddingDressView, SCALE_X, 1F, 1.2F);
        weddingDressScaleX.setDuration(1000L);
        weddingDressScaleX.setRepeatCount(ValueAnimator.INFINITE);
        weddingDressScaleX.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator weddingDressScaleY = ObjectAnimator.ofFloat(mWeddingDressView, SCALE_Y, 1F, 1.2F);
        weddingDressScaleY.setDuration(1000L);
        weddingDressScaleY.setRepeatCount(ValueAnimator.INFINITE);
        weddingDressScaleY.setRepeatMode(ValueAnimator.REVERSE);
        mWeddingDressView.setPivotX(0);
        mWeddingDressView.setPivotY(0);
        mWeddingDressMaskAnim = new AnimatorSet();
        mWeddingDressMaskAnim.play(weddingDressScaleX).with(weddingDressScaleY);
        ObjectAnimator petalsX1 = ObjectAnimator.ofFloat(mFlyingPetalsView1, TRANSLATION_X, -ScreenUtil.b(getContext(), 180), ScreenUtil.a(getContext()));
        petalsX1.setDuration(8000L);
        petalsX1.setRepeatCount(ValueAnimator.INFINITE);
        petalsX1.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsY1 = ObjectAnimator.ofFloat(mFlyingPetalsView1, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 300));
        petalsY1.setDuration(8000L);
        petalsY1.setRepeatCount(ValueAnimator.INFINITE);
        petalsY1.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsScaleX1 = ObjectAnimator.ofFloat(mFlyingPetalsView1, SCALE_X, 1F, 2.0F);
        petalsScaleX1.setDuration(8000L);
        petalsScaleX1.setRepeatCount(ValueAnimator.INFINITE);
        petalsScaleX1.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsScaleY1 = ObjectAnimator.ofFloat(mFlyingPetalsView1, SCALE_Y, 1F, 2.0F);
        petalsScaleY1.setDuration(8000L);
        petalsScaleY1.setRepeatCount(ValueAnimator.INFINITE);
        petalsScaleY1.setRepeatMode(ValueAnimator.RESTART);
        mFlying1Anim = new AnimatorSet();
        mFlying1Anim.play(petalsX1).with(petalsY1).with(petalsScaleX1).with(petalsScaleY1);
        ObjectAnimator petalsX2 = ObjectAnimator.ofFloat(mFlyingPetalsView2, TRANSLATION_X, -ScreenUtil.b(getContext(), 180), ScreenUtil.a(getContext()));
        petalsX2.setDuration(8000L);
        petalsX2.setRepeatCount(ValueAnimator.INFINITE);
        petalsX2.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsY2 = ObjectAnimator.ofFloat(mFlyingPetalsView2, TRANSLATION_Y, 0F, ScreenUtil.b(getContext(), 300));
        petalsY2.setDuration(8000L);
        petalsY2.setRepeatCount(ValueAnimator.INFINITE);
        petalsY2.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsScaleX2 = ObjectAnimator.ofFloat(mFlyingPetalsView2, SCALE_X, 1F, 2.0F);
        petalsScaleX2.setDuration(8000L);
        petalsScaleX2.setRepeatCount(ValueAnimator.INFINITE);
        petalsScaleX2.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator petalsScaleY2 = ObjectAnimator.ofFloat(mFlyingPetalsView2, SCALE_Y, 1F, 2.0F);
        petalsScaleY2.setDuration(8000L);
        petalsScaleY2.setRepeatCount(ValueAnimator.INFINITE);
        petalsScaleY2.setRepeatMode(ValueAnimator.RESTART);
        mFlying2Anim = new AnimatorSet();
        mFlying2Anim.play(petalsX2).with(petalsY2).with(petalsScaleX2).with(petalsScaleY2);
//        mFlying2Anim.setStartDelay(3000L);
        mFlowerCarpet1Anim = ObjectAnimator.ofFloat(mFlowerCarpetView1, ALPHA, 0F, 1F);
        mFlowerCarpet1Anim.setDuration(1000L);
        mFlowerCarpet2Anim = ObjectAnimator.ofFloat(mFlowerCarpetView2, ALPHA, 0F, 1F);
        mFlowerCarpet2Anim.setDuration(1000L);
        mFlowerCarpet3Anim = ObjectAnimator.ofFloat(mFlowerCarpetView3, ALPHA, 0F, 1F);
        mFlowerCarpet3Anim.setDuration(1000L);
        mFlowerCarpet4Anim = ObjectAnimator.ofFloat(mFlowerCarpetView4, ALPHA, 0F, 1F);
        mFlowerCarpet4Anim.setDuration(1000L);
        mFlowerCarpet1Anim.addListener(this);
        mFlowerCarpet2Anim.addListener(this);
        mFlowerCarpet3Anim.addListener(this);
        mFlowerCarpet4Anim.addListener(this);
        mBgAnim.addListener(this);
        if(mListener != null)mListener.a();
    }

    public void start() {
        isDisplaying = true;
        mBgAnim.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 10000L);
        mFlyingPetalsView1.setVisibility(VISIBLE);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mFlyingPetalsView2.setVisibility(VISIBLE);
                mFlying2Anim.start();
            }
        }, 3000L);
        mFlying1Anim.start();
    }

    public void stop() {
        this.isDisplaying = false;
        if (mBgAnim != null) {
            mBgAnim.removeAllListeners();
            mBgAnim.cancel();
            mBgAnim = null;
        }
        if (mWeddingDressAnim != null) {
            mWeddingDressAnim.removeAllListeners();
            mWeddingDressAnim.cancel();
            mWeddingDressAnim = null;
        }
        if (mWeddingDressMaskAnim != null) {
            mWeddingDressMaskAnim.removeAllListeners();
            mWeddingDressMaskAnim.cancel();
            mWeddingDressMaskAnim = null;
        }
        if (mHeadWearAnim != null) {
            mHeadWearAnim.removeAllListeners();
            mHeadWearAnim.cancel();
            mHeadWearAnim = null;
        }
        if (mFlying1Anim != null) {
            mFlying1Anim.removeAllListeners();
            mFlying1Anim.cancel();
            mFlying1Anim = null;
        }
        if (mFlying2Anim != null) {
            mFlying2Anim.removeAllListeners();
            mFlying2Anim.cancel();
            mFlying2Anim = null;
        }
        if (mFlowerCarpet1Anim != null) {
            mFlowerCarpet1Anim.removeAllListeners();
            mFlowerCarpet1Anim.cancel();
            mFlowerCarpet1Anim = null;
        }
        if (mFlowerCarpet2Anim != null) {
            mFlowerCarpet2Anim.removeAllListeners();
            mFlowerCarpet2Anim.cancel();
            mFlowerCarpet2Anim = null;
        }
        if (mFlowerCarpet3Anim != null) {
            mFlowerCarpet3Anim.removeAllListeners();
            mFlowerCarpet3Anim.cancel();
            mFlowerCarpet3Anim = null;
        }
        if (mFlowerCarpet4Anim != null) {
            mFlowerCarpet4Anim.removeAllListeners();
            mFlowerCarpet4Anim.cancel();
            mFlowerCarpet4Anim = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying)return;
        if(animation.equals(mBgAnim)){
            mWeddingDressContainer.setVisibility(VISIBLE);
            mFlowerCarpetView1.setVisibility(VISIBLE);
            mFlowerCarpet1Anim.start();
            mWeddingDressAnim.start();
            mHeadWearAnim.start();
        }
        if(animation.equals(mFlowerCarpet1Anim)){
            mFlowerCarpetView2.setVisibility(VISIBLE);
            mFlowerCarpet2Anim.start();
        }
        if(animation.equals(mFlowerCarpet2Anim)){
            mFlowerCarpetView3.setVisibility(VISIBLE);
            mFlowerCarpet3Anim.start();
            mFlowerCarpetView1.setVisibility(GONE);
        }
        if(animation.equals(mFlowerCarpet3Anim)){
            mFlowerCarpetView4.setVisibility(VISIBLE);
            mFlowerCarpet4Anim.start();
            mFlowerCarpetView2.setVisibility(GONE);
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    protected void a() {
        mRootView = (RelativeLayout) findViewById(R.id.rl_wedding_bg);
        mWeddingDressContainer = (RelativeLayout) findViewById(R.id.rl_wedding_dress_container);
        mWeddingDressView = (ImageView) findViewById(R.id.iv_wedding_dress);
        mHeadWearView = (ImageView) findViewById(R.id.iv_head_wear);
        mFlyingPetalsView1 = (ImageView) findViewById(R.id.iv_flaying_petals1);
        mFlyingPetalsView2 = (ImageView) findViewById(R.id.iv_flaying_petals2);
        mFlowerCarpetView1 = (ImageView) findViewById(R.id.iv_flower_carpet1);
        mFlowerCarpetView2 = (ImageView) findViewById(R.id.iv_flower_carpet2);
        mFlowerCarpetView3 = (ImageView) findViewById(R.id.iv_flower_carpet3);
        mFlowerCarpetView4 = (ImageView) findViewById(R.id.iv_flower_carpet4);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.wedding_dress_view;
    }

}
