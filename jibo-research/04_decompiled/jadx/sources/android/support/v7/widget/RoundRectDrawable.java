package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* JADX INFO: renamed from: a */
    private float f4158a;

    /* JADX INFO: renamed from: c */
    private final RectF f4160c;

    /* JADX INFO: renamed from: d */
    private final Rect f4161d;

    /* JADX INFO: renamed from: e */
    private float f4162e;

    /* JADX INFO: renamed from: h */
    private ColorStateList f4165h;

    /* JADX INFO: renamed from: i */
    private PorterDuffColorFilter f4166i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f4167j;

    /* JADX INFO: renamed from: f */
    private boolean f4163f = false;

    /* JADX INFO: renamed from: g */
    private boolean f4164g = true;

    /* JADX INFO: renamed from: k */
    private PorterDuff.Mode f4168k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    private final Paint f4159b = new Paint(5);

    RoundRectDrawable(ColorStateList colorStateList, float f) {
        this.f4158a = f;
        m4681b(colorStateList);
        this.f4160c = new RectF();
        this.f4161d = new Rect();
    }

    /* JADX INFO: renamed from: b */
    private void m4681b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4165h = colorStateList;
        this.f4159b.setColor(this.f4165h.getColorForState(getState(), this.f4165h.getDefaultColor()));
    }

    /* JADX INFO: renamed from: a */
    void m4684a(float f, boolean z, boolean z2) {
        if (f != this.f4162e || this.f4163f != z || this.f4164g != z2) {
            this.f4162e = f;
            this.f4163f = z;
            this.f4164g = z2;
            m4680a((Rect) null);
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    float m4682a() {
        return this.f4162e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f4159b;
        if (this.f4166i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f4166i);
            z = true;
        } else {
            z = false;
        }
        canvas.drawRoundRect(this.f4160c, this.f4158a, this.f4158a, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4680a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f4160c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f4161d.set(rect);
        if (this.f4163f) {
            this.f4161d.inset((int) Math.ceil(RoundRectDrawableWithShadow.m4691b(this.f4162e, this.f4158a, this.f4164g)), (int) Math.ceil(RoundRectDrawableWithShadow.m4688a(this.f4162e, this.f4158a, this.f4164g)));
            this.f4160c.set(this.f4161d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m4680a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f4161d, this.f4158a);
    }

    /* JADX INFO: renamed from: a */
    void m4683a(float f) {
        if (f != this.f4158a) {
            this.f4158a = f;
            m4680a((Rect) null);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4159b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4159b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: b */
    public float m4686b() {
        return this.f4158a;
    }

    /* JADX INFO: renamed from: a */
    public void m4685a(ColorStateList colorStateList) {
        m4681b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: c */
    public ColorStateList m4687c() {
        return this.f4165h;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4167j = colorStateList;
        this.f4166i = m4679a(this.f4167j, this.f4168k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4168k = mode;
        this.f4166i = m4679a(this.f4167j, this.f4168k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f4165h.getColorForState(iArr, this.f4165h.getDefaultColor());
        boolean z = colorForState != this.f4159b.getColor();
        if (z) {
            this.f4159b.setColor(colorForState);
        }
        if (this.f4167j == null || this.f4168k == null) {
            return z;
        }
        this.f4166i = m4679a(this.f4167j, this.f4168k);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f4167j != null && this.f4167j.isStateful()) || (this.f4165h != null && this.f4165h.isStateful()) || super.isStateful();
    }

    /* JADX INFO: renamed from: a */
    private PorterDuffColorFilter m4679a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
