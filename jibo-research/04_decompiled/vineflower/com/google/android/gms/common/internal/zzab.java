package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class zzab<T extends IInterface> extends zzd<T> implements Api.zze, zzaf {
   private final zzr d;
   private final Set<Scope> e;
   private final Account f;

   protected zzab(Context var1, Looper var2, int var3, zzr var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      this(var1, var2, zzag.a(var1), GoogleApiAvailability.a(), var3, var4, zzbq.a(var5), zzbq.a(var6));
   }

   private zzab(
      Context var1,
      Looper var2,
      zzag var3,
      GoogleApiAvailability var4,
      int var5,
      zzr var6,
      GoogleApiClient.ConnectionCallbacks var7,
      GoogleApiClient.OnConnectionFailedListener var8
   ) {
      zzac var12;
      if (var7 == null) {
         var12 = null;
      } else {
         var12 = new zzac(var7);
      }

      zzad var13;
      if (var8 == null) {
         var13 = null;
      } else {
         var13 = new zzad(var8);
      }

      super(var1, var2, var3, var4, var5, var12, var13, var6.h());
      this.d = var6;
      this.f = var6.b();
      Set var9 = var6.e();
      Set var11 = this.a(var9);
      Iterator var10 = var11.iterator();

      while (var10.hasNext()) {
         if (!var9.contains((Scope)var10.next())) {
            throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
         }
      }

      this.e = var11;
   }

   protected Set<Scope> a(Set<Scope> var1) {
      return var1;
   }

   @Override
   public final Account e_() {
      return this.f;
   }

   protected final zzr n() {
      return this.d;
   }

   @Override
   protected final Set<Scope> o() {
      return this.e;
   }

   @Override
   public com.google.android.gms.common.zzc[] p() {
      return new com.google.android.gms.common.zzc[0];
   }
}
