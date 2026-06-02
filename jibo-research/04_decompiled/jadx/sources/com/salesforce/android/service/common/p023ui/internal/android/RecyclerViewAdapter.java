package com.salesforce.android.service.common.p023ui.internal.android;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public interface RecyclerViewAdapter<VH extends RecyclerView.ViewHolder> {
    int getItemCount();

    long getItemId(int i);

    int getItemViewType(int i);

    void onAttachedToRecyclerView(RecyclerView recyclerView);

    void onBindViewHolder(VH vh, int i);

    VH onCreateViewHolder(ViewGroup viewGroup, int i);

    void onDetachedFromRecyclerView(RecyclerView recyclerView);
}
