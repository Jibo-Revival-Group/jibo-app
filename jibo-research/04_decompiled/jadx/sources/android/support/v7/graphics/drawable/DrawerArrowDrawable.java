package android.support.v7.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {

    /* JADX INFO: renamed from: b */
    private static final float f3116b = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a */
    private final Paint f3117a;

    /* JADX INFO: renamed from: c */
    private float f3118c;

    /* JADX INFO: renamed from: d */
    private float f3119d;

    /* JADX INFO: renamed from: e */
    private float f3120e;

    /* JADX INFO: renamed from: f */
    private float f3121f;

    /* JADX INFO: renamed from: g */
    private boolean f3122g;

    /* JADX INFO: renamed from: h */
    private final Path f3123h;

    /* JADX INFO: renamed from: i */
    private final int f3124i;

    /* JADX INFO: renamed from: j */
    private boolean f3125j;

    /* JADX INFO: renamed from: k */
    private float f3126k;

    /* JADX INFO: renamed from: l */
    private float f3127l;

    /* JADX INFO: renamed from: m */
    private int f3128m;

    /* JADX INFO: renamed from: a */
    public void m3437a(boolean z) {
        if (this.f3125j != z) {
            this.f3125j = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Rect bounds = getBounds();
        switch (this.f3128m) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 2:
            default:
                z = DrawableCompat.m2002i(this) == 1;
                break;
            case 3:
                z = DrawableCompat.m2002i(this) == 0;
                break;
        }
        float fM3435a = m3435a(this.f3119d, (float) Math.sqrt(this.f3118c * this.f3118c * 2.0f), this.f3126k);
        float fM3435a2 = m3435a(this.f3119d, this.f3120e, this.f3126k);
        float fRound = Math.round(m3435a(CropImageView.DEFAULT_ASPECT_RATIO, this.f3127l, this.f3126k));
        float fM3435a3 = m3435a(CropImageView.DEFAULT_ASPECT_RATIO, f3116b, this.f3126k);
        float fM3435a4 = m3435a(z ? 0.0f : -180.0f, z ? 180.0f : CropImageView.DEFAULT_ASPECT_RATIO, this.f3126k);
        float fRound2 = Math.round(((double) fM3435a) * Math.cos(fM3435a3));
        float fRound3 = Math.round(((double) fM3435a) * Math.sin(fM3435a3));
        this.f3123h.rewind();
        float fM3435a5 = m3435a(this.f3121f + this.f3117a.getStrokeWidth(), -this.f3127l, this.f3126k);
        float f = (-fM3435a2) / 2.0f;
        this.f3123h.moveTo(f + fRound, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3123h.rLineTo(fM3435a2 - (fRound * 2.0f), CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3123h.moveTo(f, fM3435a5);
        this.f3123h.rLineTo(fRound2, fRound3);
        this.f3123h.moveTo(f, -fM3435a5);
        this.f3123h.rLineTo(fRound2, -fRound3);
        this.f3123h.close();
        canvas.save();
        canvas.translate(bounds.centerX(), (this.f3117a.getStrokeWidth() * 1.5f) + this.f3121f + ((((int) ((bounds.height() - (3.0f * r2)) - (this.f3121f * 2.0f))) / 4) * 2));
        if (this.f3122g) {
            canvas.rotate((z ^ this.f3125j ? -1 : 1) * fM3435a4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f3123h, this.f3117a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f3117a.getAlpha()) {
            this.f3117a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3117a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3124i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3124i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: a */
    public void m3436a(float f) {
        if (this.f3126k != f) {
            this.f3126k = f;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private static float m3435a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
