package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.Build.VERSION;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
   private static final Object a = new Object();
   private static TypedValue b;

   public static Drawable a(Context param0, int param1) {
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
      // 00: getstatic android/os/Build$VERSION.SDK_INT I
      // 03: bipush 21
      // 05: if_icmplt 10
      // 08: aload 0
      // 09: iload 1
      // 0a: invokevirtual android/content/Context.getDrawable (I)Landroid/graphics/drawable/Drawable;
      // 0d: astore 0
      // 0e: aload 0
      // 0f: areturn
      // 10: getstatic android/os/Build$VERSION.SDK_INT I
      // 13: bipush 16
      // 15: if_icmplt 24
      // 18: aload 0
      // 19: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 1c: iload 1
      // 1d: invokevirtual android/content/res/Resources.getDrawable (I)Landroid/graphics/drawable/Drawable;
      // 20: astore 0
      // 21: goto 0e
      // 24: getstatic android/support/v4/content/ContextCompat.a Ljava/lang/Object;
      // 27: astore 2
      // 28: aload 2
      // 29: monitorenter
      // 2a: getstatic android/support/v4/content/ContextCompat.b Landroid/util/TypedValue;
      // 2d: ifnonnull 3c
      // 30: new android/util/TypedValue
      // 33: astore 3
      // 34: aload 3
      // 35: invokespecial android/util/TypedValue.<init> ()V
      // 38: aload 3
      // 39: putstatic android/support/v4/content/ContextCompat.b Landroid/util/TypedValue;
      // 3c: aload 0
      // 3d: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 40: iload 1
      // 41: getstatic android/support/v4/content/ContextCompat.b Landroid/util/TypedValue;
      // 44: bipush 1
      // 45: invokevirtual android/content/res/Resources.getValue (ILandroid/util/TypedValue;Z)V
      // 48: getstatic android/support/v4/content/ContextCompat.b Landroid/util/TypedValue;
      // 4b: getfield android/util/TypedValue.resourceId I
      // 4e: istore 1
      // 4f: aload 2
      // 50: monitorexit
      // 51: aload 0
      // 52: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 55: iload 1
      // 56: invokevirtual android/content/res/Resources.getDrawable (I)Landroid/graphics/drawable/Drawable;
      // 59: astore 0
      // 5a: goto 0e
      // 5d: astore 0
      // 5e: aload 2
      // 5f: monitorexit
      // 60: aload 0
      // 61: athrow
      // try (22 -> 30): 47 null
      // try (30 -> 41): 47 null
      // try (48 -> 50): 47 null
   }

   public static void a(Context var0, Intent var1, Bundle var2) {
      if (VERSION.SDK_INT >= 16) {
         var0.startActivity(var1, var2);
      } else {
         var0.startActivity(var1);
      }
   }

   public static boolean a(Context var0, Intent[] var1, Bundle var2) {
      if (VERSION.SDK_INT >= 16) {
         var0.startActivities(var1, var2);
      } else {
         var0.startActivities(var1);
      }

      return true;
   }

   public static File[] a(Context var0) {
      File[] var2;
      if (VERSION.SDK_INT >= 19) {
         var2 = var0.getExternalCacheDirs();
      } else {
         File[] var1 = new File[]{var0.getExternalCacheDir()};
         var2 = var1;
      }

      return var2;
   }

   public static File[] a(Context var0, String var1) {
      File[] var3;
      if (VERSION.SDK_INT >= 19) {
         var3 = var0.getExternalFilesDirs(var1);
      } else {
         File[] var2 = new File[]{var0.getExternalFilesDir(var1)};
         var3 = var2;
      }

      return var3;
   }

   public static int b(Context var0, String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("permission is null");
      } else {
         return var0.checkPermission(var1, Process.myPid(), Process.myUid());
      }
   }

   public static ColorStateList b(Context var0, int var1) {
      ColorStateList var2;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.getColorStateList(var1);
      } else {
         var2 = var0.getResources().getColorStateList(var1);
      }

      return var2;
   }

   public static boolean b(Context var0) {
      boolean var1;
      if (VERSION.SDK_INT >= 24) {
         var1 = var0.isDeviceProtectedStorage();
      } else {
         var1 = false;
      }

      return var1;
   }

   public static int c(Context var0, int var1) {
      if (VERSION.SDK_INT >= 23) {
         var1 = var0.getColor(var1);
      } else {
         var1 = var0.getResources().getColor(var1);
      }

      return var1;
   }
}
