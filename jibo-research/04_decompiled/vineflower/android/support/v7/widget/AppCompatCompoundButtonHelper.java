package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
   private final CompoundButton a;
   private ColorStateList b = null;
   private Mode c = null;
   private boolean d = false;
   private boolean e = false;
   private boolean f;

   AppCompatCompoundButtonHelper(CompoundButton var1) {
      this.a = var1;
   }

   int a(int var1) {
      int var2 = var1;
      if (VERSION.SDK_INT < 17) {
         Drawable var3 = CompoundButtonCompat.a(this.a);
         var2 = var1;
         if (var3 != null) {
            var2 = var1 + var3.getIntrinsicWidth();
         }
      }

      return var2;
   }

   ColorStateList a() {
      return this.b;
   }

   void a(ColorStateList var1) {
      this.b = var1;
      this.d = true;
      this.d();
   }

   void a(Mode var1) {
      this.c = var1;
      this.e = true;
      this.d();
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
      // 01: getfield android/support/v7/widget/AppCompatCompoundButtonHelper.a Landroid/widget/CompoundButton;
      // 04: invokevirtual android/widget/CompoundButton.getContext ()Landroid/content/Context;
      // 07: aload 1
      // 08: getstatic android/support/v7/appcompat/R$styleable.CompoundButton [I
      // 0b: iload 2
      // 0c: bipush 0
      // 0d: invokevirtual android/content/Context.obtainStyledAttributes (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
      // 10: astore 1
      // 11: aload 1
      // 12: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_android_button I
      // 15: invokevirtual android/content/res/TypedArray.hasValue (I)Z
      // 18: ifeq 3a
      // 1b: aload 1
      // 1c: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_android_button I
      // 1f: bipush 0
      // 20: invokevirtual android/content/res/TypedArray.getResourceId (II)I
      // 23: istore 2
      // 24: iload 2
      // 25: ifeq 3a
      // 28: aload 0
      // 29: getfield android/support/v7/widget/AppCompatCompoundButtonHelper.a Landroid/widget/CompoundButton;
      // 2c: aload 0
      // 2d: getfield android/support/v7/widget/AppCompatCompoundButtonHelper.a Landroid/widget/CompoundButton;
      // 30: invokevirtual android/widget/CompoundButton.getContext ()Landroid/content/Context;
      // 33: iload 2
      // 34: invokestatic android/support/v7/content/res/AppCompatResources.b (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
      // 37: invokevirtual android/widget/CompoundButton.setButtonDrawable (Landroid/graphics/drawable/Drawable;)V
      // 3a: aload 1
      // 3b: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_buttonTint I
      // 3e: invokevirtual android/content/res/TypedArray.hasValue (I)Z
      // 41: ifeq 52
      // 44: aload 0
      // 45: getfield android/support/v7/widget/AppCompatCompoundButtonHelper.a Landroid/widget/CompoundButton;
      // 48: aload 1
      // 49: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_buttonTint I
      // 4c: invokevirtual android/content/res/TypedArray.getColorStateList (I)Landroid/content/res/ColorStateList;
      // 4f: invokestatic android/support/v4/widget/CompoundButtonCompat.a (Landroid/widget/CompoundButton;Landroid/content/res/ColorStateList;)V
      // 52: aload 1
      // 53: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_buttonTintMode I
      // 56: invokevirtual android/content/res/TypedArray.hasValue (I)Z
      // 59: ifeq 6f
      // 5c: aload 0
      // 5d: getfield android/support/v7/widget/AppCompatCompoundButtonHelper.a Landroid/widget/CompoundButton;
      // 60: aload 1
      // 61: getstatic android/support/v7/appcompat/R$styleable.CompoundButton_buttonTintMode I
      // 64: bipush -1
      // 65: invokevirtual android/content/res/TypedArray.getInt (II)I
      // 68: aconst_null
      // 69: invokestatic android/support/v7/widget/DrawableUtils.a (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;
      // 6c: invokestatic android/support/v4/widget/CompoundButtonCompat.a (Landroid/widget/CompoundButton;Landroid/graphics/PorterDuff$Mode;)V
      // 6f: aload 1
      // 70: invokevirtual android/content/res/TypedArray.recycle ()V
      // 73: return
      // 74: astore 3
      // 75: aload 1
      // 76: invokevirtual android/content/res/TypedArray.recycle ()V
      // 79: aload 3
      // 7a: athrow
      // try (9 -> 18): 54 null
      // try (20 -> 28): 54 null
      // try (28 -> 38): 54 null
      // try (38 -> 51): 54 null
   }

   Mode b() {
      return this.c;
   }

   void c() {
      if (this.f) {
         this.f = false;
      } else {
         this.f = true;
         this.d();
      }
   }

   void d() {
      Drawable var1 = CompoundButtonCompat.a(this.a);
      if (var1 != null && (this.d || this.e)) {
         var1 = DrawableCompat.g(var1).mutate();
         if (this.d) {
            DrawableCompat.a(var1, this.b);
         }

         if (this.e) {
            DrawableCompat.a(var1, this.c);
         }

         if (var1.isStateful()) {
            var1.setState(this.a.getDrawableState());
         }

         this.a.setButtonDrawable(var1);
      }
   }
}
