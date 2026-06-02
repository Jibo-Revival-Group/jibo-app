package com.salesforce.android.knowledge.p022ui.internal.views;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class InsetFrameLayout extends FrameLayout {
    public InsetFrameLayout(Context context) {
        super(context);
    }

    public InsetFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InsetFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ViewCompat.m2614r(this)) {
            ViewCompat.m2613q(this);
        }
    }
}
