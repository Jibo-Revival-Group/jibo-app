package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzctv {

    /* JADX INFO: renamed from: a */
    private static final ConcurrentHashMap<Uri, zzctv> f7720a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g */
    private static String[] f7721g = {"key", "value"};

    /* JADX INFO: renamed from: b */
    private final ContentResolver f7722b;

    /* JADX INFO: renamed from: c */
    private final Uri f7723c;

    /* JADX INFO: renamed from: f */
    private volatile Map<String, String> f7726f;

    /* JADX INFO: renamed from: e */
    private final Object f7725e = new Object();

    /* JADX INFO: renamed from: d */
    private final ContentObserver f7724d = new zzctw(this, null);

    private zzctv(ContentResolver contentResolver, Uri uri) {
        this.f7722b = contentResolver;
        this.f7723c = uri;
    }

    /* JADX INFO: renamed from: a */
    public static zzctv m8461a(ContentResolver contentResolver, Uri uri) {
        zzctv zzctvVar = f7720a.get(uri);
        if (zzctvVar != null) {
            return zzctvVar;
        }
        zzctv zzctvVar2 = new zzctv(contentResolver, uri);
        zzctv zzctvVarPutIfAbsent = f7720a.putIfAbsent(uri, zzctvVar2);
        if (zzctvVarPutIfAbsent != null) {
            return zzctvVarPutIfAbsent;
        }
        zzctvVar2.f7722b.registerContentObserver(zzctvVar2.f7723c, false, zzctvVar2.f7724d);
        return zzctvVar2;
    }

    /* JADX INFO: renamed from: c */
    private final Map<String, String> m8462c() {
        HashMap map = new HashMap();
        Cursor cursorQuery = this.f7722b.query(this.f7723c, f7721g, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    map.put(cursorQuery.getString(0), cursorQuery.getString(1));
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, String> m8463a() {
        Map<String, String> mapM8462c = zzcui.m8474a("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? m8462c() : this.f7726f;
        if (mapM8462c == null) {
            synchronized (this.f7725e) {
                mapM8462c = this.f7726f;
                if (mapM8462c == null) {
                    mapM8462c = m8462c();
                    this.f7726f = mapM8462c;
                }
            }
        }
        return mapM8462c;
    }

    /* JADX INFO: renamed from: b */
    public final void m8464b() {
        synchronized (this.f7725e) {
            this.f7726f = null;
        }
    }
}
