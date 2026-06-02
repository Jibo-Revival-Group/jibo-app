package com.jibo.utils.cache;

import android.content.Context;
import java.io.File;

public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
   public ExternalCacheDiskCacheFactory(Context var1, String var2, int var3) {
      super(var1, new DiskLruCacheFactory.CacheDirectoryGetter(var1, var2) {
         final Context a;
         final String b;

         {
            this.a = var1;
            this.b = var2x;
         }

         @Override
         public File a() {
            File var1x = this.a.getExternalCacheDir();
            if (var1x == null) {
               var1x = null;
            } else if (this.b != null) {
               var1x = new File(var1x, this.b);
            }

            return var1x;
         }
      }, var3);
   }
}
