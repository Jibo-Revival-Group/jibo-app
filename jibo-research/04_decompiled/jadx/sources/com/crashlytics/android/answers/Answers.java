package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Answers extends Kit<Boolean> {

    /* JADX INFO: renamed from: a */
    SessionAnalyticsManager f5017a;

    /* JADX INFO: renamed from: a */
    public void m5606a(Crash.LoggedException loggedException) {
        if (this.f5017a != null) {
            this.f5017a.m5668a(loggedException.m15213a());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5605a(Crash.FatalException fatalException) {
        if (this.f5017a != null) {
            this.f5017a.m5669a(fatalException.m15213a(), fatalException.m15214b());
        }
    }

    @Override // io.fabric.sdk.android.Kit
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a_ */
    protected boolean mo5607a_() {
        long jLastModified;
        boolean z = false;
        try {
            Context contextR = m15121r();
            PackageManager packageManager = contextR.getPackageManager();
            String packageName = contextR.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String string = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                jLastModified = packageInfo.firstInstallTime;
            } else {
                jLastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f5017a = SessionAnalyticsManager.m5664a(this, contextR, m15120q(), string, str, jLastModified);
            this.f5017a.m5670b();
            z = true;
            return true;
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Answers", "Error retrieving app properties", e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean mo5604f() {
        boolean z;
        try {
            SettingsData settingsDataM15458b = Settings.m15455a().m15458b();
            if (settingsDataM15458b == null) {
                Fabric.m15085h().mo15072e("Answers", "Failed to retrieve settings");
                z = false;
            } else if (settingsDataM15458b.f14790d.f14763d) {
                Fabric.m15085h().mo15063a("Answers", "Analytics collection enabled");
                this.f5017a.m5667a(settingsDataM15458b.f14791e, m5609e());
                z = true;
            } else {
                Fabric.m15085h().mo15063a("Answers", "Analytics collection disabled");
                this.f5017a.m5671c();
                z = false;
            }
            return z;
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Answers", "Error dealing with settings", e);
            return false;
        }
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: b */
    public String mo5601b() {
        return "com.crashlytics.sdk.android:answers";
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a */
    public String mo5600a() {
        return "1.3.13.dev";
    }

    /* JADX INFO: renamed from: e */
    String m5609e() {
        return CommonUtils.m15195b(m15121r(), "com.crashlytics.ApiEndpoint");
    }
}
