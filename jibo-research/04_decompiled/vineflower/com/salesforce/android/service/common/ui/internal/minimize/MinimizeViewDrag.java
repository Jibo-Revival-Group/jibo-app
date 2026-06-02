package com.salesforce.android.service.common.ui.internal.minimize;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;

class MinimizeViewDrag implements OnDragListener, OnTouchListener {
   private static final ServiceLogger a = ServiceLogging.a(MinimizeViewDrag.class);
   private final MinimizeViewDrag.Listener b;
   private final View c;
   private final View d;
   private final int e;
   private Coordinate f;
   private boolean g;
   private boolean h;
   private float i;
   private float j;
   private Integer k;

   MinimizeViewDrag(MinimizeViewDrag.Builder var1) {
      this.b = var1.c;
      this.c = var1.b;
      this.d = var1.a;
      this.e = var1.d;
      this.c.setOnTouchListener(this);
      this.d.setOnDragListener(this);
   }

   private Integer a(View var1) {
      if (this.k == null) {
         this.k = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      }

      return this.k;
   }

   @TargetApi(24)
   private void a(View var1, ClipData var2, DragShadowBuilder var3, Object var4, int var5) {
      if (this.e >= 24) {
         var1.startDragAndDrop(var2, var3, var4, var5);
      } else {
         var1.startDrag(var2, var3, var4, var5);
      }
   }

   void a() {
      this.c.setOnTouchListener(null);
      this.d.setOnDragListener(null);
   }

   public boolean onDrag(View var1, DragEvent var2) {
      boolean var5 = false;
      if (this.h) {
         switch (var2.getAction()) {
            case 1:
               this.c.setVisibility(4);
            case 2:
            default:
               break;
            case 3:
               if (this.f == null) {
                  this.f = Coordinate.a(0, 0);
               }

               float var3 = var2.getX() - this.f.a();
               float var4 = var2.getY() - this.f.b();
               a.a("Minimized view dropped at {} {}", var3, var4);
               this.c.setX(var3);
               this.c.setY(var4);
               if (this.b != null) {
                  this.b.a(Coordinate.a((int)var3, (int)var4));
               }
               break;
            case 4:
               this.c.setAlpha(0.5F);
               this.c.setVisibility(0);
               this.c.animate().alpha(1.0F).setDuration(100L).start();
               this.h = false;
         }

         var5 = true;
      }

      return var5;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      if (var2.getAction() == 0) {
         this.i = var2.getX();
         this.j = var2.getY();
         this.g = true;
      } else if (var2.getAction() == 2 && this.g) {
         float var4 = var2.getX() - this.i;
         float var3 = var2.getY() - this.j;
         if (Math.sqrt(var4 * var4 + var3 * var3) > this.a(var1).intValue()) {
            this.f = Coordinate.a(Math.max((int)var2.getX(), 0), Math.max((int)var2.getY(), 0));
            this.h = true;
            this.a(var1, null, new MinimizeViewDrag.ShadowBuilder(var1, this.f), null, 0);
            this.g = false;
         }
      }

      return false;
   }

   static class Builder {
      View a;
      View b;
      MinimizeViewDrag.Listener c;
      int d = VERSION.SDK_INT;

      MinimizeViewDrag.Builder a(View var1) {
         this.a = var1;
         return this;
      }

      MinimizeViewDrag.Builder a(MinimizeViewDrag.Listener var1) {
         this.c = var1;
         return this;
      }

      MinimizeViewDrag a() {
         Arguments.a(this.a, "Builder must be provided with a container view");
         Arguments.a(this.b, "Builder must be provided with the minimized view");
         return new MinimizeViewDrag(this);
      }

      MinimizeViewDrag.Builder b(View var1) {
         this.b = var1;
         return this;
      }
   }

   interface Listener {
      void a(Coordinate var1);
   }

   static class ShadowBuilder extends DragShadowBuilder {
      Coordinate a;

      ShadowBuilder(View var1, Coordinate var2) {
         super(var1);
         this.a = var2;
      }

      public void onDrawShadow(Canvas var1) {
         this.getView().draw(var1);
      }

      public void onProvideShadowMetrics(Point var1, Point var2) {
         var1.set(this.getView().getWidth(), this.getView().getHeight());
         var2.set(this.a.a(), this.a.b());
      }
   }
}
