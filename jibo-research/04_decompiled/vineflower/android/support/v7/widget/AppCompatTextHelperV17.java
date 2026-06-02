package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelperV17 extends AppCompatTextHelper {
   private TintInfo b;
   private TintInfo c;

   AppCompatTextHelperV17(TextView var1) {
      super(var1);
   }

   @Override
   void a() {
      super.a();
      if (this.b != null || this.c != null) {
         Drawable[] var1 = this.a.getCompoundDrawablesRelative();
         this.a(var1[0], this.b);
         this.a(var1[2], this.c);
      }
   }

   @Override
   void a(AttributeSet var1, int var2) {
      super.a(var1, var2);
      Context var3 = this.a.getContext();
      AppCompatDrawableManager var4 = AppCompatDrawableManager.a();
      TypedArray var5 = var3.obtainStyledAttributes(var1, R.styleable.AppCompatTextHelper, var2, 0);
      if (var5.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
         this.b = a(var3, var4, var5.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
      }

      if (var5.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
         this.c = a(var3, var4, var5.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
      }

      var5.recycle();
   }
}
