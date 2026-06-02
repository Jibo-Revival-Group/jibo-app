package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationVersionSignature {
   private static final ConcurrentHashMap<String, Key> a = new ConcurrentHashMap<>();

   public static Key a(Context var0) {
      String var3 = var0.getPackageName();
      Key var2 = a.get(var3);
      Key var1 = var2;
      if (var2 == null) {
         Key var4 = b(var0);
         var2 = a.putIfAbsent(var3, var4);
         var1 = var2;
         if (var2 == null) {
            var1 = var4;
         }
      }

      return var1;
   }

   private static Key b(Context var0) {
      try {
         var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0);
      } catch (NameNotFoundException var1) {
         var1.printStackTrace();
         var2 = null;
      }

      String var3;
      if (var2 != null) {
         var3 = String.valueOf(var2.versionCode);
      } else {
         var3 = UUID.randomUUID().toString();
      }

      return new StringSignature(var3);
   }
}
