package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayDriver implements Driver {

    /* JADX INFO: renamed from: a */
    private final JobValidator f5702a;

    /* JADX INFO: renamed from: b */
    private final Context f5703b;

    /* JADX INFO: renamed from: c */
    private final PendingIntent f5704c;

    /* JADX INFO: renamed from: e */
    private final boolean f5706e = true;

    /* JADX INFO: renamed from: d */
    private final GooglePlayJobWriter f5705d = new GooglePlayJobWriter();

    public GooglePlayDriver(Context context) {
        this.f5703b = context;
        this.f5704c = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f5702a = new DefaultJobValidator(context);
    }

    @Override // com.firebase.jobdispatcher.Driver
    /* JADX INFO: renamed from: b */
    public boolean mo6513b() {
        return true;
    }

    @Override // com.firebase.jobdispatcher.Driver
    /* JADX INFO: renamed from: a */
    public int mo6510a(Job job) {
        GooglePlayReceiver.m6547a(job);
        this.f5703b.sendBroadcast(m6530a((JobParameters) job));
        return 0;
    }

    @Override // com.firebase.jobdispatcher.Driver
    /* JADX INFO: renamed from: a */
    public int mo6511a(String str) {
        this.f5703b.sendBroadcast(m6532b(str));
        return 0;
    }

    /* JADX INFO: renamed from: b */
    protected Intent m6532b(String str) {
        Intent intentM6531c = m6531c("CANCEL_TASK");
        intentM6531c.putExtra("tag", str);
        intentM6531c.putExtra("component", new ComponentName(this.f5703b, m6533c()));
        return intentM6531c;
    }

    /* JADX INFO: renamed from: c */
    protected Class<GooglePlayReceiver> m6533c() {
        return GooglePlayReceiver.class;
    }

    @Override // com.firebase.jobdispatcher.Driver
    /* JADX INFO: renamed from: a */
    public JobValidator mo6512a() {
        return this.f5702a;
    }

    /* JADX INFO: renamed from: a */
    private Intent m6530a(JobParameters jobParameters) {
        Intent intentM6531c = m6531c("SCHEDULE_TASK");
        intentM6531c.putExtras(this.f5705d.m6543a(jobParameters, intentM6531c.getExtras()));
        return intentM6531c;
    }

    /* JADX INFO: renamed from: c */
    private Intent m6531c(String str) {
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", str);
        intent.putExtra("app", this.f5704c);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, 8);
        intent.putExtra("source_version", 1);
        return intent;
    }
}
