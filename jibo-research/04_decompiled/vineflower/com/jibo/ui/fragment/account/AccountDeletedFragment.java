package com.jibo.ui.fragment.account;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.JiboAnalytics;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;

public class AccountDeletedFragment extends BaseFragment {
   public static final String a = AccountDeletedFragment.class.getSimpleName();
   @BindView
   ImageView closeButton;

   @Override
   protected void a(ActionBar var1) {
   }

   @Override
   public boolean h() {
      this.onCloseButtonClick();
      return true;
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onCloseButtonClick() {
      this.getActivity().setResult(TabbedActivity.c);
      this.getActivity().finish();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.k();
      return var1.inflate(2131427421, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.closeButton.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099771));
      String var3;
      if (this.getArguments() != null) {
         var3 = this.getArguments().getString(JiboAnalytics.ak, "");
      } else {
         var3 = "";
      }

      if (!var3.equals(JiboAnalytics.aG) && var3.equals(JiboAnalytics.aF)) {
      }
   }
}
