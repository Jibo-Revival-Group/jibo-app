package com.salesforce.android.service.common.ui.internal.minimize;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

class MinimizedViewHolder {
   private static final ServiceLogger f = ServiceLogging.a(MinimizedViewHolder.class);
   final ViewGroup a;
   final ViewGroup b;
   final View c;
   final MinimizedViewHolder.Listener d;
   final MinimizeViewDrag e;

   MinimizedViewHolder(MinimizedViewHolder.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.d = var1.d;
      this.e = var1.e;
      this.c = var1.c;
      this.a();
   }

   void a() {
      this.b.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
         final MinimizedViewHolder a;

         {
            this.a = var1;
         }

         public void onViewAttachedToWindow(View var1) {
            var1.post(new Runnable(this, var1) {
               final View a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  this.b.a.d.d(this.a);
               }
            });
         }

         public void onViewDetachedFromWindow(View var1) {
            this.a.b.removeOnAttachStateChangeListener(this);
            this.a.b.setOnClickListener(null);
            this.a.e.a();
         }
      });
      this.b.setOnClickListener(new OnClickListener(this) {
         final MinimizedViewHolder a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.d.b(var1);
         }
      });
      this.a.findViewById(R.id.common_minview_close).setOnClickListener(new OnClickListener(this) {
         final MinimizedViewHolder a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.d.c(var1);
         }
      });
      this.d.a(this.c);
   }

   void a(Activity var1, Coordinate var2) {
      this.b();
      ViewGroup var3 = (ViewGroup)var1.findViewById(16908290);
      if (var3 != null) {
         var3.addView(this.a);
      } else {
         f.d(
            "Couldn't find android.R.id.content in {}. Are you calling Activity.setContentView and AppCompatDelegate.setContentView?",
            var1.getClass().getSimpleName()
         );
         ((ViewGroup)var1.getWindow().getDecorView()).addView(this.a);
      }

      if (var2 != null) {
         f.a("Setting minimized location to {} {}", var2.a(), var2.b());
         this.b.setX(var2.a());
         this.b.setY(var2.b());
         ((LayoutParams)this.b.getLayoutParams()).gravity = 0;
      }
   }

   void a(Coordinate var1) {
      f.a("Setting minimized location to {} {}", var1.a(), var1.b());
      this.b.setX(var1.a());
      this.b.setY(var1.b());
   }

   void b() {
      ViewGroup var1 = (ViewGroup)this.a.getParent();
      if (var1 != null) {
         var1.removeView(this.a);
      }
   }

   void b(Coordinate var1) {
      this.b.animate().x(var1.a()).y(var1.b()).setDuration(250L).start();
   }

   ViewGroup c() {
      return this.a;
   }

   ViewGroup d() {
      return this.b;
   }

   static class Builder {
      ViewGroup a;
      ViewGroup b;
      View c;
      MinimizedViewHolder.Listener d;
      MinimizeViewDrag e;

      MinimizedViewHolder.Builder a(MinimizedViewHolder.Listener var1) {
         this.d = var1;
         return this;
      }

      MinimizedViewHolder a(Activity var1) {
         if (this.a == null) {
            this.a = (ViewGroup)LayoutInflater.from(var1).inflate(R.layout.minimized_container, (ViewGroup)var1.getWindow().getDecorView(), false);
            ((LayoutParams)this.a.getLayoutParams()).gravity = 0;
         }

         if (this.b == null) {
            this.b = (ViewGroup)this.a.findViewById(R.id.salesforce_minview_thumbnail);
         }

         if (this.c == null) {
            this.c = this.b.findViewById(R.id.common_minview_content);
         }

         if (this.e == null) {
            this.e = new MinimizeViewDrag.Builder().a(this.a).b(this.b).a(this.d).a();
         }

         return new MinimizedViewHolder(this);
      }
   }

   static class Factory {
      MinimizedViewHolder a(Activity var1, MinimizedViewHolder.Listener var2) {
         return new MinimizedViewHolder.Builder().a(var2).a(var1);
      }
   }

   interface Listener extends MinimizeViewDrag.Listener {
      void a(View var1);

      void b(View var1);

      void c(View var1);

      void d(View var1);
   }
}
