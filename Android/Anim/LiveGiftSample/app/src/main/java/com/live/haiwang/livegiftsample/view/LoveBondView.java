package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiwang on 2017/7/14.
 */

public class LoveBondView  extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private ImageView mEmitterView;
    private ImageView mTreeView;
    private ImageView mHeartView1;
    private ImageView mHeartView2;
    private ImageView mHeartView3;
    private ImageView mHeartView4;
    private ImageView mHeartView5;
    private BubbleView mBubbleView1;
//    private BubbleView mBubbleView2;
    private RelativeLayout mHeartContainer;
    private ObjectAnimator mEmitterTrans1;
    private ObjectAnimator mEmitterTrans2;
//    private ObjectAnimator mEmitterTrans3;
    private ObjectAnimator mShapeHeart1Anim;
    private ObjectAnimator mShapeHeart2Anim;
    private ObjectAnimator mShapeHeart3Anim;
    private ObjectAnimator mShapeHeart4Anim;
    private ObjectAnimator mShapeHeart5Anim;
    private ObjectAnimator mTreeDisapAnim;
    private AnimatorSet mHeartBeatAnim;
    private AnimatorSet mHeartTrans;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public LoveBondView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mEmitterTrans1 = ObjectAnimator.ofFloat(mEmitterView, TRANSLATION_X, -ScreenUtil.b(getContext(), 100), 0);
        mEmitterTrans1.setDuration(1000L);

        mEmitterTrans2 = ObjectAnimator.ofFloat(mEmitterView, TRANSLATION_X, 0, ScreenUtil.a(getContext()) + ScreenUtil.b(getContext(), 100));
        mEmitterTrans2.setDuration(1500L);
        mEmitterTrans2.setStartDelay(6500L);
//        mEmitterTrans3 = ObjectAnimator.ofFloat(mEmitterView, TRANSLATION_X, ScreenUtil.b(getContext(), 125), ScreenUtil.a(getContext()) + ScreenUtil.b(getContext(), 100));
//        mEmitterTrans3.setDuration(1000L);
//        mEmitterTrans3.setStartDelay(4500L);
        mShapeHeart1Anim = ObjectAnimator.ofFloat(mHeartView1, ALPHA, 0F, 1F);
        mShapeHeart1Anim.setDuration(1000L);
        mShapeHeart2Anim = ObjectAnimator.ofFloat(mHeartView2, ALPHA, 0F, 1F);
        mShapeHeart2Anim.setDuration(1000L);
        mShapeHeart3Anim = ObjectAnimator.ofFloat(mHeartView3, ALPHA, 0F, 1F);
        mShapeHeart3Anim.setDuration(1000L);
        mShapeHeart4Anim = ObjectAnimator.ofFloat(mHeartView4, ALPHA, 0F, 1F);
        mShapeHeart4Anim.setDuration(1000L);
        mShapeHeart5Anim = ObjectAnimator.ofFloat(mHeartView5, ALPHA, 0F, 1F);
        mShapeHeart5Anim.setDuration(1000L);

        ObjectAnimator heartTransX = ObjectAnimator.ofFloat(mHeartContainer, TRANSLATION_X, 0, ScreenUtil.a(getContext()));
        heartTransX.setDuration(5000L);
        ObjectAnimator heartTransY = ObjectAnimator.ofFloat(mHeartContainer, TRANSLATION_Y, 0, -ScreenUtil.b(getContext(), 200));
        heartTransY.setDuration(5000L);
        ObjectAnimator heartScaleX = ObjectAnimator.ofFloat(mHeartContainer, SCALE_X, 1.0F, 1.4F);
        heartScaleX.setDuration(3000L);
        ObjectAnimator heartScaleY = ObjectAnimator.ofFloat(mHeartContainer, SCALE_Y, 1.0F, 1.4F);
        heartScaleY.setDuration(3000L);
        mHeartTrans = new AnimatorSet();
        mHeartTrans.play(heartTransX).with(heartTransY).with(heartScaleX).with(heartScaleY);

        mTreeDisapAnim = ObjectAnimator.ofFloat(mTreeView, ALPHA, 1F, 0F);
        mTreeDisapAnim.setDuration(1000L);
        ObjectAnimator heartBeatX = ObjectAnimator.ofFloat(mHeartContainer, SCALE_X, 1.0F, 1.4F);
        heartBeatX.setDuration(500L);
        heartBeatX.setInterpolator(new AccelerateInterpolator());
        heartBeatX.setRepeatMode(ValueAnimator.REVERSE);
        heartBeatX.setRepeatCount(3);
        ObjectAnimator heartBeatY = ObjectAnimator.ofFloat(mHeartContainer, SCALE_Y, 1.0F, 1.4F);
        heartBeatY.setDuration(500L);
        heartBeatY.setRepeatMode(ValueAnimator.REVERSE);
        heartBeatY.setInterpolator(new AccelerateInterpolator());
        heartBeatY.setRepeatCount(3);
        mHeartBeatAnim = new AnimatorSet();
        mHeartBeatAnim.play(heartBeatX).with(heartBeatY);
        mShapeHeart1Anim.addListener(this);
        mShapeHeart2Anim.addListener(this);
        mShapeHeart3Anim.addListener(this);
        mShapeHeart4Anim.addListener(this);
        mShapeHeart5Anim.addListener(this);
        mEmitterTrans1.addListener(this);
        mEmitterTrans2.addListener(this);
