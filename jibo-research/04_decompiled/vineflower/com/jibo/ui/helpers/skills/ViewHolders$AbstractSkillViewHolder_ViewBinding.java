package com.jibo.ui.helpers.skills;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$AbstractSkillViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.AbstractSkillViewHolder target;

   public ViewHolders$AbstractSkillViewHolder_ViewBinding(ViewHolders.AbstractSkillViewHolder var1, View var2) {
      this.target = var1;
      var1.title = Utils.a(var2, 16908308, "field 'title'", TextView.class);
      var1.subtitle = Utils.a(var2, 16908309, "field 'subtitle'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.AbstractSkillViewHolder var1 = this.target;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.target = null;
      var1.title = null;
      var1.subtitle = null;
   }
}
