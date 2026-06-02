package com.salesforce.android.knowledge.ui.internal.util;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class ScrollPositionListener extends RecyclerView.OnScrollListener {
   private int a = 0;

   public void a(Bundle var1) {
      var1.putInt("scroll_position_y_state", this.a);
   }

   @Override
   public void a(RecyclerView var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.a += var3;
   }

   public int b() {
      return this.a;
   }

   public void b(Bundle var1) {
      this.a = var1.getInt("scroll_position_y_state");
   }
}
