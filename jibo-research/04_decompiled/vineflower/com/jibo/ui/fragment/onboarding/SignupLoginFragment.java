package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;

public class SignupLoginFragment extends BaseFragment {
   public static final String a = SignupLoginFragment.class.getSimpleName();
   @BindView
   View btnLearnMore;
   @BindView
   Button btnLogin;
   @BindView
   Button btnSignUp;

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
      var1.setDisplayHomeAsUpEnabled(false);
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427471, var2, false);
   }

   @OnLongClick
   public boolean onDevSettings(View var1) {
      return true;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
   }

   @OnClick
   public void openLearnMoreLink(View var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(Uri.parse("http://www.jibo.com"));
      this.startActivity(var2);
   }

   @OnClick
   public void openLoginScreen(View var1) {
      ((OnBoardingActivity)this.getActivity()).a(null);
   }

   @OnClick
   public void openSignupScreen(View var1) {
      ((OnBoardingActivity)this.getActivity()).a((String)null, (String)null);
   }
}
