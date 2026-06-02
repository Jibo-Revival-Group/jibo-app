package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {

    /* JADX INFO: renamed from: a */
    private final PreferenceStore f5313a;

    /* JADX INFO: renamed from: a */
    public static PreferenceManager m5954a(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        if (!preferenceStore.mo15420a().getBoolean("preferences_migration_complete", false)) {
            PreferenceStoreImpl preferenceStoreImpl = new PreferenceStoreImpl(crashlyticsCore);
            if (!preferenceStore.mo15420a().contains("always_send_reports_opt_in") && preferenceStoreImpl.mo15420a().contains("always_send_reports_opt_in")) {
                preferenceStore.mo15421a(preferenceStore.mo15422b().putBoolean("always_send_reports_opt_in", preferenceStoreImpl.mo15420a().getBoolean("always_send_reports_opt_in", false)));
            }
            preferenceStore.mo15421a(preferenceStore.mo15422b().putBoolean("preferences_migration_complete", true));
        }
        return new PreferenceManager(preferenceStore);
    }

    public PreferenceManager(PreferenceStore preferenceStore) {
        this.f5313a = preferenceStore;
    }

    /* JADX INFO: renamed from: a */
    void m5955a(boolean z) {
        this.f5313a.mo15421a(this.f5313a.mo15422b().putBoolean("always_send_reports_opt_in", z));
    }

    /* JADX INFO: renamed from: a */
    boolean m5956a() {
        return this.f5313a.mo15420a().getBoolean("always_send_reports_opt_in", false);
    }
}
