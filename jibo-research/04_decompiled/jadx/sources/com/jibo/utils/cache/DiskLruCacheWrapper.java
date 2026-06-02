package com.jibo.utils.cache;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.utils.OriginalKey;
import com.jibo.utils.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* JADX INFO: renamed from: a */
    private static DiskLruCacheWrapper f11705a = null;

    /* JADX INFO: renamed from: c */
    private Context f11707c;

    /* JADX INFO: renamed from: d */
    private final File f11708d;

    /* JADX INFO: renamed from: e */
    private final int f11709e;

    /* JADX INFO: renamed from: g */
    private DiskLruCache f11711g;

    /* JADX INFO: renamed from: f */
    private final DiskCacheWriteLocker f11710f = new DiskCacheWriteLocker();

    /* JADX INFO: renamed from: b */
    private final SafeKeyGenerator f11706b = new SafeKeyGenerator();

    /* JADX INFO: renamed from: a */
    public static synchronized DiskCache m11508a(Context context, File file, int i) {
        if (f11705a == null) {
            f11705a = new DiskLruCacheWrapper(context, file, i);
        }
        return f11705a;
    }

    protected DiskLruCacheWrapper(Context context, File file, int i) {
        this.f11707c = context;
        this.f11708d = file;
        this.f11709e = i;
    }

    /* JADX INFO: renamed from: a */
    private synchronized DiskLruCache m11507a() throws IOException {
        if (this.f11711g == null) {
            this.f11711g = DiskLruCache.m5296a(this.f11708d, 1, 1, this.f11709e);
        }
        return this.f11711g;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String strM11513a = this.f11706b.m11513a(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strM11513a + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value valueM5314a = m11507a().m5314a(strM11513a);
            if (valueM5314a == null) {
                return null;
            }
            return valueM5314a.m5339a(0);
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0139  */
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void put(com.bumptech.glide.load.Key r7, com.bumptech.glide.load.engine.cache.DiskCache.Writer r8) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.utils.cache.DiskLruCacheWrapper.put(com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.cache.DiskCache$Writer):void");
    }

    /* JADX INFO: renamed from: a */
    public void m11509a(OriginalKey originalKey, InputStream inputStream) {
        File file;
        DiskLruCache diskLruCacheM11507a;
        String queryParameter = null;
        this.f11710f.m11502a(originalKey);
        try {
            try {
                Uri uri = Uri.parse(originalKey.m11419a());
                if (TextUtils.isEmpty(uri.getQueryParameter("loopId"))) {
                    file = null;
                } else {
                    queryParameter = uri.getQueryParameter("loopId");
                    file = new File(this.f11708d, this.f11706b.m11513a(originalKey) + "_enc");
                }
                String strM11513a = this.f11706b.m11513a(originalKey);
                if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                    Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strM11513a + " for for Key: " + originalKey);
                }
                try {
                    diskLruCacheM11507a = m11507a();
                } catch (IOException e) {
                    if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                        Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                    }
                }
                if (diskLruCacheM11507a.m5314a(strM11513a) != null) {
                    this.f11710f.m11503b(originalKey);
                    return;
                }
                DiskLruCache.Editor editorM5316b = diskLruCacheM11507a.m5316b(strM11513a);
                if (editorM5316b == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strM11513a);
                }
                try {
                    try {
                        File fileM5321a = editorM5316b.m5321a(0);
                        if (file == null || TextUtils.isEmpty(queryParameter)) {
                            Util.m11493a(inputStream, new FileOutputStream(fileM5321a));
                        } else {
                            Util.m11493a(inputStream, new FileOutputStream(file));
                            KeyManager.getInstance(this.f11707c, EntityData.m10089a(this.f11707c).m10134i().getId()).obtainKeyHolder(this.f11707c, queryParameter).decodeFile(file, fileM5321a);
                            file.delete();
                        }
                        editorM5316b.m5322a();
                    } catch (Exception e2) {
                        Crashlytics.m5597a((Throwable) e2);
                        editorM5316b.m5324c();
                    }
                    this.f11710f.m11503b(originalKey);
                } finally {
                    editorM5316b.m5324c();
                }
            } catch (Exception e3) {
                Crashlytics.m5597a((Throwable) e3);
                this.f11710f.m11503b(originalKey);
            }
        } catch (Throwable th) {
            this.f11710f.m11503b(originalKey);
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            m11507a().m5317c(this.f11706b.m11513a(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
