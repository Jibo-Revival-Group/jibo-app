package com.jibo.ui.fragment.invite;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LoopMembersFragment_ViewBinding implements Unbinder {
   private LoopMembersFragment b;

   public LoopMembersFragment_ViewBinding(LoopMembersFragment var1, View var2) {
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      LoopMembersFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
   }
}
