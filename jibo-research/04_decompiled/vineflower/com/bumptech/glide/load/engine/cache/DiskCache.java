package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

public interface DiskCache {
   void delete(Key var1);

   File get(Key var1);

   void put(Key var1, DiskCache.Writer var2);

   interface Factory {
      DiskCache build();
   }

   interface Writer {
      boolean write(File var1);
   }
}
