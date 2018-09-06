package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

/**
 * Created by haiwang on 2017/6/7.
 */

public class TravelWorldEarthView extends View {
    private Bitmap mWorldEarthBitmap;
    private Context mContext;
    private Paint mPaint;
    private Rect mRect;

    public TravelWorldEarthView(Context context) {
        super(context);
        init();
    }

    public TravelWorldEarthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TravelWorldEarthView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setVisibility(INVISIBLE);
        this.mContext = getContext();
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mPaint.setFilterBitmap(true);
        this.mWorldEarthBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.travel_world_earth);
        this.mRect = new Rect(0, 0, ScreenUtil.b(mContext, 700.0F), ScreenUtil.b(mContext, 700.0F));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mWorldEarthBitmap, null, mRect, null);
    }
}

