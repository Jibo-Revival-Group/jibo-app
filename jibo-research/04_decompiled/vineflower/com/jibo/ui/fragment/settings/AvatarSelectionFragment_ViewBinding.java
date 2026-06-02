package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;

public class AvatarSelectionFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {
   private AvatarSelectionFragment b;

   public AvatarSelectionFragment_ViewBinding(AvatarSelectionFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.jiboAvatar = Utils.b(var2, 2131296618, "field 'jiboAvatar'", ImageView.class);
   }

   @Override
   public void unbind() {
      AvatarSelectionFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.jiboAvatar = null;
      super.unbind();
   }
}
