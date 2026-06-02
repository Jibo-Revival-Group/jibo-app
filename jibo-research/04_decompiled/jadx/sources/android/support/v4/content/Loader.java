package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class Loader<D> {

    /* JADX INFO: renamed from: n */
    int f1795n;

    /* JADX INFO: renamed from: o */
    OnLoadCompleteListener<D> f1796o;

    /* JADX INFO: renamed from: p */
    OnLoadCanceledListener<D> f1797p;

    /* JADX INFO: renamed from: q */
    Context f1798q;

    /* JADX INFO: renamed from: r */
    boolean f1799r = false;

    /* JADX INFO: renamed from: s */
    boolean f1800s = false;

    /* JADX INFO: renamed from: t */
    boolean f1801t = true;

    /* JADX INFO: renamed from: u */
    boolean f1802u = false;

    /* JADX INFO: renamed from: v */
    boolean f1803v = false;

    public interface OnLoadCanceledListener<D> {
        /* JADX INFO: renamed from: a */
        void m1877a(Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        /* JADX INFO: renamed from: a */
        void mo1695a(Loader<D> loader, D d);
    }

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.m1858B();
        }
    }

    public Loader(Context context) {
        this.f1798q = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: b */
    public void mo1842b(D d) {
        if (this.f1796o != null) {
            this.f1796o.mo1695a(this, d);
        }
    }

    /* JADX INFO: renamed from: l */
    public void m1862l() {
        if (this.f1797p != null) {
            this.f1797p.m1877a(this);
        }
    }

    /* JADX INFO: renamed from: m */
    public Context m1863m() {
        return this.f1798q;
    }

    /* JADX INFO: renamed from: n */
    public int m1864n() {
        return this.f1795n;
    }

    /* JADX INFO: renamed from: a */
    public void m1859a(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f1796o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1796o = onLoadCompleteListener;
        this.f1795n = i;
    }

    /* JADX INFO: renamed from: a */
    public void m1860a(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f1796o == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f1796o != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f1796o = null;
    }

    /* JADX INFO: renamed from: o */
    public boolean m1865o() {
        return this.f1799r;
    }

    /* JADX INFO: renamed from: p */
    public boolean m1866p() {
        return this.f1800s;
    }

    /* JADX INFO: renamed from: q */
    public boolean m1867q() {
        return this.f1801t;
    }

    /* JADX INFO: renamed from: r */
    public final void m1868r() {
        this.f1799r = true;
        this.f1801t = false;
        this.f1800s = false;
        mo1844i();
    }

    /* JADX INFO: renamed from: i */
    protected void mo1844i() {
    }

    /* JADX INFO: renamed from: s */
    public boolean m1869s() {
        return mo1822b();
    }

    /* JADX INFO: renamed from: b */
    protected boolean mo1822b() {
        return false;
    }

    /* JADX INFO: renamed from: t */
    public void m1870t() {
        mo1817a();
    }

    /* JADX INFO: renamed from: a */
    protected void mo1817a() {
    }

    /* JADX INFO: renamed from: u */
    public void m1871u() {
        this.f1799r = false;
        mo1845j();
    }

    /* JADX INFO: renamed from: j */
    protected void mo1845j() {
    }

    /* JADX INFO: renamed from: v */
    public void m1872v() {
        this.f1800s = true;
        m1873w();
    }

    /* JADX INFO: renamed from: w */
    protected void m1873w() {
    }

    /* JADX INFO: renamed from: x */
    public void m1874x() {
        mo1846k();
        this.f1801t = true;
        this.f1799r = false;
        this.f1800s = false;
        this.f1802u = false;
        this.f1803v = false;
    }

    /* JADX INFO: renamed from: k */
    protected void mo1846k() {
    }

    /* JADX INFO: renamed from: y */
    public boolean m1875y() {
        boolean z = this.f1802u;
        this.f1802u = false;
        this.f1803v |= z;
        return z;
    }

    /* JADX INFO: renamed from: z */
    public void m1876z() {
        this.f1803v = false;
    }

    /* JADX INFO: renamed from: A */
    public void m1857A() {
        if (this.f1803v) {
            m1858B();
        }
    }

    /* JADX INFO: renamed from: B */
    public void m1858B() {
        if (this.f1799r) {
            m1870t();
        } else {
            this.f1802u = true;
        }
    }

    /* JADX INFO: renamed from: c */
    public String m1861c(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m2402a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m2402a(this, sb);
        sb.append(" id=");
        sb.append(this.f1795n);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public void mo1820a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1795n);
        printWriter.print(" mListener=");
        printWriter.println(this.f1796o);
        if (this.f1799r || this.f1802u || this.f1803v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1799r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1802u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1803v);
        }
        if (this.f1800s || this.f1801t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1800s);
            printWriter.print(" mReset=");
            printWriter.println(this.f1801t);
        }
    }
}
