package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/6/30.
 */

public class ReunionDinnerView extends CustomBaseViewRelative
        implements Animation.AnimationListener {
    private ObjectAnimator mFirstFrameScaleY;
    private ObjectAnimator mFirstFrameScaleX;
    private ObjectAnimator mRightDoorAnim;
    private ObjectAnimator mLightScaleX;
    private ObjectAnimator mLightScaleY;
    private ObjectAnimator mLightAlpha;
    private ObjectAnimator mFirstFrameAlpha;
    private RotateAnimation H;
    private RotateAnimation I;
    private RotateAnimation J;
    private RotateAnimation K;
    private ObjectAnimator mWindowApha;
    private GiftDisplayListener mListener;
    private Handler N = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 272) {
                c();
            }
        }
    };
    private Boolean O = false;
    private RelativeLayout mRootView;
    private RelativeLayout mFirstFrame;
    private ImageView mLeftDoor;
    private ImageView mRightDoor;
    private ImageView mLanternlt;
    private ImageView mLanternlb;
    private ImageView mLanternrt;
    private ImageView mLanternrb;
    private RelativeLayout mInkePlaying;
    private ImageView mInkePlayingFire;
    private ImageView mLight;
    private RelativeLayout mSecondFrame;
    private ImageView mWindow;
    private ReunionFireworksView mFireworkOne;
    private ReunionFireworksView mFireworkTwo;
    private ReunionFireworksView mFireworkThree;
    private ImageView mInkeOne;
    private ImageView mInkeThree;
    private ImageView mInkeFour;
    private ImageView mInkeTwo;
    private AnimationSet mMainAnim;
    private AnimationDrawable mFireAnimDrawable;
    private RotateAnimation mLeftLanternAnim;
    private RotateAnimation mRightLanternAnim;
    private AnimatorSet mInkePlayingAnimSet;
    private ObjectAnimator mLeftDoorAnim;

    public ReunionDinnerView(Context paramContext, GiftDisplayListener parama) {
        super(paramContext);
        this.mListener = parama;
        d();
    }

    private void d() {
        this.mMainAnim = new AnimationSet(false);
        Object localObject1 = new TranslateAnimation(0.0F, 0.0F, ScreenUtil.b(getContext(), 290.0F), 0.0F);
        ((TranslateAnimation) localObject1).setDuration(500L);
        Object localObject2 = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.9F, 1, 0.5F, 1, 1.0F);
        ((ScaleAnimation) localObject2).setInterpolator(new OvershootInterpolator());
        ((ScaleAnimation) localObject2).setDuration(150L);
        ((ScaleAnimation) localObject2).setRepeatMode(ValueAnimator.REVERSE);
        ((ScaleAnimation) localObject2).setStartOffset(450L);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 1.1F, 1, 0.5F, 1, 1.0F);
        localScaleAnimation.setInterpolator(new OvershootInterpolator());
        localScaleAnimation.setDuration(150L);
        localScaleAnimation.setRepeatMode(ValueAnimator.REVERSE);
        localScaleAnimation.setStartOffset(600L);
        this.mMainAnim.addAnimation((Animation) localObject1);
        this.mMainAnim.addAnimation((Animation) localObject2);
        this.mMainAnim.addAnimation(localScaleAnimation);
        this.mRightLanternAnim = new RotateAnimation(7.0F, -7.0F, 1, 0.5F, 1, 0.0F);
        this.mRightLanternAnim.setDuration(800L);
        this.mRightLanternAnim.setRepeatMode(ValueAnimator.REVERSE);
        this.mRightLanternAnim.setRepeatCount(-1);
        this.mLeftLanternAnim = new RotateAnimation(-7.0F, 7.0F, 1, 0.5F, 1, 0.0F);
        this.mLeftLanternAnim.setDuration(800L);
        this.mLeftLanternAnim.setRepeatMode(ValueAnimator.REVERSE);
        this.mLeftLanternAnim.setRepeatCount(-1);
        this.mLightScaleX = ObjectAnimator.ofFloat(this.mLight, View.SCALE_X, new float[]{0.5F, 3.2F});
        this.mLightScaleX.setDuration(900L);
        this.mLightScaleY = ObjectAnimator.ofFloat(this.mLight, View.SCALE_Y, new float[]{0.5F, 3.2F});
        this.mLightScaleY.setDuration(900L);
        this.mLightAlpha = ObjectAnimator.ofFloat(this.mLight, View.ALPHA, new float[]{1.0F, 0.0F});
        this.mLightAlpha.setDuration(900L);
        this.mInkePlaying.measure(0, 0);
        int i1 = this.mInkePlaying.getMeasuredWidth() / 3;
        int i2 = this.mInkePlaying.getMeasuredHeight();
        this.mInkePlaying.setPivotX(i1 * 2);
        this.mInkePlaying.setPivotY(i2);
        i1 = ScreenUtil.b(getContext(), 255.0F);
        this.mInkePlayingAnimSet = new AnimatorSet();
        localObject1 = ObjectAnimator.ofFloat(this.mInkePlaying, View.TRANSLATION_X, new float[]{0.0F, -i1});
        ((ObjectAnimator) localObject1).setDuration(2300L);
        localObject2 = ObjectAnimator.ofFloat(this.mInkePlaying, View.ROTATION, new float[]{-2.0F, 2.0F});
        ((ObjectAnimator) localObject2).setDuration(500L);
        ((ObjectAnimator) localObject2).setRepeatMode(ValueAnimator.REVERSE);
        ((ObjectAnimator) localObject2).setRepeatCount(-1);
        this.mInkePlayingAnimSet.play((Animator) localObject1).with((Animator) localObject2);
        this.mInkePlayingAnimSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator paramAnonymousAnimator) {
                if (!O) {
                    return;
                }
                mSecondFrame.setVisibility(VISIBLE);
                mLeftDoorAnim.start();
                mRightDoorAnim.start();
            }
        });
        this.mLeftDoor.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        i1 = this.mLeftDoor.getMeasuredWidth();
        i2 = this.mLeftDoor.getMeasuredHeight();
        float f1 = this.mLeftDoor.getX();
        float f2 = this.mLeftDoor.getY();
        this.mLeftDoor.setPivotX(f1);
        this.mLeftDoor.setPivotY(f2 + i2 / 2);
        this.mLeftDoorAnim = ObjectAnimator.ofFloat(this.mLeftDoor, View.SCALE_X, new float[]{1.0F, 0.0F});
        this.mLeftDoorAnim.setStartDelay(2300L);
        this.mLeftDoorAnim.setDuration(900L);
        f1 = this.mRightDoor.getX();
        f2 = this.mRightDoor.getY();
        this.mRightDoor.setPivotX(i1 + f1);
        this.mRightDoor.setPivotY(i2 / 2 + f2);
        this.mRightDoorAnim = ObjectAnimator.ofFloat(this.mRightDoor, View.SCALE_X, new float[]{1.0F, 0.0F});
        this.mRightDoorAnim.setDuration(900L);
        this.mRightDoorAnim.setStartDelay(2300L);
        this.mRightDoorAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator paramAnonymousAnimator) {
                if (!O) {
                    return;
                }
                mInkeOne.startAnimation(H);
                mInkeTwo.startAnimation(K);
                mInkeThree.startAnimation(J);
                mInkeFour.startAnimation(I);
                mLightScaleX.start();
                mLightScaleY.start();
                mLightAlpha.start();
                mFirstFrameScaleX.start();
                mFirstFrameScaleY.start();
                mFirstFrameAlpha.start();
                mWindowApha.start();
//                mFireworkTwo.m(mFireworkTwo.this).start();
//                mFireworkTwo.n(mFireworkTwo.this).start();
//                mFireworkTwo.o(mFireworkTwo.this).start();
//                mFireworkTwo.p(mFireworkTwo.this).start();
//                mFireworkTwo.q(mFireworkTwo.this).start();
//                mFireworkTwo.r(mFireworkTwo.this).start();
//                mFireworkTwo.s(mFireworkTwo.this).start();
            }
        });
        this.mFirstFrameScaleX = ObjectAnimator.ofFloat(this.mFirstFrame, View.SCALE_X, new float[]{1.0F, 2.0F});
        this.mFirstFrameScaleX.setDuration(1000L);
        this.mFirstFrameScaleY = ObjectAnimator.ofFloat(this.mFirstFrame, View.SCALE_Y, new float[]{1.0F, 2.0F});
        this.mFirstFrameScaleY.setDuration(1000L);
        this.mFirstFrameAlpha = ObjectAnimator.ofFloat(this.mFirstFrame, View.ALPHA, new float[]{1.0F, 0.0F});
        this.mFirstFrameAlpha.setDuration(1000L);
        this.mFirstFrameAlpha.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator paramAnonymousAnimator) {
                if (O) {
//                    mFireworkTwo.v(mFireworkTwo.this).cancel();
//                    mFireworkTwo.w(mFireworkTwo.this).cancel();
                    mFireworkOne.a(1.3F, 1.3F, 10);
                    mFireworkTwo.a(0.8F, 0.8F, 400);
                    mFireworkThree.a(0.4F, 0.4F, 800);
                    if (N != null)
                        N.sendEmptyMessageDelayed(272, 3300L);
                }
            }

            public void onAnimationStart(Animator paramAnonymousAnimator) {
                if (O) {
//                    mFireworkTwo.t(mFireworkTwo.this).cancel();
//                    if (mFireworkTwo.u(mFireworkTwo.this) != null)
//                        mFireworkTwo.u(mFireworkTwo.this).stop();
                }
            }
        });
        this.mWindowApha = ObjectAnimator.ofFloat(this.mWindow, View.ALPHA, new float[]{0.0F, 1.0F});
        this.mWindowApha.setDuration(800L);
        this.mWindowApha.setStartDelay(200L);
        this.H = new RotateAnimation(-5.0F, 2.0F, 1, 0.5F, 1, 1.0F);
        this.H.setDuration(1000L);
        this.H.setRepeatMode(ValueAnimator.REVERSE);
        this.H.setRepeatCount(-1);
        this.K = new RotateAnimation(-6.0F, 6.0F, 1, 0.5F, 1, 1.0F);
        this.K.setDuration(1000L);
        this.K.setRepeatMode(ValueAnimator.REVERSE);
        this.K.setRepeatCount(-1);
        this.J = new RotateAnimation(8.0F, -8.0F, 1, 0.5F, 1, 1.0F);
        this.J.setDuration(1000L);
        this.J.setRepeatMode(ValueAnimator.REVERSE);
        this.J.setRepeatCount(-1);
        this.I = new RotateAnimation(-5.0F, 5.0F, 1, 0.5F, 1, 1.0F);
        this.I.setDuration(1000L);
        this.I.setRepeatMode(ValueAnimator.REVERSE);
        this.I.setRepeatCount(-1);
        if (this.mListener != null) {
            this.mListener.a();
        }
    }

    @Override
    protected void a() {
        this.mRootView = ((RelativeLayout) findViewById(R.id.id_rootview));
        this.mFirstFrame = ((RelativeLayout) this.mRootView.findViewById(R.id.id_firstframe));
        this.mLeftDoor = ((ImageView) this.mRootView.findViewById(R.id.id_leftdoor));
        this.mRightDoor = ((ImageView) this.mRootView.findViewById(R.id.id_rightdoor));
        this.mLanternlt = ((ImageView) this.mRootView.findViewById(R.id.id_lanternlt));
        this.mLanternlb = ((ImageView) this.mRootView.findViewById(R.id.id_lanternlb));
        this.mLanternrt = ((ImageView) this.mRootView.findViewById(R.id.id_lanternrt));
        this.mLanternrb = ((ImageView) this.mRootView.findViewById(R.id.id_lanternrb));
        this.mInkePlaying = ((RelativeLayout) this.mRootView.findViewById(R.id.id_inkeplaying));
        this.mInkePlayingFire = ((ImageView) this.mRootView.findViewById(R.id.id_inkeplaying_fire));
        this.mLight = ((ImageView) this.mRootView.findViewById(R.id.id_light));
        this.mFireAnimDrawable = ((AnimationDrawable) this.mInkePlayingFire.getBackground());
        this.mSecondFrame = ((RelativeLayout) this.mRootView.findViewById(R.id.id_secondframe));
        this.mWindow = ((ImageView) this.mSecondFrame.findViewById(R.id.id_window));
        this.mFireworkOne = ((ReunionFireworksView) this.mRootView.findViewById(R.id.id_fireworkone));
        this.mFireworkTwo = ((ReunionFireworksView) this.mRootView.findViewById(R.id.id_fireworktwo));
        this.mFireworkThree = ((ReunionFireworksView) this.mRootView.findViewById(R.id.id_fireworkthree));
        this.mInkeOne = ((ImageView) this.mRootView.findViewById(R.id.id_inkeone));
        this.mInkeTwo = ((ImageView) this.mRootView.findViewById(R.id.id_inketwo));
        this.mInkeThree = ((ImageView) this.mRootView.findViewById(R.id.id_inkethree));
        this.mInkeFour = ((ImageView) this.mRootView.findViewById(R.id.id_inkefour));
    }

    public void b() {
        this.O = true;
        this.mMainAnim.setAnimationListener(this);
        this.mFirstFrame.startAnimation(this.mMainAnim);
    }

    public void c() {
        this.O = false;
        if (this.mMainAnim != null) {
            this.mMainAnim.cancel();
            this.mMainAnim = null;
        }
        if (this.mFireAnimDrawable != null) {
            this.mFireAnimDrawable.stop();
        }
        if (this.mLeftLanternAnim != null) {
            this.mLeftLanternAnim.cancel();
            this.mLeftLanternAnim = null;
        }
        if (this.mRightLanternAnim != null) {
            this.mRightLanternAnim.cancel();
            this.mRightLanternAnim = null;
        }
        if (this.mInkePlayingAnimSet != null) {
            this.mInkePlayingAnimSet.removeAllListeners();
            this.mInkePlayingAnimSet.cancel();
            this.mInkePlayingAnimSet = null;
        }
        if (this.mLeftDoorAnim != null) {
            this.mLeftDoorAnim.removeAllListeners();
            this.mLeftDoorAnim.cancel();
            this.mLeftDoorAnim = null;
        }
        if (this.mRightDoorAnim != null) {
            this.mRightDoorAnim.removeAllListeners();
            this.mRightDoorAnim.cancel();
            this.mRightDoorAnim = null;
        }
        if (this.mLightScaleX != null) {
            this.mLightScaleX.removeAllListeners();
            this.mLightScaleX.cancel();
            this.mLightScaleX = null;
        }
        if (this.mLightScaleY != null) {
            this.mLightScaleY.removeAllListeners();
            this.mLightScaleY.cancel();
            this.mLightScaleY = null;
        }
        if (this.mLightAlpha != null) {
            this.mLightAlpha.removeAllListeners();
            this.mLightAlpha.cancel();
            this.mLightAlpha = null;
        }
        if (this.mFirstFrameScaleX != null) {
            this.mFirstFrameScaleX.removeAllListeners();
            this.mFirstFrameScaleX.cancel();
            this.mFirstFrameScaleX = null;
        }
        if (this.mFirstFrameScaleY != null) {
            this.mFirstFrameScaleY.removeAllListeners();
            this.mFirstFrameScaleY.cancel();
            this.mFirstFrameScaleY = null;
        }
        if (this.mFirstFrameAlpha != null) {
            this.mFirstFrameAlpha.removeAllListeners();
            this.mFirstFrameAlpha.cancel();
            this.mFirstFrameAlpha = null;
        }
        if (this.mWindowApha != null) {
            this.mWindowApha.removeAllListeners();
            this.mWindowApha.cancel();
            this.mWindowApha = null;
        }
        if (this.H != null) {
            this.H.cancel();
            this.H = null;
        }
        if (this.K != null) {
            this.K.cancel();
            this.K = null;
        }
        if (this.J != null) {
            this.J.cancel();
            this.J = null;
        }
        if (this.I != null) {
            this.I.cancel();
            this.I = null;
        }
        if (this.N != null) {
            this.N.removeCallbacksAndMessages(null);
            this.N = null;
        }
        if (this.mListener != null) {
            this.mListener.b();
        }
    }

    protected int getLayoutId() {
        return R.layout.view_reuniondinner;
    }

    public void onAnimationEnd(Animation paramAnimation) {
        if (!this.O) {
            return;
        }
        this.mInkePlayingAnimSet.start();
        this.mFireAnimDrawable.start();
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
        if (!this.O) {
            return;
        }
        this.mLanternlt.startAnimation(this.mRightLanternAnim);
        this.mLanternrt.startAnimation(this.mRightLanternAnim);
        this.mLanternlb.startAnimation(this.mLeftLanternAnim);
        this.mLanternrb.startAnimation(this.mLeftLanternAnim);
    }
}

