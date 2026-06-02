package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.iid.zzi;
import com.google.firebase.iid.zzx;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessagingService extends com.google.firebase.iid.zzb {

    /* JADX INFO: renamed from: b */
    private static final Queue<String> f8708b = new ArrayDeque(10);

    /* JADX INFO: renamed from: a */
    static void m9193a(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static boolean m9194b(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.e"));
    }

    @Override // com.google.firebase.iid.zzb
    /* JADX INFO: renamed from: a */
    protected final Intent mo9115a(Intent intent) {
        return zzx.m9172a().m9174b();
    }

    /* JADX INFO: renamed from: a */
    public void m9195a() {
    }

    /* JADX INFO: renamed from: a */
    public void mo9196a(RemoteMessage remoteMessage) {
    }

    /* JADX INFO: renamed from: a */
    public void m9197a(String str) {
    }

    /* JADX INFO: renamed from: a */
    public void m9198a(String str, Exception exc) {
    }

    @Override // com.google.firebase.iid.zzb
    /* JADX INFO: renamed from: b */
    public final void mo9117b(Intent intent) {
        boolean z;
        String stringExtra;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "com.google.android.c2dm.intent.RECEIVE":
                String stringExtra2 = intent.getStringExtra("google.message_id");
                if (TextUtils.isEmpty(stringExtra2)) {
                    z = false;
                } else if (f8708b.contains(stringExtra2)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        String strValueOf = String.valueOf(stringExtra2);
                        Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Received duplicate message: ".concat(strValueOf) : new String("Received duplicate message: "));
                    }
                    z = true;
                } else {
                    if (f8708b.size() >= 10) {
                        f8708b.remove();
                    }
                    f8708b.add(stringExtra2);
                    z = false;
                }
                if (!z) {
                    stringExtra = intent.getStringExtra("message_type");
                    if (stringExtra == null) {
                        stringExtra = "gcm";
                    }
                    switch (stringExtra) {
                        case "gcm":
                            if (m9194b(intent.getExtras())) {
                                zzd.m9235a(this, intent);
                            }
                            Bundle extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (zza.m9207a(extras)) {
                                if (!zza.m9202a(this).m9216c(extras)) {
                                    if (m9194b(extras)) {
                                        zzd.m9239d(this, intent);
                                    }
                                    mo9196a(new RemoteMessage(extras));
                                }
                                break;
                            } else {
                                mo9196a(new RemoteMessage(extras));
                                break;
                            }
                            break;
                        case "deleted_messages":
                            m9195a();
                            break;
                        case "send_event":
                            m9197a(intent.getStringExtra("google.message_id"));
                            break;
                        case "send_error":
                            String stringExtra3 = intent.getStringExtra("google.message_id");
                            if (stringExtra3 == null) {
                                stringExtra3 = intent.getStringExtra("message_id");
                            }
                            m9198a(stringExtra3, new SendException(intent.getStringExtra("error")));
                            break;
                        default:
                            String strValueOf2 = String.valueOf(stringExtra);
                            Log.w("FirebaseMessaging", strValueOf2.length() != 0 ? "Received message with unknown type: ".concat(strValueOf2) : new String("Received message with unknown type: "));
                            break;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra2)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("google.message_id", stringExtra2);
                    zzi.m9136a(this).m9138a(2, bundle);
                    break;
                }
                break;
            case "com.google.firebase.messaging.NOTIFICATION_DISMISS":
                if (m9194b(intent.getExtras())) {
                    zzd.m9238c(this, intent);
                    break;
                }
                break;
            default:
                String strValueOf3 = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", strValueOf3.length() != 0 ? "Unknown intent action: ".concat(strValueOf3) : new String("Unknown intent action: "));
                break;
        }
    }

    @Override // com.google.firebase.iid.zzb
    /* JADX INFO: renamed from: c */
    public final boolean mo9127c(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (m9194b(intent.getExtras())) {
            zzd.m9237b(this, intent);
        }
        return true;
    }
}
