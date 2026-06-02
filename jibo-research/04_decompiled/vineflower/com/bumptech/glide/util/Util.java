package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Looper;
import android.os.Build.VERSION;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class Util {
   private static final char[] a = "0123456789abcdef".toCharArray();
   private static final char[] b = new char[64];
   private static final char[] c = new char[40];

   public static int a(int var0, int var1, Config var2) {
      return var0 * var1 * a(var2);
   }

   private static int a(Config var0) {
      Config var2 = var0;
      if (var0 == null) {
         var2 = Config.ARGB_8888;
      }

      byte var1;
      switch (<unrepresentable>.a[var2.ordinal()]) {
         case 1:
            var1 = 1;
            break;
         case 2:
         case 3:
            var1 = 2;
            break;
         default:
            var1 = 4;
      }

      return var1;
   }

   @TargetApi(19)
   public static int a(Bitmap var0) {
      if (VERSION.SDK_INT >= 19) {
         try {
            return var0.getAllocationByteCount();
         } catch (NullPointerException var3) {
         }
      }

      return var0.getHeight() * var0.getRowBytes();
   }

   public static String a(byte[] param0) {
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
      // 00: getstatic com/bumptech/glide/util/Util.b [C
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: aload 0
      // 07: getstatic com/bumptech/glide/util/Util.b [C
      // 0a: invokestatic com/bumptech/glide/util/Util.a ([B[C)Ljava/lang/String;
      // 0d: astore 0
      // 0e: aload 1
      // 0f: monitorexit
      // 10: aload 0
      // 11: areturn
      // 12: astore 0
      // 13: aload 1
      // 14: monitorexit
      // 15: aload 0
      // 16: athrow
      // try (4 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   private static String a(byte[] var0, char[] var1) {
      for (int var2 = 0; var2 < var0.length; var2++) {
         int var3 = var0[var2] & 255;
         var1[var2 * 2] = a[var3 >>> 4];
         var1[var2 * 2 + 1] = a[var3 & 15];
      }

      return new String(var1);
   }

   public static <T> List<T> a(Collection<T> var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.iterator();

      while (var2.hasNext()) {
         var1.add(var2.next());
      }

      return var1;
   }

   public static <T> Queue<T> a(int var0) {
      return new ArrayDeque<>(var0);
   }

   public static void a() {
      if (!b()) {
         throw new IllegalArgumentException("You must call this method on the main thread");
      }
   }

   public static boolean a(int var0, int var1) {
      boolean var2;
      if (b(var0) && b(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static boolean b() {
      boolean var0;
      if (Looper.myLooper() == Looper.getMainLooper()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   private static boolean b(int var0) {
      boolean var1;
      if (var0 <= 0 && var0 != Integer.MIN_VALUE) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean c() {
      boolean var0;
      if (!b()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }
}
