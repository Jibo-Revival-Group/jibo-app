package com.jibo.ui.fragment.wifi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;

public class SetupOrReconnectFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private SetupOrReconnectFragment b;

   public SetupOrReconnectFragment_ViewBinding(SetupOrReconnectFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      SetupOrReconnectFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
      super.unbind();
   }
}