//        mEmitterTrans3.addListener(this);
        mHeartBeatAnim.addListener(this);
        if(mListener != null)mListener.a();
    }

    @Override
    protected void a() {
        mEmitterView = (ImageView) findViewById(R.id.iv_heart_emitter);
        mBubbleView1 = (BubbleView) findViewById(R.id.bubble_view1);
//        mBubbleView2 = (BubbleView) findViewById(R.id.bubble_view2);
        mHeartContainer = (RelativeLayout) findViewById(R.id.rl_heart_container);
        mTreeView = (ImageView) findViewById(R.id.iv_tree);
        mHeartView1 = (ImageView) findViewById(R.id.iv_shape_heart1);
        mHeartView2 = (ImageView) findViewById(R.id.iv_shape_heart2);
        mHeartView3 = (ImageView) findViewById(R.id.iv_shape_heart3);
        mHeartView4 = (ImageView) findViewById(R.id.iv_shape_heart4);
        mHeartView5 = (ImageView) findViewById(R.id.iv_shape_heart5);
        List<Drawable> list = new ArrayList<>();
        list.add(ContextCompat.getDrawable(getContext(), R.mipmap.bubble_heart));
        mBubbleView1.setDrawableList(list);
//        mBubbleView2.setDrawableList(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.love_bond_view;
    }


    public void start() {
        isDisplaying = true;
        mEmitterView.setVisibility(VISIBLE);
        mEmitterTrans1.start();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mHeartView1.setVisibility(VISIBLE);
                mShapeHeart1Anim.start();
            }
        },2000L);
    }

    public void stop() {
        isDisplaying = false;
        if (mEmitterTrans1 != null) {
            mEmitterTrans1.removeAllListeners();
            mEmitterTrans1.cancel();
            mEmitterTrans1 = null;
        }
        if (mEmitterTrans2 != null) {
            mEmitterTrans2.removeAllListeners();
            mEmitterTrans2.cancel();
            mEmitterTrans2 = null;
        }
//        if (mEmitterTrans3 != null) {
//            mEmitterTrans3.removeAllListeners();
//            mEmitterTrans3.cancel();
//            mEmitterTrans3 = null;
//        }
        if (mShapeHeart1Anim != null) {
            mShapeHeart1Anim.removeAllListeners();
            mShapeHeart1Anim.cancel();
            mShapeHeart1Anim = null;
        }
        if (mShapeHeart2Anim != null) {
            mShapeHeart2Anim.removeAllListeners();
            mShapeHeart2Anim.cancel();
            mShapeHeart2Anim = null;
        }
        if (mShapeHeart3Anim != null) {
            mShapeHeart3Anim.removeAllListeners();
            mShapeHeart3Anim.cancel();
            mShapeHeart3Anim = null;
        }
        if (mShapeHeart4Anim != null) {
            mShapeHeart4Anim.removeAllListeners();
            mShapeHeart4Anim.cancel();
            mShapeHeart4Anim = null;
        }
        if (mShapeHeart5Anim != null) {
            mShapeHeart5Anim.removeAllListeners();
            mShapeHeart5Anim.cancel();
            mShapeHeart5Anim = null;
        }
        if (mHeartTrans != null) {
            mHeartTrans.removeAllListeners();
            mHeartTrans.cancel();
            mHeartTrans = null;
        }
        if (mHeartBeatAnim != null) {
            mHeartBeatAnim.removeAllListeners();
            mHeartBeatAnim.cancel();
            mHeartBeatAnim = null;
        }
        if (mTreeDisapAnim != null) {
            mTreeDisapAnim.removeAllListeners();
            mTreeDisapAnim.cancel();
            mTreeDisapAnim = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying)return;
        if(animation.equals(mEmitterTrans1)){
            mBubbleView1.startAnimation(mBubbleView1.getWidth(), mBubbleView1.getHeight());
            mEmitterTrans2.start();
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    stop();
                }
            }, 11000L);
        }
//        if(animation.equals(mEmitterTrans2)){
//            mBubbleView2.startAnimation(mBubbleView2.getWidth(), mBubbleView2.getHeight());
//            mEmitterTrans3.start();
//            postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    stop();
//                }
//            }, 6000L);
//        }
        if(animation.equals(mShapeHeart1Anim)){
            mHeartView2.setVisibility(VISIBLE);
            mShapeHeart2Anim.start();
        }
        if(animation.equals(mShapeHeart2Anim)){
            mHeartView3.setVisibility(VISIBLE);
            mShapeHeart3Anim.start();
        }
        if(animation.equals(mShapeHeart3Anim)){
            mHeartView4.setVisibility(VISIBLE);
            mShapeHeart4Anim.start();
        }
        if(animation.equals(mShapeHeart4Anim)){
            mHeartView5.setVisibility(VISIBLE);
            mShapeHeart5Anim.start();
        }
        if(animation.equals(mShapeHeart5Anim)){
            mHeartBeatAnim.start();
            mHeartView1.setVisibility(GONE);
            mHeartView2.setVisibility(GONE);
            mHeartView3.setVisibility(GONE);
            mHeartView4.setVisibility(GONE);
        }
        if(animation.equals(mHeartBeatAnim)){
            mHeartTrans.start();
            mTreeDisapAnim.start();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
