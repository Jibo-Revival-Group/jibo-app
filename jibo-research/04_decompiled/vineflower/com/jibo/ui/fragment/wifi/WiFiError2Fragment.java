package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

public class WiFiError2Fragment extends WiFiHelpAbstractFragment {
   public static final String a = LogUtils.a(WiFiError2Fragment.class);

   @OnClick
   public void btnMacFilteringClick(View var1) {
      ((BaseActivity)this.getActivity()).c(MacAddressFragment.class, null);
   }

   @OnClick
   public void btnSetupStaticClick(View var1) {
      ((BaseActivity)this.getActivity()).c(NetworkPwdFragment.class, null);
   }

   @OnClick
   public void btnSupportClick(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755749))));
   }

   @Override
   protected String o() {
      return this.getString(2131756077);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427480, var2, false);
   }
}
