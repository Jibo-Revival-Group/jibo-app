package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: loaded from: classes.dex */
public final class PointerIconCompat {

    /* JADX INFO: renamed from: a */
    private Object f2336a;

    private PointerIconCompat(Object obj) {
        this.f2336a = obj;
    }

    /* JADX INFO: renamed from: a */
    public Object m2568a() {
        return this.f2336a;
    }

    /* JADX INFO: renamed from: a */
    public static PointerIconCompat m2567a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(PointerIcon.getSystemIcon(context, i)) : new PointerIconCompat(null);
    }
}
