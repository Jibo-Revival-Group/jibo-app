package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.api.client.googleapis.notifications.ResourceStates;

/* JADX INFO: loaded from: classes.dex */
public class InstanceIDListenerService extends zzb {
    /* JADX INFO: renamed from: a */
    static void m7612a(Context context, zzo zzoVar) {
        zzoVar.m7650b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    public void mo7613a() {
    }

    @Override // com.google.android.gms.iid.zzb
    public void handleIntent(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            InstanceID instanceIDM7600a = InstanceID.m7600a(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", new StringBuilder(String.valueOf(stringExtra).length() + 34 + String.valueOf(stringExtra2).length()).append("Service command. subtype:").append(stringExtra).append(" command:").append(stringExtra2).toString());
            }
            if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
                InstanceID.m7605c().m7653c(stringExtra);
                mo7613a();
                return;
            }
            if ("RST".equals(stringExtra2)) {
                instanceIDM7600a.m7610b();
                mo7613a();
            } else {
                if ("RST_FULL".equals(stringExtra2)) {
                    if (InstanceID.m7605c().m7649a()) {
                        return;
                    }
                    InstanceID.m7605c().m7650b();
                    mo7613a();
                    return;
                }
                if (ResourceStates.SYNC.equals(stringExtra2)) {
                    InstanceID.m7605c().m7653c(stringExtra);
                    mo7613a();
                }
            }
        }
    }
}
