package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class DevicePowerStateListener {

    /* JADX INFO: renamed from: a */
    private static final IntentFilter f5252a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* JADX INFO: renamed from: b */
    private static final IntentFilter f5253b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* JADX INFO: renamed from: c */
    private static final IntentFilter f5254c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* JADX INFO: renamed from: d */
    private final AtomicBoolean f5255d;

    /* JADX INFO: renamed from: e */
    private final Context f5256e;

    /* JADX INFO: renamed from: f */
    private final BroadcastReceiver f5257f;

    /* JADX INFO: renamed from: g */
    private final BroadcastReceiver f5258g;

    /* JADX INFO: renamed from: h */
    private boolean f5259h;

    public DevicePowerStateListener(Context context) {
        this.f5256e = context;
        Intent intentRegisterReceiver = context.registerReceiver(null, f5252a);
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1) : -1;
        this.f5259h = intExtra == 2 || intExtra == 5;
        this.f5258g = new BroadcastReceiver() { // from class: com.crashlytics.android.core.DevicePowerStateListener.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                DevicePowerStateListener.this.f5259h = true;
            }
        };
        this.f5257f = new BroadcastReceiver() { // from class: com.crashlytics.android.core.DevicePowerStateListener.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                DevicePowerStateListener.this.f5259h = false;
            }
        };
        context.registerReceiver(this.f5258g, f5253b);
        context.registerReceiver(this.f5257f, f5254c);
        this.f5255d = new AtomicBoolean(true);
    }

    /* JADX INFO: renamed from: a */
    public boolean m5901a() {
        return this.f5259h;
    }

    /* JADX INFO: renamed from: b */
    public void m5902b() {
        if (this.f5255d.getAndSet(false)) {
            this.f5256e.unregisterReceiver(this.f5258g);
            this.f5256e.unregisterReceiver(this.f5257f);
        }
    }
}
