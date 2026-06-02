package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.fabric.sdk.android.Kit;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceStoreImpl implements PreferenceStore {

    /* JADX INFO: renamed from: a */
    private final SharedPreferences f14718a;

    /* JADX INFO: renamed from: b */
    private final String f14719b;

    /* JADX INFO: renamed from: c */
    private final Context f14720c;

    public PreferenceStoreImpl(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f14720c = context;
        this.f14719b = str;
        this.f14718a = this.f14720c.getSharedPreferences(this.f14719b, 0);
    }

    @Deprecated
    public PreferenceStoreImpl(Kit kit) {
        this(kit.m15121r(), kit.getClass().getName());
    }

    @Override // io.fabric.sdk.android.services.persistence.PreferenceStore
    /* JADX INFO: renamed from: a */
    public SharedPreferences mo15420a() {
        return this.f14718a;
    }

    @Override // io.fabric.sdk.android.services.persistence.PreferenceStore
    /* JADX INFO: renamed from: b */
    public SharedPreferences.Editor mo15422b() {
        return this.f14718a.edit();
    }

    @Override // io.fabric.sdk.android.services.persistence.PreferenceStore
    @TargetApi(9)
    /* JADX INFO: renamed from: a */
    public boolean mo15421a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
