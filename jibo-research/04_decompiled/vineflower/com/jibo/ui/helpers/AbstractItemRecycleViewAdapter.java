package com.jibo.ui.helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItemRecycleViewAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {
   protected List<Items.Item> mItems = new ArrayList<>();

   public AbstractItemRecycleViewAdapter(List<Items.Item> var1) {
      this.mItems = var1;
   }

   @Override
   public int getItemCount() {
      return this.mItems.size();
   }

   @Override
   public int getItemViewType(int var1) {
      return this.mItems.get(var1).getItemType().ordinal();
   }

   protected ViewHolders.AbstractViewHolder getViewHolderByItem(View var1, Items.ItemType var2) {
      ViewHolders.AbstractViewHolder var3;
      switch (<unrepresentable>.a[var2.ordinal()]) {
         case 1:
            var3 = new ViewHolders.JiboHeaderViewHolder(var1);
            break;
         case 2:
            var3 = new ViewHolders.SubheaderViewHolder(var1);
            break;
         case 3:
            var3 = new ViewHolders.HeaderButtonViewHolder(var1);
            break;
         case 4:
            var3 = new ViewHolders.JiboSettingsViewHolder(var1);
            break;
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
            var3 = new ViewHolders.SimpleViewHolder(var1);
            break;
         case 11:
            var3 = new ViewHolders.InviteMemberViewHolder(var1);
            break;
         case 12:
            var3 = new ViewHolders.WifiSettingsViewHolder(var1);
            break;
         case 13:
            var3 = new ViewHolders.SwitchStateViewHolder(var1);
            break;
         case 14:
            var3 = new ViewHolders.FooterViewHolder(var1);
            break;
         case 15:
         case 16:
            var3 = new ViewHolders.TwoRowsSimpleViewHolder(var1);
            break;
         case 17:
            var3 = new ViewHolders.AvatarTwoRowsSimpleViewHolder(var1);
            break;
         case 18:
            var3 = new ViewHolders.AvatarRadioTwoRowsSimpleViewHolder(var1);
            break;
         default:
            var3 = null;
      }

      return var3;
   }

   public void onBindViewHolder(ViewHolders.AbstractViewHolder var1, int var2) {
      var1.setData(this.mItems.get(var2));
   }

   public ViewHolders.AbstractViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Items.ItemType var3 = Items.ItemType.values()[var2];
      return this.getViewHolderByItem(LayoutInflater.from(var1.getContext()).inflate(var3.getLayoutId(), var1, false), var3);
   }

   public static class SimpleImplItemRecycleViewAdapter extends AbstractItemRecycleViewAdapter {
      public SimpleImplItemRecycleViewAdapter(List<Items.Item> var1) {
         super(var1);
      }
   }
}
