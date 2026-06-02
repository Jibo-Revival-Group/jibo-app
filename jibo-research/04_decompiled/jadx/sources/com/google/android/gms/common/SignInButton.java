package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbx;
import com.google.android.gms.common.internal.zzby;

/* JADX INFO: loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private int f6079a;

    /* JADX INFO: renamed from: b */
    private int f6080b;

    /* JADX INFO: renamed from: c */
    private View f6081c;

    /* JADX INFO: renamed from: d */
    private View.OnClickListener f6082d;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6082d = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.f6079a = typedArrayObtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.f6080b = typedArrayObtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            typedArrayObtainStyledAttributes.recycle();
            m6847a(this.f6079a, this.f6080b);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m6847a(int i, int i2) {
        this.f6079a = i;
        this.f6080b = i2;
        Context context = getContext();
        if (this.f6081c != null) {
            removeView(this.f6081c);
        }
        try {
            this.f6081c = zzbx.m7390a(context, this.f6079a, this.f6080b);
        } catch (com.google.android.gms.dynamic.zzq e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f6079a;
            int i4 = this.f6080b;
            zzby zzbyVar = new zzby(context);
            zzbyVar.m7394a(context.getResources(), i3, i4);
            this.f6081c = zzbyVar;
        }
        addView(this.f6081c);
        this.f6081c.setEnabled(isEnabled());
        this.f6081c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f6082d == null || view != this.f6081c) {
            return;
        }
        this.f6082d.onClick(this);
    }

    public final void setColorScheme(int i) {
        m6847a(this.f6079a, i);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6081c.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6082d = onClickListener;
        if (this.f6081c != null) {
            this.f6081c.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        m6847a(this.f6079a, this.f6080b);
    }

    public final void setSize(int i) {
        m6847a(i, this.f6080b);
    }
}
