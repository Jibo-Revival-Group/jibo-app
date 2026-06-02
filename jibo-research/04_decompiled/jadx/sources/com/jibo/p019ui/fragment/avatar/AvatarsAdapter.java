package com.jibo.p019ui.fragment.avatar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class AvatarsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    private int f10143a;

    /* JADX INFO: renamed from: b */
    private View.OnClickListener f10144b;

    /* JADX INFO: renamed from: c */
    private int f10145c;

    public AvatarsAdapter(int i, int i2, View.OnClickListener onClickListener) {
        this.f10143a = 0;
        this.f10145c = i;
        this.f10143a = i2;
        this.f10144b = onClickListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f10145c, viewGroup, false);
        AvatarViewHolder avatarViewHolder = new AvatarViewHolder(viewInflate);
        viewInflate.setOnClickListener(this.f10144b);
        return avatarViewHolder;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((AvatarViewHolder) viewHolder).m10474a(i, i == this.f10143a);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 12;
    }

    /* JADX INFO: renamed from: a */
    public void m10475a(int i) {
        this.f10143a = i;
    }
}
