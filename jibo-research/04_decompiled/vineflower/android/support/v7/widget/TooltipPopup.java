package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.appcompat.R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.MeasureSpec;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class TooltipPopup {
   private final Context a;
   private final View b;
   private final TextView c;
   private final LayoutParams d = new LayoutParams();
   private final Rect e = new Rect();
   private final int[] f = new int[2];
   private final int[] g = new int[2];

   TooltipPopup(Context var1) {
      this.a = var1;
      this.b = LayoutInflater.from(this.a).inflate(R.layout.abc_tooltip, null);
      this.c = (TextView)this.b.findViewById(R.id.message);
      this.d.setTitle(this.getClass().getSimpleName());
      this.d.packageName = this.a.getPackageName();
      this.d.type = 1002;
      this.d.width = -2;
      this.d.height = -2;
      this.d.format = -3;
      this.d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
      this.d.flags = 24;
   }

   private static View a(View var0) {
      View var1 = var0.getRootView();
      android.view.ViewGroup.LayoutParams var2 = var1.getLayoutParams();
      if (var2 instanceof LayoutParams && ((LayoutParams)var2).type == 2) {
         var0 = var1;
      } else {
         Context var3 = var0.getContext();

         while (true) {
            if (!(var3 instanceof ContextWrapper)) {
               var0 = var1;
               break;
            }

            if (var3 instanceof Activity) {
               var0 = ((Activity)var3).getWindow().getDecorView();
               break;
            }

            var3 = ((ContextWrapper)var3).getBaseContext();
         }
      }

      return var0;
   }

   private void a(View var1, int var2, int var3, boolean var4, LayoutParams var5) {
      var5.token = var1.getApplicationWindowToken();
      int var6 = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
      if (var1.getWidth() < var6) {
         var2 = var1.getWidth() / 2;
      }

      if (var1.getHeight() >= var6) {
         int var7 = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
         var6 = var3 + var7;
         var7 = var3 - var7;
         var3 = var6;
         var6 = var7;
      } else {
         var3 = var1.getHeight();
         var6 = 0;
      }

      var5.gravity = 49;
      Resources var9 = this.a.getResources();
      int var21;
      if (var4) {
         var21 = R.dimen.tooltip_y_offset_touch;
      } else {
         var21 = R.dimen.tooltip_y_offset_non_touch;
      }

      int var8 = var9.getDimensionPixelOffset(var21);
      View var24 = a(var1);
      if (var24 == null) {
         Log.e("TooltipPopup", "Cannot find app view");
      } else {
         var24.getWindowVisibleDisplayFrame(this.e);
         if (this.e.left < 0 && this.e.top < 0) {
            Resources var10 = this.a.getResources();
            var21 = var10.getIdentifier("status_bar_height", "dimen", "android");
            if (var21 != 0) {
               var21 = var10.getDimensionPixelSize(var21);
            } else {
               var21 = 0;
            }

            DisplayMetrics var25 = var10.getDisplayMetrics();
            this.e.set(0, var21, var25.widthPixels, var25.heightPixels);
         }

         var24.getLocationOnScreen(this.g);
         var1.getLocationOnScreen(this.f);
         int[] var11 = this.f;
         var11[0] -= this.g[0];
         int[] var12 = this.f;
         var12[1] -= this.g[1];
         var5.x = this.f[0] + var2 - var24.getWidth() / 2;
         var2 = MeasureSpec.makeMeasureSpec(0, 0);
         this.b.measure(var2, var2);
         var2 = this.b.getMeasuredHeight();
         var6 = var6 + this.f[1] - var8 - var2;
         var3 = var3 + this.f[1] + var8;
         if (var4) {
            if (var6 >= 0) {
               var5.y = var6;
            } else {
               var5.y = var3;
            }
         } else if (var2 + var3 <= this.e.height()) {
            var5.y = var3;
         } else {
            var5.y = var6;
         }
      }
   }

   void a() {
      if (this.b()) {
         ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
      }
   }

   void a(View var1, int var2, int var3, boolean var4, CharSequence var5) {
      if (this.b()) {
         this.a();
      }

      this.c.setText(var5);
      this.a(var1, var2, var3, var4, this.d);
      ((WindowManager)this.a.getSystemService("window")).addView(this.b, this.d);
   }

   boolean b() {
      boolean var1;
      if (this.b.getParent() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
