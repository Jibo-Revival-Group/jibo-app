package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class ShadowDrawableWrapper extends DrawableWrapper {

    /* JADX INFO: renamed from: a */
    static final double f794a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b */
    final Paint f795b;

    /* JADX INFO: renamed from: c */
    final Paint f796c;

    /* JADX INFO: renamed from: d */
    final RectF f797d;

    /* JADX INFO: renamed from: e */
    float f798e;

    /* JADX INFO: renamed from: f */
    Path f799f;

    /* JADX INFO: renamed from: g */
    float f800g;

    /* JADX INFO: renamed from: h */
    float f801h;

    /* JADX INFO: renamed from: i */
    float f802i;

    /* JADX INFO: renamed from: j */
    float f803j;

    /* JADX INFO: renamed from: k */
    private boolean f804k;

    /* JADX INFO: renamed from: l */
    private final int f805l;

    /* JADX INFO: renamed from: m */
    private final int f806m;

    /* JADX INFO: renamed from: n */
    private final int f807n;

    /* JADX INFO: renamed from: o */
    private boolean f808o;

    /* JADX INFO: renamed from: p */
    private float f809p;

    /* JADX INFO: renamed from: q */
    private boolean f810q;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f804k = true;
        this.f808o = true;
        this.f810q = false;
        this.f805l = ContextCompat.m1840c(context, R.color.design_fab_shadow_start_color);
        this.f806m = ContextCompat.m1840c(context, R.color.design_fab_shadow_mid_color);
        this.f807n = ContextCompat.m1840c(context, R.color.design_fab_shadow_end_color);
        this.f795b = new Paint(5);
        this.f795b.setStyle(Paint.Style.FILL);
        this.f798e = Math.round(f);
        this.f797d = new RectF();
        this.f796c = new Paint(this.f795b);
        this.f796c.setAntiAlias(false);
        m800a(f2, f3);
    }

    /* JADX INFO: renamed from: c */
    private static int m796c(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    /* JADX INFO: renamed from: a */
    public void m801a(boolean z) {
        this.f808o = z;
        invalidateSelf();
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f795b.setAlpha(i);
        this.f796c.setAlpha(i);
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f804k = true;
    }

    /* JADX INFO: renamed from: a */
    void m800a(float f, float f2) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fM796c = m796c(f);
        float fM796c2 = m796c(f2);
        if (fM796c > fM796c2) {
            if (!this.f810q) {
                this.f810q = true;
            }
            fM796c = fM796c2;
        }
        if (this.f803j != fM796c || this.f801h != fM796c2) {
            this.f803j = fM796c;
            this.f801h = fM796c2;
            this.f802i = Math.round(fM796c * 1.5f);
            this.f800g = fM796c2;
            this.f804k = true;
            invalidateSelf();
        }
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m792a(this.f801h, this.f798e, this.f808o));
        int iCeil2 = (int) Math.ceil(m795b(this.f801h, this.f798e, this.f808o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static float m792a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f794a) * ((double) f2))) : 1.5f * f;
    }

    /* JADX INFO: renamed from: b */
    public static float m795b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f794a) * ((double) f2)));
        }
        return f;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f804k) {
            m794a(getBounds());
            this.f804k = false;
        }
        m793a(canvas);
        super.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    final void m799a(float f) {
        if (this.f809p != f) {
            this.f809p = f;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m793a(Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(this.f809p, this.f797d.centerX(), this.f797d.centerY());
        float f = (-this.f798e) - this.f802i;
        float f2 = this.f798e;
        boolean z = this.f797d.width() - (2.0f * f2) > CropImageView.DEFAULT_ASPECT_RATIO;
        boolean z2 = this.f797d.height() - (2.0f * f2) > CropImageView.DEFAULT_ASPECT_RATIO;
        float f3 = this.f803j - (this.f803j * 0.25f);
        float f4 = f2 / ((this.f803j - (this.f803j * 0.5f)) + f2);
        float f5 = f2 / (f3 + f2);
        float f6 = f2 / (f2 + (this.f803j - (this.f803j * 1.0f)));
        int iSave2 = canvas.save();
        canvas.translate(this.f797d.left + f2, this.f797d.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.f799f, this.f795b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f797d.width() - (2.0f * f2), -this.f798e, this.f796c);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.f797d.right - f2, this.f797d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f799f, this.f795b);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f797d.width() - (2.0f * f2), this.f802i + (-this.f798e), this.f796c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f797d.left + f2, this.f797d.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f799f, this.f795b);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f797d.height() - (2.0f * f2), -this.f798e, this.f796c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.f797d.right - f2, this.f797d.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f799f, this.f795b);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f797d.height() - (2.0f * f2), -this.f798e, this.f796c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    /* JADX INFO: renamed from: c */
    private void m797c() {
        RectF rectF = new RectF(-this.f798e, -this.f798e, this.f798e, this.f798e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f802i, -this.f802i);
        if (this.f799f == null) {
            this.f799f = new Path();
        } else {
            this.f799f.reset();
        }
        this.f799f.setFillType(Path.FillType.EVEN_ODD);
        this.f799f.moveTo(-this.f798e, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f799f.rLineTo(-this.f802i, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f799f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f799f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f799f.close();
        float f = -rectF2.top;
        if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            float f2 = this.f798e / f;
            this.f795b.setShader(new RadialGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, new int[]{0, this.f805l, this.f806m, this.f807n}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f796c.setShader(new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, rectF.top, CropImageView.DEFAULT_ASPECT_RATIO, rectF2.top, new int[]{this.f805l, this.f806m, this.f807n}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f796c.setAntiAlias(false);
    }

    /* JADX INFO: renamed from: a */
    private void m794a(Rect rect) {
        float f = this.f801h * 1.5f;
        this.f797d.set(rect.left + this.f801h, rect.top + f, rect.right - this.f801h, rect.bottom - f);
        m3434b().setBounds((int) this.f797d.left, (int) this.f797d.top, (int) this.f797d.right, (int) this.f797d.bottom);
        m797c();
    }

    /* JADX INFO: renamed from: b */
    public void m802b(float f) {
        m800a(f, this.f801h);
    }

    /* JADX INFO: renamed from: a */
    public float m798a() {
        return this.f803j;
    }
}
