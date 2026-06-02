package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.JiboSupport;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

public class WaitForTapFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(WaitForTapFragment.class);

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131230814);
   }

   @OnClick
   public void btnJiboOkClick(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).a(WiFiTokenGetterFragment.class, var2);
   }

   @OnClick
   public void btnNoScreenClick(View var1) {
      JiboSupport.a(this.getActivity());
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427493, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.m();
   }
}
