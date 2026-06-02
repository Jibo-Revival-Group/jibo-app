package com.salesforce.android.knowledge.ui.internal.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class KnowledgeRecyclerView extends RecyclerView {
   public KnowledgeRecyclerView(Context var1) {
      super(var1);
   }

   public KnowledgeRecyclerView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public KnowledgeRecyclerView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   @Override
   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.post(new Runnable(this) {
         final KnowledgeRecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.requestLayout();
         }
      });
   }
}
