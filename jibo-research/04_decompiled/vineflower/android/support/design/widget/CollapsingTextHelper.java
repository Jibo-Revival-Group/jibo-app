package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class CollapsingTextHelper {
   private static final boolean a;
   private static final Paint b;
   private boolean A;
   private Bitmap B;
   private Paint C;
   private float D;
   private float E;
   private float F;
   private float G;
   private int[] H;
   private boolean I;
   private final TextPaint J;
   private Interpolator K;
   private Interpolator L;
   private float M;
   private float N;
   private float O;
   private int P;
   private float Q;
   private float R;
   private float S;
   private int T;
   private final View c;
   private boolean d;
   private float e;
   private final Rect f;
   private final Rect g;
   private final RectF h;
   private int i = 16;
   private int j = 16;
   private float k = 15.0F;
   private float l = 15.0F;
   private ColorStateList m;
   private ColorStateList n;
   private float o;
   private float p;
   private float q;
   private float r;
   private float s;
   private float t;
   private Typeface u;
   private Typeface v;
   private Typeface w;
   private CharSequence x;
   private CharSequence y;
   private boolean z;

   static {
      boolean var0;
      if (VERSION.SDK_INT < 18) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
      b = null;
      if (b != null) {
         b.setAntiAlias(true);
         b.setColor(-65281);
      }
   }

   public CollapsingTextHelper(View var1) {
      this.c = var1;
      this.J = new TextPaint(129);
      this.g = new Rect();
      this.f = new Rect();
      this.h = new RectF();
   }

   private static float a(float var0, float var1, float var2, Interpolator var3) {
      float var4 = var2;
      if (var3 != null) {
         var4 = var3.getInterpolation(var2);
      }

      return AnimationUtils.a(var0, var1, var4);
   }

   private static int a(int var0, int var1, float var2) {
      float var3 = 1.0F - var2;
      float var6 = Color.alpha(var0);
      float var10 = Color.alpha(var1);
      float var5 = Color.red(var0);
      float var8 = Color.red(var1);
      float var7 = Color.green(var0);
      float var11 = Color.green(var1);
      float var4 = Color.blue(var0);
      float var9 = Color.blue(var1);
      return Color.argb(
         (int)(var6 * var3 + var10 * var2), (int)(var5 * var3 + var8 * var2), (int)(var7 * var3 + var11 * var2), (int)(var3 * var4 + var9 * var2)
      );
   }

   private static boolean a(float var0, float var1) {
      boolean var2;
      if (Math.abs(var0 - var1) < 0.001F) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private static boolean a(Rect var0, int var1, int var2, int var3, int var4) {
      boolean var5;
      if (var0.left == var1 && var0.top == var2 && var0.right == var3 && var0.bottom == var4) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   private boolean a(Typeface var1, Typeface var2) {
      boolean var3;
      if ((var1 == null || var1.equals(var2)) && (var1 != null || var2 == null)) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private boolean b(CharSequence var1) {
      boolean var2 = true;
      if (ViewCompat.e(this.c) != 1) {
         var2 = false;
      }

      TextDirectionHeuristicCompat var3;
      if (var2) {
         var3 = TextDirectionHeuristicsCompat.d;
      } else {
         var3 = TextDirectionHeuristicsCompat.c;
      }

      return var3.a(var1, 0, var1.length());
   }

   private void c(float var1) {
      this.d(var1);
      this.s = a(this.q, this.r, var1, this.K);
      this.t = a(this.o, this.p, var1, this.K);
      this.e(a(this.k, this.l, var1, this.L));
      if (this.n != this.m) {
         this.J.setColor(a(this.m(), this.n(), var1));
      } else {
         this.J.setColor(this.n());
      }

      this.J.setShadowLayer(a(this.Q, this.M, var1, null), a(this.R, this.N, var1, null), a(this.S, this.O, var1, null), a(this.T, this.P, var1));
      ViewCompat.c(this.c);
   }

   private void d(float var1) {
      this.h.left = a(this.f.left, this.g.left, var1, this.K);
      this.h.top = a(this.o, this.p, var1, this.K);
      this.h.right = a(this.f.right, this.g.right, var1, this.K);
      this.h.bottom = a(this.f.bottom, this.g.bottom, var1, this.K);
   }

   private Typeface e(int param1) {
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
      // 01: getfield android/support/design/widget/CollapsingTextHelper.c Landroid/view/View;
      // 04: invokevirtual android/view/View.getContext ()Landroid/content/Context;
      // 07: iload 1
      // 08: bipush 1
      // 09: newarray 10
      // 0b: dup
      // 0c: bipush 0
      // 0d: ldc_w 16843692
      // 10: iastore
      // 11: invokevirtual android/content/Context.obtainStyledAttributes (I[I)Landroid/content/res/TypedArray;
      // 14: astore 3
      // 15: aload 3
      // 16: bipush 0
      // 17: invokevirtual android/content/res/TypedArray.getString (I)Ljava/lang/String;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: ifnull 2b
      // 1f: aload 2
      // 20: bipush 0
      // 21: invokestatic android/graphics/Typeface.create (Ljava/lang/String;I)Landroid/graphics/Typeface;
      // 24: astore 2
      // 25: aload 3
      // 26: invokevirtual android/content/res/TypedArray.recycle ()V
      // 29: aload 2
      // 2a: areturn
      // 2b: aload 3
      // 2c: invokevirtual android/content/res/TypedArray.recycle ()V
      // 2f: aconst_null
      // 30: astore 2
      // 31: goto 29
      // 34: astore 2
      // 35: aload 3
      // 36: invokevirtual android/content/res/TypedArray.recycle ()V
      // 39: aload 2
      // 3a: athrow
      // try (12 -> 16): 31 null
      // try (18 -> 22): 31 null
   }

   private void e(float var1) {
      this.f(var1);
      boolean var2;
      if (a && this.F != 1.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.A = var2;
      if (this.A) {
         this.p();
      }

      ViewCompat.c(this.c);
   }

   private void f(float var1) {
      boolean var7 = true;
      if (this.x != null) {
         float var3 = this.g.width();
         float var4 = this.f.width();
         float var2;
         boolean var5;
         if (a(var1, this.l)) {
            var2 = this.l;
            this.F = 1.0F;
            if (this.a(this.w, this.u)) {
               this.w = this.u;
               var5 = true;
               var1 = var3;
            } else {
               var5 = false;
               var1 = var3;
            }
         } else {
            var2 = this.k;
            if (this.a(this.w, this.v)) {
               this.w = this.v;
               var5 = true;
            } else {
               var5 = false;
            }

            if (a(var1, this.k)) {
               this.F = 1.0F;
            } else {
               this.F = var1 / this.k;
            }

            var1 = this.l / this.k;
            if (var4 * var1 > var3) {
               var1 = Math.min(var3 / var1, var4);
            } else {
               var1 = var4;
            }
         }

         boolean var6 = var5;
         if (var1 > 0.0F) {
            if (this.G == var2 && !this.I && !var5) {
               var5 = false;
            } else {
               var5 = true;
            }

            this.G = var2;
            this.I = false;
            var6 = var5;
         }

         if (this.y == null || var6) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.w);
            TextPaint var8 = this.J;
            if (this.F == 1.0F) {
               var7 = false;
            }

            var8.setLinearText(var7);
            CharSequence var12 = TextUtils.ellipsize(this.x, this.J, var1, TruncateAt.END);
            if (!TextUtils.equals(var12, this.y)) {
               this.y = var12;
               this.z = this.b(this.y);
            }
         }
      }
   }

   private void l() {
      this.c(this.e);
   }

   private int m() {
      int var1;
      if (this.H != null) {
         var1 = this.m.getColorForState(this.H, 0);
      } else {
         var1 = this.m.getDefaultColor();
      }

      return var1;
   }

   private int n() {
      int var1;
      if (this.H != null) {
         var1 = this.n.getColorForState(this.H, 0);
      } else {
         var1 = this.n.getDefaultColor();
      }

      return var1;
   }

   private void o() {
      byte var5 = 1;
      float var2 = 0.0F;
      float var3 = this.G;
      this.f(this.l);
      float var1;
      if (this.y != null) {
         var1 = this.J.measureText(this.y, 0, this.y.length());
      } else {
         var1 = 0.0F;
      }

      int var6 = this.j;
      byte var4;
      if (this.z) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var4 = GravityCompat.a(var6, var4);
      switch (var4 & 112) {
         case 48:
            this.p = this.g.top - this.J.ascent();
            break;
         case 80:
            this.p = this.g.bottom;
            break;
         default:
            this.p = (this.J.descent() - this.J.ascent()) / 2.0F - this.J.descent() + this.g.centerY();
      }

      switch (var4 & 8388615) {
         case 1:
            this.r = this.g.centerX() - var1 / 2.0F;
            break;
         case 5:
            this.r = this.g.right - var1;
            break;
         default:
            this.r = this.g.left;
      }

      this.f(this.k);
      var1 = var2;
      if (this.y != null) {
         var1 = this.J.measureText(this.y, 0, this.y.length());
      }

      var6 = this.i;
      byte var9;
      if (this.z) {
         var9 = var5;
      } else {
         var9 = 0;
      }

      var9 = GravityCompat.a(var6, var9);
      switch (var9 & 112) {
         case 48:
            this.o = this.f.top - this.J.ascent();
            break;
         case 80:
            this.o = this.f.bottom;
            break;
         default:
            this.o = (this.J.descent() - this.J.ascent()) / 2.0F - this.J.descent() + this.f.centerY();
      }

      switch (var9 & 8388615) {
         case 1:
            this.q = this.f.centerX() - var1 / 2.0F;
            break;
         case 5:
            this.q = this.f.right - var1;
            break;
         default:
            this.q = this.f.left;
      }

      this.q();
      this.e(var3);
   }

   private void p() {
      if (this.B == null && !this.f.isEmpty() && !TextUtils.isEmpty(this.y)) {
         this.c(0.0F);
         this.D = this.J.ascent();
         this.E = this.J.descent();
         int var2 = Math.round(this.J.measureText(this.y, 0, this.y.length()));
         int var1 = Math.round(this.E - this.D);
         if (var2 > 0 && var1 > 0) {
            this.B = Bitmap.createBitmap(var2, var1, Config.ARGB_8888);
            new Canvas(this.B).drawText(this.y, 0, this.y.length(), 0.0F, var1 - this.J.descent(), this.J);
            if (this.C == null) {
               this.C = new Paint(3);
            }
         }
      }
   }

   private void q() {
      if (this.B != null) {
         this.B.recycle();
         this.B = null;
      }
   }

   void a() {
      boolean var1;
      if (this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.d = var1;
   }

   void a(float var1) {
      if (this.k != var1) {
         this.k = var1;
         this.i();
      }
   }

   void a(int var1) {
      if (this.i != var1) {
         this.i = var1;
         this.i();
      }
   }

   void a(int var1, int var2, int var3, int var4) {
      if (!a(this.f, var1, var2, var3, var4)) {
         this.f.set(var1, var2, var3, var4);
         this.I = true;
         this.a();
      }
   }

   void a(ColorStateList var1) {
      if (this.n != var1) {
         this.n = var1;
         this.i();
      }
   }

   public void a(Canvas var1) {
      int var7 = var1.save();
      if (this.y != null && this.d) {
         float var5 = this.s;
         float var4 = this.t;
         boolean var6;
         if (this.A && this.B != null) {
            var6 = true;
         } else {
            var6 = false;
         }

         float var2;
         if (var6) {
            var2 = this.D * this.F;
            float var3 = this.E;
            var3 = this.F;
         } else {
            var2 = this.J.ascent() * this.F;
            this.J.descent();
            float var9 = this.F;
         }

         float var10 = var4;
         if (var6) {
            var10 = var4 + var2;
         }

         if (this.F != 1.0F) {
            var1.scale(this.F, this.F, var5, var10);
         }

         if (var6) {
            var1.drawBitmap(this.B, var5, var10, this.C);
         } else {
            var1.drawText(this.y, 0, this.y.length(), var5, var10, this.J);
         }
      }

      var1.restoreToCount(var7);
   }

   void a(Typeface var1) {
      if (this.a(this.u, var1)) {
         this.u = var1;
         this.i();
      }
   }

   void a(Interpolator var1) {
      this.L = var1;
      this.i();
   }

   void a(CharSequence var1) {
      if (var1 == null || !var1.equals(this.x)) {
         this.x = var1;
         this.y = null;
         this.q();
         this.i();
      }
   }

   final boolean a(int[] var1) {
      this.H = var1;
      boolean var2;
      if (this.f()) {
         this.i();
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   int b() {
      return this.i;
   }

   void b(float var1) {
      var1 = MathUtils.a(var1, 0.0F, 1.0F);
      if (var1 != this.e) {
         this.e = var1;
         this.l();
      }
   }

   void b(int var1) {
      if (this.j != var1) {
         this.j = var1;
         this.i();
      }
   }

   void b(int var1, int var2, int var3, int var4) {
      if (!a(this.g, var1, var2, var3, var4)) {
         this.g.set(var1, var2, var3, var4);
         this.I = true;
         this.a();
      }
   }

   void b(ColorStateList var1) {
      if (this.m != var1) {
         this.m = var1;
         this.i();
      }
   }

   void b(Typeface var1) {
      if (this.a(this.v, var1)) {
         this.v = var1;
         this.i();
      }
   }

   void b(Interpolator var1) {
      this.K = var1;
      this.i();
   }

   int c() {
      return this.j;
   }

   void c(int var1) {
      TintTypedArray var2 = TintTypedArray.a(this.c.getContext(), var1, R.styleable.TextAppearance);
      if (var2.g(R.styleable.TextAppearance_android_textColor)) {
         this.n = var2.e(R.styleable.TextAppearance_android_textColor);
      }

      if (var2.g(R.styleable.TextAppearance_android_textSize)) {
         this.l = var2.e(R.styleable.TextAppearance_android_textSize, (int)this.l);
      }

      this.P = var2.a(R.styleable.TextAppearance_android_shadowColor, 0);
      this.N = var2.a(R.styleable.TextAppearance_android_shadowDx, 0.0F);
      this.O = var2.a(R.styleable.TextAppearance_android_shadowDy, 0.0F);
      this.M = var2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
      var2.a();
      if (VERSION.SDK_INT >= 16) {
         this.u = this.e(var1);
      }

      this.i();
   }

   void c(Typeface var1) {
      this.v = var1;
      this.u = var1;
      this.i();
   }

   Typeface d() {
      Typeface var1;
      if (this.u != null) {
         var1 = this.u;
      } else {
         var1 = Typeface.DEFAULT;
      }

      return var1;
   }

   void d(int var1) {
      TintTypedArray var2 = TintTypedArray.a(this.c.getContext(), var1, R.styleable.TextAppearance);
      if (var2.g(R.styleable.TextAppearance_android_textColor)) {
         this.m = var2.e(R.styleable.TextAppearance_android_textColor);
      }

      if (var2.g(R.styleable.TextAppearance_android_textSize)) {
         this.k = var2.e(R.styleable.TextAppearance_android_textSize, (int)this.k);
      }

      this.T = var2.a(R.styleable.TextAppearance_android_shadowColor, 0);
      this.R = var2.a(R.styleable.TextAppearance_android_shadowDx, 0.0F);
      this.S = var2.a(R.styleable.TextAppearance_android_shadowDy, 0.0F);
      this.Q = var2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
      var2.a();
      if (VERSION.SDK_INT >= 16) {
         this.v = this.e(var1);
      }

      this.i();
   }

   Typeface e() {
      Typeface var1;
      if (this.v != null) {
         var1 = this.v;
      } else {
         var1 = Typeface.DEFAULT;
      }

      return var1;
   }

   final boolean f() {
      boolean var1;
      if ((this.n == null || !this.n.isStateful()) && (this.m == null || !this.m.isStateful())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   float g() {
      return this.e;
   }

   float h() {
      return this.l;
   }

   public void i() {
      if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
         this.o();
         this.l();
      }
   }

   CharSequence j() {
      return this.x;
   }

   ColorStateList k() {
      return this.n;
   }
}
