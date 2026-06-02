package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class CircularBorderDrawable extends Drawable {

    /* JADX INFO: renamed from: d */
    float f586d;

    /* JADX INFO: renamed from: e */
    private int f587e;

    /* JADX INFO: renamed from: f */
    private int f588f;

    /* JADX INFO: renamed from: g */
    private int f589g;

    /* JADX INFO: renamed from: h */
    private int f590h;

    /* JADX INFO: renamed from: i */
    private ColorStateList f591i;

    /* JADX INFO: renamed from: j */
    private int f592j;

    /* JADX INFO: renamed from: l */
    private float f594l;

    /* JADX INFO: renamed from: b */
    final Rect f584b = new Rect();

    /* JADX INFO: renamed from: c */
    final RectF f585c = new RectF();

    /* JADX INFO: renamed from: k */
    private boolean f593k = true;

    /* JADX INFO: renamed from: a */
    final Paint f583a = new Paint(1);

    public CircularBorderDrawable() {
        this.f583a.setStyle(Paint.Style.STROKE);
    }

    /* JADX INFO: renamed from: a */
    void m562a(int i, int i2, int i3, int i4) {
        this.f587e = i;
        this.f588f = i2;
        this.f589g = i3;
        this.f590h = i4;
    }

    /* JADX INFO: renamed from: a */
    void m561a(float f) {
        if (this.f586d != f) {
            this.f586d = f;
            this.f583a.setStrokeWidth(1.3333f * f);
            this.f593k = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f593k) {
            this.f583a.setShader(m560a());
            this.f593k = false;
        }
        float strokeWidth = this.f583a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f585c;
        copyBounds(this.f584b);
        rectF.set(this.f584b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f594l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f583a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iRound = Math.round(this.f586d);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f583a.setAlpha(i);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    void m563a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f592j = colorStateList.getColorForState(getState(), this.f592j);
        }
        this.f591i = colorStateList;
        this.f593k = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f583a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f586d > CropImageView.DEFAULT_ASPECT_RATIO ? -3 : -2;
    }

    /* JADX INFO: renamed from: b */
    final void m564b(float f) {
        if (f != this.f594l) {
            this.f594l = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f593k = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f591i != null && this.f591i.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.f591i != null && (colorForState = this.f591i.getColorForState(iArr, this.f592j)) != this.f592j) {
            this.f593k = true;
            this.f592j = colorForState;
        }
        if (this.f593k) {
            invalidateSelf();
        }
        return this.f593k;
    }

    /* JADX INFO: renamed from: a */
    private Shader m560a() {
        copyBounds(this.f584b);
        float fHeight = this.f586d / r3.height();
        return new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, r3.top, CropImageView.DEFAULT_ASPECT_RATIO, r3.bottom, new int[]{ColorUtils.m1933a(this.f587e, this.f592j), ColorUtils.m1933a(this.f588f, this.f592j), ColorUtils.m1933a(ColorUtils.m1935b(this.f588f, 0), this.f592j), ColorUtils.m1933a(ColorUtils.m1935b(this.f590h, 0), this.f592j), ColorUtils.m1933a(this.f590h, this.f592j), ColorUtils.m1933a(this.f589g, this.f592j)}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }
}
