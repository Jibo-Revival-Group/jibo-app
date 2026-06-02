package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.firebase.jobdispatcher.JobTrigger;

/* JADX INFO: loaded from: classes.dex */
final class GooglePlayJobWriter {

    /* JADX INFO: renamed from: a */
    private final JobCoder f5708a = new JobCoder("com.firebase.jobdispatcher.");

    GooglePlayJobWriter() {
    }

    /* JADX INFO: renamed from: a */
    private static void m6538a(JobParameters jobParameters, Bundle bundle, JobTrigger.ExecutionWindowTrigger executionWindowTrigger) {
        bundle.putInt("trigger_type", 1);
        if (jobParameters.mo6569h()) {
            bundle.putLong("period", executionWindowTrigger.m6636b());
            bundle.putLong("period_flex", executionWindowTrigger.m6636b() - executionWindowTrigger.m6635a());
        } else {
            bundle.putLong("window_start", executionWindowTrigger.m6635a());
            bundle.putLong("window_end", executionWindowTrigger.m6636b());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m6536a(Bundle bundle) {
        bundle.putInt("trigger_type", 2);
        bundle.putLong("window_start", 0L);
        bundle.putLong("window_end", 1L);
    }

    /* JADX INFO: renamed from: a */
    private static void m6537a(Bundle bundle, JobTrigger.ContentUriTrigger contentUriTrigger) {
        bundle.putInt("trigger_type", 3);
        int size = contentUriTrigger.m6634a().size();
        int[] iArr = new int[size];
        Uri[] uriArr = new Uri[size];
        for (int i = 0; i < size; i++) {
            ObservedUri observedUri = contentUriTrigger.m6634a().get(i);
            iArr[i] = observedUri.m6638b();
            uriArr[i] = observedUri.m6637a();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", uriArr);
    }

    /* JADX INFO: renamed from: a */
    public Bundle m6543a(JobParameters jobParameters, Bundle bundle) {
        bundle.putString("tag", jobParameters.mo6566e());
        bundle.putBoolean("update_current", jobParameters.mo6565d());
        bundle.putBoolean("persisted", jobParameters.mo6568g() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        m6541c(jobParameters, bundle);
        m6542d(jobParameters, bundle);
        m6540b(jobParameters, bundle);
        Bundle bundleMo6563b = jobParameters.mo6563b();
        if (bundleMo6563b == null) {
            bundleMo6563b = new Bundle();
        }
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.f5708a.m6594a(jobParameters, bundleMo6563b));
        return bundle;
    }

    /* JADX INFO: renamed from: b */
    private static void m6540b(JobParameters jobParameters, Bundle bundle) {
        RetryStrategy retryStrategyMo6564c = jobParameters.mo6564c();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", m6535a(retryStrategyMo6564c.m6639a()));
        bundle2.putInt("initial_backoff_seconds", retryStrategyMo6564c.m6640b());
        bundle2.putInt("maximum_backoff_seconds", retryStrategyMo6564c.m6641c());
        bundle.putBundle("retryStrategy", bundle2);
    }

    /* JADX INFO: renamed from: a */
    private static int m6535a(int i) {
        switch (i) {
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m6541c(JobParameters jobParameters, Bundle bundle) {
        JobTrigger jobTriggerMo6567f = jobParameters.mo6567f();
        if (jobTriggerMo6567f == Trigger.f5791a) {
            m6536a(bundle);
        } else if (jobTriggerMo6567f instanceof JobTrigger.ExecutionWindowTrigger) {
            m6538a(jobParameters, bundle, (JobTrigger.ExecutionWindowTrigger) jobTriggerMo6567f);
        } else {
            if (jobTriggerMo6567f instanceof JobTrigger.ContentUriTrigger) {
                m6537a(bundle, (JobTrigger.ContentUriTrigger) jobTriggerMo6567f);
                return;
            }
            throw new IllegalArgumentException("Unknown trigger: " + jobTriggerMo6567f.getClass());
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m6542d(JobParameters jobParameters, Bundle bundle) {
        int iM6495a = Constraint.m6495a(jobParameters.mo6562a());
        bundle.putBoolean("requiresCharging", (iM6495a & 4) == 4);
        bundle.putBoolean("requiresIdle", (iM6495a & 8) == 8);
        bundle.putInt("requiredNetwork", m6539b(iM6495a));
    }

    /* JADX INFO: renamed from: b */
    private static int m6539b(int i) {
        int i2 = (i & 2) == 2 ? 0 : 2;
        if ((i & 1) == 1) {
            return 1;
        }
        return i2;
    }
}
