package com.jibo.utils.cache;

import android.content.Context;
import com.jibo.utils.cache.DiskLruCacheFactory;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(context, new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.jibo.utils.cache.ExternalCacheDiskCacheFactory.1
            @Override // com.jibo.utils.cache.DiskLruCacheFactory.CacheDirectoryGetter
            /* JADX INFO: renamed from: a */
            public File mo11506a() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, i);
    }
}
