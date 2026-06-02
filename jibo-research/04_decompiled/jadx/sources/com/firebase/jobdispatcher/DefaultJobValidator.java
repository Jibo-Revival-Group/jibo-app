package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.firebase.jobdispatcher.JobTrigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DefaultJobValidator implements JobValidator {

    /* JADX INFO: renamed from: a */
    private final Context f5692a;

    public DefaultJobValidator(Context context) {
        this.f5692a = context;
    }

    /* JADX INFO: renamed from: a */
    private static int m6497a(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        bundle.writeToParcel(parcelObtain, 0);
        int iDataSize = parcelObtain.dataSize();
        parcelObtain.recycle();
        return iDataSize;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m6500a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 != null) {
            list.addAll(list2);
            return list;
        }
        return list;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m6499a(List<String> list, String str) {
        if (str != null) {
            if (list == null) {
                return m6505c(str);
            }
            Collections.addAll(list, str);
            return list;
        }
        return list;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m6501a(boolean z, List<String> list, String str) {
        if (z) {
            return m6499a(list, str);
        }
        return list;
    }

    @Override // com.firebase.jobdispatcher.JobValidator
    /* JADX INFO: renamed from: a */
    public List<String> mo6506a(JobParameters jobParameters) {
        List<String> listM6500a = m6500a(m6500a((List<String>) null, m6507a(jobParameters.mo6567f())), m6508a(jobParameters.mo6564c()));
        if (jobParameters.mo6569h() && jobParameters.mo6567f() == Trigger.f5791a) {
            listM6500a = m6499a(listM6500a, "ImmediateTriggers can't be used with recurring jobs");
        }
        List<String> listM6500a2 = m6500a(listM6500a, m6504c(jobParameters.mo6563b()));
        if (jobParameters.mo6568g() > 1) {
            listM6500a2 = m6500a(listM6500a2, m6502b(jobParameters.mo6563b()));
        }
        return m6500a(m6500a(listM6500a2, m6503b(jobParameters.mo6566e())), m6509a(jobParameters.mo6570i()));
    }

    /* JADX INFO: renamed from: a */
    public List<String> m6507a(JobTrigger jobTrigger) {
        if (jobTrigger == Trigger.f5791a || (jobTrigger instanceof JobTrigger.ExecutionWindowTrigger) || (jobTrigger instanceof JobTrigger.ContentUriTrigger)) {
            return null;
        }
        return m6505c("Unknown trigger provided");
    }

    /* JADX INFO: renamed from: a */
    public List<String> m6508a(RetryStrategy retryStrategy) {
        int iM6639a = retryStrategy.m6639a();
        int iM6640b = retryStrategy.m6640b();
        int iM6641c = retryStrategy.m6641c();
        return m6501a(iM6640b < 30, m6501a(300 > iM6641c, m6501a(iM6641c < iM6640b, m6501a((iM6639a == 1 || iM6639a == 2) ? false : true, null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)"), "Initial backoff must be at least 30s");
    }

    /* JADX INFO: renamed from: b */
    private static List<String> m6502b(Bundle bundle) {
        List<String> listM6499a = null;
        if (bundle == null) {
            return null;
        }
        Iterator<String> it = bundle.keySet().iterator();
        while (true) {
            List<String> list = listM6499a;
            if (it.hasNext()) {
                listM6499a = m6499a(list, m6498a(bundle, it.next()));
            } else {
                return list;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static List<String> m6504c(Bundle bundle) {
        int iM6497a;
        if (bundle != null && (iM6497a = m6497a(bundle)) > 10240) {
            return m6505c(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", Integer.valueOf(iM6497a), 10240));
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static String m6498a(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = obj != null ? obj.getClass() : null;
        objArr[1] = str;
        return String.format(locale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", objArr);
    }

    /* JADX INFO: renamed from: a */
    List<String> m6509a(String str) {
        if (str == null || str.isEmpty()) {
            return m6505c("Service can't be empty");
        }
        if (this.f5692a == null) {
            return m6505c("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = this.f5692a.getPackageManager();
        if (packageManager == null) {
            return m6505c("PackageManager is null, can't validate service");
        }
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f5692a, str);
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Log.e("FJD.GooglePlayReceiver", "Couldn't find a registered service with the name " + str + ". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.enabled) {
                return null;
            }
        }
        return m6505c(str + " is disabled.");
    }

    /* JADX INFO: renamed from: b */
    private static List<String> m6503b(String str) {
        if (str == null) {
            return m6505c("Tag can't be null");
        }
        if (str.length() > 100) {
            return m6505c("Tag must be shorter than 100");
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private static List<String> m6505c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
