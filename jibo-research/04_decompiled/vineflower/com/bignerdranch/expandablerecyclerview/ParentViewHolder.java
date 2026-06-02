package com.bignerdranch.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.bignerdranch.expandablerecyclerview.model.Parent;

public class ParentViewHolder<P extends Parent<C>, C> extends RecyclerView.ViewHolder implements OnClickListener {
   P a;
   ExpandableRecyclerAdapter b;
   private ParentViewHolder.ParentViewHolderExpandCollapseListener c;
   private boolean d = false;

   public ParentViewHolder(View var1) {
      super(var1);
   }

   public void a() {
      this.itemView.setOnClickListener(this);
   }

   void a(ParentViewHolder.ParentViewHolderExpandCollapseListener var1) {
      this.c = var1;
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public void b(boolean var1) {
   }

   public boolean b() {
      return this.d;
   }

   public boolean c() {
      return true;
   }

   protected void d() {
      this.a(true);
      this.b(false);
      if (this.c != null) {
         this.c.a(this.getAdapterPosition());
      }
   }

   protected void e() {
      this.a(false);
      this.b(true);
      if (this.c != null) {
         this.c.b(this.getAdapterPosition());
      }
   }

   public void onClick(View var1) {
      if (this.d) {
         this.e();
      } else {
         this.d();
      }
   }

   interface ParentViewHolderExpandCollapseListener {
      void a(int var1);

      void b(int var1);
   }
}
