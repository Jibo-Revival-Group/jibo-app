package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
   final ChildHelper.Callback a;
   final ChildHelper.Bucket b;
   final List<View> c;

   ChildHelper(ChildHelper.Callback var1) {
      this.a = var1;
      this.b = new ChildHelper.Bucket();
      this.c = new ArrayList<>();
   }

   private int f(int var1) {
      byte var5;
      if (var1 < 0) {
         var5 = -1;
      } else {
         int var3 = this.a.a();
         int var2 = var1;

         while (var2 < var3) {
            int var4 = var1 - (var2 - this.b.e(var2));
            if (var4 == 0) {
               while (true) {
                  var5 = var2;
                  if (!this.b.c(var2)) {
                     return var5;
                  }

                  var2++;
               }
            }

            var2 += var4;
         }

         var5 = -1;
      }

      return var5;
   }

   private void g(View var1) {
      this.c.add(var1);
      this.a.c(var1);
   }

   private boolean h(View var1) {
      boolean var2;
      if (this.c.remove(var1)) {
         this.a.d(var1);
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   void a() {
      this.b.a();

      for (int var1 = this.c.size() - 1; var1 >= 0; var1--) {
         this.a.d(this.c.get(var1));
         this.c.remove(var1);
      }

      this.a.b();
   }

   void a(int var1) {
      var1 = this.f(var1);
      View var2 = this.a.b(var1);
      if (var2 != null) {
         if (this.b.d(var1)) {
            this.h(var2);
         }

         this.a.a(var1);
      }
   }

   void a(View var1) {
      int var2 = this.a.a(var1);
      if (var2 >= 0) {
         if (this.b.d(var2)) {
            this.h(var1);
         }

         this.a.a(var2);
      }
   }

   void a(View var1, int var2, LayoutParams var3, boolean var4) {
      if (var2 < 0) {
         var2 = this.a.a();
      } else {
         var2 = this.f(var2);
      }

      this.b.a(var2, var4);
      if (var4) {
         this.g(var1);
      }

      this.a.a(var1, var2, var3);
   }

   void a(View var1, int var2, boolean var3) {
      if (var2 < 0) {
         var2 = this.a.a();
      } else {
         var2 = this.f(var2);
      }

      this.b.a(var2, var3);
      if (var3) {
         this.g(var1);
      }

      this.a.a(var1, var2);
   }

   void a(View var1, boolean var2) {
      this.a(var1, -1, var2);
   }

   int b() {
      return this.a.a() - this.c.size();
   }

   int b(View var1) {
      int var2 = -1;
      int var3 = this.a.a(var1);
      if (var3 != -1 && !this.b.c(var3)) {
         var2 = var3 - this.b.e(var3);
      }

      return var2;
   }

   View b(int var1) {
      var1 = this.f(var1);
      return this.a.b(var1);
   }

   int c() {
      return this.a.a();
   }

   View c(int var1) {
      int var3 = this.c.size();
      int var2 = 0;

      View var4;
      while (true) {
         if (var2 >= var3) {
            var4 = null;
            break;
         }

         var4 = this.c.get(var2);
         RecyclerView.ViewHolder var5 = this.a.b(var4);
         if (var5.getLayoutPosition() == var1 && !var5.isInvalid() && !var5.isRemoved()) {
            break;
         }

         var2++;
      }

      return var4;
   }

   boolean c(View var1) {
      return this.c.contains(var1);
   }

   View d(int var1) {
      return this.a.b(var1);
   }

   void d(View var1) {
      int var2 = this.a.a(var1);
      if (var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      }

      this.b.a(var2);
      this.g(var1);
   }

   void e(int var1) {
      var1 = this.f(var1);
      this.b.d(var1);
      this.a.c(var1);
   }

   void e(View var1) {
      int var2 = this.a.a(var1);
      if (var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      }

      if (!this.b.c(var2)) {
         throw new RuntimeException("trying to unhide a view that was not hidden" + var1);
      }

      this.b.b(var2);
      this.h(var1);
   }

   boolean f(View var1) {
      boolean var3 = true;
      int var2 = this.a.a(var1);
      if (var2 == -1) {
         if (this.h(var1)) {
         }
      } else if (this.b.c(var2)) {
         this.b.d(var2);
         if (!this.h(var1)) {
         }

         this.a.a(var2);
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public String toString() {
      return this.b.toString() + ", hidden list:" + this.c.size();
   }

   static class Bucket {
      long a = 0L;
      ChildHelper.Bucket b;

      private void b() {
         if (this.b == null) {
            this.b = new ChildHelper.Bucket();
         }
      }

      void a() {
         this.a = 0L;
         if (this.b != null) {
            this.b.a();
         }
      }

      void a(int var1) {
         if (var1 >= 64) {
            this.b();
            this.b.a(var1 - 64);
         } else {
            this.a |= 1L << var1;
         }
      }

      void a(int var1, boolean var2) {
         if (var1 >= 64) {
            this.b();
            this.b.a(var1 - 64, var2);
         } else {
            boolean var7;
            if ((this.a & Long.MIN_VALUE) != 0L) {
               var7 = true;
            } else {
               var7 = false;
            }

            long var3 = (1L << var1) - 1L;
            long var5 = this.a;
            this.a = (~var3 & this.a) << 1 | var5 & var3;
            if (var2) {
               this.a(var1);
            } else {
               this.b(var1);
            }

            if (var7 || this.b != null) {
               this.b();
               this.b.a(0, var7);
            }
         }
      }

      void b(int var1) {
         if (var1 >= 64) {
            if (this.b != null) {
               this.b.b(var1 - 64);
            }
         } else {
            this.a &= ~(1L << var1);
         }
      }

      boolean c(int var1) {
         boolean var2;
         if (var1 >= 64) {
            this.b();
            var2 = this.b.c(var1 - 64);
         } else if ((this.a & 1L << var1) != 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      boolean d(int var1) {
         boolean var3;
         if (var1 >= 64) {
            this.b();
            var3 = this.b.d(var1 - 64);
         } else {
            long var4 = 1L << var1;
            boolean var2;
            if ((this.a & var4) != 0L) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.a &= ~var4;
            long var6 = var4 - 1L;
            var4 = this.a;
            this.a = Long.rotateRight(~var6 & this.a, 1) | var4 & var6;
            var3 = var2;
            if (this.b != null) {
               if (this.b.c(0)) {
                  this.a(63);
               }

               this.b.d(0);
               var3 = var2;
            }
         }

         return var3;
      }

      int e(int var1) {
         if (this.b == null) {
            if (var1 >= 64) {
               var1 = Long.bitCount(this.a);
            } else {
               var1 = Long.bitCount(this.a & (1L << var1) - 1L);
            }
         } else if (var1 < 64) {
            var1 = Long.bitCount(this.a & (1L << var1) - 1L);
         } else {
            var1 = this.b.e(var1 - 64) + Long.bitCount(this.a);
         }

         return var1;
      }

      @Override
      public String toString() {
         String var1;
         if (this.b == null) {
            var1 = Long.toBinaryString(this.a);
         } else {
            var1 = this.b.toString() + "xx" + Long.toBinaryString(this.a);
         }

         return var1;
      }
   }

   interface Callback {
      int a();

      int a(View var1);

      void a(int var1);

      void a(View var1, int var2);

      void a(View var1, int var2, LayoutParams var3);

      RecyclerView.ViewHolder b(View var1);

      View b(int var1);

      void b();

      void c(int var1);

      void c(View var1);

      void d(View var1);
   }
}
