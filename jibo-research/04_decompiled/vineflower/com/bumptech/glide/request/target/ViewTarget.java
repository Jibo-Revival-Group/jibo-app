package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.bumptech.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
   private static boolean b = false;
   private static Integer c = null;
   protected final T a;
   private final ViewTarget.SizeDeterminer d;

   public ViewTarget(T var1) {
      if (var1 == null) {
         throw new NullPointerException("View must not be null!");
      }

      this.a = (T)var1;
      this.d = new ViewTarget.SizeDeterminer(var1);
   }

   private void a(Object var1) {
      if (c == null) {
         b = true;
         this.a.setTag(var1);
      } else {
         this.a.setTag(c, var1);
      }
   }

   private Object c() {
      Object var1;
      if (c == null) {
         var1 = this.a.getTag();
      } else {
         var1 = this.a.getTag(c);
      }

      return var1;
   }

   public T a() {
      return this.a;
   }

   @Override
   public Request getRequest() {
      Request var1 = (Request)this.c();
      if (var1 != null) {
         if (!(var1 instanceof Request)) {
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
         }

         var1 = var1;
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public void getSize(SizeReadyCallback var1) {
      this.d.a(var1);
   }

   @Override
   public void setRequest(Request var1) {
      this.a(var1);
   }

   @Override
   public String toString() {
      return "Target for: " + this.a;
   }

   private static class SizeDeterminer {
      private final View a;
      private final List<SizeReadyCallback> b = new ArrayList<>();
      private ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener c;
      private Point d;

      public SizeDeterminer(View var1) {
         this.a = var1;
      }

      private int a(int var1, boolean var2) {
         if (var1 == -2) {
            Point var3 = this.d();
            if (var2) {
               var1 = var3.y;
            } else {
               var1 = var3.x;
            }
         }

         return var1;
      }

      private void a() {
         if (!this.b.isEmpty()) {
            int var1 = this.c();
            int var2 = this.b();
            if (this.a(var1) && this.a(var2)) {
               this.a(var1, var2);
               ViewTreeObserver var3 = this.a.getViewTreeObserver();
               if (var3.isAlive()) {
                  var3.removeOnPreDrawListener(this.c);
               }

               this.c = null;
            }
         }
      }

      private void a(int var1, int var2) {
         Iterator var3 = this.b.iterator();

         while (var3.hasNext()) {
            ((SizeReadyCallback)var3.next()).a(var1, var2);
         }

         this.b.clear();
      }

      private boolean a(int var1) {
         boolean var2;
         if (var1 <= 0 && var1 != -2) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      private int b() {
         LayoutParams var2 = this.a.getLayoutParams();
         int var1;
         if (this.a(this.a.getHeight())) {
            var1 = this.a.getHeight();
         } else if (var2 != null) {
            var1 = this.a(var2.height, true);
         } else {
            var1 = 0;
         }

         return var1;
      }

      private int c() {
         int var1 = 0;
         LayoutParams var2 = this.a.getLayoutParams();
         if (this.a(this.a.getWidth())) {
            var1 = this.a.getWidth();
         } else if (var2 != null) {
            var1 = this.a(var2.width, false);
         }

         return var1;
      }

      @TargetApi(13)
      private Point d() {
         Point var1;
         if (this.d != null) {
            var1 = this.d;
         } else {
            Display var2 = ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
               this.d = new Point();
               var2.getSize(this.d);
            } else {
               this.d = new Point(var2.getWidth(), var2.getHeight());
            }

            var1 = this.d;
         }

         return var1;
      }

      public void a(SizeReadyCallback var1) {
         int var2 = this.c();
         int var3 = this.b();
         if (this.a(var2) && this.a(var3)) {
            var1.a(var2, var3);
         } else {
            if (!this.b.contains(var1)) {
               this.b.add(var1);
            }

            if (this.c == null) {
               ViewTreeObserver var4 = this.a.getViewTreeObserver();
               this.c = new ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener(this);
               var4.addOnPreDrawListener(this.c);
            }
         }
      }

      private static class SizeDeterminerLayoutListener implements OnPreDrawListener {
         private final WeakReference<ViewTarget.SizeDeterminer> a;

         public SizeDeterminerLayoutListener(ViewTarget.SizeDeterminer var1) {
            this.a = new WeakReference<>(var1);
         }

         public boolean onPreDraw() {
            if (Log.isLoggable("ViewTarget", 2)) {
               Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
            }

            ViewTarget.SizeDeterminer var1 = this.a.get();
            if (var1 != null) {
               var1.a();
            }

            return true;
         }
      }
   }
}
