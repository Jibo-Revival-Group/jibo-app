package com.salesforce.androidsdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogoutCompleteReceiver extends BroadcastReceiver {
    /* JADX INFO: renamed from: a */
    protected abstract void mo14927a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.salesforce.LOGOUT_COMPLETE")) {
            mo14927a();
        }
    }
}
