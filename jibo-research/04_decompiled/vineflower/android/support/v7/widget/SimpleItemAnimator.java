package android.support.v7.widget;

import android.view.View;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
   boolean h = true;

   public final void a(RecyclerView.ViewHolder var1, boolean var2) {
      this.d(var1, var2);
      this.f(var1);
   }

   public abstract boolean a(RecyclerView.ViewHolder var1);

   public abstract boolean a(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5);

   @Override
   public boolean a(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3) {
      int var7 = var2.a;
      int var6 = var2.b;
      View var9 = var1.itemView;
      int var4;
      if (var3 == null) {
         var4 = var9.getLeft();
      } else {
         var4 = var3.a;
      }

      int var5;
      if (var3 == null) {
         var5 = var9.getTop();
      } else {
         var5 = var3.b;
      }

      boolean var8;
      if (var1.isRemoved() || var7 == var4 && var6 == var5) {
         var8 = this.a(var1);
      } else {
         var9.layout(var4, var5, var9.getWidth() + var4, var9.getHeight() + var5);
         var8 = this.a(var1, var7, var6, var4, var5);
      }

      return var8;
   }

   public abstract boolean a(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6);

   @Override
   public boolean a(
      RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, RecyclerView.ItemAnimator.ItemHolderInfo var3, RecyclerView.ItemAnimator.ItemHolderInfo var4
   ) {
      int var7 = var3.a;
      int var8 = var3.b;
      int var5;
      int var6;
      if (var2.shouldIgnore()) {
         var6 = var3.a;
         var5 = var3.b;
      } else {
         var6 = var4.a;
         var5 = var4.b;
      }

      return this.a(var1, var2, var7, var8, var6, var5);
   }

   public final void b(RecyclerView.ViewHolder var1, boolean var2) {
      this.c(var1, var2);
   }

   public abstract boolean b(RecyclerView.ViewHolder var1);

   @Override
   public boolean b(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3) {
      boolean var4;
      if (var2 == null || var2.a == var3.a && var2.b == var3.b) {
         var4 = this.b(var1);
      } else {
         var4 = this.a(var1, var2.a, var2.b, var3.a, var3.b);
      }

      return var4;
   }

   public void c(RecyclerView.ViewHolder var1, boolean var2) {
   }

   @Override
   public boolean c(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3) {
      boolean var4;
      if (var2.a == var3.a && var2.b == var3.b) {
         this.j(var1);
         var4 = false;
      } else {
         var4 = this.a(var1, var2.a, var2.b, var3.a, var3.b);
      }

      return var4;
   }

   public void d(RecyclerView.ViewHolder var1, boolean var2) {
   }

   @Override
   public boolean h(RecyclerView.ViewHolder var1) {
      boolean var2;
      if (this.h && !var1.isInvalid()) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public final void i(RecyclerView.ViewHolder var1) {
      this.p(var1);
      this.f(var1);
   }

   public final void j(RecyclerView.ViewHolder var1) {
      this.t(var1);
      this.f(var1);
   }

   public final void k(RecyclerView.ViewHolder var1) {
      this.r(var1);
      this.f(var1);
   }

   public final void l(RecyclerView.ViewHolder var1) {
      this.o(var1);
   }

   public final void m(RecyclerView.ViewHolder var1) {
      this.s(var1);
   }

   public final void n(RecyclerView.ViewHolder var1) {
      this.q(var1);
   }

   public void o(RecyclerView.ViewHolder var1) {
   }

   public void p(RecyclerView.ViewHolder var1) {
   }

   public void q(RecyclerView.ViewHolder var1) {
   }

   public void r(RecyclerView.ViewHolder var1) {
   }

   public void s(RecyclerView.ViewHolder var1) {
   }

   public void t(RecyclerView.ViewHolder var1) {
   }
}
