package com.jibo.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AvatarBaseFragment_ViewBinding implements Unbinder {
   private AvatarBaseFragment b;
   private View c;

   public AvatarBaseFragment_ViewBinding(AvatarBaseFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 2131296330, "field 'avatar' and method 'onAvatarClick'");
      var1.avatar = Utils.c(var3, 2131296330, "field 'avatar'", ImageView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AvatarBaseFragment b;
         final AvatarBaseFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onAvatarClick(var1);
         }
      });
      var1.photoProgressBar = Utils.b(var2, 2131296783, "field 'photoProgressBar'", ProgressBar.class);
   }

   @Override
   public void unbind() {
      AvatarBaseFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
      var1.photoProgressBar = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
