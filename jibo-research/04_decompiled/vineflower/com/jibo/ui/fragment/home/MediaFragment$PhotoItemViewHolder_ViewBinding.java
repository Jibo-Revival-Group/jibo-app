package com.jibo.ui.fragment.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MediaFragment$PhotoItemViewHolder_ViewBinding implements Unbinder {
   private MediaFragment.PhotoItemViewHolder b;

   public MediaFragment$PhotoItemViewHolder_ViewBinding(MediaFragment.PhotoItemViewHolder var1, View var2) {
      this.b = var1;
      var1.photo = Utils.b(var2, 2131296781, "field 'photo'", ImageView.class);
      var1.checkbox = Utils.a(var2, 2131296451, "field 'checkbox'", TextView.class);
   }

   @Override
   public void unbind() {
      MediaFragment.PhotoItemViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.photo = null;
      var1.checkbox = null;
   }
}
