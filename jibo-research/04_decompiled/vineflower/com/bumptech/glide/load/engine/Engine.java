package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Engine implements EngineJobListener, EngineResource.ResourceListener, MemoryCache.ResourceRemovedListener {
   private final Map<Key, WeakReference<EngineResource<?>>> activeResources;
   private final MemoryCache cache;
   private final Engine.LazyDiskCacheProvider diskCacheProvider;
   private final Engine.EngineJobFactory engineJobFactory;
   private final Map<Key, EngineJob> jobs;
   private final EngineKeyFactory keyFactory;
   private final ResourceRecycler resourceRecycler;
   private ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

   public Engine(MemoryCache var1, DiskCache.Factory var2, ExecutorService var3, ExecutorService var4) {
      this(var1, var2, var3, var4, null, null, null, null, null);
   }

   Engine(
      MemoryCache var1,
      DiskCache.Factory var2,
      ExecutorService var3,
      ExecutorService var4,
      Map<Key, EngineJob> var5,
      EngineKeyFactory var6,
      Map<Key, WeakReference<EngineResource<?>>> var7,
      Engine.EngineJobFactory var8,
      ResourceRecycler var9
   ) {
      this.cache = var1;
      this.diskCacheProvider = new Engine.LazyDiskCacheProvider(var2);
      Map var10 = var7;
      if (var7 == null) {
         var10 = new HashMap();
      }

      this.activeResources = var10;
      EngineKeyFactory var11 = var6;
      if (var6 == null) {
         var11 = new EngineKeyFactory();
      }

      this.keyFactory = var11;
      Map var12 = var5;
      if (var5 == null) {
         var12 = new HashMap();
      }

      this.jobs = var12;
      Engine.EngineJobFactory var13 = var8;
      if (var8 == null) {
         var13 = new Engine.EngineJobFactory(var3, var4, this);
      }

      this.engineJobFactory = var13;
      ResourceRecycler var14 = var9;
      if (var9 == null) {
         var14 = new ResourceRecycler();
      }

      this.resourceRecycler = var14;
      var1.setResourceRemovedListener(this);
   }

   private EngineResource<?> getEngineResourceFromCache(Key var1) {
      Resource var2 = this.cache.remove(var1);
      EngineResource var3;
      if (var2 == null) {
         var3 = null;
      } else if (var2 instanceof EngineResource) {
         var3 = (EngineResource)var2;
      } else {
         var3 = new EngineResource(var2, true);
      }

      return var3;
   }

   private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
      if (this.resourceReferenceQueue == null) {
         this.resourceReferenceQueue = new ReferenceQueue<>();
         Looper.myQueue().addIdleHandler(new Engine.RefQueueIdleHandler(this.activeResources, this.resourceReferenceQueue));
      }

      return this.resourceReferenceQueue;
   }

   private EngineResource<?> loadFromActiveResources(Key var1, boolean var2) {
      WeakReference var3 = null;
      EngineResource var4;
      if (!var2) {
         var4 = var3;
      } else {
         var3 = this.activeResources.get(var1);
         if (var3 != null) {
            EngineResource var6 = (EngineResource)var3.get();
            if (var6 != null) {
               var6.acquire();
               var4 = var6;
            } else {
               this.activeResources.remove(var1);
               var4 = var6;
            }
         } else {
            var4 = null;
         }
      }

      return var4;
   }

   private EngineResource<?> loadFromCache(Key var1, boolean var2) {
      EngineResource var3;
      if (!var2) {
         var3 = null;
      } else {
         EngineResource var4 = this.getEngineResourceFromCache(var1);
         var3 = var4;
         if (var4 != null) {
            var4.acquire();
            this.activeResources.put(var1, new Engine.ResourceWeakReference(var1, var4, this.getReferenceQueue()));
            var3 = var4;
         }
      }

      return var3;
   }

   private static void logWithTimeAndKey(String var0, long var1, Key var3) {
      Log.v("Engine", var0 + " in " + LogTime.a(var1) + "ms, key: " + var3);
   }

   public <T, Z, R> Engine.LoadStatus load(
      Key var1,
      int var2,
      int var3,
      DataFetcher<T> var4,
      DataLoadProvider<T, Z> var5,
      Transformation<Z> var6,
      ResourceTranscoder<Z, R> var7,
      Priority var8,
      boolean var9,
      DiskCacheStrategy var10,
      ResourceCallback var11
   ) {
      Util.a();
      long var12 = LogTime.a();
      String var14 = var4.getId();
      var1 = this.keyFactory
         .a(var14, var1, var2, var3, var5.getCacheDecoder(), var5.getSourceDecoder(), var6, var5.getEncoder(), var7, var5.getSourceEncoder());
      EngineResource var18 = this.loadFromCache(var1, var9);
      Engine.LoadStatus var16;
      if (var18 != null) {
         var11.onResourceReady(var18);
         if (Log.isLoggable("Engine", 2)) {
            logWithTimeAndKey("Loaded resource from cache", var12, var1);
         }

         var16 = null;
      } else {
         EngineResource var19 = this.loadFromActiveResources(var1, var9);
         if (var19 != null) {
            var11.onResourceReady(var19);
            if (Log.isLoggable("Engine", 2)) {
               logWithTimeAndKey("Loaded resource from active resources", var12, var1);
            }

            var16 = null;
         } else {
            EngineJob var20 = this.jobs.get(var1);
            if (var20 != null) {
               var20.addCallback(var11);
               if (Log.isLoggable("Engine", 2)) {
                  logWithTimeAndKey("Added to existing load", var12, var1);
               }

               var16 = new Engine.LoadStatus(var11, var20);
            } else {
               EngineJob var21 = this.engineJobFactory.build(var1, var9);
               EngineRunnable var17 = new EngineRunnable(
                  var21, new DecodeJob(var1, var2, var3, var4, var5, var6, var7, this.diskCacheProvider, var10, var8), var8
               );
               this.jobs.put(var1, var21);
               var21.addCallback(var11);
               var21.start(var17);
               if (Log.isLoggable("Engine", 2)) {
                  logWithTimeAndKey("Started new load", var12, var1);
               }

               var16 = new Engine.LoadStatus(var11, var21);
            }
         }
      }

      return var16;
   }

   @Override
   public void onEngineJobCancelled(EngineJob var1, Key var2) {
      Util.a();
      if (var1.equals(this.jobs.get(var2))) {
         this.jobs.remove(var2);
      }
   }

   @Override
   public void onEngineJobComplete(Key var1, EngineResource<?> var2) {
      Util.a();
      if (var2 != null) {
         var2.setResourceListener(var1, this);
         if (var2.isCacheable()) {
            this.activeResources.put(var1, new Engine.ResourceWeakReference(var1, var2, this.getReferenceQueue()));
         }
      }

      this.jobs.remove(var1);
   }

   @Override
   public void onResourceReleased(Key var1, EngineResource var2) {
      Util.a();
      this.activeResources.remove(var1);
      if (var2.isCacheable()) {
         this.cache.put(var1, var2);
      } else {
         this.resourceRecycler.recycle(var2);
      }
   }

   @Override
   public void onResourceRemoved(Resource<?> var1) {
      Util.a();
      this.resourceRecycler.recycle(var1);
   }

   public void release(Resource var1) {
      Util.a();
      if (var1 instanceof EngineResource) {
         ((EngineResource)var1).release();
      } else {
         throw new IllegalArgumentException("Cannot release anything but an EngineResource");
      }
   }

   static class EngineJobFactory {
      private final ExecutorService diskCacheService;
      private final EngineJobListener listener;
      private final ExecutorService sourceService;

      public EngineJobFactory(ExecutorService var1, ExecutorService var2, EngineJobListener var3) {
         this.diskCacheService = var1;
         this.sourceService = var2;
         this.listener = var3;
      }

      public EngineJob build(Key var1, boolean var2) {
         return new EngineJob(var1, this.diskCacheService, this.sourceService, var2, this.listener);
      }
   }

   private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
      private volatile DiskCache diskCache;
      private final DiskCache.Factory factory;

      public LazyDiskCacheProvider(DiskCache.Factory var1) {
         this.factory = var1;
      }

      @Override
      public DiskCache getDiskCache() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 04: ifnonnull 33
         // 07: aload 0
         // 08: monitorenter
         // 09: aload 0
         // 0a: getfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 0d: ifnonnull 1d
         // 10: aload 0
         // 11: aload 0
         // 12: getfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.factory Lcom/bumptech/glide/load/engine/cache/DiskCache$Factory;
         // 15: invokeinterface com/bumptech/glide/load/engine/cache/DiskCache$Factory.build ()Lcom/bumptech/glide/load/engine/cache/DiskCache; 1
         // 1a: putfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 1d: aload 0
         // 1e: getfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 21: ifnonnull 31
         // 24: new com/bumptech/glide/load/engine/cache/DiskCacheAdapter
         // 27: astore 1
         // 28: aload 1
         // 29: invokespecial com/bumptech/glide/load/engine/cache/DiskCacheAdapter.<init> ()V
         // 2c: aload 0
         // 2d: aload 1
         // 2e: putfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 31: aload 0
         // 32: monitorexit
         // 33: aload 0
         // 34: getfield com/bumptech/glide/load/engine/Engine$LazyDiskCacheProvider.diskCache Lcom/bumptech/glide/load/engine/cache/DiskCache;
         // 37: areturn
         // 38: astore 1
         // 39: aload 0
         // 3a: monitorexit
         // 3b: aload 1
         // 3c: athrow
         // try (5 -> 13): 28 null
         // try (13 -> 23): 28 null
         // try (23 -> 25): 28 null
         // try (29 -> 31): 28 null
      }
   }

   public static class LoadStatus {
      private final ResourceCallback cb;
      private final EngineJob engineJob;

      public LoadStatus(ResourceCallback var1, EngineJob var2) {
         this.cb = var1;
         this.engineJob = var2;
      }

      public void cancel() {
         this.engineJob.removeCallback(this.cb);
      }
   }

   private static class RefQueueIdleHandler implements IdleHandler {
      private final Map<Key, WeakReference<EngineResource<?>>> activeResources;
      private final ReferenceQueue<EngineResource<?>> queue;

      public RefQueueIdleHandler(Map<Key, WeakReference<EngineResource<?>>> var1, ReferenceQueue<EngineResource<?>> var2) {
         this.activeResources = var1;
         this.queue = var2;
      }

      public boolean queueIdle() {
         Engine.ResourceWeakReference var1 = (Engine.ResourceWeakReference)this.queue.poll();
         if (var1 != null) {
            this.activeResources.remove(var1.key);
         }

         return true;
      }
   }

   private static class ResourceWeakReference extends WeakReference<EngineResource<?>> {
      private final Key key;

      public ResourceWeakReference(Key var1, EngineResource<?> var2, ReferenceQueue<? super EngineResource<?>> var3) {
         super(var2, var3);
         this.key = var1;
      }
   }
}
