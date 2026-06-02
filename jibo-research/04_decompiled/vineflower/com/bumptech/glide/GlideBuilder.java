package com.bumptech.glide;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

public class GlideBuilder {
   private final Context a;
   private Engine b;
   private BitmapPool c;
   private MemoryCache d;
   private ExecutorService e;
   private ExecutorService f;
   private DecodeFormat g;
   private DiskCache.Factory h;

   public GlideBuilder(Context var1) {
      this.a = var1.getApplicationContext();
   }

   Glide a() {
      if (this.e == null) {
         this.e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
      }

      if (this.f == null) {
         this.f = new FifoPriorityThreadPoolExecutor(1);
      }

      MemorySizeCalculator var1 = new MemorySizeCalculator(this.a);
      if (this.c == null) {
         if (VERSION.SDK_INT >= 11) {
            this.c = new LruBitmapPool(var1.getBitmapPoolSize());
         } else {
            this.c = new BitmapPoolAdapter();
         }
      }

      if (this.d == null) {
         this.d = new LruResourceCache(var1.getMemoryCacheSize());
      }

      if (this.h == null) {
         this.h = new InternalCacheDiskCacheFactory(this.a);
      }

      if (this.b == null) {
         this.b = new Engine(this.d, this.h, this.f, this.e);
      }

      if (this.g == null) {
         this.g = DecodeFormat.DEFAULT;
      }

      return new Glide(this.b, this.d, this.c, this.a, this.g);
   }

   public GlideBuilder a(DiskCache.Factory var1) {
      this.h = var1;
      return this;
   }
}
