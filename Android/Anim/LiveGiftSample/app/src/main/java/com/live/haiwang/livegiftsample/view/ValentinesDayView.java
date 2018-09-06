package com.live.haiwang.livegiftsample.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.util.ScreenUtil;

import java.util.Random;

/**
 * Created by haiwang on 2017/6/30.
 */

public class ValentinesDayView extends CustomBaseViewRelative implements Animator.AnimatorListener {
    public static final String a = ValentinesDayView.class.getSimpleName();
    private View A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private boolean H = false;
    private GiftDisplayListener I;
    private int J = 2;
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
    private int q;
    private int r;
    private View s;
    private TextView t;
    private View u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private View z;

    public ValentinesDayView(Context paramContext, GiftDisplayListener parama) {
        super(paramContext);
        this.I = parama;
    }

    private void a(View paramView) {
        Object localObject = new Random();
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, TRANSLATION_Y, this.C.getTop() - paramView.getTop() + ScreenUtil.b(getContext(), 100.0F), 0 - ScreenUtil.b(getContext(), 125.0F));
        localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
        localObjectAnimator1.setDuration(((Random) localObject).nextInt(1000) + 600);
        localObject = ObjectAnimator.ofFloat(paramView, SCALE_X, 0.0F, 1.5F);
        ((ObjectAnimator) localObject).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) localObject).setDuration(1000L);
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, SCALE_Y, 0.0F, 1.5F);
        localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
        localObjectAnimator2.setDuration(1000L);
        paramView.setVisibility(VISIBLE);
        ((ObjectAnimator) localObject).start();
        localObjectAnimator2.start();
        localObjectAnimator1.start();
    }

    private void a(ImageView[] imageViews) {
        Random random = new Random();
        for (int i = 0; i < imageViews.length; i++) {
            ImageView imageView = imageViews[i];
            if (imageView != null) {
                int i3 = ScreenUtil.b(getContext(), 160.0F);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(imageView, TRANSLATION_Y, this.C.getTop() - imageView.getTop() + ScreenUtil.b(getContext(), 100.0F), 0 - i3);
                localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
                localObjectAnimator1.setDuration(random.nextInt(1000) + 600);
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(imageView, SCALE_X, 0.0F, 1.5F);
                localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
                localObjectAnimator2.setDuration(1000L);
                ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(imageView, SCALE_Y, 0.0F, 1.5F);
                localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
                localObjectAnimator3.setDuration(1000L);
                imageView.setVisibility(VISIBLE);
                localObjectAnimator2.start();
                localObjectAnimator3.start();
                localObjectAnimator1.start();
            }
        }
    }

    private void e() {
        this.s.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        this.b = new AnimatorSet();
        this.c = ObjectAnimator.ofFloat(this.t, TRANSLATION_X, -this.t.getMeasuredWidth() - ScreenUtil.b(this.aN, 100.0F), this.t.getMeasuredWidth() - ScreenUtil.b(this.aN, 5.0F));
        this.c.setInterpolator(new DecelerateInterpolator());
        this.c.setDuration(800L);
        this.d = ObjectAnimator.ofFloat(this.u, TRANSLATION_Y, this.r, this.r - ScreenUtil.b(getContext(), 640.0F));
        this.d.setInterpolator(new LinearInterpolator());
        this.d.setDuration(1500L);
        this.e = ObjectAnimator.ofFloat(this.v, ALPHA, 1.0F, 0.0F);
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setRepeatCount(ValueAnimator.INFINITE);
        this.e.setRepeatMode(ValueAnimator.REVERSE);
        this.e.setDuration(500L);
        this.f = ObjectAnimator.ofFloat(this.w, ALPHA, 0.0F, 1.0F);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setRepeatCount(ValueAnimator.INFINITE);
        this.f.setRepeatMode(ValueAnimator.REVERSE);
        this.f.setDuration(500L);
        this.g = ObjectAnimator.ofFloat(this.x, ALPHA, 0.0F, 1.0F, 0.0F);
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setDuration(2000L);
        this.i = ObjectAnimator.ofFloat(this.y, ALPHA, 0.0F, 2.0F, 0.0F);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.setDuration(2000L);
        this.h = ObjectAnimator.ofFloat(this.y, ROTATION, -60.0F, 60.0F);
        this.y.setPivotY(this.y.getRotationY() + ScreenUtil.b(getContext(), 205.0F));
        this.y.setPivotX(this.q / 2 - ScreenUtil.b(getContext(), 10.0F));
        this.h.setInterpolator(new LinearInterpolator());
        this.h.setDuration(2000L);
        this.j = ObjectAnimator.ofFloat(this.z, TRANSLATION_X, -this.z.getMeasuredWidth(), this.q / 2 - this.z.getMeasuredWidth());
        this.j.setInterpolator(new AccelerateInterpolator());
        this.j.setStartDelay(600L);
        this.j.setDuration(1000L);
        this.k = ObjectAnimator.ofFloat(this.A, TRANSLATION_X, this.q - this.A.getMeasuredWidth(), this.q / 2 - this.A.getMeasuredWidth());
        this.k.setInterpolator(new AccelerateInterpolator());
        this.k.setStartDelay(600L);
        this.k.setDuration(1000L);
        this.l = ObjectAnimator.ofFloat(this.B, ALPHA, 1.0F, 1.0F);
        this.l.setDuration(100L);
        this.m = ObjectAnimator.ofFloat(this.z, TRANSLATION_X, this.q / 2 - this.z.getMeasuredWidth(), -this.z.getMeasuredWidth());
        this.m.setInterpolator(new LinearInterpolator());
        this.m.setDuration(1000L);
        this.n = ObjectAnimator.ofFloat(this.A, TRANSLATION_X, this.q / 2 - this.A.getMeasuredWidth(), this.q - this.A.getMeasuredWidth());
        this.n.setInterpolator(new LinearInterpolator());
        this.n.setDuration(1000L);
        this.o = ObjectAnimator.ofFloat(this.G, ALPHA, 0.0F, 1.0F, 0.0F);
        this.o.setInterpolator(new LinearInterpolator());
        this.o.setDuration(2000L);
        this.p = ObjectAnimator.ofFloat(this.s, ALPHA, 1.0F, 0.0F);
        this.p.setInterpolator(new LinearInterpolator());
        this.p.setStartDelay(1000L);
        this.p.setDuration(800L);
        if (this.I != null) {
//            InKeLog.a(a, "onAnimationReady mListener != null");
            this.I.a();
        }
        f();
    }

    private void f() {
        this.d.addListener(this);
        this.g.addListener(this);
        this.h.addListener(this);
        this.j.addListener(this);
        this.k.addListener(this);
        this.l.addListener(this);
        this.o.addListener(this);
        this.p.addListener(this);
    }

    @Override
    protected void a() {
        this.q = ScreenUtil.a(getContext());
        this.r = ScreenUtil.b(getContext());
        this.s = findViewById(R.id.valentines_day_container);
        this.t = ((TextView) findViewById(R.id.valentines_day_rose_sender));
        this.u = findViewById(R.id.valentines_day_rose_container);
        this.v = ((ImageView) findViewById(R.id.valentines_day_rose_light_a));
        this.w = ((ImageView) findViewById(R.id.valentines_day_rose_light_b));
        this.x = ((ImageView) findViewById(R.id.valentines_day_round_light_a));
        this.y = ((ImageView) findViewById(R.id.valentines_day_round_light_b));
        this.z = findViewById(R.id.valentines_day_left_cup_container);
        this.A = findViewById(R.id.valentines_day_right_cup_container);
        this.B = ((ImageView) findViewById(R.id.valentines_day_cheers_light));
        this.C = ((ImageView) findViewById(R.id.valentines_day_light_a));
        this.D = ((ImageView) findViewById(R.id.valentines_day_light_b));
        this.E = ((ImageView) findViewById(R.id.valentines_day_note_a));
        this.F = ((ImageView) findViewById(R.id.valentines_day_note_b));
        this.G = ((ImageView) findViewById(R.id.valentines_day_note_light));
        e();
    }

