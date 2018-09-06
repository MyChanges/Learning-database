package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/6/30.
 */

public class ReunionFireworksView extends CustomBaseViewRelative
{
    private RelativeLayout mRootView;
    private ImageView mFireWork1;
    private ImageView mFireWork2;

    public ReunionFireworksView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    @Override
    protected void a()
    {
        this.mRootView = ((RelativeLayout)findViewById(R.id.id_rootview));
        this.mFireWork1 = ((ImageView)this.mRootView.findViewById(R.id.id_firework1));
        this.mFireWork2 = ((ImageView)this.mRootView.findViewById(R.id.id_firework2));
    }

    public void a(float paramFloat1, float paramFloat2, int paramInt)
    {
        AnimatorSet localAnimatorSet1 = new AnimatorSet();
        AnimatorSet localAnimatorSet2 = new AnimatorSet();
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mFireWork1, View.ALPHA, new float[] { 1.0F, 0.0F });
        localObjectAnimator1.setDuration(600L);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mFireWork2, View.ALPHA, new float[] { 1.0F, 0.0F });
        localObjectAnimator2.setDuration(600L);
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mFireWork1, View.SCALE_X, new float[] { 0.0F, paramFloat1 });
        localObjectAnimator3.setDuration(1800L);
        localObjectAnimator3.addListener(new AnimatorListenerAdapter()
        {
            public void onAnimationStart(Animator paramAnonymousAnimator)
            {
                mFireWork1.setVisibility(VISIBLE);
            }
        });
        localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mFireWork1, View.SCALE_Y, new float[] { 0.0F, paramFloat1 });
        localObjectAnimator4.setDuration(1800L);
        localObjectAnimator4.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.mFireWork2, View.SCALE_X, new float[] { 0.0F, paramFloat2 });
        localObjectAnimator5.setDuration(1800L);
        localObjectAnimator5.setInterpolator(new DecelerateInterpolator(1.2F));
        ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.mFireWork2, View.SCALE_Y, new float[] { 0.0F, paramFloat2 });
        localObjectAnimator6.setDuration(1800L);
        localObjectAnimator6.setInterpolator(new DecelerateInterpolator(1.2F));
        localObjectAnimator5.addListener(new AnimatorListenerAdapter()
        {
            public void onAnimationStart(Animator paramAnonymousAnimator)
            {
                mFireWork2.setVisibility(VISIBLE);
            }
        });
        localAnimatorSet1.play(localObjectAnimator3).with(localObjectAnimator4);
        localAnimatorSet1.play(localObjectAnimator3).before(localObjectAnimator1);
        localAnimatorSet2.play(localObjectAnimator5).with(localObjectAnimator6);
        localAnimatorSet2.play(localObjectAnimator5).before(localObjectAnimator2);
        localAnimatorSet1.setStartDelay(paramInt);
        localAnimatorSet2.setStartDelay(paramInt);
        localAnimatorSet1.start();
        localAnimatorSet2.start();
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.view_fireworks;
    }
}
