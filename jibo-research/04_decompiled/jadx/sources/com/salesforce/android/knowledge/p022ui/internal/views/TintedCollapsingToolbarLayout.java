package com.salesforce.android.knowledge.p022ui.internal.views;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceStyleHelper;

/* JADX INFO: loaded from: classes.dex */
public class TintedCollapsingToolbarLayout extends CollapsingToolbarLayout {

    /* JADX INFO: renamed from: e */
    private Toolbar f13438e;

    /* JADX INFO: renamed from: f */
    private ValueAnimator f13439f;

    /* JADX INFO: renamed from: g */
    private int f13440g;

    public TintedCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintedCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13440g = 16777215;
        SalesforceStyleHelper salesforceStyleHelperM13998a = SalesforceStyleHelper.m13998a(context, attributeSet);
        setExpandedTitleTypeface(salesforceStyleHelperM13998a.m14004b());
        setCollapsedTitleTypeface(salesforceStyleHelperM13998a.m14004b());
        setTitle(salesforceStyleHelperM13998a.m14002a(getTitle()));
    }

    @Override // android.support.design.widget.CollapsingToolbarLayout
    /* JADX INFO: renamed from: a */
    public void mo621a(boolean z, boolean z2) {
        super.mo621a(z, z2);
        int iM1840c = ContextCompat.m1840c(getContext(), z ? R.color.salesforce_toolbar_inverted : R.color.salesforce_brand_primary_inverted);
        if (z2) {
            m13712a(iM1840c);
        } else {
            setToolbarTint(iM1840c);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m13713c();
        super.onDraw(canvas);
    }

    @Override // android.support.design.widget.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m13713c();
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m13712a(int i) {
        if (this.f13439f == null) {
            this.f13439f = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f13440g), Integer.valueOf(i));
            this.f13439f.setDuration(600L);
            this.f13439f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.salesforce.android.knowledge.ui.internal.views.TintedCollapsingToolbarLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TintedCollapsingToolbarLayout.this.setToolbarTint(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.f13439f.isRunning()) {
            this.f13439f.cancel();
        }
        this.f13439f.setIntValues(this.f13440g, i);
        this.f13439f.start();
    }

    void setToolbarTint(int i) {
        if (this.f13438e != null) {
            this.f13440g = i;
            ViewUtil.m13716a(this.f13438e, i);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m13713c() {
        Toolbar toolbar;
        if (this.f13438e == null) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    toolbar = null;
                    break;
                }
                View childAt = getChildAt(i);
                if (!(childAt instanceof Toolbar)) {
                    i++;
                } else {
                    toolbar = (Toolbar) childAt;
                    break;
                }
            }
            this.f13438e = toolbar;
        }
    }
}
