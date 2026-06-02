package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.zzq;

public final class zzbhe {
   private Context a;

   public zzbhe(Context var1) {
      this.a = var1;
   }

   public final int a(String var1) {
      return this.a.checkCallingOrSelfPermission(var1);
   }

   public final ApplicationInfo a(String var1, int var2) throws NameNotFoundException {
      return this.a.getPackageManager().getApplicationInfo(var1, var2);
   }

   public final boolean a() {
      boolean var1;
      if (Binder.getCallingUid() == Process.myUid()) {
         var1 = zzbhd.a(this.a);
      } else {
         if (zzq.h()) {
            String var2 = this.a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (var2 != null) {
               var1 = this.a.getPackageManager().isInstantApp(var2);
               return var1;
            }
         }

         var1 = false;
      }

      return var1;
   }

   @TargetApi(19)
   public final boolean a(int var1, String var2) {
      boolean var4 = false;
      boolean var3;
      if (zzq.d()) {
         try {
            ((AppOpsManager)this.a.getSystemService("appops")).checkPackage(var1, var2);
         } catch (SecurityException var6) {
            return var4;
         }

         var3 = true;
      } else {
         String[] var5 = this.a.getPackageManager().getPackagesForUid(var1);
         var3 = var4;
         if (var2 != null) {
            var3 = var4;
            if (var5 != null) {
               var1 = 0;

               while (true) {
                  var3 = var4;
                  if (var1 >= var5.length) {
                     break;
                  }

                  if (var2.equals(var5[var1])) {
                     var3 = true;
                     break;
                  }

                  var1++;
               }
            }
         }
      }

      return var3;
   }

   public final String[] a(int var1) {
      return this.a.getPackageManager().getPackagesForUid(var1);
   }

   public final PackageInfo b(String var1, int var2) throws NameNotFoundException {
      return this.a.getPackageManager().getPackageInfo(var1, var2);
   }

   public final CharSequence b(String var1) throws NameNotFoundException {
      return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(var1, 0));
   }
}
