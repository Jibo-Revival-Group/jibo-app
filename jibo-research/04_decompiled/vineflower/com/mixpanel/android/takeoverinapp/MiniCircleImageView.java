package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class MiniCircleImageView extends ImageView {
   private Paint a;
   private int b;
   private int c;

   public MiniCircleImageView(Context var1) {
      super(var1);
      this.a();
   }

   public MiniCircleImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public MiniCircleImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.a = new Paint(1);
      if (VERSION.SDK_INT >= 23) {
         this.a.setColor(this.getResources().getColor(17170443, null));
      } else {
         this.a.setColor(this.getResources().getColor(17170443));
      }

      this.a.setStyle(Style.STROKE);
      float var1 = TypedValue.applyDimension(1, 2.0F, this.getResources().getDisplayMetrics());
      this.a.setStrokeWidth(var1);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.b = var1;
      this.c = var2;
   }
}
