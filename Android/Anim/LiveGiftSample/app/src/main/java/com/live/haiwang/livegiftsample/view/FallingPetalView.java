package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by haiwang on 2017/6/29.
 */

public class FallingPetalView extends View {

    private static final String TAG = "FallingPetalView";
    // 中等振幅大小
    private static final int MIDDLE_AMPLITUDE = 13;
    // 不同类型之间的振幅差距
    private static final int AMPLITUDE_DISPARITY = 5;

    // 花瓣飘动一个周期所花的时间
    private static final long PETAL_FLOAT_TIME = 4000;
    // 花瓣旋转一周需要的时间
    private static final long PETAL_ROTATE_TIME = 2000;
    // 中等振幅大小
    private int mMiddleAmplitude = MIDDLE_AMPLITUDE;
    // 振幅差
    private int mAmplitudeDisparity = AMPLITUDE_DISPARITY;
    // 花瓣飘动一个周期所花的时间
    private long mPetalFloatTime = PETAL_FLOAT_TIME;
    // 花瓣旋转一周需要的时间
    private long mPetalRotateTime = PETAL_ROTATE_TIME;
    private Resources mResources;
//    private Bitmap mPetalBitmap;
    private List<Bitmap> mPetalBitmaps;
//    private int mPetalWidth, mPetalHeight;

    private int mTotalWidth, mTotalHeight;
    private Paint mBitmapPaint;
    // 产生出的花瓣信息
    private List<Petal> mPetalInfos;
    private List<Petal> mAccumulatedPetals;
    private int mAccumulatedLayer;
    private int mCurLeftSide;
    // 用于控制随机增加的时间不抱团
    private int mAddTime;

