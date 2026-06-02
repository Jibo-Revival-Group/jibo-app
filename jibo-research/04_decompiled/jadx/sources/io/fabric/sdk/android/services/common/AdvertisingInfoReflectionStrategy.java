package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;

/* JADX INFO: loaded from: classes2.dex */
class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {

    /* JADX INFO: renamed from: a */
    private final Context f14563a;

    public AdvertisingInfoReflectionStrategy(Context context) {
        this.f14563a = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    boolean m15160a(Context context) {
        try {
            return ((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context)).intValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // io.fabric.sdk.android.services.common.AdvertisingInfoStrategy
    /* JADX INFO: renamed from: a */
    public AdvertisingInfo mo15159a() {
        if (m15160a(this.f14563a)) {
            return new AdvertisingInfo(m15156b(), m15157c());
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private String m15156b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m15158d(), new Object[0]);
        } catch (Exception e) {
            Fabric.m15085h().mo15070d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m15157c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m15158d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            Fabric.m15085h().mo15070d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    private Object m15158d() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f14563a);
        } catch (Exception e) {
            Fabric.m15085h().mo15070d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
