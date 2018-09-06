package com.live.haiwang.livegiftsample;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.live.haiwang.livegiftsample.util.ScreenUtil;
import com.live.haiwang.livegiftsample.view.CherryFlowerView;
import com.live.haiwang.livegiftsample.view.EnterRoomEffectsView;
import com.live.haiwang.livegiftsample.view.FallenAngelView;
import com.live.haiwang.livegiftsample.view.FantasyClosetView;
import com.live.haiwang.livegiftsample.view.GamePlaneView;
import com.live.haiwang.livegiftsample.view.GiftDisplayListener;
import com.live.haiwang.livegiftsample.view.GuardSwordView;
import com.live.haiwang.livegiftsample.view.HerdBoyAndSpinningGirlView;
import com.live.haiwang.livegiftsample.view.HolyCaneView;
import com.live.haiwang.livegiftsample.view.LoveBondView;
import com.live.haiwang.livegiftsample.view.MeteorRainView;
import com.live.haiwang.livegiftsample.view.PinkSeaView;
import com.live.haiwang.livegiftsample.view.RabbitAndEggView;
import com.live.haiwang.livegiftsample.view.ReunionDinnerView;
import com.live.haiwang.livegiftsample.view.RocketsLaunchingView;
import com.live.haiwang.livegiftsample.view.SkyWheelView;
import com.live.haiwang.livegiftsample.view.SunriseView;
import com.live.haiwang.livegiftsample.view.TravelWorld;
import com.live.haiwang.livegiftsample.view.TravelWorldView;
import com.live.haiwang.livegiftsample.view.ValentinesDayView;
import com.live.haiwang.livegiftsample.view.WeddingDressView;
import com.live.haiwang.livegiftsample.view.WideTextView;
import com.live.haiwang.livegiftsample.view.WorldTourView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FrameLayout mContainer;
    private TextView mEmojiTextView;
    private RelativeLayout mButtons;
    private LinearLayout mEmojiContainer;
    private TextView mTextInput, mLastTextInput;
    private RelativeLayout mSearchBox;
//    private FallingPetalView mLeafLoadingView;
    private boolean isFirst = true;
    private WideTextView mWideTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        findViewById(R.id.valentines).setOnClickListener(this);
        findViewById(R.id.travel_world).setOnClickListener(this);
        findViewById(R.id.shot_plane).setOnClickListener(this);
        findViewById(R.id.mygirl).setOnClickListener(this);
        findViewById(R.id.reunion_dinner).setOnClickListener(this);
        findViewById(R.id.egg_rabbit).setOnClickListener(this);
        findViewById(R.id.gift_closet).setOnClickListener(this);
        findViewById(R.id.fallen_angel).setOnClickListener(this);
        findViewById(R.id.meteor_rain).setOnClickListener(this);
        findViewById(R.id.wedding_dress).setOnClickListener(this);
        findViewById(R.id.milky_way).setOnClickListener(this);
        findViewById(R.id.sky_wheel).setOnClickListener(this);
        findViewById(R.id.love_bond).setOnClickListener(this);
        findViewById(R.id.holy_cane).setOnClickListener(this);
        findViewById(R.id.petal_view).setOnClickListener(this);
        findViewById(R.id.enter_room).setOnClickListener(this);
        findViewById(R.id.sun_rise).setOnClickListener(this);
        mButtons = (RelativeLayout) findViewById(R.id.rl_buttons);
        mContainer = (FrameLayout) findViewById(R.id.gift_container);
        mEmojiTextView = (TextView) findViewById(R.id.emoji);
        mEmojiContainer = (LinearLayout) findViewById(R.id.emoji_container);
//        mLeafLoadingView = (FallingPetalView) findViewById(R.id.leaf_loading);
        mTextInput = (TextView) findViewById(R.id.libui_titlebar_search_textinput);
        mLastTextInput = (TextView) findViewById(R.id.libui_titlebar_search_last_textinput);
        mSearchBox = (RelativeLayout) findViewById(R.id.libui_titlebar_search_box);
        mWideTextView = (WideTextView) findViewById(R.id.wide_text);
        mWideTextView.setText("CopyAssets(this, closet_left_door.png,getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) " +
                "+ File.separator + animation + File.separator + closet_left_door.pngvcbvcnbvndsgfdbgfnhgmjgkhjlkj;.lk;lk;");
        ObjectAnimator move = ObjectAnimator.ofFloat(mWideTextView, View.TRANSLATION_X, ScreenUtil.a(this), -ScreenUtil.a(this));
        move.setDuration(2000L);
        move.start();
        setEmojiToTextView();
        mEmojiContainer.setVisibility(View.GONE);
        JNITest test = new JNITest();
        Log.i("HARRY", test.getStringFromC());
