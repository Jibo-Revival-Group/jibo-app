package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentLoggingService extends Service {

    /* JADX INFO: renamed from: a */
    private LiveAgentLoggingServiceDelegate f13641a = new LiveAgentLoggingServiceDelegate(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f13641a.m13933a(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f13641a.m13934a();
    }
}
