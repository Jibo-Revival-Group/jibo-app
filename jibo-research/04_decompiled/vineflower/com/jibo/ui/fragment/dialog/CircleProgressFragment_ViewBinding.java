package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class CircleProgressFragment_ViewBinding implements Unbinder {
   private CircleProgressFragment b;

   public CircleProgressFragment_ViewBinding(CircleProgressFragment var1, View var2) {
      this.b = var1;
      var1.mProgressCircle = Utils.b(var2, 2131296806, "field 'mProgressCircle'", ImageView.class);
      var1.mProgressSuccess = Utils.b(var2, 2131296808, "field 'mProgressSuccess'", ImageView.class);
      var1.mProgressFailure = Utils.b(var2, 2131296807, "field 'mProgressFailure'", ImageView.class);
      var1.mProgressStatusText = Utils.b(var2, 2131296814, "field 'mProgressStatusText'", TextView.class);
   }

   @Override
   public void unbind() {
      CircleProgressFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mProgressCircle = null;
      var1.mProgressSuccess = null;
      var1.mProgressFailure = null;
      var1.mProgressStatusText = null;
   }
}
