package com.salesforce.android.service.common.ui.internal.android;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class RecyclerViewAdapterDelegate<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements RecyclerViewAdapter<VH> {
   private RecyclerViewAdapter<VH> a;

   public void a(RecyclerViewAdapter<VH> var1) {
      this.a = var1;
   }

   @Override
   public int getItemCount() {
      Arguments.a(this.a);
      return this.a.getItemCount();
   }

   @Override
   public long getItemId(int var1) {
      Arguments.a(this.a);
      return this.a.getItemId(var1);
   }

   @Override
   public int getItemViewType(int var1) {
      Arguments.a(this.a);
      return this.a.getItemViewType(var1);
   }

   @Override
   public void onAttachedToRecyclerView(RecyclerView var1) {
      Arguments.a(this.a);
      this.a.onAttachedToRecyclerView(var1);
   }

   @Override
   public void onBindViewHolder(VH var1, int var2) {
      Arguments.a(this.a);
      this.a.onBindViewHolder((VH)var1, var2);
   }

   @Override
   public VH onCreateViewHolder(ViewGroup var1, int var2) {
      Arguments.a(this.a);
      return this.a.onCreateViewHolder(var1, var2);
   }

   @Override
   public void onDetachedFromRecyclerView(RecyclerView var1) {
      Arguments.a(this.a);
      this.a.onDetachedFromRecyclerView(var1);
   }
}
