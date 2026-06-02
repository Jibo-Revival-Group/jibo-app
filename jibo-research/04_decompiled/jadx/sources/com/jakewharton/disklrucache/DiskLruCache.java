package com.jakewharton.disklrucache;

import com.facebook.appevents.AppEventsConstants;
import com.yalantis.ucrop.util.FileUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: a */
    static final Pattern f9130a = Pattern.compile("[a-z0-9_-]{1,64}");

    /* JADX INFO: renamed from: p */
    private static final OutputStream f9131p = new OutputStream() { // from class: com.jakewharton.disklrucache.DiskLruCache.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };

    /* JADX INFO: renamed from: c */
    private final File f9133c;

    /* JADX INFO: renamed from: d */
    private final File f9134d;

    /* JADX INFO: renamed from: e */
    private final File f9135e;

    /* JADX INFO: renamed from: f */
    private final File f9136f;

    /* JADX INFO: renamed from: g */
    private final int f9137g;

    /* JADX INFO: renamed from: h */
    private long f9138h;

    /* JADX INFO: renamed from: i */
    private final int f9139i;

    /* JADX INFO: renamed from: k */
    private Writer f9141k;

    /* JADX INFO: renamed from: m */
    private int f9143m;

    /* JADX INFO: renamed from: j */
    private long f9140j = 0;

    /* JADX INFO: renamed from: l */
    private final LinkedHashMap<String, Entry> f9142l = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: n */
    private long f9144n = 0;

    /* JADX INFO: renamed from: b */
    final ThreadPoolExecutor f9132b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: o */
    private final Callable<Void> f9145o = new Callable<Void>() { // from class: com.jakewharton.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f9141k != null) {
                    DiskLruCache.this.m9794i();
                    if (DiskLruCache.this.m9792g()) {
                        DiskLruCache.this.m9791f();
                        DiskLruCache.this.f9143m = 0;
                    }
                }
            }
            return null;
        }
    };

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f9133c = file;
        this.f9137g = i;
        this.f9134d = new File(file, "journal");
        this.f9135e = new File(file, "journal.tmp");
        this.f9136f = new File(file, "journal.bkp");
        this.f9139i = i2;
        this.f9138h = j;
    }

    /* JADX INFO: renamed from: a */
    public static DiskLruCache m9775a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m9780a(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
        if (diskLruCache.f9134d.exists()) {
            try {
                diskLruCache.m9784d();
                diskLruCache.m9788e();
                diskLruCache.f9141k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f9134d, true), Util.f9170a));
                return diskLruCache;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                diskLruCache.m9798b();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
        diskLruCache2.m9791f();
        return diskLruCache2;
    }

    /* JADX INFO: renamed from: d */
    private void m9784d() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f9134d), Util.f9170a);
        try {
            String strM9824a = strictLineReader.m9824a();
            String strM9824a2 = strictLineReader.m9824a();
            String strM9824a3 = strictLineReader.m9824a();
            String strM9824a4 = strictLineReader.m9824a();
            String strM9824a5 = strictLineReader.m9824a();
            if (!"libcore.io.DiskLruCache".equals(strM9824a) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strM9824a2) || !Integer.toString(this.f9137g).equals(strM9824a3) || !Integer.toString(this.f9139i).equals(strM9824a4) || !"".equals(strM9824a5)) {
                throw new IOException("unexpected journal header: [" + strM9824a + ", " + strM9824a2 + ", " + strM9824a4 + ", " + strM9824a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m9786d(strictLineReader.m9824a());
                    i++;
                } catch (EOFException e) {
                    this.f9143m = i - this.f9142l.size();
                    Util.m9825a(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.m9825a(strictLineReader);
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m9786d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            String strSubstring2 = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f9142l.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        Entry entry = this.f9142l.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f9142l.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f9156d = true;
            entry.f9157e = null;
            entry.m9811a(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
            return;
        }
        entry.f9157e = new Editor(entry);
    }

    /* JADX INFO: renamed from: e */
    private void m9788e() throws IOException {
        m9779a(this.f9135e);
        Iterator<Entry> it = this.f9142l.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.f9157e == null) {
                for (int i = 0; i < this.f9139i; i++) {
                    this.f9140j += next.f9155c[i];
                }
            } else {
                next.f9157e = null;
                for (int i2 = 0; i2 < this.f9139i; i2++) {
                    m9779a(next.m9818a(i2));
                    m9779a(next.m9820b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public synchronized void m9791f() throws IOException {
        if (this.f9141k != null) {
            this.f9141k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9135e), Util.f9170a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f9137g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f9139i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.f9142l.values()) {
                if (entry.f9157e != null) {
                    bufferedWriter.write("DIRTY " + entry.f9154b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.f9154b + entry.m9819a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f9134d.exists()) {
                m9780a(this.f9134d, this.f9136f, true);
            }
            m9780a(this.f9135e, this.f9134d, false);
            this.f9136f.delete();
            this.f9141k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f9134d, true), Util.f9170a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m9779a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m9780a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m9779a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized Snapshot m9796a(String str) throws IOException {
        Snapshot snapshot = null;
        synchronized (this) {
            m9793h();
            m9789e(str);
            Entry entry = this.f9142l.get(str);
            if (entry != null && entry.f9156d) {
                InputStream[] inputStreamArr = new InputStream[this.f9139i];
                for (int i = 0; i < this.f9139i; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(entry.m9818a(i));
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.f9139i && inputStreamArr[i2] != null; i2++) {
                            Util.m9825a(inputStreamArr[i2]);
                        }
                    }
                }
                this.f9143m++;
                this.f9141k.append((CharSequence) ("READ " + str + '\n'));
                if (m9792g()) {
                    this.f9132b.submit(this.f9145o);
                }
                snapshot = new Snapshot(str, entry.f9158f, inputStreamArr, entry.f9155c);
            }
        }
        return snapshot;
    }

    /* JADX INFO: renamed from: b */
    public Editor m9797b(String str) throws IOException {
        return m9774a(str, -1L);
    }

    /* JADX INFO: renamed from: a */
    private synchronized Editor m9774a(String str, long j) throws IOException {
        Entry entry;
        Editor editor;
        m9793h();
        m9789e(str);
        Entry entry2 = this.f9142l.get(str);
        if (j == -1 || (entry2 != null && entry2.f9158f == j)) {
            if (entry2 == null) {
                Entry entry3 = new Entry(str);
                this.f9142l.put(str, entry3);
                entry = entry3;
            } else if (entry2.f9157e != null) {
                editor = null;
            } else {
                entry = entry2;
            }
            editor = new Editor(entry);
            entry.f9157e = editor;
            this.f9141k.write("DIRTY " + str + '\n');
            this.f9141k.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    /* JADX INFO: renamed from: a */
    public synchronized long m9795a() {
        return this.f9140j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00ce, B:41:0x00d8, B:43:0x00e5, B:45:0x00eb, B:46:0x00f4), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00ce, B:41:0x00d8, B:43:0x00e5, B:45:0x00eb, B:46:0x00f4), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00ce, B:41:0x00d8, B:43:0x00e5, B:45:0x00eb, B:46:0x00f4), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4 A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00ce, B:41:0x00d8, B:43:0x00e5, B:45:0x00eb, B:46:0x00f4), top: B:48:0x0002 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m9777a(com.jakewharton.disklrucache.DiskLruCache.Editor r11, boolean r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.m9777a(com.jakewharton.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public boolean m9792g() {
        return this.f9143m >= 2000 && this.f9143m >= this.f9142l.size();
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m9799c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            m9793h();
            m9789e(str);
            Entry entry = this.f9142l.get(str);
            if (entry == null || entry.f9157e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f9139i; i++) {
                    File fileM9818a = entry.m9818a(i);
                    if (fileM9818a.exists() && !fileM9818a.delete()) {
                        throw new IOException("failed to delete " + fileM9818a);
                    }
                    this.f9140j -= entry.f9155c[i];
                    entry.f9155c[i] = 0;
                }
                this.f9143m++;
                this.f9141k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f9142l.remove(str);
                if (m9792g()) {
                    this.f9132b.submit(this.f9145o);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: h */
    private void m9793h() {
        if (this.f9141k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f9141k != null) {
            for (Entry entry : new ArrayList(this.f9142l.values())) {
                if (entry.f9157e != null) {
                    entry.f9157e.m9806b();
                }
            }
            m9794i();
            this.f9141k.close();
            this.f9141k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m9794i() throws IOException {
        while (this.f9140j > this.f9138h) {
            m9799c(this.f9142l.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9798b() throws IOException {
        close();
        Util.m9826a(this.f9133c);
    }

    /* JADX INFO: renamed from: e */
    private void m9789e(String str) {
        if (!f9130a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: b */
        private final String f9160b;

        /* JADX INFO: renamed from: c */
        private final long f9161c;

        /* JADX INFO: renamed from: d */
        private final InputStream[] f9162d;

        /* JADX INFO: renamed from: e */
        private final long[] f9163e;

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f9160b = str;
            this.f9161c = j;
            this.f9162d = inputStreamArr;
            this.f9163e = jArr;
        }

        /* JADX INFO: renamed from: a */
        public InputStream m9821a(int i) {
            return this.f9162d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f9162d) {
                Util.m9825a(inputStream);
            }
        }
    }

    public final class Editor {

        /* JADX INFO: renamed from: b */
        private final Entry f9148b;

        /* JADX INFO: renamed from: c */
        private final boolean[] f9149c;

        /* JADX INFO: renamed from: d */
        private boolean f9150d;

        /* JADX INFO: renamed from: e */
        private boolean f9151e;

        private Editor(Entry entry) {
            this.f9148b = entry;
            this.f9149c = entry.f9156d ? null : new boolean[DiskLruCache.this.f9139i];
        }

        /* JADX INFO: renamed from: a */
        public OutputStream m9804a(int i) throws IOException {
            OutputStream faultHidingOutputStream;
            FileOutputStream fileOutputStream;
            synchronized (DiskLruCache.this) {
                if (this.f9148b.f9157e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f9148b.f9156d) {
                    this.f9149c[i] = true;
                }
                File fileM9820b = this.f9148b.m9820b(i);
                try {
                    fileOutputStream = new FileOutputStream(fileM9820b);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.f9133c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileM9820b);
                    } catch (FileNotFoundException e2) {
                        faultHidingOutputStream = DiskLruCache.f9131p;
                    }
                }
                faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
            }
            return faultHidingOutputStream;
        }

        /* JADX INFO: renamed from: a */
        public void m9805a() throws IOException {
            if (this.f9150d) {
                DiskLruCache.this.m9777a(this, false);
                DiskLruCache.this.m9799c(this.f9148b.f9154b);
            } else {
                DiskLruCache.this.m9777a(this, true);
            }
            this.f9151e = true;
        }

        /* JADX INFO: renamed from: b */
        public void m9806b() throws IOException {
            DiskLruCache.this.m9777a(this, false);
        }

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    Editor.this.f9150d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    Editor.this.f9150d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.f9150d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.f9150d = true;
                }
            }
        }
    }

    private final class Entry {

        /* JADX INFO: renamed from: b */
        private final String f9154b;

        /* JADX INFO: renamed from: c */
        private final long[] f9155c;

        /* JADX INFO: renamed from: d */
        private boolean f9156d;

        /* JADX INFO: renamed from: e */
        private Editor f9157e;

        /* JADX INFO: renamed from: f */
        private long f9158f;

        private Entry(String str) {
            this.f9154b = str;
            this.f9155c = new long[DiskLruCache.this.f9139i];
        }

        /* JADX INFO: renamed from: a */
        public String m9819a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f9155c) {
                sb.append(TokenParser.f15715SP).append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m9811a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f9139i) {
                throw m9813b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f9155c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m9813b(strArr);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        private IOException m9813b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: renamed from: a */
        public File m9818a(int i) {
            return new File(DiskLruCache.this.f9133c, this.f9154b + FileUtils.HIDDEN_PREFIX + i);
        }

        /* JADX INFO: renamed from: b */
        public File m9820b(int i) {
            return new File(DiskLruCache.this.f9133c, this.f9154b + FileUtils.HIDDEN_PREFIX + i + ".tmp");
        }
    }
}
