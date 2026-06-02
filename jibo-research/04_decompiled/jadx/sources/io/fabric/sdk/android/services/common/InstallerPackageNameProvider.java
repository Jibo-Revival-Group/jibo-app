package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

/* JADX INFO: loaded from: classes2.dex */
public class InstallerPackageNameProvider {

    /* JADX INFO: renamed from: a */
    private final ValueLoader<String> f14596a = new ValueLoader<String>() { // from class: io.fabric.sdk.android.services.common.InstallerPackageNameProvider.1
        @Override // io.fabric.sdk.android.services.cache.ValueLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String mo5709b(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    /* JADX INFO: renamed from: b */
    private final MemoryValueCache<String> f14597b = new MemoryValueCache<>();

    /* JADX INFO: renamed from: a */
    public String m15239a(Context context) {
        try {
            String strA = this.f14597b.mo15140a(context, this.f14596a);
            if ("".equals(strA)) {
                return null;
            }
            return strA;
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
