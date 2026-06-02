package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdj {
   public static final Status a = new Status(8, "The connection to Google Play services was lost");
   private static final BasePendingResult<?>[] c = new BasePendingResult[0];
   final Set<BasePendingResult<?>> b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));
   private final zzdm d = new zzdk(this);
   private final Map<Api.zzc<?>, Api.zze> e;

   public zzdj(Map<Api.zzc<?>, Api.zze> var1) {
      this.e = var1;
   }

   public final void a() {
      for (BasePendingResult var3 : this.b.toArray(c)) {
         var3.a((zzdm)null);
         if (var3.c() == null) {
            if (var3.e()) {
               this.b.remove(var3);
            }
         } else {
            var3.a((ResultCallback)null);
            IBinder var6 = this.e.get(((zzm)var3).g()).k();
            if (var3.d()) {
               var3.a(new zzdl(var3, null, var6, null));
            } else {
               if (var6 == null || !var6.isBinderAlive()) {
                  var3.a((zzdm)null);
                  var3.a();
                  var3.c();
                  throw new NullPointerException();
               }

               zzdl var5 = new zzdl(var3, null, var6, null);
               var3.a(var5);

               try {
                  var6.linkToDeath(var5, 0);
               } catch (RemoteException var7) {
                  var3.a();
                  var3.c();
                  throw new NullPointerException();
               }
            }

            this.b.remove(var3);
         }
      }
   }

   final void a(BasePendingResult<? extends Result> var1) {
      this.b.add(var1);
      var1.a(this.d);
   }

   public final void b() {
      BasePendingResult[] var3 = this.b.toArray(c);
      int var2 = var3.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3[var1].b(a);
      }
   }
}
