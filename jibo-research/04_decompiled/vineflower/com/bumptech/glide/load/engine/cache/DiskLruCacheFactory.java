package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {
   private final DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter;
   private final int diskCacheSize;

   public DiskLruCacheFactory(DiskLruCacheFactory.CacheDirectoryGetter var1, int var2) {
      this.diskCacheSize = var2;
      this.cacheDirectoryGetter = var1;
   }

   @Override
   public DiskCache build() {
      Object var2 = null;
      File var3 = this.cacheDirectoryGetter.getCacheDirectory();
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

         var1 = DiskLruCacheWrapper.get(var3, this.diskCacheSize);
      }

      return var1;
   }

   public interface CacheDirectoryGetter {
      File getCacheDirectory();
   }
}
