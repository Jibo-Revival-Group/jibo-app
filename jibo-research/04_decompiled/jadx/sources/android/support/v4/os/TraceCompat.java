package android.support.v4.os;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public final class TraceCompat {
    /* JADX INFO: renamed from: a */
    public static void m2325a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2324a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
