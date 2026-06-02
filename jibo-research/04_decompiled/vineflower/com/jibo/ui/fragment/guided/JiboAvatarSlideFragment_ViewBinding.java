package com.jibo.ui.fragment.guided;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;

public class JiboAvatarSlideFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {
   private JiboAvatarSlideFragment b;

   public JiboAvatarSlideFragment_ViewBinding(JiboAvatarSlideFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.txtInfo = Utils.b(var2, 2131297038, "field 'txtInfo'", TextView.class);
   }

   @Override
   public void unbind() {
      JiboAvatarSlideFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
      var1.txtInfo = null;
      super.unbind();
   }
}
