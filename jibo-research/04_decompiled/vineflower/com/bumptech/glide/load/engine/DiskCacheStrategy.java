package com.bumptech.glide.load.engine;

public enum DiskCacheStrategy {
   ALL(true, true),
   NONE(false, false),
   RESULT(false, true),
   SOURCE(true, false);

   private static final DiskCacheStrategy[] $VALUES = new DiskCacheStrategy[]{
      DiskCacheStrategy.ALL, DiskCacheStrategy.NONE, DiskCacheStrategy.SOURCE, DiskCacheStrategy.RESULT
   };
   private final boolean cacheResult;
   private final boolean cacheSource;

   DiskCacheStrategy(boolean var3, boolean var4) {
      this.cacheSource = var3;
      this.cacheResult = var4;
   }

   public boolean cacheResult() {
      return this.cacheResult;
   }

   public boolean cacheSource() {
      return this.cacheSource;
   }
}
