package com.jibo.ui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class BottomPanelButton_ViewBinding implements Unbinder {
   private BottomPanelButton b;

   public BottomPanelButton_ViewBinding(BottomPanelButton var1) {
      this(var1, var1);
   }

   public BottomPanelButton_ViewBinding(BottomPanelButton var1, View var2) {
      this.b = var1;
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.icon = Utils.b(var2, 16908294, "field 'icon'", ImageView.class);
      var1.badge = Utils.b(var2, 16908309, "field 'badge'", TextView.class);
   }

   @Override
   public void unbind() {
      BottomPanelButton var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text = null;
      var1.icon = null;
      var1.badge = null;
   }
}
