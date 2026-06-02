package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
final class CollapsingTextHelper {

    /* JADX INFO: renamed from: a */
    private static final boolean f595a;

    /* JADX INFO: renamed from: b */
    private static final Paint f596b;

    /* JADX INFO: renamed from: A */
    private boolean f597A;

    /* JADX INFO: renamed from: B */
    private Bitmap f598B;

    /* JADX INFO: renamed from: C */
    private Paint f599C;

    /* JADX INFO: renamed from: D */
    private float f600D;

    /* JADX INFO: renamed from: E */
    private float f601E;

    /* JADX INFO: renamed from: F */
    private float f602F;

    /* JADX INFO: renamed from: G */
    private float f603G;

    /* JADX INFO: renamed from: H */
    private int[] f604H;

    /* JADX INFO: renamed from: I */
    private boolean f605I;

    /* JADX INFO: renamed from: K */
    private Interpolator f607K;

    /* JADX INFO: renamed from: L */
    private Interpolator f608L;

    /* JADX INFO: renamed from: M */
    private float f609M;

    /* JADX INFO: renamed from: N */
    private float f610N;

    /* JADX INFO: renamed from: O */
    private float f611O;

    /* JADX INFO: renamed from: P */
    private int f612P;

    /* JADX INFO: renamed from: Q */
    private float f613Q;

    /* JADX INFO: renamed from: R */
    private float f614R;

    /* JADX INFO: renamed from: S */
    private float f615S;

    /* JADX INFO: renamed from: T */
    private int f616T;

    /* JADX INFO: renamed from: c */
    private final View f617c;

    /* JADX INFO: renamed from: d */
    private boolean f618d;

    /* JADX INFO: renamed from: e */
    private float f619e;

    /* JADX INFO: renamed from: m */
    private ColorStateList f627m;

    /* JADX INFO: renamed from: n */
    private ColorStateList f628n;

    /* JADX INFO: renamed from: o */
    private float f629o;

    /* JADX INFO: renamed from: p */
    private float f630p;

    /* JADX INFO: renamed from: q */
    private float f631q;

    /* JADX INFO: renamed from: r */
    private float f632r;

    /* JADX INFO: renamed from: s */
    private float f633s;

    /* JADX INFO: renamed from: t */
    private float f634t;

    /* JADX INFO: renamed from: u */
    private Typeface f635u;

    /* JADX INFO: renamed from: v */
    private Typeface f636v;

    /* JADX INFO: renamed from: w */
    private Typeface f637w;

    /* JADX INFO: renamed from: x */
    private CharSequence f638x;

    /* JADX INFO: renamed from: y */
    private CharSequence f639y;

    /* JADX INFO: renamed from: z */
    private boolean f640z;

    /* JADX INFO: renamed from: i */
    private int f623i = 16;

    /* JADX INFO: renamed from: j */
    private int f624j = 16;

    /* JADX INFO: renamed from: k */
    private float f625k = 15.0f;

    /* JADX INFO: renamed from: l */
    private float f626l = 15.0f;

    /* JADX INFO: renamed from: J */
    private final TextPaint f606J = new TextPaint(129);

    /* JADX INFO: renamed from: g */
    private final Rect f621g = new Rect();

    /* JADX INFO: renamed from: f */
    private final Rect f620f = new Rect();

    /* JADX INFO: renamed from: h */
    private final RectF f622h = new RectF();

