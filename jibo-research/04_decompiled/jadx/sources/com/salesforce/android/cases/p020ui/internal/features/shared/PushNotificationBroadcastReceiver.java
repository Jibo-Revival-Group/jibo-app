package com.salesforce.android.cases.p020ui.internal.features.shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.salesforce.android.cases.core.model.PushNotification;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushNotificationBroadcastReceiver extends BroadcastReceiver {
    /* JADX INFO: renamed from: a */
    public abstract void mo12792a(PushNotification pushNotification);

    /* JADX INFO: renamed from: a */
    public final void m13011a(Context context) {
        if (context != null) {
            LocalBroadcastManager.m1878a(context).m1882a(this, new IntentFilter("Body"));
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m13012b(Context context) {
        if (context != null) {
            LocalBroadcastManager.m1878a(context).m1881a(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context != null) {
            mo12792a(new PushNotification(intent.getExtras()));
        }
    }
}