//    public void a(String paramString1, String paramString2){
//        if (!ah.b(paramString1)){
//            this.t.setVisibility(VISIBLE);
//            this.t.setText(paramString1 + ah.a(R.string.gift_send, new Object[0]) + paramString2);
//        }
//    }

    public void start() {
        if (this.H) {
            return;
        }
        if (this.I != null) {
            this.I.a();
        }
        this.H = true;
        this.b.play(this.d).with(this.e).with(this.f).with(this.c);
        this.b.play(this.g).with(this.h).with(this.i).with(this.j).with(this.k).after(this.d);
        this.b.play(this.l).after(this.j);
        this.b.start();
    }

    public void c() {
        this.H = false;
        d();
    }

    public void d() {
        this.H = false;
        if (this.b != null) {
            this.b.removeAllListeners();
            this.b.cancel();
            this.b = null;
        }
        if (this.d != null) {
            this.d.removeAllListeners();
            this.d.cancel();
            this.d = null;
        }
        if (this.e != null) {
            this.e.removeAllListeners();
            this.e.cancel();
            this.e = null;
        }
        if (this.f != null) {
            this.f.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        if (this.g != null) {
            this.g.removeAllListeners();
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h.removeAllListeners();
            this.h.cancel();
            this.h = null;
        }
        if (this.i != null) {
            this.i.removeAllListeners();
            this.i.cancel();
            this.i = null;
        }
        if (this.j != null) {
            this.j.removeAllListeners();
            this.j.cancel();
            this.j = null;
        }
        if (this.k != null) {
            this.k.removeAllListeners();
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null) {
            this.l.removeAllListeners();
            this.l.cancel();
            this.l = null;
        }
        if (this.m != null) {
            this.m.removeAllListeners();
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.removeAllListeners();
            this.n.cancel();
            this.n = null;
        }
        if (this.o != null) {
            this.o.removeAllListeners();
            this.o.cancel();
            this.o = null;
        }
        if (this.p != null) {
            this.p.removeAllListeners();
            this.p.cancel();
            this.p = null;
        }
        if (this.I != null) {
            this.I.b();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gift_valentines_days_rose;
    }

    @Override
    public void onAnimationCancel(Animator animation) {
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if (animation.equals(this.l)) {
            this.B.setVisibility(INVISIBLE);
            this.m.start();
            this.n.start();
            this.o.start();
            a(new ImageView[]{this.C, this.D, this.F});
            a(this.E);
            this.p.start();
        }
        if (animation.equals(this.p)) {
            d();
        }
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
    }

    @Override
    public void onAnimationStart(Animator animation) {
        if (animation.equals(this.d)) {
            this.u.setVisibility(VISIBLE);
        }
        if (animation.equals(this.g)) {
            this.x.setVisibility(VISIBLE);
        }
        if (animation.equals(this.h)) {
            this.y.setVisibility(VISIBLE);
        }
        if (animation.equals(this.j)) {
            this.z.setVisibility(VISIBLE);
        }
        if (animation.equals(this.k)) {
            this.A.setVisibility(VISIBLE);
        }
        if (animation.equals(this.l)) {
            this.B.setVisibility(VISIBLE);
        }
        if (animation.equals(this.o)) {
            this.G.setVisibility(VISIBLE);
        }
    }
}

