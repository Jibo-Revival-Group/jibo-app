package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker {
   private final String a;
   private final FileStore b;

   public CrashlyticsFileMarker(String var1, FileStore var2) {
      this.a = var1;
      this.b = var2;
   }

   private File d() {
      return new File(this.b.a(), this.a);
   }

   public boolean a() {
      boolean var1 = false;

      boolean var2;
      try {
         var2 = this.d().createNewFile();
      } catch (IOException var4) {
         Fabric.h().e("CrashlyticsCore", "Error creating marker: " + this.a, var4);
         return var1;
      }

      return var2;
   }

   public boolean b() {
      return this.d().exists();
   }

   public boolean c() {
      return this.d().delete();
   }
}
