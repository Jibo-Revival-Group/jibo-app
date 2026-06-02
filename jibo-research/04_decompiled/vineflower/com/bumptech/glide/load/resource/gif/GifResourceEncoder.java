package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.IOException;
import java.io.OutputStream;

public class GifResourceEncoder implements ResourceEncoder<GifDrawable> {
   private static final GifResourceEncoder.Factory FACTORY = new GifResourceEncoder.Factory();
   private final BitmapPool bitmapPool;
   private final GifResourceEncoder.Factory factory;
   private final GifDecoder.BitmapProvider provider;

   public GifResourceEncoder(BitmapPool var1) {
      this(var1, FACTORY);
   }

   GifResourceEncoder(BitmapPool var1, GifResourceEncoder.Factory var2) {
      this.bitmapPool = var1;
      this.provider = new GifBitmapProvider(var1);
      this.factory = var2;
   }

   private GifDecoder decodeHeaders(byte[] var1) {
      GifHeaderParser var2 = this.factory.a();
      var2.a(var1);
      GifHeader var3 = var2.b();
      GifDecoder var4 = this.factory.a(this.provider);
      var4.a(var3, var1);
      var4.a();
      return var4;
   }

   private Resource<Bitmap> getTransformedFrame(Bitmap var1, Transformation<Bitmap> var2, GifDrawable var3) {
      Resource var4 = this.factory.a(var1, this.bitmapPool);
      Resource var5 = var2.transform(var4, var3.getIntrinsicWidth(), var3.getIntrinsicHeight());
      if (!var4.equals(var5)) {
         var4.recycle();
      }

      return var5;
   }

   private boolean writeDataDirect(byte[] var1, OutputStream var2) {
      boolean var3 = true;

      try {
         var2.write(var1);
      } catch (IOException var4) {
         if (Log.isLoggable("GifEncoder", 3)) {
            Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", var4);
         }

         var3 = false;
      }

      return var3;
   }

