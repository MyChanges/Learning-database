package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiwang on 2017/7/17.
 */

public class HolyCaneView  extends CustomBaseViewRelative implements Animator.AnimatorListener{

    private ImageView mCaneView;
    private ImageView mLightView;
    private List<Point> mLeftPoints = new ArrayList();
    private List<Point> mRightPoints = new ArrayList();
    private float[] heart2Pos = new float[2];
    private Path mLightPath;
    private PathMeasure mPathMeasure;
    private ValueAnimator mPathAnim;
//    private AnimatorSet mCaneAnimSet;
    private AnimatorSet mCaneEnterAnimSet;
    private AnimatorSet mCaneResetAnimSet;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public HolyCaneView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        buildPoints(ScreenUtil.a(getContext()), ScreenUtil.b(getContext()));
        mLightPath = buildPath(mLeftPoints, mRightPoints);
        mPathMeasure = new PathMeasure();
        mPathMeasure.setPath(mLightPath, false);
        mPathAnim = ValueAnimator.ofFloat(0.0F, mPathMeasure.getLength());
        mPathAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                float f = (float)animator.getAnimatedValue();
                mPathMeasure.getPosTan(f, heart2Pos, null);
                ViewCompat.setX(mCaneView, heart2Pos[0]);
                ViewCompat.setY(mCaneView, heart2Pos[1]);
            }
        });
        mPathAnim.setDuration(2000L);
        mPathAnim.addListener(this);

//        ObjectAnimator swordRotation = ObjectAnimator.ofFloat(mCaneView, ROTATION, 0F, 1440F);
//        swordRotation.setDuration(2000L);
//        ObjectAnimator swordTransX = ObjectAnimator.ofFloat(mCaneView, TRANSLATION_X, ScreenUtil.b(getContext(), 260), 0);
//        swordTransX.setDuration(2000L);
//        ObjectAnimator swordTransY = ObjectAnimator.ofFloat(mCaneView, TRANSLATION_Y, -ScreenUtil.b(getContext(), 260), 0);
//        swordTransY.setDuration(2000L);
//
//        mCaneAnimSet = new AnimatorSet();
//        mCaneAnimSet.play(swordRotation).with(swordTransX).with(swordTransY);
//        mCaneAnimSet.addListener(this);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path1.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path2.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path3.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path4.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path5.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path6.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path7.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path8.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path9.png"), 100);
        animationDrawable.addFrame(new BitmapDrawable(getResources(), getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path10.png"), 100);
//        mLightView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.holy_cane_light_path));
        animationDrawable.setOneShot(true);
        mLightView.setImageDrawable(animationDrawable);
        ObjectAnimator caneRotation = ObjectAnimator.ofFloat(mCaneView, ROTATION, 0, 70);
        caneRotation.setDuration(100L);
        ObjectAnimator caneTrans = ObjectAnimator.ofFloat(mCaneView, TRANSLATION_X, 0, -ScreenUtil.a(getContext()) * 2 / 3);
        caneTrans.setDuration(600L);
        caneTrans.setInterpolator(new OvershootInterpolator());
        mCaneEnterAnimSet = new AnimatorSet();
        mCaneEnterAnimSet.play(caneRotation).with(caneTrans);
        mCaneEnterAnimSet.addListener(this);
        ObjectAnimator resetX = ObjectAnimator.ofFloat(mCaneView, TRANSLATION_X, -ScreenUtil.a(getContext()) * 2 / 3, -ScreenUtil.a(getContext()) / 2 + ScreenUtil.b(getContext(), 10));
        resetX.setDuration(600L);
        ObjectAnimator resetY = ObjectAnimator.ofFloat(mCaneView, TRANSLATION_Y, 0, -ScreenUtil.a(getContext()) * 2 / 3);
        resetY.setDuration(600L);
        ObjectAnimator caneResetRotation = ObjectAnimator.ofFloat(mCaneView, ROTATION, 70, 0);
        caneResetRotation.setDuration(600L);
        mCaneResetAnimSet = new AnimatorSet();
        mCaneResetAnimSet.play(resetX).with(resetY).with(caneResetRotation);//
        mCaneResetAnimSet.addListener(this);
        if(mListener != null)mListener.a();
    }

    public void start() {
        isDisplaying = true;
//        mCaneAnimSet.start();
        mCaneEnterAnimSet.start();
    }

    public void stop() {
        isDisplaying = false;
        if (mCaneEnterAnimSet != null) {
            mCaneEnterAnimSet.removeAllListeners();
            mCaneEnterAnimSet.cancel();
            mCaneEnterAnimSet = null;
        }
        if (mCaneResetAnimSet != null) {
            mCaneResetAnimSet.removeAllListeners();
            mCaneResetAnimSet.cancel();
            mCaneResetAnimSet = null;
        }
        if (mPathAnim != null) {
            mPathAnim.removeAllListeners();
            mPathAnim.cancel();
            mPathAnim = null;
        }
        if(mListener != null)mListener.b();
    }

    @Override
    protected void a() {
        mCaneView = (ImageView) findViewById(R.id.iv_holy_cane);
        mLightView = (ImageView) findViewById(R.id.iv_holy_cane_light);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.holy_cane_view;
    }

    private void buildPoints(int width, int height){
        mLeftPoints.add(new Point(width * 2 / 3, -height * 5 / 12));//width * 3 / 2, -height * 2 / 3
        mLeftPoints.add(new Point(-width / 3, -height / 2));
        mRightPoints.add(new Point(width * 5 / 7, 0));
        mLeftPoints.add(new Point(-width / 5, height / 12));
        mRightPoints.add(new Point(width / 3, height / 7));
    }

    private Path buildPath(List<Point> leftPoints, List<Point> rightPoints) {
        Path path = new Path();
        path.reset();
        path.moveTo(leftPoints.get(0).x, leftPoints.get(0).y);
        path.cubicTo(leftPoints.get(1).x, leftPoints.get(1).y,
                rightPoints.get(0).x / 2 + leftPoints.get(1).x / 2, rightPoints.get(0).y / 2 + leftPoints.get(1).y / 2,
                rightPoints.get(0).x, rightPoints.get(0).y);
         path.cubicTo(rightPoints.get(0).x / 2 + leftPoints.get(2).x / 2, rightPoints.get(0).y / 2 + leftPoints.get(2).y / 2,
                leftPoints.get(2).x, leftPoints.get(2).y,
                rightPoints.get(1).x, rightPoints.get(1).y);
        return path;
    }

    @Override
    public void onAnimationStart(Animator animation) {
//        if(animation.equals(mCaneAnimSet)){
//            mCaneView.setVisibility(VISIBLE);
//        }
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if(!isDisplaying) return;
        if(animation.equals(mCaneEnterAnimSet)){
            mCaneResetAnimSet.start();
        }
        if(animation.equals(mCaneResetAnimSet)){
            mPathAnim.start();
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLightView.setVisibility(VISIBLE);
                    AnimationDrawable drawable = (AnimationDrawable) mLightView.getDrawable();
                    drawable.start();
                }
            },800L);
        }
//        if(animation.equals(mCaneAnimSet)){
//            mPathAnim.start();
//            postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mLightView.setVisibility(VISIBLE);
//                    AnimationDrawable drawable = (AnimationDrawable) mLightView.getDrawable();
//                    drawable.start();
//                }
//            },800L);
//        }
        if (animation.equals(mPathAnim)){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    stop();
                }
            }, 3000L);
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
