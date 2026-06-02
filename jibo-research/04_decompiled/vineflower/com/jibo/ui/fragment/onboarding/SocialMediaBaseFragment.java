package com.jibo.ui.fragment.onboarding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;

public abstract class SocialMediaBaseFragment extends BaseFragment {
   private TextWatcher a = new TextWatcher(this) {
      final SocialMediaBaseFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.b();
      }
   };
   protected MenuItem b;
   AsyncHandler c = new AsyncHandler<AccountRequest, Account>(this) {
      final SocialMediaBaseFragment a;

      {
         this.a = var1;
      }

      public void a(AccountRequest var1, Account var2) {
         if (this.a.d()) {
            EntityData.a(this.a.getActivity()).a(var2, true, null);
            JiboAnalytics.a(this.a.getActivity(), var2);
            JiboAnalytics.a(this.a.getActivity(), var2.getEmail());
            if (var2.isActive()) {
               this.a.j();
            } else {
               this.a.a(new Runnable(this, var2) {
                  final Account a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.g();
                     ((OnBoardingActivity)this.b.a.getActivity()).b(this.a.getEmail(), null);
                  }
               });
            }
         }
      }

      @Override
      public void onError(Exception var1) {
         this.a.a(var1, "login", false);
         if (!ErrorHelper.a((AmazonServiceException)var1)) {
            this.a.a(new Runnable(this, var1) {
               final Exception a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  this.b.a.a(this.a);
                  this.b.a.b.setEnabled(true);
               }
            });
         }
      }
   };
   @BindView
   EditText emailEditText;
   @BindView
   EditText passwordEditText;

   protected abstract void a();

   protected void a(Exception var1) {
      UIUtils.a(this.getView(), var1);
   }

   protected void b() {
      boolean var2 = true;
      boolean var4 = this.emailEditText.getText().toString().trim().isEmpty();
      boolean var3 = Commons.a.matcher(this.emailEditText.getText().toString().trim()).matches();
      boolean var1;
      if (!TextUtils.isEmpty(this.passwordEditText.getText().toString()) && Commons.b.matcher(this.passwordEditText.getText().toString()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (this.b != null) {
         MenuItem var5 = this.b;
         if (var4 || !var3 || !var1) {
            var2 = false;
         }

         var5.setEnabled(var2);
      }
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492870, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296294);
      ImageUtils.a(this.getActivity(), var1);
      this.b();
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
   public void onResume() {
      super.onResume();
      this.g();
      this.getActivity().invalidateOptionsMenu();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.setHasOptionsMenu(true);
      this.emailEditText.addTextChangedListener(this.a);
      this.passwordEditText.addTextChangedListener(this.a);
   }
}