   public boolean encode(Resource<GifDrawable> param1, OutputStream param2) {
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
      // 000: bipush 0
      // 001: istore 5
      // 003: invokestatic com/bumptech/glide/util/LogTime.a ()J
      // 006: lstore 6
      // 008: aload 1
      // 009: invokeinterface com/bumptech/glide/load/engine/Resource.get ()Ljava/lang/Object; 1
      // 00e: checkcast com/bumptech/glide/load/resource/gif/GifDrawable
      // 011: astore 8
      // 013: aload 8
      // 015: invokevirtual com/bumptech/glide/load/resource/gif/GifDrawable.getFrameTransformation ()Lcom/bumptech/glide/load/Transformation;
      // 018: astore 9
      // 01a: aload 9
      // 01c: instanceof com/bumptech/glide/load/resource/UnitTransformation
      // 01f: ifeq 031
      // 022: aload 0
      // 023: aload 8
      // 025: invokevirtual com/bumptech/glide/load/resource/gif/GifDrawable.getData ()[B
      // 028: aload 2
      // 029: invokespecial com/bumptech/glide/load/resource/gif/GifResourceEncoder.writeDataDirect ([BLjava/io/OutputStream;)Z
      // 02c: istore 4
      // 02e: iload 4
      // 030: ireturn
      // 031: aload 0
      // 032: aload 8
      // 034: invokevirtual com/bumptech/glide/load/resource/gif/GifDrawable.getData ()[B
      // 037: invokespecial com/bumptech/glide/load/resource/gif/GifResourceEncoder.decodeHeaders ([B)Lcom/bumptech/glide/gifdecoder/GifDecoder;
      // 03a: astore 1
      // 03b: aload 0
      // 03c: getfield com/bumptech/glide/load/resource/gif/GifResourceEncoder.factory Lcom/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory;
      // 03f: invokevirtual com/bumptech/glide/load/resource/gif/GifResourceEncoder$Factory.b ()Lcom/bumptech/glide/gifencoder/AnimatedGifEncoder;
      // 042: astore 10
      // 044: iload 5
      // 046: istore 4
      // 048: aload 10
      // 04a: aload 2
      // 04b: invokevirtual com/bumptech/glide/gifencoder/AnimatedGifEncoder.a (Ljava/io/OutputStream;)Z
      // 04e: ifeq 02e
      // 051: bipush 0
      // 052: istore 3
      // 053: iload 3
      // 054: aload 1
      // 055: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.c ()I
      // 058: if_icmpge 0b0
      // 05b: aload 0
      // 05c: aload 1
      // 05d: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.f ()Landroid/graphics/Bitmap;
      // 060: aload 9
      // 062: aload 8
      // 064: invokespecial com/bumptech/glide/load/resource/gif/GifResourceEncoder.getTransformedFrame (Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/Transformation;Lcom/bumptech/glide/load/resource/gif/GifDrawable;)Lcom/bumptech/glide/load/engine/Resource;
      // 067: astore 2
      // 068: aload 10
      // 06a: aload 2
      // 06b: invokeinterface com/bumptech/glide/load/engine/Resource.get ()Ljava/lang/Object; 1
      // 070: checkcast android/graphics/Bitmap
      // 073: invokevirtual com/bumptech/glide/gifencoder/AnimatedGifEncoder.a (Landroid/graphics/Bitmap;)Z
      // 076: istore 4
      // 078: iload 4
      // 07a: ifne 08a
      // 07d: aload 2
      // 07e: invokeinterface com/bumptech/glide/load/engine/Resource.recycle ()V 1
      // 083: iload 5
      // 085: istore 4
      // 087: goto 02e
      // 08a: aload 10
      // 08c: aload 1
      // 08d: aload 1
      // 08e: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.d ()I
      // 091: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.a (I)I
      // 094: invokevirtual com/bumptech/glide/gifencoder/AnimatedGifEncoder.a (I)V
      // 097: aload 1
      // 098: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.a ()V
      // 09b: aload 2
      // 09c: invokeinterface com/bumptech/glide/load/engine/Resource.recycle ()V 1
      // 0a1: iinc 3 1
      // 0a4: goto 053
      // 0a7: astore 1
      // 0a8: aload 2
      // 0a9: invokeinterface com/bumptech/glide/load/engine/Resource.recycle ()V 1
      // 0ae: aload 1
      // 0af: athrow
      // 0b0: aload 10
      // 0b2: invokevirtual com/bumptech/glide/gifencoder/AnimatedGifEncoder.a ()Z
      // 0b5: istore 5
      // 0b7: iload 5
      // 0b9: istore 4
      // 0bb: ldc "GifEncoder"
      // 0bd: bipush 2
      // 0be: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0c1: ifeq 02e
      // 0c4: ldc "GifEncoder"
      // 0c6: new java/lang/StringBuilder
      // 0c9: dup
      // 0ca: invokespecial java/lang/StringBuilder.<init> ()V
      // 0cd: ldc "Encoded gif with "
      // 0cf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d2: aload 1
      // 0d3: invokevirtual com/bumptech/glide/gifdecoder/GifDecoder.c ()I
      // 0d6: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0d9: ldc " frames and "
      // 0db: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0de: aload 8
      // 0e0: invokevirtual com/bumptech/glide/load/resource/gif/GifDrawable.getData ()[B
      // 0e3: arraylength
      // 0e4: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0e7: ldc " bytes in "
      // 0e9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ec: lload 6
      // 0ee: invokestatic com/bumptech/glide/util/LogTime.a (J)D
      // 0f1: invokevirtual java/lang/StringBuilder.append (D)Ljava/lang/StringBuilder;
      // 0f4: ldc " ms"
      // 0f6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0fc: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0ff: pop
      // 100: iload 5
      // 102: istore 4
      // 104: goto 02e
      // try (50 -> 56): 75 null
      // try (63 -> 71): 75 null
   }

   @Override
   public String getId() {
      return "";
   }

   static class Factory {
      public GifDecoder a(GifDecoder.BitmapProvider var1) {
         return new GifDecoder(var1);
      }

      public GifHeaderParser a() {
         return new GifHeaderParser();
      }

      public Resource<Bitmap> a(Bitmap var1, BitmapPool var2) {
         return new BitmapResource(var1, var2);
      }

      public AnimatedGifEncoder b() {
         return new AnimatedGifEncoder();
      }
   }
}
