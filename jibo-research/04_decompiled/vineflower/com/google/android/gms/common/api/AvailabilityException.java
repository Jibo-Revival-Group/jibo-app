package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.Iterator;

public class AvailabilityException extends Exception {
   private final ArrayMap<zzh<?>, ConnectionResult> a;

   public AvailabilityException(ArrayMap<zzh<?>, ConnectionResult> var1) {
      this.a = var1;
   }

   public final ArrayMap<zzh<?>, ConnectionResult> a() {
      return this.a;
   }

   public ConnectionResult a(GoogleApi<? extends Api.ApiOptions> var1) {
      zzh var3 = var1.b();
      boolean var2;
      if (this.a.get(var3) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      zzbq.b(var2, "The given API was not part of the availability request.");
      return this.a.get(var3);
   }

   @Override
   public String getMessage() {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.a.keySet().iterator();
      boolean var1 = true;

      while (var3.hasNext()) {
         zzh var4 = (zzh)var3.next();
         ConnectionResult var5 = this.a.get(var4);
         if (var5.b()) {
            var1 = false;
         }

         String var7 = var4.a();
         String var8 = String.valueOf(var5);
         var2.add(new StringBuilder(String.valueOf(var7).length() + 2 + String.valueOf(var8).length()).append(var7).append(": ").append(var8).toString());
      }

      StringBuilder var6 = new StringBuilder();
      if (var1) {
         var6.append("None of the queried APIs are available. ");
      } else {
         var6.append("Some of the queried APIs are unavailable. ");
      }

      var6.append(TextUtils.join("; ", var2));
      return var6.toString();
   }
}
