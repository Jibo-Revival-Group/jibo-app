package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class TintTypedArray {

    /* JADX INFO: renamed from: a */
    private final Context f4432a;

    /* JADX INFO: renamed from: b */
    private final TypedArray f4433b;

    /* JADX INFO: renamed from: c */
    private TypedValue f4434c;

    /* JADX INFO: renamed from: a */
    public static TintTypedArray m4954a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* JADX INFO: renamed from: a */
    public static TintTypedArray m4955a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public static TintTypedArray m4953a(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f4432a = context;
        this.f4433b = typedArray;
    }

    /* JADX INFO: renamed from: a */
    public Drawable m4959a(int i) {
        int resourceId;
        return (!this.f4433b.hasValue(i) || (resourceId = this.f4433b.getResourceId(i, 0)) == 0) ? this.f4433b.getDrawable(i) : AppCompatResources.m3426b(this.f4432a, resourceId);
    }

    /* JADX INFO: renamed from: b */
    public Drawable m4963b(int i) {
        int resourceId;
        if (!this.f4433b.hasValue(i) || (resourceId = this.f4433b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.m3862a().m3882a(this.f4432a, resourceId, true);
    }

    /* JADX INFO: renamed from: a */
    public Typeface m4958a(int i, int i2, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f4433b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f4434c == null) {
            this.f4434c = new TypedValue();
        }
        return ResourcesCompat.m1916a(this.f4432a, resourceId, this.f4434c, i2, fontCallback);
    }

    /* JADX INFO: renamed from: c */
    public CharSequence m4965c(int i) {
        return this.f4433b.getText(i);
    }

    /* JADX INFO: renamed from: d */
    public String m4967d(int i) {
        return this.f4433b.getString(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4961a(int i, boolean z) {
        return this.f4433b.getBoolean(i, z);
    }

    /* JADX INFO: renamed from: a */
    public int m4957a(int i, int i2) {
        return this.f4433b.getInt(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public float m4956a(int i, float f) {
        return this.f4433b.getFloat(i, f);
    }

    /* JADX INFO: renamed from: b */
    public int m4962b(int i, int i2) {
        return this.f4433b.getColor(i, i2);
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m4969e(int i) {
        int resourceId;
        ColorStateList colorStateListM3423a;
        return (!this.f4433b.hasValue(i) || (resourceId = this.f4433b.getResourceId(i, 0)) == 0 || (colorStateListM3423a = AppCompatResources.m3423a(this.f4432a, resourceId)) == null) ? this.f4433b.getColorStateList(i) : colorStateListM3423a;
    }

    /* JADX INFO: renamed from: c */
    public int m4964c(int i, int i2) {
        return this.f4433b.getInteger(i, i2);
    }

    /* JADX INFO: renamed from: d */
    public int m4966d(int i, int i2) {
        return this.f4433b.getDimensionPixelOffset(i, i2);
    }

    /* JADX INFO: renamed from: e */
    public int m4968e(int i, int i2) {
        return this.f4433b.getDimensionPixelSize(i, i2);
    }

    /* JADX INFO: renamed from: f */
    public int m4970f(int i, int i2) {
        return this.f4433b.getLayoutDimension(i, i2);
    }

    /* JADX INFO: renamed from: g */
    public int m4972g(int i, int i2) {
        return this.f4433b.getResourceId(i, i2);
    }

    /* JADX INFO: renamed from: f */
    public CharSequence[] m4971f(int i) {
        return this.f4433b.getTextArray(i);
    }

    /* JADX INFO: renamed from: g */
    public boolean m4973g(int i) {
        return this.f4433b.hasValue(i);
    }

    /* JADX INFO: renamed from: a */
    public void m4960a() {
        this.f4433b.recycle();
    }
}
