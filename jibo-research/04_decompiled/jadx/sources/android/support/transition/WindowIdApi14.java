package android.support.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {

    /* JADX INFO: renamed from: a */
    private final IBinder f1392a;

    WindowIdApi14(IBinder iBinder) {
        this.f1392a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f1392a.equals(this.f1392a);
    }

    public int hashCode() {
        return this.f1392a.hashCode();
    }
}
