package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzewh {

    /* JADX INFO: renamed from: a */
    private final int f7871a;

    /* JADX INFO: renamed from: b */
    private final int f7872b;

    /* JADX INFO: renamed from: c */
    private final boolean f7873c;

    /* JADX INFO: renamed from: d */
    private boolean f7874d;

    /* JADX INFO: renamed from: e */
    private zzewj f7875e;

    /* JADX INFO: renamed from: f */
    private zzewj f7876f;

    private zzewh(long j, long j2, zzewk zzewkVar, int i, List<String> list) {
        this.f7874d = false;
        this.f7875e = null;
        this.f7876f = null;
        this.f7871a = i;
        Map<String, Long> mapM8593a = m8593a(list);
        if (mapM8593a.containsKey("sampling")) {
            this.f7872b = mapM8593a.get("sampling").intValue();
        } else {
            this.f7872b = 100;
        }
        if (this.f7872b != 100) {
            Log.d("FirebasePerformance", new StringBuilder(59).append("RateLimiter sampling rate:").append(this.f7872b).append(" bucketId: ").append(this.f7871a).toString());
        }
        this.f7873c = this.f7871a <= this.f7872b;
        if (!this.f7873c) {
            Log.d("FirebasePerformance", "logging is disabled because device sampling");
        } else {
            this.f7875e = new zzewj(100L, 500L, zzewkVar, mapM8593a, zzewi.TRACE, this.f7874d);
            this.f7876f = new zzewj(100L, 500L, zzewkVar, mapM8593a, zzewi.NETWORK, this.f7874d);
        }
    }

    public zzewh(Context context, String str, long j, long j2) {
        this(100L, 500L, new zzewk(), m8591a(Settings.Secure.getString(context.getContentResolver(), "android_id")), m8592a(context, str));
        this.f7874d = zzewq.m8607a(context);
    }

    /* JADX INFO: renamed from: a */
    private static int m8590a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m8591a(String str) {
        int iM8604a;
        try {
            iM8604a = zzewq.m8604a(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            iM8604a = zzewq.m8604a(str.getBytes());
        }
        return (((iM8604a % 100) + 100) % 100) + 1;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m8592a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {new StringBuilder(String.valueOf(str).length() + 12).append(str).append(":").append(m8590a(context)).toString(), str, "1.0.0.178131943"};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            String strValueOf = String.valueOf("_fireperf1:");
            String strValueOf2 = String.valueOf(str2);
            String strM8594b = m8594b(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
            String strM8515a = zzdmf.m8515a(context.getContentResolver(), new StringBuilder(String.valueOf(strM8594b).length() + 16).append("fireperf:").append(strM8594b).append("_limits").toString(), (String) null);
            if (strM8515a != null) {
                arrayList.add(strM8515a);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, Long> m8593a(List<String> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            for (String str : it.next().split(",")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length >= 2) {
                    String strTrim = strArrSplit[0].trim();
                    if (!strTrim.isEmpty() && !map.containsKey(strTrim)) {
                        try {
                            long j = Long.parseLong(strArrSplit[1].trim());
                            if (j >= 0) {
                                map.put(strTrim, Long.valueOf(j));
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: b */
    private static String m8594b(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8595a(boolean z) {
        if (this.f7873c) {
            this.f7875e.m8597a(z);
            this.f7876f.m8597a(z);
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m8596a(zzewx zzewxVar) {
        if (!this.f7873c) {
            return false;
        }
        if (!(zzewxVar.f7923b == null || zzewxVar.f7923b.f7926a == null || !(zzewxVar.f7923b.f7926a.equals(zzewm.FOREGROUND_TRACE_NAME.toString()) || zzewxVar.f7923b.f7926a.equals(zzewm.BACKGROUND_TRACE_NAME.toString())) || zzewxVar.f7923b.f7929d == null || zzewxVar.f7923b.f7929d.length <= 0)) {
            return true;
        }
        if (zzewxVar.f7924c != null) {
            return this.f7876f.m8598a(zzewxVar);
        }
        if (zzewxVar.f7923b != null) {
            return this.f7875e.m8598a(zzewxVar);
        }
        return false;
    }
}
