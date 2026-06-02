package com.salesforce.androidsdk.util.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastListenerQueue extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private BlockingQueue<Intent> f14464a = new ArrayBlockingQueue(10);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f14464a.offer(intent);
    }
}
