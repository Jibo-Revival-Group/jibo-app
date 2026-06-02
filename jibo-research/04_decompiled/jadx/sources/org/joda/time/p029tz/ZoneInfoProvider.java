package org.joda.time.p029tz;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class ZoneInfoProvider implements Provider {

    /* JADX INFO: renamed from: a */
    private final File f16192a;

    /* JADX INFO: renamed from: b */
    private final String f16193b;

    /* JADX INFO: renamed from: c */
    private final ClassLoader f16194c;

    /* JADX INFO: renamed from: d */
    private final Map<String, Object> f16195d;

    /* JADX INFO: renamed from: e */
    private final Set<String> f16196e;

    public ZoneInfoProvider(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("No file directory provided");
        }
        if (!file.exists()) {
            throw new IOException("File directory doesn't exist: " + file);
        }
        if (!file.isDirectory()) {
            throw new IOException("File doesn't refer to a directory: " + file);
        }
        this.f16192a = file;
        this.f16193b = null;
        this.f16194c = null;
        this.f16195d = m17011a(m17013b("ZoneInfoMap"));
        this.f16196e = Collections.unmodifiableSortedSet(new TreeSet(this.f16195d.keySet()));
    }

    public ZoneInfoProvider(String str) throws IOException {
        this(str, null, false);
    }

    private ZoneInfoProvider(String str, ClassLoader classLoader, boolean z) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("No resource path provided");
        }
        str = str.endsWith("/") ? str : str + '/';
        this.f16192a = null;
        this.f16193b = str;
        if (classLoader == null && !z) {
            classLoader = getClass().getClassLoader();
        }
        this.f16194c = classLoader;
        this.f16195d = m17011a(m17013b("ZoneInfoMap"));
        this.f16196e = Collections.unmodifiableSortedSet(new TreeSet(this.f16195d.keySet()));
    }

    @Override // org.joda.time.p029tz.Provider
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo17009a(String str) {
        Object obj;
        if (str != null && (obj = this.f16195d.get(str)) != null) {
            if (obj instanceof SoftReference) {
                DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
                if (dateTimeZone == null) {
                    return m17014c(str);
                }
                return dateTimeZone;
            }
            if (str.equals(obj)) {
                return m17014c(str);
            }
            return mo17009a((String) obj);
        }
        return null;
    }

    @Override // org.joda.time.p029tz.Provider
    /* JADX INFO: renamed from: a */
    public Set<String> mo17008a() {
        return this.f16196e;
    }

    /* JADX INFO: renamed from: a */
    protected void m17015a(Exception exc) {
        exc.printStackTrace();
    }

    /* JADX INFO: renamed from: b */
    private InputStream m17013b(String str) throws IOException {
        if (this.f16192a != null) {
            return new FileInputStream(new File(this.f16192a, str));
        }
        final String strConcat = this.f16193b.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: org.joda.time.tz.ZoneInfoProvider.1
            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public InputStream run() {
                return ZoneInfoProvider.this.f16194c != null ? ZoneInfoProvider.this.f16194c.getResourceAsStream(strConcat) : ClassLoader.getSystemResourceAsStream(strConcat);
            }
        });
        if (inputStream == null) {
            throw new IOException(new StringBuilder(40).append("Resource not found: \"").append(strConcat).append("\" ClassLoader: ").append(this.f16194c != null ? this.f16194c.toString() : "system").toString());
        }
        return inputStream;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.joda.time.DateTimeZone m17014c(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            java.io.InputStream r2 = r5.m17013b(r6)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L2a
            org.joda.time.DateTimeZone r0 = org.joda.time.p029tz.DateTimeZoneBuilder.m16985a(r2, r6)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.f16195d     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            if (r2 == 0) goto L18
            r2.close()     // Catch: java.io.IOException -> L32
        L18:
            return r0
        L19:
            r0 = move-exception
            r2 = r1
        L1b:
            r5.m17015a(r0)     // Catch: java.lang.Throwable -> L38
            java.util.Map<java.lang.String, java.lang.Object> r0 = r5.f16195d     // Catch: java.lang.Throwable -> L38
            r0.remove(r6)     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L28
            r2.close()     // Catch: java.io.IOException -> L34
        L28:
            r0 = r1
            goto L18
        L2a:
            r0 = move-exception
            r2 = r1
        L2c:
            if (r2 == 0) goto L31
            r2.close()     // Catch: java.io.IOException -> L36
        L31:
            throw r0
        L32:
            r1 = move-exception
            goto L18
        L34:
            r0 = move-exception
            goto L28
        L36:
            r1 = move-exception
            goto L31
        L38:
            r0 = move-exception
            goto L2c
        L3a:
            r0 = move-exception
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.p029tz.ZoneInfoProvider.m17014c(java.lang.String):org.joda.time.DateTimeZone");
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, Object> m17011a(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            m17012a(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(DateTimeZone.f15751a));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m17012a(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[unsignedShort];
        for (int i = 0; i < unsignedShort; i++) {
            strArr[i] = dataInputStream.readUTF().intern();
        }
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }
}
