package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by haiwang on 2017/8/15.
 */

public class FallingEffectView extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap mBitmap;
    private Paint mPaint;
    private Rect rangeRect = new Rect();
    private SurfaceHolder mHolder;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private LinkedList<Coin> coinContainer = new LinkedList<>();
    private int coinCount = 20;
    private boolean isLeft;
    private Random timeRandom = new Random(System.currentTimeMillis());

    public FallingEffectView(Context context) {
        super(context);
        init();
    }

    public FallingEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FallingEffectView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        getHolder().addCallback(this);
        mPaint = new Paint();
        mPaint.setFlags(Paint.FILTER_BITMAP_FLAG);
    }

    //Mark:cancel task!!!
    private void draw() {
        Canvas canvas = mHolder.lockCanvas();
        if (canvas == null)
            return;
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mPaint.reset();
        for (Coin coin : coinContainer) {
            mPaint.setAlpha(coin.getAlpha());
            if (coin.getCachedBitmap() != null)
                canvas.drawBitmap(coin.getCachedBitmap(), coin.getSrcRect(), coin.getCurRect(), mPaint);
        }
        mHolder.unlockCanvasAndPost(canvas);
    }

    private void generateCoins() {
        //可以使用Random随机生成数量
        for (int i = 0; i < coinCount; i++) {
            Coin coin = new Coin(mBitmap, rangeRect.right, rangeRect.bottom, true);
            coinContainer.add(coin);
        }
    }

    public void setLeft(boolean left){
        this.isLeft = left;
    }

    public void setResource(int resId, String resPath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (TextUtils.isEmpty(resPath))
            mBitmap = BitmapFactory.decodeResource(getResources(), resId, options);
        else
            mBitmap = BitmapFactory.decodeFile(resPath, options);
    }

    public void setCount(int count){
        this.coinCount = count;
    }

    public void start() {
        setVisibility(View.VISIBLE);
        if (mTimer == null) {
            mTimer = new Timer();
        }
        if (mTimerTask == null)
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    if (mHolder == null)
                        return;
                    draw();
                    for (Coin coin : coinContainer) {
                        coin.fall();
                    }
                }
            };
        mTimer.schedule(mTimerTask, 1000L, 20L);
    }

    public void recycle() {
        if (!mBitmap.isRecycled()) {
            mBitmap.recycle();
        }
        mBitmap = null;
    }

    public void stop() {
        setVisibility(View.GONE);
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
        if (mTimer != null) {
            mTimer.cancel();
            mTimer.purge();
            mTimer = null;
        }
        coinContainer.clear();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.mHolder = holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        rangeRect.set(0, 0, width, height);
        generateCoins();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.mHolder = null;
    }

    private class Coin {

        private WeakReference<Bitmap> bitmapRef;
        private int curX = 0;
        private int curY = 0;
        private int width = 0;
        private int height = 0;
        private int dstX = 0;
        private int dstY = 0;
        private int xUnit = 3;
        private int yUnit = 2;
        private int alpha = 255;
        private Rect srcRect;
        private Rect curRect;

        Coin(Bitmap bitmap, int x, int y) {
            bitmapRef = new WeakReference<>(bitmap);
            if (bitmap != null) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
            }
            this.dstX = x;
            this.dstY = y;
            this.srcRect = new Rect(0, 0, width, height);
            this.curRect = new Rect();
        }

        Coin(Bitmap bitmap, int x, int y, boolean random) {
            this(bitmap, x, y);
            if (random) {
//                this.curX = dstX / 3 + timeRandom.nextInt(5) * width / 2;
                this.curY = -timeRandom.nextInt(y / 5);
                this.xUnit = timeRandom.nextInt(5) + 1;
                int margin = ScreenUtil.b(getContext(), 35);
                if(isLeft){
                    this.curX = margin * 2 + timeRandom.nextInt(x);
                    this.yUnit = timeRandom.nextInt(12) + 6;
                }else {
                    this.curX = margin + timeRandom.nextInt(x - margin * 3);
                    this.yUnit = timeRandom.nextInt(3) + 6;
                }
                this.alpha = timeRandom.nextInt(135) + 120;
            }
        }

        void fall() {
            if(isLeft)
            this.curX -= xUnit;
            this.curY += yUnit;
//            yUnit++;
            if ((curX > dstX - width) || (curY > dstY - height)) {
                bitmapRef.clear();
            }
        }

        public int getAlpha() {
            return alpha;
        }

        Rect getSrcRect() {
            return srcRect;
        }

        Rect getCurRect() {
            curRect.set(curX, curY, curX + width, curY + height);
            return curRect;
        }

        Bitmap getCachedBitmap() {
            return bitmapRef.get();
        }
    }

}
