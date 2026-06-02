package com.bumptech.glide.disklrucache;

import com.facebook.appevents.AppEventsConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: b */
    private final File f4744b;

    /* JADX INFO: renamed from: c */
    private final File f4745c;

    /* JADX INFO: renamed from: d */
    private final File f4746d;

    /* JADX INFO: renamed from: e */
    private final File f4747e;

    /* JADX INFO: renamed from: f */
    private final int f4748f;

    /* JADX INFO: renamed from: g */
    private long f4749g;

    /* JADX INFO: renamed from: h */
    private final int f4750h;

    /* JADX INFO: renamed from: j */
    private Writer f4752j;

    /* JADX INFO: renamed from: l */
    private int f4754l;

    /* JADX INFO: renamed from: i */
    private long f4751i = 0;

    /* JADX INFO: renamed from: k */
    private final LinkedHashMap<String, Entry> f4753k = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: m */
    private long f4755m = 0;

    /* JADX INFO: renamed from: a */
    final ThreadPoolExecutor f4743a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: n */
    private final Callable<Void> f4756n = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f4752j != null) {
                    DiskLruCache.this.m5313g();
                    if (DiskLruCache.this.m5310e()) {
                        DiskLruCache.this.m5306d();
                        DiskLruCache.this.f4754l = 0;
                    }
                }
            }
            return null;
        }
    };

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f4744b = file;
        this.f4748f = i;
        this.f4745c = new File(file, "journal");
        this.f4746d = new File(file, "journal.tmp");
        this.f4747e = new File(file, "journal.bkp");
        this.f4750h = i2;
        this.f4749g = j;
    }

    /* JADX INFO: renamed from: a */
    public static DiskLruCache m5296a(File file, int i, int i2, long j) throws IOException {
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
                m5301a(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
        if (diskLruCache.f4745c.exists()) {
            try {
                diskLruCache.m5302b();
                diskLruCache.m5304c();
                return diskLruCache;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                diskLruCache.m5315a();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
        diskLruCache2.m5306d();
        return diskLruCache2;
    }

    /* JADX INFO: renamed from: b */
    private void m5302b() throws IOException {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f4745c), Util.f4781a);
        try {
            String strM5342a = strictLineReader.m5342a();
            String strM5342a2 = strictLineReader.m5342a();
            String strM5342a3 = strictLineReader.m5342a();
            String strM5342a4 = strictLineReader.m5342a();
            String strM5342a5 = strictLineReader.m5342a();
            if (!"libcore.io.DiskLruCache".equals(strM5342a) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strM5342a2) || !Integer.toString(this.f4748f).equals(strM5342a3) || !Integer.toString(this.f4750h).equals(strM5342a4) || !"".equals(strM5342a5)) {
                throw new IOException("unexpected journal header: [" + strM5342a + ", " + strM5342a2 + ", " + strM5342a4 + ", " + strM5342a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m5308d(strictLineReader.m5342a());
                    i++;
                } catch (EOFException e) {
                    this.f4754l = i - this.f4753k.size();
                    if (strictLineReader.m5343b()) {
                        m5306d();
                    } else {
                        this.f4752j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4745c, true), Util.f4781a));
                    }
                    Util.m5344a(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.m5344a(strictLineReader);
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m5308d(String str) throws IOException {
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
                this.f4753k.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        Entry entry = this.f4753k.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f4753k.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f4767f = true;
            entry.f4768g = null;
            entry.m5329a(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
            return;
        }
        entry.f4768g = new Editor(entry);
    }

    /* JADX INFO: renamed from: c */
    private void m5304c() throws IOException {
        m5300a(this.f4746d);
        Iterator<Entry> it = this.f4753k.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.f4768g == null) {
                for (int i = 0; i < this.f4750h; i++) {
                    this.f4751i += next.f4766e[i];
                }
            } else {
                next.f4768g = null;
                for (int i2 = 0; i2 < this.f4750h; i2++) {
                    m5300a(next.m5336a(i2));
                    m5300a(next.m5338b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public synchronized void m5306d() throws IOException {
        if (this.f4752j != null) {
            this.f4752j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4746d), Util.f4781a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f4748f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f4750h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.f4753k.values()) {
                if (entry.f4768g != null) {
                    bufferedWriter.write("DIRTY " + entry.f4765d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.f4765d + entry.m5337a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f4745c.exists()) {
                m5301a(this.f4745c, this.f4747e, true);
            }
            m5301a(this.f4746d, this.f4745c, false);
            this.f4747e.delete();
            this.f4752j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4745c, true), Util.f4781a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5300a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5301a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m5300a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        r9.f4754l++;
        r9.f4752j.append((java.lang.CharSequence) "READ");
        r9.f4752j.append(org.apache.http.message.TokenParser.f15715SP);
        r9.f4752j.append((java.lang.CharSequence) r10);
        r9.f4752j.append('\n');
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (m5310e() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        r9.f4743a.submit(r9.f4756n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        r1 = new com.bumptech.glide.disklrucache.DiskLruCache.Value(r9, r10, r0.f4769h, r0.f4762a, r0.f4766e, null);
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.bumptech.glide.disklrucache.DiskLruCache.Value m5314a(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            r1 = 0
            monitor-enter(r9)
            r9.m5312f()     // Catch: java.lang.Throwable -> L68
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r9.f4753k     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L11
        Lf:
            monitor-exit(r9)
            return r1
        L11:
            boolean r2 = com.bumptech.glide.disklrucache.DiskLruCache.Entry.m5334d(r0)     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto Lf
            java.io.File[] r3 = r0.f4762a     // Catch: java.lang.Throwable -> L68
            int r4 = r3.length     // Catch: java.lang.Throwable -> L68
            r2 = 0
        L1b:
            if (r2 >= r4) goto L28
            r5 = r3[r2]     // Catch: java.lang.Throwable -> L68
            boolean r5 = r5.exists()     // Catch: java.lang.Throwable -> L68
            if (r5 == 0) goto Lf
            int r2 = r2 + 1
            goto L1b
        L28:
            int r1 = r9.f4754l     // Catch: java.lang.Throwable -> L68
            int r1 = r1 + 1
            r9.f4754l = r1     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.f4752j     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = "READ"
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.f4752j     // Catch: java.lang.Throwable -> L68
            r2 = 32
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.f4752j     // Catch: java.lang.Throwable -> L68
            r1.append(r10)     // Catch: java.lang.Throwable -> L68
            java.io.Writer r1 = r9.f4752j     // Catch: java.lang.Throwable -> L68
            r2 = 10
            r1.append(r2)     // Catch: java.lang.Throwable -> L68
            boolean r1 = r9.m5310e()     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L55
            java.util.concurrent.ThreadPoolExecutor r1 = r9.f4743a     // Catch: java.lang.Throwable -> L68
            java.util.concurrent.Callable<java.lang.Void> r2 = r9.f4756n     // Catch: java.lang.Throwable -> L68
            r1.submit(r2)     // Catch: java.lang.Throwable -> L68
        L55:
            com.bumptech.glide.disklrucache.DiskLruCache$Value r1 = new com.bumptech.glide.disklrucache.DiskLruCache$Value     // Catch: java.lang.Throwable -> L68
            long r4 = com.bumptech.glide.disklrucache.DiskLruCache.Entry.m5335e(r0)     // Catch: java.lang.Throwable -> L68
            java.io.File[] r6 = r0.f4762a     // Catch: java.lang.Throwable -> L68
            long[] r7 = com.bumptech.glide.disklrucache.DiskLruCache.Entry.m5332b(r0)     // Catch: java.lang.Throwable -> L68
            r8 = 0
            r2 = r9
            r3 = r10
            r1.<init>(r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L68
            goto Lf
        L68:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.m5314a(java.lang.String):com.bumptech.glide.disklrucache.DiskLruCache$Value");
    }

    /* JADX INFO: renamed from: b */
    public Editor m5316b(String str) throws IOException {
        return m5295a(str, -1L);
    }

    /* JADX INFO: renamed from: a */
    private synchronized Editor m5295a(String str, long j) throws IOException {
        Entry entry;
        Editor editor;
        m5312f();
        Entry entry2 = this.f4753k.get(str);
        if (j == -1 || (entry2 != null && entry2.f4769h == j)) {
            if (entry2 == null) {
                Entry entry3 = new Entry(str);
                this.f4753k.put(str, entry3);
                entry = entry3;
            } else if (entry2.f4768g != null) {
                editor = null;
            } else {
                entry = entry2;
            }
            editor = new Editor(entry);
            entry.f4768g = editor;
            this.f4752j.append((CharSequence) "DIRTY");
            this.f4752j.append(TokenParser.f15715SP);
            this.f4752j.append((CharSequence) str);
            this.f4752j.append('\n');
            this.f4752j.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8 A[Catch: all -> 0x0012, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1 A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000c, B:7:0x0011, B:12:0x0017, B:15:0x001e, B:17:0x0022, B:19:0x002a, B:20:0x0045, B:21:0x0046, B:23:0x0050, B:27:0x0058, B:29:0x005c, B:31:0x0062, B:33:0x0068, B:34:0x0086, B:35:0x0089, B:36:0x008d, B:38:0x009e, B:40:0x00cb, B:41:0x00d5, B:43:0x00e2, B:45:0x00e8, B:46:0x00f1), top: B:48:0x0002 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m5298a(com.bumptech.glide.disklrucache.DiskLruCache.Editor r11, boolean r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.m5298a(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public boolean m5310e() {
        return this.f4754l >= 2000 && this.f4754l >= this.f4753k.size();
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m5317c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            m5312f();
            Entry entry = this.f4753k.get(str);
            if (entry == null || entry.f4768g != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f4750h; i++) {
                    File fileM5336a = entry.m5336a(i);
                    if (fileM5336a.exists() && !fileM5336a.delete()) {
                        throw new IOException("failed to delete " + fileM5336a);
                    }
                    this.f4751i -= entry.f4766e[i];
                    entry.f4766e[i] = 0;
                }
                this.f4754l++;
                this.f4752j.append((CharSequence) "REMOVE");
                this.f4752j.append(TokenParser.f15715SP);
                this.f4752j.append((CharSequence) str);
                this.f4752j.append('\n');
                this.f4753k.remove(str);
                if (m5310e()) {
                    this.f4743a.submit(this.f4756n);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: f */
    private void m5312f() {
        if (this.f4752j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f4752j != null) {
            for (Entry entry : new ArrayList(this.f4753k.values())) {
                if (entry.f4768g != null) {
                    entry.f4768g.m5323b();
                }
            }
            m5313g();
            this.f4752j.close();
            this.f4752j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m5313g() throws IOException {
        while (this.f4751i > this.f4749g) {
            m5317c(this.f4753k.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5315a() throws IOException {
        close();
        Util.m5345a(this.f4744b);
    }

    public final class Value {

        /* JADX INFO: renamed from: b */
        private final String f4771b;

        /* JADX INFO: renamed from: c */
        private final long f4772c;

        /* JADX INFO: renamed from: d */
        private final long[] f4773d;

        /* JADX INFO: renamed from: e */
        private final File[] f4774e;

        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.f4771b = str;
            this.f4772c = j;
            this.f4774e = fileArr;
            this.f4773d = jArr;
        }

        /* JADX INFO: renamed from: a */
        public File m5339a(int i) {
            return this.f4774e[i];
        }
    }

    public final class Editor {

        /* JADX INFO: renamed from: b */
        private final Entry f4759b;

        /* JADX INFO: renamed from: c */
        private final boolean[] f4760c;

        /* JADX INFO: renamed from: d */
        private boolean f4761d;

        private Editor(Entry entry) {
            this.f4759b = entry;
            this.f4760c = entry.f4767f ? null : new boolean[DiskLruCache.this.f4750h];
        }

        /* JADX INFO: renamed from: a */
        public File m5321a(int i) throws IOException {
            File fileM5338b;
            synchronized (DiskLruCache.this) {
                if (this.f4759b.f4768g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4759b.f4767f) {
                    this.f4760c[i] = true;
                }
                fileM5338b = this.f4759b.m5338b(i);
                if (!DiskLruCache.this.f4744b.exists()) {
                    DiskLruCache.this.f4744b.mkdirs();
                }
            }
            return fileM5338b;
        }

        /* JADX INFO: renamed from: a */
        public void m5322a() throws IOException {
            DiskLruCache.this.m5298a(this, true);
            this.f4761d = true;
        }

        /* JADX INFO: renamed from: b */
        public void m5323b() throws IOException {
            DiskLruCache.this.m5298a(this, false);
        }

        /* JADX INFO: renamed from: c */
        public void m5324c() {
            if (!this.f4761d) {
                try {
                    m5323b();
                } catch (IOException e) {
                }
            }
        }
    }

    private final class Entry {

        /* JADX INFO: renamed from: a */
        File[] f4762a;

        /* JADX INFO: renamed from: b */
        File[] f4763b;

        /* JADX INFO: renamed from: d */
        private final String f4765d;

        /* JADX INFO: renamed from: e */
        private final long[] f4766e;

        /* JADX INFO: renamed from: f */
        private boolean f4767f;

        /* JADX INFO: renamed from: g */
        private Editor f4768g;

        /* JADX INFO: renamed from: h */
        private long f4769h;

        private Entry(String str) {
            this.f4765d = str;
            this.f4766e = new long[DiskLruCache.this.f4750h];
            this.f4762a = new File[DiskLruCache.this.f4750h];
            this.f4763b = new File[DiskLruCache.this.f4750h];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < DiskLruCache.this.f4750h; i++) {
                sbAppend.append(i);
                this.f4762a[i] = new File(DiskLruCache.this.f4744b, sbAppend.toString());
                sbAppend.append(".tmp");
                this.f4763b[i] = new File(DiskLruCache.this.f4744b, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* JADX INFO: renamed from: a */
        public String m5337a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4766e) {
                sb.append(TokenParser.f15715SP).append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m5329a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f4750h) {
                throw m5331b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f4766e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m5331b(strArr);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        private IOException m5331b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: renamed from: a */
        public File m5336a(int i) {
            return this.f4762a[i];
        }

        /* JADX INFO: renamed from: b */
        public File m5338b(int i) {
            return this.f4763b[i];
        }
    }
}
