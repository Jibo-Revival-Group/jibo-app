package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf {

    /* JADX INFO: renamed from: a */
    private static Object f6568a = new Object();

    /* JADX INFO: renamed from: b */
    private static boolean f6569b;

    /* JADX INFO: renamed from: c */
    private static String f6570c;

    /* JADX INFO: renamed from: d */
    private static int f6571d;

    /* JADX INFO: renamed from: a */
    public static String m7367a(Context context) {
        m7369c(context);
        return f6570c;
    }

    /* JADX INFO: renamed from: b */
    public static int m7368b(Context context) {
        m7369c(context);
        return f6571d;
    }

    /* JADX INFO: renamed from: c */
    private static void m7369c(Context context) {
        synchronized (f6568a) {
            if (f6569b) {
                return;
            }
            f6569b = true;
            try {
                Bundle bundle = zzbhf.m7816a(context).m7810a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f6570c = bundle.getString("com.google.app.id");
                f6571d = bundle.getInt("com.google.android.gms.version");
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
