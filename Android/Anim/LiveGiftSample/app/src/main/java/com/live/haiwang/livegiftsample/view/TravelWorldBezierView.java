package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiwang on 2017/6/7.
 */

public class TravelWorldBezierView extends View {

    private static final String a = TravelWorldBezierView.class.getSimpleName();
    private Path mFireBalloonPath;
    private Path mParachuteLeftPath;
    private Path mParachuteRightPath;
    private int mScreenWidth;
    private int mScreenHeight;
    private Context mContext;
    private List<Point> h = new ArrayList();
    private List<Point> i = new ArrayList();
    private List<Point> j = new ArrayList();
    private List<Point> k = new ArrayList();
    private List<Point> l = new ArrayList();
    private List<Point> m = new ArrayList();
    private List<Point> n = new ArrayList();
    private List<Point> o = new ArrayList();
    private List<Point> p = new ArrayList();
    private List<Point> q = new ArrayList();
    private List<Point> r = new ArrayList();
    private List<Point> s = new ArrayList();

    public TravelWorldBezierView(Context context) {
        super(context);
        a(context);
    }

    public TravelWorldBezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    private void a(Context context) {
        this.mContext = context;
        this.mScreenWidth = ScreenUtil.a(this.mContext);
        this.mScreenHeight = ScreenUtil.b(this.mContext);
        this.mFireBalloonPath = new Path();
        this.mParachuteLeftPath = new Path();
        this.mParachuteRightPath = new Path();
        b();
        a(this.h, this.k);
        b(this.k, this.n);
        a(this.h, this.k, this.n, this.q);
        a(this.i, this.l);
        b(this.l, this.o);
        a(this.i, this.l, this.o, this.r);
        a(this.j, this.m);
        b(this.m, this.p);
        a(this.j, this.m, this.p, this.s);
    }

    private void a(Canvas paramCanvas, List<Point> paramList1, List<Point> paramList2) {
        if (mFireBalloonPath == null) {
            return;
        }
        mFireBalloonPath.reset();
        mFireBalloonPath.moveTo(paramList1.get(0).x, paramList1.get(0).y);
        mFireBalloonPath.quadTo(paramList2.get(0).x, paramList2.get(0).y, paramList1.get(1).x, paramList1.get(1).y);
        mFireBalloonPath.cubicTo(paramList2.get(1).x, paramList2.get(1).y, paramList2.get(2).x, paramList2.get(2).y, paramList1.get(2).x, paramList1.get(2).y);
        mFireBalloonPath.quadTo(paramList2.get(paramList2.size() - 1).x, paramList2.get(paramList2.size() - 1).y, paramList1.get(3).x, paramList1.get(3).y);
        mFireBalloonPath.quadTo(paramList1.get(3).x - ScreenUtil.b(getContext(), 50.0F), paramList1.get(3).y - ScreenUtil.b(getContext(), 50.0F), paramList1.get(3).x - ScreenUtil.b(getContext(), 50.0F), -ScreenUtil.b(getContext(), 180.0F));
        Log.d(a, "dp2px:" + ScreenUtil.b(getContext(), 12.0F));
    }

    public static void a(List<Point> paramList1, List<Point> paramList2) {
        int i1 = 0;
        for (;;) {
            if ((i1 >= paramList1.size()) || (i1 == paramList1.size() - 1)) {
                return;
            }
            int i2 = paramList1.get(i1).x;
            i2 = (paramList1.get(i1 + 1).x + i2) / 2;
            int i3 = paramList1.get(i1).y;
            paramList2.add(new Point(i2, (paramList1.get(i1 + 1).y + i3) / 2));
            i1 += 1;
        }
    }

    public static void a(List<Point> paramList1, List<Point> paramList2, List<Point> paramList3, List<Point> paramList4) {
        int i1 = 0;
        while (i1 < paramList1.size()){
            if (i1 != 0 && i1 != paramList1.size() - 1) {
                Point localPoint1 = new Point();
                Point localPoint2 = new Point();
                int i2 = paramList1.get(i1).x;
                int i3 = paramList3.get(i1 - 1).x;
                localPoint1.x = paramList2.get(i1 - 1).x + (i2 - i3);
                i2 = paramList1.get(i1).y;
                i3 = paramList3.get(i1 - 1).y;
                localPoint1.y = paramList2.get(i1 - 1).y + (i2 - i3);
                i2 = paramList1.get(i1).x;
                i3 = paramList3.get(i1 - 1).x;
                localPoint2.x = paramList2.get(i1).x + (i2 - i3);
                i2 = paramList1.get(i1).y;
                i3 = paramList3.get(i1 - 1).y;
                localPoint2.y = paramList2.get(i1).y + (i2 - i3);
                paramList4.add(localPoint1);
                paramList4.add(localPoint2);
            }
            i1 += 1;
        }
    }

