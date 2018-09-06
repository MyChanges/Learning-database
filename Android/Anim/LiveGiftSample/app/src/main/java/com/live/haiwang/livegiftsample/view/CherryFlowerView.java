package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by haiwang on 2017/6/30.
 */

public class CherryFlowerView extends CustomBaseViewRelative
        implements Animator.AnimatorListener
{
    public static final String a = CherryFlowerView.class.getSimpleName();
    ObjectAnimator A;
    ObjectAnimator B;
    ObjectAnimator C;
    ObjectAnimator D;
    ObjectAnimator E;
    ObjectAnimator F;
    ObjectAnimator G;
    ObjectAnimator H;
    ObjectAnimator I;
    ObjectAnimator J;
    ObjectAnimator K;
    ObjectAnimator L;
    ObjectAnimator M;
    ObjectAnimator N;
    ObjectAnimator O;
    ObjectAnimator P;
    ObjectAnimator Q;
    private int RR;
    private int S;
    private RelativeLayout T;
    private ImageView U;
    private ImageView V;
    private ImageView W;
    private ImageView aA;
    private ImageView aB;
    private ImageView aC;
    private ImageView aD;
    private ImageView aE;
    private SimpleDraweeView aF;
    private SimpleDraweeView aG;
    private boolean aH = false;
    private GiftDisplayListener aI;
    private ImageView aa;
    private ImageView ab;
    private ImageView ac;
    private RelativeLayout ad;
    private ImageView ae;
    private ImageView af;
    private ImageView ag;
    private ImageView ah;
    private ImageView ai;
    private ImageView aj;
    private ImageView ak;
    private ImageView al;
    private ImageView am;
    private ImageView an;
    private ImageView ao;
    private ImageView ap;
    private ImageView aq;
    private ImageView ar;
    private ImageView as;
    private ImageView at;
    private ImageView au;
    private ImageView av;
    private ImageView aw;
    private ArrayList<ImageView> ax;
    private ArrayList<ImageView> ay;
    private RelativeLayout az;
    AnimatorSet b;
    ObjectAnimator c;
    ObjectAnimator d;
    ObjectAnimator e;
    ObjectAnimator f;
    ObjectAnimator g;
    ObjectAnimator h;
    ObjectAnimator i;
    ObjectAnimator j;
    ObjectAnimator k;
    ObjectAnimator l;
    ObjectAnimator m;
    ObjectAnimator n;
    ObjectAnimator o;
    ObjectAnimator p;
    ObjectAnimator q;
    ObjectAnimator r;
    ObjectAnimator s;
    ObjectAnimator t;
    ObjectAnimator u;
    ObjectAnimator v;
    ObjectAnimator w;
    ObjectAnimator x;
    ObjectAnimator y;
    ObjectAnimator z;

    public CherryFlowerView(Context paramContext, GiftDisplayListener parama)
    {
        super(paramContext);
        this.aI = parama;
    }

    private void a(View paramView, boolean paramBoolean) {
        float f1;
        if (paramBoolean) {
            f1 = 16.0F;
            paramView.setPivotY(paramView.getMeasuredHeight() / 2);
            paramView.setPivotX(paramView.getMeasuredWidth());
        } else {
            f1 = -16.0F;
            paramView.setPivotY(paramView.getMeasuredHeight() / 2);
            paramView.setPivotX(0.0F);
        }
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ROTATION, 0.0F, f1);
        localObjectAnimator.setInterpolator(new LinearInterpolator());
        localObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        localObjectAnimator.setRepeatCount(-1);
        localObjectAnimator.setStartDelay(1000L);
        localObjectAnimator.setDuration(1000L);
        ObjectAnimator aaa = ObjectAnimator.ofFloat(paramView, SCALE_Y, 1.0F, 0.95F);
        aaa.setInterpolator(new LinearInterpolator());
        aaa.setRepeatMode(ValueAnimator.REVERSE);
        aaa.setRepeatCount(-1);
        localObjectAnimator.setStartDelay(1000L);
        aaa.setDuration(1000L);
        localObjectAnimator.start();
        aaa.start();
    }

    private void e()
    {
        this.b = new AnimatorSet();
        this.T.measure(0, 0);
        this.c = ObjectAnimator.ofFloat(this.T, ALPHA, new float[] { 0.0F, 1.0F });
        this.c.setInterpolator(new LinearInterpolator());
        this.c.setDuration(500L);
        this.d = ObjectAnimator.ofFloat(this.U, ALPHA, new float[] { 0.0F, 1.0F });
        this.d.setInterpolator(new LinearInterpolator());
        this.d.setDuration(300L);
        this.e = ObjectAnimator.ofFloat(this.V, ALPHA, new float[] { 0.0F, 1.0F });
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setDuration(300L);
        this.f = ObjectAnimator.ofFloat(this.U, ROTATION, new float[] { 0.0F, -2.0F, 1.0F });
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setRepeatMode(ValueAnimator.REVERSE);
        this.f.setRepeatCount(-1);
        this.f.setDuration(3000L);
        this.U.setPivotY(0.0F);
        this.U.setPivotX(this.U.getMeasuredWidth());
        this.g = ObjectAnimator.ofFloat(this.V, ROTATION, new float[] { 0.0F, 1.0F, -2.0F });
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setRepeatMode(ValueAnimator.REVERSE);
        this.g.setRepeatCount(-1);
        this.g.setDuration(3000L);
        this.V.setPivotY(0.0F);
        this.V.setPivotX(this.V.getMeasuredWidth());
        this.h = ObjectAnimator.ofFloat(this.W, TRANSLATION_Y, new float[] { this.W.getTop(), this.W.getTop() + ScreenUtil.b(getContext(), 10.0F)});
        this.h.setInterpolator(new LinearInterpolator());
        this.h.setRepeatMode(ValueAnimator.REVERSE);
        this.h.setRepeatCount(-1);
        this.h.setDuration(5000L);
        this.i = ObjectAnimator.ofFloat(this.aa, TRANSLATION_Y, new float[] { this.aa.getTop() + ScreenUtil.b(getContext(), 10.0F) });
        this.i.setInterpolator(new LinearInterpolator());
        this.i.setRepeatMode(ValueAnimator.REVERSE);
        this.i.setRepeatCount(-1);
        this.i.setDuration(5000L);
        this.j = ObjectAnimator.ofFloat(this.W, ALPHA, new float[] { 1.0F, 0.0F });
        this.j.setInterpolator(new LinearInterpolator());
        this.j.setRepeatMode(ValueAnimator.REVERSE);
        this.j.setRepeatCount(-1);
        this.j.setDuration(1000L);
        this.k = ObjectAnimator.ofFloat(this.aa, ALPHA, new float[] { 0.0F, 1.0F });
        this.k.setInterpolator(new LinearInterpolator());
        this.k.setRepeatMode(ValueAnimator.REVERSE);
        this.k.setRepeatCount(-1);
        this.k.setDuration(1000L);
        this.l = ObjectAnimator.ofFloat(this.ab, ROTATION, new float[] { 30.0F, 70.0F });
        this.l.setInterpolator(new LinearInterpolator());
        this.l.setRepeatMode(ValueAnimator.REVERSE);
        this.l.setRepeatCount(-1);
        this.l.setDuration(500L);
        this.ab.setPivotY(this.ab.getMeasuredHeight() / 2);
        this.ab.setPivotX(this.ab.getMeasuredWidth());
        this.m = ObjectAnimator.ofFloat(this.ab, SCALE_Y, new float[] { 1.0F, 0.7F });
        this.m.setInterpolator(new LinearInterpolator());
        this.m.setRepeatMode(ValueAnimator.REVERSE);
        this.m.setRepeatCount(-1);
        this.m.setDuration(500L);
        this.n = ObjectAnimator.ofFloat(this.ac, ROTATION, new float[] { -30.0F, -70.0F });
        this.n.setInterpolator(new LinearInterpolator());
        this.n.setRepeatMode(ValueAnimator.REVERSE);
        this.n.setRepeatCount(-1);
        this.n.setDuration(500L);
        this.ac.setPivotY(this.ac.getMeasuredHeight() / 2);
        this.ac.setPivotX(0.0F);
        this.o = ObjectAnimator.ofFloat(this.ac, SCALE_Y, new float[] { 1.0F, 0.7F });
        this.o.setInterpolator(new LinearInterpolator());
        this.o.setRepeatMode(ValueAnimator.REVERSE);
        this.o.setRepeatCount(-1);
        this.o.setDuration(500L);
        this.p = ObjectAnimator.ofFloat(this.ad, TRANSLATION_Y, new float[] { this.S, this.S / 6 });
        this.p.setInterpolator(new LinearInterpolator());
        this.p.setStartDelay(1000L);
        this.p.setDuration(3500L);
        this.q = ObjectAnimator.ofFloat(this.ad, TRANSLATION_Y, new float[] { this.S / 6, -this.ad.getMeasuredHeight() });
        this.q.setInterpolator(new LinearInterpolator());
        this.q.setDuration(1200L);
        this.r = ObjectAnimator.ofFloat(this.ae, ALPHA, new float[] { 0.0F, 1.0F });
        this.r.setInterpolator(new LinearInterpolator());
        this.r.setRepeatMode(ValueAnimator.REVERSE);
        this.r.setRepeatCount(-1);
        this.r.setDuration(1000L);
        this.s = ObjectAnimator.ofFloat(this.af, ALPHA, new float[] { 1.0F, 0.0F });
        this.s.setInterpolator(new LinearInterpolator());
        this.s.setRepeatMode(ValueAnimator.REVERSE);
        this.s.setRepeatCount(-1);
        this.s.setDuration(1000L);
        this.t = ObjectAnimator.ofFloat(this.ag, SCALE_X, new float[] { 0.0F, 1.0F });
        this.t.setInterpolator(new LinearInterpolator());
        this.t.setDuration(600L);
        this.u = ObjectAnimator.ofFloat(this.ag, SCALE_Y, new float[] { 0.0F, 1.0F });
        this.u.setInterpolator(new LinearInterpolator());
        this.u.setDuration(600L);
        this.v = ObjectAnimator.ofFloat(this.ah, SCALE_X, new float[] { 0.6F, 1.0F });
        this.v.setInterpolator(new LinearInterpolator());
        this.v.setDuration(600L);
        this.w = ObjectAnimator.ofFloat(this.ah, SCALE_Y, new float[] { 0.6F, 1.0F });
        this.w.setInterpolator(new LinearInterpolator());
        this.w.setDuration(600L);
        this.x = ObjectAnimator.ofFloat(this.ai, SCALE_X, new float[] { 0.6F, 1.0F });
        this.x.setInterpolator(new LinearInterpolator());
        this.x.setDuration(600L);
        this.y = ObjectAnimator.ofFloat(this.ai, SCALE_Y, new float[] { 0.6F, 1.0F });
        this.y.setInterpolator(new LinearInterpolator());
        this.y.setDuration(600L);
        this.z = ObjectAnimator.ofFloat(this.aj, SCALE_X, new float[] { 0.0F, 1.0F });
        this.z.setInterpolator(new LinearInterpolator());
        this.z.setStartDelay(200L);
        this.z.setDuration(400L);
        this.A = ObjectAnimator.ofFloat(this.ak, SCALE_X, new float[] { 0.0F, 1.0F });
        this.A.setInterpolator(new LinearInterpolator());
        this.A.setStartDelay(200L);
        this.A.setDuration(400L);
        this.B = ObjectAnimator.ofFloat(this.al, SCALE_X, new float[] { 0.0F, 1.0F });
        this.B.setInterpolator(new LinearInterpolator());
        this.B.setStartDelay(200L);
        this.B.setDuration(400L);
        this.C = ObjectAnimator.ofFloat(this.am, TRANSLATION_Y, new float[] { this.S, 0.0F });
        this.C.setInterpolator(new LinearInterpolator());
        this.C.setDuration(1200L);
        this.D = ObjectAnimator.ofFloat(this.az, TRANSLATION_Y, new float[] { -this.az.getMeasuredHeight(), ScreenUtil.b(getContext(), 80.0F)});
        this.D.setInterpolator(new DecelerateInterpolator());
        this.D.setStartDelay(500L);
        this.D.setDuration(2000L);
        this.E = ObjectAnimator.ofFloat(this.az, TRANSLATION_Y, new float[] { ScreenUtil.b(getContext(), 80.0F), ScreenUtil.b(getContext(), 50.0F), ScreenUtil.b(getContext(), 80.0F) });
        this.E.setRepeatMode(ValueAnimator.REVERSE);
        this.E.setRepeatCount(-1);
        this.E.setInterpolator(new LinearInterpolator());
        this.E.setDuration(2000L);
        this.F = ObjectAnimator.ofFloat(this.aA, ROTATION, new float[] { 0.0F, 112.0F });
        this.F.setInterpolator(new LinearInterpolator());
        this.F.setDuration(3000L);
        this.G = ObjectAnimator.ofFloat(this.aA, SCALE_X, new float[] { 1.0F, 1.638F });
        this.G.setInterpolator(new LinearInterpolator());
        this.G.setDuration(3000L);
        this.H = ObjectAnimator.ofFloat(this.aA, SCALE_Y, new float[] { 1.0F, 1.638F });
        this.H.setInterpolator(new LinearInterpolator());
        this.H.setDuration(3000L);
        this.I = ObjectAnimator.ofFloat(this.aB, ALPHA, new float[] { 0.0F, 1.0F });
        this.I.setInterpolator(new LinearInterpolator());
        this.I.setRepeatMode(ValueAnimator.REVERSE);
        this.I.setRepeatCount(-1);
        this.I.setDuration(1000L);
        this.J = ObjectAnimator.ofFloat(this.aB, TRANSLATION_Y, new float[] { this.aB.getTop(), this.aB.getTop() + ScreenUtil.b(getContext(), 15.0F)});
        this.J.setInterpolator(new LinearInterpolator());
        this.J.setRepeatMode(ValueAnimator.REVERSE);
        this.J.setRepeatCount(-1);
        this.J.setDuration(1000L);
        this.K = ObjectAnimator.ofFloat(this.aC, ALPHA, new float[] { 1.0F, 0.0F });
        this.K.setInterpolator(new LinearInterpolator());
        this.K.setRepeatMode(ValueAnimator.REVERSE);
        this.K.setRepeatCount(-1);
        this.K.setDuration(1000L);
        this.L = ObjectAnimator.ofFloat(this.aC, TRANSLATION_Y, new float[] { this.aC.getTop() + ScreenUtil.b(getContext(), 20.0F), this.aC.getTop() });
        this.L.setInterpolator(new LinearInterpolator());
        this.L.setRepeatMode(ValueAnimator.REVERSE);
        this.L.setRepeatCount(-1);
        this.L.setDuration(1000L);
        this.M = ObjectAnimator.ofFloat(this.aD, SCALE_X, new float[] { 1.0F, 0.95F });
        this.M.setInterpolator(new LinearInterpolator());
        this.M.setRepeatMode(ValueAnimator.REVERSE);
        this.M.setRepeatCount(-1);
        this.M.setDuration(1000L);
        this.N = ObjectAnimator.ofFloat(this.aE, SCALE_X, new float[] { 1.0F, 0.95F });
        this.N.setInterpolator(new LinearInterpolator());
        this.N.setRepeatMode(ValueAnimator.REVERSE);
        this.N.setRepeatCount(-1);
        this.N.setDuration(1000L);
        this.O = ObjectAnimator.ofFloat(this.U, ALPHA, new float[] { 1.0F, 0.0F });
        this.O.setInterpolator(new LinearInterpolator());
        this.O.setStartDelay(2300L);
        this.O.setDuration(200L);
        this.P = ObjectAnimator.ofFloat(this.V, ALPHA, new float[] { 1.0F, 0.0F });
        this.P.setInterpolator(new LinearInterpolator());
        this.P.setStartDelay(2300L);
        this.P.setDuration(200L);
        this.Q = ObjectAnimator.ofFloat(this.T, ALPHA, new float[] { 1.0F, 0.0F });
        this.Q.setInterpolator(new LinearInterpolator());
        this.Q.setStartDelay(200L);
        this.Q.setDuration(300L);
        f();
        g();
        if (this.aI != null)
        {
//            InKeLog.a(a, "onAnimationReady mListener != null");
            this.aI.a();
        }
    }

    private void f()
    {
        this.ax = new ArrayList();
        this.ay = new ArrayList();
        this.ax.add(this.an);
        this.ax.add(this.ao);
        this.ax.add(this.ap);
        this.ax.add(this.aq);
        this.ax.add(this.ar);
        this.ay.add(this.as);
        this.ay.add(this.at);
        this.ay.add(this.au);
        this.ay.add(this.av);
        this.ay.add(this.aw);
    }

    private void g()
    {
        this.p.addListener(this);
        this.t.addListener(this);
        this.v.addListener(this);
        this.x.addListener(this);
        this.z.addListener(this);
        this.A.addListener(this);
        this.B.addListener(this);
        this.C.addListener(this);
        this.D.addListener(this);
        this.I.addListener(this);
        this.Q.addListener(this);
        this.f.addListener(this);
    }

    protected void a()
    {
        this.T = ((RelativeLayout)findViewById(R.id.cherry_flower_cherry_container));
        this.U = ((ImageView)findViewById(R.id.cherry_flower_tree_a));
        this.V = ((ImageView)findViewById(R.id.cherry_flower_tree_b));
        this.W = ((ImageView)findViewById(R.id.cherry_flower_tree_heart_a));
        this.aa = ((ImageView)findViewById(R.id.cherry_flower_tree_heart_b));
        this.ab = ((ImageView)findViewById(R.id.cherry_flower_left_wing));
        this.ac = ((ImageView)findViewById(R.id.cherry_flower_right_wing));
        this.ad = ((RelativeLayout)findViewById(R.id.portrait_container));
        this.ae = ((ImageView)findViewById(R.id.cherry_flower_portrait_light_a));
        this.af = ((ImageView)findViewById(R.id.cherry_flower_portrait_light_b));
        this.ag = ((ImageView)findViewById(R.id.cherry_flower_stage_a));
        this.ah = ((ImageView)findViewById(R.id.cherry_flower_stage_b));
        this.ai = ((ImageView)findViewById(R.id.cherry_flower_stage_c));
        this.aj = ((ImageView)findViewById(R.id.cherry_flower_stage_light_a));
        this.ak = ((ImageView)findViewById(R.id.cherry_flower_stage_light_b));
        this.al = ((ImageView)findViewById(R.id.cherry_flower_stage_light_c));
        this.am = ((ImageView)findViewById(R.id.cherry_flower_stage_light_all));
        this.an = ((ImageView)findViewById(R.id.cherry_flower_girl_left_wing_a));
        this.ao = ((ImageView)findViewById(R.id.cherry_flower_girl_left_wing_b));
        this.ap = ((ImageView)findViewById(R.id.cherry_flower_girl_left_wing_c));
        this.aq = ((ImageView)findViewById(R.id.cherry_flower_girl_left_wing_d));
        this.ar = ((ImageView)findViewById(R.id.cherry_flower_girl_left_wing_e));
        this.as = ((ImageView)findViewById(R.id.cherry_flower_girl_right_wing_a));
        this.at = ((ImageView)findViewById(R.id.cherry_flower_girl_right_wing_b));
        this.au = ((ImageView)findViewById(R.id.cherry_flower_girl_right_wing_c));
        this.av = ((ImageView)findViewById(R.id.cherry_flower_girl_right_wing_d));
        this.aw = ((ImageView)findViewById(R.id.cherry_flower_girl_right_wing_e));
        this.az = ((RelativeLayout)findViewById(R.id.cherry_flower_girl_container));
        this.aA = ((ImageView)findViewById(R.id.cherry_flower_girl_flower));
        this.aB = ((ImageView)findViewById(R.id.cherry_flower_girl_light_a));
        this.aC = ((ImageView)findViewById(R.id.cherry_flower_girl_light_b));
        this.aD = ((ImageView)findViewById(R.id.cherry_flower_girl_clothes_a));
        this.aE = ((ImageView)findViewById(R.id.cherry_flower_girl_clothes_b));
        this.aF = ((SimpleDraweeView)findViewById(R.id.cherry_flower_creator));
        this.aG = ((SimpleDraweeView)findViewById(R.id.cherry_flower_sender));
//        this.RR = com.meelive.ingkee.base.utils.c.l().a();
//        this.S = com.meelive.ingkee.base.utils.c.l().b();
        this.S = ScreenUtil.b(getContext());
        e();
    }

