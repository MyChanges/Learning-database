package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/8/14.
 */

public class WorldTourView extends CustomBaseViewRelative implements Animator.AnimatorListener, Animation.AnimationListener{

    private ImageView mEarthView;
    private ImageView mWalkingGirlView;
    private ImageView mBuildingView;
    private ImageView mFlyingView;
    private ImageView mLeftSunflowerView;
    private ImageView mRightSunflowerView;
    private ImageView mLeftFirworkView;
    private ImageView mRightFirworkView;
    private ImageView mMidFirworkView;
    private LinearLayout mRocketContainer;
    private FallingEffectView mFallingView;
    private ObjectAnimator mEarthViewScaleX;
    private ObjectAnimator mEarthViewScaleY;
    private ObjectAnimator mEarthViewTransY;
    private ObjectAnimator mEarthViewRotation;

    private int[] buildingResIds = {R.mipmap.wt_forest, R.mipmap.wt_egypt,  R.mipmap.wt_vassily_rose_cathedral, R.mipmap.wt_taj_mahal,
                                    R.mipmap.wt_eifel_tower, R.mipmap.wt_big_ben, R.mipmap.wt_jesus_statue, R.mipmap.wt_fujiyama,
                                    R.mipmap.wt_liberty_statue, R.mipmap.wt_sydney_opera_house, R.mipmap.wt_tiananmen};
    private int mCurBuilding;
    private GiftDisplayListener mGiftDisplayListener;
    private AnimatorSet mCombinedAnimSet;
    private AnimationSet mBuildingAppearAnim;
    private AnimatorSet mRocketAnimSet;
    private AnimatorSet mFireworkAnimSet;
    private boolean isDisplaying = false;

