package com.jibo.utils.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* JADX INFO: renamed from: a */
    private Context f11702a;

    /* JADX INFO: renamed from: b */
    private final int f11703b;

    /* JADX INFO: renamed from: c */
    private final CacheDirectoryGetter f11704c;

    public interface CacheDirectoryGetter {
        /* JADX INFO: renamed from: a */
        File mo11506a();
    }

    public DiskLruCacheFactory(Context context, CacheDirectoryGetter cacheDirectoryGetter, int i) {
        this.f11702a = context.getApplicationContext();
        this.f11703b = i;
        this.f11704c = cacheDirectoryGetter;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File fileMo11506a = this.f11704c.mo11506a();
        if (fileMo11506a == null) {
            return null;
        }
        if (fileMo11506a.mkdirs() || (fileMo11506a.exists() && fileMo11506a.isDirectory())) {
            return DiskLruCacheWrapper.m11508a(this.f11702a, fileMo11506a, this.f11703b);
        }
        return null;
    }
}
