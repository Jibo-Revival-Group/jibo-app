package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentLoggingServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private final IntentFactory f13644a;

    /* JADX INFO: renamed from: b */
    private Context f13645b;

    /* JADX INFO: renamed from: c */
    private OnDisconnectedListener f13646c;

    /* JADX INFO: renamed from: d */
    private BasicAsync<LiveAgentLoggingSession> f13647d;

    /* JADX INFO: renamed from: e */
    private boolean f13648e = false;

    public interface OnDisconnectedListener {
        /* JADX INFO: renamed from: a */
        void m13931a();
    }

    protected LiveAgentLoggingServiceConnection(Builder builder) {
        this.f13644a = builder.f13649a;
    }

    /* JADX INFO: renamed from: a */
    public Intent m13927a(Context context, LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
        Intent intentM14112a = this.f13644a.m14112a(context, LiveAgentLoggingService.class);
        intentM14112a.putExtra("com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration", liveAgentLoggingConfiguration);
        return intentM14112a;
    }

    /* JADX INFO: renamed from: a */
    public Async<LiveAgentLoggingSession> m13928a(Context context, Intent intent) {
        this.f13645b = context.getApplicationContext();
        this.f13648e = this.f13645b.bindService(intent, this, 1);
        if (!this.f13648e) {
            return BasicAsync.m14085c((Throwable) new Exception("Unable to bind to LiveAgentLoggingService."));
        }
        this.f13647d = BasicAsync.m14086g();
        return this.f13647d;
    }

    /* JADX INFO: renamed from: a */
    public void m13929a() {
        if (this.f13648e && this.f13645b != null) {
            this.f13648e = false;
            this.f13645b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if ((iBinder instanceof LiveAgentLoggingServiceBinder) && this.f13647d != null) {
            this.f13647d.mo12614b(((LiveAgentLoggingServiceBinder) iBinder).m13924a());
            this.f13647d.mo12613b();
            this.f13647d = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f13646c != null) {
            this.f13646c.m13931a();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected IntentFactory f13649a;

        /* JADX INFO: renamed from: a */
        public LiveAgentLoggingServiceConnection m13930a() {
            if (this.f13649a == null) {
                this.f13649a = new IntentFactory();
            }
            return new LiveAgentLoggingServiceConnection(this);
        }
    }
}
