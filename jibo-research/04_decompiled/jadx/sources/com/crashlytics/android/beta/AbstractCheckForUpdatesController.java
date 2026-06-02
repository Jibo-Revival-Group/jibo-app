package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractCheckForUpdatesController implements UpdatesController {

    /* JADX INFO: renamed from: a */
    private final AtomicBoolean f5108a;

    /* JADX INFO: renamed from: b */
    private final AtomicBoolean f5109b;

    /* JADX INFO: renamed from: c */
    private Context f5110c;

    /* JADX INFO: renamed from: d */
    private Beta f5111d;

    /* JADX INFO: renamed from: e */
    private IdManager f5112e;

    /* JADX INFO: renamed from: f */
    private BetaSettingsData f5113f;

    /* JADX INFO: renamed from: g */
    private BuildProperties f5114g;

    /* JADX INFO: renamed from: h */
    private PreferenceStore f5115h;

    /* JADX INFO: renamed from: i */
    private CurrentTimeProvider f5116i;

    /* JADX INFO: renamed from: j */
    private HttpRequestFactory f5117j;

    /* JADX INFO: renamed from: k */
    private long f5118k;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.f5108a = new AtomicBoolean();
        this.f5118k = 0L;
        this.f5109b = new AtomicBoolean(z);
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    /* JADX INFO: renamed from: a */
    public void mo5685a(Context context, Beta beta, IdManager idManager, BetaSettingsData betaSettingsData, BuildProperties buildProperties, PreferenceStore preferenceStore, CurrentTimeProvider currentTimeProvider, HttpRequestFactory httpRequestFactory) {
        this.f5110c = context;
        this.f5111d = beta;
        this.f5112e = idManager;
        this.f5113f = betaSettingsData;
        this.f5114g = buildProperties;
        this.f5115h = preferenceStore;
        this.f5116i = currentTimeProvider;
        this.f5117j = httpRequestFactory;
        if (m5687b()) {
            m5688c();
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m5686a() {
        this.f5109b.set(true);
        return this.f5108a.get();
    }

    /* JADX INFO: renamed from: b */
    boolean m5687b() {
        this.f5108a.set(true);
        return this.f5109b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    /* JADX INFO: renamed from: c */
    protected void m5688c() {
        synchronized (this.f5115h) {
            if (this.f5115h.mo15420a().contains("last_update_check")) {
                this.f5115h.mo15421a(this.f5115h.mo15422b().remove("last_update_check"));
            }
        }
        long jMo15215a = this.f5116i.mo15215a();
        long j = ((long) this.f5113f.f14751b) * 1000;
        Fabric.m15085h().mo15063a("Beta", "Check for updates delay: " + j);
        Fabric.m15085h().mo15063a("Beta", "Check for updates last check time: " + m5689d());
        long jM5689d = j + m5689d();
        Fabric.m15085h().mo15063a("Beta", "Check for updates current time: " + jMo15215a + ", next check time: " + jM5689d);
        if (jMo15215a >= jM5689d) {
            try {
                m5683e();
                return;
            } finally {
                m5684a(jMo15215a);
            }
        }
        Fabric.m15085h().mo15063a("Beta", "Check for updates next check time was not passed");
    }

    /* JADX INFO: renamed from: e */
    private void m5683e() throws Throwable {
        Fabric.m15085h().mo15063a("Beta", "Performing update check");
        new CheckForUpdatesRequest(this.f5111d, this.f5111d.m5698g(), this.f5113f.f14750a, this.f5117j, new CheckForUpdatesResponseTransform()).m5704a(new ApiKey().m15165a(this.f5110c), this.f5112e.m15233i().get(IdManager.DeviceIdentifierType.FONT_TOKEN), this.f5114g);
    }

    /* JADX INFO: renamed from: a */
    void m5684a(long j) {
        this.f5118k = j;
    }

    /* JADX INFO: renamed from: d */
    long m5689d() {
        return this.f5118k;
    }
}
