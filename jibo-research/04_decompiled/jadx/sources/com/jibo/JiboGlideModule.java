package com.jibo;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.facebook.share.widget.ShareDialog;
import com.jibo.utils.cache.ExternalCacheDiskCacheFactory;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class JiboGlideModule implements GlideModule {

    /* JADX INFO: renamed from: a */
    private static ExternalCacheDiskCacheFactory f9268a;

    /* JADX INFO: renamed from: a */
    public static synchronized ExternalCacheDiskCacheFactory m9865a(Context context) {
        m9866b(context);
        if (f9268a == null) {
            synchronized (JiboGlideModule.class) {
                if (f9268a == null) {
                    f9268a = new ExternalCacheDiskCacheFactory(context.getApplicationContext(), null, 262144000);
                }
            }
        }
        return f9268a;
    }

    /* JADX INFO: renamed from: b */
    public static void m9866b(Context context) {
        File file = new File(context.getExternalCacheDir(), ShareDialog.WEB_SHARE_DIALOG);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Override // com.bumptech.glide.module.GlideModule
    /* JADX INFO: renamed from: a */
    public void mo5492a(Context context, GlideBuilder glideBuilder) {
        glideBuilder.m5268a(m9865a(context));
    }

    @Override // com.bumptech.glide.module.GlideModule
    /* JADX INFO: renamed from: a */
    public void mo5491a(Context context, Glide glide) {
    }
}
