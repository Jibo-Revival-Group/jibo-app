package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class GifResourceDecoder implements ResourceDecoder<InputStream, GifDrawable> {
   private static final GifResourceDecoder.GifDecoderPool DECODER_POOL = new GifResourceDecoder.GifDecoderPool();
   private static final GifResourceDecoder.GifHeaderParserPool PARSER_POOL = new GifResourceDecoder.GifHeaderParserPool();
   private final BitmapPool bitmapPool;
   private final Context context;
   private final GifResourceDecoder.GifDecoderPool decoderPool;
   private final GifResourceDecoder.GifHeaderParserPool parserPool;
   private final GifBitmapProvider provider;

   public GifResourceDecoder(Context var1, BitmapPool var2) {
      this(var1, var2, PARSER_POOL, DECODER_POOL);
   }

   GifResourceDecoder(Context var1, BitmapPool var2, GifResourceDecoder.GifHeaderParserPool var3, GifResourceDecoder.GifDecoderPool var4) {
      this.context = var1;
      this.bitmapPool = var2;
      this.decoderPool = var4;
      this.provider = new GifBitmapProvider(var2);
      this.parserPool = var3;
   }

   private GifDrawableResource decode(byte[] var1, int var2, int var3, GifHeaderParser var4, GifDecoder var5) {
      Object var6 = null;
      GifHeader var7 = var4.b();
      GifDrawableResource var8 = (GifDrawableResource)var6;
      if (var7.a() > 0) {
         if (var7.b() != 0) {
            var8 = (GifDrawableResource)var6;
         } else {
            Bitmap var10 = this.decodeFirstFrame(var5, var7, var1);
            var8 = (GifDrawableResource)var6;
            if (var10 != null) {
               UnitTransformation var9 = UnitTransformation.get();
               var8 = new GifDrawableResource(new GifDrawable(this.context, this.provider, this.bitmapPool, var9, var2, var3, var7, var1, var10));
            }
         }
      }

      return var8;
   }

   private Bitmap decodeFirstFrame(GifDecoder var1, GifHeader var2, byte[] var3) {
      var1.a(var2, var3);
      var1.a();
      return var1.f();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static byte[] inputStreamToBytes(InputStream var0) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream(16384);

      byte[] var3;
      try {
         var3 = new byte[16384];
      } catch (IOException var7) {
         Log.w("GifResourceDecoder", "Error reading data from stream", var7);
         return var2.toByteArray();
      }

      while (true) {
         int var1;
         try {
            var1 = var0.read(var3);
         } catch (IOException var5) {
            Log.w("GifResourceDecoder", "Error reading data from stream", var5);
            break;
         }

         if (var1 == -1) {
            try {
               var2.flush();
            } catch (IOException var4) {
               Log.w("GifResourceDecoder", "Error reading data from stream", var4);
            }
            break;
         }

         try {
            var2.write(var3, 0, var1);
         } catch (IOException var6) {
            Log.w("GifResourceDecoder", "Error reading data from stream", var6);
            break;
         }
      }

      return var2.toByteArray();
   }

   public GifDrawableResource decode(InputStream var1, int var2, int var3) {
      byte[] var5 = inputStreamToBytes(var1);
      GifHeaderParser var4 = this.parserPool.obtain(var5);
      GifDecoder var8 = this.decoderPool.obtain(this.provider);

      try {
         return this.decode(var5, var2, var3, var4, var8);
      } finally {
         this.parserPool.release(var4);
         this.decoderPool.release(var8);
      }
   }

   @Override
   public String getId() {
      return "";
   }

   static class GifDecoderPool {
      private final Queue<GifDecoder> pool = Util.a(0);

      public GifDecoder obtain(GifDecoder.BitmapProvider param1) {
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
         // 00: aload 0
         // 01: monitorenter
         // 02: aload 0
         // 03: getfield com/bumptech/glide/load/resource/gif/GifResourceDecoder$GifDecoderPool.pool Ljava/util/Queue;
         // 06: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
         // 0b: checkcast com/bumptech/glide/gifdecoder/GifDecoder
         // 0e: astore 3
         // 0f: aload 3
         // 10: astore 2
         // 11: aload 3
         // 12: ifnonnull 1e
         // 15: new com/bumptech/glide/gifdecoder/GifDecoder
         // 18: dup
         // 19: aload 1
         // 1a: invokespecial com/bumptech/glide/gifdecoder/GifDecoder.<init> (Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;)V
         // 1d: astore 2
         // 1e: aload 0
         // 1f: monitorexit
         // 20: aload 2
         // 21: areturn
         // 22: astore 1
         // 23: aload 0
         // 24: monitorexit
         // 25: aload 1
         // 26: athrow
         // try (2 -> 7): 20 null
         // try (11 -> 16): 20 null
      }

      public void release(GifDecoder var1) {
         synchronized (this) {
            var1.g();
            this.pool.offer(var1);
         }
      }
   }

   static class GifHeaderParserPool {
      private final Queue<GifHeaderParser> pool = Util.a(0);

      public GifHeaderParser obtain(byte[] param1) {
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
         // 00: aload 0
         // 01: monitorenter
         // 02: aload 0
         // 03: getfield com/bumptech/glide/load/resource/gif/GifResourceDecoder$GifHeaderParserPool.pool Ljava/util/Queue;
         // 06: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
         // 0b: checkcast com/bumptech/glide/gifdecoder/GifHeaderParser
         // 0e: astore 3
         // 0f: aload 3
         // 10: astore 2
         // 11: aload 3
         // 12: ifnonnull 1d
         // 15: new com/bumptech/glide/gifdecoder/GifHeaderParser
         // 18: astore 2
         // 19: aload 2
         // 1a: invokespecial com/bumptech/glide/gifdecoder/GifHeaderParser.<init> ()V
         // 1d: aload 2
         // 1e: aload 1
         // 1f: invokevirtual com/bumptech/glide/gifdecoder/GifHeaderParser.a ([B)Lcom/bumptech/glide/gifdecoder/GifHeaderParser;
         // 22: astore 1
         // 23: aload 0
         // 24: monitorexit
         // 25: aload 1
         // 26: areturn
         // 27: astore 1
         // 28: aload 0
         // 29: monitorexit
         // 2a: aload 1
         // 2b: athrow
         // try (2 -> 7): 23 null
         // try (11 -> 15): 23 null
         // try (15 -> 19): 23 null
      }

      public void release(GifHeaderParser var1) {
         synchronized (this) {
            var1.a();
            this.pool.offer(var1);
         }
      }
   }
}
