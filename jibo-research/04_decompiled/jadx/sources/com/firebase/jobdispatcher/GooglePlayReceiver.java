package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.util.Pair;
import com.firebase.jobdispatcher.ExecutionDelegator;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobInvocation;
import com.firebase.jobdispatcher.JobTrigger;

/* JADX INFO: loaded from: classes.dex */
public class GooglePlayReceiver extends Service implements ExecutionDelegator.JobFinishedCallback {

    /* JADX INFO: renamed from: d */
    private static final JobCoder f5712d = new JobCoder("com.firebase.jobdispatcher.");

    /* JADX INFO: renamed from: h */
    private static final SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> f5713h = new SimpleArrayMap<>(1);

    /* JADX INFO: renamed from: a */
    Messenger f5714a;

    /* JADX INFO: renamed from: b */
    Driver f5715b;

    /* JADX INFO: renamed from: c */
    ValidationEnforcer f5716c;

    /* JADX INFO: renamed from: e */
    private final GooglePlayCallbackExtractor f5717e = new GooglePlayCallbackExtractor();

    /* JADX INFO: renamed from: f */
    private ExecutionDelegator f5718f;

    /* JADX INFO: renamed from: g */
    private int f5719g;

    /* JADX INFO: renamed from: a */
    private static void m6548a(JobCallback jobCallback, int i) {
        try {
            jobCallback.mo6534a(i);
        } catch (Throwable th) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", th.getCause());
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                synchronized (f5713h) {
                    this.f5719g = i2;
                    if (f5713h.isEmpty()) {
                        stopSelf(this.f5719g);
                    }
                }
            } else {
                String action = intent.getAction();
                if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                    m6555a().m6518a(m6556a(intent));
                    synchronized (f5713h) {
                        this.f5719g = i2;
                        if (f5713h.isEmpty()) {
                            stopSelf(this.f5719g);
                        }
                    }
                } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                    synchronized (f5713h) {
                        this.f5719g = i2;
                        if (f5713h.isEmpty()) {
                            stopSelf(this.f5719g);
                        }
                    }
                } else {
                    Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                    synchronized (f5713h) {
                        this.f5719g = i2;
                        if (f5713h.isEmpty()) {
                            stopSelf(this.f5719g);
                        }
                    }
                }
            }
            return 2;
        } catch (Throwable th) {
            synchronized (f5713h) {
                this.f5719g = i2;
                if (f5713h.isEmpty()) {
                    stopSelf(this.f5719g);
                }
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || Build.VERSION.SDK_INT < 21 || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return null;
        }
        return m6552c().getBinder();
    }

    /* JADX INFO: renamed from: c */
    private synchronized Messenger m6552c() {
        if (this.f5714a == null) {
            this.f5714a = new Messenger(new GooglePlayMessageHandler(Looper.getMainLooper(), this));
        }
        return this.f5714a;
    }

    /* JADX INFO: renamed from: a */
    synchronized ExecutionDelegator m6555a() {
        if (this.f5718f == null) {
            this.f5718f = new ExecutionDelegator(this, this);
        }
        return this.f5718f;
    }

    /* JADX INFO: renamed from: d */
    private synchronized Driver m6553d() {
        if (this.f5715b == null) {
            this.f5715b = new GooglePlayDriver(getApplicationContext());
        }
        return this.f5715b;
    }

    /* JADX INFO: renamed from: e */
    private synchronized ValidationEnforcer m6554e() {
        if (this.f5716c == null) {
            this.f5716c = new ValidationEnforcer(m6553d().mo6512a());
        }
        return this.f5716c;
    }

    /* JADX INFO: renamed from: a */
    JobInvocation m6556a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
            return null;
        }
        Pair<JobCallback, Bundle> pairM6529a = this.f5717e.m6529a(extras);
        if (pairM6529a == null) {
            Log.i("FJD.GooglePlayReceiver", "no callback found");
            return null;
        }
        return m6557a((JobCallback) pairM6529a.first, (Bundle) pairM6529a.second);
    }

    /* JADX INFO: renamed from: a */
    JobInvocation m6557a(JobCallback jobCallback, Bundle bundle) {
        JobInvocation jobInvocationM6595a = f5712d.m6595a(bundle);
        if (jobInvocationM6595a == null) {
            Log.e("FJD.GooglePlayReceiver", "unable to decode job");
            m6548a(jobCallback, 2);
            return null;
        }
        synchronized (f5713h) {
            SimpleArrayMap<String, JobCallback> simpleArrayMap = f5713h.get(jobInvocationM6595a.mo6570i());
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap<>(1);
                f5713h.put(jobInvocationM6595a.mo6570i(), simpleArrayMap);
            }
            simpleArrayMap.put(jobInvocationM6595a.mo6566e(), jobCallback);
        }
        return jobInvocationM6595a;
    }

    @Override // com.firebase.jobdispatcher.ExecutionDelegator.JobFinishedCallback
    /* JADX INFO: renamed from: a */
    public void mo6520a(JobInvocation jobInvocation, int i) {
        synchronized (f5713h) {
            try {
                SimpleArrayMap<String, JobCallback> simpleArrayMap = f5713h.get(jobInvocation.mo6570i());
                if (simpleArrayMap == null) {
                    return;
                }
                JobCallback jobCallbackRemove = simpleArrayMap.remove(jobInvocation.mo6566e());
                if (jobCallbackRemove == null) {
                    if (f5713h.isEmpty()) {
                        stopSelf(this.f5719g);
                    }
                    return;
                }
                if (simpleArrayMap.isEmpty()) {
                    f5713h.remove(jobInvocation.mo6570i());
                }
                if (m6550a((JobParameters) jobInvocation, i)) {
                    m6549a(jobInvocation);
                } else {
                    if (Log.isLoggable("FJD.GooglePlayReceiver", 2)) {
                        Log.v("FJD.GooglePlayReceiver", "sending jobFinished for " + jobInvocation.mo6566e() + " = " + i);
                    }
                    m6548a(jobCallbackRemove, i);
                }
                if (f5713h.isEmpty()) {
                    stopSelf(this.f5719g);
                }
            } finally {
                if (f5713h.isEmpty()) {
                    stopSelf(this.f5719g);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6549a(JobInvocation jobInvocation) {
        m6553d().mo6510a(new Job.Builder(m6554e(), jobInvocation).m6584a(true).m6587j());
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6550a(JobParameters jobParameters, int i) {
        return jobParameters.mo6569h() && (jobParameters.mo6567f() instanceof JobTrigger.ContentUriTrigger) && i != 1;
    }

    /* JADX INFO: renamed from: b */
    static JobCoder m6551b() {
        return f5712d;
    }

    /* JADX INFO: renamed from: a */
    static void m6547a(Job job) {
        synchronized (f5713h) {
            SimpleArrayMap<String, JobCallback> simpleArrayMap = f5713h.get(job.mo6570i());
            if (simpleArrayMap != null) {
                if (simpleArrayMap.get(job.mo6566e()) != null) {
                    ExecutionDelegator.m6517a(new JobInvocation.Builder().m6612a(job.mo6566e()).m6616b(job.mo6570i()).m6609a(job.mo6567f()).m6615a(), false);
                }
            }
        }
    }
}
