package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/6/27.
 */

public class RoundAngleFrameLayout extends FrameLayout {
    private float a;
    private float b;
    private float c;
    private float d;
    private Paint e;
    private Paint f;

    public RoundAngleFrameLayout(Context paramContext) {
        this(paramContext, null);
    }

    public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (paramAttributeSet != null) {
            TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundAngleFrameLayout);
            float f1 = typedArray.getDimension(R.styleable.RoundAngleFrameLayout_ra_radius, 0.0F);
            this.a = typedArray.getDimension(R.styleable.RoundAngleFrameLayout_topLeftRadius, f1);
            this.b = typedArray.getDimension(R.styleable.RoundAngleFrameLayout_topRightRadius, f1);
            this.c = typedArray.getDimension(R.styleable.RoundAngleFrameLayout_bottomLeftRadius, f1);
            this.d = typedArray.getDimension(R.styleable.RoundAngleFrameLayout_bottomRightRadius, f1);
            typedArray.recycle();
        }
        this.e = new Paint();
        this.e.setColor(-1);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f = new Paint();
        this.f.setXfermode(null);
    }

    private void a(Canvas paramCanvas) {
        if (this.a > 0.0F) {
            Path localPath = new Path();
            localPath.moveTo(0.0F, this.a);
            localPath.lineTo(0.0F, 0.0F);
            localPath.lineTo(this.a, 0.0F);
            localPath.arcTo(new RectF(0.0F, 0.0F, this.a * 2.0F, this.a * 2.0F), -90.0F, -90.0F);
            localPath.close();
            paramCanvas.drawPath(localPath, this.e);
        }
    }

    private void b(Canvas paramCanvas) {
        if (this.b > 0.0F) {
            int i = getWidth();
            Path localPath = new Path();
            localPath.moveTo(i - this.b, 0.0F);
            localPath.lineTo(i, 0.0F);
            localPath.lineTo(i, this.b);
            localPath.arcTo(new RectF(i - this.b * 2.0F, 0.0F, i, this.b * 2.0F), 0.0F, -90.0F);
            localPath.close();
            paramCanvas.drawPath(localPath, this.e);
        }
    }

    private void c(Canvas paramCanvas) {
        if (this.c > 0.0F) {
            int i = getHeight();
            Path localPath = new Path();
            localPath.moveTo(0.0F, i - this.c);
            localPath.lineTo(0.0F, i);
            localPath.lineTo(this.c, i);
            localPath.arcTo(new RectF(0.0F, i - this.c * 2.0F, this.c * 2.0F, i), 90.0F, 90.0F);
            localPath.close();
            paramCanvas.drawPath(localPath, this.e);
        }
    }

    private void d(Canvas paramCanvas) {
        if (this.d > 0.0F) {
            int i = getHeight();
            int j = getWidth();
            Path localPath = new Path();
            localPath.moveTo(j - this.d, i);
            localPath.lineTo(j, i);
            localPath.lineTo(j, i - this.d);
            localPath.arcTo(new RectF(j - this.d * 2.0F, i - this.d * 2.0F, j, i), 0.0F, 90.0F);
            localPath.close();
            paramCanvas.drawPath(localPath, this.e);
        }
    }

    @Override
    protected void dispatchDraw(Canvas paramCanvas) {
        paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.f, Canvas.ALL_SAVE_FLAG);
        super.dispatchDraw(paramCanvas);
        a(paramCanvas);
        b(paramCanvas);
        c(paramCanvas);
        d(paramCanvas);
        paramCanvas.restore();
    }
}

