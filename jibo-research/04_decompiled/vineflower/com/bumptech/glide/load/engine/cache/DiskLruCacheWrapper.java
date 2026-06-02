package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
   private static DiskLruCacheWrapper wrapper = null;
   private final File directory;
   private DiskLruCache diskLruCache;
   private final int maxSize;
   private final SafeKeyGenerator safeKeyGenerator;
   private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

   protected DiskLruCacheWrapper(File var1, int var2) {
      this.directory = var1;
      this.maxSize = var2;
      this.safeKeyGenerator = new SafeKeyGenerator();
   }

   public static DiskCache get(File var0, int var1) {
      synchronized (DiskLruCacheWrapper.class) {
         if (wrapper == null) {
            DiskLruCacheWrapper var2 = new DiskLruCacheWrapper(var0, var1);
            wrapper = var2;
         }

         return wrapper;
      }
   }

   private DiskLruCache getDiskCache() throws IOException {
      synchronized (this) {
         if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.a(this.directory, 1, 1, this.maxSize);
         }

         return this.diskLruCache;
      }
   }

   @Override
   public void delete(Key var1) {
      String var3 = this.safeKeyGenerator.getSafeKey(var1);

      try {
         this.getDiskCache().c(var3);
      } catch (IOException var2) {
         if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
            Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", var2);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public File get(Key var1) {
      String var6 = this.safeKeyGenerator.getSafeKey(var1);
      Object var2 = null;

      IOException var3;
      label29: {
         try {
            var8 = this.getDiskCache().a(var6);
         } catch (IOException var5) {
            var3 = var5;
            Object var7 = var2;
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
               return (File)var7;
            }
            break label29;
         }

         File var9 = (File)var2;
         if (var8 == null) {
            return var9;
         }

         try {
            var9 = var8.a(0);
            return var9;
         } catch (IOException var4) {
            var3 = var4;
            var9 = (File)var2;
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
               return var9;
            }
         }
      }

      Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", var3);
      return (File)var2;
   }

   @Override
   public void put(Key param1, DiskCache.Writer param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.safeKeyGenerator Lcom/bumptech/glide/load/engine/cache/SafeKeyGenerator;
      // 04: aload 1
      // 05: invokevirtual com/bumptech/glide/load/engine/cache/SafeKeyGenerator.getSafeKey (Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
      // 08: astore 3
      // 09: aload 0
      // 0a: getfield com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.writeLocker Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
      // 0d: aload 1
      // 0e: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.acquire (Lcom/bumptech/glide/load/Key;)V
      // 11: aload 0
      // 12: invokespecial com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.getDiskCache ()Lcom/bumptech/glide/disklrucache/DiskLruCache;
      // 15: aload 3
      // 16: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache.b (Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
      // 19: astore 3
      // 1a: aload 3
      // 1b: ifnull 34
      // 1e: aload 2
      // 1f: aload 3
      // 20: bipush 0
      // 21: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a (I)Ljava/io/File;
      // 24: invokeinterface com/bumptech/glide/load/engine/cache/DiskCache$Writer.write (Ljava/io/File;)Z 2
      // 29: ifeq 30
      // 2c: aload 3
      // 2d: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.a ()V
      // 30: aload 3
      // 31: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 34: aload 0
      // 35: getfield com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.writeLocker Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
      // 38: aload 1
      // 39: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.release (Lcom/bumptech/glide/load/Key;)V
      // 3c: return
      // 3d: astore 2
      // 3e: aload 3
      // 3f: invokevirtual com/bumptech/glide/disklrucache/DiskLruCache$Editor.c ()V
      // 42: aload 2
      // 43: athrow
      // 44: astore 2
      // 45: ldc "DiskLruCacheWrapper"
      // 47: bipush 5
      // 48: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 4b: ifeq 57
      // 4e: ldc "DiskLruCacheWrapper"
      // 50: ldc "Unable to put to disk cache"
      // 52: aload 2
      // 53: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 56: pop
      // 57: aload 0
      // 58: getfield com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.writeLocker Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
      // 5b: aload 1
      // 5c: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.release (Lcom/bumptech/glide/load/Key;)V
      // 5f: goto 3c
      // 62: astore 2
      // 63: aload 0
      // 64: getfield com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper.writeLocker Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
      // 67: aload 1
      // 68: invokevirtual com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.release (Lcom/bumptech/glide/load/Key;)V
      // 6b: aload 2
      // 6c: athrow
      // try (9 -> 14): 36 java/io/IOException
      // try (9 -> 14): 51 null
      // try (16 -> 24): 31 null
      // try (24 -> 26): 36 java/io/IOException
      // try (24 -> 26): 51 null
      // try (32 -> 36): 36 java/io/IOException
      // try (32 -> 36): 51 null
      // try (37 -> 46): 51 null
   }
}
