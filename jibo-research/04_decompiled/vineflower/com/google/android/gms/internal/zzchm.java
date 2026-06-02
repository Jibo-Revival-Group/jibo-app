package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzchm extends zzcjl {
   private final String a = zzchc.c.b();
   private final char b;
   private final long c = 11910L;
   private final zzcho d;
   private final zzcho e;
   private final zzcho f;
   private final zzcho g;
   private final zzcho h;
   private final zzcho i;
   private final zzcho j;
   private final zzcho k;
   private final zzcho l;

   zzchm(zzcim var1) {
      super(var1);
      if (this.v().w()) {
         this.b = 'C';
      } else {
         this.b = 'c';
      }

      this.d = new zzcho(this, 6, false, false);
      this.e = new zzcho(this, 6, true, false);
      this.f = new zzcho(this, 6, false, true);
      this.g = new zzcho(this, 5, false, false);
      this.h = new zzcho(this, 5, true, false);
      this.i = new zzcho(this, 5, false, true);
      this.j = new zzcho(this, 4, false, false);
      this.k = new zzcho(this, 3, false, false);
      this.l = new zzcho(this, 2, false, false);
   }

   protected static Object a(String var0) {
      zzchp var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = new zzchp(var0);
      }

      return var1;
   }

   private static String a(boolean var0, Object var1) {
      String var13;
      if (var1 == null) {
         var13 = "";
      } else {
         if (var1 instanceof Integer) {
            var1 = (long)((Integer)var1).intValue();
         }

         if (var1 instanceof Long) {
            if (!var0) {
               var13 = String.valueOf(var1);
            } else if (Math.abs((Long)var1) < 100L) {
               var13 = String.valueOf(var1);
            } else {
               String var8;
               if (String.valueOf(var1).charAt(0) == '-') {
                  var8 = "-";
               } else {
                  var8 = "";
               }

               var13 = String.valueOf(Math.abs((Long)var1));
               long var6 = Math.round(Math.pow(10.0, var13.length() - 1));
               long var4 = Math.round(Math.pow(10.0, var13.length()) - 1.0);
               var13 = new StringBuilder(String.valueOf(var8).length() + 43 + String.valueOf(var8).length())
                  .append(var8)
                  .append(var6)
                  .append("...")
                  .append(var8)
                  .append(var4)
                  .toString();
            }
         } else if (var1 instanceof Boolean) {
            var13 = String.valueOf(var1);
         } else if (var1 instanceof Throwable) {
            Throwable var10 = (Throwable)var1;
            if (var0) {
               var13 = var10.getClass().getName();
            } else {
               var13 = var10.toString();
            }

            StringBuilder var9 = new StringBuilder(var13);
            String var17 = b(AppMeasurement.class.getCanonicalName());
            var13 = b(zzcim.class.getCanonicalName());

            for (StackTraceElement var18 : var10.getStackTrace()) {
               if (!var18.isNativeMethod()) {
                  String var12 = var18.getClassName();
                  if (var12 != null) {
                     var12 = b(var12);
                     if (var12.equals(var17) || var12.equals(var13)) {
                        var9.append(": ");
                        var9.append(var18);
                        break;
                     }
                  }
               }
            }

            var13 = var9.toString();
         } else if (var1 instanceof zzchp) {
            var13 = zzchp.a((zzchp)var1);
         } else if (var0) {
            var13 = "-";
         } else {
            var13 = String.valueOf(var1);
         }
      }

      return var13;
   }

   private static String a(boolean var0, String var1, Object var2, Object var3, Object var4) {
      String var5 = var1;
      if (var1 == null) {
         var5 = "";
      }

      String var7 = a(var0, var2);
      String var6 = a(var0, var3);
      var4 = a(var0, var4);
      var3 = new StringBuilder();
      var1 = "";
      if (!TextUtils.isEmpty(var5)) {
         var3.append(var5);
         var1 = ": ";
      }

      var2 = var1;
      if (!TextUtils.isEmpty(var7)) {
         var3.append(var1);
         var3.append(var7);
         var2 = ", ";
      }

      var1 = var2;
      if (!TextUtils.isEmpty(var6)) {
         var3.append(var2);
         var3.append(var6);
         var1 = ", ";
      }

      if (!TextUtils.isEmpty(var4)) {
         var3.append(var1);
         var3.append(var4);
      }

      return var3.toString();
   }

   private static String b(String var0) {
      String var2;
      if (TextUtils.isEmpty(var0)) {
         var2 = "";
      } else {
         int var1 = var0.lastIndexOf(46);
         var2 = var0;
         if (var1 != -1) {
            var2 = var0.substring(0, var1);
         }
      }

      return var2;
   }

   public final zzcho A() {
      return this.g;
   }

   public final zzcho B() {
      return this.i;
   }

   public final zzcho C() {
      return this.j;
   }

   public final zzcho D() {
      return this.k;
   }

   public final zzcho E() {
      return this.l;
   }

   public final String F() {
      Pair var2 = this.u().b.a();
      String var1;
      if (var2 != null && var2 != zzchx.a) {
         var1 = String.valueOf(var2.second);
         String var4 = (String)var2.first;
         var1 = new StringBuilder(String.valueOf(var1).length() + 1 + String.valueOf(var4).length()).append(var1).append(":").append(var4).toString();
      } else {
         var1 = null;
      }

      return var1;
   }

   protected final void a(int var1, String var2) {
      Log.println(var1, this.a, var2);
   }

   protected final void a(int var1, boolean var2, boolean var3, String var4, Object var5, Object var6, Object var7) {
      if (!var2 && this.a(var1)) {
         this.a(var1, a(false, var4, var5, var6, var7));
      }

      if (!var3 && var1 >= 5) {
         zzbq.a((String)var4);
         zzcih var13 = this.p.k();
         if (var13 == null) {
            this.a(6, "Scheduler not set. Not logging error/warn");
         } else if (!var13.P()) {
            this.a(6, "Scheduler not initialized. Not logging error/warn");
         } else {
            if (var1 < 0) {
               var1 = 0;
            }

            int var10 = var1;
            if (var1 >= 9) {
               var10 = 8;
            }

            char var8 = "01VDIWEA?".charAt(var10);
            char var9 = this.b;
            long var11 = this.c;
            var5 = a(true, var4, var5, var6, var7);
            var6 = new StringBuilder(String.valueOf("2").length() + 23 + String.valueOf(var5).length())
               .append("2")
               .append(var8)
               .append(var9)
               .append(var11)
               .append(":")
               .append(var5)
               .toString();
            var5 = var6;
            if (var6.length() > 1024) {
               var5 = var4.substring(0, 1024);
            }

            var13.a(new zzchn(this, var5));
         }
      }
   }

   protected final boolean a(int var1) {
      return Log.isLoggable(this.a, var1);
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final zzcho y() {
      return this.d;
   }

   public final zzcho z() {
      return this.e;
   }
}
