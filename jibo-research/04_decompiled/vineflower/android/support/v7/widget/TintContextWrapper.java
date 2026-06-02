package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
   private static final Object a = new Object();
   private static ArrayList<WeakReference<TintContextWrapper>> b;
   private final Resources c;
   private final Theme d;

   private TintContextWrapper(Context var1) {
      super(var1);
      if (VectorEnabledTintResources.a()) {
         this.c = new VectorEnabledTintResources(this, var1.getResources());
         this.d = this.c.newTheme();
         this.d.setTo(var1.getTheme());
      } else {
         this.c = new TintResources(this, var1.getResources());
         this.d = null;
      }
   }

   public static Context a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: astore 2
      // 02: aload 0
      // 03: invokestatic android/support/v7/widget/TintContextWrapper.b (Landroid/content/Context;)Z
      // 06: ifeq 42
      // 09: getstatic android/support/v7/widget/TintContextWrapper.a Ljava/lang/Object;
      // 0c: astore 3
      // 0d: aload 3
      // 0e: monitorenter
      // 0f: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 12: ifnonnull 44
      // 15: new java/util/ArrayList
      // 18: astore 2
      // 19: aload 2
      // 1a: invokespecial java/util/ArrayList.<init> ()V
      // 1d: aload 2
      // 1e: putstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 21: new android/support/v7/widget/TintContextWrapper
      // 24: astore 2
      // 25: aload 2
      // 26: aload 0
      // 27: invokespecial android/support/v7/widget/TintContextWrapper.<init> (Landroid/content/Context;)V
      // 2a: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 2d: astore 0
      // 2e: new java/lang/ref/WeakReference
      // 31: astore 4
      // 33: aload 4
      // 35: aload 2
      // 36: invokespecial java/lang/ref/WeakReference.<init> (Ljava/lang/Object;)V
      // 39: aload 0
      // 3a: aload 4
      // 3c: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 3f: pop
      // 40: aload 3
      // 41: monitorexit
      // 42: aload 2
      // 43: areturn
      // 44: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 47: invokevirtual java/util/ArrayList.size ()I
      // 4a: bipush 1
      // 4b: isub
      // 4c: istore 1
      // 4d: iload 1
      // 4e: iflt 75
      // 51: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 54: iload 1
      // 55: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 58: checkcast java/lang/ref/WeakReference
      // 5b: astore 2
      // 5c: aload 2
      // 5d: ifnull 67
      // 60: aload 2
      // 61: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 64: ifnonnull 6f
      // 67: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 6a: iload 1
      // 6b: invokevirtual java/util/ArrayList.remove (I)Ljava/lang/Object;
      // 6e: pop
      // 6f: iinc 1 -1
      // 72: goto 4d
      // 75: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 78: invokevirtual java/util/ArrayList.size ()I
      // 7b: bipush 1
      // 7c: isub
      // 7d: istore 1
      // 7e: iload 1
      // 7f: iflt 21
      // 82: getstatic android/support/v7/widget/TintContextWrapper.b Ljava/util/ArrayList;
      // 85: iload 1
      // 86: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 89: checkcast java/lang/ref/WeakReference
      // 8c: astore 2
      // 8d: aload 2
      // 8e: ifnull aa
      // 91: aload 2
      // 92: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 95: checkcast android/support/v7/widget/TintContextWrapper
      // 98: astore 2
      // 99: aload 2
      // 9a: ifnull af
      // 9d: aload 2
      // 9e: invokevirtual android/support/v7/widget/TintContextWrapper.getBaseContext ()Landroid/content/Context;
      // a1: aload 0
      // a2: if_acmpne af
      // a5: aload 3
      // a6: monitorexit
      // a7: goto 42
      // aa: aconst_null
      // ab: astore 2
      // ac: goto 99
      // af: iinc 1 -1
      // b2: goto 7e
      // b5: astore 0
      // b6: aload 3
      // b7: monitorexit
      // b8: aload 0
      // b9: athrow
      // try (9 -> 17): 92 null
      // try (17 -> 35): 92 null
      // try (37 -> 42): 92 null
      // try (44 -> 49): 92 null
      // try (51 -> 54): 92 null
      // try (54 -> 58): 92 null
      // try (60 -> 65): 92 null
      // try (67 -> 72): 92 null
      // try (74 -> 78): 92 null
      // try (80 -> 86): 92 null
      // try (93 -> 95): 92 null
   }

   private static boolean b(Context var0) {
      boolean var2 = false;
      boolean var1 = var2;
      if (!(var0 instanceof TintContextWrapper)) {
         var1 = var2;
         if (!(var0.getResources() instanceof TintResources)) {
            if (var0.getResources() instanceof VectorEnabledTintResources) {
               var1 = var2;
            } else {
               if (VERSION.SDK_INT >= 21) {
                  var1 = var2;
                  if (!VectorEnabledTintResources.a()) {
                     return var1;
                  }
               }

               var1 = true;
            }
         }
      }

      return var1;
   }

   public AssetManager getAssets() {
      return this.c.getAssets();
   }

   public Resources getResources() {
      return this.c;
   }

   public Theme getTheme() {
      Theme var1;
      if (this.d == null) {
         var1 = super.getTheme();
      } else {
         var1 = this.d;
      }

      return var1;
   }

   public void setTheme(int var1) {
      if (this.d == null) {
         super.setTheme(var1);
      } else {
         this.d.applyStyle(var1, true);
      }
   }
}
