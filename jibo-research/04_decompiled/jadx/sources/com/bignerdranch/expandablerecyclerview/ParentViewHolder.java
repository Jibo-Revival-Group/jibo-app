package com.bignerdranch.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bignerdranch.expandablerecyclerview.model.Parent;

/* JADX INFO: loaded from: classes.dex */
public class ParentViewHolder<P extends Parent<C>, C> extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    P f4656a;

    /* JADX INFO: renamed from: b */
    ExpandableRecyclerAdapter f4657b;

    /* JADX INFO: renamed from: c */
    private ParentViewHolderExpandCollapseListener f4658c;

    /* JADX INFO: renamed from: d */
    private boolean f4659d;

    interface ParentViewHolderExpandCollapseListener {
        /* JADX INFO: renamed from: a */
        void mo5184a(int i);

        /* JADX INFO: renamed from: b */
        void mo5185b(int i);
    }

    public ParentViewHolder(View view) {
        super(view);
        this.f4659d = false;
    }

    /* JADX INFO: renamed from: a */
    public void m5188a() {
        this.itemView.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: b */
    public boolean m5192b() {
        return this.f4659d;
    }

    /* JADX INFO: renamed from: a */
    public void m5190a(boolean z) {
        this.f4659d = z;
    }

    /* JADX INFO: renamed from: b */
    public void mo5191b(boolean z) {
    }

    /* JADX INFO: renamed from: a */
    void m5189a(ParentViewHolderExpandCollapseListener parentViewHolderExpandCollapseListener) {
        this.f4658c = parentViewHolderExpandCollapseListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4659d) {
            m5195e();
        } else {
            m5194d();
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m5193c() {
        return true;
    }

    /* JADX INFO: renamed from: d */
    protected void m5194d() {
        m5190a(true);
        mo5191b(false);
        if (this.f4658c != null) {
            this.f4658c.mo5184a(getAdapterPosition());
        }
    }

    /* JADX INFO: renamed from: e */
    protected void m5195e() {
        m5190a(false);
        mo5191b(true);
        if (this.f4658c != null) {
            this.f4658c.mo5185b(getAdapterPosition());
        }
    }
}
