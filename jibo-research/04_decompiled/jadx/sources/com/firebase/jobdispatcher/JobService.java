package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.firebase.jobdispatcher.IRemoteJobService;
import com.firebase.jobdispatcher.JobInvocation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobService extends Service {

    /* JADX INFO: renamed from: a */
    private static final Handler f5762a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b */
    private final SimpleArrayMap<String, JobCallback> f5763b = new SimpleArrayMap<>(1);

    /* JADX INFO: renamed from: c */
    private final IRemoteJobService.Stub f5764c = new IRemoteJobService.Stub() { // from class: com.firebase.jobdispatcher.JobService.1
        @Override // com.firebase.jobdispatcher.IRemoteJobService
        /* JADX INFO: renamed from: a */
        public void mo6559a(Bundle bundle, IJobCallback iJobCallback) {
            JobInvocation.Builder builderM6596b = GooglePlayReceiver.m6551b().m6596b(bundle);
            if (builderM6596b == null) {
                Log.wtf("FJD.JobService", "start: unknown invocation provided");
            } else {
                JobService.this.m6619a(builderM6596b.m6615a(), iJobCallback);
            }
        }

        @Override // com.firebase.jobdispatcher.IRemoteJobService
        /* JADX INFO: renamed from: a */
        public void mo6560a(Bundle bundle, boolean z) {
            JobInvocation.Builder builderM6596b = GooglePlayReceiver.m6551b().m6596b(bundle);
            if (builderM6596b == null) {
                Log.wtf("FJD.JobService", "stop: unknown invocation provided");
            } else {
                JobService.this.m6620a(builderM6596b.m6615a(), z);
            }
        }
    };

    /* JADX INFO: renamed from: a */
    public abstract boolean mo6621a(JobParameters jobParameters);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo6623b(JobParameters jobParameters);

    /* JADX INFO: renamed from: a */
    void m6619a(final JobParameters jobParameters, IJobCallback iJobCallback) {
        synchronized (this.f5763b) {
            if (this.f5763b.containsKey(jobParameters.mo6566e())) {
                Log.w("FJD.JobService", String.format(Locale.US, "Job with tag = %s was already running.", jobParameters.mo6566e()));
            } else {
                this.f5763b.put(jobParameters.mo6566e(), new JobCallback(jobParameters, iJobCallback));
                f5762a.post(new Runnable() { // from class: com.firebase.jobdispatcher.JobService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JobCallback jobCallback;
                        synchronized (JobService.this.f5763b) {
                            if (!JobService.this.mo6621a(jobParameters) && (jobCallback = (JobCallback) JobService.this.f5763b.remove(jobParameters.mo6566e())) != null) {
                                jobCallback.m6624a(0);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m6620a(final JobParameters jobParameters, final boolean z) {
        synchronized (this.f5763b) {
            final JobCallback jobCallbackRemove = this.f5763b.remove(jobParameters.mo6566e());
            if (jobCallbackRemove == null) {
                if (Log.isLoggable("FJD.JobService", 3)) {
                    Log.d("FJD.JobService", "Provided job has already been executed.");
                }
            } else {
                f5762a.post(new Runnable() { // from class: com.firebase.jobdispatcher.JobService.3
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zMo6623b = JobService.this.mo6623b(jobParameters);
                        if (z) {
                            jobCallbackRemove.m6624a(zMo6623b ? 1 : 0);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m6622b(JobParameters jobParameters, boolean z) {
        if (jobParameters == null) {
            Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
            return;
        }
        synchronized (this.f5763b) {
            JobCallback jobCallbackRemove = this.f5763b.remove(jobParameters.mo6566e());
            if (jobCallbackRemove != null) {
                jobCallbackRemove.m6624a(z ? 1 : 0);
            }
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f5764c;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        synchronized (this.f5763b) {
            for (int size = this.f5763b.size() - 1; size >= 0; size--) {
                JobCallback jobCallbackRemove = this.f5763b.remove(this.f5763b.m2452b(size));
                if (jobCallbackRemove != null) {
                    jobCallbackRemove.m6624a(mo6623b(jobCallbackRemove.f5772a) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
    }

    @Override // android.app.Service
    protected final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    private static final class JobCallback {

        /* JADX INFO: renamed from: a */
        final JobParameters f5772a;

        /* JADX INFO: renamed from: b */
        final IJobCallback f5773b;

        private JobCallback(JobParameters jobParameters, IJobCallback iJobCallback) {
            this.f5772a = jobParameters;
            this.f5773b = iJobCallback;
        }

        /* JADX INFO: renamed from: a */
        void m6624a(int i) {
            try {
                this.f5773b.mo6519a(GooglePlayReceiver.m6551b().m6594a(this.f5772a, new Bundle()), i);
            } catch (RemoteException e) {
                Log.e("FJD.JobService", "Failed to send result to driver", e);
            }
        }
    }
}
