package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiwang on 2017/7/13.
 */

public class BubbleView extends RelativeLayout{
    private List<Drawable> drawableList = new ArrayList<>();

    private int viewWidth = dp2pix(16), viewHeight = dp2pix(16);

    private int maxHeartNum = 8;
    private int minHeartNum = 2;

    private int riseDuration = 2000;

    private int bottomPadding = dp2pix(70);
    private int originsOffset = dp2pix(35);

    private float maxScale = 3.0f;
    private float minScale = 1.5f;

    private int innerDelay = 200;
    private boolean isStopped;

    public BubbleView(Context context) {
        super(context);
    }

    public BubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BubbleView setDrawableList(List<Drawable> drawableList){
        this.drawableList = drawableList;
        return this;
    }

    public BubbleView setRiseDuration(int riseDuration){
        this.riseDuration = riseDuration;
        return this;
    }

    public BubbleView setBottomPadding(int px){
        this.bottomPadding = px;
        return this;
    }

    public BubbleView setOriginsOffset(int px){
        this.originsOffset = px;
        return this;
    }

    public BubbleView setScaleAnimation(float maxScale, float minScale) {
        this.maxScale = maxScale;
        this.minScale = minScale;
        return this;
    }

    public BubbleView setAnimationDelay(int delay){
        this.innerDelay = delay;
        return this;
    }

    public void setMaxHeartNum(int maxHeartNum){
        this.maxHeartNum = maxHeartNum;
    }

    public void setMinHeartNum(int minHeartNum){
        this.minHeartNum = minHeartNum;
    }

    public BubbleView setItemViewWH(int viewWidth, int viewHeight){
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
        return this;
    }

