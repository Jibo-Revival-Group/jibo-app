package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NamePronunciationFragment_ViewBinding implements Unbinder {
   private NamePronunciationFragment b;

   public NamePronunciationFragment_ViewBinding(NamePronunciationFragment var1, View var2) {
      this.b = var1;
      var1.mPhoneticNameView = Utils.b(var2, 2131296779, "field 'mPhoneticNameView'", EditText.class);
      var1.mPhoneticNameTip = Utils.b(var2, 2131296780, "field 'mPhoneticNameTip'", TextView.class);
      var1.mTitleView = Utils.b(var2, 2131297019, "field 'mTitleView'", TextView.class);
   }

   @Override
   public void unbind() {
      NamePronunciationFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mPhoneticNameView = null;
      var1.mPhoneticNameTip = null;
      var1.mTitleView = null;
   }
}
