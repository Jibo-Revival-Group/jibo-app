package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.google.api.client.googleapis.notifications.ResourceStates;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseInstanceIdService extends zzb {
    @Override // com.google.firebase.iid.zzb
    /* JADX INFO: renamed from: a */
    protected final Intent mo9115a(Intent intent) {
        return zzx.m9172a().f8697a.poll();
    }

    /* JADX INFO: renamed from: a */
    public void mo9116a() {
    }

    @Override // com.google.firebase.iid.zzb
    /* JADX INFO: renamed from: b */
    public final void mo9117b(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            mo9116a();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(intent.getExtras());
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(strValueOf).length()).append("Received command: ").append(stringExtra).append(" - ").append(strValueOf).toString());
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.m9094a().m9111i();
            } else if (ResourceStates.SYNC.equals(stringExtra)) {
                FirebaseInstanceId.m9094a().m9112j();
            }
        }
    }
}
