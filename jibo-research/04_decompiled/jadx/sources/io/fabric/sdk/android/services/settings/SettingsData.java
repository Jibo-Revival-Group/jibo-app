package io.fabric.sdk.android.services.settings;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsData {

    /* JADX INFO: renamed from: a */
    public final AppSettingsData f14787a;

    /* JADX INFO: renamed from: b */
    public final SessionSettingsData f14788b;

    /* JADX INFO: renamed from: c */
    public final PromptSettingsData f14789c;

    /* JADX INFO: renamed from: d */
    public final FeaturesSettingsData f14790d;

    /* JADX INFO: renamed from: e */
    public final AnalyticsSettingsData f14791e;

    /* JADX INFO: renamed from: f */
    public final BetaSettingsData f14792f;

    /* JADX INFO: renamed from: g */
    public final long f14793g;

    /* JADX INFO: renamed from: h */
    public final int f14794h;

    /* JADX INFO: renamed from: i */
    public final int f14795i;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, PromptSettingsData promptSettingsData, FeaturesSettingsData featuresSettingsData, AnalyticsSettingsData analyticsSettingsData, BetaSettingsData betaSettingsData, int i, int i2) {
        this.f14793g = j;
        this.f14787a = appSettingsData;
        this.f14788b = sessionSettingsData;
        this.f14789c = promptSettingsData;
        this.f14790d = featuresSettingsData;
        this.f14794h = i;
        this.f14795i = i2;
        this.f14791e = analyticsSettingsData;
        this.f14792f = betaSettingsData;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15462a(long j) {
        return this.f14793g < j;
    }
}
