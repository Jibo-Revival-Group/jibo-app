package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* JADX INFO: renamed from: a */
    protected final VisibilityAnimListener f3460a;

    /* JADX INFO: renamed from: b */
    protected final Context f3461b;

    /* JADX INFO: renamed from: c */
    protected ActionMenuView f3462c;

    /* JADX INFO: renamed from: d */
    protected ActionMenuPresenter f3463d;

    /* JADX INFO: renamed from: e */
    protected int f3464e;

    /* JADX INFO: renamed from: f */
    protected ViewPropertyAnimatorCompat f3465f;

    /* JADX INFO: renamed from: g */
    private boolean f3466g;

    /* JADX INFO: renamed from: h */
    private boolean f3467h;

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3460a = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f3461b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f3461b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.f3463d != null) {
            this.f3463d.m3729a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3466g = false;
        }
        if (!this.f3466g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3466g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3466g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3467h = false;
        }
        if (!this.f3467h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3467h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3467h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f3464e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f3464e;
    }

    public int getAnimatedVisibility() {
        return this.f3465f != null ? this.f3460a.f3468a : getVisibility();
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat mo3689a(int i, long j) {
        if (this.f3465f != null) {
            this.f3465f.m2760b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatM2753a = ViewCompat.m2608l(this).m2753a(1.0f);
            viewPropertyAnimatorCompatM2753a.m2754a(j);
            viewPropertyAnimatorCompatM2753a.m2755a(this.f3460a.m3691a(viewPropertyAnimatorCompatM2753a, i));
            return viewPropertyAnimatorCompatM2753a;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatM2753a2 = ViewCompat.m2608l(this).m2753a(CropImageView.DEFAULT_ASPECT_RATIO);
        viewPropertyAnimatorCompatM2753a2.m2754a(j);
        viewPropertyAnimatorCompatM2753a2.m2755a(this.f3460a.m3691a(viewPropertyAnimatorCompatM2753a2, i));
        return viewPropertyAnimatorCompatM2753a2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f3465f != null) {
                this.f3465f.m2760b();
            }
            super.setVisibility(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3690a() {
        if (this.f3463d != null) {
            return this.f3463d.m3735f();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected int m3687a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: renamed from: a */
    protected static int m3684a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: renamed from: a */
    protected int m3688a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a */
        int f3468a;

        /* JADX INFO: renamed from: c */
        private boolean f3470c = false;

        protected VisibilityAnimListener() {
        }

        /* JADX INFO: renamed from: a */
        public VisibilityAnimListener m3691a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.f3465f = viewPropertyAnimatorCompat;
            this.f3468a = i;
            return this;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: a */
        public void mo2762a(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f3470c = false;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: b */
        public void mo2763b(View view) {
            if (!this.f3470c) {
                AbsActionBarView.this.f3465f = null;
                AbsActionBarView.super.setVisibility(this.f3468a);
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: c */
        public void mo2764c(View view) {
            this.f3470c = true;
        }
    }
}
