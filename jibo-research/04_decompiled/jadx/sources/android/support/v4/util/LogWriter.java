package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class LogWriter extends Writer {

    /* JADX INFO: renamed from: a */
    private final String f2198a;

    /* JADX INFO: renamed from: b */
    private StringBuilder f2199b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f2198a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m2403a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m2403a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m2403a();
            } else {
                this.f2199b.append(c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2403a() {
        if (this.f2199b.length() > 0) {
            Log.d(this.f2198a, this.f2199b.toString());
            this.f2199b.delete(0, this.f2199b.length());
        }
    }
}