    public BubbleView setGiftBoxImage(Drawable drawable, int positionX, int positionY){
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawable);
        LayoutParams layoutParams = new LayoutParams(imageView.getWidth(), imageView.getHeight());
        addView(imageView, layoutParams);
        imageView.setX(positionX);
        imageView.setY(positionY);
        return this;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isStopped = true;
    }

    public void startAnimation(final int rankWidth, final int rankHeight){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!isStopped){
//                    post(new Runnable() {
//                        @Override
//                        public void run() {
//                            bubbleAnimation(rankWidth, rankHeight);
//                        }
//                    });
//                    try {
//                        Thread.sleep(500L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        ValueAnimator animator1 = ValueAnimator.ofInt(0, 30);
        animator1.setDuration(1500L);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                if(value % 5 == 0)
                bubbleAnimation(rankWidth, rankHeight);
            }
        });
        ValueAnimator animator2 = ValueAnimator.ofInt(0, 30);
        animator2.setDuration(1500L);
        animator2.setStartDelay(800L);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                if(value % 5 == 0)
                    bubbleAnimation(rankWidth, rankHeight);
            }
        });
        ValueAnimator animator3 = ValueAnimator.ofInt(0, 30);
        animator3.setDuration(1500L);
        animator3.setStartDelay(800L);
        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                if(value % 5 == 0)
                    bubbleAnimation(rankWidth, rankHeight);
            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.play(animator3).after(animator2);
        set.start();
    }

    public void stop(){
        this.isStopped = true;
    }

    private void bubbleAnimation(int rankWidth, int rankHeight){
        rankHeight -= bottomPadding;
        int seed = (int)(Math.random() * 3);
        seed = 0;
        switch (seed){
            case 0:
                rankWidth -= originsOffset;
                break;
            case 1:
                rankWidth += originsOffset;
                break;
            case 2:
                rankHeight -= originsOffset;
                break;
        }

        int heartDrawableIndex;
        LayoutParams layoutParams = new LayoutParams(viewWidth, viewHeight);
        heartDrawableIndex = (int)(drawableList.size() * Math.random());
        ImageView tempImageView = new ImageView(getContext());
        tempImageView.setImageDrawable(drawableList.get(heartDrawableIndex));
        addView(tempImageView, layoutParams);

        ObjectAnimator riseAlphaAnimator = ObjectAnimator.ofFloat(tempImageView, ALPHA, 1.0f, 0.0f);
        riseAlphaAnimator.setDuration(riseDuration - 500);

        ObjectAnimator riseScaleXAnimator = ObjectAnimator.ofFloat(tempImageView, SCALE_X, 0.3F, 1.5F);
        riseScaleXAnimator.setDuration(500L);

        ObjectAnimator riseScaleYAnimator = ObjectAnimator.ofFloat(tempImageView, SCALE_Y, 0.3F, 1.5F);
        riseScaleYAnimator.setDuration(500L);

        ObjectAnimator riseScaleXAnimator1 = ObjectAnimator.ofFloat(tempImageView, SCALE_X, minScale, maxScale);
        riseScaleXAnimator1.setDuration(riseDuration);

        ObjectAnimator riseScaleYAnimator1 = ObjectAnimator.ofFloat(tempImageView, SCALE_Y, minScale, maxScale);
        riseScaleYAnimator1.setDuration(riseDuration);

        ValueAnimator valueAnimator = getBesselAnimator(tempImageView, rankWidth / 3, rankHeight);
        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.play(valueAnimator).with(riseScaleXAnimator).with(riseScaleYAnimator);//with(riseAlphaAnimator).
        animatorSet.play(riseScaleXAnimator1).with(riseScaleYAnimator1).after(riseScaleXAnimator);
        animatorSet.start();
    }

    private ValueAnimator getBesselAnimator(final ImageView imageView, int rankWidth, int rankHeight){
        float point0[] = new float[2];
        point0[0] = rankWidth;
        point0[1] = rankHeight;

        float point1[] = new float[2];
        point1[0] = (float) (rankWidth * 1.80) + (float) (Math.random() * rankWidth * 0.8);
        point1[1] = (float) (rankHeight - Math.random() * rankHeight * 0.5);

        float point2[] = new float[2];
        point2[0] = (float) (Math.random() * rankWidth * 1.8);
        point2[1] = (float) (Math.random() * (rankHeight - point1[1]));

        float point3[] = new float[2];
        point3[0] = (float) (rankWidth * 1.50) + (float) (Math.random() * rankWidth * 0.8);
        point3[1] = ScreenUtil.b(getContext(), 30);//TODO 0

        BesselEvaluator besselEvaluator = new BesselEvaluator(point1, point2);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(besselEvaluator, point0, point3);
        valueAnimator.setDuration(riseDuration);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float[] currentPosition = (float[]) animation.getAnimatedValue();
                imageView.setTranslationX(currentPosition[0]);
                imageView.setTranslationY(currentPosition[1]);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                removeView(imageView);
                imageView.setImageDrawable(null);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        return valueAnimator;
    }

   private class BesselEvaluator implements TypeEvaluator<float[]> {
        private float point1[] = new float[2], point2[] = new float[2];

        BesselEvaluator(float[] point1, float[] point2){
            this.point1 = point1;
            this.point2 = point2;
        }

        @Override
        public float[] evaluate(float fraction, float[] point0, float[] point3) {
            float[] currentPosition = new float[2];
            currentPosition[0] = point0[0] * (1 - fraction) * (1 - fraction) * (1 - fraction)
                    + point1[0] * 3 * fraction * (1 - fraction) * (1 - fraction)
                    + point2[0] * 3 * (1 - fraction) * fraction * fraction
                    + point3[0] * fraction * fraction * fraction;
            currentPosition[1] = point0[1] * (1 - fraction) * (1 - fraction) * (1 - fraction)
                    + point1[1] * 3 * fraction * (1 - fraction) * (1 - fraction)
                    + point2[1] * 3 * (1 - fraction) * fraction * fraction
                    + point3[1] * fraction * fraction * fraction;
            return currentPosition;
        }
    }

    private int dp2pix(int dp){
        float scale = getResources().getDisplayMetrics().density;
        int pix = (int) (dp * scale + 0.5f);
        return pix;
    }

    private int pix2dp(int pix){
        float scale = getResources().getDisplayMetrics().density;
        int dp = (int) (pix/scale + 0.5f);
        return dp;
    }
}
