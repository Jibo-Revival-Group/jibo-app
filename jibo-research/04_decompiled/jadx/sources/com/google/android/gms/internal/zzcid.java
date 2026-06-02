package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcid {

    /* JADX INFO: renamed from: a */
    private final zzcif f7298a;

    public zzcid(zzcif zzcifVar) {
        zzbq.m7373a(zzcifVar);
        this.f7298a = zzcifVar;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8144a(Context context) {
        ActivityInfo receiverInfo;
        zzbq.m7373a(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 2)) == null) {
                return false;
            }
            return receiverInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8145a(Context context, Intent intent) {
        zzcim zzcimVarM8191a = zzcim.m8191a(context);
        zzchm zzchmVarM8233f = zzcimVarM8191a.m8233f();
        if (intent == null) {
            zzchmVarM8233f.m8097A().m8108a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzchmVarM8233f.m8101E().m8109a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzchmVarM8233f.m8101E().m8108a("Starting wakeful intent.");
            this.f7298a.mo8147a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            BroadcastReceiver.PendingResult pendingResultMo8146a = this.f7298a.mo8146a();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzchmVarM8233f.m8101E().m8108a("Install referrer extras are null");
                if (pendingResultMo8146a != null) {
                    pendingResultMo8146a.finish();
                    return;
                }
                return;
            }
            zzchmVarM8233f.m8099C().m8109a("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String strValueOf = String.valueOf(stringExtra);
                stringExtra = strValueOf.length() != 0 ? "?".concat(strValueOf) : new String("?");
            }
            Bundle bundleM8416a = zzcimVarM8191a.m8242o().m8416a(Uri.parse(stringExtra));
            if (bundleM8416a == null) {
                zzchmVarM8233f.m8101E().m8108a("No campaign defined in install referrer broadcast");
                if (pendingResultMo8146a != null) {
                    pendingResultMo8146a.finish();
                    return;
                }
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0L);
            if (longExtra == 0) {
                zzchmVarM8233f.m8097A().m8108a("Install referrer is missing timestamp");
            }
            zzcimVarM8191a.m8235h().m8173a(new zzcie(this, zzcimVarM8191a, longExtra, bundleM8416a, context, zzchmVarM8233f, pendingResultMo8146a));
        }
    }
}
