package android.support.v4.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* JADX INFO: renamed from: a */
    private final AccessibilityRecord f2482a;

    /* JADX INFO: renamed from: a */
    public static void m2841a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2842b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        if (this.f2482a == null) {
            return 0;
        }
        return this.f2482a.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
            return this.f2482a == null ? accessibilityRecordCompat.f2482a == null : this.f2482a.equals(accessibilityRecordCompat.f2482a);
        }
        return false;
    }
}
