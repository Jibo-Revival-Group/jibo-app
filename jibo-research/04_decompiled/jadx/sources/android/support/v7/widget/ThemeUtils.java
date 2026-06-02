package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
class ThemeUtils {

    /* JADX INFO: renamed from: i */
    private static final ThreadLocal<TypedValue> f4421i = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    static final int[] f4413a = {-16842910};

    /* JADX INFO: renamed from: b */
    static final int[] f4414b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c */
    static final int[] f4415c = {R.attr.state_activated};

    /* JADX INFO: renamed from: d */
    static final int[] f4416d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e */
    static final int[] f4417e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f */
    static final int[] f4418f = {R.attr.state_selected};

    /* JADX INFO: renamed from: g */
    static final int[] f4419g = {-16842919, -16842908};

    /* JADX INFO: renamed from: h */
    static final int[] f4420h = new int[0];

    /* JADX INFO: renamed from: j */
    private static final int[] f4422j = new int[1];

    /* JADX INFO: renamed from: a */
    public static int m4943a(Context context, int i) {
        f4422j[0] = i;
        TintTypedArray tintTypedArrayM4954a = TintTypedArray.m4954a(context, (AttributeSet) null, f4422j);
        try {
            return tintTypedArrayM4954a.m4962b(0, 0);
        } finally {
            tintTypedArrayM4954a.m4960a();
        }
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m4946b(Context context, int i) {
        f4422j[0] = i;
        TintTypedArray tintTypedArrayM4954a = TintTypedArray.m4954a(context, (AttributeSet) null, f4422j);
        try {
            return tintTypedArrayM4954a.m4969e(0);
        } finally {
            tintTypedArrayM4954a.m4960a();
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m4947c(Context context, int i) {
        ColorStateList colorStateListM4946b = m4946b(context, i);
        if (colorStateListM4946b != null && colorStateListM4946b.isStateful()) {
            return colorStateListM4946b.getColorForState(f4413a, colorStateListM4946b.getDefaultColor());
        }
        TypedValue typedValueM4945a = m4945a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM4945a, true);
        return m4944a(context, i, typedValueM4945a.getFloat());
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m4945a() {
        TypedValue typedValue = f4421i.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f4421i.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* JADX INFO: renamed from: a */
    static int m4944a(Context context, int i, float f) {
        return ColorUtils.m1935b(m4943a(context, i), Math.round(Color.alpha(r0) * f));
    }
}
