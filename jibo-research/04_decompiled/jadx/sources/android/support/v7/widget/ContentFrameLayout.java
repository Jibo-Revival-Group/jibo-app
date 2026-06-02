package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private TypedValue f3778a;

    /* JADX INFO: renamed from: b */
    private TypedValue f3779b;

    /* JADX INFO: renamed from: c */
    private TypedValue f3780c;

    /* JADX INFO: renamed from: d */
    private TypedValue f3781d;

    /* JADX INFO: renamed from: e */
    private TypedValue f3782e;

    /* JADX INFO: renamed from: f */
    private TypedValue f3783f;

    /* JADX INFO: renamed from: g */
    private final Rect f3784g;

    /* JADX INFO: renamed from: h */
    private OnAttachListener f3785h;

    public interface OnAttachListener {
        /* JADX INFO: renamed from: a */
        void mo3325a();

        /* JADX INFO: renamed from: b */
        void mo3326b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3784g = new Rect();
    }

    /* JADX INFO: renamed from: a */
    public void m4045a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f3785h = onAttachListener;
    }

    /* JADX INFO: renamed from: a */
    public void m4044a(int i, int i2, int i3, int i4) {
        this.f3784g.set(i, i2, i3, i4);
        if (ViewCompat.m2621y(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0100  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.f3778a == null) {
            this.f3778a = new TypedValue();
        }
        return this.f3778a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f3779b == null) {
            this.f3779b = new TypedValue();
        }
        return this.f3779b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f3780c == null) {
            this.f3780c = new TypedValue();
        }
        return this.f3780c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f3781d == null) {
            this.f3781d = new TypedValue();
        }
        return this.f3781d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f3782e == null) {
            this.f3782e = new TypedValue();
        }
        return this.f3782e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f3783f == null) {
            this.f3783f = new TypedValue();
        }
        return this.f3783f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3785h != null) {
            this.f3785h.mo3325a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3785h != null) {
            this.f3785h.mo3326b();
        }
    }
}
