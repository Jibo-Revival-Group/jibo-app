package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a */
    private int f4500a;

    /* JADX INFO: renamed from: b */
    private int f4501b;

    /* JADX INFO: renamed from: c */
    private WeakReference<View> f4502c;

    /* JADX INFO: renamed from: d */
    private LayoutInflater f4503d;

    /* JADX INFO: renamed from: e */
    private OnInflateListener f4504e;

    public interface OnInflateListener {
        /* JADX INFO: renamed from: a */
        void m5029a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4500a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i, 0);
        this.f4501b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f4500a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f4501b;
    }

    public void setInflatedId(int i) {
        this.f4501b = i;
    }

    public int getLayoutResource() {
        return this.f4500a;
    }

    public void setLayoutResource(int i) {
        this.f4500a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4503d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4503d;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f4502c != null) {
            View view = this.f4502c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m5028a();
        }
    }

    /* JADX INFO: renamed from: a */
    public View m5028a() {
        LayoutInflater layoutInflaterFrom;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            if (this.f4500a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (this.f4503d != null) {
                    layoutInflaterFrom = this.f4503d;
                } else {
                    layoutInflaterFrom = LayoutInflater.from(getContext());
                }
                View viewInflate = layoutInflaterFrom.inflate(this.f4500a, viewGroup, false);
                if (this.f4501b != -1) {
                    viewInflate.setId(this.f4501b);
                }
                int iIndexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
                } else {
                    viewGroup.addView(viewInflate, iIndexOfChild);
                }
                this.f4502c = new WeakReference<>(viewInflate);
                if (this.f4504e != null) {
                    this.f4504e.m5029a(this, viewInflate);
                }
                return viewInflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f4504e = onInflateListener;
    }
}
