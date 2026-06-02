package com.salesforce.android.service.common.ui.internal.android;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface RecyclerViewAdapter<VH extends RecyclerView.ViewHolder> {
   int getItemCount();

   long getItemId(int var1);

   int getItemViewType(int var1);

   void onAttachedToRecyclerView(RecyclerView var1);

   void onBindViewHolder(VH var1, int var2);

   VH onCreateViewHolder(ViewGroup var1, int var2);

   void onDetachedFromRecyclerView(RecyclerView var1);
}