//        CopyAssets(this, "closet_left_door.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "closet_left_door.png");
//        CopyAssets(this, "closet_right_door.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "closet_right_door.png");
//        CopyAssets(this, "cane_path1.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path1.png");
//        CopyAssets(this, "cane_path2.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path2.png");
//        CopyAssets(this, "cane_path3.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path3.png");
//        CopyAssets(this, "cane_path4.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path4.png");
//        CopyAssets(this, "cane_path5.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path5.png");
//        CopyAssets(this, "cane_path6.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path6.png");
//        CopyAssets(this, "cane_path7.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path7.png");
//        CopyAssets(this, "cane_path8.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path8.png");
//        CopyAssets(this, "cane_path9.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path9.png");
//        CopyAssets(this, "cane_path10.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "cane_path10.png");
//        CopyAssets(this, "angel_body.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "angel_body.png");
//        CopyAssets(this, "angel_left_wing.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "angel_left_wing.png");
//        CopyAssets(this, "angel_right_wing.png",getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "animation" + File.separator + "angel_right_wing.png");
    }

    private void setEmojiToTextView(){
        int unicodeJoy = 0x1F602;
        String emojiString = "我是"+getEmojiStringByUnicode(unicodeJoy)+getEmojiStringByUnicode(unicodeJoy)+",你是谁";
        mEmojiTextView.setText(emojiString);
    }

    private String getEmojiStringByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    private void expand(final View v) {
        v.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetWidth = v.getMeasuredWidth();
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = 0;
        v.setLayoutParams(lp);
        v.setVisibility(View.VISIBLE);
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
//                if (interpolatedTime == 1) {
//                    isOpened = true;
//                    if(mListener != null) mListener.onExpanded();
//                }
                lp.width = (int) (targetWidth * interpolatedTime);
//                v.getLayoutParams().width = (int) (targetWidth * interpolatedTime);
//                v.requestLayout();
                v.setLayoutParams(lp);
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(2000);
        v.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        mButtons.setVisibility(View.INVISIBLE);
        switch (v.getId()){
            case R.id.shot_plane:
//                EnterRoomEffectsView view = new EnterRoomEffectsView(MainActivity.this);
//                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
//                lp.gravity = Gravity.CENTER_VERTICAL;
//                mContainer.addView(view, lp);
//                view.start();
//                mLeafLoadingView.setProgress(0);
//                if(isFirst){
//                    initAnimator();
//                }else{
//                    secondAnimator();
//                }
//                expand(mEmojiContainer);
//                createPlaneView();
                createRocketsView();
                break;
            case R.id.mygirl:
                createFlowerView();
                break;
            case R.id.travel_world:
                createTravelWorldView();
                break;
            case R.id.valentines:
                createSwordView();
//                createValentinesView();
                break;
            case R.id.reunion_dinner:
//                createReunionDinnerView();
                createWorldTuorView();
                break;
            case R.id.egg_rabbit:
                createRabbitEggView();
                break;
            case R.id.gift_closet:
                createClosetView();
                break;
            case R.id.fallen_angel:
                createFallenView();
                break;
            case R.id.meteor_rain:
                createMeteorRainView();
                break;
            case R.id.wedding_dress:
                createWeddingDressView();
                break;
            case R.id.milky_way:
                createMilkyWayView();
                break;
            case R.id.sky_wheel:
                createSkyWheelView();
                break;
            case R.id.love_bond:
                createLoveBondView();
                break;
            case R.id.holy_cane:
                createHolyCaneView();
                break;
            case R.id.petal_view:
                createPinkSeaView();
                break;
            case R.id.enter_room:
                createEnterRoomView();
                break;
            case R.id.sun_rise:
                createSunriseView();
                break;
        }
    }


    private void initAnimator(){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mTextInput, View.TRANSLATION_Y, 0F, mSearchBox.getHeight());
        anim1.setDuration(400L);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mLastTextInput, View.TRANSLATION_Y,  -mSearchBox.getHeight(), 0F);
        anim1.setDuration(500L);
