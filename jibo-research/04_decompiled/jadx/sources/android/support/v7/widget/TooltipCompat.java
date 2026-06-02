package android.support.v7.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {
    /* JADX INFO: renamed from: a */
    public static void m4985a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            TooltipCompatHandler.m4989a(view, charSequence);
        }
    }
}
