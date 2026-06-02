package com.salesforce.android.service.common.ui.internal.minimize;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

class MinimizedViewManager implements MinimizedViewHolder.Listener, ActivityTracker.OnPauseListener, ActivityTracker.OnResumeListener {
   MinimizeListener a;
   final ActivityTracker b;
   final MinimizedViewHolder.Factory c;
   final Set<Class<? extends Activity>> d;
   MinimizedViewHolder e;
   Minimizer f;
   Coordinate g;
   ActivityReference<Activity> h = ActivityReference.a();

   MinimizedViewManager(MinimizedViewManager.Builder var1) {
      this.b = var1.b;
      this.a = var1.a;
      this.c = var1.c;
      this.d = var1.d;
   }

   static Coordinate a(Coordinate var0, MinimizedViewHolder var1) {
      ViewGroup var5 = var1.c();
      ViewGroup var6 = var1.d();
      int var3 = Math.max(var0.a(), 0);
      int var4 = Math.max(var0.b(), 0);
      int var2 = var3;
      if (var6.getWidth() + var3 > var5.getWidth()) {
         var2 = var5.getWidth() - var6.getWidth();
      }

      var3 = var4;
      if (var6.getHeight() + var4 > var5.getHeight()) {
         var3 = var5.getHeight() - var6.getHeight();
      }

      if (var2 != var0.a() || var3 != var0.b()) {
         var0 = Coordinate.a(var2, var3);
      }

      return var0;
   }

   private void a(MinimizedViewHolder var1) {
      if (this.e != null) {
         this.e.b();
      }

      this.e = var1;
   }

   private void d() {
      this.b.b(this);
      this.b.b(this);
      this.h.clear();
      this.f = null;
   }

   void a(Activity var1) {
      this.h = ActivityReference.a(var1);
   }

   @Override
   public void a(View var1) {
      if (this.a != null) {
         ViewGroup var2 = (ViewGroup)var1;
         var2.removeAllViews();
         this.h.a(new Consumer<Activity>(this, var2) {
            final ViewGroup a;
            final MinimizedViewManager b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void a(Activity var1) {
               this.b.a.a(this.a, var1);
            }
         });
      }
   }

   void a(Minimizer var1) {
      this.b.a(this);
      this.b.a(this);
      this.f = var1;
   }

   @Override
   public void a(Coordinate var1) {
      if (this.e != null) {
         this.g = a(var1, this.e);
         if (!this.g.equals(var1)) {
            this.e.b(this.g);
         }

         this.a.a(var1);
      }
   }

   boolean a() {
      boolean var1;
      if (this.e != null && this.h.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   void b() {
      this.a((MinimizedViewHolder)null);
      this.d();
   }

   @Override
   public void b(Activity var1) {
      this.a(var1);
      if (var1 != null && !this.d.contains(var1.getClass()) && !Minimizer.a.contains(var1.getClass())) {
         this.d(var1);
      }
   }

   @Override
   public void b(View var1) {
      if (this.f != null) {
         this.h.a(new Consumer<Activity>(this) {
            final MinimizedViewManager a;

            {
               this.a = var1;
            }

            public void a(Activity var1) {
               this.a.f.a(var1);
            }
         });
      }
   }

   void c() {
      this.b();
   }

   @Override
   public void c(Activity var1) {
      if (this.h.a(var1) && this.e != null) {
         this.e.b();
         this.e = null;
      }

      this.h.b(var1);
   }

   @Override
   public void c(View var1) {
      if (this.a != null) {
         this.a.d();
      }
   }

   void d(Activity var1) {
      MinimizedViewHolder var2 = this.c.a(var1, this);
      var2.a(var1, this.g);
      this.a(var2);
   }

   @Override
   public void d(View var1) {
      if (this.g != null && this.e != null) {
         Coordinate var2 = a(this.g, this.e);
         if (!var2.equals(this.g)) {
            this.g = var2;
            if (this.e != null) {
               this.e.a(var2);
            }
         }
      }
   }

   static class Builder {
      MinimizeListener a;
      ActivityTracker b;
      MinimizedViewHolder.Factory c = new MinimizedViewHolder.Factory();
      Set<Class<? extends Activity>> d = new HashSet<>();

      MinimizedViewManager.Builder a(MinimizeListener var1) {
         this.a = var1;
         return this;
      }

      MinimizedViewManager.Builder a(ActivityTracker var1) {
         this.b = var1;
         return this;
      }

      MinimizedViewManager.Builder a(Set<Class<? extends Activity>> var1) {
         this.d.addAll(var1);
         return this;
      }

      MinimizedViewManager a() {
         Arguments.a(this.b, "ActivityTracker must be provided to the MinimizedViewManager");
         return new MinimizedViewManager(this);
      }
   }
}
