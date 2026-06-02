package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class MetaDataStore {

    /* JADX INFO: renamed from: a */
    private static final Charset f5273a = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: b */
    private final File f5274b;

    public MetaDataStore(File file) {
        this.f5274b = file;
    }

    /* JADX INFO: renamed from: a */
    public UserMetaData m5933a(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileM5929c = m5929c(str);
        if (!fileM5929c.exists()) {
            return UserMetaData.f5341a;
        }
        try {
            fileInputStream = new FileInputStream(fileM5929c);
            try {
                try {
                    UserMetaData userMetaDataM5931e = m5931e(CommonUtils.m15177a((InputStream) fileInputStream));
                    CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return userMetaDataM5931e;
                } catch (Exception e) {
                    e = e;
                    Fabric.m15085h().mo15073e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return UserMetaData.f5341a;
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX INFO: renamed from: b */
    public Map<String, String> m5934b(String str) throws Throwable {
        FileInputStream fileInputStream;
        Map<String, String> mapEmptyMap;
        File fileM5930d = m5930d(str);
        ?? Exists = fileM5930d.exists();
        if (Exists == 0) {
            return Collections.emptyMap();
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileM5930d);
                try {
                    mapEmptyMap = m5932f(CommonUtils.m15177a((InputStream) fileInputStream));
                    CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    Exists = fileInputStream;
                } catch (Exception e) {
                    e = e;
                    Fabric.m15085h().mo15073e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    mapEmptyMap = Collections.emptyMap();
                    Exists = fileInputStream;
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15188a((Closeable) Exists, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Exists = 0;
            CommonUtils.m15188a((Closeable) Exists, "Failed to close user metadata file.");
            throw th;
        }
        return mapEmptyMap;
    }

    /* JADX INFO: renamed from: c */
    private File m5929c(String str) {
        return new File(this.f5274b, str + "user.meta");
    }

    /* JADX INFO: renamed from: d */
    private File m5930d(String str) {
        return new File(this.f5274b, str + "keys.meta");
    }

    /* JADX INFO: renamed from: e */
    private static UserMetaData m5931e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new UserMetaData(m5928a(jSONObject, "userId"), m5928a(jSONObject, "userName"), m5928a(jSONObject, "userEmail"));
    }

    /* JADX INFO: renamed from: f */
    private static Map<String, String> m5932f(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, m5928a(jSONObject, next));
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private static String m5928a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }
}
