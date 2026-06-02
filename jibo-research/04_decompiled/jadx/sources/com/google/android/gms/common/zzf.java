package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.internal.zzbhf;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class zzf {

    /* JADX INFO: renamed from: b */
    public static final int f6704b = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* JADX INFO: renamed from: a */
    private static final zzf f6703a = new zzf();

    zzf() {
    }

    /* JADX INFO: renamed from: a */
    public static Intent m7528a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !com.google.android.gms.common.util.zzi.m7503b(context)) ? zzak.m7353a("com.google.android.gms", m7529a(context, str)) : zzak.m7351a();
            case 3:
                return zzak.m7352a("com.google.android.gms");
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m7529a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f6704b);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(zzbhf.m7816a(context).m7814b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public static zzf m7530b() {
        return f6703a;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m7531b(Context context, int i) {
        return zzp.zze(context, i);
    }

    /* JADX INFO: renamed from: c */
    public static void m7532c(Context context) {
        zzp.zzce(context);
    }

    /* JADX INFO: renamed from: d */
    public static int m7533d(Context context) {
        return zzp.zzcf(context);
    }

    /* JADX INFO: renamed from: a */
    public int mo6834a(Context context) {
        int iIsGooglePlayServicesAvailable = zzp.isGooglePlayServicesAvailable(context);
        if (zzp.zze(context, iIsGooglePlayServicesAvailable)) {
            return 18;
        }
        return iIsGooglePlayServicesAvailable;
    }

    /* JADX INFO: renamed from: a */
    public PendingIntent mo6837a(Context context, int i, int i2) {
        return m7534a(context, i, i2, null);
    }

    /* JADX INFO: renamed from: a */
    public final PendingIntent m7534a(Context context, int i, int i2, String str) {
        Intent intentM7528a = m7528a(context, i, str);
        if (intentM7528a == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentM7528a, SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo6840a(int i) {
        return zzp.isUserRecoverableError(i);
    }

    /* JADX INFO: renamed from: b */
    public String mo6843b(int i) {
        return zzp.getErrorString(i);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public final Intent m7535c(int i) {
        return m7528a((Context) null, i, (String) null);
    }
}
