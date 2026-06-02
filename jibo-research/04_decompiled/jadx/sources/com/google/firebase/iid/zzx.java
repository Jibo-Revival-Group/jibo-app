package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class zzx {

    /* JADX INFO: renamed from: b */
    private static zzx f8696b;

    /* JADX INFO: renamed from: c */
    private final SimpleArrayMap<String, String> f8698c = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: d */
    private Boolean f8699d = null;

    /* JADX INFO: renamed from: a */
    final Queue<Intent> f8697a = new ArrayDeque();

    /* JADX INFO: renamed from: e */
    private Queue<Intent> f8700e = new ArrayDeque();

    private zzx() {
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int m9170a(android.content.Context r7, android.content.Intent r8) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzx.m9170a(android.content.Context, android.content.Intent):int");
    }

    /* JADX INFO: renamed from: a */
    public static PendingIntent m9171a(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, (Class<?>) FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, 1073741824);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized zzx m9172a() {
        if (f8696b == null) {
            f8696b = new zzx();
        }
        return f8696b;
    }

    /* JADX INFO: renamed from: a */
    public final int m9173a(Context context, String str, Intent intent) {
        switch (str) {
            case "com.google.firebase.INSTANCE_ID_EVENT":
                this.f8697a.offer(intent);
                break;
            case "com.google.firebase.MESSAGING_EVENT":
                this.f8700e.offer(intent);
                break;
            default:
                String strValueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", strValueOf.length() != 0 ? "Unknown service action: ".concat(strValueOf) : new String("Unknown service action: "));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return m9170a(context, intent2);
    }

    /* JADX INFO: renamed from: b */
    public final Intent m9174b() {
        return this.f8700e.poll();
    }
}
