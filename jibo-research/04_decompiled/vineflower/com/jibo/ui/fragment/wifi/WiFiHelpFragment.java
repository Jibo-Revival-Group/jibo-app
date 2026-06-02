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

public class WiFiHelpFragment extends WiFiHelpAbstractFragment {
   public static final String a = LogUtils.a(WiFiHelpFragment.class);

   @OnClick
   public void btnWiFiError1Click(View var1) {
      ((BaseActivity)this.getActivity()).c(WiFiError1Fragment.class, null);
   }

   @OnClick
   public void btnWiFiError2Click(View var1) {
      ((BaseActivity)this.getActivity()).c(WiFiError2Fragment.class, null);
   }

   @OnClick
   public void btnWiFiError3Click(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755747))));
   }

   @OnClick
   public void btnWiFiError4Click(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755750))));
   }

   @Override
   protected String o() {
      return this.getString(2131756078);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427481, var2, false);
   }
}
