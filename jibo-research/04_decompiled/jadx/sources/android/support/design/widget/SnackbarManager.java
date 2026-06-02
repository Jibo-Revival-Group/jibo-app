package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class SnackbarManager {

    /* JADX INFO: renamed from: a */
    private static SnackbarManager f813a;

    /* JADX INFO: renamed from: b */
    private final Object f814b = new Object();

    /* JADX INFO: renamed from: c */
    private final Handler f815c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SnackbarManager.this.m819a((SnackbarRecord) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* JADX INFO: renamed from: d */
    private SnackbarRecord f816d;

    /* JADX INFO: renamed from: e */
    private SnackbarRecord f817e;

    interface Callback {
        /* JADX INFO: renamed from: a */
        void mo500a();

        /* JADX INFO: renamed from: a */
        void mo501a(int i);
    }

    /* JADX INFO: renamed from: a */
    static SnackbarManager m810a() {
        if (f813a == null) {
            f813a = new SnackbarManager();
        }
        return f813a;
    }

    private SnackbarManager() {
    }

    /* JADX INFO: renamed from: a */
    public void m816a(int i, Callback callback) {
        synchronized (this.f814b) {
            if (m814g(callback)) {
                this.f816d.f820b = i;
                this.f815c.removeCallbacksAndMessages(this.f816d);
                m813b(this.f816d);
                return;
            }
            if (m815h(callback)) {
                this.f817e.f820b = i;
            } else {
                this.f817e = new SnackbarRecord(i, callback);
            }
            if (this.f816d == null || !m811a(this.f816d, 4)) {
                this.f816d = null;
                m812b();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m818a(Callback callback, int i) {
        synchronized (this.f814b) {
            if (m814g(callback)) {
                m811a(this.f816d, i);
            } else if (m815h(callback)) {
                m811a(this.f817e, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m817a(Callback callback) {
        synchronized (this.f814b) {
            if (m814g(callback)) {
                this.f816d = null;
                if (this.f817e != null) {
                    m812b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m820b(Callback callback) {
        synchronized (this.f814b) {
            if (m814g(callback)) {
                m813b(this.f816d);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m821c(Callback callback) {
        synchronized (this.f814b) {
            if (m814g(callback) && !this.f816d.f821c) {
                this.f816d.f821c = true;
                this.f815c.removeCallbacksAndMessages(this.f816d);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m822d(Callback callback) {
        synchronized (this.f814b) {
            if (m814g(callback) && this.f816d.f821c) {
                this.f816d.f821c = false;
                m813b(this.f816d);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m823e(Callback callback) {
        boolean zM814g;
        synchronized (this.f814b) {
            zM814g = m814g(callback);
        }
        return zM814g;
    }

    /* JADX INFO: renamed from: f */
    public boolean m824f(Callback callback) {
        boolean z;
        synchronized (this.f814b) {
            z = m814g(callback) || m815h(callback);
        }
        return z;
    }

    private static class SnackbarRecord {

        /* JADX INFO: renamed from: a */
        final WeakReference<Callback> f819a;

        /* JADX INFO: renamed from: b */
        int f820b;

        /* JADX INFO: renamed from: c */
        boolean f821c;

        SnackbarRecord(int i, Callback callback) {
            this.f819a = new WeakReference<>(callback);
            this.f820b = i;
        }

        /* JADX INFO: renamed from: a */
        boolean m825a(Callback callback) {
            return callback != null && this.f819a.get() == callback;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m812b() {
        if (this.f817e != null) {
            this.f816d = this.f817e;
            this.f817e = null;
            Callback callback = this.f816d.f819a.get();
            if (callback != null) {
                callback.mo500a();
            } else {
                this.f816d = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m811a(SnackbarRecord snackbarRecord, int i) {
        Callback callback = snackbarRecord.f819a.get();
        if (callback == null) {
            return false;
        }
        this.f815c.removeCallbacksAndMessages(snackbarRecord);
        callback.mo501a(i);
        return true;
    }

    /* JADX INFO: renamed from: g */
    private boolean m814g(Callback callback) {
        return this.f816d != null && this.f816d.m825a(callback);
    }

    /* JADX INFO: renamed from: h */
    private boolean m815h(Callback callback) {
        return this.f817e != null && this.f817e.m825a(callback);
    }

    /* JADX INFO: renamed from: b */
    private void m813b(SnackbarRecord snackbarRecord) {
        if (snackbarRecord.f820b != -2) {
            int i = 2750;
            if (snackbarRecord.f820b > 0) {
                i = snackbarRecord.f820b;
            } else if (snackbarRecord.f820b == -1) {
                i = 1500;
            }
            this.f815c.removeCallbacksAndMessages(snackbarRecord);
            this.f815c.sendMessageDelayed(Message.obtain(this.f815c, 0, snackbarRecord), i);
        }
    }

    /* JADX INFO: renamed from: a */
    void m819a(SnackbarRecord snackbarRecord) {
        synchronized (this.f814b) {
            if (this.f816d == snackbarRecord || this.f817e == snackbarRecord) {
                m811a(snackbarRecord, 2);
            }
        }
    }
}
