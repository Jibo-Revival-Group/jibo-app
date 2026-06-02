package com.salesforce.androidsdk.analytics.manager;

import android.content.Context;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.store.EventStoreManager;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsManager {

    /* JADX INFO: renamed from: a */
    private EventStoreManager f14026a;

    /* JADX INFO: renamed from: b */
    private DeviceAppAttributes f14027b;

    /* JADX INFO: renamed from: c */
    private int f14028c = 0;

    public AnalyticsManager(String str, Context context, String str2, DeviceAppAttributes deviceAppAttributes) {
        this.f14026a = new EventStoreManager(str, context, str2);
        this.f14027b = deviceAppAttributes;
    }

    /* JADX INFO: renamed from: a */
    public void m14328a() {
        this.f14026a.m14387b();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m14329a(int i) {
        this.f14028c = i;
    }

    /* JADX INFO: renamed from: b */
    public synchronized int m14331b() {
        return this.f14028c;
    }

    /* JADX INFO: renamed from: c */
    public DeviceAppAttributes m14332c() {
        return this.f14027b;
    }

    /* JADX INFO: renamed from: d */
    public EventStoreManager m14333d() {
        return this.f14026a;
    }

    /* JADX INFO: renamed from: a */
    public void m14330a(String str, String str2) {
        this.f14026a.m14383a(str, str2);
    }
}
