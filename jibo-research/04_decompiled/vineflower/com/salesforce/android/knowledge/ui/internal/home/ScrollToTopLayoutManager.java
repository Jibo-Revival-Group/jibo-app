package com.salesforce.android.knowledge.ui.internal.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

public class ScrollToTopLayoutManager extends LinearLayoutManager {
   public ScrollToTopLayoutManager(Context var1) {
      super(var1);
   }

   @Override
   public void e(int var1) {
      this.b(var1, 0);
   }
}
