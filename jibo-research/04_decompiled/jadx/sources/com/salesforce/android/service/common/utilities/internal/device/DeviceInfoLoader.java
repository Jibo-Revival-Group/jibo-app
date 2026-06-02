package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.salesforce.android.service.common.utilities.internal.android.AndroidInfo;
import com.salesforce.android.service.common.utilities.internal.device.DeviceIdentifier;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfoLoader {

    /* JADX INFO: renamed from: a */
    private final String f13871a;

    /* JADX INFO: renamed from: b */
    private String f13872b;

    /* JADX INFO: renamed from: c */
    private String f13873c;

    /* JADX INFO: renamed from: d */
    private String f13874d;

    /* JADX INFO: renamed from: e */
    private String f13875e;

    protected DeviceInfoLoader(Builder builder) {
        AndroidInfo androidInfo = builder.f13877b;
        PackageInfo packageInfo = builder.f13878c;
        this.f13871a = builder.f13879d.m14148a();
        this.f13872b = builder.f13876a;
        this.f13873c = String.format(Locale.getDefault(), "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        this.f13874d = String.format("%s %s %s", "android", androidInfo.m14103a(), androidInfo.m14104b());
        this.f13875e = androidInfo.m14105c();
    }

    /* JADX INFO: renamed from: a */
    public String m14151a() {
        return this.f13872b;
    }

    /* JADX INFO: renamed from: b */
    public String m14152b() {
        return this.f13873c;
    }

    /* JADX INFO: renamed from: c */
    public String m14153c() {
        return this.f13874d;
    }

    /* JADX INFO: renamed from: d */
    public String m14154d() {
        return this.f13875e;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected String f13876a;

        /* JADX INFO: renamed from: b */
        protected AndroidInfo f13877b;

        /* JADX INFO: renamed from: c */
        protected PackageInfo f13878c;

        /* JADX INFO: renamed from: d */
        protected DeviceIdentifier f13879d;

        /* JADX INFO: renamed from: e */
        private Context f13880e;

        /* JADX INFO: renamed from: a */
        public Builder m14155a(Context context) {
            this.f13880e = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public DeviceInfoLoader m14156a() {
            Arguments.m14235a(this.f13880e);
            this.f13876a = this.f13880e.getPackageName();
            if (this.f13877b == null) {
                this.f13877b = new AndroidInfo();
            }
            if (this.f13878c == null) {
                try {
                    this.f13878c = this.f13880e.getPackageManager().getPackageInfo(this.f13876a, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            if (this.f13879d == null) {
                this.f13879d = new DeviceIdentifier.Builder().m14149a(this.f13880e).m14150a();
            }
            return new DeviceInfoLoader(this);
        }
    }
}
