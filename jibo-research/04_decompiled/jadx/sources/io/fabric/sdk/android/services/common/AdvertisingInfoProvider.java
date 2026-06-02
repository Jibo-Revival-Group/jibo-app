package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

/* JADX INFO: loaded from: classes2.dex */
class AdvertisingInfoProvider {

    /* JADX INFO: renamed from: a */
    private final Context f14559a;

    /* JADX INFO: renamed from: b */
    private final PreferenceStore f14560b;

    public AdvertisingInfoProvider(Context context) {
        this.f14559a = context.getApplicationContext();
        this.f14560b = new PreferenceStoreImpl(context, "TwitterAdvertisingInfoPreferences");
    }

    /* JADX INFO: renamed from: a */
    public AdvertisingInfo m15152a() {
        AdvertisingInfo advertisingInfoM15153b = m15153b();
        if (m15150c(advertisingInfoM15153b)) {
            Fabric.m15085h().mo15063a("Fabric", "Using AdvertisingInfo from Preference Store");
            m15147a(advertisingInfoM15153b);
            return advertisingInfoM15153b;
        }
        AdvertisingInfo advertisingInfoM15151e = m15151e();
        m15149b(advertisingInfoM15151e);
        return advertisingInfoM15151e;
    }

    /* JADX INFO: renamed from: a */
    private void m15147a(final AdvertisingInfo advertisingInfo) {
        new Thread(new BackgroundPriorityRunnable() { // from class: io.fabric.sdk.android.services.common.AdvertisingInfoProvider.1
            @Override // io.fabric.sdk.android.services.common.BackgroundPriorityRunnable
            /* JADX INFO: renamed from: a */
            public void mo5968a() {
                AdvertisingInfo advertisingInfoM15151e = AdvertisingInfoProvider.this.m15151e();
                if (!advertisingInfo.equals(advertisingInfoM15151e)) {
                    Fabric.m15085h().mo15063a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    AdvertisingInfoProvider.this.m15149b(advertisingInfoM15151e);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* JADX INFO: renamed from: b */
    public void m15149b(AdvertisingInfo advertisingInfo) {
        if (m15150c(advertisingInfo)) {
            this.f14560b.mo15421a(this.f14560b.mo15422b().putString("advertising_id", advertisingInfo.f14557a).putBoolean("limit_ad_tracking_enabled", advertisingInfo.f14558b));
        } else {
            this.f14560b.mo15421a(this.f14560b.mo15422b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    /* JADX INFO: renamed from: b */
    protected AdvertisingInfo m15153b() {
        return new AdvertisingInfo(this.f14560b.mo15420a().getString("advertising_id", ""), this.f14560b.mo15420a().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* JADX INFO: renamed from: c */
    public AdvertisingInfoStrategy m15154c() {
        return new AdvertisingInfoReflectionStrategy(this.f14559a);
    }

    /* JADX INFO: renamed from: d */
    public AdvertisingInfoStrategy m15155d() {
        return new AdvertisingInfoServiceStrategy(this.f14559a);
    }

    /* JADX INFO: renamed from: c */
    private boolean m15150c(AdvertisingInfo advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.f14557a)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public AdvertisingInfo m15151e() {
        AdvertisingInfo advertisingInfoMo15159a = m15154c().mo15159a();
        if (!m15150c(advertisingInfoMo15159a)) {
            advertisingInfoMo15159a = m15155d().mo15159a();
            if (!m15150c(advertisingInfoMo15159a)) {
                Fabric.m15085h().mo15063a("Fabric", "AdvertisingInfo not present");
            } else {
                Fabric.m15085h().mo15063a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            Fabric.m15085h().mo15063a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return advertisingInfoMo15159a;
    }
}