    public WorldTourView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        createAnimation();
    }

    public WorldTourView(Context paramContext, GiftDisplayListener listener) {
        super(paramContext);
        this.mGiftDisplayListener = listener;
        createAnimation();
    }

    public void start() {
        if (isDisplaying) {
            return;
        }
        isDisplaying = true;
        mCombinedAnimSet.play(mEarthViewScaleX).with(mEarthViewScaleY).before(mEarthViewTransY);
        mCombinedAnimSet.play(mEarthViewRotation).after(mEarthViewTransY);
        mCombinedAnimSet.start();
    }

    private void createAnimation(){
        mEarthViewScaleX = ObjectAnimator.ofFloat(mEarthView, SCALE_X, 1.0F, 2.5F);
        mEarthViewScaleX.setDuration(100L);
        mEarthViewScaleY = ObjectAnimator.ofFloat(mEarthView, SCALE_Y, 1.0F, 2.5F);
        mEarthViewScaleY.setDuration(100L);
        mEarthViewTransY = ObjectAnimator.ofFloat(mEarthView, TRANSLATION_Y, ScreenUtil.a(getContext()), ScreenUtil.a(getContext()) * 7 / 12);
        mEarthViewTransY.setInterpolator(new LinearInterpolator());
        mEarthViewTransY.setDuration(700L);
        mEarthViewRotation = ObjectAnimator.ofFloat(mEarthView, ROTATION, 0.0F, 360.0F);
        mEarthViewRotation.setInterpolator(new LinearInterpolator());
        mEarthViewRotation.setRepeatMode(ValueAnimator.RESTART);
        mEarthViewRotation.setRepeatCount(ValueAnimator.INFINITE);
        mEarthViewRotation.setDuration(20000L);
        mEarthViewTransY.addListener(this);
        mCombinedAnimSet = new AnimatorSet();
    }

    private void createBuildingAnim(float fromY, float toY){
        if(mBuildingAppearAnim != null){
            mBuildingAppearAnim.cancel();
            mBuildingAppearAnim = null;
        }
        mBuildingAppearAnim = adaptBuildingAnim(fromY, toY);
        RotateAnimation rotateAnimation = new RotateAnimation(0, -55, Animation.ABSOLUTE, ScreenUtil.a(getContext()) / 2, Animation.ABSOLUTE, ScreenUtil.b(getContext()) - ScreenUtil.b(getContext(), 88));
        rotateAnimation.setDuration(500L);
        rotateAnimation.setStartOffset(1500L);
        mBuildingAppearAnim.addAnimation(rotateAnimation);
//        mBuildingAppearAnim.setAnimationListener(this);
        rotateAnimation.setAnimationListener(this);
    }

    private AnimationSet adaptBuildingAnim(float fromY, float toY){
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translate = new TranslateAnimation(0.0F, 0.0F, fromY, toY);
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

        animationSet.addAnimation(translate);
        animationSet.addAnimation(scale1);
        animationSet.addAnimation(scale2);
        return animationSet;
    }

    private AnimationSet createRiseAnimation(){
        return adaptBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3);
    }

    private void createFireworkAnim(){
        ObjectAnimator firework1ScaleX = ObjectAnimator.ofFloat(mLeftFirworkView, SCALE_X, 0F, 0.8F);
        firework1ScaleX.setDuration(800L);
        firework1ScaleX.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator firework1ScaleY = ObjectAnimator.ofFloat(mLeftFirworkView, SCALE_Y, 0F, 0.8F);
        firework1ScaleY.setDuration(800L);
        firework1ScaleY.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator firework1Alpha = ObjectAnimator.ofFloat(mLeftFirworkView, ALPHA, 1F, 0F);
        firework1Alpha.setDuration(1000L);
        ObjectAnimator firework2ScaleX = ObjectAnimator.ofFloat(mRightFirworkView, SCALE_X, 0F, 1.0F);
        firework2ScaleX.setDuration(800L);
        firework2ScaleX.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator firework2ScaleY = ObjectAnimator.ofFloat(mRightFirworkView, SCALE_Y, 0F, 1.0F);
        firework2ScaleY.setDuration(800L);
        firework2ScaleY.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator firework2Alpha = ObjectAnimator.ofFloat(mRightFirworkView, ALPHA, 1F, 0F);
        firework2Alpha.setDuration(1000L);
        final ObjectAnimator firework3ScaleX = ObjectAnimator.ofFloat(mMidFirworkView, SCALE_X, 0F, 1.0F);
        firework3ScaleX.setDuration(800L);
        firework3ScaleX.setInterpolator(new AccelerateInterpolator());
        final ObjectAnimator firework3ScaleY = ObjectAnimator.ofFloat(mMidFirworkView, SCALE_Y, 0F, 1.0F);
        firework3ScaleY.setDuration(800L);
        firework3ScaleY.setInterpolator(new AccelerateInterpolator());
        final ObjectAnimator firework3Alpha = ObjectAnimator.ofFloat(mMidFirworkView, ALPHA, 1F, 0F);
        firework3Alpha.setDuration(1000L);
        AnimatorSet fireAnimSet = new AnimatorSet();
        fireAnimSet.play(firework1ScaleX).with(firework1ScaleY).with(firework2ScaleX).with(firework2ScaleY).before(firework1Alpha);
        fireAnimSet.play(firework1Alpha).with(firework2Alpha);
        fireAnimSet.start();
        mLeftFirworkView.setVisibility(VISIBLE);
        mRightFirworkView.setVisibility(VISIBLE);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mFireworkAnimSet = new AnimatorSet();
                mFireworkAnimSet.play(firework3ScaleX).with(firework3ScaleY).before(firework3Alpha);
                mFireworkAnimSet.addListener(WorldTourView.this);
                mFireworkAnimSet.start();
                mMidFirworkView.setVisibility(VISIBLE);
            }
        }, 500L);
    }

    public void stop() {
        this.isDisplaying = false;
        if (mEarthViewScaleX != null) {
            mEarthViewScaleX.removeAllListeners();
            mEarthViewScaleX.cancel();
            mEarthViewScaleX = null;
        }
        if (mEarthViewScaleY != null) {
            mEarthViewScaleY.removeAllListeners();
            mEarthViewScaleY.cancel();
            mEarthViewScaleY = null;
        }
        if (mEarthViewTransY != null) {
            mEarthViewTransY.removeAllListeners();
            mEarthViewTransY.cancel();
            mEarthViewTransY = null;
        }
        if (mEarthViewRotation != null) {
            mEarthViewRotation.removeAllListeners();
            mEarthViewRotation.cancel();
            mEarthViewRotation = null;
        }
        if (mBuildingAppearAnim != null) {
            mBuildingAppearAnim.cancel();
            mBuildingAppearAnim = null;
        }
        if (mCombinedAnimSet != null) {
            mCombinedAnimSet.removeAllListeners();
            mCombinedAnimSet.cancel();
            mCombinedAnimSet = null;
        }
        if (mRocketAnimSet != null) {
            mRocketAnimSet.removeAllListeners();
            mRocketAnimSet.cancel();
            mRocketAnimSet = null;
        }
        if (mFireworkAnimSet != null) {
            mFireworkAnimSet.removeAllListeners();
            mFireworkAnimSet.cancel();
            mFireworkAnimSet = null;
        }
        if(mGiftDisplayListener != null) mGiftDisplayListener.b();
    }

    private void startFlying(){
        AnimatorSet as = new AnimatorSet();
        if(mCurBuilding == 5){
            ObjectAnimator ax = ObjectAnimator.ofFloat(mFlyingView, TRANSLATION_X, mFlyingView.getWidth(), -ScreenUtil.b(getContext(), 400));
            ax.setDuration(2000L);
            ObjectAnimator ay = ObjectAnimator.ofFloat(mFlyingView, TRANSLATION_Y, mFlyingView.getHeight() * 2.2F, mFlyingView.getHeight());
            ay.setDuration(2000L);
            as.play(ax).with(ay);
        }else if(mCurBuilding == 6){
            mFlyingView.setImageResource(R.mipmap.wt_falling_leaves);
            ObjectAnimator ax = ObjectAnimator.ofFloat(mFlyingView, TRANSLATION_X, 0, -mFlyingView.getWidth() / 2);
            ax.setDuration(2000L);
            ObjectAnimator ay = ObjectAnimator.ofFloat(mFlyingView, TRANSLATION_Y, -mFlyingView.getHeight() * 1.5F, mFlyingView.getHeight() * 3F);
            ay.setDuration(2000L);
            as.play(ax).with(ay);
        }else if(mCurBuilding == 8){
            mFlyingView.setImageResource(R.mipmap.wt_ufo);
            ObjectAnimator ax = ObjectAnimator.ofFloat(mFlyingView, ROTATION, -15, 15);
            mFlyingView.setPivotX(0);
            mFallingView.setPivotY(0);
            ax.setDuration(1000L);
            ax.setRepeatMode(ValueAnimator.REVERSE);
            ax.setRepeatCount(1);
            as.play(ax);
        }
        as.start();
        mFlyingView.setVisibility(VISIBLE);
    }

    private void fallLeaves(){
        mFallingView.setResource(R.mipmap.ss_heart3, null);
        mFallingView.setCount(8);
        mFallingView.setVisibility(VISIBLE);
        mFallingView.setLeft(true);
        mFallingView.start();
    }

    private void launchRocket(){
        mRocketAnimSet = new AnimatorSet();
        ObjectAnimator ay = ObjectAnimator.ofFloat(mRocketContainer, TRANSLATION_Y, mRocketContainer.getHeight(), -mRocketContainer.getHeight() * 0.3F);
        ay.setDuration(800L);
        ay.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ay1 = ObjectAnimator.ofFloat(mRocketContainer, TRANSLATION_Y, -mRocketContainer.getHeight() * 0.5F, -mRocketContainer.getHeight() * 2);
        ay1.setDuration(1000L);
        ay1.setStartDelay(800L);
        ay1.setInterpolator(new AccelerateInterpolator());
        mRocketAnimSet.play(ay).before(ay1);
        mRocketAnimSet.addListener(this);
        mRocketAnimSet.start();
        mRocketContainer.setVisibility(VISIBLE);
    }

    private void kangarooHop(){
        final int unit = ScreenUtil.b(getContext(), 5);
        AnimatorSet as = new AnimatorSet();
        Path first = new Path();
        first.moveTo(unit * 30, unit * 35);
        first.quadTo(unit * 10, unit * 5, unit * 5, unit * 25);
        final PathMeasure pm = new PathMeasure(first, false);
        ValueAnimator va = ValueAnimator.ofFloat(0F, pm.getLength());
        va.setDuration(600L);
        mFlyingView.setImageResource(R.mipmap.wt_kangaroo);

        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float[] v = new float[2];
                pm.getPosTan((float)animation.getAnimatedValue(), v, null);
                mFlyingView.setX(v[0] + unit * 30);
                mFlyingView.setY(v[1] + unit * 30);
            }
        });
        Path second = new Path();
        second.moveTo(unit * 5, unit * 25);
        second.quadTo(-unit * 15, unit * 3, -unit * 35, unit * 30);
        final PathMeasure pm1 = new PathMeasure(second, false);
        ValueAnimator vb = ValueAnimator.ofFloat(0F, pm1.getLength());
        vb.setDuration(1000L);
        vb.setStartDelay(500L);
        vb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float[] v = new float[2];
                pm1.getPosTan((float)animation.getAnimatedValue(), v, null);
                mFlyingView.setX(v[0] + unit * 30);
                mFlyingView.setY(v[1] + unit * 30);
            }
        });
        as.play(va).before(vb);
        as.start();
        mFlyingView.setVisibility(VISIBLE);
    }

    private void riseSunflower(){
        RotateAnimation dis = new RotateAnimation(0, -30, Animation.ABSOLUTE, ScreenUtil.a(getContext()) / 2, Animation.ABSOLUTE, ScreenUtil.b(getContext()));
        dis.setDuration(500L);
        dis.setStartOffset(1500L);

        AnimationSet as = createRiseAnimation();
        RotateAnimation rotateAnimation = new RotateAnimation(-6, 6, Animation.ABSOLUTE, ScreenUtil.a(getContext()) / 4, Animation.ABSOLUTE, ScreenUtil.b(getContext()) / 2);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setInterpolator(new OvershootInterpolator());
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        as.addAnimation(rotateAnimation);
        as.addAnimation(dis);
        AnimationSet as1 = createRiseAnimation();
        RotateAnimation rotateAnimation1 = new RotateAnimation(6, -6, Animation.ABSOLUTE, ScreenUtil.a(getContext()) * 3 / 4, Animation.ABSOLUTE, ScreenUtil.b(getContext()) / 2);
        rotateAnimation1.setDuration(800L);
        rotateAnimation1.setInterpolator(new OvershootInterpolator());
        rotateAnimation1.setRepeatCount(1);
        rotateAnimation1.setRepeatMode(Animation.REVERSE);
        as1.addAnimation(rotateAnimation1);
        as1.addAnimation(dis);
        mLeftSunflowerView.startAnimation(as);
        mRightSunflowerView.startAnimation(as1);
        mLeftSunflowerView.setVisibility(VISIBLE);
        mRightSunflowerView.setVisibility(VISIBLE);
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if (animation.equals(mEarthViewTransY)) {
            mEarthView.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(animation.equals(mEarthViewTransY)){
            mWalkingGirlView.setVisibility(VISIBLE);
            AnimationDrawable drawable = (AnimationDrawable) mWalkingGirlView.getDrawable();
            drawable.start();
            createBuildingAnim(ScreenUtil.b(getContext(), 178.0F), -ScreenUtil.a(getContext()) / 5 + ScreenUtil.b(getContext(), 5.0F));
            mBuildingView.setVisibility(VISIBLE);
            mBuildingView.startAnimation(mBuildingAppearAnim);
        }
        if(animation.equals(mRocketAnimSet)){
            mRocketContainer.setVisibility(GONE);
            mBuildingView.setVisibility(GONE);
            createFireworkAnim();
        }
        if(animation.equals(mFireworkAnimSet)){
            stop();
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
        mEarthView = (ImageView) findViewById(R.id.iv_world_tour_earth);
        mWalkingGirlView = (ImageView) findViewById(R.id.iv_walking_girl);
        mBuildingView = (ImageView) findViewById(R.id.iv_common_build);
        mFlyingView = (ImageView) findViewById(R.id.iv_flying_object);
        mLeftSunflowerView = (ImageView) findViewById(R.id.iv_left_sunflower);
        mRightSunflowerView = (ImageView) findViewById(R.id.iv_right_sunflower);
        mLeftFirworkView = (ImageView) findViewById(R.id.iv_firework1);
        mRightFirworkView = (ImageView) findViewById(R.id.iv_firework2);
        mMidFirworkView = (ImageView) findViewById(R.id.iv_firework3);
        mRocketContainer = (LinearLayout) findViewById(R.id.ll_rocket_container);
        mFallingView = (FallingEffectView) findViewById(R.id.fev_heart);
        mFallingView.setResource(R.mipmap.wt_falling_heart, null);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.world_tuor_view;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        mBuildingView.setImageResource(buildingResIds[mCurBuilding]);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mCurBuilding++;
        switch (mCurBuilding){
            case 1:
                createBuildingAnim(ScreenUtil.b(getContext(), 178.0F), -ScreenUtil.a(getContext()) / 5 - ScreenUtil.b(getContext(), 15.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                break;
            case 2:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3 + ScreenUtil.b(getContext(), 10.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                riseSunflower();
                break;
            case 3:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3 + ScreenUtil.b(getContext(), 13.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mLeftSunflowerView.setVisibility(GONE);
                mRightSunflowerView.setVisibility(GONE);
                mFallingView.setVisibility(VISIBLE);
                mFallingView.start();
                break;
            case 4:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3);
                mBuildingView.startAnimation(mBuildingAppearAnim);
                break;
            case 5:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3 - ScreenUtil.b(getContext(), 2.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mFallingView.stop();
                mFallingView.recycle();
                startFlying();
                break;
            case 6:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3 - ScreenUtil.b(getContext(), 8.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mFlyingView.setVisibility(INVISIBLE);
                mFlyingView.setX(0);
                mFlyingView.setY(0);
                fallLeaves();
                break;
            case 7:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 5 + ScreenUtil.b(getContext(), 8.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                break;
            case 8:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 3 - ScreenUtil.b(getContext(), 10.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mFlyingView.setVisibility(INVISIBLE);
                mFlyingView.setX(0);
                mFlyingView.setY(0);
                startFlying();
                break;
            case 9:
                createBuildingAnim(ScreenUtil.b(getContext(), 178.0F), -ScreenUtil.a(getContext()) / 5 + ScreenUtil.b(getContext(), 26.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mFlyingView.setVisibility(GONE);
                kangarooHop();
                break;
            case 10:
                createBuildingAnim(ScreenUtil.b(getContext(), 168.0F), -ScreenUtil.a(getContext()) / 5 - ScreenUtil.b(getContext(), 26.0F));
                mBuildingView.startAnimation(mBuildingAppearAnim);
                mFlyingView.setVisibility(GONE);
                launchRocket();
                break;
        }
        if(mCurBuilding > buildingResIds.length - 1){
            mCurBuilding = 0;
        }else {
            mBuildingView.setImageResource(0);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
