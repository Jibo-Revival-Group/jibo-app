package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

/* JADX INFO: loaded from: classes2.dex */
public class ApiKey {
    /* JADX INFO: renamed from: a */
    public String m15165a(Context context) {
        String strM15166b = m15166b(context);
        if (TextUtils.isEmpty(strM15166b)) {
            strM15166b = m15167c(context);
        }
        if (TextUtils.isEmpty(strM15166b)) {
            m15168d(context);
        }
        return strM15166b;
    }

    /* JADX INFO: renamed from: b */
    protected String m15166b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            if (string == null) {
                Fabric.m15085h().mo15063a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            }
            return string;
        } catch (Exception e) {
            Fabric.m15085h().mo15063a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    protected String m15167c(Context context) {
        int iM15170a = CommonUtils.m15170a(context, "io.fabric.ApiKey", "string");
        if (iM15170a == 0) {
            Fabric.m15085h().mo15063a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            iM15170a = CommonUtils.m15170a(context, "com.crashlytics.ApiKey", "string");
        }
        if (iM15170a == 0) {
            return null;
        }
        return context.getResources().getString(iM15170a);
    }

    /* JADX INFO: renamed from: d */
    protected void m15168d(Context context) {
        if (Fabric.m15086i() || CommonUtils.m15206i(context)) {
            throw new IllegalArgumentException(m15164a());
        }
        Fabric.m15085h().mo15072e("Fabric", m15164a());
    }

    /* JADX INFO: renamed from: a */
    protected String m15164a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