//    public void a(String paramString1, String paramString2)
//    {
//        if (!TextUtils.isEmpty(paramString2)) {
//            b.b(paramString2, this.aF, 0, 70, 70);
//        }
//        if (!TextUtils.isEmpty(paramString1)) {
//            b.b(paramString1, this.aG, 0, 70, 70);
//        }
//    }

    public void b()
    {
        if (this.aH) {
            return;
        }
        if (this.aI != null) {
            this.aI.a();
        }
        this.aH = true;
        this.b.play(this.c);
        this.b.play(this.d).with(this.e).after(this.c);
        this.b.play(this.f).with(this.g).with(this.h).with(this.j).with(this.i).with(this.k).with(this.l).with(this.m).with(this.n).with(this.o).with(this.r).with(this.s).with(this.p).after(this.c);
        this.b.play(this.q).after(this.p);
        this.b.play(this.t).with(this.u).with(this.z).after(this.q);
        this.b.play(this.v).with(this.w).with(this.A).after(this.t);
        this.b.play(this.x).with(this.y).with(this.B).after(this.v);
        this.b.play(this.C).after(this.v);
        this.b.play(this.D).after(this.v);
        this.b.play(this.E).after(this.D);
        this.b.play(this.F).with(this.G).with(this.H).after(this.D);
        this.b.play(this.I).with(this.K).with(this.J).with(this.L).after(this.D);
        this.b.play(this.M).with(this.N).after(this.D);
        this.b.play(this.O).with(this.P).after(this.D);
        this.b.play(this.Q).after(this.O);
        Iterator<ImageView> localIterator = this.ax.iterator();
        while (localIterator.hasNext()) {
            a(localIterator.next(), true);
        }
        localIterator = this.ay.iterator();
        while (localIterator.hasNext()) {
            a(localIterator.next(), false);
        }
        this.b.start();
    }

    public void c()
    {
        this.aH = false;
        d();
    }

    public void d()
    {
        this.aH = false;
        if (this.f != null)
        {
            this.f.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        if (this.g != null)
        {
            this.g.removeAllListeners();
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null)
        {
            this.h.removeAllListeners();
            this.h.cancel();
            this.h = null;
        }
        if (this.j != null)
        {
            this.j.removeAllListeners();
            this.j.cancel();
            this.j = null;
        }
        if (this.i != null)
        {
            this.i.removeAllListeners();
            this.i.cancel();
            this.i = null;
        }
        if (this.k != null)
        {
            this.k.removeAllListeners();
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null)
        {
            this.l.removeAllListeners();
            this.l.cancel();
            this.l = null;
        }
        if (this.m != null)
        {
            this.m.removeAllListeners();
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null)
        {
            this.n.removeAllListeners();
            this.n.cancel();
            this.n = null;
        }
        if (this.o != null)
        {
            this.o.removeAllListeners();
            this.o.cancel();
            this.o = null;
        }
        if (this.r != null)
        {
            this.r.removeAllListeners();
            this.r.cancel();
            this.r = null;
        }
        if (this.s != null)
        {
            this.s.removeAllListeners();
            this.s.cancel();
            this.s = null;
        }
        if (this.p != null)
        {
            this.p.removeAllListeners();
            this.p.cancel();
            this.p = null;
        }
        if (this.q != null)
        {
            this.q.removeAllListeners();
            this.q.cancel();
            this.q = null;
        }
        if (this.t != null)
        {
            this.t.removeAllListeners();
            this.t.cancel();
            this.t = null;
        }
        if (this.u != null)
        {
            this.u.removeAllListeners();
            this.u.cancel();
            this.u = null;
        }
        if (this.z != null)
        {
            this.z.removeAllListeners();
            this.z.cancel();
            this.z = null;
        }
        if (this.v != null)
        {
            this.v.removeAllListeners();
            this.v.cancel();
            this.v = null;
        }
        if (this.w != null)
        {
            this.w.removeAllListeners();
            this.w.cancel();
            this.w = null;
        }
        if (this.A != null)
        {
            this.A.removeAllListeners();
            this.A.cancel();
            this.A = null;
        }
        if (this.x != null)
        {
            this.x.removeAllListeners();
            this.x.cancel();
            this.x = null;
        }
        if (this.y != null)
        {
            this.y.removeAllListeners();
            this.y.cancel();
            this.y = null;
        }
        if (this.B != null)
        {
            this.B.removeAllListeners();
            this.B.cancel();
            this.B = null;
        }
        if (this.C != null)
        {
            this.C.removeAllListeners();
            this.C.cancel();
            this.C = null;
        }
        if (this.D != null)
        {
            this.D.removeAllListeners();
            this.D.cancel();
            this.D = null;
        }
        if (this.E != null)
        {
            this.E.removeAllListeners();
            this.E.cancel();
            this.E = null;
        }
        if (this.F != null)
        {
            this.F.removeAllListeners();
            this.F.cancel();
            this.F = null;
        }
        if (this.G != null)
        {
            this.G.removeAllListeners();
            this.G.cancel();
            this.G = null;
        }
        if (this.H != null)
        {
            this.H.removeAllListeners();
            this.H.cancel();
            this.H = null;
        }
        if (this.I != null)
        {
            this.I.removeAllListeners();
            this.I.cancel();
            this.I = null;
        }
        if (this.K != null)
        {
            this.K.removeAllListeners();
            this.K.cancel();
            this.K = null;
        }
        if (this.J != null)
        {
            this.J.removeAllListeners();
            this.J.cancel();
            this.J = null;
        }
        if (this.L != null)
        {
            this.L.removeAllListeners();
            this.L.cancel();
            this.L = null;
        }
        if (this.M != null)
        {
            this.M.removeAllListeners();
            this.M.cancel();
            this.M = null;
        }
        if (this.N != null)
        {
            this.N.removeAllListeners();
            this.N.cancel();
            this.N = null;
        }
        if (this.Q != null)
        {
            this.Q.removeAllListeners();
            this.Q.cancel();
            this.Q = null;
        }
        if (this.aI != null) {
            this.aI.b();
        }
    }

    protected int getLayoutId()
    {
        return R.layout.gift_cherry_flower_anchor;
    }

    public void onAnimationCancel(Animator paramAnimator) {}

    public void onAnimationEnd(Animator paramAnimator)
    {
        if (paramAnimator.equals(this.Q)) {
            d();
        }
    }

    public void onAnimationRepeat(Animator paramAnimator) {}

    public void onAnimationStart(Animator paramAnimator)
    {
        if (paramAnimator.equals(this.f))
        {
            this.U.setVisibility(VISIBLE);
            this.V.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.p)) {
            this.ad.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.t)) {
            this.ag.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.v)) {
            this.ah.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.x)) {
            this.ai.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.z)) {
            this.aj.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.A)) {
            this.ak.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.B)) {
            this.al.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.C)) {
            this.am.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.D)) {
            this.az.setVisibility(VISIBLE);
        }
        if (paramAnimator.equals(this.I))
        {
            this.aB.setVisibility(VISIBLE);
            this.aC.setVisibility(VISIBLE);
        }
    }
}

