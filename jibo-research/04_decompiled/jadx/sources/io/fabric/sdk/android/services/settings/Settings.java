package io.fabric.sdk.android.services.settings;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class Settings {

    /* JADX INFO: renamed from: a */
    private final AtomicReference<SettingsData> f14782a;

    /* JADX INFO: renamed from: b */
    private final CountDownLatch f14783b;

    /* JADX INFO: renamed from: c */
    private SettingsController f14784c;

    /* JADX INFO: renamed from: d */
    private boolean f14785d;

    static class LazyHolder {

        /* JADX INFO: renamed from: a */
        private static final Settings f14786a = new Settings();
    }

    /* JADX INFO: renamed from: a */
    public static Settings m15455a() {
        return LazyHolder.f14786a;
    }

    private Settings() {
        this.f14782a = new AtomicReference<>();
        this.f14783b = new CountDownLatch(1);
        this.f14785d = false;
    }

    /* JADX INFO: renamed from: a */
    public synchronized Settings m15457a(Kit kit, IdManager idManager, HttpRequestFactory httpRequestFactory, String str, String str2, String str3) {
        Settings settings;
        if (this.f14785d) {
            settings = this;
        } else {
            if (this.f14784c == null) {
                Context contextM15121r = kit.m15121r();
                String strM15227c = idManager.m15227c();
                String strM15165a = new ApiKey().m15165a(contextM15121r);
                String strM15234j = idManager.m15234j();
                this.f14784c = new DefaultSettingsController(kit, new SettingsRequest(strM15165a, idManager.m15231g(), idManager.m15230f(), idManager.m15229e(), idManager.m15237m(), idManager.m15226b(), idManager.m15238n(), CommonUtils.m15183a(CommonUtils.m15210m(contextM15121r)), str2, str, DeliveryMechanism.determineFrom(strM15234j).getId(), CommonUtils.m15208k(contextM15121r)), new SystemCurrentTimeProvider(), new DefaultSettingsJsonTransform(), new DefaultCachedSettingsIo(kit), new DefaultSettingsSpiCall(kit, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", strM15227c), httpRequestFactory));
            }
            this.f14785d = true;
            settings = this;
        }
        return settings;
    }

    /* JADX INFO: renamed from: b */
    public SettingsData m15458b() {
        try {
            this.f14783b.await();
            return this.f14782a.get();
        } catch (InterruptedException e) {
            Fabric.m15085h().mo15072e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m15459c() {
        SettingsData settingsDataMo15432a;
        settingsDataMo15432a = this.f14784c.mo15432a();
        m15456a(settingsDataMo15432a);
        return settingsDataMo15432a != null;
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m15460d() {
        SettingsData settingsDataMo15433a;
        settingsDataMo15433a = this.f14784c.mo15433a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m15456a(settingsDataMo15433a);
        if (settingsDataMo15433a == null) {
            Fabric.m15085h().mo15073e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return settingsDataMo15433a != null;
    }

    /* JADX INFO: renamed from: a */
    private void m15456a(SettingsData settingsData) {
        this.f14782a.set(settingsData);
        this.f14783b.countDown();
    }
}
