package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

class AppCompatBackgroundHelper {
   private final View a;
   private final AppCompatDrawableManager b;
   private int c = -1;
   private TintInfo d;
   private TintInfo e;
   private TintInfo f;

   AppCompatBackgroundHelper(View var1) {
      this.a = var1;
      this.b = AppCompatDrawableManager.a();
   }

   private boolean b(Drawable var1) {
      boolean var2 = true;
      if (this.f == null) {
         this.f = new TintInfo();
      }

      TintInfo var3 = this.f;
      var3.a();
      ColorStateList var4 = ViewCompat.u(this.a);
      if (var4 != null) {
         var3.d = true;
         var3.a = var4;
      }

      Mode var5 = ViewCompat.v(this.a);
      if (var5 != null) {
         var3.c = true;
         var3.b = var5;
      }

      if (!var3.d && !var3.c) {
         var2 = false;
      } else {
         AppCompatDrawableManager.a(var1, var3, this.a.getDrawableState());
      }

      return var2;
   }

   private boolean d() {
      boolean var2 = true;
      int var1 = VERSION.SDK_INT;
      if (var1 > 21) {
         if (this.d == null) {
            var2 = false;
         }
      } else if (var1 != 21) {
         var2 = false;
      }

      return var2;
   }

   ColorStateList a() {
      ColorStateList var1;
      if (this.e != null) {
         var1 = this.e.a;
      } else {
         var1 = null;
      }

      return var1;
   }

   void a(int var1) {
      this.c = var1;
      ColorStateList var2;
      if (this.b != null) {
         var2 = this.b.b(this.a.getContext(), var1);
      } else {
         var2 = null;
      }

      this.b(var2);
      this.c();
   }

   void a(ColorStateList var1) {
      if (this.e == null) {
         this.e = new TintInfo();
      }

      this.e.a = var1;
      this.e.d = true;
      this.c();
   }

   void a(Mode var1) {
      if (this.e == null) {
         this.e = new TintInfo();
      }

      this.e.b = var1;
      this.e.c = true;
      this.c();
   }

   void a(Drawable var1) {
      this.c = -1;
      this.b((ColorStateList)null);
      this.c();
   }

   void a(AttributeSet param1, int param2) {
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
      // 01: getfield android/support/v7/widget/AppCompatBackgroundHelper.a Landroid/view/View;
      // 04: invokevirtual android/view/View.getContext ()Landroid/content/Context;
      // 07: aload 1
      // 08: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper [I
      // 0b: iload 2
      // 0c: bipush 0
      // 0d: invokestatic android/support/v7/widget/TintTypedArray.a (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
      // 10: astore 1
      // 11: aload 1
      // 12: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_android_background I
      // 15: invokevirtual android/support/v7/widget/TintTypedArray.g (I)Z
      // 18: ifeq 43
      // 1b: aload 0
      // 1c: aload 1
      // 1d: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_android_background I
      // 20: bipush -1
      // 21: invokevirtual android/support/v7/widget/TintTypedArray.g (II)I
      // 24: putfield android/support/v7/widget/AppCompatBackgroundHelper.c I
      // 27: aload 0
      // 28: getfield android/support/v7/widget/AppCompatBackgroundHelper.b Landroid/support/v7/widget/AppCompatDrawableManager;
      // 2b: aload 0
      // 2c: getfield android/support/v7/widget/AppCompatBackgroundHelper.a Landroid/view/View;
      // 2f: invokevirtual android/view/View.getContext ()Landroid/content/Context;
      // 32: aload 0
      // 33: getfield android/support/v7/widget/AppCompatBackgroundHelper.c I
      // 36: invokevirtual android/support/v7/widget/AppCompatDrawableManager.b (Landroid/content/Context;I)Landroid/content/res/ColorStateList;
      // 39: astore 3
      // 3a: aload 3
      // 3b: ifnull 43
      // 3e: aload 0
      // 3f: aload 3
      // 40: invokevirtual android/support/v7/widget/AppCompatBackgroundHelper.b (Landroid/content/res/ColorStateList;)V
      // 43: aload 1
      // 44: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_backgroundTint I
      // 47: invokevirtual android/support/v7/widget/TintTypedArray.g (I)Z
      // 4a: ifeq 5b
      // 4d: aload 0
      // 4e: getfield android/support/v7/widget/AppCompatBackgroundHelper.a Landroid/view/View;
      // 51: aload 1
      // 52: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_backgroundTint I
      // 55: invokevirtual android/support/v7/widget/TintTypedArray.e (I)Landroid/content/res/ColorStateList;
      // 58: invokestatic android/support/v4/view/ViewCompat.a (Landroid/view/View;Landroid/content/res/ColorStateList;)V
      // 5b: aload 1
      // 5c: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_backgroundTintMode I
      // 5f: invokevirtual android/support/v7/widget/TintTypedArray.g (I)Z
      // 62: ifeq 78
      // 65: aload 0
      // 66: getfield android/support/v7/widget/AppCompatBackgroundHelper.a Landroid/view/View;
      // 69: aload 1
      // 6a: getstatic android/support/v7/appcompat/R$styleable.ViewBackgroundHelper_backgroundTintMode I
      // 6d: bipush -1
      // 6e: invokevirtual android/support/v7/widget/TintTypedArray.a (II)I
      // 71: aconst_null
      // 72: invokestatic android/support/v7/widget/DrawableUtils.a (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
      // 75: invokestatic android/support/v4/view/ViewCompat.a (Landroid/view/View;Landroid/graphics/PorterDuff$Mode;)V
      // 78: aload 1
      // 79: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 7c: return
      // 7d: astore 3
      // 7e: aload 1
      // 7f: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 82: aload 3
      // 83: athrow
      // try (9 -> 28): 59 null
      // try (30 -> 33): 59 null
      // try (33 -> 43): 59 null
      // try (43 -> 56): 59 null
   }

   Mode b() {
      Mode var1;
      if (this.e != null) {
         var1 = this.e.b;
      } else {
         var1 = null;
      }

      return var1;
   }

   void b(ColorStateList var1) {
      if (var1 != null) {
         if (this.d == null) {
            this.d = new TintInfo();
         }

         this.d.a = var1;
         this.d.d = true;
      } else {
         this.d = null;
      }

      this.c();
   }

   void c() {
      Drawable var1 = this.a.getBackground();
      if (var1 != null && (!this.d() || !this.b(var1))) {
         if (this.e != null) {
            AppCompatDrawableManager.a(var1, this.e, this.a.getDrawableState());
         } else if (this.d != null) {
            AppCompatDrawableManager.a(var1, this.d, this.a.getDrawableState());
         }
      }
   }
}
