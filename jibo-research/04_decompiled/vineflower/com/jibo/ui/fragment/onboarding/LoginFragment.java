package com.jibo.ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.utils.Commons;

public class LoginFragment extends SocialMediaBaseFragment implements DialogUtils.DialogFragmentWrapperClickListener {
   public static final String a = LoginFragment.class.getSimpleName();
   @BindView
   TextView validationMessagePassword;

   @Override
   protected void a() {
      try {
         this.b.setEnabled(false);
         this.e();
         String var1 = this.emailEditText.getText().toString();
         String var2 = this.passwordEditText.getText().toString();
         this.f();
         ((JiboApplication)this.getActivity().getApplication()).b();
         EntityData.a(this.getActivity()).a().login(var1, var2, this.c);
      } catch (Exception var3) {
         this.g();
         this.b.setEnabled(true);
         ((OnBoardingActivity)this.getActivity()).l();
         Crashlytics.a(var3);
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var2 == -1) {
         ((OnBoardingActivity)this.getActivity()).a(this.emailEditText.getText().toString(), null);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.l();
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected void a(Exception var1) {
      if (var1 instanceof UnauthorizedRequestException) {
         this.validationMessagePassword.setVisibility(0);
      } else if (var1 instanceof ResourceNotFoundException) {
         DialogUtils.a(
            this,
            this.getFragmentManager(),
            103,
            this.getString(2131755045),
            this.getString(2131755044),
            this.getString(2131755043),
            this.getString(2131755042)
         );
      } else {
         super.a(var1);
      }
   }

   @Override
   protected void b() {
      this.validationMessagePassword.setVisibility(8);
      boolean var1;
      if (!this.emailEditText.getText().toString().trim().isEmpty()
         && Commons.a.matcher(this.emailEditText.getText().toString().trim()).matches()
         && !this.passwordEditText.getText().toString().trim().isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (this.b != null) {
         this.b.setEnabled(var1);
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756041);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427446, var2, false);
   }

   @OnClick
   public void onForgotPasswordClick(View var1) {
      ((OnBoardingActivity)this.getActivity()).b(this.emailEditText.getText().toString());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (var2 == null && this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("email"))) {
         this.emailEditText.setText(this.getArguments().getString("email"));
      }
   }
}
