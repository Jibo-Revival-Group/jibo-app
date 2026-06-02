package com.salesforce.android.service.common.utilities.internal.android;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundTracker implements ActivityTracker.OnResumeListener, ActivityTracker.OnStopListener {

    /* JADX INFO: renamed from: a */
    private final ActivityTracker f13833a;

    /* JADX INFO: renamed from: b */
    private final Handler f13834b;

    /* JADX INFO: renamed from: c */
    private final Set<Listener> f13835c = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: d */
    private boolean f13836d = false;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13597a(boolean z);
    }

    BackgroundTracker(ActivityTracker activityTracker, Handler handler) {
        this.f13833a = activityTracker;
        this.f13834b = handler;
    }

    /* JADX INFO: renamed from: a */
    public static BackgroundTracker m14106a(ActivityTracker activityTracker) {
        return new BackgroundTracker(activityTracker, new Handler(Looper.getMainLooper()));
    }

    /* JADX INFO: renamed from: a */
    public void m14108a() {
        this.f13836d = this.f13833a.m14065b() == null;
        this.f13833a.m14059a((ActivityTracker.OnResumeListener) this).m14061a((ActivityTracker.OnStopListener) this);
    }

    /* JADX INFO: renamed from: b */
    public void m14110b() {
        this.f13833a.m14069b((ActivityTracker.OnResumeListener) this).m14071b((ActivityTracker.OnStopListener) this);
    }

    /* JADX INFO: renamed from: a */
    public void m14109a(Listener listener) {
        this.f13835c.add(listener);
    }

    /* JADX INFO: renamed from: a */
    private void m14107a(boolean z) {
        if (this.f13836d != z) {
            this.f13836d = z;
            Iterator<Listener> it = this.f13835c.iterator();
            while (it.hasNext()) {
                it.next().mo13597a(z);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m14111c() {
        if (this.f13833a.m14065b() == null) {
            m14107a(true);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnResumeListener
    /* JADX INFO: renamed from: b */
    public void mo13982b(Activity activity) {
        m14107a(false);
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnStopListener
    /* JADX INFO: renamed from: a */
    public void mo12741a(Activity activity) {
        this.f13834b.post(new Runnable() { // from class: com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker.1
            @Override // java.lang.Runnable
            public void run() {
                BackgroundTracker.this.m14111c();
            }
        });
    }
}
