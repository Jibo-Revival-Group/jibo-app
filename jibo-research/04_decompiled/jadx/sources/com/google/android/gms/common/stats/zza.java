package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzc;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zza {

    /* JADX INFO: renamed from: b */
    private static volatile zza f6684b;

    /* JADX INFO: renamed from: d */
    private final List<String> f6686d = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: e */
    private final List<String> f6687e = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: f */
    private final List<String> f6688f = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: g */
    private final List<String> f6689g = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: a */
    private static final Object f6683a = new Object();

    /* JADX INFO: renamed from: c */
    private static boolean f6685c = false;

    private zza() {
    }

    /* JADX INFO: renamed from: a */
    public static zza m7483a() {
        if (f6684b == null) {
            synchronized (f6683a) {
                if (f6684b == null) {
                    f6684b = new zza();
                }
            }
        }
        return f6684b;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7484a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m7485a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7485a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : zzc.m7495a(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
