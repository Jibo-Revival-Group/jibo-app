package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider {
   private final ValueLoader<String> a = new ValueLoader<String>(this) {
      final InstallerPackageNameProvider a;

      {
         this.a = var1;
      }

      public String a(Context var1) throws Exception {
         String var2 = var1.getPackageManager().getInstallerPackageName(var1.getPackageName());
         String var3 = var2;
         if (var2 == null) {
            var3 = "";
         }

         return var3;
      }
   };
   private final MemoryValueCache<String> b = new MemoryValueCache<>();

   public String a(Context var1) {
      boolean var2;
      try {
         var4 = this.b.a(var1, this.a);
         var2 = "".equals(var4);
      } catch (Exception var3) {
         Fabric.h().e("Fabric", "Failed to determine installer package name", var3);
         return null;
      }

      if (var2) {
         var4 = null;
      }

      return var4;
   }
}