//        anim1.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                mLastTextInput.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        anim1.start();
        anim2.start();
        if(mLastTextInput.getVisibility() != View.VISIBLE)
            mLastTextInput.setVisibility(View.VISIBLE);
        isFirst = false;
    }

    private void secondAnimator(){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mLastTextInput, View.TRANSLATION_Y, 0F, mSearchBox.getHeight());
        anim1.setDuration(400L);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mTextInput, View.TRANSLATION_Y,  -mSearchBox.getHeight(), 0F);
        anim1.setDuration(500L);
        anim1.start();
        anim2.start();
        isFirst = true;
    }

    private void createPlaneView(){
        GamePlaneView gamePlaneView = new GamePlaneView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        }, "Harry", "Harry");
        mContainer.addView(gamePlaneView);
        gamePlaneView.a();
    }

    private void createFlowerView(){
        CherryFlowerView cherryFlowerView = new CherryFlowerView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(cherryFlowerView);
        cherryFlowerView.b();
    }

    private void createValentinesView() {
        ValentinesDayView valentinesDayView = new ValentinesDayView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(valentinesDayView);
        valentinesDayView.start();
    }

    private void createTravelWorldView() {
        TravelWorld travelWorldView = new TravelWorld(MainActivity.this, new GiftDisplayListener() {//TravelWorldView
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(travelWorldView);
        travelWorldView.start();
    }

    private void createReunionDinnerView(){
        ReunionDinnerView reunionDinnerView = new ReunionDinnerView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(reunionDinnerView);
        reunionDinnerView.b();
    }

    private void createRabbitEggView(){
        RabbitAndEggView rabbitAndEggView = new RabbitAndEggView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(rabbitAndEggView);
        rabbitAndEggView.start();
    }

    private void createClosetView(){
        FantasyClosetView fantasyClosetView = new FantasyClosetView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(fantasyClosetView);
        fantasyClosetView.start();
    }


    private void createFallenView(){
        FallenAngelView fallenAngelView = new FallenAngelView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(fallenAngelView);
        fallenAngelView.start();
    }

    private void createRocketsView(){
        RocketsLaunchingView rocketsLaunchingView = new RocketsLaunchingView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(rocketsLaunchingView);
        rocketsLaunchingView.start();
    }

    private void createMeteorRainView(){
         MeteorRainView meteorRainView = new MeteorRainView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(meteorRainView);
        meteorRainView.start();
    }

    private void createWeddingDressView(){
        WeddingDressView weddingDressView = new WeddingDressView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(weddingDressView);
        weddingDressView.start();
    }

    private void createMilkyWayView(){
        HerdBoyAndSpinningGirlView herdBoyAndSpinningGirlView = new HerdBoyAndSpinningGirlView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(herdBoyAndSpinningGirlView);
        herdBoyAndSpinningGirlView.start();
    }

    private void createSkyWheelView(){
        SkyWheelView skyWheelView = new SkyWheelView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(skyWheelView);
        skyWheelView.start();
    }

    private void createSwordView(){
        GuardSwordView guardSwordView = new GuardSwordView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(guardSwordView);
        guardSwordView.start();
    }
    private void createLoveBondView(){
        LoveBondView loveBondView = new LoveBondView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(loveBondView);
        loveBondView.start();
    }

    private void createHolyCaneView(){
        HolyCaneView loveBondView = new HolyCaneView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(loveBondView);
        loveBondView.start();
    }

    private void createWorldTuorView(){
        WorldTourView worldTourView = new WorldTourView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(worldTourView);
        worldTourView.start();
    }

    private void createSunriseView(){
        SunriseView sunriseView = new SunriseView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(sunriseView);
        sunriseView.start();
    }

    private void createPinkSeaView(){
        PinkSeaView pinkSeaView = new PinkSeaView(MainActivity.this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(pinkSeaView);
//        pinkSeaView.start();
    }

    private void createEnterRoomView(){
        EnterRoomEffectsView enterRoomEffectsView = new EnterRoomEffectsView(this, new GiftDisplayListener() {
            @Override
            public void a() {

            }

            @Override
            public void b() {
                mContainer.removeAllViews();
                mButtons.setVisibility(View.VISIBLE);
            }

            @Override
            public void c() {

            }
        });
        mContainer.addView(enterRoomEffectsView);
        enterRoomEffectsView.start();
    }

    /**
     * 复制asset文件到指定目录
     * @param oldPath  asset下的路径
     * @param newPath  SD卡下保存路径
     */
    public static void CopyAssets(Context context, String oldPath, String newPath) {
        try {
            String fileNames[] = context.getAssets().list(oldPath);// 获取assets目录下的所有文件及目录名
            if (fileNames.length > 0) {// 如果是目录
                File file = new File(newPath);
                file.mkdirs();// 如果文件夹不存在，则递归
                for (String fileName : fileNames) {
                    CopyAssets(context, oldPath + "/" + fileName, newPath + "/" + fileName);
                }
            } else {// 如果是文件
                InputStream is = context.getAssets().open(oldPath);
                if(!new File(newPath).getParentFile().exists())
                    new File(newPath).getParentFile().mkdirs();
                if(!new File(newPath).exists())
                    new File(newPath).createNewFile();
                FileOutputStream fos = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                int byteCount = 0;
                while ((byteCount = is.read(buffer)) != -1) {// 循环从输入流读取
                    // buffer字节
                    fos.write(buffer, 0, byteCount);// 将读取的输入流写入到输出流
                }
                fos.flush();// 刷新缓冲区
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
