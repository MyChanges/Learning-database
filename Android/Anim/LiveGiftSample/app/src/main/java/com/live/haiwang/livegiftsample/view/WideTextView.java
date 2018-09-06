package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by haiwang on 2017/9/18.
 */

public class WideTextView extends View {

    private Paint mTextPaint;
    private String mContent;

    public WideTextView(Context context) {
        super(context);
    }

    public WideTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.RED);
        mTextPaint.setTextSize(50);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mContent, 0, 0,mTextPaint );
    }

    public void setText(String content){
        this.mContent = content;
        float width = mTextPaint.measureText(content);

        invalidate();
    }

}
