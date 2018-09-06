package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/6/30.
 */

public class GamePlaneView extends RelativeLayout {
    private ValueAnimator mPlaneBodyRotation;
    private ValueAnimator mLeftBodyTransX;
    private ValueAnimator mLeftBodyTransY;
    private ValueAnimator mLeftBodyRotation;
    private AnimatorSet mPlaneBodyAnimSet;
    private AnimatorSet mLeftBodyAnimSet;
    private GiftDisplayListener mListener;
    private String H;
    private String I;
    private Context mContext;
    private LayoutInflater b;
    private DisplayMetrics mDisplayMetrics;
    private View mRootView;
    private RelativeLayout mPlaneBody;
    private RelativeLayout mLeftPlaneBody;
    private ImageView mLeftPushFire;
    private ImageView mPushFire;
    private ImageView mLeftTopFire;
    private ImageView mLeftBottomFire;
    private ImageView mRightTopFire;
    private ImageView mRightBottomFire;
    private ImageView mRightTopFirstBullet;
    private ImageView mRightTopSecondBullet;
    private ImageView mRightBottomFirstBullet;
    private ImageView mRightBottomSecondBullet;
    private ImageView mLeftTopFirstBullet;
    private ImageView mLeftTopSecondBullet;
    private ImageView mLeftBottomFirstBullet;
    private ImageView mLeftBottomSecondBullet;
    private SimpleDraweeView mSenderView;
    private SimpleDraweeView mReceiverView;
    private SimpleDraweeView mLeftSenderView;
    private SimpleDraweeView mLeftReceiverView;
    private ValueAnimator mPlaneBodyTransX;
    private ValueAnimator mPlaneBodyTransY;

    public GamePlaneView(Context paramContext, GiftDisplayListener parama, String paramString1, String paramString2) {
        super(paramContext);
        this.mContext = paramContext;
        this.mListener = parama;
        this.H = paramString1;
        this.I = paramString2;
        b();
        c();
    }

    private ObjectAnimator shootBullet(final ImageView view, int delay, final boolean toRight) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, TRANSLATION_X, 0.0F, -mDisplayMetrics.widthPixels);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(1000L);
        animator.setStartDelay(delay);
        animator.setTarget(view);
        view.setVisibility(INVISIBLE);
        if (toRight) {
            mRightTopFire.setVisibility(VISIBLE);
            mRightBottomFire.setVisibility(VISIBLE);
        } else {
            mLeftTopFire.setVisibility(VISIBLE);
            mLeftBottomFire.setVisibility(VISIBLE);
        }
        animator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator paramAnonymousAnimator) {
                Log.d("PlaneView", "onAnimationCancel");
            }

            public void onAnimationEnd(Animator paramAnonymousAnimator) {
                Log.d("PlaneView", "onAnimationEnd");
                view.setVisibility(GONE);
                if (toRight) {
                    mRightTopFire.setVisibility(INVISIBLE);
                    mRightBottomFire.setVisibility(INVISIBLE);
                } else {
                    mLeftTopFire.setVisibility(INVISIBLE);
                    mLeftBottomFire.setVisibility(INVISIBLE);
                }
            }

            public void onAnimationRepeat(Animator paramAnonymousAnimator) {
                Log.d("PlaneView", "onAnimationRepeat");
            }

            public void onAnimationStart(Animator paramAnonymousAnimator) {
                Log.d("PlaneView", "onAnimationStart");
                view.setVisibility(VISIBLE);
            }
        });
        return animator;
    }

    private void startFire(final ImageView view, long delay) {
        mRootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(VISIBLE);
                AnimationDrawable animDrawable = (AnimationDrawable) view.getDrawable();
                view.setImageDrawable(animDrawable);
                animDrawable.start();
            }
        }, delay);
    }

    private void b() {
        this.b = LayoutInflater.from(this.mContext);
        this.mDisplayMetrics = getContext().getResources().getDisplayMetrics();
        this.mRootView = this.b.inflate(R.layout.game_plane_view, this, true);
        this.mPlaneBody = ((RelativeLayout) this.mRootView.findViewById(R.id.rl_plane_body));
        this.mLeftPlaneBody = ((RelativeLayout) this.mRootView.findViewById(R.id.rl_left_plane_body));
        this.mLeftPushFire = ((ImageView) this.mRootView.findViewById(R.id.iv_left_plane_push_fire));
        this.mPushFire = ((ImageView) this.mRootView.findViewById(R.id.iv_plane_push_fire));
        this.mLeftTopFire = ((ImageView) this.mRootView.findViewById(R.id.iv_left_top_plane_fire));
        this.mLeftBottomFire = ((ImageView) this.mRootView.findViewById(R.id.iv_left_bottom_plane_fire));
        this.mRightTopFire = ((ImageView) this.mRootView.findViewById(R.id.iv_right_top_plane_fire));
        this.mRightBottomFire = ((ImageView) this.mRootView.findViewById(R.id.iv_right_bottom_plane_fire));
        this.mRightTopFirstBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_right_top_plane_bullet_first));
        this.mRightTopSecondBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_right_top_plane_bullet_second));
        this.mRightBottomFirstBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_right_bottom_plane_bullet_first));
        this.mRightBottomSecondBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_right_bottom_plane_bullet_second));
        this.mLeftTopFirstBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_left_top_plane_bullet_first));
        this.mLeftTopSecondBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_letf_top_plane_bullet_second));
        this.mLeftBottomFirstBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_left_bottom_plane_bullet_first));
        this.mLeftBottomSecondBullet = ((ImageView) this.mRootView.findViewById(R.id.iv_letf_bottom_plane_bullet_second));
        this.mSenderView = ((SimpleDraweeView) this.mRootView.findViewById(R.id.iv_sender_img));
        this.mReceiverView = ((SimpleDraweeView) this.mRootView.findViewById(R.id.iv_recv_img));
        this.mLeftSenderView = ((SimpleDraweeView) this.mRootView.findViewById(R.id.iv_left_sender_img));
        this.mLeftReceiverView = ((SimpleDraweeView) this.mRootView.findViewById(R.id.iv_left_recv_img));
