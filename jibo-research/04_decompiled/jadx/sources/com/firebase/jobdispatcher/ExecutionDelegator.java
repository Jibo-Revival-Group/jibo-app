package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.firebase.jobdispatcher.IJobCallback;
import com.firebase.jobdispatcher.JobInvocation;

/* JADX INFO: loaded from: classes.dex */
class ExecutionDelegator {

    /* JADX INFO: renamed from: a */
    private static final SimpleArrayMap<String, JobServiceConnection> f5693a = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: b */
    private final IJobCallback f5694b = new IJobCallback.Stub() { // from class: com.firebase.jobdispatcher.ExecutionDelegator.1
        @Override // com.firebase.jobdispatcher.IJobCallback
        /* JADX INFO: renamed from: a */
        public void mo6519a(Bundle bundle, int i) {
            JobInvocation.Builder builderM6596b = GooglePlayReceiver.m6551b().m6596b(bundle);
            if (builderM6596b != null) {
                ExecutionDelegator.this.m6516a(builderM6596b.m6615a(), i);
            } else {
                Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
            }
        }
    };

    /* JADX INFO: renamed from: c */
    private final Context f5695c;

    /* JADX INFO: renamed from: d */
    private final JobFinishedCallback f5696d;

    interface JobFinishedCallback {
        /* JADX INFO: renamed from: a */
        void mo6520a(JobInvocation jobInvocation, int i);
    }

    ExecutionDelegator(Context context, JobFinishedCallback jobFinishedCallback) {
        this.f5695c = context;
        this.f5696d = jobFinishedCallback;
    }

    /* JADX INFO: renamed from: a */
    void m6518a(JobInvocation jobInvocation) {
        if (jobInvocation != null) {
            synchronized (f5693a) {
                JobServiceConnection jobServiceConnection = f5693a.get(jobInvocation.mo6570i());
                if (jobServiceConnection != null && !jobServiceConnection.m6629a()) {
                    if (jobServiceConnection.m6633c(jobInvocation) && !jobServiceConnection.m6630b()) {
                        return;
                    }
                } else {
                    jobServiceConnection = new JobServiceConnection(this.f5694b, this.f5695c);
                    f5693a.put(jobInvocation.mo6570i(), jobServiceConnection);
                }
                if (!jobServiceConnection.m6631b(jobInvocation) && !this.f5695c.bindService(m6514a((JobParameters) jobInvocation), jobServiceConnection, 1)) {
                    Log.e("FJD.ExternalReceiver", "Unable to bind to " + jobInvocation.mo6570i());
                    jobServiceConnection.m6632c();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private Intent m6514a(JobParameters jobParameters) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f5695c, jobParameters.mo6570i());
        return intent;
    }

    /* JADX INFO: renamed from: a */
    static void m6517a(JobInvocation jobInvocation, boolean z) {
        synchronized (f5693a) {
            JobServiceConnection jobServiceConnection = f5693a.get(jobInvocation.mo6570i());
            if (jobServiceConnection != null) {
                jobServiceConnection.m6628a(jobInvocation, z);
                if (jobServiceConnection.m6629a()) {
                    f5693a.remove(jobInvocation.mo6570i());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6516a(JobInvocation jobInvocation, int i) {
        synchronized (f5693a) {
            JobServiceConnection jobServiceConnection = f5693a.get(jobInvocation.mo6570i());
            if (jobServiceConnection != null) {
                jobServiceConnection.m6627a(jobInvocation);
                if (jobServiceConnection.m6629a()) {
                    f5693a.remove(jobInvocation.mo6570i());
                }
            }
        }
        this.f5696d.mo6520a(jobInvocation, i);
    }
}