    private void b(){
        int i1 = mScreenHeight * 2 / 3;
        Point localPoint = new Point(-mScreenWidth * 2 / 5, mScreenHeight * 8 / 11);
        this.h.add(localPoint);
        localPoint = new Point(mScreenWidth / 3, mScreenHeight * 7 / 15);
        this.h.add(localPoint);
        localPoint = new Point(mScreenWidth * 19 / 21, mScreenHeight * 7 / 15);
        this.h.add(localPoint);
        localPoint = new Point(mScreenWidth * 3 / 4, mScreenHeight / 6);
        this.h.add(localPoint);
        localPoint = new Point(mScreenWidth / 4, -ScreenUtil.b(getContext(), 120.0F));
        this.i.add(localPoint);
        localPoint = new Point(mScreenWidth * 1 / 5, mScreenHeight / 4);
        this.i.add(localPoint);
        localPoint = new Point(mScreenWidth * 2 / 7, mScreenHeight * 3 / 5);
        this.i.add(localPoint);
        localPoint = new Point(mScreenWidth / 6, mScreenHeight);
        this.i.add(localPoint);
        localPoint = new Point(mScreenWidth * 5 / 7, -ScreenUtil.b(getContext(), 120.0F));
        this.j.add(localPoint);
        localPoint = new Point(mScreenWidth * 4 / 5, mScreenHeight / 4);
        this.j.add(localPoint);
        localPoint = new Point(mScreenWidth * 3 / 5, mScreenHeight * 3 / 5);
        this.j.add(localPoint);
        localPoint = new Point(mScreenWidth * 3 / 5, mScreenHeight);
        this.j.add(localPoint);
    }

    private void b(Canvas paramCanvas, List<Point> paramList1, List<Point> paramList2) {
        if (mParachuteLeftPath == null) {
            return;
        }
        mParachuteLeftPath.reset();
        mParachuteLeftPath.moveTo(paramList1.get(0).x, paramList1.get(0).y);
        mParachuteLeftPath.quadTo(paramList2.get(0).x, paramList2.get(0).y, paramList1.get(1).x, paramList1.get(1).y);
        mParachuteLeftPath.cubicTo(paramList2.get(1).x, paramList2.get(1).y, paramList2.get(2).x, paramList2.get(2).y, paramList1.get(2).x, paramList1.get(2).y);
        mParachuteLeftPath.quadTo(paramList2.get(paramList2.size() - 1).x, paramList2.get(paramList2.size() - 1).y, paramList1.get(3).x, paramList1.get(3).y);
        mParachuteLeftPath.lineTo(paramList1.get(3).x, paramList1.get(3).y + ScreenUtil.b(getContext(), 80.0F));
    }

    public static void b(List<Point> paramList1, List<Point> paramList2) {
        int i1 = 0;
        for (;;){
            if ((i1 >= paramList1.size()) || (i1 == paramList1.size() - 1)) {
                return;
            }
            int i2 = paramList1.get(i1).x;
            i2 = (paramList1.get(i1 + 1).x + i2) / 2;
            int i3 = paramList1.get(i1).y;
            paramList2.add(new Point(i2, (paramList1.get(i1 + 1).y + i3) / 2));
            i1 += 1;
        }
    }

    private void c(Canvas paramCanvas, List<Point> paramList1, List<Point> paramList2){
        if (mParachuteRightPath == null) {
            return;
        }
        mParachuteRightPath.reset();
        mParachuteRightPath.moveTo(paramList1.get(0).x, paramList1.get(0).y);
        mParachuteRightPath.quadTo(paramList2.get(0).x, paramList2.get(0).y, paramList1.get(1).x, paramList1.get(1).y);
        mParachuteRightPath.cubicTo(paramList2.get(1).x, paramList2.get(1).y, paramList2.get(2).x, paramList2.get(2).y, paramList1.get(2).x, paramList1.get(2).y);
        mParachuteRightPath.quadTo(paramList2.get(paramList2.size() - 1).x, paramList2.get(paramList2.size() - 1).y, paramList1.get(3).x, paramList1.get(3).y);
        mParachuteRightPath.lineTo(paramList1.get(3).x, paramList1.get(3).y + ScreenUtil.b(getContext(), 80.0F));
    }

    public void a(){
        this.mContext = null;
        this.mFireBalloonPath = null;
        this.mParachuteLeftPath = null;
        this.mParachuteRightPath = null;
    }

    public Path getFireBalloonPath(){
        return mFireBalloonPath;
    }

    public Path getParachuteLeftPath(){
        return mParachuteLeftPath;
    }

    public Path getParachuteRightPath(){
        return mParachuteRightPath;
    }

    @Override
    public void onDraw(Canvas canvas){
        a(canvas, this.h, this.q);
        b(canvas, this.i, this.r);
        c(canvas, this.j, this.s);
    }

}

