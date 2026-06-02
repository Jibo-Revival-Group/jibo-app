package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzal;
import java.util.Locale;

public final class zzbgg {
   private final String a;
   private final String b;
   private final zzal c;
   private final int d;

   private zzbgg(String var1, String var2) {
      this.b = var2;
      this.a = var1;
      this.c = new zzal(var1);
      this.d = this.a();
   }

   public zzbgg(String var1, String... var2) {
      this(var1, a(var2));
   }

   private final int a() {
      int var1 = 2;

      while (7 >= var1 && !Log.isLoggable(this.a, var1)) {
         var1++;
      }

      return var1;
   }

   private static String a(String... var0) {
      String var5;
      if (var0.length == 0) {
         var5 = "";
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append('[');

         for (String var4 : var0) {
            if (var3.length() > 1) {
               var3.append(",");
            }

            var3.append(var4);
         }

         var3.append(']').append(' ');
         var5 = var3.toString();
      }

      return var5;
   }

   private final boolean a(int var1) {
      boolean var2;
      if (this.d <= var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private final String d(String var1, Object... var2) {
      String var3 = var1;
      if (var2 != null) {
         var3 = var1;
         if (var2.length > 0) {
            var3 = String.format(Locale.US, var1, var2);
         }
      }

      return this.b.concat(var3);
   }

   public final void a(String var1, Object... var2) {
      if (this.a(3)) {
         Log.d(this.a, this.d(var1, var2));
      }
   }

   public final void b(String var1, Object... var2) {
      Log.i(this.a, this.d(var1, var2));
   }

   public final void c(String var1, Object... var2) {
      Log.w(this.a, this.d(var1, var2));
   }
}
