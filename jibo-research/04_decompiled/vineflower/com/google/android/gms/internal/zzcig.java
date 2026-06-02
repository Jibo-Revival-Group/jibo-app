package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public final class zzcig extends zzcjl {
   private static int a = 65535;
   private static int b = 2;
   private final Map<String, Map<String, String>> c = new ArrayMap<>();
   private final Map<String, Map<String, Boolean>> d = new ArrayMap<>();
   private final Map<String, Map<String, Boolean>> e = new ArrayMap<>();
   private final Map<String, zzcly> f = new ArrayMap<>();
   private final Map<String, Map<String, Integer>> g;
   private final Map<String, String> h = new ArrayMap<>();

   zzcig(zzcim var1) {
      super(var1);
      this.g = new ArrayMap<>();
   }

   private final zzcly a(String var1, byte[] var2) {
      zzcly var5;
      if (var2 == null) {
         var5 = new zzcly();
      } else {
         zzfjj var3 = zzfjj.a(var2, 0, var2.length);
         zzcly var6 = new zzcly();

         try {
            var6.a(var3);
            this.t().E().a("Parsed config. version, gmp_app_id", var6.a, var6.b);
         } catch (IOException var4) {
            this.t().A().a("Unable to merge remote config. appId", zzchm.a(var1), var4);
            zzcly var7 = new zzcly();
            return var7;
         }

         var5 = var6;
      }

      return var5;
   }

   private static Map<String, String> a(zzcly var0) {
      ArrayMap var3 = new ArrayMap();
      if (var0 != null && var0.c != null) {
         for (zzclz var5 : var0.c) {
            if (var5 != null) {
               var3.put(var5.a, var5.b);
            }
         }
      }

      return var3;
   }

   private final void a(String var1, zzcly var2) {
      ArrayMap var5 = new ArrayMap();
      ArrayMap var7 = new ArrayMap();
      ArrayMap var6 = new ArrayMap();
      if (var2 != null && var2.d != null) {
         for (zzclx var9 : var2.d) {
            if (TextUtils.isEmpty(var9.a)) {
               this.t().A().a("EventConfig contained null event name");
            } else {
               String var10 = AppMeasurement.Event.a(var9.a);
               if (!TextUtils.isEmpty(var10)) {
                  var9.a = var10;
               }

               var5.put(var9.a, var9.b);
               var7.put(var9.a, var9.c);
               if (var9.d != null) {
                  if (var9.d >= b && var9.d <= a) {
                     var6.put(var9.a, var9.d);
                  } else {
                     this.t().A().a("Invalid sampling rate. Event name, sample rate", var9.a, var9.d);
                  }
               }
            }
         }
      }

      this.d.put(var1, var5);
      this.e.put(var1, var7);
      this.g.put(var1, var6);
   }

   private final void e(String var1) {
      this.Q();
      this.c();
      zzbq.a(var1);
      if (this.f.get(var1) == null) {
         byte[] var2 = this.n().d(var1);
         if (var2 == null) {
            this.c.put(var1, null);
            this.d.put(var1, null);
            this.e.put(var1, null);
            this.f.put(var1, null);
            this.h.put(var1, null);
            this.g.put(var1, null);
         } else {
            zzcly var3 = this.a(var1, var2);
            this.c.put(var1, a(var3));
            this.a(var1, var3);
            this.f.put(var1, var3);
            this.h.put(var1, null);
         }
      }
   }

   protected final zzcly a(String var1) {
      this.Q();
      this.c();
      zzbq.a(var1);
      this.e(var1);
      return this.f.get(var1);
   }

   final String a(String var1, String var2) {
      this.c();
      this.e(var1);
      Map var3 = this.c.get(var1);
      if (var3 != null) {
         var1 = (String)var3.get(var2);
      } else {
         var1 = null;
      }

      return var1;
   }

   protected final boolean a(String var1, byte[] var2, String var3) {
      this.Q();
      this.c();
      zzbq.a(var1);
      zzcly var11 = this.a(var1, var2);
      boolean var10;
      if (var11 == null) {
         var10 = false;
      } else {
         this.a(var1, var11);
         this.f.put(var1, var11);
         this.h.put(var1, var3);
         this.c.put(var1, a(var11));
         zzcgk var20 = this.e();
         zzclr[] var12 = var11.e;
         zzbq.a(var12);

         for (zzclr var14 : var12) {
            for (zzcls var16 : var14.c) {
               String var15 = AppMeasurement.Event.a(var16.b);
               if (var15 != null) {
                  var16.b = var15;
               }

               for (zzclt var17 : var16.c) {
                  var15 = AppMeasurement.Param.a(var17.d);
                  if (var15 != null) {
                     var17.d = var15;
                  }
               }
            }

            for (zzclv var26 : var14.b) {
               String var27 = AppMeasurement.UserProperty.a(var26.b);
               if (var27 != null) {
                  var26.b = var27;
               }
            }
         }

         var20.n().a(var1, var12);

         label49: {
            try {
               var11.e = null;
               var21 = new byte[var11.f()];
               var11.a(zzfjk.a(var21, 0, var21.length));
            } catch (IOException var19) {
               this.t().A().a("Unable to serialize reduced-size config. Storing full config instead. appId", zzchm.a(var1), var19);
               break label49;
            }

            var2 = var21;
         }

         zzcgo var22 = this.n();
         zzbq.a(var1);
         var22.c();
         var22.Q();
         ContentValues var25 = new ContentValues();
         var25.put("remote_config", var2);

         try {
            if (var22.A().update("apps", var25, "app_id = ?", new String[]{var1}) == 0L) {
               var22.t().y().a("Failed to update remote config (got 0). appId", zzchm.a(var1));
            }
         } catch (SQLiteException var18) {
            var22.t().y().a("Error storing remote config. appId", zzchm.a(var1), var18);
         }

         var10 = true;
      }

      return var10;
   }

   protected final String b(String var1) {
      this.c();
      return this.h.get(var1);
   }

   final boolean b(String var1, String var2) {
      boolean var3 = true;
      this.c();
      this.e(var1);
      if ((!this.p().l(var1) || !zzclq.i(var2)) && (!this.p().m(var1) || !zzclq.a(var2))) {
         Map var4 = this.d.get(var1);
         if (var4 != null) {
            Boolean var5 = (Boolean)var4.get(var2);
            if (var5 == null) {
               var3 = false;
            } else {
               var3 = var5;
            }
         } else {
            var3 = false;
         }
      }

      return var3;
   }

   protected final void c(String var1) {
      this.c();
      this.h.put(var1, null);
   }

   final boolean c(String var1, String var2) {
      this.c();
      this.e(var1);
      boolean var3;
      if ("ecommerce_purchase".equals(var2)) {
         var3 = true;
      } else {
         Map var4 = this.e.get(var1);
         if (var4 != null) {
            Boolean var5 = (Boolean)var4.get(var2);
            if (var5 == null) {
               var3 = false;
            } else {
               var3 = var5;
            }
         } else {
            var3 = false;
         }
      }

      return var3;
   }

   final int d(String var1, String var2) {
      this.c();
      this.e(var1);
      Map var4 = this.g.get(var1);
      int var3;
      if (var4 != null) {
         Integer var5 = (Integer)var4.get(var2);
         if (var5 == null) {
            var3 = 1;
         } else {
            var3 = var5;
         }
      } else {
         var3 = 1;
      }

      return var3;
   }

   final void d(String var1) {
      this.c();
      this.f.remove(var1);
   }

   @Override
   protected final boolean w() {
      return false;
   }
}
