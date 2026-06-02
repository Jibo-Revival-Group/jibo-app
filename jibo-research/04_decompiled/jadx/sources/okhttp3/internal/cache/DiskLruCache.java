package okhttp3.internal.cache;

import com.facebook.appevents.AppEventsConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.p026io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    static final Pattern f15276a;

    /* JADX INFO: renamed from: m */
    static final /* synthetic */ boolean f15277m;

    /* JADX INFO: renamed from: b */
    final FileSystem f15278b;

    /* JADX INFO: renamed from: c */
    final File f15279c;

    /* JADX INFO: renamed from: d */
    final int f15280d;

    /* JADX INFO: renamed from: e */
    BufferedSink f15281e;

    /* JADX INFO: renamed from: g */
    int f15283g;

    /* JADX INFO: renamed from: h */
    boolean f15284h;

    /* JADX INFO: renamed from: i */
    boolean f15285i;

    /* JADX INFO: renamed from: j */
    boolean f15286j;

    /* JADX INFO: renamed from: k */
    boolean f15287k;

    /* JADX INFO: renamed from: l */
    boolean f15288l;

    /* JADX INFO: renamed from: n */
    private final File f15289n;

    /* JADX INFO: renamed from: o */
    private final File f15290o;

    /* JADX INFO: renamed from: p */
    private final File f15291p;

    /* JADX INFO: renamed from: q */
    private final int f15292q;

    /* JADX INFO: renamed from: r */
    private long f15293r;

    /* JADX INFO: renamed from: u */
    private final Executor f15296u;

    /* JADX INFO: renamed from: s */
    private long f15294s = 0;

    /* JADX INFO: renamed from: f */
    final LinkedHashMap<String, Entry> f15282f = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: t */
    private long f15295t = 0;

    /* JADX INFO: renamed from: v */
    private final Runnable f15297v = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if (!((DiskLruCache.this.f15285i ? false : true) | DiskLruCache.this.f15286j)) {
                    try {
                        DiskLruCache.this.m15889e();
                    } catch (IOException e) {
                        DiskLruCache.this.f15287k = true;
                    }
                    try {
                        if (DiskLruCache.this.m15886c()) {
                            DiskLruCache.this.m15885b();
                            DiskLruCache.this.f15283g = 0;
                        }
                    } catch (IOException e2) {
                        DiskLruCache.this.f15288l = true;
                        DiskLruCache.this.f15281e = Okio.m16359a(Okio.m16361a());
                    }
                }
            }
        }
    };

    static {
        f15277m = !DiskLruCache.class.desiredAssertionStatus();
        f15276a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f15278b = fileSystem;
        this.f15279c = file;
        this.f15292q = i;
        this.f15289n = new File(file, "journal");
        this.f15290o = new File(file, "journal.tmp");
        this.f15291p = new File(file, "journal.bkp");
        this.f15280d = i2;
        this.f15293r = j;
        this.f15296u = executor;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15881a() throws IOException {
        if (!f15277m && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f15285i) {
            if (this.f15278b.mo16173e(this.f15291p)) {
                if (this.f15278b.mo16173e(this.f15289n)) {
                    this.f15278b.mo16172d(this.f15291p);
                } else {
                    this.f15278b.mo16169a(this.f15291p, this.f15289n);
                }
            }
            if (this.f15278b.mo16173e(this.f15289n)) {
                try {
                    m15875g();
                    m15877i();
                    this.f15285i = true;
                } catch (IOException e) {
                    Platform.m16203b().mo16181a(5, "DiskLruCache " + this.f15279c + " is corrupt: " + e.getMessage() + ", removing", e);
                    try {
                        m15890f();
                        this.f15286j = false;
                        m15885b();
                        this.f15285i = true;
                    } catch (Throwable th) {
                        this.f15286j = false;
                        throw th;
                    }
                }
            } else {
                m15885b();
                this.f15285i = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static DiskLruCache m15872a(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m15841a("OkHttp DiskLruCache", true)));
    }

    /* JADX INFO: renamed from: g */
    private void m15875g() throws IOException {
        BufferedSource bufferedSourceM16360a = Okio.m16360a(this.f15278b.mo16168a(this.f15289n));
        try {
            String strMo16307r = bufferedSourceM16360a.mo16307r();
            String strMo16307r2 = bufferedSourceM16360a.mo16307r();
            String strMo16307r3 = bufferedSourceM16360a.mo16307r();
            String strMo16307r4 = bufferedSourceM16360a.mo16307r();
            String strMo16307r5 = bufferedSourceM16360a.mo16307r();
            if (!"libcore.io.DiskLruCache".equals(strMo16307r) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strMo16307r2) || !Integer.toString(this.f15292q).equals(strMo16307r3) || !Integer.toString(this.f15280d).equals(strMo16307r4) || !"".equals(strMo16307r5)) {
                throw new IOException("unexpected journal header: [" + strMo16307r + ", " + strMo16307r2 + ", " + strMo16307r4 + ", " + strMo16307r5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m15873d(bufferedSourceM16360a.mo16307r());
                    i++;
                } catch (EOFException e) {
                    this.f15283g = i - this.f15282f.size();
                    if (!bufferedSourceM16360a.mo16283f()) {
                        m15885b();
                    } else {
                        this.f15281e = m15876h();
                    }
                    Util.m15843a(bufferedSourceM16360a);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.m15843a(bufferedSourceM16360a);
            throw th;
        }
    }

    /* JADX INFO: renamed from: h */
    private BufferedSink m15876h() throws FileNotFoundException {
        return Okio.m16359a(new FaultHidingSink(this.f15278b.mo16171c(this.f15289n)) { // from class: okhttp3.internal.cache.DiskLruCache.2

            /* JADX INFO: renamed from: a */
            static final /* synthetic */ boolean f15299a;

            static {
                f15299a = !DiskLruCache.class.desiredAssertionStatus();
            }

            @Override // okhttp3.internal.cache.FaultHidingSink
            /* JADX INFO: renamed from: a */
            protected void mo15891a(IOException iOException) {
                if (!f15299a && !Thread.holdsLock(DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.f15284h = true;
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private void m15873d(String str) throws IOException {
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
                this.f15282f.remove(strSubstring2);
                return;
            }
            strSubstring = strSubstring2;
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        Entry entry = this.f15282f.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f15282f.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f15310e = true;
            entry.f15311f = null;
            entry.m15899a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            entry.f15311f = new Editor(entry);
        } else if (iIndexOf2 != -1 || iIndexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m15877i() throws IOException {
        this.f15278b.mo16172d(this.f15290o);
        Iterator<Entry> it = this.f15282f.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            if (next.f15311f == null) {
                for (int i = 0; i < this.f15280d; i++) {
                    this.f15294s += next.f15307b[i];
                }
            } else {
                next.f15311f = null;
                for (int i2 = 0; i2 < this.f15280d; i2++) {
                    this.f15278b.mo16172d(next.f15308c[i2]);
                    this.f15278b.mo16172d(next.f15309d[i2]);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    synchronized void m15885b() throws IOException {
        if (this.f15281e != null) {
            this.f15281e.close();
        }
        BufferedSink bufferedSinkM16359a = Okio.m16359a(this.f15278b.mo16170b(this.f15290o));
        try {
            bufferedSinkM16359a.mo16267b("libcore.io.DiskLruCache").mo16298k(10);
            bufferedSinkM16359a.mo16267b(AppEventsConstants.EVENT_PARAM_VALUE_YES).mo16298k(10);
            bufferedSinkM16359a.mo16302m(this.f15292q).mo16298k(10);
            bufferedSinkM16359a.mo16302m(this.f15280d).mo16298k(10);
            bufferedSinkM16359a.mo16298k(10);
            for (Entry entry : this.f15282f.values()) {
                if (entry.f15311f != null) {
                    bufferedSinkM16359a.mo16267b("DIRTY").mo16298k(32);
                    bufferedSinkM16359a.mo16267b(entry.f15306a);
                    bufferedSinkM16359a.mo16298k(10);
                } else {
                    bufferedSinkM16359a.mo16267b("CLEAN").mo16298k(32);
                    bufferedSinkM16359a.mo16267b(entry.f15306a);
                    entry.m15898a(bufferedSinkM16359a);
                    bufferedSinkM16359a.mo16298k(10);
                }
            }
            bufferedSinkM16359a.close();
            if (this.f15278b.mo16173e(this.f15289n)) {
                this.f15278b.mo16169a(this.f15289n, this.f15291p);
            }
            this.f15278b.mo16169a(this.f15290o, this.f15289n);
            this.f15278b.mo16172d(this.f15291p);
            this.f15281e = m15876h();
            this.f15284h = false;
            this.f15288l = false;
        } catch (Throwable th) {
            bufferedSinkM16359a.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized Snapshot m15880a(String str) throws IOException {
        Snapshot snapshotM15897a;
        m15881a();
        m15878j();
        m15874e(str);
        Entry entry = this.f15282f.get(str);
        if (entry == null || !entry.f15310e || (snapshotM15897a = entry.m15897a()) == null) {
            snapshotM15897a = null;
        } else {
            this.f15283g++;
            this.f15281e.mo16267b("READ").mo16298k(32).mo16267b(str).mo16298k(10);
            if (m15886c()) {
                this.f15296u.execute(this.f15297v);
            }
        }
        return snapshotM15897a;
    }

    /* JADX INFO: renamed from: b */
    public Editor m15884b(String str) throws IOException {
        return m15879a(str, -1L);
    }

    /* JADX INFO: renamed from: a */
    synchronized Editor m15879a(String str, long j) throws IOException {
        Editor editor;
        Entry entry;
        m15881a();
        m15878j();
        m15874e(str);
        Entry entry2 = this.f15282f.get(str);
        if (j != -1 && (entry2 == null || entry2.f15312g != j)) {
            editor = null;
        } else if (entry2 != null && entry2.f15311f != null) {
            editor = null;
        } else if (this.f15287k || this.f15288l) {
            this.f15296u.execute(this.f15297v);
            editor = null;
        } else {
            this.f15281e.mo16267b("DIRTY").mo16298k(32).mo16267b(str).mo16298k(10);
            this.f15281e.flush();
            if (this.f15284h) {
                editor = null;
            } else {
                if (entry2 == null) {
                    Entry entry3 = new Entry(str);
                    this.f15282f.put(str, entry3);
                    entry = entry3;
                } else {
                    entry = entry2;
                }
                editor = new Editor(entry);
                entry.f15311f = editor;
            }
        }
        return editor;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056 A[Catch: all -> 0x000e, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0008, B:7:0x000d, B:12:0x0013, B:15:0x0018, B:17:0x001c, B:19:0x0022, B:20:0x003d, B:21:0x003e, B:23:0x004a, B:27:0x0052, B:29:0x0056, B:31:0x005c, B:33:0x0064, B:34:0x0082, B:35:0x0085, B:36:0x008b, B:38:0x0099, B:40:0x00be, B:41:0x00c7, B:43:0x00d4, B:45:0x00da, B:46:0x00e3), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[Catch: all -> 0x000e, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0008, B:7:0x000d, B:12:0x0013, B:15:0x0018, B:17:0x001c, B:19:0x0022, B:20:0x003d, B:21:0x003e, B:23:0x004a, B:27:0x0052, B:29:0x0056, B:31:0x005c, B:33:0x0064, B:34:0x0082, B:35:0x0085, B:36:0x008b, B:38:0x0099, B:40:0x00be, B:41:0x00c7, B:43:0x00d4, B:45:0x00da, B:46:0x00e3), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da A[Catch: all -> 0x000e, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0008, B:7:0x000d, B:12:0x0013, B:15:0x0018, B:17:0x001c, B:19:0x0022, B:20:0x003d, B:21:0x003e, B:23:0x004a, B:27:0x0052, B:29:0x0056, B:31:0x005c, B:33:0x0064, B:34:0x0082, B:35:0x0085, B:36:0x008b, B:38:0x0099, B:40:0x00be, B:41:0x00c7, B:43:0x00d4, B:45:0x00da, B:46:0x00e3), top: B:48:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0008, B:7:0x000d, B:12:0x0013, B:15:0x0018, B:17:0x001c, B:19:0x0022, B:20:0x003d, B:21:0x003e, B:23:0x004a, B:27:0x0052, B:29:0x0056, B:31:0x005c, B:33:0x0064, B:34:0x0082, B:35:0x0085, B:36:0x008b, B:38:0x0099, B:40:0x00be, B:41:0x00c7, B:43:0x00d4, B:45:0x00da, B:46:0x00e3), top: B:48:0x0002 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    synchronized void m15882a(okhttp3.internal.cache.DiskLruCache.Editor r11, boolean r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.m15882a(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    /* JADX INFO: renamed from: c */
    boolean m15886c() {
        return this.f15283g >= 2000 && this.f15283g >= this.f15282f.size();
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m15887c(String str) throws IOException {
        boolean zM15883a;
        m15881a();
        m15878j();
        m15874e(str);
        Entry entry = this.f15282f.get(str);
        if (entry == null) {
            zM15883a = false;
        } else {
            zM15883a = m15883a(entry);
            if (zM15883a && this.f15294s <= this.f15293r) {
                this.f15287k = false;
            }
        }
        return zM15883a;
    }

    /* JADX INFO: renamed from: a */
    boolean m15883a(Entry entry) throws IOException {
        if (entry.f15311f != null) {
            entry.f15311f.m15893a();
        }
        for (int i = 0; i < this.f15280d; i++) {
            this.f15278b.mo16172d(entry.f15308c[i]);
            this.f15294s -= entry.f15307b[i];
            entry.f15307b[i] = 0;
        }
        this.f15283g++;
        this.f15281e.mo16267b("REMOVE").mo16298k(32).mo16267b(entry.f15306a).mo16298k(10);
        this.f15282f.remove(entry.f15306a);
        if (m15886c()) {
            this.f15296u.execute(this.f15297v);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m15888d() {
        return this.f15286j;
    }

    /* JADX INFO: renamed from: j */
    private synchronized void m15878j() {
        if (m15888d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f15285i) {
            m15878j();
            m15889e();
            this.f15281e.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.f15285i || this.f15286j) {
            this.f15286j = true;
        } else {
            for (Entry entry : (Entry[]) this.f15282f.values().toArray(new Entry[this.f15282f.size()])) {
                if (entry.f15311f != null) {
                    entry.f15311f.m15895c();
                }
            }
            m15889e();
            this.f15281e.close();
            this.f15281e = null;
            this.f15286j = true;
        }
    }

    /* JADX INFO: renamed from: e */
    void m15889e() throws IOException {
        while (this.f15294s > this.f15293r) {
            m15883a(this.f15282f.values().iterator().next());
        }
        this.f15287k = false;
    }

    /* JADX INFO: renamed from: f */
    public void m15890f() throws IOException {
        close();
        this.f15278b.mo16175g(this.f15279c);
    }

    /* JADX INFO: renamed from: e */
    private void m15874e(String str) {
        if (!f15276a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: b */
        private final String f15315b;

        /* JADX INFO: renamed from: c */
        private final long f15316c;

        /* JADX INFO: renamed from: d */
        private final Source[] f15317d;

        /* JADX INFO: renamed from: e */
        private final long[] f15318e;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.f15315b = str;
            this.f15316c = j;
            this.f15317d = sourceArr;
            this.f15318e = jArr;
        }

        /* JADX INFO: renamed from: a */
        public Editor m15900a() throws IOException {
            return DiskLruCache.this.m15879a(this.f15315b, this.f15316c);
        }

        /* JADX INFO: renamed from: a */
        public Source m15901a(int i) {
            return this.f15317d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f15317d) {
                Util.m15843a(source);
            }
        }
    }

    public final class Editor {

        /* JADX INFO: renamed from: a */
        final Entry f15301a;

        /* JADX INFO: renamed from: b */
        final boolean[] f15302b;

        /* JADX INFO: renamed from: d */
        private boolean f15304d;

        Editor(Entry entry) {
            this.f15301a = entry;
            this.f15302b = entry.f15310e ? null : new boolean[DiskLruCache.this.f15280d];
        }

        /* JADX INFO: renamed from: a */
        void m15893a() {
            if (this.f15301a.f15311f == this) {
                for (int i = 0; i < DiskLruCache.this.f15280d; i++) {
                    try {
                        DiskLruCache.this.f15278b.mo16172d(this.f15301a.f15309d[i]);
                    } catch (IOException e) {
                    }
                }
                this.f15301a.f15311f = null;
            }
        }

        /* JADX INFO: renamed from: a */
        public Sink m15892a(int i) {
            Sink sinkM16361a;
            synchronized (DiskLruCache.this) {
                if (this.f15304d) {
                    throw new IllegalStateException();
                }
                if (this.f15301a.f15311f != this) {
                    sinkM16361a = Okio.m16361a();
                } else {
                    if (!this.f15301a.f15310e) {
                        this.f15302b[i] = true;
                    }
                    try {
                        sinkM16361a = new FaultHidingSink(DiskLruCache.this.f15278b.mo16170b(this.f15301a.f15309d[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                            @Override // okhttp3.internal.cache.FaultHidingSink
                            /* JADX INFO: renamed from: a */
                            protected void mo15891a(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.m15893a();
                                }
                            }
                        };
                    } catch (FileNotFoundException e) {
                        sinkM16361a = Okio.m16361a();
                    }
                }
                return sinkM16361a;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m15894b() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f15304d) {
                    throw new IllegalStateException();
                }
                if (this.f15301a.f15311f == this) {
                    DiskLruCache.this.m15882a(this, true);
                }
                this.f15304d = true;
            }
        }

        /* JADX INFO: renamed from: c */
        public void m15895c() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f15304d) {
                    throw new IllegalStateException();
                }
                if (this.f15301a.f15311f == this) {
                    DiskLruCache.this.m15882a(this, false);
                }
                this.f15304d = true;
            }
        }
    }

    private final class Entry {

        /* JADX INFO: renamed from: a */
        final String f15306a;

        /* JADX INFO: renamed from: b */
        final long[] f15307b;

        /* JADX INFO: renamed from: c */
        final File[] f15308c;

        /* JADX INFO: renamed from: d */
        final File[] f15309d;

        /* JADX INFO: renamed from: e */
        boolean f15310e;

        /* JADX INFO: renamed from: f */
        Editor f15311f;

        /* JADX INFO: renamed from: g */
        long f15312g;

        Entry(String str) {
            this.f15306a = str;
            this.f15307b = new long[DiskLruCache.this.f15280d];
            this.f15308c = new File[DiskLruCache.this.f15280d];
            this.f15309d = new File[DiskLruCache.this.f15280d];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < DiskLruCache.this.f15280d; i++) {
                sbAppend.append(i);
                this.f15308c[i] = new File(DiskLruCache.this.f15279c, sbAppend.toString());
                sbAppend.append(".tmp");
                this.f15309d[i] = new File(DiskLruCache.this.f15279c, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* JADX INFO: renamed from: a */
        void m15899a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f15280d) {
                throw m15896b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f15307b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m15896b(strArr);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m15898a(BufferedSink bufferedSink) throws IOException {
            for (long j : this.f15307b) {
                bufferedSink.mo16298k(32).mo16302m(j);
            }
        }

        /* JADX INFO: renamed from: b */
        private IOException m15896b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: renamed from: a */
        Snapshot m15897a() {
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f15280d];
            long[] jArr = (long[]) this.f15307b.clone();
            for (int i = 0; i < DiskLruCache.this.f15280d; i++) {
                try {
                    sourceArr[i] = DiskLruCache.this.f15278b.mo16168a(this.f15308c[i]);
                } catch (FileNotFoundException e) {
                    for (int i2 = 0; i2 < DiskLruCache.this.f15280d && sourceArr[i2] != null; i2++) {
                        Util.m15843a(sourceArr[i2]);
                    }
                    try {
                        DiskLruCache.this.m15883a(this);
                    } catch (IOException e2) {
                    }
                    return null;
                }
            }
            return DiskLruCache.this.new Snapshot(this.f15306a, this.f15312g, sourceArr, jArr);
        }
    }
}
