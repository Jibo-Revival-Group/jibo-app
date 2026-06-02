package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* JADX INFO: renamed from: a */
    final Bitmap f1874a;

    /* JADX INFO: renamed from: c */
    private int f1876c;

    /* JADX INFO: renamed from: f */
    private final BitmapShader f1879f;

    /* JADX INFO: renamed from: h */
    private float f1881h;

    /* JADX INFO: renamed from: k */
    private boolean f1884k;

    /* JADX INFO: renamed from: l */
    private int f1885l;

    /* JADX INFO: renamed from: m */
    private int f1886m;

    /* JADX INFO: renamed from: d */
    private int f1877d = 119;

    /* JADX INFO: renamed from: e */
    private final Paint f1878e = new Paint(3);

    /* JADX INFO: renamed from: g */
    private final Matrix f1880g = new Matrix();

    /* JADX INFO: renamed from: b */
    final Rect f1875b = new Rect();

    /* JADX INFO: renamed from: i */
    private final RectF f1882i = new RectF();

    /* JADX INFO: renamed from: j */
    private boolean f1883j = true;

    /* JADX INFO: renamed from: c */
    private void m2004c() {
        this.f1885l = this.f1874a.getScaledWidth(this.f1876c);
        this.f1886m = this.f1874a.getScaledHeight(this.f1876c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1878e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1878e.setDither(z);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    void mo2008a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    void m2006a() {
        if (this.f1883j) {
            if (this.f1884k) {
                int iMin = Math.min(this.f1885l, this.f1886m);
                mo2008a(this.f1877d, iMin, iMin, getBounds(), this.f1875b);
                int iMin2 = Math.min(this.f1875b.width(), this.f1875b.height());
                this.f1875b.inset(Math.max(0, (this.f1875b.width() - iMin2) / 2), Math.max(0, (this.f1875b.height() - iMin2) / 2));
                this.f1881h = iMin2 * 0.5f;
            } else {
                mo2008a(this.f1877d, this.f1885l, this.f1886m, getBounds(), this.f1875b);
            }
            this.f1882i.set(this.f1875b);
            if (this.f1879f != null) {
                this.f1880g.setTranslate(this.f1882i.left, this.f1882i.top);
                this.f1880g.preScale(this.f1882i.width() / this.f1874a.getWidth(), this.f1882i.height() / this.f1874a.getHeight());
                this.f1879f.setLocalMatrix(this.f1880g);
                this.f1878e.setShader(this.f1879f);
            }
            this.f1883j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1874a;
        if (bitmap != null) {
            m2006a();
            if (this.f1878e.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f1875b, this.f1878e);
            } else {
                canvas.drawRoundRect(this.f1882i, this.f1881h, this.f1881h, this.f1878e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1878e.getAlpha()) {
            this.f1878e.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1878e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1878e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1878e.getColorFilter();
    }

    /* JADX INFO: renamed from: a */
    public void m2009a(boolean z) {
        this.f1884k = z;
        this.f1883j = true;
        if (z) {
            m2005d();
            this.f1878e.setShader(this.f1879f);
            invalidateSelf();
            return;
        }
        m2007a(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: d */
    private void m2005d() {
        this.f1881h = Math.min(this.f1886m, this.f1885l) / 2;
    }

    /* JADX INFO: renamed from: a */
    public void m2007a(float f) {
        if (this.f1881h != f) {
            this.f1884k = false;
            if (m2003b(f)) {
                this.f1878e.setShader(this.f1879f);
            } else {
                this.f1878e.setShader(null);
            }
            this.f1881h = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f1884k) {
            m2005d();
        }
        this.f1883j = true;
    }

    /* JADX INFO: renamed from: b */
    public float m2010b() {
        return this.f1881h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1885l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1886m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f1877d != 119 || this.f1884k || (bitmap = this.f1874a) == null || bitmap.hasAlpha() || this.f1878e.getAlpha() < 255 || m2003b(this.f1881h)) ? -3 : -1;
    }

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f1876c = 160;
        if (resources != null) {
            this.f1876c = resources.getDisplayMetrics().densityDpi;
        }
        this.f1874a = bitmap;
        if (this.f1874a != null) {
            m2004c();
            this.f1879f = new BitmapShader(this.f1874a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.f1886m = -1;
            this.f1885l = -1;
            this.f1879f = null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2003b(float f) {
        return f > 0.05f;
    }
}
