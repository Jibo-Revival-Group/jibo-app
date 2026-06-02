package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

public class FileStoreImpl implements FileStore {
   private final Context a;
   private final String b;
   private final String c;

   public FileStoreImpl(Kit var1) {
      if (var1.r() == null) {
         throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
      }

      this.a = var1.r();
      this.b = var1.t();
      this.c = "Android/" + this.a.getPackageName();
   }

   @Override
   public File a() {
      return this.a(this.a.getFilesDir());
   }

   File a(File var1) {
      if (var1 != null) {
         File var2 = var1;
         if (var1.exists()) {
            return var2;
         }

         if (var1.mkdirs()) {
            var2 = var1;
            return var2;
         }

         Fabric.h().d("Fabric", "Couldn't create file");
      } else {
         Fabric.h().a("Fabric", "Null File");
      }

      return null;
   }
}
