package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.Layout.Alignment;
import android.text.StaticLayout.Builder;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper {
   private static final RectF a = new RectF();
   private static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap<>();
   private int c = 0;
   private boolean d = false;
   private float e = -1.0F;
   private float f = -1.0F;
   private float g = -1.0F;
   private int[] h = new int[0];
   private boolean i = false;
   private TextPaint j;
   private final TextView k;
   private final Context l;

   AppCompatTextViewAutoSizeHelper(TextView var1) {
      this.k = var1;
      this.l = this.k.getContext();
   }

   private int a(RectF var1) {
      int var4 = this.h.length;
      if (var4 == 0) {
         throw new IllegalStateException("No available text sizes to choose from.");
      }

      int var3 = 0;
      int var2 = 1;
      var4--;

      while (var2 <= var4) {
         int var5 = (var2 + var4) / 2;
         if (this.a(this.h[var5], var1)) {
            var3 = var2;
            var2 = var5 + 1;
         } else {
            var4 = var5 - 1;
            var3 = var4;
         }
      }

      return this.h[var3];
   }

   private StaticLayout a(CharSequence var1, Alignment var2, int var3) {
      float var4;
      float var5;
      boolean var6;
      if (VERSION.SDK_INT >= 16) {
         var4 = this.k.getLineSpacingMultiplier();
         var5 = this.k.getLineSpacingExtra();
         var6 = this.k.getIncludeFontPadding();
      } else {
         var4 = this.a(this.k, "getLineSpacingMultiplier", 1.0F);
         var5 = this.a(this.k, "getLineSpacingExtra", 0.0F);
         var6 = this.a(this.k, "getIncludeFontPadding", true);
      }

      return new StaticLayout(var1, this.j, var3, var2, var4, var5, var6);
   }

   private StaticLayout a(CharSequence var1, Alignment var2, int var3, int var4) {
      TextDirectionHeuristic var5 = this.a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
      Builder var6 = Builder.obtain(var1, 0, var1.length(), this.j, var3)
         .setAlignment(var2)
         .setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier())
         .setIncludePad(this.k.getIncludeFontPadding())
         .setBreakStrategy(this.k.getBreakStrategy())
         .setHyphenationFrequency(this.k.getHyphenationFrequency());
      var3 = var4;
      if (var4 == -1) {
         var3 = Integer.MAX_VALUE;
      }

      return var6.setMaxLines(var3).setTextDirection(var5).build();
   }

   private <T> T a(Object param1, String param2, T param3) {
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
      // 00: bipush 0
      // 01: istore 4
      // 03: aload 0
      // 04: aload 2
      // 05: invokespecial android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a (Ljava/lang/String;)Ljava/lang/reflect/Method;
      // 08: aload 1
      // 09: bipush 0
      // 0a: anewarray 4
      // 0d: invokevirtual java/lang/reflect/Method.invoke (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      // 10: astore 1
      // 11: aload 1
      // 12: astore 3
      // 13: aload 1
      // 14: ifnonnull 17
      // 17: aload 3
      // 18: areturn
      // 19: astore 6
      // 1b: bipush 1
      // 1c: istore 5
      // 1e: iload 5
      // 20: istore 4
      // 22: new java/lang/StringBuilder
      // 25: astore 1
      // 26: iload 5
      // 28: istore 4
      // 2a: aload 1
      // 2b: invokespecial java/lang/StringBuilder.<init> ()V
      // 2e: iload 5
      // 30: istore 4
      // 32: ldc "ACTVAutoSizeHelper"
      // 34: aload 1
      // 35: ldc "Failed to invoke TextView#"
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: aload 2
      // 3b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e: ldc "() method"
      // 40: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 43: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 46: aload 6
      // 48: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 4b: pop
      // 4c: bipush 0
      // 4d: ifeq 17
      // 50: aconst_null
      // 51: astore 3
      // 52: goto 17
      // 55: astore 1
      // 56: bipush 0
      // 57: ifne 5f
      // 5a: iload 4
      // 5c: ifeq 5f
      // 5f: aload 1
      // 60: athrow
      // try (2 -> 10): 16 java/lang/Exception
      // try (2 -> 10): 46 null
      // try (21 -> 23): 46 null
      // try (25 -> 27): 46 null
      // try (29 -> 41): 46 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private Method a(String var1) {
      Method var3;
      try {
         var3 = b.get(var1);
      } catch (Exception var6) {
         Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + var1 + "() method", var6);
         return null;
      }

      Method var2 = var3;
      if (var3 == null) {
         try {
            var3 = TextView.class.getDeclaredMethod(var1);
         } catch (Exception var5) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + var1 + "() method", var5);
            var2 = null;
            return var2;
         }

         var2 = var3;
         if (var3 != null) {
            try {
               var3.setAccessible(true);
               b.put(var1, var3);
            } catch (Exception var4) {
               Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + var1 + "() method", var4);
               var2 = null;
               return var2;
            }

            var2 = var3;
         }
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(float var1) {
      if (var1 != this.k.getPaint().getTextSize()) {
         this.k.getPaint().setTextSize(var1);
         boolean var2;
         if (VERSION.SDK_INT >= 18) {
            var2 = this.k.isInLayout();
         } else {
            var2 = false;
         }

         if (this.k.getLayout() != null) {
            this.d = false;

            label30: {
               Method var3;
               try {
                  var3 = this.a("nullLayouts");
               } catch (Exception var5) {
                  Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", var5);
                  break label30;
               }

               if (var3 != null) {
                  try {
                     var3.invoke(this.k);
                  } catch (Exception var4) {
                     Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", var4);
                  }
               }
            }

            if (!var2) {
               this.k.requestLayout();
            } else {
               this.k.forceLayout();
            }

            this.k.invalidate();
         }
      }
   }

   private void a(float var1, float var2, float var3) throws IllegalArgumentException {
      if (var1 <= 0.0F) {
         throw new IllegalArgumentException("Minimum auto-size text size (" + var1 + "px) is less or equal to (0px)");
      }

      if (var2 <= var1) {
         throw new IllegalArgumentException(
            "Maximum auto-size text size (" + var2 + "px) is less or equal to minimum auto-size " + "text size (" + var1 + "px)"
         );
      }

      if (var3 <= 0.0F) {
         throw new IllegalArgumentException("The auto-size step granularity (" + var3 + "px) is less or equal to (0px)");
      }

      this.c = 1;
      this.f = var1;
      this.g = var2;
      this.e = var3;
      this.i = false;
   }

   private void a(TypedArray var1) {
      int var3 = var1.length();
      int[] var4 = new int[var3];
      if (var3 > 0) {
         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2] = var1.getDimensionPixelSize(var2, -1);
         }

         this.h = this.a(var4);
         this.h();
      }
   }

   private boolean a(int var1, RectF var2) {
      CharSequence var6 = this.k.getText();
      TransformationMethod var7 = this.k.getTransformationMethod();
      CharSequence var5 = var6;
      if (var7 != null) {
         CharSequence var10 = var7.getTransformation(var6, this.k);
         var5 = var6;
         if (var10 != null) {
            var5 = var10;
         }
      }

      int var3;
      if (VERSION.SDK_INT >= 16) {
         var3 = this.k.getMaxLines();
      } else {
         var3 = -1;
      }

      if (this.j == null) {
         this.j = new TextPaint();
      } else {
         this.j.reset();
      }

      this.j.set(this.k.getPaint());
      this.j.setTextSize(var1);
      Alignment var8 = this.a(this.k, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
      StaticLayout var9;
      if (VERSION.SDK_INT >= 23) {
         var9 = this.a(var5, var8, Math.round(var2.right), var3);
      } else {
         var9 = this.a(var5, var8, Math.round(var2.right));
      }

      boolean var4;
      if (var3 == -1 || var9.getLineCount() <= var3 && var9.getLineEnd(var9.getLineCount() - 1) == var5.length()) {
         if (var9.getHeight() > var2.bottom) {
            var4 = false;
         } else {
            var4 = true;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   private int[] a(int[] var1) {
      int var3 = var1.length;
      if (var3 != 0) {
         Arrays.sort(var1);
         ArrayList var6 = new ArrayList();

         for (int var2 = 0; var2 < var3; var2++) {
            int var4 = var1[var2];
            if (var4 > 0 && Collections.binarySearch(var6, var4) < 0) {
               var6.add(var4);
            }
         }

         if (var3 != var6.size()) {
            var3 = var6.size();
            int[] var5 = new int[var3];
            int var7 = 0;

            while (true) {
               var1 = var5;
               if (var7 >= var3) {
                  break;
               }

               var5[var7] = (Integer)var6.get(var7);
               var7++;
            }
         }
      }

      return var1;
   }

   private boolean h() {
      int var1 = this.h.length;
      boolean var2;
      if (var1 > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.i = var2;
      if (this.i) {
         this.c = 1;
         this.f = this.h[0];
         this.g = this.h[var1 - 1];
         this.e = -1.0F;
      }

      return this.i;
   }

   private boolean i() {
      if (this.k() && this.c == 1) {
         if (!this.i || this.h.length == 0) {
            float var1 = Math.round(this.f);
            int var2 = 1;

            while (Math.round(this.e + var1) <= Math.round(this.g)) {
               var2++;
               var1 += this.e;
            }

            int[] var4 = new int[var2];
            var1 = this.f;

            for (int var3 = 0; var3 < var2; var3++) {
               var4[var3] = Math.round(var1);
               var1 += this.e;
            }

            this.h = this.a(var4);
         }

         this.d = true;
      } else {
         this.d = false;
      }

      return this.d;
   }

   private void j() {
      this.c = 0;
      this.f = -1.0F;
      this.g = -1.0F;
      this.e = -1.0F;
      this.h = new int[0];
      this.d = false;
   }

   private boolean k() {
      boolean var1;
      if (!(this.k instanceof AppCompatEditText)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   int a() {
      return this.c;
   }

   void a(int var1) {
      if (this.k()) {
         switch (var1) {
            case 0:
               this.j();
               break;
            case 1:
               DisplayMetrics var2 = this.l.getResources().getDisplayMetrics();
               this.a(TypedValue.applyDimension(2, 12.0F, var2), TypedValue.applyDimension(2, 112.0F, var2), 1.0F);
               if (this.i()) {
                  this.f();
               }
               break;
            default:
               throw new IllegalArgumentException("Unknown auto-size text type: " + var1);
         }
      }
   }

   void a(int var1, float var2) {
      Resources var3;
      if (this.l == null) {
         var3 = Resources.getSystem();
      } else {
         var3 = this.l.getResources();
      }

      this.a(TypedValue.applyDimension(var1, var2, var3.getDisplayMetrics()));
   }

   void a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      if (this.k()) {
         DisplayMetrics var5 = this.l.getResources().getDisplayMetrics();
         this.a(TypedValue.applyDimension(var4, var1, var5), TypedValue.applyDimension(var4, var2, var5), TypedValue.applyDimension(var4, var3, var5));
         if (this.i()) {
            this.f();
         }
      }
   }

   void a(AttributeSet var1, int var2) {
      TypedArray var7 = this.l.obtainStyledAttributes(var1, R.styleable.AppCompatTextView, var2, 0);
      if (var7.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
         this.c = var7.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
      }

      float var3;
      if (var7.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
         var3 = var7.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
      } else {
         var3 = -1.0F;
      }

      float var5;
      if (var7.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
         var5 = var7.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
      } else {
         var5 = -1.0F;
      }

      float var4;
      if (var7.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
         var4 = var7.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
      } else {
         var4 = -1.0F;
      }

      if (var7.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes)) {
         var2 = var7.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
         if (var2 > 0) {
            TypedArray var8 = var7.getResources().obtainTypedArray(var2);
            this.a(var8);
            var8.recycle();
         }
      }

      var7.recycle();
      if (this.k()) {
         if (this.c == 1) {
            if (!this.i) {
               DisplayMetrics var9 = this.l.getResources().getDisplayMetrics();
               float var6 = var5;
               if (var5 == -1.0F) {
                  var6 = TypedValue.applyDimension(2, 12.0F, var9);
               }

               var5 = var4;
               if (var4 == -1.0F) {
                  var5 = TypedValue.applyDimension(2, 112.0F, var9);
               }

               var4 = var3;
               if (var3 == -1.0F) {
                  var4 = 1.0F;
               }

               this.a(var6, var5, var4);
            }

            this.i();
         }
      } else {
         this.c = 0;
      }
   }

   void a(int[] var1, int var2) throws IllegalArgumentException {
      int var3 = 0;
      if (this.k()) {
         int var4 = var1.length;
         if (var4 <= 0) {
            this.i = false;
         } else {
            int[] var6 = new int[var4];
            int[] var5;
            if (var2 == 0) {
               var5 = Arrays.copyOf(var1, var4);
            } else {
               DisplayMetrics var7 = this.l.getResources().getDisplayMetrics();

               while (true) {
                  var5 = var6;
                  if (var3 >= var4) {
                     break;
                  }

                  var6[var3] = Math.round(TypedValue.applyDimension(var2, var1[var3], var7));
                  var3++;
               }
            }

            this.h = this.a(var5);
            if (!this.h()) {
               throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(var1));
            }
         }

         if (this.i()) {
            this.f();
         }
      }
   }

   int b() {
      return Math.round(this.e);
   }

   int c() {
      return Math.round(this.f);
   }

   int d() {
      return Math.round(this.g);
   }

   int[] e() {
      return this.h;
   }

   void f() {
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
      // 00: aload 0
      // 01: invokevirtual android/support/v7/widget/AppCompatTextViewAutoSizeHelper.g ()Z
      // 04: ifne 08
      // 07: return
      // 08: aload 0
      // 09: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.d Z
      // 0c: ifeq 9b
      // 0f: aload 0
      // 10: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 13: invokevirtual android/widget/TextView.getMeasuredHeight ()I
      // 16: ifle 07
      // 19: aload 0
      // 1a: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 1d: invokevirtual android/widget/TextView.getMeasuredWidth ()I
      // 20: ifle 07
      // 23: aload 0
      // 24: aload 0
      // 25: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 28: ldc_w "getHorizontallyScrolling"
      // 2b: bipush 0
      // 2c: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 2f: invokespecial android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      // 32: checkcast java/lang/Boolean
      // 35: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 38: ifeq a3
      // 3b: ldc_w 1048576
      // 3e: istore 2
      // 3f: aload 0
      // 40: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 43: invokevirtual android/widget/TextView.getHeight ()I
      // 46: aload 0
      // 47: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 4a: invokevirtual android/widget/TextView.getCompoundPaddingBottom ()I
      // 4d: isub
      // 4e: aload 0
      // 4f: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 52: invokevirtual android/widget/TextView.getCompoundPaddingTop ()I
      // 55: isub
      // 56: istore 3
      // 57: iload 2
      // 58: ifle 07
      // 5b: iload 3
      // 5c: ifle 07
      // 5f: getstatic android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a Landroid/graphics/RectF;
      // 62: astore 4
      // 64: aload 4
      // 66: monitorenter
      // 67: getstatic android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a Landroid/graphics/RectF;
      // 6a: invokevirtual android/graphics/RectF.setEmpty ()V
      // 6d: getstatic android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a Landroid/graphics/RectF;
      // 70: iload 2
      // 71: i2f
      // 72: putfield android/graphics/RectF.right F
      // 75: getstatic android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a Landroid/graphics/RectF;
      // 78: iload 3
      // 79: i2f
      // 7a: putfield android/graphics/RectF.bottom F
      // 7d: aload 0
      // 7e: getstatic android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a Landroid/graphics/RectF;
      // 81: invokespecial android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a (Landroid/graphics/RectF;)I
      // 84: i2f
      // 85: fstore 1
      // 86: fload 1
      // 87: aload 0
      // 88: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // 8b: invokevirtual android/widget/TextView.getTextSize ()F
      // 8e: fcmpl
      // 8f: ifeq 98
      // 92: aload 0
      // 93: bipush 0
      // 94: fload 1
      // 95: invokevirtual android/support/v7/widget/AppCompatTextViewAutoSizeHelper.a (IF)V
      // 98: aload 4
      // 9a: monitorexit
      // 9b: aload 0
      // 9c: bipush 1
      // 9d: putfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.d Z
      // a0: goto 07
      // a3: aload 0
      // a4: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // a7: invokevirtual android/widget/TextView.getMeasuredWidth ()I
      // aa: aload 0
      // ab: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // ae: invokevirtual android/widget/TextView.getTotalPaddingLeft ()I
      // b1: isub
      // b2: aload 0
      // b3: getfield android/support/v7/widget/AppCompatTextViewAutoSizeHelper.k Landroid/widget/TextView;
      // b6: invokevirtual android/widget/TextView.getTotalPaddingRight ()I
      // b9: isub
      // ba: istore 2
      // bb: goto 3f
      // be: astore 5
      // c0: aload 4
      // c2: monitorexit
      // c3: aload 5
      // c5: athrow
      // try (47 -> 72): 91 null
      // try (72 -> 74): 91 null
      // try (92 -> 94): 91 null
   }

   boolean g() {
      boolean var1;
      if (this.k() && this.c != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
