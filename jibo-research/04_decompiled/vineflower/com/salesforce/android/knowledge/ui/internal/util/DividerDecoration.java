package com.salesforce.android.knowledge.ui.internal.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerDecoration extends RecyclerView.ItemDecoration {
   private final Drawable a;

   public DividerDecoration(Drawable var1) {
      this.a = var1;
   }

   @Override
   public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
      super.a(var1, var2, var3, var4);
      var1.top = this.a.getIntrinsicHeight();
   }

   @Override
   public void b(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      int var5 = var2.getWidth();

      for (int var4 = 0; var4 < var2.getChildCount(); var4++) {
         View var8 = var2.getChildAt(var4);
         RecyclerView.LayoutParams var9 = (RecyclerView.LayoutParams)var8.getLayoutParams();
         int var7 = var8.getTop() - var9.topMargin;
         int var6 = this.a.getIntrinsicHeight();
         this.a.setBounds(0, var7 - var6, var5, var7);
         this.a.draw(var1);
      }
   }
}
