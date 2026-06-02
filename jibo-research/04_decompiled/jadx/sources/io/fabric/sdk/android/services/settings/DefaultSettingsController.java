package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DefaultSettingsController implements SettingsController {

    /* JADX INFO: renamed from: a */
    private final SettingsRequest f14753a;

    /* JADX INFO: renamed from: b */
    private final SettingsJsonTransform f14754b;

    /* JADX INFO: renamed from: c */
    private final CurrentTimeProvider f14755c;

    /* JADX INFO: renamed from: d */
    private final CachedSettingsIo f14756d;

    /* JADX INFO: renamed from: e */
    private final SettingsSpiCall f14757e;

    /* JADX INFO: renamed from: f */
    private final Kit f14758f;

    /* JADX INFO: renamed from: g */
    private final PreferenceStore f14759g;

    public DefaultSettingsController(Kit kit, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonTransform settingsJsonTransform, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall) {
        this.f14758f = kit;
        this.f14753a = settingsRequest;
        this.f14755c = currentTimeProvider;
        this.f14754b = settingsJsonTransform;
        this.f14756d = cachedSettingsIo;
        this.f14757e = settingsSpiCall;
        this.f14759g = new PreferenceStoreImpl(this.f14758f);
    }

    @Override // io.fabric.sdk.android.services.settings.SettingsController
    /* JADX INFO: renamed from: a */
    public SettingsData mo15432a() {
        return mo15433a(SettingsCacheBehavior.USE_CACHE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // io.fabric.sdk.android.services.settings.SettingsController
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.fabric.sdk.android.services.settings.SettingsData mo15433a(io.fabric.sdk.android.services.settings.SettingsCacheBehavior r8) {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = io.fabric.sdk.android.Fabric.m15086i()     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L11
            boolean r0 = r7.m15437d()     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L11
            io.fabric.sdk.android.services.settings.SettingsData r1 = r7.m15431b(r8)     // Catch: java.lang.Exception -> L42
        L11:
            if (r1 != 0) goto L38
            io.fabric.sdk.android.services.settings.SettingsSpiCall r0 = r7.f14757e     // Catch: java.lang.Exception -> L52
            io.fabric.sdk.android.services.settings.SettingsRequest r2 = r7.f14753a     // Catch: java.lang.Exception -> L52
            org.json.JSONObject r0 = r0.mo15452a(r2)     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L38
            io.fabric.sdk.android.services.settings.SettingsJsonTransform r2 = r7.f14754b     // Catch: java.lang.Exception -> L52
            io.fabric.sdk.android.services.common.CurrentTimeProvider r3 = r7.f14755c     // Catch: java.lang.Exception -> L52
            io.fabric.sdk.android.services.settings.SettingsData r1 = r2.mo15446a(r3, r0)     // Catch: java.lang.Exception -> L52
            io.fabric.sdk.android.services.settings.CachedSettingsIo r2 = r7.f14756d     // Catch: java.lang.Exception -> L52
            long r4 = r1.f14793g     // Catch: java.lang.Exception -> L52
            r2.mo15429a(r4, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r2 = "Loaded settings: "
            r7.m15430a(r0, r2)     // Catch: java.lang.Exception -> L52
            java.lang.String r0 = r7.m15435b()     // Catch: java.lang.Exception -> L52
            r7.m15434a(r0)     // Catch: java.lang.Exception -> L52
        L38:
            r0 = r1
            if (r0 != 0) goto L41
            io.fabric.sdk.android.services.settings.SettingsCacheBehavior r1 = io.fabric.sdk.android.services.settings.SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION     // Catch: java.lang.Exception -> L57
            io.fabric.sdk.android.services.settings.SettingsData r0 = r7.m15431b(r1)     // Catch: java.lang.Exception -> L57
        L41:
            return r0
        L42:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
        L46:
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.m15085h()
            java.lang.String r3 = "Fabric"
            java.lang.String r4 = "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved."
            r2.mo15073e(r3, r4, r1)
            goto L41
        L52:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L46
        L57:
            r1 = move-exception
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.DefaultSettingsController.mo15433a(io.fabric.sdk.android.services.settings.SettingsCacheBehavior):io.fabric.sdk.android.services.settings.SettingsData");
    }

    /* JADX INFO: renamed from: b */
    private SettingsData m15431b(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectMo15428a = this.f14756d.mo15428a();
                if (jSONObjectMo15428a != null) {
                    SettingsData settingsDataMo15446a = this.f14754b.mo15446a(this.f14755c, jSONObjectMo15428a);
                    if (settingsDataMo15446a != null) {
                        m15430a(jSONObjectMo15428a, "Loaded cached settings: ");
                        long jMo15215a = this.f14755c.mo15215a();
                        if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !settingsDataMo15446a.m15462a(jMo15215a)) {
                            try {
                                Fabric.m15085h().mo15063a("Fabric", "Returning cached settings.");
                                settingsData = settingsDataMo15446a;
                            } catch (Exception e) {
                                settingsData = settingsDataMo15446a;
                                e = e;
                                Fabric.m15085h().mo15073e("Fabric", "Failed to get cached settings", e);
                            }
                        } else {
                            Fabric.m15085h().mo15063a("Fabric", "Cached settings have expired.");
                        }
                    } else {
                        Fabric.m15085h().mo15073e("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    Fabric.m15085h().mo15063a("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return settingsData;
    }

    /* JADX INFO: renamed from: a */
    private void m15430a(JSONObject jSONObject, String str) throws JSONException {
        Fabric.m15085h().mo15063a("Fabric", str + jSONObject.toString());
    }

    /* JADX INFO: renamed from: b */
    String m15435b() {
        return CommonUtils.m15183a(CommonUtils.m15210m(this.f14758f.m15121r()));
    }

    /* JADX INFO: renamed from: c */
    String m15436c() {
        return this.f14759g.mo15420a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    /* JADX INFO: renamed from: a */
    boolean m15434a(String str) {
        SharedPreferences.Editor editorMo15422b = this.f14759g.mo15422b();
        editorMo15422b.putString("existing_instance_identifier", str);
        return this.f14759g.mo15421a(editorMo15422b);
    }

    /* JADX INFO: renamed from: d */
    boolean m15437d() {
        return !m15436c().equals(m15435b());
    }
}
