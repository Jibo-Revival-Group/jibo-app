package com.jibo.ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;

public class ResetPasswordFragment extends BaseFragment {
   public static final String a = ResetPasswordFragment.class.getSimpleName();
   private MenuItem b;
   @BindView
   EditText emailEditText;

   public void a() {
      try {
         this.b.setEnabled(false);
         this.e();
         String var3 = this.emailEditText.getText().toString();
         this.f();
         JiboAccountAsyncClient var1 = EntityData.a(this.getActivity()).a();
         AsyncHandler var2 = new AsyncHandler<SendPasswordResetRequest, Account>(this) {
            final ResetPasswordFragment a;

            {
               this.a = var1;
            }

            public void a(SendPasswordResetRequest var1, Account var2x) {
               this.a.a(new Runnable(this, var2x) {
                  final Account a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.b.setEnabled(true);
                     this.b.a.g();
                     ((OnBoardingActivity)this.b.a.getActivity()).c(this.a.getEmail(), "");
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "send password reset", true);
               if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                  this.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.a.b.setEnabled(true);
                     }
                  });
               }
            }
         };
         var1.sendPasswordReset(var3, var2);
      } catch (Exception var4) {
         this.g();
         this.b.setEnabled(true);
         this.g();
         Crashlytics.a(var4);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.l();
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(2131756068);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492870, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296294);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427461, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
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
      boolean var2 = this.emailEditText.getText().toString().trim().isEmpty();
      boolean var3 = Commons.a.matcher(this.emailEditText.getText().toString().trim()).matches();
      MenuItem var4 = this.b;
      if (!var2 && var3) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4.setEnabled(var2);
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
      this.setHasOptionsMenu(true);
      this.emailEditText.setText(this.getArguments().getString("email", ""));
      this.emailEditText.addTextChangedListener(new TextWatcher(this) {
         final ResetPasswordFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
            this.a.getActivity().invalidateOptionsMenu();
         }
      });
   }
}
