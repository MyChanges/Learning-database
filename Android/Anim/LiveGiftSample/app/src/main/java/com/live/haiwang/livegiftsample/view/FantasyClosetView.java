package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by haiwang on 2017/7/3.
 */

public class FantasyClosetView extends CustomBaseViewRelative{

    private RelativeLayout mRootView;
    private RelativeLayout mClosetView;
    private ImageView mLeftDoorView;
    private ImageView mRightDoorView;
    private ObjectAnimator mBgAnim;
    private ObjectAnimator mClosetAnim;
    private AnimatorSet mLeftDoorAnimSet;
    private AnimatorSet mRightDoorAnimSet;
    private boolean isDisplaying;
    private GiftDisplayListener mListener;

    public FantasyClosetView(Context context, GiftDisplayListener listener) {
        super(context);
        this.mListener = listener;
        d();
    }

    private void d() {
        mBgAnim = ObjectAnimator.ofFloat(mRootView, ALPHA, 0F, 1F);
        mBgAnim.setDuration(500L);
        mClosetAnim = ObjectAnimator.ofFloat(mClosetView, TRANSLATION_Y, -ScreenUtil.b(getContext()), 0F);
        mClosetAnim.setDuration(1000L);
        mClosetAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isDisplaying)return;
                mRightDoorAnimSet.start();
                mLeftDoorAnimSet.start();
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(getContext()).load("file:///").into(mLeftDoorView);
                        Picasso.with(getContext()).load("file:///").into(mRightDoorView);
                        mLeftDoorView.setBackgroundColor(Color.WHITE);
                        mRightDoorView.setBackgroundColor(Color.WHITE);
                    }
                }, 1200L);
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stop();
                    }
                }, 4000L);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator leftDoorRotation = ObjectAnimator.ofFloat(mLeftDoorView, ROTATION_Y, 0F, -120F);
        leftDoorRotation.setDuration(2000L);
        ObjectAnimator leftDoorScale = ObjectAnimator.ofFloat(mLeftDoorView, SCALE_X, 1F, 0.6F);
        leftDoorScale.setDuration(2000L);
        int pivotY = ScreenUtil.b(getContext(), 120);
        mLeftDoorAnimSet = new AnimatorSet();
        mLeftDoorAnimSet.play(leftDoorRotation).with(leftDoorScale);
        mLeftDoorView.setPivotX(0);
        mLeftDoorView.setPivotY(pivotY);
        ObjectAnimator rightDoorRotation = ObjectAnimator.ofFloat(mRightDoorView, ROTATION_Y, 0F, 120F);
        rightDoorRotation.setDuration(2000L);
        ObjectAnimator rightDoorScale = ObjectAnimator.ofFloat(mRightDoorView, SCALE_X, 1F, 0.6F);
        rightDoorScale.setDuration(2000L);
        mRightDoorView.setPivotX(ScreenUtil.b(getContext(), 98.0F));
        mRightDoorView.setPivotY(pivotY);
        mRightDoorAnimSet = new AnimatorSet();
        mRightDoorAnimSet.play(rightDoorRotation).with(rightDoorScale);
        if(mListener != null) mListener.a();
    }

    public void start() {
        isDisplaying = true;
        mRootView.setVisibility(VISIBLE);
        mClosetView.setVisibility(VISIBLE);
        mBgAnim.start();
        mClosetAnim.start();
    }

    public void stop() {
        this.isDisplaying = false;
        if (mBgAnim != null) {
            mBgAnim.removeAllListeners();
            mBgAnim.cancel();
            mBgAnim = null;
        }
        if (mClosetAnim != null) {
            mClosetAnim.removeAllListeners();
            mClosetAnim.cancel();
            mClosetAnim = null;
        }
        if (mLeftDoorAnimSet != null) {
            mLeftDoorAnimSet.removeAllListeners();
            mLeftDoorAnimSet.cancel();
            mLeftDoorAnimSet = null;
        }
        if (mRightDoorAnimSet != null) {
            mRightDoorAnimSet.removeAllListeners();
            mRightDoorAnimSet.cancel();
            mRightDoorAnimSet = null;
        }
        if(mListener != null) mListener.b();
    }

    @Override
    protected void a() {
        mRootView = (RelativeLayout) findViewById(R.id.closet_root);
        mClosetView = (RelativeLayout) findViewById(R.id.closet_big_container);
        mLeftDoorView = (ImageView) findViewById(R.id.closet_left_door);
        mRightDoorView = (ImageView) findViewById(R.id.closet_right_door);
//        String folder = Environment.getExternalStorageDirectory() + File.separator + "xylive" + File.separator + "FantacyCloset";
//        File file = new File(folder + File.separator + "closet_left_door.png");
//        if(file.exists()){
//            Log.i("HARRY","file len = "+file.length());
//        }
        File user = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation");
        if(user.exists())
            Log.i("HARRY","user exists = "+user.getPath());
        Picasso.with(getContext()).load("file:///" + user.getPath() + File.separator + "closet_left_door.png").resize(ScreenUtil.b(getContext(), 98), ScreenUtil.b(getContext(), 278)).into(mLeftDoorView);
        Picasso.with(getContext()).load("file:///" + user.getPath() + File.separator + "closet_right_door.png").resize(ScreenUtil.b(getContext(), 98), ScreenUtil.b(getContext(), 278)).into(mRightDoorView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.gift_fantasy_closet;
    }

}
