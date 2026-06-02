package com.jibo.p019ui.fragment.jibos.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.utils.ImageUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoopMembersListAdapter extends AbstractItemRecycleViewAdapter {

    /* JADX INFO: renamed from: a */
    private Loop f10639a;

    /* JADX INFO: renamed from: b */
    private View.OnLongClickListener f10640b;

    /* JADX INFO: renamed from: c */
    private Account f10641c;

    /* JADX INFO: renamed from: a */
    public void m10819a(View.OnLongClickListener onLongClickListener) {
        this.f10640b = onLongClickListener;
    }

    public LoopMembersListAdapter(List<Items.Item> list, Loop loop, Account account) {
        super(list);
        this.f10641c = account;
        this.f10639a = loop;
    }

    @Override // com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter
    protected ViewHolders.AbstractViewHolder getViewHolderByItem(View view, Items.ItemType itemType) {
        switch (itemType) {
            case member:
                return new ViewHolders.LoopMemberViewHolder(view, this.f10641c);
            case attribution:
                return new ViewHolders.AttributionViewHolder(view);
            case date:
                return new ViewHolders.DateViewHolder(view);
            default:
                return super.getViewHolderByItem(view, itemType);
        }
    }

    @Override // com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter, android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i) {
        super.onBindViewHolder(abstractViewHolder, i);
        switch (Items.ItemType.values()[getItemViewType(i)]) {
            case member:
                if (!this.f10639a.getOwner().equals(((Items.MemberItem) this.mItems.get(i)).m11211b().getAccountId()) && LoopHelper.isOwner(this.f10639a, this.f10641c.getId())) {
                    abstractViewHolder.itemView.setOnLongClickListener(this.f10640b);
                    break;
                }
                break;
            case footer:
                ((ViewHolders.FooterViewHolder) abstractViewHolder).m11238a(ImageUtils.m11399b(abstractViewHolder.itemView.getContext(), R.color.steel));
                if (this.f10639a.getOwner().equals(this.f10641c.getId()) && !LoopHelper.doesLoopHavePlace(this.f10639a) && i == getItemCount() - 1) {
                    ((ViewHolders.FooterViewHolder) abstractViewHolder).m11238a(ImageUtils.m11399b(abstractViewHolder.itemView.getContext(), R.color.firecracker));
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10820a(Loop loop) {
        this.f10639a = loop;
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10643a;

        /* JADX INFO: renamed from: b */
        private int f10644b;

        /* JADX INFO: renamed from: c */
        private int f10645c;

        public SpacesItemDecoration(Context context, int i, int i2, int i3) {
            this.f10643a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
            this.f10644b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            this.f10645c = i3 != -1 ? context.getResources().getDimensionPixelOffset(i3) : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.findContainingViewHolder(view) instanceof ViewHolders.LoopMemberViewHolder) || (recyclerView.findContainingViewHolder(view) instanceof ViewHolders.SimpleViewHolder) || (recyclerView.findContainingViewHolder(view) instanceof ViewHolders.JiboSettingsViewHolder)) {
                rect.bottom = this.f10645c;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.f10643a;
            } else if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.f10644b;
            }
        }
    }
}
