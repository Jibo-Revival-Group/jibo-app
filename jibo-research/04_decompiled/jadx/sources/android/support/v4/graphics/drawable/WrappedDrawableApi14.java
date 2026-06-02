package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, TintAwareDrawable, WrappedDrawable {

    /* JADX INFO: renamed from: a */
    static final PorterDuff.Mode f1887a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    DrawableWrapperState f1888b;

    /* JADX INFO: renamed from: c */
    Drawable f1889c;

    /* JADX INFO: renamed from: d */
    private int f1890d;

    /* JADX INFO: renamed from: e */
    private PorterDuff.Mode f1891e;

    /* JADX INFO: renamed from: f */
    private boolean f1892f;

    /* JADX INFO: renamed from: g */
    private boolean f1893g;

    WrappedDrawableApi14(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.f1888b = drawableWrapperState;
        m2014a(resources);
    }

    WrappedDrawableApi14(Drawable drawable) {
        this.f1888b = mo2016b();
        mo2013a(drawable);
    }

    /* JADX INFO: renamed from: a */
    private void m2014a(Resources resources) {
        if (this.f1888b != null && this.f1888b.f1895b != null) {
            mo2013a(this.f1888b.f1895b.newDrawable(resources));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1889c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1889c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f1889c != null) {
            this.f1889c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1889c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return (this.f1888b != null ? this.f1888b.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.f1889c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1889c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1889c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1889c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1889c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!mo2017c() || this.f1888b == null) ? null : this.f1888b.f1896c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1889c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m2015a(iArr) || this.f1889c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1889c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1889c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1889c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1889c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1889c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1889c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1889c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1889c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1889c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1889c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1888b == null || !this.f1888b.m2018a()) {
            return null;
        }
        this.f1888b.f1894a = getChangingConfigurations();
        return this.f1888b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1893g && super.mutate() == this) {
            this.f1888b = mo2016b();
            if (this.f1889c != null) {
                this.f1889c.mutate();
            }
            if (this.f1888b != null) {
                this.f1888b.f1895b = this.f1889c != null ? this.f1889c.getConstantState() : null;
            }
            this.f1893g = true;
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    DrawableWrapperState mo2016b() {
        return new DrawableWrapperStateBase(this.f1888b, null);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f1889c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1888b.f1896c = colorStateList;
        m2015a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1888b.f1897d = mode;
        m2015a(getState());
    }

    /* JADX INFO: renamed from: a */
    private boolean m2015a(int[] iArr) {
        if (!mo2017c()) {
            return false;
        }
        ColorStateList colorStateList = this.f1888b.f1896c;
        PorterDuff.Mode mode = this.f1888b.f1897d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (this.f1892f && colorForState == this.f1890d && mode == this.f1891e) {
                return false;
            }
            setColorFilter(colorForState, mode);
            this.f1890d = colorForState;
            this.f1891e = mode;
            this.f1892f = true;
            return true;
        }
        this.f1892f = false;
        clearColorFilter();
        return false;
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawable
    /* JADX INFO: renamed from: a */
    public final Drawable mo2012a() {
        return this.f1889c;
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawable
    /* JADX INFO: renamed from: a */
    public final void mo2013a(Drawable drawable) {
        if (this.f1889c != null) {
            this.f1889c.setCallback(null);
        }
        this.f1889c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f1888b != null) {
                this.f1888b.f1895b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* JADX INFO: renamed from: c */
    protected boolean mo2017c() {
        return true;
    }

    protected static abstract class DrawableWrapperState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f1894a;

        /* JADX INFO: renamed from: b */
        Drawable.ConstantState f1895b;

        /* JADX INFO: renamed from: c */
        ColorStateList f1896c;

        /* JADX INFO: renamed from: d */
        PorterDuff.Mode f1897d;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);

        DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            this.f1896c = null;
            this.f1897d = WrappedDrawableApi14.f1887a;
            if (drawableWrapperState != null) {
                this.f1894a = drawableWrapperState.f1894a;
                this.f1895b = drawableWrapperState.f1895b;
                this.f1896c = drawableWrapperState.f1896c;
                this.f1897d = drawableWrapperState.f1897d;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return (this.f1895b != null ? this.f1895b.getChangingConfigurations() : 0) | this.f1894a;
        }

        /* JADX INFO: renamed from: a */
        boolean m2018a() {
            return this.f1895b != null;
        }
    }

    private static class DrawableWrapperStateBase extends DrawableWrapperState {
        DrawableWrapperStateBase(DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi14(this, resources);
        }
    }
}
