package com.jibo.ui.fragment.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

public class ConfirmPasswordFragment extends BaseFragment {
   public static final String b = LogUtils.a(ConfirmPasswordFragment.class);
   private JiboAccountAsyncClient a;
   MenuItem c;
   private TextWatcher d = new TextWatcher(this) {
      final ConfirmPasswordFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.getActivity().invalidateOptionsMenu();
         this.a.t();
      }
   };
   @BindView
   TextView footer;
   @BindView
   TextView footerError;
   @BindView
   EditText password;

   private boolean r() {
      boolean var1;
      if (!TextUtils.isEmpty(this.password.getText().toString()) && Commons.b.matcher(this.password.getText().toString()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void s() {
      this.footer.setVisibility(8);
      this.footerError.setVisibility(0);
   }

   private void t() {
      this.footer.setVisibility(0);
      this.footerError.setVisibility(8);
   }

   protected void a() {
      SingleFragmentActivity.Builder var1 = new SingleFragmentActivity.Builder(this, ChangePasswordFragment.class.getName());
      var1.a("ARGS_OLD_PASSWORD", this.password.getText().toString());
      var1.a(999);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowTitleEnabled(true);
      var1.setDisplayShowCustomEnabled(false);
      this.n();
   }

   protected int b() {
      return 2131427429;
   }

   @Override
   protected String o() {
      return this.getString(2131756033);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 999) {
         this.getActivity().setResult(var2);
         this.getActivity().finish();
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492870, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.c = var1.findItem(2131296294);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(this.b(), var2, false);
   }

   @OnClick
   public void onForgotPasswordClick(View var1) {
      try {
         this.f();
         String var5 = EntityData.a(this.getActivity()).i().getEmail();
         JiboAccountAsyncClient var2 = EntityData.a(this.getActivity()).a();
         AsyncHandler var3 = new AsyncHandler<SendPasswordResetRequest, Account>(this, var5) {
            final String a;
            final ConfirmPasswordFragment b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void a(SendPasswordResetRequest var1, Account var2x) {
               this.b.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.b.g();
                     Bundle var1x = new Bundle();
                     var1x.putString("email", this.a.a);
                     ((BaseActivity)this.a.b.getActivity()).a(ResetPasswordSentFragment.class, var1x);
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.b.a(var1, "send password reset", true);
            }
         };
         var2.sendPasswordReset(var5, var3);
      } catch (Exception var4) {
         this.g();
         Crashlytics.a(var4);
      }
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
         this.q();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      this.c.setEnabled(this.r());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.password.addTextChangedListener(this.d);
      this.a = EntityData.a(this.getContext()).a();
   }

   public void q() {
      this.a(false);
      this.c.setEnabled(false);
      this.a.changePassword(this.password.getText().toString(), this.password.getText().toString(), new AsyncHandler<ChangePasswordRequest, Account>(this) {
         final ConfirmPasswordFragment a;

         {
            this.a = var1;
         }

         public void a(ChangePasswordRequest var1, Account var2) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
                  this.a.a.c.setEnabled(true);
                  this.a.a.a();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "change password", false);
            if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.s();
                     this.a.a.g();
                  }
               });
            }
         }
      });
   }
}
