package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class OrientationHelper {
   protected final RecyclerView.LayoutManager a;
   final Rect b;
   private int c = Integer.MIN_VALUE;

   private OrientationHelper(RecyclerView.LayoutManager var1) {
      this.b = new Rect();
      this.a = var1;
   }

   public static OrientationHelper a(RecyclerView.LayoutManager var0) {
      return new OrientationHelper(var0) {
         @Override
         public int a(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.a.h(var1) - var2.leftMargin;
         }

         @Override
         public void a(int var1) {
            this.a.j(var1);
         }

         @Override
         public int b(View var1) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.j(var1);
            return var3.rightMargin + var2;
         }

         @Override
         public int c() {
            return this.a.A();
         }

         @Override
         public int c(View var1) {
            this.a.a(var1, true, this.b);
            return this.b.right;
         }

         @Override
         public int d() {
            return this.a.y() - this.a.C();
         }

         @Override
         public int d(View var1) {
            this.a.a(var1, true, this.b);
            return this.b.left;
         }

         @Override
         public int e() {
            return this.a.y();
         }

         @Override
         public int e(View var1) {
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.f(var1);
            int var3 = var4.leftMargin;
            return var4.rightMargin + var2 + var3;
         }

         @Override
         public int f() {
            return this.a.y() - this.a.A() - this.a.C();
         }

         @Override
         public int f(View var1) {
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.g(var1);
            int var3 = var4.topMargin;
            return var4.bottomMargin + var2 + var3;
         }

         @Override
         public int g() {
            return this.a.C();
         }

         @Override
         public int h() {
            return this.a.w();
         }

         @Override
         public int i() {
            return this.a.x();
         }
      };
   }

   public static OrientationHelper a(RecyclerView.LayoutManager var0, int var1) {
      OrientationHelper var2;
      switch (var1) {
         case 0:
            var2 = a(var0);
            break;
         case 1:
            var2 = b(var0);
            break;
         default:
            throw new IllegalArgumentException("invalid orientation");
      }

      return var2;
   }

   public static OrientationHelper b(RecyclerView.LayoutManager var0) {
      return new OrientationHelper(var0) {
         @Override
         public int a(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.a.i(var1) - var2.topMargin;
         }

         @Override
         public void a(int var1) {
            this.a.k(var1);
         }

         @Override
         public int b(View var1) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.k(var1);
            return var3.bottomMargin + var2;
         }

         @Override
         public int c() {
            return this.a.B();
         }

         @Override
         public int c(View var1) {
            this.a.a(var1, true, this.b);
            return this.b.bottom;
         }

         @Override
         public int d() {
            return this.a.z() - this.a.D();
         }

         @Override
         public int d(View var1) {
            this.a.a(var1, true, this.b);
            return this.b.top;
         }

         @Override
         public int e() {
            return this.a.z();
         }

         @Override
         public int e(View var1) {
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var3 = this.a.g(var1);
            int var2 = var4.topMargin;
            return var4.bottomMargin + var3 + var2;
         }

         @Override
         public int f() {
            return this.a.z() - this.a.B() - this.a.D();
         }

         @Override
         public int f(View var1) {
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var3 = this.a.f(var1);
            int var2 = var4.leftMargin;
            return var4.rightMargin + var3 + var2;
         }

         @Override
         public int g() {
            return this.a.D();
         }

         @Override
         public int h() {
            return this.a.x();
         }

         @Override
         public int i() {
            return this.a.w();
         }
      };
   }

   public abstract int a(View var1);

   public void a() {
      this.c = this.f();
   }

   public abstract void a(int var1);

   public int b() {
      int var1;
      if (Integer.MIN_VALUE == this.c) {
         var1 = 0;
      } else {
         var1 = this.f() - this.c;
      }

      return var1;
   }

   public abstract int b(View var1);

   public abstract int c();

   public abstract int c(View var1);

   public abstract int d();

   public abstract int d(View var1);

   public abstract int e();

   public abstract int e(View var1);

   public abstract int f();

   public abstract int f(View var1);

   public abstract int g();

   public abstract int h();

   public abstract int i();
}
