package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {

    /* JADX INFO: renamed from: a */
    private final WindowId f1393a;

    WindowIdApi18(View view) {
        this.f1393a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f1393a.equals(this.f1393a);
    }

    public int hashCode() {
        return this.f1393a.hashCode();
    }
}
