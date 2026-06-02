package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;

public class TintTypedArray {
   private final Context a;
   private final TypedArray b;
   private TypedValue c;

   private TintTypedArray(Context var1, TypedArray var2) {
      this.a = var1;
      this.b = var2;
   }

   public static TintTypedArray a(Context var0, int var1, int[] var2) {
      return new TintTypedArray(var0, var0.obtainStyledAttributes(var1, var2));
   }

   public static TintTypedArray a(Context var0, AttributeSet var1, int[] var2) {
      return new TintTypedArray(var0, var0.obtainStyledAttributes(var1, var2));
   }

   public static TintTypedArray a(Context var0, AttributeSet var1, int[] var2, int var3, int var4) {
      return new TintTypedArray(var0, var0.obtainStyledAttributes(var1, var2, var3, var4));
   }

   public float a(int var1, float var2) {
      return this.b.getFloat(var1, var2);
   }

   public int a(int var1, int var2) {
      return this.b.getInt(var1, var2);
   }

   public Typeface a(int var1, int var2, ResourcesCompat.FontCallback var3) {
      var1 = this.b.getResourceId(var1, 0);
      Typeface var5;
      if (var1 == 0) {
         var5 = null;
      } else {
         if (this.c == null) {
            this.c = new TypedValue();
         }

         var5 = ResourcesCompat.a(this.a, var1, this.c, var2, var3);
      }

      return var5;
   }

   public Drawable a(int var1) {
      if (this.b.hasValue(var1)) {
         int var2 = this.b.getResourceId(var1, 0);
         if (var2 != 0) {
            return AppCompatResources.b(this.a, var2);
         }
      }

      return this.b.getDrawable(var1);
   }

   public void a() {
      this.b.recycle();
   }

   public boolean a(int var1, boolean var2) {
      return this.b.getBoolean(var1, var2);
   }

   public int b(int var1, int var2) {
      return this.b.getColor(var1, var2);
   }

   public Drawable b(int var1) {
      if (this.b.hasValue(var1)) {
         var1 = this.b.getResourceId(var1, 0);
         if (var1 != 0) {
            return AppCompatDrawableManager.a().a(this.a, var1, true);
         }
      }

      return null;
   }

   public int c(int var1, int var2) {
      return this.b.getInteger(var1, var2);
   }

   public CharSequence c(int var1) {
      return this.b.getText(var1);
   }

   public int d(int var1, int var2) {
      return this.b.getDimensionPixelOffset(var1, var2);
   }

   public String d(int var1) {
      return this.b.getString(var1);
   }

   public int e(int var1, int var2) {
      return this.b.getDimensionPixelSize(var1, var2);
   }

   public ColorStateList e(int var1) {
      if (this.b.hasValue(var1)) {
         int var2 = this.b.getResourceId(var1, 0);
         if (var2 != 0) {
            ColorStateList var3 = AppCompatResources.a(this.a, var2);
            if (var3 != null) {
               return var3;
            }
         }
      }

      return this.b.getColorStateList(var1);
   }

   public int f(int var1, int var2) {
      return this.b.getLayoutDimension(var1, var2);
   }

   public CharSequence[] f(int var1) {
      return this.b.getTextArray(var1);
   }

   public int g(int var1, int var2) {
      return this.b.getResourceId(var1, var2);
   }

   public boolean g(int var1) {
      return this.b.hasValue(var1);
   }
}
