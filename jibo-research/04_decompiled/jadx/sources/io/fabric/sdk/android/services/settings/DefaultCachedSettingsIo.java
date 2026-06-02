package io.fabric.sdk.android.services.settings;

import android.content.res.AssetFileDescriptor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DefaultCachedSettingsIo implements CachedSettingsIo {

    /* JADX INFO: renamed from: a */
    private final Kit f14752a;

    public DefaultCachedSettingsIo(Kit kit) {
        this.f14752a = kit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.fabric.sdk.android.services.settings.CachedSettingsIo
    /* JADX INFO: renamed from: a */
    public JSONObject mo15428a() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        AssetFileDescriptor.AutoCloseInputStream autoCloseInputStream = 0;
        FileInputStream fileInputStream2 = null;
        Fabric.m15085h().mo15063a("Fabric", "Reading cached settings...");
        try {
            try {
                File file = new File(new FileStoreImpl(this.f14752a).mo15418a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.m15177a((InputStream) fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        Fabric.m15085h().mo15073e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m15188a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    Fabric.m15085h().mo15063a("Fabric", "No cached settings found.");
                    jSONObject = null;
                }
                CommonUtils.m15188a((Closeable) fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                autoCloseInputStream = "Fabric";
                CommonUtils.m15188a((Closeable) autoCloseInputStream, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m15188a((Closeable) autoCloseInputStream, "Error while closing settings cache file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // io.fabric.sdk.android.services.settings.CachedSettingsIo
    /* JADX INFO: renamed from: a */
    public void mo15429a(long j, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        Object obj = "Fabric";
        Fabric.m15085h().mo15063a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            ?? r2 = 0;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new FileStoreImpl(this.f14752a).mo15418a(), "com.crashlytics.settings.json"));
                    try {
                        fileWriter.write(jSONObject.toString());
                        fileWriter.flush();
                        CommonUtils.m15188a((Closeable) fileWriter, "Failed to close settings writer.");
                        obj = fileWriter;
                    } catch (Exception e) {
                        e = e;
                        Fabric.m15085h().mo15073e("Fabric", "Failed to cache settings", e);
                        CommonUtils.m15188a((Closeable) fileWriter, "Failed to close settings writer.");
                        obj = fileWriter;
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = obj;
                    CommonUtils.m15188a((Closeable) r2, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m15188a((Closeable) r2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
