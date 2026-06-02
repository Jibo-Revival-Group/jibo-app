package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* JADX INFO: renamed from: a */
    private final SeekBar f3701a;

    /* JADX INFO: renamed from: b */
    private Drawable f3702b;

    /* JADX INFO: renamed from: c */
    private ColorStateList f3703c;

    /* JADX INFO: renamed from: d */
    private PorterDuff.Mode f3704d;

    /* JADX INFO: renamed from: e */
    private boolean f3705e;

    /* JADX INFO: renamed from: f */
    private boolean f3706f;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f3703c = null;
        this.f3704d = null;
        this.f3705e = false;
        this.f3706f = false;
        this.f3701a = seekBar;
    }

    @Override // android.support.v7.widget.AppCompatProgressBarHelper
    /* JADX INFO: renamed from: a */
    void mo3907a(AttributeSet attributeSet, int i) {
        super.mo3907a(attributeSet, i);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(this.f3701a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableM4963b = tintTypedArrayM4955a.m4963b(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableM4963b != null) {
            this.f3701a.setThumb(drawableM4963b);
        }
        m3910a(tintTypedArrayM4955a.m4959a(R.styleable.AppCompatSeekBar_tickMark));
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f3704d = DrawableUtils.m4114a(tintTypedArrayM4955a.m4957a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f3704d);
            this.f3706f = true;
        }
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f3703c = tintTypedArrayM4955a.m4969e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f3705e = true;
        }
        tintTypedArrayM4955a.m4960a();
        m3908d();
    }

    /* JADX INFO: renamed from: a */
    void m3910a(Drawable drawable) {
        if (this.f3702b != null) {
            this.f3702b.setCallback(null);
        }
        this.f3702b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f3701a);
            DrawableCompat.m1995b(drawable, ViewCompat.m2601e(this.f3701a));
            if (drawable.isStateful()) {
                drawable.setState(this.f3701a.getDrawableState());
            }
            m3908d();
        }
        this.f3701a.invalidate();
    }

    /* JADX INFO: renamed from: d */
    private void m3908d() {
        if (this.f3702b != null) {
            if (this.f3705e || this.f3706f) {
                this.f3702b = DrawableCompat.m2000g(this.f3702b.mutate());
                if (this.f3705e) {
                    DrawableCompat.m1989a(this.f3702b, this.f3703c);
                }
                if (this.f3706f) {
                    DrawableCompat.m1992a(this.f3702b, this.f3704d);
                }
                if (this.f3702b.isStateful()) {
                    this.f3702b.setState(this.f3701a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m3911b() {
        if (this.f3702b != null) {
            this.f3702b.jumpToCurrentState();
        }
    }

    /* JADX INFO: renamed from: c */
    void m3912c() {
        Drawable drawable = this.f3702b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f3701a.getDrawableState())) {
            this.f3701a.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3909a(Canvas canvas) {
        int max;
        if (this.f3702b != null && (max = this.f3701a.getMax()) > 1) {
            int intrinsicWidth = this.f3702b.getIntrinsicWidth();
            int intrinsicHeight = this.f3702b.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.f3702b.setBounds(-i, -i2, i, i2);
            float width = ((this.f3701a.getWidth() - this.f3701a.getPaddingLeft()) - this.f3701a.getPaddingRight()) / max;
            int iSave = canvas.save();
            canvas.translate(this.f3701a.getPaddingLeft(), this.f3701a.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.f3702b.draw(canvas);
                canvas.translate(width, CropImageView.DEFAULT_ASPECT_RATIO);
            }
            canvas.restoreToCount(iSave);
        }
    }
}
