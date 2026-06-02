package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.support.v4.util.LruCache;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzbfl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
   private static final Object a = new Object();
   private static HashSet<Uri> b = new HashSet<>();
   private final Context c;
   private final Handler d;
   private final ExecutorService e;
   private final ImageManager.zza f;
   private final zzbfl g;
   private final Map<com.google.android.gms.common.images.zza, ImageManager.ImageReceiver> h;
   private final Map<Uri, ImageManager.ImageReceiver> i;
   private final Map<Uri, Long> j;

   @KeepName
   final class ImageReceiver extends ResultReceiver {
      private final Uri a;
      private final ArrayList<com.google.android.gms.common.images.zza> b;
      private ImageManager c;

      public final void onReceiveResult(int var1, Bundle var2) {
         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
         this.c.e.execute(this.c.new zzb(this.c, this.a, var3));
      }
   }

   public interface OnImageLoadedListener {
      void a(Uri var1, Drawable var2, boolean var3);
   }

   static final class zza extends LruCache<com.google.android.gms.common.images.zzb, Bitmap> {
   }

   final class zzb implements Runnable {
      private final Uri a;
      private final ParcelFileDescriptor b;
      private ImageManager c;

      public zzb(ImageManager var1, Uri var2, ParcelFileDescriptor var3) {
         this.c = var1;
         super();
         this.a = var2;
         this.b = var3;
      }

      @Override
      public final void run() {
         if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String var13 = String.valueOf(Thread.currentThread());
            String var11 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e(
               "Asserts",
               new StringBuilder(String.valueOf(var13).length() + 56 + String.valueOf(var11).length())
                  .append("checkNotMainThread: current thread ")
                  .append(var13)
                  .append(" IS the main thread ")
                  .append(var11)
                  .append("!")
                  .toString()
            );
            throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
         }

         boolean var1 = false;
         boolean var2 = false;
         Bitmap var3 = null;
         CountDownLatch var4 = null;
         if (this.b != null) {
            label27: {
               try {
                  var3 = BitmapFactory.decodeFileDescriptor(this.b.getFileDescriptor());
               } catch (OutOfMemoryError var8) {
                  String var9 = String.valueOf(this.a);
                  Log.e(
                     "ImageManager",
                     new StringBuilder(String.valueOf(var9).length() + 34).append("OOM while loading bitmap for uri: ").append(var9).toString(),
                     var8
                  );
                  var1 = true;
                  var3 = var4;
                  break label27;
               }

               var1 = var2;
            }

            try {
               this.b.close();
            } catch (IOException var7) {
               Log.e("ImageManager", "closed failed", var7);
            }
         }

         var4 = new CountDownLatch(1);
         this.c.d.post(this.c.new zzd(this.c, this.a, var3, var1, var4));

         try {
            var4.await();
         } catch (InterruptedException var6) {
            String var10 = String.valueOf(this.a);
            Log.w("ImageManager", new StringBuilder(String.valueOf(var10).length() + 32).append("Latch interrupted while posting ").append(var10).toString());
         }
      }
   }

   final class zzd implements Runnable {
      private final Uri a;
      private final Bitmap b;
      private final CountDownLatch c;
      private boolean d;
      private ImageManager e;

      public zzd(ImageManager var1, Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
         this.e = var1;
         super();
         this.a = var2;
         this.b = var3;
         this.d = var4;
         this.c = var5;
      }

      @Override
      public final void run() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
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
         // 000: ldc "OnBitmapLoadedRunnable must be executed in the main thread"
         // 002: invokestatic com/google/android/gms/common/internal/zzc.a (Ljava/lang/String;)V
         // 005: aload 0
         // 006: getfield com/google/android/gms/common/images/ImageManager$zzd.b Landroid/graphics/Bitmap;
         // 009: ifnull 03e
         // 00c: bipush 1
         // 00d: istore 1
         // 00e: aload 0
         // 00f: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 012: invokestatic com/google/android/gms/common/images/ImageManager.h (Lcom/google/android/gms/common/images/ImageManager;)Lcom/google/android/gms/common/images/ImageManager$zza;
         // 015: ifnull 061
         // 018: aload 0
         // 019: getfield com/google/android/gms/common/images/ImageManager$zzd.d Z
         // 01c: ifeq 043
         // 01f: aload 0
         // 020: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 023: invokestatic com/google/android/gms/common/images/ImageManager.h (Lcom/google/android/gms/common/images/ImageManager;)Lcom/google/android/gms/common/images/ImageManager$zza;
         // 026: invokevirtual com/google/android/gms/common/images/ImageManager$zza.a ()V
         // 029: invokestatic java/lang/System.gc ()V
         // 02c: aload 0
         // 02d: bipush 0
         // 02e: putfield com/google/android/gms/common/images/ImageManager$zzd.d Z
         // 031: aload 0
         // 032: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 035: invokestatic com/google/android/gms/common/images/ImageManager.g (Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
         // 038: aload 0
         // 039: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
         // 03c: pop
         // 03d: return
         // 03e: bipush 0
         // 03f: istore 1
         // 040: goto 00e
         // 043: iload 1
         // 044: ifeq 061
         // 047: aload 0
         // 048: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 04b: invokestatic com/google/android/gms/common/images/ImageManager.h (Lcom/google/android/gms/common/images/ImageManager;)Lcom/google/android/gms/common/images/ImageManager$zza;
         // 04e: new com/google/android/gms/common/images/zzb
         // 051: dup
         // 052: aload 0
         // 053: getfield com/google/android/gms/common/images/ImageManager$zzd.a Landroid/net/Uri;
         // 056: invokespecial com/google/android/gms/common/images/zzb.<init> (Landroid/net/Uri;)V
         // 059: aload 0
         // 05a: getfield com/google/android/gms/common/images/ImageManager$zzd.b Landroid/graphics/Bitmap;
         // 05d: invokevirtual com/google/android/gms/common/images/ImageManager$zza.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
         // 060: pop
         // 061: aload 0
         // 062: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 065: invokestatic com/google/android/gms/common/images/ImageManager.e (Lcom/google/android/gms/common/images/ImageManager;)Ljava/util/Map;
         // 068: aload 0
         // 069: getfield com/google/android/gms/common/images/ImageManager$zzd.a Landroid/net/Uri;
         // 06c: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
         // 071: checkcast com/google/android/gms/common/images/ImageManager$ImageReceiver
         // 074: astore 4
         // 076: aload 4
         // 078: ifnull 0fa
         // 07b: aload 4
         // 07d: invokestatic com/google/android/gms/common/images/ImageManager$ImageReceiver.a (Lcom/google/android/gms/common/images/ImageManager$ImageReceiver;)Ljava/util/ArrayList;
         // 080: astore 4
         // 082: aload 4
         // 084: invokevirtual java/util/ArrayList.size ()I
         // 087: istore 3
         // 088: bipush 0
         // 089: istore 2
         // 08a: iload 2
         // 08b: iload 3
         // 08c: if_icmpge 0fa
         // 08f: aload 4
         // 091: iload 2
         // 092: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
         // 095: checkcast com/google/android/gms/common/images/zza
         // 098: astore 5
         // 09a: iload 1
         // 09b: ifeq 0cc
         // 09e: aload 5
         // 0a0: aload 0
         // 0a1: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 0a4: invokestatic com/google/android/gms/common/images/ImageManager.b (Lcom/google/android/gms/common/images/ImageManager;)Landroid/content/Context;
         // 0a7: aload 0
         // 0a8: getfield com/google/android/gms/common/images/ImageManager$zzd.b Landroid/graphics/Bitmap;
         // 0ab: bipush 0
         // 0ac: invokevirtual com/google/android/gms/common/images/zza.a (Landroid/content/Context;Landroid/graphics/Bitmap;Z)V
         // 0af: aload 5
         // 0b1: instanceof com/google/android/gms/common/images/zzd
         // 0b4: ifne 0c6
         // 0b7: aload 0
         // 0b8: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 0bb: invokestatic com/google/android/gms/common/images/ImageManager.a (Lcom/google/android/gms/common/images/ImageManager;)Ljava/util/Map;
         // 0be: aload 5
         // 0c0: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
         // 0c5: pop
         // 0c6: iinc 2 1
         // 0c9: goto 08a
         // 0cc: aload 0
         // 0cd: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 0d0: invokestatic com/google/android/gms/common/images/ImageManager.d (Lcom/google/android/gms/common/images/ImageManager;)Ljava/util/Map;
         // 0d3: aload 0
         // 0d4: getfield com/google/android/gms/common/images/ImageManager$zzd.a Landroid/net/Uri;
         // 0d7: invokestatic android/os/SystemClock.elapsedRealtime ()J
         // 0da: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
         // 0dd: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 0e2: pop
         // 0e3: aload 5
         // 0e5: aload 0
         // 0e6: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 0e9: invokestatic com/google/android/gms/common/images/ImageManager.b (Lcom/google/android/gms/common/images/ImageManager;)Landroid/content/Context;
         // 0ec: aload 0
         // 0ed: getfield com/google/android/gms/common/images/ImageManager$zzd.e Lcom/google/android/gms/common/images/ImageManager;
         // 0f0: invokestatic com/google/android/gms/common/images/ImageManager.c (Lcom/google/android/gms/common/images/ImageManager;)Lcom/google/android/gms/internal/zzbfl;
         // 0f3: bipush 0
         // 0f4: invokevirtual com/google/android/gms/common/images/zza.a (Landroid/content/Context;Lcom/google/android/gms/internal/zzbfl;Z)V
         // 0f7: goto 0af
         // 0fa: aload 0
         // 0fb: getfield com/google/android/gms/common/images/ImageManager$zzd.c Ljava/util/concurrent/CountDownLatch;
         // 0fe: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
         // 101: invokestatic com/google/android/gms/common/images/ImageManager.a ()Ljava/lang/Object;
         // 104: astore 4
         // 106: aload 4
         // 108: monitorenter
         // 109: invokestatic com/google/android/gms/common/images/ImageManager.b ()Ljava/util/HashSet;
         // 10c: aload 0
         // 10d: getfield com/google/android/gms/common/images/ImageManager$zzd.a Landroid/net/Uri;
         // 110: invokevirtual java/util/HashSet.remove (Ljava/lang/Object;)Z
         // 113: pop
         // 114: aload 4
         // 116: monitorexit
         // 117: goto 03d
         // 11a: astore 5
         // 11c: aload 4
         // 11e: monitorexit
         // 11f: aload 5
         // 121: athrow
         // try (119 -> 126): 127 null
         // try (128 -> 130): 127 null
      }
   }
}
