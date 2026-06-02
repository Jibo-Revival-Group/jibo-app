package com.salesforce.android.knowledge.p022ui.internal.util;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListController<T extends RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    private final Adapter<T> f13430a;

    /* JADX INFO: renamed from: a */
    public abstract int mo13457a();

    /* JADX INFO: renamed from: a */
    public abstract T mo13459a(ViewGroup viewGroup, int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo13460a(T t, int i);

    protected ListController() {
        this(new Adapter());
    }

    protected ListController(Adapter<T> adapter) {
        this.f13430a = adapter;
        this.f13430a.m13707a(this);
    }

    /* JADX INFO: renamed from: c */
    public Adapter<T> m13706c() {
        return this.f13430a;
    }

    /* JADX INFO: renamed from: a */
    public int mo13458a(int i) {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public void m13705a(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: b */
    public long mo13665b(int i) {
        return -1L;
    }

    public static class Adapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

        /* JADX INFO: renamed from: a */
        private ListController<T> f13431a;

        Adapter() {
        }

        /* JADX INFO: renamed from: a */
        void m13707a(ListController<T> listController) {
            this.f13431a = listController;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public T onCreateViewHolder(ViewGroup viewGroup, int i) {
            return (T) this.f13431a.mo13459a(viewGroup, i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(T t, int i) {
            this.f13431a.mo13460a(t, i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f13431a.mo13457a();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f13431a.mo13458a(i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onViewRecycled(T t) {
            this.f13431a.m13705a(t);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.f13431a.mo13665b(i);
        }
    }
}
