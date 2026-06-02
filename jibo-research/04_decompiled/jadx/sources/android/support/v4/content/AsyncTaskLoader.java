package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* JADX INFO: renamed from: a */
    volatile AsyncTaskLoader<D>.LoadTask f1770a;

    /* JADX INFO: renamed from: b */
    volatile AsyncTaskLoader<D>.LoadTask f1771b;

    /* JADX INFO: renamed from: c */
    long f1772c;

    /* JADX INFO: renamed from: d */
    long f1773d;

    /* JADX INFO: renamed from: e */
    Handler f1774e;

    /* JADX INFO: renamed from: f */
    private final Executor f1775f;

    /* JADX INFO: renamed from: d */
    public abstract D mo1824d();

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: a */
        boolean f1776a;

        /* JADX INFO: renamed from: d */
        private final CountDownLatch f1778d = new CountDownLatch(1);

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.ModernAsyncTask
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public D mo1828a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.m1825e();
            } catch (OperationCanceledException e) {
                if (!m1893c()) {
                    throw e;
                }
                return null;
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        /* JADX INFO: renamed from: a */
        protected void mo1829a(D d) {
            try {
                AsyncTaskLoader.this.m1821b(this, d);
            } finally {
                this.f1778d.countDown();
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        /* JADX INFO: renamed from: b */
        protected void mo1830b(D d) {
            try {
                AsyncTaskLoader.this.m1818a(this, d);
            } finally {
                this.f1778d.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1776a = false;
            AsyncTaskLoader.this.m1823c();
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f1821c);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f1773d = -10000L;
        this.f1775f = executor;
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: a */
    protected void mo1817a() {
        super.mo1817a();
        m1869s();
        this.f1770a = new LoadTask();
        m1823c();
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: b */
    protected boolean mo1822b() {
        boolean zA = false;
        if (this.f1770a != null) {
            if (!this.f1799r) {
                this.f1802u = true;
            }
            if (this.f1771b != null) {
                if (this.f1770a.f1776a) {
                    this.f1770a.f1776a = false;
                    this.f1774e.removeCallbacks(this.f1770a);
                }
                this.f1770a = null;
            } else if (this.f1770a.f1776a) {
                this.f1770a.f1776a = false;
                this.f1774e.removeCallbacks(this.f1770a);
                this.f1770a = null;
            } else {
                zA = this.f1770a.m1889a(false);
                if (zA) {
                    this.f1771b = this.f1770a;
                    mo1826f();
                }
                this.f1770a = null;
            }
        }
        return zA;
    }

    /* JADX INFO: renamed from: a */
    public void mo1819a(D d) {
    }

    /* JADX INFO: renamed from: c */
    void m1823c() {
        if (this.f1771b == null && this.f1770a != null) {
            if (this.f1770a.f1776a) {
                this.f1770a.f1776a = false;
                this.f1774e.removeCallbacks(this.f1770a);
            }
            if (this.f1772c > 0 && SystemClock.uptimeMillis() < this.f1773d + this.f1772c) {
                this.f1770a.f1776a = true;
                this.f1774e.postAtTime(this.f1770a, this.f1773d + this.f1772c);
            } else {
                this.f1770a.m1887a(this.f1775f, (Void[]) null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1818a(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        mo1819a(d);
        if (this.f1771b == loadTask) {
            m1857A();
            this.f1773d = SystemClock.uptimeMillis();
            this.f1771b = null;
            m1862l();
            m1823c();
        }
    }

    /* JADX INFO: renamed from: b */
    void m1821b(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        if (this.f1770a != loadTask) {
            m1818a(loadTask, d);
            return;
        }
        if (m1866p()) {
            mo1819a(d);
            return;
        }
        m1876z();
        this.f1773d = SystemClock.uptimeMillis();
        this.f1770a = null;
        mo1842b(d);
    }

    /* JADX INFO: renamed from: e */
    protected D m1825e() {
        return mo1824d();
    }

    /* JADX INFO: renamed from: f */
    public void mo1826f() {
    }

    /* JADX INFO: renamed from: g */
    public boolean m1827g() {
        return this.f1771b != null;
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: a */
    public void mo1820a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo1820a(str, fileDescriptor, printWriter, strArr);
        if (this.f1770a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f1770a);
            printWriter.print(" waiting=");
            printWriter.println(this.f1770a.f1776a);
        }
        if (this.f1771b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f1771b);
            printWriter.print(" waiting=");
            printWriter.println(this.f1771b.f1776a);
        }
        if (this.f1772c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.m2472a(this.f1772c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.m2471a(this.f1773d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