//        if (!TextUtils.isEmpty(this.H)){
//            b.mContext(this.H, this.mReceiverView, R.mipmap.default_head);
//            b.mContext(this.H, this.mLeftReceiverView, R.mipmap.default_head);
//        }
//        if (!TextUtils.isEmpty(this.I)){
//            b.mContext(this.I, this.mSenderView, R.mipmap.default_head);
//            b.mContext(this.I, this.mLeftSenderView, R.mipmap.default_head);
//        }
        this.mLeftPlaneBody.setScaleX(-1.0F);
        this.mLeftPlaneBody.setScaleY(1.0F);
    }

    private void c() {
        this.mPlaneBodyTransX = ObjectAnimator.ofFloat(this.mPlaneBody, TRANSLATION_X, 0.0F, -this.mDisplayMetrics.widthPixels * 2.0F - 650.0F);
        this.mPlaneBodyTransY = ObjectAnimator.ofFloat(this.mPlaneBody, TRANSLATION_Y, -500.0F, 20.0F, -100.0F);
        this.mPlaneBodyRotation = ObjectAnimator.ofFloat(this.mPlaneBody, ROTATION, -5.0F, 0.0F, 5.0F);
        this.mPlaneBodyTransX.setInterpolator(new MyInterpolator());
        this.mPlaneBodyTransY.setInterpolator(new AccelerateInterpolator());
        this.mPlaneBodyRotation.setInterpolator(new AccelerateInterpolator());
        this.mPlaneBodyTransX.setDuration(7000L);
        this.mPlaneBodyTransY.setDuration(7000L);
        this.mPlaneBodyRotation.setDuration(3500L);
        this.mLeftBodyTransX = ObjectAnimator.ofFloat(this.mLeftPlaneBody, TRANSLATION_X, 0.0F, this.mDisplayMetrics.widthPixels * 2.0F + 650.0F);
        this.mLeftBodyTransY = ObjectAnimator.ofFloat(this.mLeftPlaneBody, TRANSLATION_Y, -200.0F, -20.0F, 200.0F);
        this.mLeftBodyRotation = ObjectAnimator.ofFloat(this.mLeftPlaneBody, ROTATION, -15.0F, 0.0F, 5.0F);
        this.mLeftBodyTransX.setInterpolator(new MyInterpolator());
        this.mLeftBodyTransY.setInterpolator(new AccelerateInterpolator());
        this.mLeftBodyRotation.setInterpolator(new AccelerateInterpolator());
        this.mLeftBodyTransX.setDuration(6000L);
        this.mLeftBodyTransY.setDuration(6000L);
        this.mLeftBodyRotation.setDuration(6000L);
        this.mLeftPushFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_body_push_fire_anim));
        this.mPushFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_body_push_fire_anim));
        this.mRightTopFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_fire_anim));
        this.mRightBottomFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_fire_anim));
        this.mLeftTopFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_fire_anim));
        this.mLeftBottomFire.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.game_plane_fire_anim));
    }

    private void d() {
        setVisibility(INVISIBLE);
        if (this.mListener != null) {
            this.mListener.b();
        }
        e();
    }

    private void e() {
        if (this.mPlaneBodyTransX != null) {
            this.mPlaneBodyTransX.removeAllUpdateListeners();
            this.mPlaneBodyTransX.removeAllListeners();
            this.mPlaneBodyTransX.cancel();
            this.mPlaneBodyTransX = null;
        }
        if (this.mPlaneBodyTransY != null) {
            this.mPlaneBodyTransY.removeAllUpdateListeners();
            this.mPlaneBodyTransY.removeAllListeners();
            this.mPlaneBodyTransY.cancel();
            this.mPlaneBodyTransY = null;
        }
        if (this.mPlaneBodyRotation != null) {
            this.mPlaneBodyRotation.removeAllUpdateListeners();
            this.mPlaneBodyRotation.removeAllListeners();
            this.mPlaneBodyRotation.cancel();
            this.mPlaneBodyRotation = null;
        }
        if (this.mLeftBodyTransX != null) {
            this.mLeftBodyTransX.removeAllUpdateListeners();
            this.mLeftBodyTransX.removeAllListeners();
            this.mLeftBodyTransX.cancel();
            this.mLeftBodyTransX = null;
        }
        if (this.mLeftBodyTransY != null) {
            this.mLeftBodyTransY.removeAllUpdateListeners();
            this.mLeftBodyTransY.removeAllListeners();
            this.mLeftBodyTransY.cancel();
            this.mLeftBodyTransY = null;
        }
        if (this.mLeftBodyRotation != null) {
            this.mLeftBodyRotation.removeAllUpdateListeners();
            this.mLeftBodyRotation.removeAllListeners();
            this.mLeftBodyRotation.cancel();
            this.mLeftBodyRotation = null;
        }
        if (this.mPlaneBodyAnimSet != null) {
            this.mPlaneBodyAnimSet.removeAllListeners();
            this.mPlaneBodyAnimSet.cancel();
            this.mPlaneBodyAnimSet = null;
        }
        if (this.mLeftBodyAnimSet != null) {
            this.mLeftBodyAnimSet.removeAllListeners();
            this.mLeftBodyAnimSet.cancel();
            this.mLeftBodyAnimSet = null;
        }
    }

    public void a() {
        this.mPlaneBodyAnimSet = new AnimatorSet();
        this.mLeftBodyAnimSet = new AnimatorSet();
        this.mPlaneBodyAnimSet.playTogether(this.mPlaneBodyTransX, this.mPlaneBodyTransY, this.mPlaneBodyRotation);
        this.mLeftBodyAnimSet.playTogether(this.mLeftBodyTransX, this.mLeftBodyTransY, this.mLeftBodyRotation);
        this.mPlaneBodyAnimSet.start();
        startFire(mPushFire, 0L);
        startFire(mRightTopFire, 1000L);
        startFire(mRightBottomFire, 1000L);
        shootBullet(mRightTopFirstBullet, 2000, true).start();
        shootBullet(mRightTopSecondBullet, 2600, true).start();
        shootBullet(mRightBottomFirstBullet, 2000, true).start();
        shootBullet(mRightBottomSecondBullet, 2600, true).start();
        this.mLeftBodyAnimSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator paramAnonymousAnimator) {
            }

            public void onAnimationEnd(Animator paramAnonymousAnimator) {
                e();
            }

            public void onAnimationRepeat(Animator paramAnonymousAnimator) {
            }

            public void onAnimationStart(Animator paramAnonymousAnimator) {
            }
        });
        this.mPlaneBodyAnimSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator paramAnonymousAnimator) {
            }

            public void onAnimationEnd(Animator paramAnonymousAnimator) {
                mLeftBodyAnimSet.start();
                mLeftPlaneBody.setVisibility(VISIBLE);
                startFire(mLeftPushFire, 0L);
                startFire(mLeftTopFire, 4000L);
                startFire(mLeftBottomFire, 4000L);
                shootBullet(mLeftTopFirstBullet, 2000, false).start();
                shootBullet(mLeftTopSecondBullet, 2600, false).start();
                shootBullet(mLeftBottomFirstBullet, 2000, false).start();
                shootBullet(mLeftBottomSecondBullet, 2600, false).start();
            }

            public void onAnimationRepeat(Animator paramAnonymousAnimator) {
            }

            public void onAnimationStart(Animator paramAnonymousAnimator) {
            }
        });
    }

    class MyInterpolator implements TimeInterpolator {

        @Override
        public float getInterpolation(float paramFloat) {
            float f = paramFloat;
            if (paramFloat <= 0.5D) {
                f = (float) Math.sin(Math.PI * paramFloat) / 2.0F;
            }
            return f;
        }
    }

}

