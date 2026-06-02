package com.jibo.utils.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {
   private Context a;
   private final int b;
   private final DiskLruCacheFactory.CacheDirectoryGetter c;

   public DiskLruCacheFactory(Context var1, DiskLruCacheFactory.CacheDirectoryGetter var2, int var3) {
      this.a = var1.getApplicationContext();
      this.b = var3;
      this.c = var2;
   }

   @Override
   public DiskCache build() {
      Object var2 = null;
      File var3 = this.c.a();
      DiskCache var1;
      if (var3 == null) {
         var1 = (DiskCache)var2;
      } else {
         if (!var3.mkdirs()) {
            var1 = (DiskCache)var2;
            if (!var3.exists()) {
               return var1;
            }

            var1 = (DiskCache)var2;
            if (!var3.isDirectory()) {
               return var1;
            }
         }

         var1 = DiskLruCacheWrapper.a(this.a, var3, this.b);
      }

      return var1;
   }

   public interface CacheDirectoryGetter {
      File a();
   }
}
