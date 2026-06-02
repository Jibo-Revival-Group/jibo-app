package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* JADX INFO: loaded from: classes.dex */
class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* JADX INFO: renamed from: a */
    private final Context f4895a;

    /* JADX INFO: renamed from: b */
    private final ConnectivityMonitor.ConnectivityListener f4896b;

    /* JADX INFO: renamed from: c */
    private boolean f4897c;

    /* JADX INFO: renamed from: d */
    private boolean f4898d;

    /* JADX INFO: renamed from: e */
    private final BroadcastReceiver f4899e = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.f4897c;
            DefaultConnectivityMonitor.this.f4897c = DefaultConnectivityMonitor.this.m5457a(context);
            if (z != DefaultConnectivityMonitor.this.f4897c) {
                DefaultConnectivityMonitor.this.f4896b.mo5293a(DefaultConnectivityMonitor.this.f4897c);
            }
        }
    };

    public DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f4895a = context.getApplicationContext();
        this.f4896b = connectivityListener;
    }

    /* JADX INFO: renamed from: a */
    private void m5456a() {
        if (!this.f4898d) {
            this.f4897c = m5457a(this.f4895a);
            this.f4895a.registerReceiver(this.f4899e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4898d = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5462b() {
        if (this.f4898d) {
            this.f4895a.unregisterReceiver(this.f4899e);
            this.f4898d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m5457a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        m5456a();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        m5462b();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }
}
