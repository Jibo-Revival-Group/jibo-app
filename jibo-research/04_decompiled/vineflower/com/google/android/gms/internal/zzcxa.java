package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

public final class zzcxa {
   public static final Api.zza<zzcxn, zzcxe> a = new zzcxb();
   public static final Api<zzcxe> b = new Api<>("SignIn.API", a, zzcxa.c);
   private static Api.zzf<zzcxn> c = new Api.zzf<>();
   private static Api.zzf<zzcxn> d = new Api.zzf<>();
   private static Api.zza<zzcxn, Object> e = new zzcxc();
   private static Scope f = new Scope("profile");
   private static Scope g = new Scope("email");
   private static Api<Object> h = new Api<>("SignIn.INTERNAL_API", e, d);
}
