package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.iid.zzb;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GcmListenerService extends zzb {
    /* JADX INFO: renamed from: a */
    static void m7580a(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7581a() {
    }

    /* JADX INFO: renamed from: a */
    public void m7582a(String str) {
    }

    /* JADX INFO: renamed from: a */
    public void mo7583a(String str, Bundle bundle) {
    }

    /* JADX INFO: renamed from: a */
    public void m7584a(String str, String str2) {
    }

    @Override // com.google.android.gms.iid.zzb
    public void handleIntent(Intent intent) {
        String stringExtra;
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.w("GcmListenerService", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
        }
        stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "gcm":
                Bundle extras = intent.getExtras();
                extras.remove("message_type");
                extras.remove("android.support.content.wakelockid");
                if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza.m7593a(extras, "gcm.n.e")) || zza.m7593a(extras, "gcm.n.icon") != null) {
                    if (!zza.m7596b(this)) {
                        zza.m7592a(this).m7598b(extras);
                    } else {
                        zza.m7594a(extras);
                    }
                    break;
                }
                String string = extras.getString("from");
                extras.remove("from");
                m7580a(extras);
                mo7583a(string, extras);
                break;
            case "deleted_messages":
                m7581a();
                break;
            case "send_event":
                m7582a(intent.getStringExtra("google.message_id"));
                break;
            case "send_error":
                String stringExtra2 = intent.getStringExtra("google.message_id");
                if (stringExtra2 == null) {
                    stringExtra2 = intent.getStringExtra("message_id");
                }
                m7584a(stringExtra2, intent.getStringExtra("error"));
                break;
            default:
                String strValueOf2 = String.valueOf(stringExtra);
                Log.w("GcmListenerService", strValueOf2.length() != 0 ? "Received message with unknown type: ".concat(strValueOf2) : new String("Received message with unknown type: "));
                break;
        }
    }
}
