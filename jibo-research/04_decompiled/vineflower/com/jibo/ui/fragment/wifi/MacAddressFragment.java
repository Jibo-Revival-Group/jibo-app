package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.utils.LogUtils;

public class MacAddressFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(MacAddressFragment.class);

   @OnClick
   public void btnRestartSetup(View var1) {
      this.getActivity().getSupportFragmentManager().a(NetworkSelectionFragment.a, 0);
   }

   @Override
   protected String o() {
      return this.getString(2131756050);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427492, var2, false);
   }
}
