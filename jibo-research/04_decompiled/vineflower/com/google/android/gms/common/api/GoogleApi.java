package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzs;
import java.util.Collections;
import java.util.Set;

public class GoogleApi<O extends Api.ApiOptions> {
   protected final zzbm a;
   private final Context b;
   private final Api<O> c;
   private final O d;
   private final zzh<O> e;
   private final Looper f;
   private final int g;
   private final GoogleApiClient h;
   private final zzcz i;

   protected GoogleApi(Context var1, Api<O> var2, Looper var3) {
      zzbq.a(var1, "Null context is not permitted.");
      zzbq.a(var2, "Api must not be null.");
      zzbq.a(var3, "Looper must not be null.");
      this.b = var1.getApplicationContext();
      this.c = var2;
      this.d = null;
      this.f = var3;
      this.e = zzh.a(var2);
      this.h = new zzbw<>(this);
      this.a = zzbm.a(this.b);
      this.g = this.a.c();
      this.i = new com.google.android.gms.common.api.internal.zzg();
   }

   public GoogleApi(Context var1, Api<O> var2, O var3, GoogleApi.zza var4) {
      zzbq.a(var1, "Null context is not permitted.");
      zzbq.a(var2, "Api must not be null.");
      zzbq.a(var4, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
      this.b = var1.getApplicationContext();
      this.c = var2;
      this.d = (O)var3;
      this.f = var4.c;
      this.e = zzh.a(this.c, this.d);
      this.h = new zzbw<>(this);
      this.a = zzbm.a(this.b);
      this.g = this.a.c();
      this.i = var4.b;
      this.a.a(this);
   }

   @Deprecated
   public GoogleApi(Context var1, Api<O> var2, O var3, zzcz var4) {
      this(var1, var2, (O)var3, new zzd().a(var4).a());
   }

   private final <A extends Api.zzb, T extends zzm<? extends Result, A>> T a(int var1, T var2) {
      var2.f();
      this.a.a(this, var1, var2);
      return (T)var2;
   }

   private final zzs g() {
      zzs var2;
      Account var3;
      label24: {
         var2 = new zzs();
         if (this.d instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
            GoogleSignInAccount var1 = ((Api.ApiOptions.HasGoogleSignInAccountOptions)this.d).a();
            if (var1 != null) {
               var3 = var1.d();
               break label24;
            }
         }

         if (this.d instanceof Api.ApiOptions.HasAccountOptions) {
            var3 = ((Api.ApiOptions.HasAccountOptions)this.d).a();
         } else {
            var3 = null;
         }
      }

      var2 = var2.a(var3);
      if (this.d instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
         GoogleSignInAccount var4 = ((Api.ApiOptions.HasGoogleSignInAccountOptions)this.d).a();
         if (var4 != null) {
            Set var7 = var4.k();
            return var2.a(var7);
         }
      }

      Set var5 = Collections.emptySet();
      return var2.a(var5);
   }

   public Api.zze a(Looper var1, zzbo<O> var2) {
      zzr var3 = this.g().a(this.b.getPackageName()).b(this.b.getClass().getName()).a();
      return this.c.b().a(this.b, var1, var3, this.d, var2, var2);
   }

   public final Api<O> a() {
      return this.c;
   }

   public zzcv a(Context var1, Handler var2) {
      return new zzcv(var1, var2, this.g().a());
   }

   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T a(T var1) {
      return this.a(0, (T)var1);
   }

   public final zzh<O> b() {
      return this.e;
   }

   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      return this.a(1, (T)var1);
   }

   public final int c() {
      return this.g;
   }

   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T c(T var1) {
      return this.a(2, (T)var1);
   }

   public final GoogleApiClient d() {
      return this.h;
   }

   public final Looper e() {
      return this.f;
   }

   public final Context f() {
      return this.b;
   }

   public static final class zza {
      public static final GoogleApi.zza a = new zzd().a();
      public final zzcz b;
      public final Looper c;

      private zza(zzcz var1, Account var2, Looper var3) {
         this.b = var1;
         this.c = var3;
      }
   }
}
