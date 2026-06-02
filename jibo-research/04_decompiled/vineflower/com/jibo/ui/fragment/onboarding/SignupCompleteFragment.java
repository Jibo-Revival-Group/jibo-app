package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.EmailRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.UIUtils;

public class SignupCompleteFragment extends BaseFragment {
   public static final String a = SignupCompleteFragment.class.getSimpleName();
   @BindView
   Button btnOpenEmailApp;
   @BindView
   TextView text_instructions;

   private void a() {
      try {
         this.e();
         CircleProgressFragment var1 = new CircleProgressFragment();
         this.j = var1;
         var1 = this.j;
         CircleProgressFragment.OnDismissListener var2 = new CircleProgressFragment.OnDismissListener(this) {
            final SignupCompleteFragment a;

            {
               this.a = var1;
            }

            @Override
            public void a(CircleProgressFragment.Status var1) {
               if (var1 == CircleProgressFragment.Status.Success) {
                  this.a.j();
               }
            }
         };
         var1.a(var2);
         this.j.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
         JiboAccountAsyncClient var8 = EntityData.a(this.getActivity()).a();
         String var7 = this.getArguments().getString("code", "");
         AsyncHandler var3 = new AsyncHandler<ActivateByCodeRequest, Account>(this) {
            final SignupCompleteFragment a;

            {
               this.a = var1;
            }

            public void a(ActivateByCodeRequest var1, Account var2x) {
               if (this.a.d()) {
                  EntityData.a(this.a.getActivity()).a(var2x, true, null);
               }

               this.a.j.a(this.a.getString(2131755041));
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "activate by code", false);
               if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                  this.a.j.b(((AmazonServiceException)var1).getErrorMessage());
               }
            }
         };
         var8.activateByCode(var7, var3);
      } catch (InvalidParameterException var4) {
      } catch (Exception var5) {
         ((OnBoardingActivity)this.getActivity()).l();
         Crashlytics.a(var5);
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
      return this.getString(2131755772);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427470, var2, false);
   }

   @OnClick
   public void onOpenEmailAppClick(View var1) {
      Intent var2 = new Intent("android.intent.action.MAIN");
      var2.addCategory("android.intent.category.APP_EMAIL");
      var2.setFlags(268435456);
      if (var2.resolveActivity(this.getActivity().getPackageManager()) != null) {
         this.getActivity().startActivity(var2);
      } else {
         UIUtils.a(this.btnOpenEmailApp, this.getString(2131755554));
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @OnClick
   public void onResendVerificationEmailClick(View var1) {
      Account var2;
      try {
         ((OnBoardingActivity)this.getActivity()).k();
         var2 = EntityData.a(this.getActivity()).i();
         var6 = EntityData.a(this.getActivity()).a();
      } catch (Exception var5) {
         ((OnBoardingActivity)this.getActivity()).l();
         Crashlytics.a(var5);
         return;
      }

      if (var2 != null) {
         try {
            if (!TextUtils.isEmpty(var2.getEmail())) {
               String var7 = var2.getEmail();
               AsyncHandler var3 = new AsyncHandler<EmailRequest, Account>(this) {
                  final SignupCompleteFragment a;

                  {
                     this.a = var1;
                  }

                  public void a(EmailRequest var1, Account var2x) {
                     this.a.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           this.a.a.g();
                        }
                     });
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.a.a(var1, "resend activation code", true);
                  }
               };
               var6.resendActivationCode(var7, var3);
            }
         } catch (Exception var4) {
            ((OnBoardingActivity)this.getActivity()).l();
            Crashlytics.a(var4);
         }
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      String var3;
      if (this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("email"))) {
         var3 = this.getArguments().getString("email");
      } else {
         var3 = "";
      }

      this.text_instructions.setText(Html.fromHtml(String.format(this.getString(2131755853), var3)));
      if (!TextUtils.isEmpty(this.getArguments().getString("code", null))) {
         this.a();
      }
   }
}
