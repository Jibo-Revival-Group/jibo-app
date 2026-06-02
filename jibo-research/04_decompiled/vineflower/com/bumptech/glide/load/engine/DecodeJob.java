package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.util.LogTime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DecodeJob<A, T, Z> {
   private static final DecodeJob.FileOpener DEFAULT_FILE_OPENER = new DecodeJob.FileOpener();
   private final DecodeJob.DiskCacheProvider diskCacheProvider;
   private final DiskCacheStrategy diskCacheStrategy;
   private final DataFetcher<A> fetcher;
   private final DecodeJob.FileOpener fileOpener;
   private final int height;
   private volatile boolean isCancelled;
   private final DataLoadProvider<A, T> loadProvider;
   private final Priority priority;
   private final EngineKey resultKey;
   private final ResourceTranscoder<T, Z> transcoder;
   private final Transformation<T> transformation;
   private final int width;

   public DecodeJob(
      EngineKey var1,
      int var2,
      int var3,
      DataFetcher<A> var4,
      DataLoadProvider<A, T> var5,
      Transformation<T> var6,
      ResourceTranscoder<T, Z> var7,
      DecodeJob.DiskCacheProvider var8,
      DiskCacheStrategy var9,
      Priority var10
   ) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, DEFAULT_FILE_OPENER);
   }

   DecodeJob(
      EngineKey var1,
      int var2,
      int var3,
      DataFetcher<A> var4,
      DataLoadProvider<A, T> var5,
      Transformation<T> var6,
      ResourceTranscoder<T, Z> var7,
      DecodeJob.DiskCacheProvider var8,
      DiskCacheStrategy var9,
      Priority var10,
      DecodeJob.FileOpener var11
   ) {
      this.resultKey = var1;
      this.width = var2;
      this.height = var3;
      this.fetcher = var4;
      this.loadProvider = var5;
      this.transformation = var6;
      this.transcoder = var7;
      this.diskCacheProvider = var8;
      this.diskCacheStrategy = var9;
      this.priority = var10;
      this.fileOpener = var11;
   }

   private Resource<T> cacheAndDecodeSourceData(A var1) throws IOException {
      long var2 = LogTime.a();
      var1 = new DecodeJob.SourceWriter<>(this, this.loadProvider.getSourceEncoder(), var1);
      this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), var1);
      if (Log.isLoggable("DecodeJob", 2)) {
         this.logWithTimeAndKey("Wrote source to cache", var2);
      }

      var2 = LogTime.a();
      Resource var5 = this.loadFromCache(this.resultKey.getOriginalKey());
      if (Log.isLoggable("DecodeJob", 2) && var5 != null) {
         this.logWithTimeAndKey("Decoded source from cache", var2);
      }

      return var5;
   }

   private Resource<T> decodeFromSourceData(A var1) throws IOException {
      if (this.diskCacheStrategy.cacheSource()) {
         var1 = this.cacheAndDecodeSourceData((A)var1);
      } else {
         long var2 = LogTime.a();
         Resource var4 = this.loadProvider.getSourceDecoder().decode((A)var1, this.width, this.height);
         var1 = var4;
         if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Decoded from source", var2);
            var1 = var4;
         }
      }

      return var1;
   }

   private Resource<T> decodeSource() throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: invokestatic com/bumptech/glide/util/LogTime.a ()J
      // 03: lstore 1
      // 04: aload 0
      // 05: getfield com/bumptech/glide/load/engine/DecodeJob.fetcher Lcom/bumptech/glide/load/data/DataFetcher;
      // 08: aload 0
      // 09: getfield com/bumptech/glide/load/engine/DecodeJob.priority Lcom/bumptech/glide/Priority;
      // 0c: invokeinterface com/bumptech/glide/load/data/DataFetcher.loadData (Lcom/bumptech/glide/Priority;)Ljava/lang/Object; 2
      // 11: astore 4
      // 13: ldc "DecodeJob"
      // 15: bipush 2
      // 16: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 19: ifeq 23
      // 1c: aload 0
      // 1d: ldc "Fetched data"
      // 1f: lload 1
      // 20: invokespecial com/bumptech/glide/load/engine/DecodeJob.logWithTimeAndKey (Ljava/lang/String;J)V
      // 23: aload 0
      // 24: getfield com/bumptech/glide/load/engine/DecodeJob.isCancelled Z
      // 27: istore 3
      // 28: iload 3
      // 29: ifeq 3b
      // 2c: aconst_null
      // 2d: astore 4
      // 2f: aload 0
      // 30: getfield com/bumptech/glide/load/engine/DecodeJob.fetcher Lcom/bumptech/glide/load/data/DataFetcher;
      // 33: invokeinterface com/bumptech/glide/load/data/DataFetcher.cleanup ()V 1
      // 38: aload 4
      // 3a: areturn
      // 3b: aload 0
      // 3c: aload 4
      // 3e: invokespecial com/bumptech/glide/load/engine/DecodeJob.decodeFromSourceData (Ljava/lang/Object;)Lcom/bumptech/glide/load/engine/Resource;
      // 41: astore 4
      // 43: aload 0
      // 44: getfield com/bumptech/glide/load/engine/DecodeJob.fetcher Lcom/bumptech/glide/load/data/DataFetcher;
      // 47: invokeinterface com/bumptech/glide/load/data/DataFetcher.cleanup ()V 1
      // 4c: goto 38
      // 4f: astore 4
      // 51: aload 0
      // 52: getfield com/bumptech/glide/load/engine/DecodeJob.fetcher Lcom/bumptech/glide/load/data/DataFetcher;
      // 55: invokeinterface com/bumptech/glide/load/data/DataFetcher.cleanup ()V 1
      // 5a: aload 4
      // 5c: athrow
      // try (0 -> 16): 36 null
      // try (16 -> 19): 36 null
      // try (28 -> 32): 36 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private Resource<T> loadFromCache(Key var1) throws IOException {
      Resource var3 = null;
      Resource var2 = this.diskCacheProvider.getDiskCache().get(var1);
      if (var2 != null) {
         boolean var5 = false /* VF: Semaphore variable */;

         try {
            var5 = true;
            var2 = this.loadProvider.getCacheDecoder().decode(var2, this.width, this.height);
            var5 = false;
         } finally {
            if (var5) {
               if (true) {
                  this.diskCacheProvider.getDiskCache().delete(var1);
               }
            }
         }

         var3 = var2;
         if (var2 == null) {
            this.diskCacheProvider.getDiskCache().delete(var1);
            var3 = var2;
         }
      }

      return var3;
   }

   private void logWithTimeAndKey(String var1, long var2) {
      Log.v("DecodeJob", var1 + " in " + LogTime.a(var2) + ", key: " + this.resultKey);
   }

   private Resource<Z> transcode(Resource<T> var1) {
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = this.transcoder.transcode(var1);
      }

      return var1;
   }

   private Resource<T> transform(Resource<T> var1) {
      Resource var2;
      if (var1 == null) {
         var2 = null;
      } else {
         Resource var3 = this.transformation.transform(var1, this.width, this.height);
         var2 = var3;
         if (!var1.equals(var3)) {
            var1.recycle();
            var2 = var3;
         }
      }

      return var2;
   }

   private Resource<Z> transformEncodeAndTranscode(Resource<T> var1) {
      long var2 = LogTime.a();
      var1 = this.transform(var1);
      if (Log.isLoggable("DecodeJob", 2)) {
         this.logWithTimeAndKey("Transformed resource from source", var2);
      }

      this.writeTransformedToCache(var1);
      var2 = LogTime.a();
      var1 = this.transcode(var1);
      if (Log.isLoggable("DecodeJob", 2)) {
         this.logWithTimeAndKey("Transcoded transformed from source", var2);
      }

      return var1;
   }

   private void writeTransformedToCache(Resource<T> var1) {
      if (var1 != null && this.diskCacheStrategy.cacheResult()) {
         long var2 = LogTime.a();
         DecodeJob.SourceWriter var4 = new DecodeJob.SourceWriter<>(this, this.loadProvider.getEncoder(), var1);
         this.diskCacheProvider.getDiskCache().put(this.resultKey, var4);
         if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Wrote transformed from source to cache", var2);
         }
      }
   }

   public void cancel() {
      this.isCancelled = true;
      this.fetcher.cancel();
   }

   public Resource<Z> decodeFromSource() throws Exception {
      return this.transformEncodeAndTranscode(this.decodeSource());
   }

   public Resource<Z> decodeResultFromCache() throws Exception {
      Resource var3;
      if (!this.diskCacheStrategy.cacheResult()) {
         var3 = null;
      } else {
         long var1 = LogTime.a();
         var3 = this.loadFromCache(this.resultKey);
         if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Decoded transformed from cache", var1);
         }

         var1 = LogTime.a();
         Resource var4 = this.transcode(var3);
         var3 = var4;
         if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Transcoded transformed from cache", var1);
            var3 = var4;
         }
      }

      return var3;
   }

   public Resource<Z> decodeSourceFromCache() throws Exception {
      Resource var3;
      if (!this.diskCacheStrategy.cacheSource()) {
         var3 = null;
      } else {
         long var1 = LogTime.a();
         var3 = this.loadFromCache(this.resultKey.getOriginalKey());
         if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Decoded source from cache", var1);
         }

         var3 = this.transformEncodeAndTranscode(var3);
      }

      return var3;
   }

   interface DiskCacheProvider {
      DiskCache getDiskCache();
   }

   static class FileOpener {
      public OutputStream a(File var1) throws FileNotFoundException {
         return new BufferedOutputStream(new FileOutputStream(var1));
      }
   }

   class SourceWriter<DataType> implements DiskCache.Writer {
      private final DataType data;
      private final Encoder<DataType> encoder;
      final DecodeJob this$0;

      public SourceWriter(DecodeJob var1, DataType var2, Object var3) {
         this.this$0 = var1;
         this.encoder = var2;
         this.data = (DataType)var3;
      }

      @Override
      public boolean write(File param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: bipush 0
         // 01: istore 3
         // 02: aconst_null
         // 03: astore 5
         // 05: aconst_null
         // 06: astore 4
         // 08: aload 0
         // 09: getfield com/bumptech/glide/load/engine/DecodeJob$SourceWriter.this$0 Lcom/bumptech/glide/load/engine/DecodeJob;
         // 0c: invokestatic com/bumptech/glide/load/engine/DecodeJob.access$000 (Lcom/bumptech/glide/load/engine/DecodeJob;)Lcom/bumptech/glide/load/engine/DecodeJob$FileOpener;
         // 0f: aload 1
         // 10: invokevirtual com/bumptech/glide/load/engine/DecodeJob$FileOpener.a (Ljava/io/File;)Ljava/io/OutputStream;
         // 13: astore 1
         // 14: aload 1
         // 15: astore 4
         // 17: aload 1
         // 18: astore 5
         // 1a: aload 0
         // 1b: getfield com/bumptech/glide/load/engine/DecodeJob$SourceWriter.encoder Lcom/bumptech/glide/load/Encoder;
         // 1e: aload 0
         // 1f: getfield com/bumptech/glide/load/engine/DecodeJob$SourceWriter.data Ljava/lang/Object;
         // 22: aload 1
         // 23: invokeinterface com/bumptech/glide/load/Encoder.encode (Ljava/lang/Object;Ljava/io/OutputStream;)Z 3
         // 28: istore 2
         // 29: iload 2
         // 2a: istore 3
         // 2b: iload 3
         // 2c: istore 2
         // 2d: aload 1
         // 2e: ifnull 37
         // 31: aload 1
         // 32: invokevirtual java/io/OutputStream.close ()V
         // 35: iload 3
         // 36: istore 2
         // 37: iload 2
         // 38: ireturn
         // 39: astore 1
         // 3a: aload 4
         // 3c: astore 5
         // 3e: ldc "DecodeJob"
         // 40: bipush 3
         // 41: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
         // 44: ifeq 54
         // 47: aload 4
         // 49: astore 5
         // 4b: ldc "DecodeJob"
         // 4d: ldc "Failed to find file to write to disk cache"
         // 4f: aload 1
         // 50: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 53: pop
         // 54: iload 3
         // 55: istore 2
         // 56: aload 4
         // 58: ifnull 37
         // 5b: aload 4
         // 5d: invokevirtual java/io/OutputStream.close ()V
         // 60: iload 3
         // 61: istore 2
         // 62: goto 37
         // 65: astore 1
         // 66: iload 3
         // 67: istore 2
         // 68: goto 37
         // 6b: astore 1
         // 6c: aload 5
         // 6e: ifnull 76
         // 71: aload 5
         // 73: invokevirtual java/io/OutputStream.close ()V
         // 76: aload 1
         // 77: athrow
         // 78: astore 1
         // 79: iload 3
         // 7a: istore 2
         // 7b: goto 37
         // 7e: astore 4
         // 80: goto 76
         // try (6 -> 12): 35 java/io/FileNotFoundException
         // try (6 -> 12): 62 null
         // try (16 -> 23): 35 java/io/FileNotFoundException
         // try (16 -> 23): 62 null
         // try (29 -> 31): 69 java/io/IOException
         // try (38 -> 42): 62 null
         // try (44 -> 49): 62 null
         // try (53 -> 55): 58 java/io/IOException
         // try (65 -> 67): 73 java/io/IOException
      }
   }
}
