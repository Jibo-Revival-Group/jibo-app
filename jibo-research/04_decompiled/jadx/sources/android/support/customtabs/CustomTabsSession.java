package android.support.customtabs;

import android.content.ComponentName;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsSession {

    /* JADX INFO: renamed from: a */
    private final ICustomTabsCallback f375a;

    /* JADX INFO: renamed from: b */
    private final ComponentName f376b;

    /* JADX INFO: renamed from: a */
    IBinder m330a() {
        return this.f375a.asBinder();
    }

    /* JADX INFO: renamed from: b */
    ComponentName m331b() {
        return this.f376b;
    }
}
