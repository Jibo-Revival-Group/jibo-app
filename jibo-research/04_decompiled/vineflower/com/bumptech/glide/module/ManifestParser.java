package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ManifestParser {
   private final Context a;

   public ManifestParser(Context var1) {
      this.a = var1;
   }

   private static GlideModule a(String var0) {
      try {
         var5 = Class.forName(var0);
      } catch (ClassNotFoundException var4) {
         throw new IllegalArgumentException("Unable to find GlideModule implementation", var4);
      }

      Object var1;
      try {
         var1 = var5.newInstance();
      } catch (InstantiationException var2) {
         throw new RuntimeException("Unable to instantiate GlideModule implementation for " + var5, var2);
      } catch (IllegalAccessException var3) {
         throw new RuntimeException("Unable to instantiate GlideModule implementation for " + var5, var3);
      }

      if (!(var1 instanceof GlideModule)) {
         throw new RuntimeException("Expected instanceof GlideModule, but found: " + var1);
      } else {
         return (GlideModule)var1;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public List<GlideModule> a() {
      ArrayList var1 = new ArrayList();

      label32: {
         ApplicationInfo var2;
         Iterator var3;
         try {
            var2 = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (var2.metaData == null) {
               break label32;
            }

            var3 = var2.metaData.keySet().iterator();
         } catch (NameNotFoundException var6) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", var6);
         }

         while (true) {
            try {
               if (!var3.hasNext()) {
                  break;
               }

               String var4 = (String)var3.next();
               if ("GlideModule".equals(var2.metaData.get(var4))) {
                  var1.add(a(var4));
               }
            } catch (NameNotFoundException var7) {
               throw new RuntimeException("Unable to find metadata to parse GlideModules", var7);
            }
         }
      }

      try {
         return var1;
      } catch (NameNotFoundException var5) {
         throw new RuntimeException("Unable to find metadata to parse GlideModules", var5);
      }
   }
}
