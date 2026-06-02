package com.jibo.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class BitmapProgress extends View {
   private int a;
   private int b;
   private Bitmap c;
   private Path d;
   private Paint e;
   private int f = 17170443;
   private int g = 100;
   private int h = 0;
   private float i;
   private int j = 50;
   private Handler k = new Handler(this) {
      final BitmapProgress a;

      {
         this.a = var1;
      }

      public void handleMessage(Message var1) {
         super.handleMessage(var1);
         switch (var1.what) {
            case 1911:
               this.a.invalidate();
               this.sendEmptyMessageDelayed(1911, this.a.j);
         }
      }
   };

   public BitmapProgress(Context var1) {
      this(var1, null, 0);
   }

   public BitmapProgress(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public BitmapProgress(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.b();
   }

   private Bitmap a(Drawable var1) {
      Object var2 = null;
      Bitmap var6;
      if (var1 == null) {
         var6 = (Bitmap)var2;
      } else if (var1 instanceof BitmapDrawable) {
         var6 = ((BitmapDrawable)var1).getBitmap();
      } else {
         Bitmap var3;
         try {
            var3 = Bitmap.createBitmap(var1.getIntrinsicWidth(), var1.getIntrinsicHeight(), Config.ARGB_8888);
            Canvas var4 = new Canvas(var3);
            var1.setBounds(0, 0, var4.getWidth(), var4.getHeight());
            var1.draw(var4);
         } catch (OutOfMemoryError var5) {
            Object var7 = var2;
            return (Bitmap)var7;
         }

         var6 = var3;
      }

      return var6;
   }

   private void b() {
      if (this.getBackground() == null) {
         throw new IllegalArgumentException(String.format("background is null."));
      }

      this.a();
      this.d = new Path();
      this.e = new Paint();
      this.e.setAntiAlias(true);
      this.e.setStyle(Style.FILL);
      this.k.sendEmptyMessageDelayed(1911, 100L);
   }

   private Bitmap c() {
      this.e.setColor(this.getResources().getColor(this.f));
      Paint var3 = new Paint();
      var3.setAntiAlias(true);
      Bitmap var2 = Bitmap.createBitmap(this.a, this.b, Config.ARGB_8888);
      Canvas var4 = new Canvas(var2);
      float var1 = this.a * ((float)this.h / this.g);
      this.d.reset();
      this.d.moveTo(0.0F, 0.0F);
      this.d.lineTo(0.0F, this.b);
      this.d.lineTo(var1, this.b);
      this.d.lineTo(var1, 0.0F);
      this.d.close();
      var4.drawPath(this.d, this.e);
      this.c = Bitmap.createScaledBitmap(this.c, this.a, this.b, false);
      var3.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
      var4.drawBitmap(this.c, 0.0F, 0.0F, var3);
      return var2;
   }

   public void a() {
      this.c = this.a(this.getBackground());
   }

   public int getCurrentProgress() {
      return this.h;
   }

   protected void onDraw(Canvas var1) {
      if (this.c != null) {
         var1.drawBitmap(this.c(), 0.0F, 0.0F, null);
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      var1 = MeasureSpec.getSize(var1);
      this.a = var1;
      this.i = var1;
      this.b = MeasureSpec.getSize(var2);
   }

   public void setMaxProgress(int var1) {
      this.g = var1;
   }

   public void setProgress(int var1) {
      this.h = var1;
   }

   public void setWaveColor(int var1) {
      this.f = var1;
   }
}
