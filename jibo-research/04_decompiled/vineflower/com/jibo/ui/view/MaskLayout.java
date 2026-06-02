package com.jibo.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.jibo.R;

public class MaskLayout extends FrameLayout {
   private Handler a;
   private Drawable b = null;
   private Bitmap c = null;
   private boolean d = false;
   private Paint e = null;
   private PorterDuffXfermode f = null;

   public MaskLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public MaskLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   private Paint a(boolean var1) {
      Paint var2 = new Paint(1);
      var2.setAntiAlias(var1);
      var2.setXfermode(this.f);
      return var2;
   }

   private PorterDuffXfermode a(int var1) {
      Mode var2;
      switch (var1) {
         case 0:
            if (VERSION.SDK_INT >= 11) {
               var2 = Mode.ADD;
            } else {
               this.a("MODE_ADD is not supported on api lvl " + VERSION.SDK_INT);
            }
         case 1:
            var2 = Mode.CLEAR;
            break;
         case 2:
            var2 = Mode.DARKEN;
            break;
         case 3:
            var2 = Mode.DST;
            break;
         case 4:
            var2 = Mode.DST_ATOP;
            break;
         case 5:
            var2 = Mode.DST_IN;
            break;
         case 6:
            var2 = Mode.DST_OUT;
            break;
         case 7:
            var2 = Mode.DST_OVER;
            break;
         case 8:
            var2 = Mode.LIGHTEN;
            break;
         case 9:
            var2 = Mode.MULTIPLY;
            break;
         case 10:
            if (VERSION.SDK_INT >= 11) {
               var2 = Mode.OVERLAY;
            } else {
               this.a("MODE_OVERLAY is not supported on api lvl " + VERSION.SDK_INT);
            }
         case 11:
            var2 = Mode.SCREEN;
            break;
         case 12:
            var2 = Mode.SRC;
            break;
         case 13:
            var2 = Mode.SRC_ATOP;
            break;
         case 14:
            var2 = Mode.SRC_IN;
            break;
         case 15:
            var2 = Mode.SRC_OUT;
            break;
         case 16:
            var2 = Mode.SRC_OVER;
            break;
         case 17:
            var2 = Mode.XOR;
            break;
         default:
            var2 = Mode.DST_IN;
      }

      this.a("Mode is " + var2.toString());
      return new PorterDuffXfermode(var2);
   }

   private Drawable a(TypedArray var1) {
      return var1.getDrawable(1);
   }

   private void a() {
      ViewTreeObserver var1 = this.getViewTreeObserver();
      if (var1 != null && var1.isAlive()) {
         var1.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this, var1) {
            final ViewTreeObserver a;
            final MaskLayout b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void onGlobalLayout() {
               ViewTreeObserver var2 = this.a;
               ViewTreeObserver var1x = var2;
               if (!var2.isAlive()) {
                  var1x = this.b.getViewTreeObserver();
               }

               if (var1x != null) {
                  if (VERSION.SDK_INT >= 16) {
                     var1x.removeOnGlobalLayoutListener(this);
                  } else {
                     var1x.removeGlobalOnLayoutListener(this);
                  }
               } else {
                  this.b.a("GlobalLayoutListener not removed as ViewTreeObserver is not valid");
               }

               this.b.a(this.b.b(this.b.b));
            }
         });
      }
   }

   private void a(int var1, int var2) {
      if (var1 <= 0 || var2 <= 0) {
         this.a("Width and height must be higher than 0");
      } else if (this.b != null) {
         this.a(this.b(this.b));
      }
   }

   private void a(Context var1, AttributeSet var2) {
      this.a = new Handler();
      this.setDrawingCacheEnabled(true);
      if (VERSION.SDK_INT >= 11) {
         this.setLayerType(1, null);
      }

      this.e = this.a(false);
      Theme var5 = var1.getTheme();
      if (var5 != null) {
         TypedArray var6 = var5.obtainStyledAttributes(var2, R.styleable.MaskLayout, 0, 0);

         try {
            this.a(this.a(var6));
            this.f = this.a(var6.getInteger(2, 0));
            this.a(this.b);
            if (var6.getBoolean(0, false)) {
               this.e = this.a(true);
            }
         } finally {
            if (var6 != null) {
               var6.recycle();
            }
         }
      } else {
         this.a("Couldn't load theme, mask in xml won't be loaded.");
      }

      this.a();
   }

   private void a(Bitmap var1) {
      if (var1 != null) {
         if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
         }

         this.c = var1;
      }
   }

   private void a(Drawable var1) {
      if (var1 != null) {
         this.b = var1;
         if (this.b instanceof AnimationDrawable) {
            this.b.setCallback(this);
         }
      } else {
         this.a("Are you sure you don't want to provide a mask ?");
      }
   }

   private void a(String var1) {
      Log.d("MaskLayout", var1);
   }

   private Bitmap b(Drawable var1) {
      Bitmap var2 = null;
      Bitmap var4;
      if (var1 != null) {
         if (this.getMeasuredWidth() > 0 && this.getMeasuredHeight() > 0) {
            var2 = Bitmap.createBitmap(this.getMeasuredWidth(), this.getMeasuredHeight(), Config.ARGB_8888);
            Canvas var3 = new Canvas(var2);
            var1.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            var1.draw(var3);
            var4 = var2;
         } else {
            this.a("Can't create a mask with height 0 or width 0. Or the layout has no children and is wrap content");
            var4 = var2;
         }
      } else {
         this.a("No bitmap mask loaded, view will NOT be masked !");
         var4 = var2;
      }

      return var4;
   }

   protected void dispatchDraw(Canvas var1) {
      super.dispatchDraw(var1);
      if (this.c != null && this.e != null) {
         this.e.setXfermode(this.f);
         var1.drawBitmap(this.c, 0.0F, 0.0F, this.e);
         this.e.setXfermode(null);
      } else {
         this.a("Mask or paint is null ...");
      }
   }

   public Drawable getDrawableMask() {
      return this.b;
   }

   public void invalidateDrawable(Drawable var1) {
      if (var1 != null) {
         this.a(var1);
         this.a(this.b(var1));
         this.invalidate();
      }
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.a(var1, var2);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      if (var1 != null && var2 != null) {
         this.a.postAtTime(var2, var3);
      }
   }

   public void setMask(int var1) {
      Resources var2 = this.getResources();
      if (var2 != null) {
         this.setMask(var2.getDrawable(var1));
      } else {
         this.a("Unable to load resources, mask will not be loaded as drawable");
      }
   }

   public void setMask(Drawable var1) {
      this.a(var1);
      this.a(this.b(this.b));
      this.invalidate();
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      if (var1 != null && var2 != null) {
         this.a.removeCallbacks(var2);
      }
   }
}
