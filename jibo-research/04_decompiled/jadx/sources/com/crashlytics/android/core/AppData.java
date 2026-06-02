package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.IdManager;

/* JADX INFO: loaded from: classes.dex */
class AppData {

    /* JADX INFO: renamed from: a */
    public final String f5137a;

    /* JADX INFO: renamed from: b */
    public final String f5138b;

    /* JADX INFO: renamed from: c */
    public final String f5139c;

    /* JADX INFO: renamed from: d */
    public final String f5140d;

    /* JADX INFO: renamed from: e */
    public final String f5141e;

    /* JADX INFO: renamed from: f */
    public final String f5142f;

    /* JADX INFO: renamed from: a */
    public static AppData m5710a(Context context, IdManager idManager, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strM15234j = idManager.m15234j();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new AppData(str, str2, strM15234j, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    AppData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f5137a = str;
        this.f5138b = str2;
        this.f5139c = str3;
        this.f5140d = str4;
        this.f5141e = str5;
        this.f5142f = str6;
    }
}
