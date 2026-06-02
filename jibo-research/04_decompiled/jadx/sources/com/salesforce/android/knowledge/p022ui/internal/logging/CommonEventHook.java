package com.salesforce.android.knowledge.p022ui.internal.logging;

import android.content.Context;
import com.salesforce.android.service.common.liveagentlogging.event.BackgroundedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

/* JADX INFO: loaded from: classes.dex */
class CommonEventHook implements BackgroundTracker.Listener, ConnectivityTracker.Listener, OrientationTracker.Listener {

    /* JADX INFO: renamed from: a */
    private Listener f13292a;

    /* JADX INFO: renamed from: b */
    private final String f13293b;

    /* JADX INFO: renamed from: c */
    private final BackgroundTracker f13294c;

    /* JADX INFO: renamed from: d */
    private OrientationTracker f13295d;

    /* JADX INFO: renamed from: e */
    private ConnectivityTracker f13296e;

    interface Listener {
        /* JADX INFO: renamed from: b */
        void mo13598b(BaseEvent baseEvent);
    }

    CommonEventHook(BackgroundTracker backgroundTracker, String str) {
        this.f13294c = backgroundTracker;
        this.f13293b = str;
    }

    /* JADX INFO: renamed from: a */
    static CommonEventHook m13592a(ActivityTracker activityTracker, String str) {
        return new CommonEventHook(BackgroundTracker.m14106a(activityTracker), str);
    }

    /* JADX INFO: renamed from: a */
    void m13595a(Context context) {
        this.f13295d = new OrientationTracker.Builder().m14159a(context).m14160a(this).m14161a();
        this.f13296e = new ConnectivityTracker.Builder().m14139a(context).m14140a(this).m14141a();
        this.f13294c.m14109a(this);
        this.f13294c.m14108a();
    }

    /* JADX INFO: renamed from: a */
    void m13594a() {
        this.f13294c.m14110b();
        if (this.f13295d != null) {
            this.f13295d.m14157a();
            this.f13295d = null;
        }
        if (this.f13296e != null) {
            this.f13296e.m14138c();
            this.f13296e = null;
        }
    }

    /* JADX INFO: renamed from: a */
    void m13596a(Listener listener) {
        this.f13292a = listener;
    }

    /* JADX INFO: renamed from: a */
    private void m13593a(BaseEvent baseEvent) {
        if (this.f13292a != null) {
            this.f13292a.mo13598b(baseEvent);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13597a(boolean z) {
        m13593a(new BackgroundedEvent("KB", this.f13293b, z));
    }

    @Override // com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13027a(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        m13593a(new ConnectivityEvent("KB", this.f13293b, connectionInfo.m14131b().name(), connectionInfo.m14132c().getRadioName()));
    }

    @Override // com.salesforce.android.service.common.utilities.internal.device.OrientationTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13028a(Orientation orientation) {
        m13593a(new OrientationEvent("KB", this.f13293b, orientation));
    }
}
