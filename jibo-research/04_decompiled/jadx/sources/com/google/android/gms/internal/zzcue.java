package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public final class zzcue {

    /* JADX INFO: renamed from: a */
    private static final Api.zzf<zzcut> f7742a = new Api.zzf<>();

    /* JADX INFO: renamed from: b */
    private static final Api.zza<zzcut, Object> f7743b = new zzcuf();

    /* JADX INFO: renamed from: c */
    @Deprecated
    private static Api<Object> f7744c = new Api<>("Phenotype.API", f7743b, f7742a);

    /* JADX INFO: renamed from: d */
    @Deprecated
    private static zzcug f7745d = new zzcus();

    /* JADX INFO: renamed from: a */
    public static Uri m8469a(String str) {
        String strValueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
