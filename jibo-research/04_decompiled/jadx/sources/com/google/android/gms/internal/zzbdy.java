package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbdy {

    /* JADX INFO: renamed from: g */
    private final String f6863g;

    /* JADX INFO: renamed from: h */
    private final int f6864h;

    /* JADX INFO: renamed from: i */
    private String f6865i;

    /* JADX INFO: renamed from: j */
    private int f6866j;

    /* JADX INFO: renamed from: n */
    private int f6870n;

    /* JADX INFO: renamed from: o */
    private final zzbee f6871o;

    /* JADX INFO: renamed from: p */
    private final zzd f6872p;

    /* JADX INFO: renamed from: r */
    private final zzbeb f6874r;

    /* JADX INFO: renamed from: b */
    private static Api.zzf<zzbeo> f6858b = new Api.zzf<>();

    /* JADX INFO: renamed from: c */
    private static Api.zza<zzbeo, Object> f6859c = new zzbdz();

    /* JADX INFO: renamed from: a */
    @Deprecated
    public static final Api<Object> f6857a = new Api<>("ClearcutLogger.API", f6859c, f6858b);

    /* JADX INFO: renamed from: d */
    private static final zzctx[] f6860d = new zzctx[0];

    /* JADX INFO: renamed from: e */
    private static final String[] f6861e = new String[0];

    /* JADX INFO: renamed from: f */
    private static final byte[][] f6862f = new byte[0][];

    /* JADX INFO: renamed from: k */
    private String f6867k = null;

    /* JADX INFO: renamed from: l */
    private String f6868l = null;

    /* JADX INFO: renamed from: m */
    private final boolean f6869m = true;

    /* JADX INFO: renamed from: q */
    private zzbed f6873q = new zzbed();

    public zzbdy(Context context, int i, String str, String str2, String str3, boolean z, zzbee zzbeeVar, zzd zzdVar, zzbed zzbedVar, zzbeb zzbebVar) {
        this.f6866j = -1;
        this.f6870n = 0;
        this.f6863g = context.getPackageName();
        this.f6864h = m7655a(context);
        this.f6866j = -1;
        this.f6865i = str;
        this.f6871o = zzbeeVar;
        this.f6872p = zzdVar;
        this.f6870n = 0;
        this.f6874r = zzbebVar;
        zzbq.m7383b(true, "can't be anonymous with an upload account");
    }

    /* JADX INFO: renamed from: a */
    private static int m7655a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static int[] m7659b(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList<Integer> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Integer num = arrayList2.get(i);
            i++;
            iArr[i2] = num.intValue();
            i2++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public final zzbea m7667a(byte[] bArr) {
        return new zzbea(this, bArr, (zzbdz) null);
    }
}
