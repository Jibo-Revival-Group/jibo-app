package com.salesforce.android.service.common.p023ui.internal.android;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAdapterDelegate<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements RecyclerViewAdapter<VH> {

    /* JADX INFO: renamed from: a */
    private RecyclerViewAdapter<VH> f13666a;

    /* JADX INFO: renamed from: a */
    public void m13936a(RecyclerViewAdapter<VH> recyclerViewAdapter) {
        this.f13666a = recyclerViewAdapter;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        Arguments.m14235a(this.f13666a);
        return this.f13666a.getItemCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Arguments.m14235a(this.f13666a);
        return this.f13666a.getItemId(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Arguments.m14235a(this.f13666a);
        return this.f13666a.getItemViewType(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Arguments.m14235a(this.f13666a);
        return (VH) this.f13666a.onCreateViewHolder(viewGroup, i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i) {
        Arguments.m14235a(this.f13666a);
        this.f13666a.onBindViewHolder(vh, i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Arguments.m14235a(this.f13666a);
        this.f13666a.onAttachedToRecyclerView(recyclerView);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Arguments.m14235a(this.f13666a);
        this.f13666a.onDetachedFromRecyclerView(recyclerView);
    }
}
