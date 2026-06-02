package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

/* JADX INFO: loaded from: classes.dex */
class AnswersPreferenceManager {

    /* JADX INFO: renamed from: a */
    private final PreferenceStore f5039a;

    /* JADX INFO: renamed from: a */
    public static AnswersPreferenceManager m5634a(Context context) {
        return new AnswersPreferenceManager(new PreferenceStoreImpl(context, "settings"));
    }

    AnswersPreferenceManager(PreferenceStore preferenceStore) {
        this.f5039a = preferenceStore;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* JADX INFO: renamed from: a */
    public void m5635a() {
        this.f5039a.mo15421a(this.f5039a.mo15422b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* JADX INFO: renamed from: b */
    public boolean m5636b() {
        return this.f5039a.mo15420a().getBoolean("analytics_launched", false);
    }
}
