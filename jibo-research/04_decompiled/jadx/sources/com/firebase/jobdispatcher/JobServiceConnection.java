package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.firebase.jobdispatcher.IRemoteJobService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class JobServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: b */
    private final IJobCallback f5775b;

    /* JADX INFO: renamed from: c */
    private final Context f5776c;

    /* JADX INFO: renamed from: e */
    private IRemoteJobService f5778e;

    /* JADX INFO: renamed from: a */
    private final Map<JobInvocation, Boolean> f5774a = new HashMap();

    /* JADX INFO: renamed from: d */
    private boolean f5777d = false;

    JobServiceConnection(IJobCallback iJobCallback, Context context) {
        this.f5775b = iJobCallback;
        this.f5776c = context;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (m6629a()) {
            Log.w("FJD.ExternalReceiver", "Connection have been used already.");
        } else {
            this.f5778e = IRemoteJobService.Stub.m6561a(iBinder);
            HashSet hashSet = new HashSet();
            for (Map.Entry<JobInvocation, Boolean> entry : this.f5774a.entrySet()) {
                if (Boolean.FALSE.equals(entry.getValue())) {
                    try {
                        this.f5778e.mo6559a(m6625a((JobParameters) entry.getKey()), this.f5775b);
                        hashSet.add(entry.getKey());
                    } catch (RemoteException e) {
                        Log.e("FJD.ExternalReceiver", "Failed to start job " + entry.getKey(), e);
                        m6632c();
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.f5774a.put((JobInvocation) it.next(), true);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        m6632c();
    }

    /* JADX INFO: renamed from: a */
    synchronized boolean m6629a() {
        return this.f5777d;
    }

    /* JADX INFO: renamed from: b */
    synchronized boolean m6630b() {
        return this.f5778e != null;
    }

    /* JADX INFO: renamed from: a */
    synchronized void m6628a(JobInvocation jobInvocation, boolean z) {
        if (!m6629a()) {
            if (Boolean.TRUE.equals(this.f5774a.remove(jobInvocation)) && m6630b()) {
                m6626a(z, jobInvocation);
            }
            if (!z && this.f5774a.isEmpty()) {
                m6632c();
            }
        } else {
            Log.w("FJD.ExternalReceiver", "Can't send stop request because service was unbound.");
        }
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m6626a(boolean z, JobInvocation jobInvocation) {
        try {
            this.f5778e.mo6560a(m6625a((JobParameters) jobInvocation), z);
        } catch (RemoteException e) {
            Log.e("FJD.ExternalReceiver", "Failed to stop a job", e);
            m6632c();
        }
    }

    /* JADX INFO: renamed from: c */
    synchronized void m6632c() {
        if (!m6629a()) {
            this.f5778e = null;
            this.f5777d = true;
            try {
                this.f5776c.unbindService(this);
            } catch (IllegalArgumentException e) {
                Log.w("FJD.ExternalReceiver", "Error unbinding service: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized void m6627a(JobInvocation jobInvocation) {
        this.f5774a.remove(jobInvocation);
        if (this.f5774a.isEmpty()) {
            m6632c();
        }
    }

    /* JADX INFO: renamed from: b */
    synchronized boolean m6631b(JobInvocation jobInvocation) {
        boolean z;
        boolean zM6630b = m6630b();
        if (zM6630b) {
            if (Boolean.TRUE.equals(this.f5774a.get(jobInvocation))) {
                Log.w("FJD.ExternalReceiver", "Received an execution request for already running job " + jobInvocation);
                m6626a(false, jobInvocation);
            }
            try {
                this.f5778e.mo6559a(m6625a((JobParameters) jobInvocation), this.f5775b);
                this.f5774a.put(jobInvocation, Boolean.valueOf(zM6630b));
                z = zM6630b;
            } catch (RemoteException e) {
                Log.e("FJD.ExternalReceiver", "Failed to start the job " + jobInvocation, e);
                m6632c();
                z = false;
            }
        } else {
            this.f5774a.put(jobInvocation, Boolean.valueOf(zM6630b));
            z = zM6630b;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static Bundle m6625a(JobParameters jobParameters) {
        return GooglePlayReceiver.m6551b().m6594a(jobParameters, new Bundle());
    }

    /* JADX INFO: renamed from: c */
    synchronized boolean m6633c(JobInvocation jobInvocation) {
        return this.f5774a.containsKey(jobInvocation);
    }
}
