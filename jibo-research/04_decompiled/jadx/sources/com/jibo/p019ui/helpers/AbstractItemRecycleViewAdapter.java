package com.jibo.p019ui.helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractItemRecycleViewAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {
    protected List<Items.Item> mItems;

    public AbstractItemRecycleViewAdapter(List<Items.Item> list) {
        this.mItems = new ArrayList();
        this.mItems = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolders.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Items.ItemType itemType = Items.ItemType.values()[i];
        return getViewHolderByItem(LayoutInflater.from(viewGroup.getContext()).inflate(itemType.getLayoutId(), viewGroup, false), itemType);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i) {
        abstractViewHolder.setData(this.mItems.get(i));
    }

    protected ViewHolders.AbstractViewHolder getViewHolderByItem(View view, Items.ItemType itemType) {
        switch (itemType) {
            case jiboheader:
                return new ViewHolders.JiboHeaderViewHolder(view);
            case subheader:
                return new ViewHolders.SubheaderViewHolder(view);
            case header_with_button:
                return new ViewHolders.HeaderButtonViewHolder(view);
            case settings:
                return new ViewHolders.JiboSettingsViewHolder(view);
            case searchRecap:
            case text_button:
            case text_button_small:
            case text_button_small_red:
            case text_bold_single_row:
            case text_greyed_row:
                return new ViewHolders.SimpleViewHolder(view);
            case invite:
                return new ViewHolders.InviteMemberViewHolder(view);
            case wifisettings:
                return new ViewHolders.WifiSettingsViewHolder(view);
            case switch_row:
                return new ViewHolders.SwitchStateViewHolder(view);
            case footer:
                return new ViewHolders.FooterViewHolder(view);
            case text_double_row:
            case text_double_greyed_row:
                return new ViewHolders.TwoRowsSimpleViewHolder(view);
            case text_avatar_double_row:
                return new ViewHolders.AvatarTwoRowsSimpleViewHolder(view);
            case text_avatar_radio_double_row:
                return new ViewHolders.AvatarRadioTwoRowsSimpleViewHolder(view);
            default:
                return null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mItems.get(i).getItemType().ordinal();
    }

    public static class SimpleImplItemRecycleViewAdapter extends AbstractItemRecycleViewAdapter {
        @Override // com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter, android.support.v7.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            super.onBindViewHolder((ViewHolders.AbstractViewHolder) viewHolder, i);
        }

        @Override // com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter, android.support.v7.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return super.onCreateViewHolder(viewGroup, i);
        }

        public SimpleImplItemRecycleViewAdapter(List<Items.Item> list) {
            super(list);
        }
    }
}
