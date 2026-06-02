package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes2.dex */
class FabricKitsFinder implements Callable<Map<String, KitInfo>> {

    /* JADX INFO: renamed from: a */
    final String f14526a;

    FabricKitsFinder(String str) {
        this.f14526a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, KitInfo> call() throws Exception {
        HashMap map = new HashMap();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        map.putAll(m15104c());
        map.putAll(m15105d());
        Fabric.m15085h().mo15066b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return map;
    }

    /* JADX INFO: renamed from: c */
    private Map<String, KitInfo> m15104c() {
        HashMap map = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            KitInfo kitInfo = new KitInfo("com.google.firebase.firebase-ads", "0.0.0", MIME.ENC_BINARY);
            map.put(kitInfo.m15126a(), kitInfo);
            Fabric.m15085h().mo15066b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception e) {
        }
        return map;
    }

    /* JADX INFO: renamed from: d */
    private Map<String, KitInfo> m15105d() throws Exception {
        KitInfo kitInfoM15103a;
        HashMap map = new HashMap();
        ZipFile zipFileM15107b = m15107b();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFileM15107b.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.getName().startsWith("fabric/") && zipEntryNextElement.getName().length() > "fabric/".length() && (kitInfoM15103a = m15103a(zipEntryNextElement, zipFileM15107b)) != null) {
                map.put(kitInfoM15103a.m15126a(), kitInfoM15103a);
                Fabric.m15085h().mo15066b("Fabric", String.format("Found kit:[%s] version:[%s]", kitInfoM15103a.m15126a(), kitInfoM15103a.m15127b()));
            }
        }
        if (zipFileM15107b != null) {
            try {
                zipFileM15107b.close();
            } catch (IOException e) {
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private KitInfo m15103a(ZipEntry zipEntry, ZipFile zipFile) throws Throwable {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String property = properties.getProperty("fabric-identifier");
                    String property2 = properties.getProperty("fabric-version");
                    String property3 = properties.getProperty("fabric-build-type");
                    if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                        throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                    }
                    KitInfo kitInfo = new KitInfo(property, property2, property3);
                    CommonUtils.m15187a((Closeable) inputStream);
                    return kitInfo;
                } catch (IOException e) {
                    e = e;
                    Fabric.m15085h().mo15073e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.m15187a((Closeable) inputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15187a((Closeable) null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m15187a((Closeable) null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    protected ZipFile m15107b() throws IOException {
        return new ZipFile(this.f14526a);
    }
}