    public FallingPetalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mResources = getResources();
        mPetalFloatTime = PETAL_FLOAT_TIME;
        mPetalRotateTime = PETAL_ROTATE_TIME;
        initBitmap();
        initPaint();
        PetalFactory petalFactory = new PetalFactory();
        mPetalInfos = petalFactory.generatePetals();
        mAccumulatedPetals = new ArrayList<>();
    }

    private void initPaint() {
        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setDither(true);
        mBitmapPaint.setFilterBitmap(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPetals(canvas);
        postInvalidate();
    }

    /**
     * 绘制花瓣
     */
    private void drawPetals(Canvas canvas) {
        mPetalRotateTime = mPetalRotateTime <= 0 ? PETAL_ROTATE_TIME : mPetalRotateTime;
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < mPetalInfos.size(); i++) {
            Petal petal = mPetalInfos.get(i);
            if (currentTime > petal.startTime && petal.startTime != 0) {
                // 绘制花瓣－－根据花瓣的类型和当前时间得出花瓣的（x，y）
                getPetalLocation(petal, currentTime);
                // 根据时间计算旋转角度
                canvas.save();
                // 通过Matrix控制花瓣旋转
                Matrix matrix = new Matrix();
                float transX = petal.x;
                float transY = petal.y;
//                Log.i(TAG, "left.x = " + petal.x + "--petal.y=" + petal.y);
                matrix.postTranslate(transX, transY);
                // 通过时间关联旋转角度，则可以直接通过修改PETAL_ROTATE_TIME调节花瓣旋转快慢
                float rotateFraction = ((currentTime - petal.startTime) % mPetalRotateTime) / (float) mPetalRotateTime;
                int angle = (int) (rotateFraction * 360);
                // 根据花瓣旋转方向确定花瓣旋转角度
                int rotate = petal.rotateDirection == 0 ? angle + petal.rotateAngle : -angle + petal.rotateAngle;
                matrix.postRotate(rotate, transX + petal.width / 2, transY + petal.height / 2);
                canvas.drawBitmap(petal.bitmap, matrix, mBitmapPaint);
                canvas.restore();
            }
        }
//        for (int i = 0; i < mAccumulatedPetals.size(); i++) {
//            Petal petal = mAccumulatedPetals.get(i);
//            canvas.save();
//            // 通过Matrix控制花瓣旋转
//            Matrix matrix = new Matrix();
//            float transX = petal.x;
//            float transY = petal.y;
////            Log.i(TAG, "--petal.y=" + petal.y);
//            matrix.postTranslate(transX, transY);
//            // 通过时间关联旋转角度，则可以直接通过修改PETAL_ROTATE_TIME调节花瓣旋转快慢
//            float rotateFraction = ((currentTime - petal.startTime) % mPetalRotateTime) / (float) mPetalRotateTime;
//            int angle = (int) (rotateFraction * 360);
//            // 根据花瓣旋转方向确定花瓣旋转角度
//            int rotate = petal.rotateDirection == 0 ? angle + petal.rotateAngle : -angle + petal.rotateAngle;
//            matrix.postRotate(petal.rotateAngle, transX + petal.width / 2, transY + petal.height / 2);
//            canvas.drawBitmap(petal.bitmap, matrix, mBitmapPaint);
//            canvas.restore();
//        }
    }

    private void getPetalLocation(Petal petal, long currentTime) {
        long intervalTime = currentTime - petal.startTime;
        mPetalFloatTime = mPetalFloatTime <= 0 ? PETAL_FLOAT_TIME : mPetalFloatTime;
        if (intervalTime < 0) return;
        if (intervalTime > mPetalFloatTime) {
            petal.startTime = System.currentTimeMillis() + new Random().nextInt((int) mPetalFloatTime);
        }
        float fraction = (float) intervalTime / mPetalFloatTime;
        petal.x = getLocationX(petal);
        petal.y = mTotalHeight * fraction;

        if(mAccumulatedLayer == 0 && petal.y >= mTotalHeight - ScreenUtil.b(getContext(), 18) && petal.x >= mCurLeftSide) {
            mAccumulatedPetals.add(new Petal(petal));
            mCurLeftSide += ScreenUtil.b(getContext(), 5);
            if(mCurLeftSide > mTotalWidth)
                mCurLeftSide = 0;
            if(mAccumulatedPetals.size() >= 30) {
                mAccumulatedLayer = 1;
                Log.i(TAG,  ";layer " + mAccumulatedLayer);
            }
        }
        if(mAccumulatedLayer == 1 && petal.y >= mTotalHeight - ScreenUtil.b(getContext(), 36) && petal.x >= mCurLeftSide) {
            mAccumulatedPetals.add(new Petal(petal));
            mCurLeftSide += ScreenUtil.b(getContext(), 5);
            if(mCurLeftSide > mTotalWidth)
                mCurLeftSide = 0;
            if(mAccumulatedPetals.size() >= 55) {
                mAccumulatedLayer = 2;
                Log.i(TAG, ";layer " + mAccumulatedLayer);
            }
        }
        if(mAccumulatedLayer == 2 && petal.y >= mTotalHeight - ScreenUtil.b(getContext(), 54) && petal.x >= mCurLeftSide) {
            mAccumulatedPetals.add(new Petal(petal));
            mCurLeftSide += ScreenUtil.b(getContext(), 5);
            if(mCurLeftSide > mTotalWidth)
                mCurLeftSide = 0;
            if(mAccumulatedPetals.size() >= 75) {
                mAccumulatedLayer = -1;
                Log.i(TAG,  ";layer " + mAccumulatedLayer);
            }
        }
    }

    // 通过花瓣信息获取当前花瓣的X值
    private int getLocationX(Petal petal) {
        // x = A(hx+Q)+w
        float h = (float) ((float) 2 * Math.PI / mTotalHeight);
        float a = mMiddleAmplitude;
        switch (petal.type) {
            case LITTLE:
                // 小振幅 ＝ 中等振幅 － 振幅差
                a = mMiddleAmplitude - mAmplitudeDisparity;
                break;
            case MIDDLE:
                a = mMiddleAmplitude;
                break;
            case BIG:
                // 小振幅 ＝ 中等振幅 + 振幅差
                a = mMiddleAmplitude + mAmplitudeDisparity;
                break;
            default:
                break;
        }
//        Log.i(TAG, "---a = " + a + "---w = " + h + "--petal.startX = " + petal.startX);
        return (int) (a * Math.sin(h * petal.y) + petal.startX);
    }

    private void initBitmap() {
//        mPetalBitmap = ((BitmapDrawable) mResources.getDrawable(R.mipmap.leaf)).getBitmap();
//        mPetalWidth = mPetalBitmap.getWidth();
//        mPetalHeight = mPetalBitmap.getHeight();
        mPetalBitmaps = new ArrayList<>();
        mPetalBitmaps.add(((BitmapDrawable) mResources.getDrawable(R.mipmap.petal_01)).getBitmap());
        mPetalBitmaps.add(((BitmapDrawable) mResources.getDrawable(R.mipmap.petal_02)).getBitmap());
        mPetalBitmaps.add(((BitmapDrawable) mResources.getDrawable(R.mipmap.petal_03)).getBitmap());
        mPetalBitmaps.add(((BitmapDrawable) mResources.getDrawable(R.mipmap.petal_04)).getBitmap());
//        mOuterBitmap = ((BitmapDrawable) mResources.getDrawable(R.drawable.leaf_kuang)).getBitmap();
//        mOuterWidth = mOuterBitmap.getWidth();
//        mOuterHeight = mOuterBitmap.getHeight();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTotalWidth = w;
        mTotalHeight = h;
        if(mPetalInfos == null || w <= 0) return;
        Random random = new Random();
        for(int i = 0; i < mPetalInfos.size(); i++)
            mPetalInfos.get(i).startX = random.nextInt(w);
    }

    private enum StartType {
        LITTLE, MIDDLE, BIG
    }

    /**
     * 花瓣对象，用来记录花瓣主要数据
     */
    private class Petal{
        // 在绘制部分的位置
        float x, y;
        int width, height;
        int startX;
        Bitmap bitmap;
        // 控制花瓣飘动的幅度
        StartType type;
        // 旋转角度
        int rotateAngle;
        // 旋转方向--0代表顺时针，1代表逆时针
        int rotateDirection;
        // 起始时间(ms)
        long startTime;
        Petal(){

        }
        Petal(Petal p){
            x = p.x;
            y = p.y;
            width = p.width;
            height = p.height;
            startX = p.startX;
            bitmap = p.bitmap;
            type = p.type;
            rotateAngle = p.rotateAngle;
            rotateDirection = p.rotateDirection;
            startTime = p.startTime;
        }

    }

    private class PetalFactory {
        private static final int MAX_PETALS = 150;
        Random random = new Random();
        // 生成一个花瓣信息
        Petal generatePetal() {
            Petal petal = new Petal();
            int randomType = random.nextInt(3);
            // 随时类型－ 随机振幅
            StartType type = StartType.MIDDLE;
            switch (randomType) {
                case 0:
                    break;
                case 1:
                    type = StartType.LITTLE;
                    break;
                case 2:
                    type = StartType.BIG;
                    break;
                default:
                    break;
            }
            petal.type = type;
            petal.bitmap = mPetalBitmaps.get((int)(mPetalBitmaps.size() * Math.random()));
            petal.width = petal.bitmap.getWidth();
            petal.height = petal.bitmap.getHeight();
            // 随机起始的旋转角度
            petal.rotateAngle = random.nextInt(360);
            // 随机旋转方向（顺时针或逆时针）
            petal.rotateDirection = random.nextInt(2);
            // 为了产生交错的感觉，让开始的时间有一定的随机性
            mPetalFloatTime = mPetalFloatTime <= 0 ? PETAL_FLOAT_TIME : mPetalFloatTime;
            mAddTime += random.nextInt((int)mPetalFloatTime);
            petal.startTime = System.currentTimeMillis() + mAddTime / 20;
            return petal;
        }

        // 根据最大花瓣数产生花瓣信息
        List<Petal> generatePetals() {
            return generatePetals(MAX_PETALS);
        }

        // 根据传入的花瓣数量产生花瓣信息
        List<Petal> generatePetals(int petalSize) {
            List<Petal> petals = new LinkedList<>();
            for (int i = 0; i < petalSize; i++) {
                petals.add(generatePetal());
            }
            return petals;
        }
    }

    /**
     * 设置中等振幅
     */
    public void setMiddleAmplitude(int amplitude) {
        this.mMiddleAmplitude = amplitude;
    }

    /**
     * 设置振幅差
     */
    public void setMplitudeDisparity(int disparity) {
        this.mAmplitudeDisparity = disparity;
    }

    /**
     * 获取中等振幅
     */
    public int getMiddleAmplitude() {
        return mMiddleAmplitude;
    }

    /**
     * 获取振幅差
     */
    public int getMplitudeDisparity() {
        return mAmplitudeDisparity;
    }

    /**
     * 设置花瓣飘完一个周期所花的时间
     */
    public void setPetalFloatTime(long time) {
        this.mPetalFloatTime = time;
    }

    /**
     * 设置花瓣旋转一周所花的时间
     */
    public void setPetalRotateTime(long time) {
        this.mPetalRotateTime = time;
    }

    /**
     * 获取花瓣飘完一个周期所花的时间
     */
    public long getPetalFloatTime() {
        mPetalFloatTime = mPetalFloatTime == 0 ? PETAL_FLOAT_TIME : mPetalFloatTime;
        return mPetalFloatTime;
    }

    /**
     * 获取花瓣旋转一周所花的时间
     */
    public long getPetalRotateTime() {
        mPetalRotateTime = mPetalRotateTime == 0 ? PETAL_ROTATE_TIME : mPetalRotateTime;
        return mPetalRotateTime;
    }

}

