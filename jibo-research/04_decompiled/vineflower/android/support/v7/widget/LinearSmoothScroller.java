package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
   protected final LinearInterpolator a = new LinearInterpolator();
   protected final DecelerateInterpolator b = new DecelerateInterpolator();
   protected PointF c;
   protected int d = 0;
   protected int e = 0;
   private final float f;

   public LinearSmoothScroller(Context var1) {
      this.f = this.a(var1.getResources().getDisplayMetrics());
   }

   private int a(int var1, int var2) {
      int var3 = var1 - var2;
      var2 = var3;
      if (var1 * var3 <= 0) {
         var2 = 0;
      }

      return var2;
   }

   protected float a(DisplayMetrics var1) {
      return 25.0F / var1.densityDpi;
   }

   protected int a(int var1) {
      return (int)Math.ceil(this.b(var1) / 0.3356);
   }

   public int a(int var1, int var2, int var3, int var4, int var5) {
      switch (var5) {
         case -1:
            var1 = var3 - var1;
            break;
         case 0:
            var3 -= var1;
            var1 = var3;
            if (var3 <= 0) {
               var2 = var4 - var2;
               var1 = var2;
               if (var2 >= 0) {
                  var1 = 0;
               }
            }
            break;
         case 1:
            var1 = var4 - var2;
            break;
         default:
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      }

      return var1;
   }

   public int a(View var1, int var2) {
      RecyclerView.LayoutManager var4 = this.e();
      if (var4 != null && var4.f()) {
         RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         var2 = this.a(var4.i(var1) - var3.topMargin, var4.k(var1) + var3.bottomMargin, var4.B(), var4.z() - var4.D(), var2);
      } else {
         var2 = 0;
      }

      return var2;
   }

   @Override
   protected void a() {
   }

   @Override
   protected void a(int var1, int var2, RecyclerView.State var3, RecyclerView.SmoothScroller.Action var4) {
      if (this.j() == 0) {
         this.f();
      } else {
         this.d = this.a(this.d, var1);
         this.e = this.a(this.e, var2);
         if (this.d == 0 && this.e == 0) {
            this.a(var4);
         }
      }
   }

   protected void a(RecyclerView.SmoothScroller.Action var1) {
      PointF var3 = this.c(this.i());
      if (var3 != null && (var3.x != 0.0F || var3.y != 0.0F)) {
         this.a(var3);
         this.c = var3;
         this.d = (int)(var3.x * 10000.0F);
         this.e = (int)(var3.y * 10000.0F);
         int var2 = this.b(10000);
         var1.a((int)(this.d * 1.2F), (int)(this.e * 1.2F), (int)(var2 * 1.2F), this.a);
      } else {
         var1.a(this.i());
         this.f();
      }
   }

   @Override
   protected void a(View var1, RecyclerView.State var2, RecyclerView.SmoothScroller.Action var3) {
      int var6 = this.b(var1, this.c());
      int var5 = this.a(var1, this.d());
      int var4 = this.a((int)Math.sqrt(var6 * var6 + var5 * var5));
      if (var4 > 0) {
         var3.a(-var6, -var5, var4, this.b);
      }
   }

   protected int b(int var1) {
      return (int)Math.ceil(Math.abs(var1) * this.f);
   }

   public int b(View var1, int var2) {
      RecyclerView.LayoutManager var4 = this.e();
      if (var4 != null && var4.e()) {
         RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         var2 = this.a(var4.h(var1) - var3.leftMargin, var4.j(var1) + var3.rightMargin, var4.A(), var4.y() - var4.C(), var2);
      } else {
         var2 = 0;
      }

      return var2;
   }

   @Override
   protected void b() {
      this.e = 0;
      this.d = 0;
      this.c = null;
   }

   protected int c() {
      byte var1;
      if (this.c == null || this.c.x == 0.0F) {
         var1 = 0;
      } else if (this.c.x > 0.0F) {
         var1 = 1;
      } else {
         var1 = -1;
      }

      return var1;
   }

   public PointF c(int var1) {
      RecyclerView.LayoutManager var2 = this.e();
      PointF var3;
      if (var2 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
         var3 = ((RecyclerView.SmoothScroller.ScrollVectorProvider)var2).d(var1);
      } else {
         Log.w(
            "LinearSmoothScroller",
            "You should override computeScrollVectorForPosition when the LayoutManager does not implement "
               + RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName()
         );
         var3 = null;
      }

      return var3;
   }

   protected int d() {
      byte var1;
      if (this.c == null || this.c.y == 0.0F) {
         var1 = 0;
      } else if (this.c.y > 0.0F) {
         var1 = 1;
      } else {
         var1 = -1;
      }

      return var1;
   }
}
