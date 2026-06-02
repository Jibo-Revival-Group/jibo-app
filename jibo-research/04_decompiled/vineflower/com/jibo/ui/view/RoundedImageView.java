package com.jibo.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.jibo.utils.ImageUtils;

public class RoundedImageView extends ImageView {
   public RoundedImageView(Context var1) {
      super(var1);
   }

   public RoundedImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public RoundedImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private Drawable a(Drawable var1) {
      if (var1 != null) {
         int var2 = var1.getIntrinsicHeight();
         int var3 = var1.getIntrinsicWidth();
         Bitmap var5 = Bitmap.createBitmap(var3, var2, Config.ARGB_8888);
         Canvas var4 = new Canvas(var5);
         var1.setBounds(0, 0, var3, var2);
         var1.draw(var4);
         Bitmap var6 = ImageUtils.a(var5);
         var1 = RoundedBitmapDrawableFactory.a(this.getResources(), var6);
         var1.a(true);
      }

      return var1;
   }

   public void setImageBitmap(Bitmap var1) {
      super.setImageBitmap(var1);
   }

   public void setImageDrawable(Drawable var1) {
      if (var1 instanceof BitmapDrawable) {
         var1 = RoundedBitmapDrawableFactory.a(this.getResources(), ((BitmapDrawable)var1).getBitmap());
         var1.a(true);
         super.setImageDrawable(var1);
      } else if (var1 instanceof GlideBitmapDrawable) {
         var1 = RoundedBitmapDrawableFactory.a(this.getResources(), ((GlideBitmapDrawable)var1).getBitmap());
         var1.a(true);
         super.setImageDrawable(var1);
      } else if (VERSION.SDK_INT >= 21) {
         if (var1 instanceof VectorDrawable) {
            int var3 = var1.getIntrinsicHeight();
            int var2 = var1.getIntrinsicWidth();
            Bitmap var5 = Bitmap.createBitmap(var2, var3, Config.ARGB_8888);
            Canvas var4 = new Canvas(var5);
            var1.setBounds(0, 0, var2, var3);
            var1.setTintList(this.getImageTintList());
            var1.draw(var4);
            var1 = RoundedBitmapDrawableFactory.a(this.getResources(), var5);
            var1.a(true);
            super.setImageDrawable(var1);
         } else {
            super.setImageDrawable(this.a(var1));
         }
      } else {
         super.setImageDrawable(this.a(var1));
      }
   }

   public void setImageResource(int var1) {
      if (VERSION.SDK_INT >= 21) {
         this.setImageDrawable(this.getResources().getDrawable(var1, this.getContext().getTheme()));
      } else {
         this.setImageDrawable(this.getResources().getDrawable(var1));
      }
   }
}
