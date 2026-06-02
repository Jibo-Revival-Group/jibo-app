package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzr;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends Api.ApiOptions> {
   private final Api.zza<?, O> a;
   private final Api.zzh<?, O> b;
   private final Api.zzf<?> c;
   private final Api.zzi<?> d;
   private final String e;

   public <C extends Api.zze> Api(String var1, Api.zza<C, O> var2, Api.zzf<C> var3) {
      zzbq.a(var2, "Cannot construct an Api with a null ClientBuilder");
      zzbq.a(var3, "Cannot construct an Api with a null ClientKey");
      this.e = var1;
      this.a = var2;
      this.b = null;
      this.c = var3;
      this.d = null;
   }

   public final Api.zzd<?, O> a() {
      return this.a;
   }

   public final Api.zza<?, O> b() {
      boolean var1;
      if (this.a != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzbq.a(var1, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.a;
   }

   public final Api.zzc<?> c() {
      if (this.c != null) {
         return this.c;
      } else {
         throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
      }
   }

   public final String d() {
      return this.e;
   }

   public interface ApiOptions {
      interface HasAccountOptions extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions {
         Account a();
      }

      interface HasGoogleSignInAccountOptions extends Api.ApiOptions.HasOptions {
         GoogleSignInAccount a();
      }

      interface HasOptions extends Api.ApiOptions {
      }

      interface NotRequiredOptions extends Api.ApiOptions {
      }

      interface Optional extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions {
      }
   }

   public abstract static class zza<T extends Api.zze, O> extends Api.zzd<T, O> {
      public abstract T a(
         Context var1, Looper var2, zzr var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6
      );
   }

   public interface zzb {
   }

   public static class zzc<C extends Api.zzb> {
   }

   public static class zzd<T extends Api.zzb, O> {
      public int a() {
         return Integer.MAX_VALUE;
      }

      public List<Scope> a(O var1) {
         return Collections.emptyList();
      }
   }

   public interface zze extends Api.zzb {
      void a(zzan var1, Set<Scope> var2);

      void a(zzj var1);

      void a(zzp var1);

      void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

      boolean c();

      Intent d();

      void f();

      boolean g();

      boolean h();

      boolean i();

      boolean j();

      IBinder k();

      String l();
   }

   public static final class zzf<C extends Api.zze> extends Api.zzc<C> {
   }

   public interface zzg<T extends IInterface> extends Api.zzb {
   }

   public static class zzh<T extends Api.zzg, O> extends Api.zzd<T, O> {
   }

   public static final class zzi<C extends Api.zzg> extends Api.zzc<C> {
   }
}
