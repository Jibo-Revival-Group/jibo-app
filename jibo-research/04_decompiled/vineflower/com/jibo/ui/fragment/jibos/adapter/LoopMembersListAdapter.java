package com.jibo.ui.fragment.jibos.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.utils.ImageUtils;
import java.util.List;

public class LoopMembersListAdapter extends AbstractItemRecycleViewAdapter {
   private Loop a;
   private OnLongClickListener b;
   private Account c;

   public LoopMembersListAdapter(List<Items.Item> var1, Loop var2, Account var3) {
      super(var1);
      this.c = var3;
      this.a = var2;
   }

   public void a(OnLongClickListener var1) {
      this.b = var1;
   }

   public void a(Loop var1) {
      this.a = var1;
   }

   @Override
   protected ViewHolders.AbstractViewHolder getViewHolderByItem(View var1, Items.ItemType var2) {
      ViewHolders.AbstractViewHolder var3;
      switch (<unrepresentable>.a[var2.ordinal()]) {
         case 1:
            var3 = new ViewHolders.LoopMemberViewHolder(var1, this.c);
            break;
         case 2:
            var3 = new ViewHolders.AttributionViewHolder(var1);
            break;
         case 3:
            var3 = new ViewHolders.DateViewHolder(var1);
            break;
         default:
            var3 = super.getViewHolderByItem(var1, var2);
      }

      return var3;
   }

   @Override
   public void onBindViewHolder(ViewHolders.AbstractViewHolder var1, int var2) {
      super.onBindViewHolder(var1, var2);
      Items.ItemType var3 = Items.ItemType.values()[this.getItemViewType(var2)];
      switch (<unrepresentable>.a[var3.ordinal()]) {
         case 1:
            if (!this.a.getOwner().equals(((Items.MemberItem)this.mItems.get(var2)).b().getAccountId()) && LoopHelper.isOwner(this.a, this.c.getId())) {
               var1.itemView.setOnLongClickListener(this.b);
            }
         case 2:
         case 3:
         default:
            break;
         case 4:
            ((ViewHolders.FooterViewHolder)var1).a(ImageUtils.b(var1.itemView.getContext(), 2131099846));
            if (this.a.getOwner().equals(this.c.getId()) && !LoopHelper.doesLoopHavePlace(this.a) && var2 == this.getItemCount() - 1) {
               ((ViewHolders.FooterViewHolder)var1).a(ImageUtils.b(var1.itemView.getContext(), 2131099764));
            }
      }
   }

   public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
      private int a;
      private int b;
      private int c;

      public SpacesItemDecoration(Context var1, int var2, int var3, int var4) {
         byte var5 = 0;
         super();
         if (var2 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var2);
         } else {
            var2 = 0;
         }

         this.a = var2;
         if (var3 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var3);
         } else {
            var2 = 0;
         }

         this.b = var2;
         var2 = var5;
         if (var4 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var4);
         }

         this.c = var2;
      }

      @Override
      public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         if (var3.findContainingViewHolder(var2) instanceof ViewHolders.LoopMemberViewHolder
            || var3.findContainingViewHolder(var2) instanceof ViewHolders.SimpleViewHolder
            || var3.findContainingViewHolder(var2) instanceof ViewHolders.JiboSettingsViewHolder) {
            var1.bottom = this.c;
         }

         if (var3.getChildAdapterPosition(var2) == 0) {
            var1.top = this.a;
         } else if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
            var1.bottom = this.b;
         }
      }
   }
}
