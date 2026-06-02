package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxa {

    /* JADX INFO: renamed from: c */
    private static Api.zzf<zzcxn> f7769c = new Api.zzf<>();

    /* JADX INFO: renamed from: d */
    private static Api.zzf<zzcxn> f7770d = new Api.zzf<>();

    /* JADX INFO: renamed from: a */
    public static final Api.zza<zzcxn, zzcxe> f7767a = new zzcxb();

    /* JADX INFO: renamed from: e */
    private static Api.zza<zzcxn, Object> f7771e = new zzcxc();

    /* JADX INFO: renamed from: f */
    private static Scope f7772f = new Scope("profile");

    /* JADX INFO: renamed from: g */
    private static Scope f7773g = new Scope("email");

    /* JADX INFO: renamed from: b */
    public static final Api<zzcxe> f7768b = new Api<>("SignIn.API", f7767a, f7769c);

    /* JADX INFO: renamed from: h */
    private static Api<Object> f7774h = new Api<>("SignIn.INTERNAL_API", f7771e, f7770d);
}
