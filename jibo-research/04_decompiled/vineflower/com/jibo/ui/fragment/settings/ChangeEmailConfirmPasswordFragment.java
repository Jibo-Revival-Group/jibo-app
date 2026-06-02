package com.jibo.ui.fragment.settings;

import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.utils.LogUtils;

public class ChangeEmailConfirmPasswordFragment extends ConfirmPasswordFragment {
   public static final String a = LogUtils.a(ChangeEmailConfirmPasswordFragment.class);

   @Override
   protected void a() {
      SingleFragmentActivity.Builder var1 = new SingleFragmentActivity.Builder(this, ChangeEmailFragment.class.getName());
      var1.a("ARGS_PASSWORD", this.password.getText().toString());
      var1.a(999);
   }

   @Override
   protected int b() {
      return 2131427426;
   }

   @Override
   protected String o() {
      return this.getString(2131756028);
   }
}
