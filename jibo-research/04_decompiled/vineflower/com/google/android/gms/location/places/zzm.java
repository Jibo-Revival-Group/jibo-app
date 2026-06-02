package com.google.android.gms.location.places;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcga;
import com.google.android.gms.location.places.internal.zzx;

public class zzm extends zzx {
   private static final String a = zzm.class.getSimpleName();
   private final zzm.zzd b = null;
   private final zzm.zza c;
   private final zzm.zze d;
   private final zzm.zzf e;
   private final zzm.zzc f;

   public zzm(zzm.zza var1) {
      this.c = var1;
      this.d = null;
      this.e = null;
      this.f = null;
   }

   public zzm(zzm.zzc var1) {
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = var1;
   }

   @Override
   public final void a(Status var1) throws RemoteException {
      this.e.a(var1);
   }

   @Override
   public final void a(DataHolder var1) throws RemoteException {
      boolean var3;
      if (this.b != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzbq.a(var3, "placeEstimator cannot be null");
      if (var1 == null) {
         if (Log.isLoggable(a, 6)) {
            Log.e(a, "onPlaceEstimated received null DataHolder", new Throwable());
         }

         this.b.c(Status.c);
      } else {
         Bundle var4 = var1.c();
         int var2;
         if (var4 == null) {
            var2 = 100;
         } else {
            var2 = PlaceLikelihoodBuffer.a(var4);
         }

         PlaceLikelihoodBuffer var5 = new PlaceLikelihoodBuffer(var1, var2);
         this.b.a(var5);
      }
   }

   @Override
   public final void b(DataHolder var1) throws RemoteException {
      if (var1 == null) {
         if (Log.isLoggable(a, 6)) {
            Log.e(a, "onAutocompletePrediction received null DataHolder", new Throwable());
         }

         this.c.c(Status.c);
      } else {
         this.c.a(new AutocompletePredictionBuffer(var1));
      }
   }

   @Override
   public final void c(DataHolder var1) throws RemoteException {
      if (var1 == null) {
         if (Log.isLoggable(a, 6)) {
            Log.e(a, "onPlaceUserDataFetched received null DataHolder", new Throwable());
         }

         Status var2 = Status.c;
         throw new NullPointerException();
      } else {
         new zzcga(var1);
         throw new NullPointerException();
      }
   }

   @Override
   public final void d(DataHolder var1) throws RemoteException {
      PlaceBuffer var2 = new PlaceBuffer(var1);
      this.f.a(var2);
   }

   public abstract static class zza<A extends Api.zze> extends zzm.zzb<AutocompletePredictionBuffer, A> {
      public zza(Api var1, GoogleApiClient var2) {
         super(var1, var2);
      }
   }

   public abstract static class zzb<R extends Result, A extends Api.zze> extends com.google.android.gms.common.api.internal.zzm<R, A> {
      public zzb(Api var1, GoogleApiClient var2) {
         super(var1, var2);
      }
   }

   public abstract static class zzc<A extends Api.zze> extends zzm.zzb<PlaceBuffer, A> {
      public zzc(Api var1, GoogleApiClient var2) {
         super(var1, var2);
      }
   }

   public abstract static class zzd<A extends Api.zze> extends zzm.zzb<PlaceLikelihoodBuffer, A> {
   }

   @Deprecated
   public abstract static class zze<A extends Api.zze> extends zzm.zzb<zzcga, A> {
   }

   public abstract static class zzf<A extends Api.zze> extends zzm.zzb<Status, A> {
   }
}
