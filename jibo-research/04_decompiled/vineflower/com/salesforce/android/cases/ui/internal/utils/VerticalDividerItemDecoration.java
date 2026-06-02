package com.salesforce.android.cases.ui.internal.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VerticalDividerItemDecoration extends RecyclerView.ItemDecoration {
   private Drawable a;
   private int b;
   private int c;

   public VerticalDividerItemDecoration(Drawable var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private void c(Canvas var1, RecyclerView var2) {
      int var4 = var2.getPaddingLeft();
      int var7 = var2.getWidth();
      int var5 = var2.getPaddingRight();
      int var6 = var2.getChildCount();

      for (int var3 = 0; var3 < var6 - 1; var3++) {
         View var10 = var2.getChildAt(var3);
         RecyclerView.LayoutParams var11 = (RecyclerView.LayoutParams)var10.getLayoutParams();
         int var8 = var10.getBottom();
         var8 = var11.bottomMargin + var8;
         int var9 = this.a.getIntrinsicHeight();
         this.a.setBounds(this.b + var4, var8, var7 - var5 - this.c, var9 + var8);
         this.a.draw(var1);
      }
   }

   @Override
   public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
      super.a(var1, var2, var3, var4);
      if (var3.getChildAdapterPosition(var2) != 0) {
         var1.top = this.a.getIntrinsicHeight();
      }
   }

   @Override
   public void b(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      this.c(var1, var2);
   }
}
