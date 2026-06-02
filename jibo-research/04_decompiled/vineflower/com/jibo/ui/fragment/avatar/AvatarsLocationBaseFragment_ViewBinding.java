package com.jibo.ui.fragment.avatar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.settings.LocationFragment_ViewBinding;

public class AvatarsLocationBaseFragment_ViewBinding extends LocationFragment_ViewBinding {
   private AvatarsLocationBaseFragment b;

   public AvatarsLocationBaseFragment_ViewBinding(AvatarsLocationBaseFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.list = Utils.a(var2, 16908298, "field 'list'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      AvatarsLocationBaseFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
      super.unbind();
   }
}
