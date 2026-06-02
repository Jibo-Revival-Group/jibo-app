package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import io.fabric.sdk.android.services.settings.IconRequest;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.UpdateAppSpiCall;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes2.dex */
class Onboarding extends Kit<Boolean> {

    /* JADX INFO: renamed from: a */
    private final HttpRequestFactory f14538a = new DefaultHttpRequestFactory();

    /* JADX INFO: renamed from: b */
    private PackageManager f14539b;

    /* JADX INFO: renamed from: c */
    private String f14540c;

    /* JADX INFO: renamed from: d */
    private PackageInfo f14541d;

    /* JADX INFO: renamed from: k */
    private String f14542k;

    /* JADX INFO: renamed from: l */
    private String f14543l;

    /* JADX INFO: renamed from: m */
    private String f14544m;

    /* JADX INFO: renamed from: n */
    private String f14545n;

    /* JADX INFO: renamed from: o */
    private String f14546o;

    /* JADX INFO: renamed from: p */
    private final Future<Map<String, KitInfo>> f14547p;

    /* JADX INFO: renamed from: q */
    private final Collection<Kit> f14548q;

    public Onboarding(Future<Map<String, KitInfo>> future, Collection<Kit> collection) {
        this.f14547p = future;
        this.f14548q = collection;
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a */
    public String mo5600a() {
        return "1.3.17.dev";
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a_ */
    protected boolean mo5607a_() {
        boolean z = false;
        try {
            this.f14544m = m15120q().m15234j();
            this.f14539b = m15121r().getPackageManager();
            this.f14540c = m15121r().getPackageName();
            this.f14541d = this.f14539b.getPackageInfo(this.f14540c, 0);
            this.f14542k = Integer.toString(this.f14541d.versionCode);
            this.f14543l = this.f14541d.versionName == null ? "0.0" : this.f14541d.versionName;
            this.f14545n = this.f14539b.getApplicationLabel(m15121r().getApplicationInfo()).toString();
            this.f14546o = Integer.toString(m15121r().getApplicationInfo().targetSdkVersion);
            z = true;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Fabric.m15085h().mo15073e("Fabric", "Failed init", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean mo5604f() throws Throwable {
        Map<String, KitInfo> map;
        boolean zM15131a;
        String strM15208k = CommonUtils.m15208k(m15121r());
        SettingsData settingsDataM15134g = m15134g();
        if (settingsDataM15134g == null) {
            zM15131a = false;
        } else {
            try {
                if (this.f14547p != null) {
                    map = this.f14547p.get();
                } else {
                    map = new HashMap<>();
                }
                zM15131a = m15131a(strM15208k, settingsDataM15134g.f14787a, m15135a(map, this.f14548q).values());
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("Fabric", "Error performing auto configuration.", e);
                zM15131a = false;
            }
        }
        return Boolean.valueOf(zM15131a);
    }

    /* JADX INFO: renamed from: g */
    private SettingsData m15134g() {
        try {
            Settings.m15455a().m15457a(this, this.f14533i, this.f14538a, this.f14542k, this.f14543l, m15137e()).m15459c();
            return Settings.m15455a().m15458b();
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    Map<String, KitInfo> m15135a(Map<String, KitInfo> map, Collection<Kit> collection) {
        for (Kit kit : collection) {
            if (!map.containsKey(kit.mo5601b())) {
                map.put(kit.mo5601b(), new KitInfo(kit.mo5601b(), kit.mo5600a(), MIME.ENC_BINARY));
            }
        }
        return map;
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: b */
    public String mo5601b() {
        return "io.fabric.sdk.android:fabric";
    }

    /* JADX INFO: renamed from: a */
    private boolean m15131a(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        if ("new".equals(appSettingsData.f14745b)) {
            if (m15132b(str, appSettingsData, collection)) {
                return Settings.m15455a().m15460d();
            }
            Fabric.m15085h().mo15073e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals(appSettingsData.f14745b)) {
            return Settings.m15455a().m15460d();
        }
        if (!appSettingsData.f14748e) {
            return true;
        }
        Fabric.m15085h().mo15063a("Fabric", "Server says an update is required - forcing a full App update.");
        m15133c(str, appSettingsData, collection);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m15132b(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return new CreateAppSpiCall(this, m15137e(), appSettingsData.f14746c, this.f14538a).mo15426a(m15129a(IconRequest.m15454a(m15121r(), str), collection));
    }

    /* JADX INFO: renamed from: c */
    private boolean m15133c(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return m15130a(appSettingsData, IconRequest.m15454a(m15121r(), str), collection);
    }

    /* JADX INFO: renamed from: a */
    private boolean m15130a(AppSettingsData appSettingsData, IconRequest iconRequest, Collection<KitInfo> collection) {
        return new UpdateAppSpiCall(this, m15137e(), appSettingsData.f14746c, this.f14538a).mo15426a(m15129a(iconRequest, collection));
    }

    /* JADX INFO: renamed from: a */
    private AppRequestData m15129a(IconRequest iconRequest, Collection<KitInfo> collection) {
        Context contextR = m15121r();
        return new AppRequestData(new ApiKey().m15165a(contextR), m15120q().m15227c(), this.f14543l, this.f14542k, CommonUtils.m15183a(CommonUtils.m15210m(contextR)), this.f14545n, DeliveryMechanism.determineFrom(this.f14544m).getId(), this.f14546o, AppEventsConstants.EVENT_PARAM_VALUE_NO, iconRequest, collection);
    }

    /* JADX INFO: renamed from: e */
    String m15137e() {
        return CommonUtils.m15195b(m15121r(), "com.crashlytics.ApiEndpoint");
    }
}
