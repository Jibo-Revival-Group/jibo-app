package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {

    /* JADX INFO: renamed from: a */
    private final MemoryValueCache<String> f5123a = new MemoryValueCache<>();

    /* JADX INFO: renamed from: b */
    private final DeviceTokenLoader f5124b = new DeviceTokenLoader();

    /* JADX INFO: renamed from: c */
    private UpdatesController f5125c;

    @Override // io.fabric.sdk.android.Kit
    @TargetApi(14)
    /* JADX INFO: renamed from: a_ */
    protected boolean mo5607a_() {
        this.f5125c = m5694a(Build.VERSION.SDK_INT, (Application) m15121r().getApplicationContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean mo5604f() throws Throwable {
        Fabric.m15085h().mo15063a("Beta", "Beta kit initializing...");
        Context contextR = m15121r();
        IdManager idManagerQ = m15120q();
        if (TextUtils.isEmpty(m5692a(contextR, idManagerQ.m15234j()))) {
            Fabric.m15085h().mo15063a("Beta", "A Beta device token was not found for this app");
            return false;
        }
        Fabric.m15085h().mo15063a("Beta", "Beta device token is present, checking for app updates.");
        BetaSettingsData betaSettingsDataM5693h = m5693h();
        BuildProperties buildPropertiesM5691a = m5691a(contextR);
        if (m5695a(betaSettingsDataM5693h, buildPropertiesM5691a)) {
            this.f5125c.mo5685a(contextR, this, idManagerQ, betaSettingsDataM5693h, buildPropertiesM5691a, new PreferenceStoreImpl(this), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.m15085h()));
        }
        return true;
    }

    @TargetApi(14)
    /* JADX INFO: renamed from: a */
    UpdatesController m5694a(int i, Application application) {
        return i >= 14 ? new ActivityLifecycleCheckForUpdatesController(m15122s().m15096e(), m15122s().m15097f()) : new ImmediateCheckForUpdatesController();
    }

    @Override // io.fabric.sdk.android.services.common.DeviceIdentifierProvider
    /* JADX INFO: renamed from: e */
    public Map<IdManager.DeviceIdentifierType, String> mo5697e() {
        String strM5692a = m5692a(m15121r(), m15120q().m15234j());
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strM5692a)) {
            map.put(IdManager.DeviceIdentifierType.FONT_TOKEN, strM5692a);
        }
        return map;
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: b */
    public String mo5601b() {
        return "com.crashlytics.sdk.android:beta";
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a */
    public String mo5600a() {
        return "1.2.5.dev";
    }

    /* JADX INFO: renamed from: a */
    boolean m5695a(BetaSettingsData betaSettingsData, BuildProperties buildProperties) {
        return (betaSettingsData == null || TextUtils.isEmpty(betaSettingsData.f14750a) || buildProperties == null) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private String m5692a(Context context, String str) {
        String strA;
        try {
            strA = this.f5123a.mo15140a(context, this.f5124b);
            if ("".equals(strA)) {
                strA = null;
            }
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Beta", "Failed to load the Beta device token", e);
            strA = null;
        }
        Fabric.m15085h().mo15063a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(strA)));
        return strA;
    }

    /* JADX INFO: renamed from: h */
    private BetaSettingsData m5693h() {
        SettingsData settingsDataM15458b = Settings.m15455a().m15458b();
        if (settingsDataM15458b != null) {
            return settingsDataM15458b.f14792f;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.crashlytics.android.beta.BuildProperties m5691a(android.content.Context r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            android.content.res.AssetManager r0 = r8.getAssets()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L84
            java.lang.String r2 = "crashlytics-build.properties"
            java.io.InputStream r2 = r0.open(r2)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L84
            if (r2 == 0) goto La5
            com.crashlytics.android.beta.BuildProperties r1 = com.crashlytics.android.beta.BuildProperties.m5699a(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            io.fabric.sdk.android.Logger r0 = io.fabric.sdk.android.Fabric.m15085h()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r3 = "Beta"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r4.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.f5129d     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = " build properties: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.f5127b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = " ("
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.f5126a     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = ") - "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r5 = r1.f5128c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0.mo15063a(r3, r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La0
            r0 = r1
        L4e:
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.io.IOException -> L54
        L53:
            return r0
        L54:
            r1 = move-exception
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.m15085h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.mo15073e(r3, r4, r1)
            goto L53
        L61:
            r0 = move-exception
            r2 = r1
            r6 = r1
            r1 = r0
            r0 = r6
        L66:
            io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.m15085h()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Error reading Beta build properties"
            r3.mo15073e(r4, r5, r1)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.io.IOException -> L77
            goto L53
        L77:
            r1 = move-exception
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.m15085h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.mo15073e(r3, r4, r1)
            goto L53
        L84:
            r0 = move-exception
            r2 = r1
        L86:
            if (r2 == 0) goto L8b
            r2.close()     // Catch: java.io.IOException -> L8c
        L8b:
            throw r0
        L8c:
            r1 = move-exception
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.m15085h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.mo15073e(r3, r4, r1)
            goto L8b
        L99:
            r0 = move-exception
            goto L86
        L9b:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L66
        La0:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L66
        La5:
            r0 = r1
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.Beta.m5691a(android.content.Context):com.crashlytics.android.beta.BuildProperties");
    }

    /* JADX INFO: renamed from: g */
    String m5698g() {
        return CommonUtils.m15195b(m15121r(), "com.crashlytics.ApiEndpoint");
    }
}
