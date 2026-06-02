package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;

public final class zzcgv {
   final String a;
   final String b;
   final long c;
   final long d;
   final zzcgx e;
   private String f;

   zzcgv(zzcim var1, String var2, String var3, String var4, long var5, long var7, Bundle var9) {
      zzbq.a(var3);
      zzbq.a(var4);
      this.a = var3;
      this.b = var4;
      var4 = var2;
      if (TextUtils.isEmpty(var2)) {
         var4 = null;
      }

      this.f = var4;
      this.c = var5;
      this.d = var7;
      if (this.d != 0L && this.d > this.c) {
         var1.f().A().a("Event created with reverse previous/current timestamps. appId", zzchm.a(var3));
      }

      this.e = a(var1, var9);
   }

   private zzcgv(zzcim var1, String var2, String var3, String var4, long var5, long var7, zzcgx var9) {
      zzbq.a(var3);
      zzbq.a(var4);
      zzbq.a(var9);
      this.a = var3;
      this.b = var4;
      var4 = var2;
      if (TextUtils.isEmpty(var2)) {
         var4 = null;
      }

      this.f = var4;
      this.c = var5;
      this.d = var7;
      if (this.d != 0L && this.d > this.c) {
         var1.f().A().a("Event created with reverse previous/current timestamps. appId", zzchm.a(var3));
      }

      this.e = var9;
   }

   private static zzcgx a(zzcim var0, Bundle var1) {
      zzcgx var5;
      if (var1 != null && !var1.isEmpty()) {
         Bundle var2 = new Bundle(var1);
         Iterator var4 = var2.keySet().iterator();

         while (var4.hasNext()) {
            String var3 = (String)var4.next();
            if (var3 == null) {
               var0.f().y().a("Param name can't be null");
               var4.remove();
            } else {
               Object var6 = var0.o().a(var3, var2.get(var3));
               if (var6 == null) {
                  var0.f().A().a("Param value can't be null", var0.p().b(var3));
                  var4.remove();
               } else {
                  var0.o().a(var2, var3, var6);
               }
            }
         }

         var5 = new zzcgx(var2);
      } else {
         var5 = new zzcgx(new Bundle());
      }

      return var5;
   }

   final zzcgv a(zzcim var1, long var2) {
      return new zzcgv(var1, this.f, this.a, this.b, this.c, var2, this.e);
   }

   @Override
   public final String toString() {
      String var3 = this.a;
      String var1 = this.b;
      String var2 = String.valueOf(this.e);
      return new StringBuilder(String.valueOf(var3).length() + 33 + String.valueOf(var1).length() + String.valueOf(var2).length())
         .append("Event{appId='")
         .append(var3)
         .append("', name='")
         .append(var1)
         .append("', params=")
         .append(var2)
         .append("}")
         .toString();
   }
}
