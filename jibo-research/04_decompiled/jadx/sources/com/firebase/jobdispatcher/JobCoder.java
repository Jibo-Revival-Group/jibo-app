package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.firebase.jobdispatcher.JobInvocation;
import com.firebase.jobdispatcher.JobTrigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class JobCoder {

    /* JADX INFO: renamed from: a */
    private final String f5741a;

    JobCoder(String str) {
        this.f5741a = str;
    }

    /* JADX INFO: renamed from: a */
    Bundle m6594a(JobParameters jobParameters, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        Bundle bundleMo6563b = jobParameters.mo6563b();
        if (bundleMo6563b != null) {
            bundle.putAll(bundleMo6563b);
        }
        bundle.putInt(this.f5741a + "persistent", jobParameters.mo6568g());
        bundle.putBoolean(this.f5741a + "recurring", jobParameters.mo6569h());
        bundle.putBoolean(this.f5741a + "replace_current", jobParameters.mo6565d());
        bundle.putString(this.f5741a + "tag", jobParameters.mo6566e());
        bundle.putString(this.f5741a + "service", jobParameters.mo6570i());
        bundle.putInt(this.f5741a + "constraints", Constraint.m6495a(jobParameters.mo6562a()));
        m6590a(jobParameters.mo6567f(), bundle);
        m6591a(jobParameters.mo6564c(), bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    JobInvocation m6595a(Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
            return null;
        }
        Bundle bundle2 = bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
        if (bundle2 == null) {
            return null;
        }
        JobInvocation.Builder builderM6596b = m6596b(bundle2);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("triggered_uris");
        if (parcelableArrayList != null) {
            builderM6596b.m6611a(new TriggerReason(parcelableArrayList));
        }
        return builderM6596b.m6615a();
    }

    /* JADX INFO: renamed from: b */
    public JobInvocation.Builder m6596b(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Unexpected null Bundle provided");
        }
        Bundle bundle2 = new Bundle(bundle);
        boolean z = bundle2.getBoolean(this.f5741a + "recurring");
        boolean z2 = bundle2.getBoolean(this.f5741a + "replace_current");
        int i = bundle2.getInt(this.f5741a + "persistent");
        int[] iArrM6496a = Constraint.m6496a(bundle2.getInt(this.f5741a + "constraints"));
        JobTrigger jobTriggerM6592c = m6592c(bundle2);
        RetryStrategy retryStrategyM6593d = m6593d(bundle2);
        String string = bundle2.getString(this.f5741a + "tag");
        String string2 = bundle2.getString(this.f5741a + "service");
        if (string == null || string2 == null || jobTriggerM6592c == null || retryStrategyM6593d == null) {
            return null;
        }
        JobInvocation.Builder builder = new JobInvocation.Builder();
        builder.m6612a(string);
        builder.m6616b(string2);
        builder.m6609a(jobTriggerM6592c);
        builder.m6610a(retryStrategyM6593d);
        builder.m6613a(z);
        builder.m6607a(i);
        builder.m6614a(iArrM6496a);
        builder.m6617b(z2);
        if (!TextUtils.isEmpty(this.f5741a)) {
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().startsWith(this.f5741a)) {
                    it.remove();
                }
            }
        }
        builder.m6608a(bundle2);
        return builder;
    }

    /* JADX INFO: renamed from: c */
    private JobTrigger m6592c(Bundle bundle) {
        switch (bundle.getInt(this.f5741a + "trigger_type")) {
            case 1:
                return Trigger.m6643a(bundle.getInt(this.f5741a + "window_start"), bundle.getInt(this.f5741a + "window_end"));
            case 2:
                return Trigger.f5791a;
            case 3:
                return Trigger.m6642a(Collections.unmodifiableList(m6589a(bundle.getString(this.f5741a + "observed_uris"))));
            default:
                if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
                    Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
                }
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6590a(JobTrigger jobTrigger, Bundle bundle) {
        if (jobTrigger == Trigger.f5791a) {
            bundle.putInt(this.f5741a + "trigger_type", 2);
            return;
        }
        if (jobTrigger instanceof JobTrigger.ExecutionWindowTrigger) {
            JobTrigger.ExecutionWindowTrigger executionWindowTrigger = (JobTrigger.ExecutionWindowTrigger) jobTrigger;
            bundle.putInt(this.f5741a + "trigger_type", 1);
            bundle.putInt(this.f5741a + "window_start", executionWindowTrigger.m6635a());
            bundle.putInt(this.f5741a + "window_end", executionWindowTrigger.m6636b());
            return;
        }
        if (jobTrigger instanceof JobTrigger.ContentUriTrigger) {
            bundle.putInt(this.f5741a + "trigger_type", 3);
            bundle.putString(this.f5741a + "observed_uris", m6588a(((JobTrigger.ContentUriTrigger) jobTrigger).m6634a()));
            return;
        }
        throw new IllegalArgumentException("Unsupported trigger.");
    }

    /* JADX INFO: renamed from: d */
    private RetryStrategy m6593d(Bundle bundle) {
        int i = bundle.getInt(this.f5741a + "retry_policy");
        if (i != 1 && i != 2) {
            return RetryStrategy.f5784a;
        }
        return new RetryStrategy(i, bundle.getInt(this.f5741a + "initial_backoff_seconds"), bundle.getInt(this.f5741a + "maximum_backoff_seconds"));
    }

    /* JADX INFO: renamed from: a */
    private void m6591a(RetryStrategy retryStrategy, Bundle bundle) {
        if (retryStrategy == null) {
            retryStrategy = RetryStrategy.f5784a;
        }
        bundle.putInt(this.f5741a + "retry_policy", retryStrategy.m6639a());
        bundle.putInt(this.f5741a + "initial_backoff_seconds", retryStrategy.m6640b());
        bundle.putInt(this.f5741a + "maximum_backoff_seconds", retryStrategy.m6641c());
    }

    /* JADX INFO: renamed from: a */
    private static String m6588a(List<ObservedUri> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (ObservedUri observedUri : list) {
            jSONArray.put(observedUri.m6638b());
            jSONArray2.put(observedUri.m6637a());
        }
        try {
            jSONObject.put("uri_flags", jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static List<ObservedUri> m6589a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("uri_flags");
            JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new ObservedUri(Uri.parse(jSONArray2.getString(i)), jSONArray.getInt(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
