package com.jibo.ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class FontFitTextView extends CustomFontTextView {
   private float a;
   private Paint b;

   public FontFitTextView(Context var1) {
      super(var1);
      this.a();
   }

   public FontFitTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public FontFitTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.b = new Paint();
      this.b.set(this.getPaint());
      this.a = this.getTextSize();
   }

   private void a(String var1, int var2) {
      if (var2 > 0) {
         int var6 = this.getPaddingLeft();
         int var7 = this.getPaddingRight();
         float var3 = this.a;
         this.b.set(this.getPaint());
         float var4 = 2.0F;

         while (var3 - var4 > 0.5F) {
            float var5 = (var3 + var4) / 2.0F;
            this.b.setTextSize(var5);
            if (this.b.measureText(var1) >= var2 - var6 - var7) {
               var3 = var5;
            } else {
               var4 = var5;
            }
         }

         this.setTextSize(0, var4);
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      var1 = MeasureSpec.getSize(var1);
      var2 = this.getMeasuredHeight();
      this.a(this.getText().toString(), var1);
      this.setMeasuredDimension(var1, var2);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      if (var1 != var3) {
         this.a(this.getText().toString(), var1);
      }
   }

   protected void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      this.a(var1.toString(), this.getWidth());
   }
}
