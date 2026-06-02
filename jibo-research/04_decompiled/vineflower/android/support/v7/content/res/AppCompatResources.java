package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class AppCompatResources {
   private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
   private static final WeakHashMap<Context, SparseArray<AppCompatResources.ColorStateListCacheEntry>> b = new WeakHashMap<>(0);
   private static final Object c = new Object();

   public static ColorStateList a(Context var0, int var1) {
      ColorStateList var2;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.getColorStateList(var1);
      } else {
         ColorStateList var3 = d(var0, var1);
         var2 = var3;
         if (var3 == null) {
            var2 = c(var0, var1);
            if (var2 != null) {
               a(var0, var1, var2);
            } else {
               var2 = ContextCompat.b(var0, var1);
            }
         }
      }

      return var2;
   }

   private static TypedValue a() {
      TypedValue var1 = a.get();
      TypedValue var0 = var1;
      if (var1 == null) {
         var0 = new TypedValue();
         a.set(var0);
      }

      return var0;
   }

   private static void a(Context param0, int param1, ColorStateList param2) {
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
      // 00: getstatic android/support/v7/content/res/AppCompatResources.c Ljava/lang/Object;
      // 03: astore 5
      // 05: aload 5
      // 07: monitorenter
      // 08: getstatic android/support/v7/content/res/AppCompatResources.b Ljava/util/WeakHashMap;
      // 0b: aload 0
      // 0c: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast android/util/SparseArray
      // 12: astore 4
      // 14: aload 4
      // 16: astore 3
      // 17: aload 4
      // 19: ifnonnull 2d
      // 1c: new android/util/SparseArray
      // 1f: astore 3
      // 20: aload 3
      // 21: invokespecial android/util/SparseArray.<init> ()V
      // 24: getstatic android/support/v7/content/res/AppCompatResources.b Ljava/util/WeakHashMap;
      // 27: aload 0
      // 28: aload 3
      // 29: invokevirtual java/util/WeakHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 2c: pop
      // 2d: new android/support/v7/content/res/AppCompatResources$ColorStateListCacheEntry
      // 30: astore 4
      // 32: aload 4
      // 34: aload 2
      // 35: aload 0
      // 36: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 39: invokevirtual android/content/res/Resources.getConfiguration ()Landroid/content/res/Configuration;
      // 3c: invokespecial android/support/v7/content/res/AppCompatResources$ColorStateListCacheEntry.<init> (Landroid/content/res/ColorStateList;Landroid/content/res/Configuration;)V
      // 3f: aload 3
      // 40: iload 1
      // 41: aload 4
      // 43: invokevirtual android/util/SparseArray.append (ILjava/lang/Object;)V
      // 46: aload 5
      // 48: monitorexit
      // 49: return
      // 4a: astore 0
      // 4b: aload 5
      // 4d: monitorexit
      // 4e: aload 0
      // 4f: athrow
      // try (4 -> 9): 37 null
      // try (13 -> 22): 37 null
      // try (22 -> 36): 37 null
      // try (38 -> 40): 37 null
   }

   public static Drawable b(Context var0, int var1) {
      return AppCompatDrawableManager.a().a(var0, var1);
   }

   private static ColorStateList c(Context var0, int var1) {
      Object var2 = null;
      ColorStateList var6;
      if (e(var0, var1)) {
         var6 = (ColorStateList)var2;
      } else {
         Resources var3 = var0.getResources();
         XmlResourceParser var4 = var3.getXml(var1);

         try {
            var6 = AppCompatColorStateListInflater.a(var3, var4, var0.getTheme());
         } catch (Exception var5) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", var5);
            var6 = (ColorStateList)var2;
         }
      }

      return var6;
   }

   private static ColorStateList d(Context param0, int param1) {
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
      // 00: getstatic android/support/v7/content/res/AppCompatResources.c Ljava/lang/Object;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: getstatic android/support/v7/content/res/AppCompatResources.b Ljava/util/WeakHashMap;
      // 09: aload 0
      // 0a: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0d: checkcast android/util/SparseArray
      // 10: astore 3
      // 11: aload 3
      // 12: ifnull 4c
      // 15: aload 3
      // 16: invokevirtual android/util/SparseArray.size ()I
      // 19: ifle 4c
      // 1c: aload 3
      // 1d: iload 1
      // 1e: invokevirtual android/util/SparseArray.get (I)Ljava/lang/Object;
      // 21: checkcast android/support/v7/content/res/AppCompatResources$ColorStateListCacheEntry
      // 24: astore 4
      // 26: aload 4
      // 28: ifnull 4c
      // 2b: aload 4
      // 2d: getfield android/support/v7/content/res/AppCompatResources$ColorStateListCacheEntry.b Landroid/content/res/Configuration;
      // 30: aload 0
      // 31: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 34: invokevirtual android/content/res/Resources.getConfiguration ()Landroid/content/res/Configuration;
      // 37: invokevirtual android/content/res/Configuration.equals (Landroid/content/res/Configuration;)Z
      // 3a: ifeq 47
      // 3d: aload 4
      // 3f: getfield android/support/v7/content/res/AppCompatResources$ColorStateListCacheEntry.a Landroid/content/res/ColorStateList;
      // 42: astore 0
      // 43: aload 2
      // 44: monitorexit
      // 45: aload 0
      // 46: areturn
      // 47: aload 3
      // 48: iload 1
      // 49: invokevirtual android/util/SparseArray.remove (I)V
      // 4c: aload 2
      // 4d: monitorexit
      // 4e: aconst_null
      // 4f: astore 0
      // 50: goto 45
      // 53: astore 0
      // 54: aload 2
      // 55: monitorexit
      // 56: aload 0
      // 57: athrow
      // try (4 -> 9): 43 null
      // try (11 -> 19): 43 null
      // try (21 -> 33): 43 null
      // try (35 -> 38): 43 null
      // try (38 -> 40): 43 null
      // try (44 -> 46): 43 null
   }

   private static boolean e(Context var0, int var1) {
      boolean var2 = true;
      Resources var4 = var0.getResources();
      TypedValue var3 = a();
      var4.getValue(var1, var3, true);
      if (var3.type < 28 || var3.type > 31) {
         var2 = false;
      }

      return var2;
   }

   private static class ColorStateListCacheEntry {
      final ColorStateList a;
      final Configuration b;

      ColorStateListCacheEntry(ColorStateList var1, Configuration var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
