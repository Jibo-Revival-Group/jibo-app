package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class ThemeUtils {

    /* JADX INFO: renamed from: a */
    private static final int[] f969a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: a */
    static void m940a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f969a);
        boolean z = typedArrayObtainStyledAttributes.hasValue(0) ? false : true;
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
