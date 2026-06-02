package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

/* JADX INFO: loaded from: classes.dex */
public class SquaringDrawable extends GlideDrawable {

    /* JADX INFO: renamed from: a */
    private GlideDrawable f4981a;

    /* JADX INFO: renamed from: b */
    private State f4982b;

    /* JADX INFO: renamed from: c */
    private boolean f4983c;

    public SquaringDrawable(GlideDrawable glideDrawable, int i) {
        this(new State(glideDrawable.getConstantState(), i), glideDrawable, null);
    }

    SquaringDrawable(State state, GlideDrawable glideDrawable, Resources resources) {
        this.f4982b = state;
        if (glideDrawable == null) {
            if (resources != null) {
                this.f4981a = (GlideDrawable) state.f4984a.newDrawable(resources);
                return;
            } else {
                this.f4981a = (GlideDrawable) state.f4984a.newDrawable();
                return;
            }
        }
        this.f4981a = glideDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f4981a.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f4981a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f4981a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f4981a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f4981a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f4981a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.f4981a.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.f4981a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f4981a.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f4981a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f4981a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f4981a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4982b.f4985b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4982b.f4985b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f4981a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f4981a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f4981a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f4981a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f4981a.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f4981a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f4981a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4981a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4981a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4981a.getOpacity();
    }

    @Override // com.bumptech.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return this.f4981a.isAnimated();
    }

    @Override // com.bumptech.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i) {
        this.f4981a.setLoopCount(i);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4981a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4981a.stop();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4981a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4983c && super.mutate() == this) {
            this.f4981a = (GlideDrawable) this.f4981a.mutate();
            this.f4982b = new State(this.f4982b);
            this.f4983c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4982b;
    }

    static class State extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f4984a;

        /* JADX INFO: renamed from: b */
        private final int f4985b;

        State(State state) {
            this(state.f4984a, state.f4985b);
        }

        State(Drawable.ConstantState constantState, int i) {
            this.f4984a = constantState;
            this.f4985b = i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new SquaringDrawable(this, null, resources);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
