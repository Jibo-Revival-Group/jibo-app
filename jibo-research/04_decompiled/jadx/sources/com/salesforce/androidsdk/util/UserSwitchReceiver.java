package com.salesforce.androidsdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class UserSwitchReceiver extends BroadcastReceiver {
    /* JADX INFO: renamed from: a */
    protected abstract void mo14928a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.salesforce.USERSWITCHED")) {
            mo14928a();
        }
    }
}
