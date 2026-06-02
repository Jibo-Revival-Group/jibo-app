package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzevw;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewn;
import com.google.firebase.perf.metrics.AppStartTrace;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebasePerfProvider extends ContentProvider {
    private static final zzewn zzoem;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    static {
        new zzewk();
        zzoem = new zzewn();
    }

    public static zzewn zzckv() {
        return zzoem;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        zzbq.m7374a(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseperfprovider".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
        super.attachInfo(context, providerInfo);
        zzevw.m8544a().m8550a(getContext());
        AppStartTrace appStartTraceM9247a = AppStartTrace.m9247a();
        appStartTraceM9247a.m9251a(getContext());
        this.mHandler.post(new AppStartTrace.zza(appStartTraceM9247a));
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
