package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
   public InternalCacheDiskCacheFactory(Context var1) {
      this(var1, "image_manager_disk_cache", 262144000);
   }

   public InternalCacheDiskCacheFactory(Context var1, String var2, int var3) {
      super(new DiskLruCacheFactory.CacheDirectoryGetter(var1, var2) {
         final Context val$context;
         final String val$diskCacheName;

         {
            this.val$context = var1;
            this.val$diskCacheName = var2x;
         }

         @Override
         public File getCacheDirectory() {
            File var1x = this.val$context.getCacheDir();
            if (var1x == null) {
               var1x = null;
            } else if (this.val$diskCacheName != null) {
               var1x = new File(var1x, this.val$diskCacheName);
            }

            return var1x;
         }
      }, var3);
   }
}
