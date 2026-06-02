package com.salesforce.android.knowledge.p022ui.internal.util;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.salesforce.android.knowledge.p022ui.R;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedOnClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private ValueAnimator f13413a;

    /* JADX INFO: renamed from: b */
    private final int f13414b;

    /* JADX INFO: renamed from: c */
    private final int f13415c;

    /* JADX INFO: renamed from: d */
    private final int f13416d;

    /* JADX INFO: renamed from: e */
    private final View.OnClickListener f13417e;

    private AnimatedOnClickListener(Context context, View.OnClickListener onClickListener) {
        int iM1840c = ContextCompat.m1840c(context, R.color.salesforce_brand_secondary);
        int iArgb = Color.argb(63, Color.red(iM1840c), Color.green(iM1840c), Color.blue(iM1840c));
        this.f13414b = 0;
        this.f13415c = iArgb;
        this.f13416d = 300;
        this.f13417e = onClickListener;
    }

    /* JADX INFO: renamed from: a */
    public static AnimatedOnClickListener m13687a(Context context, View.OnClickListener onClickListener) {
        return new AnimatedOnClickListener(context, onClickListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(final View view) {
        if (this.f13413a != null) {
            this.f13413a.cancel();
        }
        this.f13413a = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f13415c), Integer.valueOf(this.f13414b));
        this.f13413a.setDuration(this.f13416d);
        this.f13413a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.salesforce.android.knowledge.ui.internal.util.AnimatedOnClickListener.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f13413a.start();
        if (this.f13417e != null) {
            this.f13417e.onClick(view);
        }
    }
}
