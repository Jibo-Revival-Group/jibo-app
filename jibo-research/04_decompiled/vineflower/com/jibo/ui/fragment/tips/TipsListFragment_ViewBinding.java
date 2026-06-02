package com.jibo.ui.fragment.tips;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsListFragment_ViewBinding implements Unbinder {
   private TipsListFragment b;

   public TipsListFragment_ViewBinding(TipsListFragment var1, View var2) {
      this.b = var1;
      var1.tip0 = Utils.a(var2, 2131297006, "field 'tip0'");
      var1.tip1 = Utils.a(var2, 2131297007, "field 'tip1'");
      var1.tip2 = Utils.a(var2, 2131297008, "field 'tip2'");
      var1.tip3 = Utils.a(var2, 2131297009, "field 'tip3'");
      var1.tip4 = Utils.a(var2, 2131297010, "field 'tip4'");
      var1.tip5 = Utils.a(var2, 2131297011, "field 'tip5'");
   }

   @Override
   public void unbind() {
      TipsListFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.tip0 = null;
      var1.tip1 = null;
      var1.tip2 = null;
      var1.tip3 = null;
      var1.tip4 = null;
      var1.tip5 = null;
   }
}
