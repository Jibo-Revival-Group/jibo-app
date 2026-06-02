package android.support.v4.os;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {

    /* JADX INFO: renamed from: a */
    private boolean f2106a;

    /* JADX INFO: renamed from: b */
    private OnCancelListener f2107b;

    /* JADX INFO: renamed from: c */
    private Object f2108c;

    /* JADX INFO: renamed from: d */
    private boolean f2109d;

    public interface OnCancelListener {
        /* JADX INFO: renamed from: a */
        void m2318a();
    }

    /* JADX INFO: renamed from: a */
    public boolean m2314a() {
        boolean z;
        synchronized (this) {
            z = this.f2106a;
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    public void m2315b() {
        if (m2314a()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2316c() {
        synchronized (this) {
            if (!this.f2106a) {
                this.f2106a = true;
                this.f2109d = true;
                OnCancelListener onCancelListener = this.f2107b;
                Object obj = this.f2108c;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.m2318a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f2109d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null && Build.VERSION.SDK_INT >= 16) {
                    ((android.os.CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f2109d = false;
                    notifyAll();
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public Object m2317d() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f2108c == null) {
                this.f2108c = new android.os.CancellationSignal();
                if (this.f2106a) {
                    ((android.os.CancellationSignal) this.f2108c).cancel();
                }
            }
            obj = this.f2108c;
        }
        return obj;
    }
}
