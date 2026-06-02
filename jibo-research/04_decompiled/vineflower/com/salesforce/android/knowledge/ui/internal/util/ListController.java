package com.salesforce.android.knowledge.ui.internal.util;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class ListController<T extends RecyclerView.ViewHolder> {
   private final ListController.Adapter<T> a;

   protected ListController() {
      this(new ListController.Adapter<>());
   }

   protected ListController(ListController.Adapter<T> var1) {
      this.a = var1;
      this.a.a(this);
   }

   public abstract int a();

   public int a(int var1) {
      return 0;
   }

   public abstract T a(ViewGroup var1, int var2);

   public void a(RecyclerView.ViewHolder var1) {
   }

   public abstract void a(T var1, int var2);

   public long b(int var1) {
      return -1L;
   }

   public ListController.Adapter<T> c() {
      return this.a;
   }

   public static class Adapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
      private ListController<T> a;

      Adapter() {
      }

      void a(ListController<T> var1) {
         this.a = var1;
      }

      @Override
      public int getItemCount() {
         return this.a.a();
      }

      @Override
      public long getItemId(int var1) {
         return this.a.b(var1);
      }

      @Override
      public int getItemViewType(int var1) {
         return this.a.a(var1);
      }

      @Override
      public void onBindViewHolder(T var1, int var2) {
         this.a.a((T)var1, var2);
      }

      @Override
      public T onCreateViewHolder(ViewGroup var1, int var2) {
         return this.a.a(var1, var2);
      }

      @Override
      public void onViewRecycled(T var1) {
         this.a.a(var1);
      }
   }
}