    static {
        f595a = Build.VERSION.SDK_INT < 18;
        f596b = null;
        if (f596b != null) {
            f596b.setAntiAlias(true);
            f596b.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.f617c = view;
    }

    /* JADX INFO: renamed from: a */
    void m589a(Interpolator interpolator) {
        this.f608L = interpolator;
        m608i();
    }

    /* JADX INFO: renamed from: b */
    void m598b(Interpolator interpolator) {
        this.f607K = interpolator;
        m608i();
    }

    /* JADX INFO: renamed from: a */
    void m583a(float f) {
        if (this.f625k != f) {
            this.f625k = f;
            m608i();
        }
    }

    /* JADX INFO: renamed from: a */
    void m586a(ColorStateList colorStateList) {
        if (this.f628n != colorStateList) {
            this.f628n = colorStateList;
            m608i();
        }
    }

    /* JADX INFO: renamed from: b */
    void m596b(ColorStateList colorStateList) {
        if (this.f627m != colorStateList) {
            this.f627m = colorStateList;
            m608i();
        }
    }

    /* JADX INFO: renamed from: a */
    void m585a(int i, int i2, int i3, int i4) {
        if (!m568a(this.f620f, i, i2, i3, i4)) {
            this.f620f.set(i, i2, i3, i4);
            this.f605I = true;
            m582a();
        }
    }

    /* JADX INFO: renamed from: b */
    void m595b(int i, int i2, int i3, int i4) {
        if (!m568a(this.f621g, i, i2, i3, i4)) {
            this.f621g.set(i, i2, i3, i4);
            this.f605I = true;
            m582a();
        }
    }

    /* JADX INFO: renamed from: a */
    void m582a() {
        this.f618d = this.f621g.width() > 0 && this.f621g.height() > 0 && this.f620f.width() > 0 && this.f620f.height() > 0;
    }

    /* JADX INFO: renamed from: a */
    void m584a(int i) {
        if (this.f623i != i) {
            this.f623i = i;
            m608i();
        }
    }

    /* JADX INFO: renamed from: b */
    int m592b() {
        return this.f623i;
    }

    /* JADX INFO: renamed from: b */
    void m594b(int i) {
        if (this.f624j != i) {
            this.f624j = i;
            m608i();
        }
    }

    /* JADX INFO: renamed from: c */
    int m599c() {
        return this.f624j;
    }

    /* JADX INFO: renamed from: c */
    void m600c(int i) {
        TintTypedArray tintTypedArrayM4953a = TintTypedArray.m4953a(this.f617c.getContext(), i, R.styleable.TextAppearance);
        if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColor)) {
            this.f628n = tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColor);
        }
        if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textSize)) {
            this.f626l = tintTypedArrayM4953a.m4968e(R.styleable.TextAppearance_android_textSize, (int) this.f626l);
        }
        this.f612P = tintTypedArrayM4953a.m4957a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.f610N = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowDx, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f611O = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowDy, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f609M = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowRadius, CropImageView.DEFAULT_ASPECT_RATIO);
        tintTypedArrayM4953a.m4960a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f635u = m573e(i);
        }
        m608i();
    }

    /* JADX INFO: renamed from: d */
    void m603d(int i) {
        TintTypedArray tintTypedArrayM4953a = TintTypedArray.m4953a(this.f617c.getContext(), i, R.styleable.TextAppearance);
        if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColor)) {
            this.f627m = tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColor);
        }
        if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textSize)) {
            this.f625k = tintTypedArrayM4953a.m4968e(R.styleable.TextAppearance_android_textSize, (int) this.f625k);
        }
        this.f616T = tintTypedArrayM4953a.m4957a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.f614R = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowDx, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f615S = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowDy, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f613Q = tintTypedArrayM4953a.m4956a(R.styleable.TextAppearance_android_shadowRadius, CropImageView.DEFAULT_ASPECT_RATIO);
        tintTypedArrayM4953a.m4960a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f636v = m573e(i);
        }
        m608i();
    }

    /* JADX INFO: renamed from: e */
    private Typeface m573e(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f617c.getContext().obtainStyledAttributes(i, new int[]{android.R.attr.fontFamily});
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    void m588a(Typeface typeface) {
        if (m569a(this.f635u, typeface)) {
            this.f635u = typeface;
            m608i();
        }
    }

    /* JADX INFO: renamed from: b */
    void m597b(Typeface typeface) {
        if (m569a(this.f636v, typeface)) {
            this.f636v = typeface;
            m608i();
        }
    }

    /* JADX INFO: renamed from: c */
    void m601c(Typeface typeface) {
        this.f636v = typeface;
        this.f635u = typeface;
        m608i();
    }

    /* JADX INFO: renamed from: d */
    Typeface m602d() {
        return this.f635u != null ? this.f635u : Typeface.DEFAULT;
    }

    /* JADX INFO: renamed from: e */
    Typeface m604e() {
        return this.f636v != null ? this.f636v : Typeface.DEFAULT;
    }

    /* JADX INFO: renamed from: b */
    void m593b(float f) {
        float fM2024a = MathUtils.m2024a(f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        if (fM2024a != this.f619e) {
            this.f619e = fM2024a;
            m576l();
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m591a(int[] iArr) {
        this.f604H = iArr;
        if (!m605f()) {
            return false;
        }
        m608i();
        return true;
    }

    /* JADX INFO: renamed from: f */
    final boolean m605f() {
        return (this.f628n != null && this.f628n.isStateful()) || (this.f627m != null && this.f627m.isStateful());
    }

    /* JADX INFO: renamed from: g */
    float m606g() {
        return this.f619e;
    }

    /* JADX INFO: renamed from: h */
    float m607h() {
        return this.f626l;
    }

    /* JADX INFO: renamed from: l */
    private void m576l() {
        m571c(this.f619e);
    }

    /* JADX INFO: renamed from: c */
    private void m571c(float f) {
        m572d(f);
        this.f633s = m565a(this.f631q, this.f632r, f, this.f607K);
        this.f634t = m565a(this.f629o, this.f630p, f, this.f607K);
        m574e(m565a(this.f625k, this.f626l, f, this.f608L));
        if (this.f628n != this.f627m) {
            this.f606J.setColor(m566a(m577m(), m578n(), f));
        } else {
            this.f606J.setColor(m578n());
        }
        this.f606J.setShadowLayer(m565a(this.f613Q, this.f609M, f, (Interpolator) null), m565a(this.f614R, this.f610N, f, (Interpolator) null), m565a(this.f615S, this.f611O, f, (Interpolator) null), m566a(this.f616T, this.f612P, f));
        ViewCompat.m2597c(this.f617c);
    }

    /* JADX INFO: renamed from: m */
    private int m577m() {
        return this.f604H != null ? this.f627m.getColorForState(this.f604H, 0) : this.f627m.getDefaultColor();
    }

    /* JADX INFO: renamed from: n */
    private int m578n() {
        return this.f604H != null ? this.f628n.getColorForState(this.f604H, 0) : this.f628n.getDefaultColor();
    }

    /* JADX INFO: renamed from: o */
    private void m579o() {
        float fMeasureText = CropImageView.DEFAULT_ASPECT_RATIO;
        float f = this.f603G;
        m575f(this.f626l);
        float fMeasureText2 = this.f639y != null ? this.f606J.measureText(this.f639y, 0, this.f639y.length()) : 0.0f;
        int iM2508a = GravityCompat.m2508a(this.f624j, this.f640z ? 1 : 0);
        switch (iM2508a & 112) {
            case 48:
                this.f630p = this.f621g.top - this.f606J.ascent();
                break;
            case 80:
                this.f630p = this.f621g.bottom;
                break;
            default:
                this.f630p = (((this.f606J.descent() - this.f606J.ascent()) / 2.0f) - this.f606J.descent()) + this.f621g.centerY();
                break;
        }
        switch (iM2508a & 8388615) {
            case 1:
                this.f632r = this.f621g.centerX() - (fMeasureText2 / 2.0f);
                break;
            case 5:
                this.f632r = this.f621g.right - fMeasureText2;
                break;
            default:
                this.f632r = this.f621g.left;
                break;
        }
        m575f(this.f625k);
        if (this.f639y != null) {
            fMeasureText = this.f606J.measureText(this.f639y, 0, this.f639y.length());
        }
        int iM2508a2 = GravityCompat.m2508a(this.f623i, this.f640z ? 1 : 0);
        switch (iM2508a2 & 112) {
            case 48:
                this.f629o = this.f620f.top - this.f606J.ascent();
                break;
            case 80:
                this.f629o = this.f620f.bottom;
                break;
            default:
                this.f629o = (((this.f606J.descent() - this.f606J.ascent()) / 2.0f) - this.f606J.descent()) + this.f620f.centerY();
                break;
        }
        switch (iM2508a2 & 8388615) {
            case 1:
                this.f631q = this.f620f.centerX() - (fMeasureText / 2.0f);
                break;
            case 5:
                this.f631q = this.f620f.right - fMeasureText;
                break;
            default:
                this.f631q = this.f620f.left;
                break;
        }
        m581q();
        m574e(f);
    }

    /* JADX INFO: renamed from: d */
    private void m572d(float f) {
        this.f622h.left = m565a(this.f620f.left, this.f621g.left, f, this.f607K);
        this.f622h.top = m565a(this.f629o, this.f630p, f, this.f607K);
        this.f622h.right = m565a(this.f620f.right, this.f621g.right, f, this.f607K);
        this.f622h.bottom = m565a(this.f620f.bottom, this.f621g.bottom, f, this.f607K);
    }

    /* JADX INFO: renamed from: a */
    public void m587a(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.f639y != null && this.f618d) {
            float f = this.f633s;
            float f2 = this.f634t;
            boolean z = this.f597A && this.f598B != null;
            if (z) {
                fAscent = this.f600D * this.f602F;
                float f3 = this.f601E * this.f602F;
            } else {
                fAscent = this.f606J.ascent() * this.f602F;
                float fDescent = this.f606J.descent() * this.f602F;
            }
            if (z) {
                f2 += fAscent;
            }
            if (this.f602F != 1.0f) {
                canvas.scale(this.f602F, this.f602F, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.f598B, f, f2, this.f599C);
            } else {
                canvas.drawText(this.f639y, 0, this.f639y.length(), f, f2, this.f606J);
            }
        }
        canvas.restoreToCount(iSave);
    }

    /* JADX INFO: renamed from: b */
    private boolean m570b(CharSequence charSequence) {
        return (ViewCompat.m2601e(this.f617c) == 1 ? TextDirectionHeuristicsCompat.f2171d : TextDirectionHeuristicsCompat.f2170c).mo2365a(charSequence, 0, charSequence.length());
    }

    /* JADX INFO: renamed from: e */
    private void m574e(float f) {
        m575f(f);
        this.f597A = f595a && this.f602F != 1.0f;
        if (this.f597A) {
            m580p();
        }
        ViewCompat.m2597c(this.f617c);
    }

    /* JADX INFO: renamed from: a */
    private boolean m569a(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    /* JADX INFO: renamed from: f */
    private void m575f(float f) {
        float f2;
        boolean z;
        if (this.f638x != null) {
            float fWidth = this.f621g.width();
            float fWidth2 = this.f620f.width();
            if (m567a(f, this.f626l)) {
                f2 = this.f626l;
                this.f602F = 1.0f;
                if (m569a(this.f637w, this.f635u)) {
                    this.f637w = this.f635u;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                f2 = this.f625k;
                if (m569a(this.f637w, this.f636v)) {
                    this.f637w = this.f636v;
                    z = true;
                } else {
                    z = false;
                }
                if (m567a(f, this.f625k)) {
                    this.f602F = 1.0f;
                } else {
                    this.f602F = f / this.f625k;
                }
                float f3 = this.f626l / this.f625k;
                fWidth = fWidth2 * f3 > fWidth ? Math.min(fWidth / f3, fWidth2) : fWidth2;
            }
            if (fWidth > CropImageView.DEFAULT_ASPECT_RATIO) {
                z = this.f603G != f2 || this.f605I || z;
                this.f603G = f2;
                this.f605I = false;
            }
            if (this.f639y == null || z) {
                this.f606J.setTextSize(this.f603G);
                this.f606J.setTypeface(this.f637w);
                this.f606J.setLinearText(this.f602F != 1.0f);
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f638x, this.f606J, fWidth, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(charSequenceEllipsize, this.f639y)) {
                    this.f639y = charSequenceEllipsize;
                    this.f640z = m570b(this.f639y);
                }
            }
        }
    }

    /* JADX INFO: renamed from: p */
    private void m580p() {
        if (this.f598B == null && !this.f620f.isEmpty() && !TextUtils.isEmpty(this.f639y)) {
            m571c(CropImageView.DEFAULT_ASPECT_RATIO);
            this.f600D = this.f606J.ascent();
            this.f601E = this.f606J.descent();
            int iRound = Math.round(this.f606J.measureText(this.f639y, 0, this.f639y.length()));
            int iRound2 = Math.round(this.f601E - this.f600D);
            if (iRound > 0 && iRound2 > 0) {
                this.f598B = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
                new Canvas(this.f598B).drawText(this.f639y, 0, this.f639y.length(), CropImageView.DEFAULT_ASPECT_RATIO, iRound2 - this.f606J.descent(), this.f606J);
                if (this.f599C == null) {
                    this.f599C = new Paint(3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public void m608i() {
        if (this.f617c.getHeight() > 0 && this.f617c.getWidth() > 0) {
            m579o();
            m576l();
        }
    }

    /* JADX INFO: renamed from: a */
    void m590a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f638x)) {
            this.f638x = charSequence;
            this.f639y = null;
            m581q();
            m608i();
        }
    }

    /* JADX INFO: renamed from: j */
    CharSequence m609j() {
        return this.f638x;
    }

    /* JADX INFO: renamed from: q */
    private void m581q() {
        if (this.f598B != null) {
            this.f598B.recycle();
            this.f598B = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m567a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* JADX INFO: renamed from: k */
    ColorStateList m610k() {
        return this.f628n;
    }

    /* JADX INFO: renamed from: a */
    private static int m566a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((f2 * Color.blue(i)) + (Color.blue(i2) * f)));
    }

    /* JADX INFO: renamed from: a */
    private static float m565a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return AnimationUtils.m408a(f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m568a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
