package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzdmf {

    /* JADX INFO: renamed from: f */
    private static HashMap<String, String> f7802f;

    /* JADX INFO: renamed from: k */
    private static Object f7807k;

    /* JADX INFO: renamed from: l */
    private static boolean f7808l;

    /* JADX INFO: renamed from: a */
    private static Uri f7797a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b */
    private static Uri f7798b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* JADX INFO: renamed from: c */
    private static Pattern f7799c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* JADX INFO: renamed from: d */
    private static Pattern f7800d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* JADX INFO: renamed from: e */
    private static final AtomicBoolean f7801e = new AtomicBoolean();

    /* JADX INFO: renamed from: g */
    private static HashMap<String, Boolean> f7803g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    private static HashMap<String, Integer> f7804h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    private static HashMap<String, Long> f7805i = new HashMap<>();

    /* JADX INFO: renamed from: j */
    private static HashMap<String, Float> f7806j = new HashMap<>();

    /* JADX INFO: renamed from: m */
    private static String[] f7809m = new String[0];

    /* JADX INFO: renamed from: a */
    public static long m8513a(ContentResolver contentResolver, String str, long j) {
        Long lValueOf;
        long j2;
        Object objM8522b = m8522b(contentResolver);
        Long l = (Long) m8514a((HashMap<String, long>) f7805i, str, 0L);
        if (l != null) {
            return l.longValue();
        }
        String strM8515a = m8515a(contentResolver, str, (String) null);
        if (strM8515a == null) {
            lValueOf = l;
            j2 = 0;
        } else {
            try {
                long j3 = Long.parseLong(strM8515a);
                lValueOf = Long.valueOf(j3);
                j2 = j3;
            } catch (NumberFormatException e) {
                lValueOf = l;
                j2 = 0;
            }
        }
        m8520a(objM8522b, f7805i, str, lValueOf);
        return j2;
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m8514a(HashMap<String, T> map, String str, T t) {
        synchronized (zzdmf.class) {
            if (!map.containsKey(str)) {
                return null;
            }
            T t2 = map.get(str);
            if (t2 == null) {
                t2 = t;
            }
            return t2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0060 A[Catch: all -> 0x005d, DONT_GENERATE, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0006, B:6:0x0013, B:9:0x001e, B:11:0x0020, B:13:0x0026, B:15:0x002e, B:17:0x0032, B:29:0x0060, B:19:0x003a, B:21:0x0050, B:24:0x005b, B:31:0x0062, B:32:0x0065), top: B:56:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:35:0x0075, B:41:0x0086, B:43:0x008c, B:46:0x0094, B:37:0x007b), top: B:55:0x0075 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m8515a(android.content.ContentResolver r9, java.lang.String r10, java.lang.String r11) {
        /*
            r3 = 0
            r8 = 1
            r2 = 0
            java.lang.Class<com.google.android.gms.internal.zzdmf> r1 = com.google.android.gms.internal.zzdmf.class
            monitor-enter(r1)
            m8518a(r9)     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r6 = com.google.android.gms.internal.zzdmf.f7807k     // Catch: java.lang.Throwable -> L5d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.containsKey(r10)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L20
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L1e
            r2 = r0
        L1e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5d
        L1f:
            return r2
        L20:
            java.lang.String[] r4 = com.google.android.gms.internal.zzdmf.f7809m     // Catch: java.lang.Throwable -> L5d
            int r5 = r4.length     // Catch: java.lang.Throwable -> L5d
            r0 = r3
        L24:
            if (r0 >= r5) goto L65
            r7 = r4[r0]     // Catch: java.lang.Throwable -> L5d
            boolean r7 = r10.startsWith(r7)     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L62
            boolean r0 = com.google.android.gms.internal.zzdmf.f7808l     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L3a
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L60
        L3a:
            java.lang.String[] r0 = com.google.android.gms.internal.zzdmf.f7809m     // Catch: java.lang.Throwable -> L5d
            java.util.HashMap<java.lang.String, java.lang.String> r3 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            java.util.Map r0 = m8516a(r9, r0)     // Catch: java.lang.Throwable -> L5d
            r3.putAll(r0)     // Catch: java.lang.Throwable -> L5d
            r0 = 1
            com.google.android.gms.internal.zzdmf.f7808l = r0     // Catch: java.lang.Throwable -> L5d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.containsKey(r10)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L60
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.google.android.gms.internal.zzdmf.f7802f     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L5b
            r2 = r0
        L5b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5d
            goto L1f
        L5d:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5d
            throw r0
        L60:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5d
            goto L1f
        L62:
            int r0 = r0 + 1
            goto L24
        L65:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5d
            android.net.Uri r1 = com.google.android.gms.internal.zzdmf.f7797a
            java.lang.String[] r4 = new java.lang.String[r8]
            r4[r3] = r10
            r0 = r9
            r3 = r2
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L7b
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La0
            if (r0 != 0) goto L85
        L7b:
            r0 = 0
            m8519a(r6, r10, r0)     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L1f
            r1.close()
            goto L1f
        L85:
            r0 = 1
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L94
            r3 = 0
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L94
            r0 = r2
        L94:
            m8519a(r6, r10, r0)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L9a
            r2 = r0
        L9a:
            if (r1 == 0) goto L1f
            r1.close()
            goto L1f
        La0:
            r0 = move-exception
            if (r1 == 0) goto La6
            r1.close()
        La6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdmf.m8515a(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, String> m8516a(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(f7798b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return treeMap;
    }

    /* JADX INFO: renamed from: a */
    private static void m8518a(ContentResolver contentResolver) {
        if (f7802f == null) {
            f7801e.set(false);
            f7802f = new HashMap<>();
            f7807k = new Object();
            f7808l = false;
            contentResolver.registerContentObserver(f7797a, true, new zzdmg(null));
            return;
        }
        if (f7801e.getAndSet(false)) {
            f7802f.clear();
            f7803g.clear();
            f7804h.clear();
            f7805i.clear();
            f7806j.clear();
            f7807k = new Object();
            f7808l = false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8519a(Object obj, String str, String str2) {
        synchronized (zzdmf.class) {
            if (obj == f7807k) {
                f7802f.put(str, str2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static <T> void m8520a(Object obj, HashMap<String, T> map, String str, T t) {
        synchronized (zzdmf.class) {
            if (obj == f7807k) {
                map.put(str, t);
                f7802f.remove(str);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8521a(ContentResolver contentResolver, String str, boolean z) {
        Object objM8522b = m8522b(contentResolver);
        Boolean bool = (Boolean) m8514a(f7803g, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String strM8515a = m8515a(contentResolver, str, (String) null);
        if (strM8515a != null && !strM8515a.equals("")) {
            if (f7799c.matcher(strM8515a).matches()) {
                bool = true;
                z = true;
            } else if (f7800d.matcher(strM8515a).matches()) {
                bool = false;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + strM8515a + "\") as boolean");
            }
        }
        m8520a(objM8522b, f7803g, str, bool);
        return z;
    }

    /* JADX INFO: renamed from: b */
    private static Object m8522b(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdmf.class) {
            m8518a(contentResolver);
            obj = f7807k;
        }
        return obj;
    }
}
