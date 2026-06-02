package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.R;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* JADX INFO: renamed from: a */
    static RoundRectHelper f4169a;

    /* JADX INFO: renamed from: b */
    private static final double f4170b = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: c */
    private final int f4171c;

    /* JADX INFO: renamed from: e */
    private Paint f4173e;

    /* JADX INFO: renamed from: f */
    private Paint f4174f;

    /* JADX INFO: renamed from: g */
    private final RectF f4175g;

    /* JADX INFO: renamed from: h */
    private float f4176h;

    /* JADX INFO: renamed from: i */
    private Path f4177i;

    /* JADX INFO: renamed from: j */
    private float f4178j;

    /* JADX INFO: renamed from: k */
    private float f4179k;

    /* JADX INFO: renamed from: l */
    private float f4180l;

    /* JADX INFO: renamed from: m */
    private ColorStateList f4181m;

    /* JADX INFO: renamed from: o */
    private final int f4183o;

    /* JADX INFO: renamed from: p */
    private final int f4184p;

    /* JADX INFO: renamed from: n */
    private boolean f4182n = true;

    /* JADX INFO: renamed from: q */
    private boolean f4185q = true;

    /* JADX INFO: renamed from: r */
    private boolean f4186r = false;

    /* JADX INFO: renamed from: d */
    private Paint f4172d = new Paint(5);

    interface RoundRectHelper {
        /* JADX INFO: renamed from: a */
        void mo3985a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f4183o = resources.getColor(R.color.cardview_shadow_start_color);
        this.f4184p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f4171c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        m4692b(colorStateList);
        this.f4173e = new Paint(5);
        this.f4173e.setStyle(Paint.Style.FILL);
        this.f4176h = (int) (0.5f + f);
        this.f4175g = new RectF();
        this.f4174f = new Paint(this.f4173e);
        this.f4174f.setAntiAlias(false);
        m4689a(f2, f3);
    }

    /* JADX INFO: renamed from: b */
    private void m4692b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4181m = colorStateList;
        this.f4172d.setColor(this.f4181m.getColorForState(getState(), this.f4181m.getDefaultColor()));
    }

    /* JADX INFO: renamed from: d */
    private int m4694d(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    void m4700a(boolean z) {
        this.f4185q = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4172d.setAlpha(i);
        this.f4173e.setAlpha(i);
        this.f4174f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4182n = true;
    }

    /* JADX INFO: renamed from: a */
    private void m4689a(float f, float f2) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fM4694d = m4694d(f);
        float fM4694d2 = m4694d(f2);
        if (fM4694d > fM4694d2) {
            if (!this.f4186r) {
                this.f4186r = true;
            }
            fM4694d = fM4694d2;
        }
        if (this.f4180l != fM4694d || this.f4178j != fM4694d2) {
            this.f4180l = fM4694d;
            this.f4178j = fM4694d2;
            this.f4179k = (int) ((fM4694d * 1.5f) + this.f4171c + 0.5f);
            this.f4182n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m4688a(this.f4178j, this.f4176h, this.f4185q));
        int iCeil2 = (int) Math.ceil(m4691b(this.f4178j, this.f4176h, this.f4185q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    /* JADX INFO: renamed from: a */
    static float m4688a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f4170b) * ((double) f2))) : 1.5f * f;
    }

    /* JADX INFO: renamed from: b */
    static float m4691b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f4170b) * ((double) f2)));
        }
        return f;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f4181m.getColorForState(iArr, this.f4181m.getDefaultColor());
        if (this.f4172d.getColor() == colorForState) {
            return false;
        }
        this.f4172d.setColor(colorForState);
        this.f4182n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f4181m != null && this.f4181m.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4172d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: a */
    void m4697a(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (0.5f + f);
        if (this.f4176h != f2) {
            this.f4176h = f2;
            this.f4182n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4182n) {
            m4693b(getBounds());
            this.f4182n = false;
        }
        canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, this.f4180l / 2.0f);
        m4690a(canvas);
        canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, (-this.f4180l) / 2.0f);
        f4169a.mo3985a(canvas, this.f4175g, this.f4176h, this.f4172d);
    }

    /* JADX INFO: renamed from: a */
    private void m4690a(Canvas canvas) {
        float f = (-this.f4176h) - this.f4179k;
        float f2 = this.f4176h + this.f4171c + (this.f4180l / 2.0f);
        boolean z = this.f4175g.width() - (2.0f * f2) > CropImageView.DEFAULT_ASPECT_RATIO;
        boolean z2 = this.f4175g.height() - (2.0f * f2) > CropImageView.DEFAULT_ASPECT_RATIO;
        int iSave = canvas.save();
        canvas.translate(this.f4175g.left + f2, this.f4175g.top + f2);
        canvas.drawPath(this.f4177i, this.f4173e);
        if (z) {
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f4175g.width() - (2.0f * f2), -this.f4176h, this.f4174f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.f4175g.right - f2, this.f4175g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f4177i, this.f4173e);
        if (z) {
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f4175g.width() - (2.0f * f2), this.f4179k + (-this.f4176h), this.f4174f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.f4175g.left + f2, this.f4175g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f4177i, this.f4173e);
        if (z2) {
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f4175g.height() - (2.0f * f2), -this.f4176h, this.f4174f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f4175g.right - f2, this.f4175g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f4177i, this.f4173e);
        if (z2) {
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, f, this.f4175g.height() - (2.0f * f2), -this.f4176h, this.f4174f);
        }
        canvas.restoreToCount(iSave4);
    }

    /* JADX INFO: renamed from: g */
    private void m4695g() {
        RectF rectF = new RectF(-this.f4176h, -this.f4176h, this.f4176h, this.f4176h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f4179k, -this.f4179k);
        if (this.f4177i == null) {
            this.f4177i = new Path();
        } else {
            this.f4177i.reset();
        }
        this.f4177i.setFillType(Path.FillType.EVEN_ODD);
        this.f4177i.moveTo(-this.f4176h, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f4177i.rLineTo(-this.f4179k, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f4177i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f4177i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f4177i.close();
        this.f4173e.setShader(new RadialGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.f4176h + this.f4179k, new int[]{this.f4183o, this.f4183o, this.f4184p}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, this.f4176h / (this.f4176h + this.f4179k), 1.0f}, Shader.TileMode.CLAMP));
        this.f4174f.setShader(new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, (-this.f4176h) + this.f4179k, CropImageView.DEFAULT_ASPECT_RATIO, (-this.f4176h) - this.f4179k, new int[]{this.f4183o, this.f4183o, this.f4184p}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f4174f.setAntiAlias(false);
    }

    /* JADX INFO: renamed from: b */
    private void m4693b(Rect rect) {
        float f = this.f4178j * 1.5f;
        this.f4175g.set(rect.left + this.f4178j, rect.top + f, rect.right - this.f4178j, rect.bottom - f);
        m4695g();
    }

    /* JADX INFO: renamed from: a */
    float m4696a() {
        return this.f4176h;
    }

    /* JADX INFO: renamed from: a */
    void m4699a(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: renamed from: b */
    void m4702b(float f) {
        m4689a(f, this.f4178j);
    }

    /* JADX INFO: renamed from: c */
    void m4704c(float f) {
        m4689a(this.f4180l, f);
    }

    /* JADX INFO: renamed from: b */
    float m4701b() {
        return this.f4180l;
    }

    /* JADX INFO: renamed from: c */
    float m4703c() {
        return this.f4178j;
    }

    /* JADX INFO: renamed from: d */
    float m4705d() {
        return (Math.max(this.f4178j, this.f4176h + this.f4171c + (this.f4178j / 2.0f)) * 2.0f) + ((this.f4178j + this.f4171c) * 2.0f);
    }

    /* JADX INFO: renamed from: e */
    float m4706e() {
        return (Math.max(this.f4178j, this.f4176h + this.f4171c + ((this.f4178j * 1.5f) / 2.0f)) * 2.0f) + (((this.f4178j * 1.5f) + this.f4171c) * 2.0f);
    }

    /* JADX INFO: renamed from: a */
    void m4698a(ColorStateList colorStateList) {
        m4692b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: f */
    ColorStateList m4707f() {
        return this.f4181m;
    }
}
