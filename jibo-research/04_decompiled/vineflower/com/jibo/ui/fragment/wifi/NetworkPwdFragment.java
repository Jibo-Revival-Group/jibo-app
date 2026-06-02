package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

public class NetworkPwdFragment extends WiFiValidatedFragment implements StaticOptionsDialogFragment.OnStaticOptionsChangeListener {
   public static final String a = LogUtils.a(NetworkPwdFragment.class);
   final TextWatcher b = new TextWatcher(this) {
      final NetworkPwdFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
         this.a.q();
         this.a.getActivity().invalidateOptionsMenu();
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }
   };
   @BindView
   TextView btnStaticOptions;
   @BindView
   EditText editPassword;
   @BindView
   TextView txtPasswordHint;

   private void q() {
      if (!this.r().isEmpty() && this.r().length() < 8) {
         this.txtPasswordHint.setText(2131755311);
         this.txtPasswordHint.setTextColor(ImageUtils.b(this.getActivity(), 2131099764));
      } else {
         this.txtPasswordHint.setText(2131755481);
         this.txtPasswordHint.setTextColor(ImageUtils.b(this.getActivity(), 2131099846));
      }
   }

   private String r() {
      String var2 = "";
      String var1 = var2;

      try {
         if (this.editPassword != null) {
            var1 = this.editPassword.getText().toString().trim();
         }
      } catch (Exception var3) {
         var1 = var2;
      }

      return var1;
   }

   @Override
   protected void a() {
      this.e();
      e.putString("ARG_PASSWORD", this.r());
      if (this.getActivity().getSupportFragmentManager().e() > 4) {
         this.getActivity().getSupportFragmentManager().a(WiFiHelpFragment.class.getSimpleName(), 1);
      } else {
         Bundle var1 = new Bundle();
         var1.putParcelable(Loop.class.getSimpleName(), this.k);
         ((BaseActivity)this.getActivity()).c(WaitForTapFragment.class, var1);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131230814);
   }

   @Override
   protected void a(MenuItem var1) {
      boolean var3;
      if (this.r().length() < 8 && this.r().length() != 0) {
         var3 = false;
      } else {
         var3 = true;
      }

      var1.setEnabled(var3);
      FragmentActivity var4 = this.getActivity();
      int var2;
      if (var1.isEnabled()) {
         var2 = 2131099871;
      } else {
         var2 = 2131099701;
      }

      ImageUtils.a(var4, var1, var2);
   }

   @Override
   public void a(String var1, String var2, String var3, String var4, String var5) {
      e.putString("ARG_IPADDRESS", var1);
      e.putString("ARG_SUBNETMASK", var2);
      e.putString("ARG_ROUTER", var3);
      e.putString("ARG_DNS1", var4);
      e.putString("ARG_DNS2", var5);
      TextView var7 = this.btnStaticOptions;
      int var6;
      if (e.getString("ARG_IPADDRESS", null) == null) {
         var6 = 2131755080;
      } else {
         var6 = 2131755079;
      }

      var7.setText(var6);
   }

   @Override
   public boolean h() {
      if (this.getActivity().getSupportFragmentManager().e() <= 3) {
         e.remove("ARG_IPADDRESS");
         e.remove("ARG_SUBNETMASK");
         e.remove("ARG_ROUTER");
         e.remove("ARG_DNS1");
         e.remove("ARG_DNS2");
      }

      return super.h();
   }

   @Override
   protected String o() {
      return this.getString(2131756075);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427486, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.editPassword.removeTextChangedListener(this.b);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.editPassword.setHint(e.getString("ARG_SSID") + this.getString(2131755369));
      TextView var2 = this.btnStaticOptions;
      int var1;
      if (e.getString("ARG_IPADDRESS", null) == null) {
         var1 = 2131755080;
      } else {
         var1 = 2131755079;
      }

      var2.setText(var1);
      this.q();
      this.editPassword.addTextChangedListener(this.b);
      if (this.getActivity().getSupportFragmentManager().e() > 4) {
         this.onStaticClick(null);
      } else {
         this.editPassword.requestFocus();
         this.a(this.editPassword);
      }
   }

   @OnClick
   public void onStaticClick(View var1) {
      Bundle var2 = new Bundle();
      var2.putAll(e);
      StaticOptionsDialogFragment var3 = new StaticOptionsDialogFragment();
      var3.setArguments(var2);
      var3.setTargetFragment(this, 0);
      var3.show(this.getActivity().getSupportFragmentManager(), StaticOptionsDialogFragment.class.getSimpleName());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.n();
   }
}
