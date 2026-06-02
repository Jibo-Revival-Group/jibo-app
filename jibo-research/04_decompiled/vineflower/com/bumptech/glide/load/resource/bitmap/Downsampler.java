package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class Downsampler implements BitmapDecoder<InputStream> {
   public static final Downsampler AT_LEAST = new Downsampler() {
      @Override
      public String getId() {
         return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
      }

      @Override
      protected int getSampleSize(int var1, int var2, int var3, int var4) {
         return Math.min(var2 / var4, var1 / var3);
      }
   };
   public static final Downsampler AT_MOST = new Downsampler() {
      @Override
      public String getId() {
         return "AT_MOST.com.bumptech.glide.load.data.bitmap";
      }

      @Override
      protected int getSampleSize(int var1, int var2, int var3, int var4) {
         byte var5 = 1;
         var1 = (int)Math.ceil(Math.max((float)var2 / var4, (float)var1 / var3));
         var2 = Math.max(1, Integer.highestOneBit(var1));
         byte var7;
         if (var2 < var1) {
            var7 = var5;
         } else {
            var7 = 0;
         }

         return var2 << var7;
      }
   };
   public static final Downsampler NONE = new Downsampler() {
      @Override
      public String getId() {
         return "NONE.com.bumptech.glide.load.data.bitmap";
      }

      @Override
      protected int getSampleSize(int var1, int var2, int var3, int var4) {
         return 0;
      }
   };
   private static final Queue<Options> OPTIONS_QUEUE = Util.a(0);
   private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(
      ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG
   );

   private static Bitmap decodeStream(MarkEnforcingInputStream var0, RecyclableBufferedInputStream var1, Options var2) {
      if (var2.inJustDecodeBounds) {
         var0.mark(5242880);
      } else {
         var1.fixMarkLimit();
      }

      Bitmap var4 = BitmapFactory.decodeStream(var0, null, var2);

      try {
         if (var2.inJustDecodeBounds) {
            var0.reset();
         }
      } catch (IOException var3) {
         if (Log.isLoggable("Downsampler", 6)) {
            Log.e("Downsampler", "Exception loading inDecodeBounds=" + var2.inJustDecodeBounds + " sample=" + var2.inSampleSize, var3);
         }
      }

      return var4;
   }

   private Bitmap downsampleWithSize(
      MarkEnforcingInputStream var1, RecyclableBufferedInputStream var2, Options var3, BitmapPool var4, int var5, int var6, int var7, DecodeFormat var8
   ) {
      Config var9 = getConfig(var1, var8);
      var3.inSampleSize = var7;
      var3.inPreferredConfig = var9;
      if ((var3.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && shouldUsePool(var1)) {
         setInBitmap(var3, var4.getDirty((int)Math.ceil((double)var5 / var7), (int)Math.ceil((double)var6 / var7), var9));
      }

      return decodeStream(var1, var2, var3);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static Config getConfig(InputStream var0, DecodeFormat var1) {
      Config var17;
      if (var1 != DecodeFormat.ALWAYS_ARGB_8888 && var1 != DecodeFormat.PREFER_ARGB_8888 && VERSION.SDK_INT != 16) {
         var0.mark(1024);
         boolean var11 = false /* VF: Semaphore variable */;

         boolean var2;
         label117: {
            boolean var3;
            label118: {
               try {
                  var11 = true;
                  ImageHeaderParser var4 = new ImageHeaderParser(var0);
                  var3 = var4.hasAlpha();
                  var11 = false;
                  break label118;
               } catch (IOException var15) {
                  if (Log.isLoggable("Downsampler", 5)) {
                     StringBuilder var5 = new StringBuilder();
                     Log.w(
                        "Downsampler",
                        var5.append("Cannot determine whether the image has alpha or not from header for format ").append(var1).toString(),
                        var15
                     );
                     var11 = false;
                  } else {
                     var11 = false;
                  }
               } finally {
                  if (var11) {
                     try {
                        var0.reset();
                     } catch (IOException var12) {
                        if (Log.isLoggable("Downsampler", 5)) {
                           Log.w("Downsampler", "Cannot reset the input stream", var12);
                        }
                     }
                  }
               }

               try {
                  var0.reset();
               } catch (IOException var14) {
                  if (Log.isLoggable("Downsampler", 5)) {
                     Log.w("Downsampler", "Cannot reset the input stream", var14);
                  }

                  var2 = false;
                  break label117;
               }

               var2 = false;
               break label117;
            }

            try {
               var0.reset();
            } catch (IOException var13) {
               var2 = var3;
               if (Log.isLoggable("Downsampler", 5)) {
                  Log.w("Downsampler", "Cannot reset the input stream", var13);
                  var2 = var3;
               }
               break label117;
            }

            var2 = var3;
         }

         if (var2) {
            var17 = Config.ARGB_8888;
         } else {
            var17 = Config.RGB_565;
         }
      } else {
         var17 = Config.ARGB_8888;
      }

      return var17;
   }

   @TargetApi(11)
   private static Options getDefaultOptions() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
      // 02: monitorenter
      // 03: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.OPTIONS_QUEUE Ljava/util/Queue;
      // 06: astore 0
      // 07: aload 0
      // 08: monitorenter
      // 09: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.OPTIONS_QUEUE Ljava/util/Queue;
      // 0c: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 11: checkcast android/graphics/BitmapFactory$Options
      // 14: astore 1
      // 15: aload 0
      // 16: monitorexit
      // 17: aload 1
      // 18: astore 0
      // 19: aload 1
      // 1a: ifnonnull 29
      // 1d: new android/graphics/BitmapFactory$Options
      // 20: astore 0
      // 21: aload 0
      // 22: invokespecial android/graphics/BitmapFactory$Options.<init> ()V
      // 25: aload 0
      // 26: invokestatic com/bumptech/glide/load/resource/bitmap/Downsampler.resetOptions (Landroid/graphics/BitmapFactory$Options;)V
      // 29: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
      // 2b: monitorexit
      // 2c: aload 0
      // 2d: areturn
      // 2e: astore 1
      // 2f: aload 0
      // 30: monitorexit
      // 31: aload 1
      // 32: athrow
      // 33: astore 0
      // 34: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
      // 36: monitorexit
      // 37: aload 0
      // 38: athrow
      // try (2 -> 6): 31 null
      // try (6 -> 12): 26 null
      // try (16 -> 22): 31 null
      // try (27 -> 29): 26 null
      // try (29 -> 31): 31 null
   }

   private int getRoundedSampleSize(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var5;
      if (var5 == Integer.MIN_VALUE) {
         var6 = var3;
      }

      var5 = var4;
      if (var4 == Integer.MIN_VALUE) {
         var5 = var2;
      }

      if (var1 != 90 && var1 != 270) {
         var1 = this.getSampleSize(var2, var3, var5, var6);
      } else {
         var1 = this.getSampleSize(var3, var2, var5, var6);
      }

      if (var1 == 0) {
         var1 = 0;
      } else {
         var1 = Integer.highestOneBit(var1);
      }

      return Math.max(1, var1);
   }

   private static void releaseOptions(Options param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic com/bumptech/glide/load/resource/bitmap/Downsampler.resetOptions (Landroid/graphics/BitmapFactory$Options;)V
      // 04: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.OPTIONS_QUEUE Ljava/util/Queue;
      // 07: astore 1
      // 08: aload 1
      // 09: monitorenter
      // 0a: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.OPTIONS_QUEUE Ljava/util/Queue;
      // 0d: aload 0
      // 0e: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
      // 13: pop
      // 14: aload 1
      // 15: monitorexit
      // 16: return
      // 17: astore 0
      // 18: aload 1
      // 19: monitorexit
      // 1a: aload 0
      // 1b: athrow
      // try (6 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   @TargetApi(11)
   private static void resetOptions(Options var0) {
      var0.inTempStorage = null;
      var0.inDither = false;
      var0.inScaled = false;
      var0.inSampleSize = 1;
      var0.inPreferredConfig = null;
      var0.inJustDecodeBounds = false;
      var0.outWidth = 0;
      var0.outHeight = 0;
      var0.outMimeType = null;
      if (11 <= VERSION.SDK_INT) {
         var0.inBitmap = null;
         var0.inMutable = true;
      }
   }

   @TargetApi(11)
   private static void setInBitmap(Options var0, Bitmap var1) {
      if (11 <= VERSION.SDK_INT) {
         var0.inBitmap = var1;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static boolean shouldUsePool(InputStream var0) {
      boolean var1;
      if (19 <= VERSION.SDK_INT) {
         var1 = true;
      } else {
         var0.mark(1024);
         boolean var9 = false /* VF: Semaphore variable */;

         boolean var2;
         label106: {
            try {
               var9 = true;
               ImageHeaderParser var3 = new ImageHeaderParser(var0);
               ImageHeaderParser.ImageType var15 = var3.getType();
               var2 = TYPES_THAT_USE_POOL.contains(var15);
               var9 = false;
               break label106;
            } catch (IOException var13) {
               if (Log.isLoggable("Downsampler", 5)) {
                  Log.w("Downsampler", "Cannot determine the image type from header", var13);
                  var9 = false;
               } else {
                  var9 = false;
               }
            } finally {
               if (var9) {
                  try {
                     var0.reset();
                  } catch (IOException var10) {
                     if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", var10);
                     }
                  }
               }
            }

            try {
               var0.reset();
            } catch (IOException var11) {
               if (Log.isLoggable("Downsampler", 5)) {
                  Log.w("Downsampler", "Cannot reset the input stream", var11);
               }
            }

            var1 = false;
            return var1;
         }

         try {
            var0.reset();
         } catch (IOException var12) {
            var1 = var2;
            if (Log.isLoggable("Downsampler", 5)) {
               Log.w("Downsampler", "Cannot reset the input stream", var12);
               var1 = var2;
            }

            return var1;
         }

         var1 = var2;
      }

      return var1;
   }

   public Bitmap decode(InputStream param1, BitmapPool param2, int param3, int param4, DecodeFormat param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: invokestatic com/bumptech/glide/util/ByteArrayPool.a ()Lcom/bumptech/glide/util/ByteArrayPool;
      // 003: astore 10
      // 005: aload 10
      // 007: invokevirtual com/bumptech/glide/util/ByteArrayPool.b ()[B
      // 00a: astore 12
      // 00c: aload 10
      // 00e: invokevirtual com/bumptech/glide/util/ByteArrayPool.b ()[B
      // 011: astore 11
      // 013: invokestatic com/bumptech/glide/load/resource/bitmap/Downsampler.getDefaultOptions ()Landroid/graphics/BitmapFactory$Options;
      // 016: astore 9
      // 018: new com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream
      // 01b: dup
      // 01c: aload 1
      // 01d: aload 11
      // 01f: invokespecial com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.<init> (Ljava/io/InputStream;[B)V
      // 022: astore 1
      // 023: aload 1
      // 024: invokestatic com/bumptech/glide/util/ExceptionCatchingInputStream.a (Ljava/io/InputStream;)Lcom/bumptech/glide/util/ExceptionCatchingInputStream;
      // 027: astore 13
      // 029: new com/bumptech/glide/util/MarkEnforcingInputStream
      // 02c: dup
      // 02d: aload 13
      // 02f: invokespecial com/bumptech/glide/util/MarkEnforcingInputStream.<init> (Ljava/io/InputStream;)V
      // 032: astore 14
      // 034: aload 13
      // 036: ldc 5242880
      // 038: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.mark (I)V
      // 03b: new com/bumptech/glide/load/resource/bitmap/ImageHeaderParser
      // 03e: astore 15
      // 040: aload 15
      // 042: aload 13
      // 044: invokespecial com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init> (Ljava/io/InputStream;)V
      // 047: aload 15
      // 049: invokevirtual com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.getOrientation ()I
      // 04c: istore 6
      // 04e: aload 13
      // 050: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.reset ()V
      // 053: aload 9
      // 055: aload 12
      // 057: putfield android/graphics/BitmapFactory$Options.inTempStorage [B
      // 05a: aload 0
      // 05b: aload 14
      // 05d: aload 1
      // 05e: aload 9
      // 060: invokevirtual com/bumptech/glide/load/resource/bitmap/Downsampler.getDimensions (Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;)[I
      // 063: astore 15
      // 065: aload 15
      // 067: bipush 0
      // 068: iaload
      // 069: istore 7
      // 06b: aload 15
      // 06d: bipush 1
      // 06e: iaload
      // 06f: istore 8
      // 071: aload 0
      // 072: aload 14
      // 074: aload 1
      // 075: aload 9
      // 077: aload 2
      // 078: iload 7
      // 07a: iload 8
      // 07c: aload 0
      // 07d: iload 6
      // 07f: invokestatic com/bumptech/glide/load/resource/bitmap/TransformationUtils.a (I)I
      // 082: iload 7
      // 084: iload 8
      // 086: iload 3
      // 087: iload 4
      // 089: invokespecial com/bumptech/glide/load/resource/bitmap/Downsampler.getRoundedSampleSize (IIIII)I
      // 08c: aload 5
      // 08e: invokespecial com/bumptech/glide/load/resource/bitmap/Downsampler.downsampleWithSize (Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;IIILcom/bumptech/glide/load/DecodeFormat;)Landroid/graphics/Bitmap;
      // 091: astore 14
      // 093: aload 13
      // 095: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.a ()Ljava/io/IOException;
      // 098: astore 1
      // 099: aload 1
      // 09a: ifnull 137
      // 09d: new java/lang/RuntimeException
      // 0a0: astore 2
      // 0a1: aload 2
      // 0a2: aload 1
      // 0a3: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 0a6: aload 2
      // 0a7: athrow
      // 0a8: astore 1
      // 0a9: aload 10
      // 0ab: aload 12
      // 0ad: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 0b0: pop
      // 0b1: aload 10
      // 0b3: aload 11
      // 0b5: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 0b8: pop
      // 0b9: aload 13
      // 0bb: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.b ()V
      // 0be: aload 9
      // 0c0: invokestatic com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions (Landroid/graphics/BitmapFactory$Options;)V
      // 0c3: aload 1
      // 0c4: athrow
      // 0c5: astore 15
      // 0c7: ldc "Downsampler"
      // 0c9: bipush 5
      // 0ca: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0cd: ifeq 0da
      // 0d0: ldc "Downsampler"
      // 0d2: ldc "Cannot reset the input stream"
      // 0d4: aload 15
      // 0d6: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0d9: pop
      // 0da: goto 053
      // 0dd: astore 15
      // 0df: ldc "Downsampler"
      // 0e1: bipush 5
      // 0e2: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0e5: ifeq 0f3
      // 0e8: ldc "Downsampler"
      // 0ea: ldc_w "Cannot determine the image orientation from header"
      // 0ed: aload 15
      // 0ef: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0f2: pop
      // 0f3: aload 13
      // 0f5: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.reset ()V
      // 0f8: bipush 0
      // 0f9: istore 6
      // 0fb: goto 053
      // 0fe: astore 15
      // 100: ldc "Downsampler"
      // 102: bipush 5
      // 103: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 106: ifeq 113
      // 109: ldc "Downsampler"
      // 10b: ldc "Cannot reset the input stream"
      // 10d: aload 15
      // 10f: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 112: pop
      // 113: bipush 0
      // 114: istore 6
      // 116: goto 053
      // 119: astore 2
      // 11a: aload 13
      // 11c: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.reset ()V
      // 11f: aload 2
      // 120: athrow
      // 121: astore 1
      // 122: ldc "Downsampler"
      // 124: bipush 5
      // 125: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 128: ifeq 11f
      // 12b: ldc "Downsampler"
      // 12d: ldc "Cannot reset the input stream"
      // 12f: aload 1
      // 130: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 133: pop
      // 134: goto 11f
      // 137: aconst_null
      // 138: astore 1
      // 139: aload 14
      // 13b: ifnull 16b
      // 13e: aload 14
      // 140: aload 2
      // 141: iload 6
      // 143: invokestatic com/bumptech/glide/load/resource/bitmap/TransformationUtils.a (Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;I)Landroid/graphics/Bitmap;
      // 146: astore 5
      // 148: aload 5
      // 14a: astore 1
      // 14b: aload 14
      // 14d: aload 5
      // 14f: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 152: ifne 16b
      // 155: aload 5
      // 157: astore 1
      // 158: aload 2
      // 159: aload 14
      // 15b: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/BitmapPool.put (Landroid/graphics/Bitmap;)Z 2
      // 160: ifne 16b
      // 163: aload 14
      // 165: invokevirtual android/graphics/Bitmap.recycle ()V
      // 168: aload 5
      // 16a: astore 1
      // 16b: aload 10
      // 16d: aload 12
      // 16f: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 172: pop
      // 173: aload 10
      // 175: aload 11
      // 177: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 17a: pop
      // 17b: aload 13
      // 17d: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.b ()V
      // 180: aload 9
      // 182: invokestatic com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions (Landroid/graphics/BitmapFactory$Options;)V
      // 185: aload 1
      // 186: areturn
      // try (24 -> 27): 84 null
      // try (27 -> 35): 110 java/io/IOException
      // try (27 -> 35): 138 null
      // try (35 -> 37): 99 java/io/IOException
      // try (35 -> 37): 84 null
      // try (37 -> 46): 84 null
      // try (54 -> 75): 84 null
      // try (77 -> 84): 84 null
      // try (100 -> 109): 84 null
      // try (111 -> 120): 138 null
      // try (120 -> 122): 125 java/io/IOException
      // try (120 -> 122): 84 null
      // try (126 -> 135): 84 null
      // try (139 -> 141): 143 java/io/IOException
      // try (139 -> 141): 84 null
      // try (141 -> 143): 84 null
      // try (144 -> 153): 84 null
      // try (158 -> 163): 84 null
      // try (165 -> 169): 84 null
      // try (171 -> 177): 84 null
   }

   public int[] getDimensions(MarkEnforcingInputStream var1, RecyclableBufferedInputStream var2, Options var3) {
      var3.inJustDecodeBounds = true;
      decodeStream(var1, var2, var3);
      var3.inJustDecodeBounds = false;
      return new int[]{var3.outWidth, var3.outHeight};
   }

   protected abstract int getSampleSize(int var1, int var2, int var3, int var4);
}
