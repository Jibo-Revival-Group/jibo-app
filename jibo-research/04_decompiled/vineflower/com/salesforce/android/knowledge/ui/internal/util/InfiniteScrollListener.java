package com.salesforce.android.knowledge.ui.internal.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class InfiniteScrollListener extends ScrollPositionListener {
   private final LinearLayoutManager a;
   private InfiniteScrollListener.BehaviorListener b;
   private int c;
   private boolean d = true;

   private InfiniteScrollListener(LinearLayoutManager var1) {
      this.a = var1;
   }

   public static InfiniteScrollListener a(LinearLayoutManager var0) {
      return new InfiniteScrollListener(var0);
   }

   private boolean a(int var1, int var2) {
      boolean var3 = true;
      if (this.a.f()) {
         if (var2 <= 0) {
            var3 = false;
         }
      } else if (var1 <= 0) {
         var3 = false;
      }

      return var3;
   }

   public LinearLayoutManager a() {
      return this.a;
   }

   public InfiniteScrollListener a(int var1) {
      this.c = var1;
      return this;
   }

   public InfiniteScrollListener a(InfiniteScrollListener.BehaviorListener var1) {
      this.b = var1;
      return this;
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.b != null && this.d) {
         boolean var6 = this.a(var2, var3);
         var3 = this.a.m();
         int var4 = var1.getChildCount();
         int var5 = this.a.F();
         var2 = this.c;
         if (var6 && var3 + var4 > var5 - 1 - var2) {
            this.b.s_();
            this.d = false;
         }
      }
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public interface BehaviorListener {
      void s_();
   }
}
