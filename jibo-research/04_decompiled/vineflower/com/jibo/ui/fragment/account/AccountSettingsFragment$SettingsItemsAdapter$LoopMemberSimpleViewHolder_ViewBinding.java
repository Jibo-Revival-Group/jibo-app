package com.jibo.ui.fragment.account;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.RoundedImageView;

public class AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding implements Unbinder {
   private AccountSettingsFragment.SettingsItemsAdapter.LoopMemberSimpleViewHolder b;

   public AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding(
      AccountSettingsFragment.SettingsItemsAdapter.LoopMemberSimpleViewHolder var1, View var2
   ) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", RoundedImageView.class);
      var1.name = Utils.b(var2, 16908308, "field 'name'", TextView.class);
      var1.nickName = Utils.b(var2, 16908309, "field 'nickName'", TextView.class);
   }

   @Override
   public void unbind() {
      AccountSettingsFragment.SettingsItemsAdapter.LoopMemberSimpleViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
      var1.name = null;
      var1.nickName = null;
   }
}
