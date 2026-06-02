package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.utils.LogUtils;

public class WiFiJiboConnectingFragment extends WiFiBaseQRCodeFragment {
   public static final String p = LogUtils.a(WiFiJiboConnectingFragment.class);

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
   }

   @Override
   public boolean h() {
      this.getActivity().getSupportFragmentManager().a(WiFiQRCodeFragment.class.getSimpleName(), 1);
      return true;
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onBtnEditWifiClick(View var1) {
      this.getActivity().getSupportFragmentManager().a(WaitForTapFragment.class.getSimpleName(), 1);
   }

   @OnClick
   public void onBtnNoScreenClick(View var1) {
      this.h();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427483, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.q();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
   }

   @Override
   protected void s() {
   }
}
