package com.jibo.ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;

public class ResetPasswordNewPasswordFragment extends BaseFragment {
   public static final String a = ResetPasswordNewPasswordFragment.class.getSimpleName();
   private String b;
   private MenuItem c;
   @BindView
   TextView footer;
   @BindView
   EditText passwordEdit;

   private void a() {
      try {
         this.c.setEnabled(false);
         this.e();
         String var1 = this.passwordEdit.getText().toString();
         this.f();
         ((JiboApplication)this.getActivity().getApplication()).b();
         JiboAccountAsyncClient var2 = EntityData.a(this.getActivity()).a();
         String var3 = this.b;
         AsyncHandler var4 = new AsyncHandler<PasswordResetByCodeRequest, Account>(this) {
            final ResetPasswordNewPasswordFragment a;

            {
               this.a = var1;
            }

            public void a(PasswordResetByCodeRequest var1, Account var2x) {
               if (this.a.d()) {
                  EntityData.a(this.a.getActivity()).a(var2x, true, null);
               }

               this.a.j();
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "password reset by code", true);
               if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                  this.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.a.c.setEnabled(true);
                     }
                  });
               }
            }
         };
         var2.passwordResetByCode(var3, var1, var4);
      } catch (Exception var5) {
         this.g();
         this.c.setEnabled(true);
         Crashlytics.a(var5);
         ((OnBoardingActivity)this.getActivity()).l();
      }
   }

   private void b(boolean var1) {
      String var2 = this.getString(2131755171);
      String var3 = var2 + "\n\n" + this.getString(2131755172);
      SpannableStringBuilder var4 = new SpannableStringBuilder(var3);
      if (!var1) {
         var4.setSpan(new ForegroundColorSpan(this.getResources().getColor(2131099764)), var2.length(), var3.length(), 33);
      }

      this.footer.setText(var4);
   }

   private boolean b() {
      boolean var1;
      if (!TextUtils.isEmpty(this.passwordEdit.getText().toString()) && Commons.b.matcher(this.passwordEdit.getText().toString()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.l();
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setHomeAsUpIndicator(2131231362);
   }

   @Override
   protected String o() {
      return this.getString(2131756057);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492871, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.c = var1.findItem(2131296304);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427462, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296304 == var1.getItemId()) {
         this.a();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      boolean var2;
      if (!TextUtils.isEmpty(this.passwordEdit.getText().toString()) && Commons.b.matcher(this.passwordEdit.getText().toString()).matches()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.c.setEnabled(var2);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.g();
      this.getActivity().invalidateOptionsMenu();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      String var3;
      if (this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("code"))) {
         var3 = this.getArguments().getString("code");
      } else {
         var3 = "";
      }

      this.b = var3;
      this.setHasOptionsMenu(true);
      this.passwordEdit.addTextChangedListener(new TextWatcher(this) {
         final ResetPasswordNewPasswordFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3x, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3x, int var4) {
            this.a.getActivity().invalidateOptionsMenu();
            this.a.b(this.a.b());
         }
      });
      this.b(true);
   }
}
