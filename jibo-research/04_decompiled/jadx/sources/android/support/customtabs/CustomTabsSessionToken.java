package android.support.customtabs;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken {

    /* JADX INFO: renamed from: a */
    private final ICustomTabsCallback f377a;

    /* JADX INFO: renamed from: b */
    private final CustomTabsCallback f378b = new CustomTabsCallback() { // from class: android.support.customtabs.CustomTabsSessionToken.1
    };

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback) {
        this.f377a = iCustomTabsCallback;
    }

    /* JADX INFO: renamed from: a */
    IBinder m332a() {
        return this.f377a.asBinder();
    }

    public int hashCode() {
        return m332a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CustomTabsSessionToken) {
            return ((CustomTabsSessionToken) obj).m332a().equals(this.f377a.asBinder());
        }
        return false;
    }
}
