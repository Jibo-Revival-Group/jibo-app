package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.internal.zzbhf;

public class zzf {
   private static final zzf a = new zzf();
   public static final int b = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;

   zzf() {
   }

   public static Intent a(Context var0, int var1, String var2) {
      Intent var3;
      switch (var1) {
         case 1:
         case 2:
            if (var0 != null && com.google.android.gms.common.util.zzi.b(var0)) {
               var3 = zzak.a();
            } else {
               var3 = zzak.a("com.google.android.gms", a(var0, var2));
            }
            break;
         case 3:
            var3 = zzak.a("com.google.android.gms");
            break;
         default:
            var3 = null;
      }

      return var3;
   }

   private static String a(Context var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("gcore_");
      var2.append(b);
      var2.append("-");
      if (!TextUtils.isEmpty(var1)) {
         var2.append(var1);
      }

      var2.append("-");
      if (var0 != null) {
         var2.append(var0.getPackageName());
      }

      var2.append("-");
      if (var0 != null) {
         try {
            var2.append(zzbhf.a(var0).b(var0.getPackageName(), 0).versionCode);
         } catch (NameNotFoundException var3) {
         }
      }

      return var2.toString();
   }

   public static zzf b() {
      return a;
   }

   public static boolean b(Context var0, int var1) {
      return zzp.zze(var0, var1);
   }

   public static void c(Context var0) {
      zzp.zzce(var0);
   }

   public static int d(Context var0) {
      return zzp.zzcf(var0);
   }

   public int a(Context var1) {
      int var3 = zzp.isGooglePlayServicesAvailable(var1);
      int var2 = var3;
      if (zzp.zze(var1, var3)) {
         var2 = 18;
      }

      return var2;
   }

   public PendingIntent a(Context var1, int var2, int var3) {
      return this.a(var1, var2, var3, null);
   }

   public final PendingIntent a(Context var1, int var2, int var3, String var4) {
      Intent var6 = a(var1, var2, var4);
      PendingIntent var5;
      if (var6 == null) {
         var5 = null;
      } else {
         var5 = PendingIntent.getActivity(var1, var3, var6, 268435456);
      }

      return var5;
   }

   public boolean a(int var1) {
      return zzp.isUserRecoverableError(var1);
   }

   public String b(int var1) {
      return zzp.getErrorString(var1);
   }

   @Deprecated
   public final Intent c(int var1) {
      return a(null, var1, null);
   }
}
