package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

public class WiFiTokenGetterFragment extends WiFiBaseQRCodeFragment {
   public static final String p = LogUtils.a(WiFiTokenGetterFragment.class);

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onBtnContinueClick(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      var2.putSerializable(TokenContainer.class.getSimpleName(), this.n);
      ((BaseActivity)this.getActivity()).c(WiFiQRCodeFragment.class, var2);
   }

   @OnClick
   @Override
   public void onBtnHelpClick(View var1) {
      ((BaseActivity)this.getActivity()).c(WiFiHelpFragment.class, null);
   }

   @OnClick
   public void onCloseClick(View var1) {
      this.h();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427490, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      var1.setVisibility(4);
   }

   @Override
   protected void s() {
      if (this.d()) {
         this.r();
         if (this.m.size() > 1) {
            this.getView().setVisibility(0);
         } else {
            Bundle var1 = new Bundle();
            var1.putParcelable(Loop.class.getSimpleName(), this.k);
            var1.putSerializable(TokenContainer.class.getSimpleName(), this.n);
            ((BaseActivity)this.getActivity()).a(WiFiQRCodeFragment.class, var1);
         }
      }
   }
}
