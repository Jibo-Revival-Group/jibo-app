package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class FadingImageView extends ImageView {
   private Matrix a;
   private Paint b;
   private Shader c;
   private Paint d;
   private Shader e;
   private int f;
   private int g;
   private boolean h;

   public FadingImageView(Context var1) {
      super(var1);
      this.a();
   }

   public FadingImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public FadingImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.a = new Matrix();
      this.b = new Paint();
      TileMode var1 = TileMode.CLAMP;
      this.c = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0F, 0.2F, 0.4F, 1.0F}, var1);
      this.b.setShader(this.c);
      this.b.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
      this.d = new Paint();
      var1 = TileMode.CLAMP;
      this.e = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0F, 0.85F, 0.98F, 1.0F}, var1);
      this.d.setShader(this.e);
      this.b.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public void draw(Canvas var1) {
      if (this.h) {
         Rect var3 = var1.getClipBounds();
         int var2 = var1.saveLayer(0.0F, 0.0F, var3.width(), var3.height(), null, 31);
         super.draw(var1);
         var1.drawRect(0.0F, 0.0F, this.g, this.f, this.b);
         var1.restoreToCount(var2);
      } else {
         super.draw(var1);
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (this.h) {
         this.f = this.getHeight();
         this.g = this.getWidth();
         var1 = MeasureSpec.getSize(var2);
         this.a.setScale(1.0F, var1);
         this.c.setLocalMatrix(this.a);
         this.e.setLocalMatrix(this.a);
      }
   }
}
