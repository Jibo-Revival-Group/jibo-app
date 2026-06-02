package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AppCompatTextHelper {
   final TextView a;
   private TintInfo b;
   private TintInfo c;
   private TintInfo d;
   private TintInfo e;
   private final AppCompatTextViewAutoSizeHelper f;
   private int g = 0;
   private Typeface h;
   private boolean i;

   AppCompatTextHelper(TextView var1) {
      this.a = var1;
      this.f = new AppCompatTextViewAutoSizeHelper(this.a);
   }

   static AppCompatTextHelper a(TextView var0) {
      AppCompatTextHelper var1;
      if (VERSION.SDK_INT >= 17) {
         var1 = new AppCompatTextHelperV17(var0);
      } else {
         var1 = new AppCompatTextHelper(var0);
      }

      return var1;
   }

   protected static TintInfo a(Context var0, AppCompatDrawableManager var1, int var2) {
      ColorStateList var4 = var1.b(var0, var2);
      TintInfo var3;
      if (var4 != null) {
         var3 = new TintInfo();
         var3.d = true;
         var3.a = var4;
      } else {
         var3 = null;
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(Context var1, TintTypedArray var2) {
      boolean var4 = true;
      this.g = var2.a(R.styleable.TextAppearance_android_textStyle, this.g);
      if (var2.g(R.styleable.TextAppearance_android_fontFamily) || var2.g(R.styleable.TextAppearance_fontFamily)) {
         this.h = null;
         int var3;
         if (var2.g(R.styleable.TextAppearance_fontFamily)) {
            var3 = R.styleable.TextAppearance_fontFamily;
         } else {
            var3 = R.styleable.TextAppearance_android_fontFamily;
         }

         label41:
         if (!var1.isRestricted()) {
            ResourcesCompat.FontCallback var9 = new ResourcesCompat.FontCallback(this, new WeakReference<>(this.a)) {
               final WeakReference a;
               final AppCompatTextHelper b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void a(int var1) {
               }

               @Override
               public void a(Typeface var1) {
                  this.b.a(this.a, var1);
               }
            };

            label46: {
               try {
                  this.h = var2.a(var3, this.g, var9);
                  if (this.h == null) {
                     break label46;
                  }
               } catch (UnsupportedOperationException var7) {
                  break label41;
               } catch (NotFoundException var8) {
                  break label41;
               }

               var4 = false;
            }

            try {
               this.i = var4;
            } catch (UnsupportedOperationException var5) {
            } catch (NotFoundException var6) {
            }
         }

         if (this.h == null) {
            String var10 = var2.d(var3);
            if (var10 != null) {
               this.h = Typeface.create(var10, this.g);
            }
         }
      } else if (var2.g(R.styleable.TextAppearance_android_typeface)) {
         this.i = false;
         switch (var2.a(R.styleable.TextAppearance_android_typeface, 1)) {
            case 1:
               this.h = Typeface.SANS_SERIF;
               break;
            case 2:
               this.h = Typeface.SERIF;
               break;
            case 3:
               this.h = Typeface.MONOSPACE;
         }
      }
   }

   private void a(WeakReference<TextView> var1, Typeface var2) {
      if (this.i) {
         this.h = var2;
         TextView var3 = (TextView)var1.get();
         if (var3 != null) {
            var3.setTypeface(var2, this.g);
         }
      }
   }

   private void b(int var1, float var2) {
      this.f.a(var1, var2);
   }

   void a() {
      if (this.b != null || this.c != null || this.d != null || this.e != null) {
         Drawable[] var1 = this.a.getCompoundDrawables();
         this.a(var1[0], this.b);
         this.a(var1[1], this.c);
         this.a(var1[2], this.d);
         this.a(var1[3], this.e);
      }
   }

   void a(int var1) {
      this.f.a(var1);
   }

   void a(int var1, float var2) {
      if (!AutoSizeableTextView.a && !this.c()) {
         this.b(var1, var2);
      }
   }

   void a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      this.f.a(var1, var2, var3, var4);
   }

   void a(Context var1, int var2) {
      TintTypedArray var3 = TintTypedArray.a(var1, var2, R.styleable.TextAppearance);
      if (var3.g(R.styleable.TextAppearance_textAllCaps)) {
         this.a(var3.a(R.styleable.TextAppearance_textAllCaps, false));
      }

      if (VERSION.SDK_INT < 23 && var3.g(R.styleable.TextAppearance_android_textColor)) {
         ColorStateList var4 = var3.e(R.styleable.TextAppearance_android_textColor);
         if (var4 != null) {
            this.a.setTextColor(var4);
         }
      }

      this.a(var1, var3);
      var3.a();
      if (this.h != null) {
         this.a.setTypeface(this.h, this.g);
      }
   }

   final void a(Drawable var1, TintInfo var2) {
      if (var1 != null && var2 != null) {
         AppCompatDrawableManager.a(var1, var2, this.a.getDrawableState());
      }
   }

   @SuppressLint("NewApi")
   void a(AttributeSet var1, int var2) {
      ColorStateList var10 = null;
      ColorStateList var11 = null;
      Context var14 = this.a.getContext();
      AppCompatDrawableManager var8 = AppCompatDrawableManager.a();
      TintTypedArray var9 = TintTypedArray.a(var14, var1, R.styleable.AppCompatTextHelper, var2, 0);
      int var3 = var9.g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
      if (var9.g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
         this.b = a(var14, var8, var9.g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
      }

      if (var9.g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
         this.c = a(var14, var8, var9.g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
      }

      if (var9.g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
         this.d = a(var14, var8, var9.g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
      }

      if (var9.g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
         this.e = a(var14, var8, var9.g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
      }

      var9.a();
      boolean var7 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
      boolean var5;
      boolean var17;
      ColorStateList var19;
      ColorStateList var20;
      if (var3 != -1) {
         TintTypedArray var13 = TintTypedArray.a(var14, var3, R.styleable.TextAppearance);
         if (!var7 && var13.g(R.styleable.TextAppearance_textAllCaps)) {
            var5 = var13.a(R.styleable.TextAppearance_textAllCaps, false);
            var17 = true;
         } else {
            var17 = false;
            var5 = false;
         }

         this.a(var14, var13);
         ColorStateList var12;
         if (VERSION.SDK_INT < 23) {
            ColorStateList var18;
            if (var13.g(R.styleable.TextAppearance_android_textColor)) {
               var18 = var13.e(R.styleable.TextAppearance_android_textColor);
            } else {
               var18 = null;
            }

            if (var13.g(R.styleable.TextAppearance_android_textColorHint)) {
               var10 = var13.e(R.styleable.TextAppearance_android_textColorHint);
            } else {
               var10 = null;
            }

            var20 = var18;
            var12 = var10;
            if (var13.g(R.styleable.TextAppearance_android_textColorLink)) {
               var11 = var13.e(R.styleable.TextAppearance_android_textColorLink);
               var12 = var10;
               var20 = var18;
            }
         } else {
            var12 = null;
            var20 = null;
         }

         var13.a();
         var19 = var12;
         var10 = var11;
      } else {
         var19 = null;
         var20 = null;
         var17 = false;
         var5 = false;
      }

      TintTypedArray var15 = TintTypedArray.a(var14, var1, R.styleable.TextAppearance, var2, 0);
      boolean var4 = var17;
      boolean var6 = var5;
      if (!var7) {
         var4 = var17;
         var6 = var5;
         if (var15.g(R.styleable.TextAppearance_textAllCaps)) {
            var6 = var15.a(R.styleable.TextAppearance_textAllCaps, false);
            var4 = true;
         }
      }

      ColorStateList var24 = var20;
      ColorStateList var23 = var10;
      var11 = var19;
      if (VERSION.SDK_INT < 23) {
         if (var15.g(R.styleable.TextAppearance_android_textColor)) {
            var20 = var15.e(R.styleable.TextAppearance_android_textColor);
         }

         if (var15.g(R.styleable.TextAppearance_android_textColorHint)) {
            var19 = var15.e(R.styleable.TextAppearance_android_textColorHint);
         }

         var24 = var20;
         var23 = var10;
         var11 = var19;
         if (var15.g(R.styleable.TextAppearance_android_textColorLink)) {
            var23 = var15.e(R.styleable.TextAppearance_android_textColorLink);
            var11 = var19;
            var24 = var20;
         }
      }

      this.a(var14, var15);
      var15.a();
      if (var24 != null) {
         this.a.setTextColor(var24);
      }

      if (var11 != null) {
         this.a.setHintTextColor(var11);
      }

      if (var23 != null) {
         this.a.setLinkTextColor(var23);
      }

      if (!var7 && var4) {
         this.a(var6);
      }

      if (this.h != null) {
         this.a.setTypeface(this.h, this.g);
      }

      this.f.a(var1, var2);
      if (AutoSizeableTextView.a && this.f.a() != 0) {
         int[] var16 = this.f.e();
         if (var16.length > 0) {
            if (this.a.getAutoSizeStepGranularity() != -1.0F) {
               this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
            } else {
               this.a.setAutoSizeTextTypeUniformWithPresetSizes(var16, 0);
            }
         }
      }
   }

   void a(boolean var1) {
      this.a.setAllCaps(var1);
   }

   void a(boolean var1, int var2, int var3, int var4, int var5) {
      if (!AutoSizeableTextView.a) {
         this.b();
      }
   }

   void a(int[] var1, int var2) throws IllegalArgumentException {
      this.f.a(var1, var2);
   }

   void b() {
      this.f.f();
   }

   boolean c() {
      return this.f.g();
   }

   int d() {
      return this.f.a();
   }

   int e() {
      return this.f.b();
   }

   int f() {
      return this.f.c();
   }

   int g() {
      return this.f.d();
   }

   int[] h() {
      return this.f.e();
   }
}
