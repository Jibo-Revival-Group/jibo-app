package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
   private static final Config DEFAULT_CONFIG = Config.ARGB_8888;
   private final Set<Config> allowedConfigs;
   private int currentSize;
   private int evictions;
   private int hits;
   private final int initialMaxSize;
   private int maxSize;
   private int misses;
   private int puts;
   private final LruPoolStrategy strategy;
   private final LruBitmapPool.BitmapTracker tracker;

   public LruBitmapPool(int var1) {
      this(var1, getDefaultStrategy(), getDefaultAllowedConfigs());
   }

   LruBitmapPool(int var1, LruPoolStrategy var2, Set<Config> var3) {
      this.initialMaxSize = var1;
      this.maxSize = var1;
      this.strategy = var2;
      this.allowedConfigs = var3;
      this.tracker = new LruBitmapPool.NullBitmapTracker();
   }

   private void dump() {
      if (Log.isLoggable("LruBitmapPool", 2)) {
         this.dumpUnchecked();
      }
   }

   private void dumpUnchecked() {
      Log.v(
         "LruBitmapPool",
         "Hits="
            + this.hits
            + ", misses="
            + this.misses
            + ", puts="
            + this.puts
            + ", evictions="
            + this.evictions
            + ", currentSize="
            + this.currentSize
            + ", maxSize="
            + this.maxSize
            + "\nStrategy="
            + this.strategy
      );
   }

   private void evict() {
      this.trimToSize(this.maxSize);
   }

   private static Set<Config> getDefaultAllowedConfigs() {
      HashSet var0 = new HashSet();
      var0.addAll(Arrays.asList(Config.values()));
      if (VERSION.SDK_INT >= 19) {
         var0.add(null);
      }

      return Collections.unmodifiableSet(var0);
   }

   private static LruPoolStrategy getDefaultStrategy() {
      LruPoolStrategy var0;
      if (VERSION.SDK_INT >= 19) {
         var0 = new SizeConfigStrategy();
      } else {
         var0 = new AttributeStrategy();
      }

      return var0;
   }

   private void trimToSize(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 06: iload 1
      // 07: if_icmple 32
      // 0a: aload 0
      // 0b: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 0e: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.removeLast ()Landroid/graphics/Bitmap; 1
      // 13: astore 2
      // 14: aload 2
      // 15: ifnonnull 35
      // 18: ldc "LruBitmapPool"
      // 1a: bipush 5
      // 1b: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 1e: ifeq 2d
      // 21: ldc "LruBitmapPool"
      // 23: ldc "Size mismatch, resetting"
      // 25: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 28: pop
      // 29: aload 0
      // 2a: invokespecial com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.dumpUnchecked ()V
      // 2d: aload 0
      // 2e: bipush 0
      // 2f: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 32: aload 0
      // 33: monitorexit
      // 34: return
      // 35: aload 0
      // 36: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.tracker Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
      // 39: aload 2
      // 3a: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker.b (Landroid/graphics/Bitmap;)V 2
      // 3f: aload 0
      // 40: aload 0
      // 41: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 44: aload 0
      // 45: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 48: aload 2
      // 49: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.getSize (Landroid/graphics/Bitmap;)I 2
      // 4e: isub
      // 4f: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 52: aload 2
      // 53: invokevirtual android/graphics/Bitmap.recycle ()V
      // 56: aload 0
      // 57: aload 0
      // 58: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.evictions I
      // 5b: bipush 1
      // 5c: iadd
      // 5d: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.evictions I
      // 60: ldc "LruBitmapPool"
      // 62: bipush 3
      // 63: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 66: ifeq 8d
      // 69: new java/lang/StringBuilder
      // 6c: astore 3
      // 6d: aload 3
      // 6e: invokespecial java/lang/StringBuilder.<init> ()V
      // 71: ldc "LruBitmapPool"
      // 73: aload 3
      // 74: ldc "Evicting bitmap="
      // 76: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 79: aload 0
      // 7a: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 7d: aload 2
      // 7e: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.logBitmap (Landroid/graphics/Bitmap;)Ljava/lang/String; 2
      // 83: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 86: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 89: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 8c: pop
      // 8d: aload 0
      // 8e: invokespecial com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.dump ()V
      // 91: goto 02
      // 94: astore 2
      // 95: aload 0
      // 96: monitorexit
      // 97: aload 2
      // 98: athrow
      // try (2 -> 10): 72 null
      // try (12 -> 22): 72 null
      // try (22 -> 25): 72 null
      // try (28 -> 69): 72 null
      // try (69 -> 71): 72 null
   }

   @Override
   public void clearMemory() {
      if (Log.isLoggable("LruBitmapPool", 3)) {
         Log.d("LruBitmapPool", "clearMemory");
      }

      this.trimToSize(0);
   }

   @Override
   public Bitmap get(int param1, int param2, Config param3) {
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
      // 03: iload 1
      // 04: iload 2
      // 05: aload 3
      // 06: invokevirtual com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.getDirty (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      // 09: astore 3
      // 0a: aload 3
      // 0b: ifnull 13
      // 0e: aload 3
      // 0f: bipush 0
      // 10: invokevirtual android/graphics/Bitmap.eraseColor (I)V
      // 13: aload 0
      // 14: monitorexit
      // 15: aload 3
      // 16: areturn
      // 17: astore 3
      // 18: aload 0
      // 19: monitorexit
      // 1a: aload 3
      // 1b: athrow
      // try (2 -> 8): 17 null
      // try (10 -> 13): 17 null
   }

   @TargetApi(12)
   @Override
   public Bitmap getDirty(int param1, int param2, Config param3) {
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
      // 03: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 06: astore 5
      // 08: aload 3
      // 09: ifnull 98
      // 0c: aload 3
      // 0d: astore 4
      // 0f: aload 5
      // 11: iload 1
      // 12: iload 2
      // 13: aload 4
      // 15: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.get (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap; 4
      // 1a: astore 4
      // 1c: aload 4
      // 1e: ifnonnull a0
      // 21: ldc "LruBitmapPool"
      // 23: bipush 3
      // 24: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 27: ifeq 53
      // 2a: new java/lang/StringBuilder
      // 2d: astore 5
      // 2f: aload 5
      // 31: invokespecial java/lang/StringBuilder.<init> ()V
      // 34: ldc "LruBitmapPool"
      // 36: aload 5
      // 38: ldc "Missing bitmap="
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: aload 0
      // 3e: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 41: iload 1
      // 42: iload 2
      // 43: aload 3
      // 44: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.logBitmap (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String; 4
      // 49: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4f: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 52: pop
      // 53: aload 0
      // 54: aload 0
      // 55: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.misses I
      // 58: bipush 1
      // 59: iadd
      // 5a: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.misses I
      // 5d: ldc "LruBitmapPool"
      // 5f: bipush 2
      // 60: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 63: ifeq 8f
      // 66: new java/lang/StringBuilder
      // 69: astore 5
      // 6b: aload 5
      // 6d: invokespecial java/lang/StringBuilder.<init> ()V
      // 70: ldc "LruBitmapPool"
      // 72: aload 5
      // 74: ldc "Get bitmap="
      // 76: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 79: aload 0
      // 7a: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 7d: iload 1
      // 7e: iload 2
      // 7f: aload 3
      // 80: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.logBitmap (IILandroid/graphics/Bitmap$Config;)Ljava/lang/String; 4
      // 85: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 88: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 8b: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 8e: pop
      // 8f: aload 0
      // 90: invokespecial com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.dump ()V
      // 93: aload 0
      // 94: monitorexit
      // 95: aload 4
      // 97: areturn
      // 98: getstatic com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.DEFAULT_CONFIG Landroid/graphics/Bitmap$Config;
      // 9b: astore 4
      // 9d: goto 0f
      // a0: aload 0
      // a1: aload 0
      // a2: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.hits I
      // a5: bipush 1
      // a6: iadd
      // a7: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.hits I
      // aa: aload 0
      // ab: aload 0
      // ac: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // af: aload 0
      // b0: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // b3: aload 4
      // b5: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.getSize (Landroid/graphics/Bitmap;)I 2
      // ba: isub
      // bb: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // be: aload 0
      // bf: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.tracker Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
      // c2: aload 4
      // c4: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker.b (Landroid/graphics/Bitmap;)V 2
      // c9: getstatic android/os/Build$VERSION.SDK_INT I
      // cc: bipush 12
      // ce: if_icmplt 5d
      // d1: aload 4
      // d3: bipush 1
      // d4: invokevirtual android/graphics/Bitmap.setHasAlpha (Z)V
      // d7: goto 5d
      // da: astore 3
      // db: aload 0
      // dc: monitorexit
      // dd: aload 3
      // de: athrow
      // try (2 -> 5): 102 null
      // try (9 -> 15): 102 null
      // try (17 -> 39): 102 null
      // try (39 -> 45): 102 null
      // try (45 -> 67): 102 null
      // try (67 -> 69): 102 null
      // try (73 -> 75): 102 null
      // try (76 -> 101): 102 null
   }

   @Override
   public boolean put(Bitmap param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 0
      // 001: monitorenter
      // 002: aload 1
      // 003: ifnonnull 017
      // 006: new java/lang/NullPointerException
      // 009: astore 1
      // 00a: aload 1
      // 00b: ldc "Bitmap must not be null"
      // 00d: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 010: aload 1
      // 011: athrow
      // 012: astore 1
      // 013: aload 0
      // 014: monitorexit
      // 015: aload 1
      // 016: athrow
      // 017: aload 1
      // 018: invokevirtual android/graphics/Bitmap.isMutable ()Z
      // 01b: ifeq 03f
      // 01e: aload 0
      // 01f: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 022: aload 1
      // 023: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.getSize (Landroid/graphics/Bitmap;)I 2
      // 028: aload 0
      // 029: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.maxSize I
      // 02c: if_icmpgt 03f
      // 02f: aload 0
      // 030: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.allowedConfigs Ljava/util/Set;
      // 033: aload 1
      // 034: invokevirtual android/graphics/Bitmap.getConfig ()Landroid/graphics/Bitmap$Config;
      // 037: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 03c: ifne 099
      // 03f: ldc "LruBitmapPool"
      // 041: bipush 2
      // 042: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 045: ifeq 093
      // 048: new java/lang/StringBuilder
      // 04b: astore 4
      // 04d: aload 4
      // 04f: invokespecial java/lang/StringBuilder.<init> ()V
      // 052: ldc "LruBitmapPool"
      // 054: aload 4
      // 056: ldc_w "Reject bitmap from pool, bitmap: "
      // 059: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05c: aload 0
      // 05d: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 060: aload 1
      // 061: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.logBitmap (Landroid/graphics/Bitmap;)Ljava/lang/String; 2
      // 066: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 069: ldc_w ", is mutable: "
      // 06c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06f: aload 1
      // 070: invokevirtual android/graphics/Bitmap.isMutable ()Z
      // 073: invokevirtual java/lang/StringBuilder.append (Z)Ljava/lang/StringBuilder;
      // 076: ldc_w ", is allowed config: "
      // 079: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07c: aload 0
      // 07d: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.allowedConfigs Ljava/util/Set;
      // 080: aload 1
      // 081: invokevirtual android/graphics/Bitmap.getConfig ()Landroid/graphics/Bitmap$Config;
      // 084: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 089: invokevirtual java/lang/StringBuilder.append (Z)Ljava/lang/StringBuilder;
      // 08c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08f: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 092: pop
      // 093: bipush 0
      // 094: istore 3
      // 095: aload 0
      // 096: monitorexit
      // 097: iload 3
      // 098: ireturn
      // 099: aload 0
      // 09a: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 09d: aload 1
      // 09e: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.getSize (Landroid/graphics/Bitmap;)I 2
      // 0a3: istore 2
      // 0a4: aload 0
      // 0a5: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 0a8: aload 1
      // 0a9: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.put (Landroid/graphics/Bitmap;)V 2
      // 0ae: aload 0
      // 0af: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.tracker Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker;
      // 0b2: aload 1
      // 0b3: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool$BitmapTracker.a (Landroid/graphics/Bitmap;)V 2
      // 0b8: aload 0
      // 0b9: aload 0
      // 0ba: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.puts I
      // 0bd: bipush 1
      // 0be: iadd
      // 0bf: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.puts I
      // 0c2: aload 0
      // 0c3: iload 2
      // 0c4: aload 0
      // 0c5: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 0c8: iadd
      // 0c9: putfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.currentSize I
      // 0cc: ldc "LruBitmapPool"
      // 0ce: bipush 2
      // 0cf: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 0d2: ifeq 0fd
      // 0d5: new java/lang/StringBuilder
      // 0d8: astore 4
      // 0da: aload 4
      // 0dc: invokespecial java/lang/StringBuilder.<init> ()V
      // 0df: ldc "LruBitmapPool"
      // 0e1: aload 4
      // 0e3: ldc_w "Put bitmap in pool="
      // 0e6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e9: aload 0
      // 0ea: getfield com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.strategy Lcom/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy;
      // 0ed: aload 1
      // 0ee: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.logBitmap (Landroid/graphics/Bitmap;)Ljava/lang/String; 2
      // 0f3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f9: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 0fc: pop
      // 0fd: aload 0
      // 0fe: invokespecial com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.dump ()V
      // 101: aload 0
      // 102: invokespecial com/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool.evict ()V
      // 105: bipush 1
      // 106: istore 3
      // 107: goto 095
      // try (4 -> 11): 11 null
      // try (16 -> 32): 11 null
      // try (32 -> 65): 11 null
      // try (71 -> 116): 11 null
      // try (116 -> 120): 11 null
   }

   @SuppressLint("InlinedApi")
   @Override
   public void trimMemory(int var1) {
      if (Log.isLoggable("LruBitmapPool", 3)) {
         Log.d("LruBitmapPool", "trimMemory, level=" + var1);
      }

      if (var1 >= 60) {
         this.clearMemory();
      } else if (var1 >= 40) {
         this.trimToSize(this.maxSize / 2);
      }
   }

   private interface BitmapTracker {
      void a(Bitmap var1);

      void b(Bitmap var1);
   }

   private static class NullBitmapTracker implements LruBitmapPool.BitmapTracker {
      private NullBitmapTracker() {
      }

      @Override
      public void a(Bitmap var1) {
      }

      @Override
      public void b(Bitmap var1) {
      }
   }
}
