package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper {
   private final ImageView a;
   private TintInfo b;
   private TintInfo c;
   private TintInfo d;

   public AppCompatImageHelper(ImageView var1) {
      this.a = var1;
   }

   private boolean a(Drawable var1) {
      boolean var2 = true;
      if (this.d == null) {
         this.d = new TintInfo();
      }

      TintInfo var3 = this.d;
      var3.a();
      ColorStateList var4 = ImageViewCompat.a(this.a);
      if (var4 != null) {
         var3.d = true;
         var3.a = var4;
      }

      Mode var5 = ImageViewCompat.b(this.a);
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

   private boolean e() {
      boolean var2 = true;
      int var1 = VERSION.SDK_INT;
      if (var1 > 21) {
         if (this.b == null) {
            var2 = false;
         }
      } else if (var1 != 21) {
         var2 = false;
      }

      return var2;
   }

   public void a(int var1) {
      if (var1 != 0) {
         Drawable var2 = AppCompatResources.b(this.a.getContext(), var1);
         if (var2 != null) {
            DrawableUtils.b(var2);
         }

         this.a.setImageDrawable(var2);
      } else {
         this.a.setImageDrawable(null);
      }

      this.d();
   }

   void a(ColorStateList var1) {
      if (this.c == null) {
         this.c = new TintInfo();
      }

      this.c.a = var1;
      this.c.d = true;
      this.d();
   }

   void a(Mode var1) {
      if (this.c == null) {
         this.c = new TintInfo();
      }

      this.c.b = var1;
      this.c.c = true;
      this.d();
   }

   public void a(AttributeSet param1, int param2) {
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
      // 01: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 04: invokevirtual android/widget/ImageView.getContext ()Landroid/content/Context;
      // 07: aload 1
      // 08: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView [I
      // 0b: iload 2
      // 0c: bipush 0
      // 0d: invokestatic android/support/v7/widget/TintTypedArray.a (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
      // 10: astore 4
      // 12: aload 0
      // 13: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 16: invokevirtual android/widget/ImageView.getDrawable ()Landroid/graphics/drawable/Drawable;
      // 19: astore 3
      // 1a: aload 3
      // 1b: astore 1
      // 1c: aload 3
      // 1d: ifnonnull 4d
      // 20: aload 4
      // 22: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView_srcCompat I
      // 25: bipush -1
      // 26: invokevirtual android/support/v7/widget/TintTypedArray.g (II)I
      // 29: istore 2
      // 2a: aload 3
      // 2b: astore 1
      // 2c: iload 2
      // 2d: bipush -1
      // 2e: if_icmpeq 4d
      // 31: aload 0
      // 32: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 35: invokevirtual android/widget/ImageView.getContext ()Landroid/content/Context;
      // 38: iload 2
      // 39: invokestatic android/support/v7/content/res/AppCompatResources.b (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
      // 3c: astore 3
      // 3d: aload 3
      // 3e: astore 1
      // 3f: aload 3
      // 40: ifnull 4d
      // 43: aload 0
      // 44: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 47: aload 3
      // 48: invokevirtual android/widget/ImageView.setImageDrawable (Landroid/graphics/drawable/Drawable;)V
      // 4b: aload 3
      // 4c: astore 1
      // 4d: aload 1
      // 4e: ifnull 55
      // 51: aload 1
      // 52: invokestatic android/support/v7/widget/DrawableUtils.b (Landroid/graphics/drawable/Drawable;)V
      // 55: aload 4
      // 57: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView_tint I
      // 5a: invokevirtual android/support/v7/widget/TintTypedArray.g (I)Z
      // 5d: ifeq 6f
      // 60: aload 0
      // 61: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 64: aload 4
      // 66: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView_tint I
      // 69: invokevirtual android/support/v7/widget/TintTypedArray.e (I)Landroid/content/res/ColorStateList;
      // 6c: invokestatic android/support/v4/widget/ImageViewCompat.a (Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V
      // 6f: aload 4
      // 71: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView_tintMode I
      // 74: invokevirtual android/support/v7/widget/TintTypedArray.g (I)Z
      // 77: ifeq 8e
      // 7a: aload 0
      // 7b: getfield android/support/v7/widget/AppCompatImageHelper.a Landroid/widget/ImageView;
      // 7e: aload 4
      // 80: getstatic android/support/v7/appcompat/R$styleable.AppCompatImageView_tintMode I
      // 83: bipush -1
      // 84: invokevirtual android/support/v7/widget/TintTypedArray.a (II)I
      // 87: aconst_null
      // 88: invokestatic android/support/v7/widget/DrawableUtils.a (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
      // 8b: invokestatic android/support/v4/widget/ImageViewCompat.a (Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V
      // 8e: aload 4
      // 90: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 93: return
      // 94: astore 1
      // 95: aload 4
      // 97: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 9a: aload 1
      // 9b: athrow
      // try (9 -> 13): 73 null
      // try (17 -> 22): 73 null
      // try (27 -> 33): 73 null
      // try (37 -> 41): 73 null
      // try (45 -> 47): 73 null
      // try (47 -> 57): 73 null
      // try (57 -> 70): 73 null
   }

   boolean a() {
      Drawable var2 = this.a.getBackground();
      boolean var1;
      if (VERSION.SDK_INT >= 21 && var2 instanceof RippleDrawable) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   ColorStateList b() {
      ColorStateList var1;
      if (this.c != null) {
         var1 = this.c.a;
      } else {
         var1 = null;
      }

      return var1;
   }

   Mode c() {
      Mode var1;
      if (this.c != null) {
         var1 = this.c.b;
      } else {
         var1 = null;
      }

      return var1;
   }

   void d() {
      Drawable var1 = this.a.getDrawable();
      if (var1 != null) {
         DrawableUtils.b(var1);
      }

      if (var1 != null && (!this.e() || !this.a(var1))) {
         if (this.c != null) {
            AppCompatDrawableManager.a(var1, this.c, this.a.getDrawableState());
         } else if (this.b != null) {
            AppCompatDrawableManager.a(var1, this.b, this.a.getDrawableState());
         }
      }
   }
}
