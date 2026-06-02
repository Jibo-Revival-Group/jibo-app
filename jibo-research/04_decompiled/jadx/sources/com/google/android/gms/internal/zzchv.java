package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
class zzchv extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static String f7250a = zzchv.class.getName();

    /* JADX INFO: renamed from: b */
    private final zzcim f7251b;

    /* JADX INFO: renamed from: c */
    private boolean f7252c;

    /* JADX INFO: renamed from: d */
    private boolean f7253d;

    zzchv(zzcim zzcimVar) {
        zzbq.m7373a(zzcimVar);
        this.f7251b = zzcimVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m8118a() {
        this.f7251b.m8211a();
        this.f7251b.m8235h().mo7855c();
        if (this.f7252c) {
            return;
        }
        this.f7251b.m8247t().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f7253d = this.f7251b.m8246s().m8115y();
        this.f7251b.m8233f().m8101E().m8109a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f7253d));
        this.f7252c = true;
    }

    /* JADX INFO: renamed from: b */
    public final void m8119b() {
        this.f7251b.m8211a();
        this.f7251b.m8235h().mo7855c();
        this.f7251b.m8235h().mo7855c();
        if (this.f7252c) {
            this.f7251b.m8233f().m8101E().m8108a("Unregistering connectivity change receiver");
            this.f7252c = false;
            this.f7253d = false;
            try {
                this.f7251b.m8247t().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f7251b.m8233f().m8106y().m8109a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f7251b.m8211a();
        String action = intent.getAction();
        this.f7251b.m8233f().m8101E().m8109a("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f7251b.m8233f().m8097A().m8109a("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM8115y = this.f7251b.m8246s().m8115y();
        if (this.f7253d != zM8115y) {
            this.f7253d = zM8115y;
            this.f7251b.m8235h().m8173a(new zzchw(this, zM8115y));
        }
    }
}
