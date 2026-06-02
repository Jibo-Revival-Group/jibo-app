package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* JADX INFO: renamed from: f */
    final Loader<Cursor>.ForceLoadContentObserver f1781f;

    /* JADX INFO: renamed from: g */
    Uri f1782g;

    /* JADX INFO: renamed from: h */
    String[] f1783h;

    /* JADX INFO: renamed from: i */
    String f1784i;

    /* JADX INFO: renamed from: j */
    String[] f1785j;

    /* JADX INFO: renamed from: k */
    String f1786k;

    /* JADX INFO: renamed from: l */
    Cursor f1787l;

    /* JADX INFO: renamed from: m */
    CancellationSignal f1788m;

    @Override // android.support.v4.content.AsyncTaskLoader
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Cursor mo1824d() {
        synchronized (this) {
            if (m1827g()) {
                throw new OperationCanceledException();
            }
            this.f1788m = new CancellationSignal();
        }
        try {
            Cursor cursorM1831a = ContentResolverCompat.m1831a(m1863m().getContentResolver(), this.f1782g, this.f1783h, this.f1784i, this.f1785j, this.f1786k, this.f1788m);
            if (cursorM1831a != null) {
                try {
                    cursorM1831a.getCount();
                    cursorM1831a.registerContentObserver(this.f1781f);
                } catch (RuntimeException e) {
                    cursorM1831a.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.f1788m = null;
            }
            return cursorM1831a;
        } catch (Throwable th) {
            synchronized (this) {
                this.f1788m = null;
                throw th;
            }
        }
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    /* JADX INFO: renamed from: f */
    public void mo1826f() {
        super.mo1826f();
        synchronized (this) {
            if (this.f1788m != null) {
                this.f1788m.m2316c();
            }
        }
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1842b(Cursor cursor) {
        if (m1867q()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f1787l;
        this.f1787l = cursor;
        if (m1865o()) {
            super.mo1842b(cursor);
        }
        if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f1781f = new Loader.ForceLoadContentObserver();
        this.f1782g = uri;
        this.f1783h = strArr;
        this.f1784i = str;
        this.f1785j = strArr2;
        this.f1786k = str2;
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: i */
    protected void mo1844i() {
        if (this.f1787l != null) {
            mo1842b(this.f1787l);
        }
        if (m1875y() || this.f1787l == null) {
            m1870t();
        }
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: j */
    protected void mo1845j() {
        m1869s();
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo1819a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: k */
    protected void mo1846k() {
        super.mo1846k();
        mo1845j();
        if (this.f1787l != null && !this.f1787l.isClosed()) {
            this.f1787l.close();
        }
        this.f1787l = null;
    }

    @Override // android.support.v4.content.AsyncTaskLoader, android.support.v4.content.Loader
    /* JADX INFO: renamed from: a */
    public void mo1820a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo1820a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f1782g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f1783h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f1784i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f1785j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f1786k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f1787l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f1802u);
    }
}
