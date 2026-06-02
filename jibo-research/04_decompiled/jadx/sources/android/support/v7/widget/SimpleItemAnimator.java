package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* JADX INFO: renamed from: h */
    boolean f4296h = true;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4103a(RecyclerView.ViewHolder viewHolder);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4104a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4105a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo4109b(RecyclerView.ViewHolder viewHolder);

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: h */
    public boolean mo4451h(RecyclerView.ViewHolder viewHolder) {
        return !this.f4296h || viewHolder.isInvalid();
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4441a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i = itemHolderInfo.f4066a;
        int i2 = itemHolderInfo.f4067b;
        View view = viewHolder.itemView;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.f4066a;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.f4067b;
        if (!viewHolder.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return mo4104a(viewHolder, i, i2, left, top);
        }
        return mo4103a(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: b */
    public boolean mo4443b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        return (itemHolderInfo == null || (itemHolderInfo.f4066a == itemHolderInfo2.f4066a && itemHolderInfo.f4067b == itemHolderInfo2.f4067b)) ? mo4109b(viewHolder) : mo4104a(viewHolder, itemHolderInfo.f4066a, itemHolderInfo.f4067b, itemHolderInfo2.f4066a, itemHolderInfo2.f4067b);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: c */
    public boolean mo4444c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo.f4066a != itemHolderInfo2.f4066a || itemHolderInfo.f4067b != itemHolderInfo2.f4067b) {
            return mo4104a(viewHolder, itemHolderInfo.f4066a, itemHolderInfo.f4067b, itemHolderInfo2.f4066a, itemHolderInfo2.f4067b);
        }
        m4791j(viewHolder);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4442a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.f4066a;
        int i4 = itemHolderInfo.f4067b;
        if (viewHolder2.shouldIgnore()) {
            i = itemHolderInfo.f4066a;
            i2 = itemHolderInfo.f4067b;
        } else {
            i = itemHolderInfo2.f4066a;
            i2 = itemHolderInfo2.f4067b;
        }
        return mo4105a(viewHolder, viewHolder2, i3, i4, i, i2);
    }

    /* JADX INFO: renamed from: i */
    public final void m4790i(RecyclerView.ViewHolder viewHolder) {
        m4797p(viewHolder);
        m4447f(viewHolder);
    }

    /* JADX INFO: renamed from: j */
    public final void m4791j(RecyclerView.ViewHolder viewHolder) {
        m4801t(viewHolder);
        m4447f(viewHolder);
    }

    /* JADX INFO: renamed from: k */
    public final void m4792k(RecyclerView.ViewHolder viewHolder) {
        m4799r(viewHolder);
        m4447f(viewHolder);
    }

    /* JADX INFO: renamed from: a */
    public final void m4786a(RecyclerView.ViewHolder viewHolder, boolean z) {
        m4789d(viewHolder, z);
        m4447f(viewHolder);
    }

    /* JADX INFO: renamed from: l */
    public final void m4793l(RecyclerView.ViewHolder viewHolder) {
        m4796o(viewHolder);
    }

    /* JADX INFO: renamed from: m */
    public final void m4794m(RecyclerView.ViewHolder viewHolder) {
        m4800s(viewHolder);
    }

    /* JADX INFO: renamed from: n */
    public final void m4795n(RecyclerView.ViewHolder viewHolder) {
        m4798q(viewHolder);
    }

    /* JADX INFO: renamed from: b */
    public final void m4787b(RecyclerView.ViewHolder viewHolder, boolean z) {
        m4788c(viewHolder, z);
    }

    /* JADX INFO: renamed from: o */
    public void m4796o(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: p */
    public void m4797p(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: q */
    public void m4798q(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: r */
    public void m4799r(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: s */
    public void m4800s(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: t */
    public void m4801t(RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: renamed from: c */
    public void m4788c(RecyclerView.ViewHolder viewHolder, boolean z) {
    }

    /* JADX INFO: renamed from: d */
    public void m4789d(RecyclerView.ViewHolder viewHolder, boolean z) {
    }
}
