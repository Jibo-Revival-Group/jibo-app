package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
   final ArrayList<ViewPropertyAnimatorCompat> a;
   ViewPropertyAnimatorListener b;
   private long c = -1L;
   private Interpolator d;
   private boolean e;
   private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter(this) {
      final ViewPropertyAnimatorCompatSet a;
      private boolean b;
      private int c;

      {
         this.a = var1;
         this.b = false;
         this.c = 0;
      }

      void a() {
         this.c = 0;
         this.b = false;
         this.a.b();
      }

      @Override
      public void a(View var1) {
         if (!this.b) {
            this.b = true;
            if (this.a.b != null) {
               this.a.b.a(null);
            }
         }
      }

      @Override
      public void b(View var1) {
         int var2 = this.c + 1;
         this.c = var2;
         if (var2 == this.a.a.size()) {
            if (this.a.b != null) {
               this.a.b.b(null);
            }

            this.a();
         }
      }
   };

   public ViewPropertyAnimatorCompatSet() {
      this.a = new ArrayList<>();
   }

   public ViewPropertyAnimatorCompatSet a(long var1) {
      if (!this.e) {
         this.c = var1;
      }

      return this;
   }

   public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorCompat var1) {
      if (!this.e) {
         this.a.add(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorCompat var1, ViewPropertyAnimatorCompat var2) {
      this.a.add(var1);
      var2.b(var1.a());
      this.a.add(var2);
      return this;
   }

   public ViewPropertyAnimatorCompatSet a(ViewPropertyAnimatorListener var1) {
      if (!this.e) {
         this.b = var1;
      }

      return this;
   }

   public ViewPropertyAnimatorCompatSet a(Interpolator var1) {
      if (!this.e) {
         this.d = var1;
      }

      return this;
   }

   public void a() {
      if (!this.e) {
         for (ViewPropertyAnimatorCompat var1 : this.a) {
            if (this.c >= 0L) {
               var1.a(this.c);
            }

            if (this.d != null) {
               var1.a(this.d);
            }

            if (this.b != null) {
               var1.a(this.f);
            }

            var1.c();
         }

         this.e = true;
      }
   }

   void b() {
      this.e = false;
   }

   public void c() {
      if (this.e) {
         Iterator var1 = this.a.iterator();

         while (var1.hasNext()) {
            ((ViewPropertyAnimatorCompat)var1.next()).b();
         }

         this.e = false;
      }
   }
}
