package com.jibo.ui.helpers.skills;

import android.view.View;
import com.jibo.ui.helpers.AbstractItemRecycleViewAdapter;
import java.util.List;

public class SkillBasedRecycleViewAdapter extends AbstractItemRecycleViewAdapter {
   private boolean mIsOwner;

   public SkillBasedRecycleViewAdapter(List<com.jibo.ui.helpers.Items.Item> var1, boolean var2) {
      super(var1);
      this.mIsOwner = var2;
   }

   @Override
   protected com.jibo.ui.helpers.ViewHolders.AbstractViewHolder getViewHolderByItem(View var1, com.jibo.ui.helpers.Items.ItemType var2) {
      com.jibo.ui.helpers.ViewHolders.AbstractViewHolder var3;
      switch (<unrepresentable>.$SwitchMap$com$jibo$ui$helpers$Items$ItemType[var2.ordinal()]) {
         case 1:
            var3 = new ViewHolders.SkillViewHolder(var1, this.mIsOwner);
            break;
         case 2:
            var3 = new ViewHolders.FooterViewHolder(var1, this.mIsOwner);
            break;
         case 3:
            var3 = new ViewHolders.SwitchViewHolder(var1, this.mIsOwner);
            break;
         case 4:
            var3 = new ViewHolders.ToggleViewHolder(var1, this.mIsOwner);
            break;
         case 5:
            var3 = new ViewHolders.LocationViewHolder(var1, true);
            break;
         case 6:
            var3 = new ViewHolders.ChoiceViewHolder(var1, this.mIsOwner);
            break;
         case 7:
            var3 = new ViewHolders.TimeViewHolder(var1, this.mIsOwner);
            break;
         case 8:
            var3 = new ViewHolders.ConnectableViewHolder(var1, this.mIsOwner);
            break;
         case 9:
            var3 = new ViewHolders.OauthViewHolder(var1, this.mIsOwner);
            break;
         default:
            var3 = super.getViewHolderByItem(var1, var2);
      }

      return var3;
   }
}
