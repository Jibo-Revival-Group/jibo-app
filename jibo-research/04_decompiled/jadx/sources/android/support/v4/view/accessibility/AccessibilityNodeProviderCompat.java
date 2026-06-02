package android.support.v4.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {

    /* JADX INFO: renamed from: a */
    private final Object f2480a;

    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a */
        final AccessibilityNodeProviderCompat f2481a;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f2481a = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatM2836a = this.f2481a.m2836a(i);
            if (accessibilityNodeInfoCompatM2836a == null) {
                return null;
            }
            return accessibilityNodeInfoCompatM2836a.m2781a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<AccessibilityNodeInfoCompat> listM2838a = this.f2481a.m2838a(str, i);
            if (listM2838a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listM2838a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listM2838a.get(i2).m2781a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f2481a.m2839a(i, i2, bundle);
        }
    }

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatM2840b = this.f2481a.m2840b(i);
            if (accessibilityNodeInfoCompatM2840b == null) {
                return null;
            }
            return accessibilityNodeInfoCompatM2840b.m2781a();
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2480a = new AccessibilityNodeProviderApi19(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f2480a = new AccessibilityNodeProviderApi16(this);
        } else {
            this.f2480a = null;
        }
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f2480a = obj;
    }

    /* JADX INFO: renamed from: a */
    public Object m2837a() {
        return this.f2480a;
    }

    /* JADX INFO: renamed from: a */
    public AccessibilityNodeInfoCompat m2836a(int i) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2839a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public List<AccessibilityNodeInfoCompat> m2838a(String str, int i) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public AccessibilityNodeInfoCompat m2840b(int i) {
        return null;
    }
}
