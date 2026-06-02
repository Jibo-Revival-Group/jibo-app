package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;

public class ResetPasswordSentFragment extends BaseFragment {
   public static final String a = ResetPasswordSentFragment.class.getSimpleName();
   private String b;
   private String c;
   private boolean d = false;
   @BindView
   TextView text_instructions;

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
      return var1.inflate(2131427463, var2, false);
   }

   @OnClick
   public void onOpenEmailAppClick(View var1) {
      Intent var2 = new Intent("android.intent.action.MAIN");
      var2.addCategory("android.intent.category.APP_EMAIL");
      var2.setFlags(268435456);
      this.getActivity().startActivity(var2);
   }

   @OnClick
   public void onResendPasswordResetEmailClick(View var1) {
      try {
         if (TextUtils.isEmpty(this.b)) {
            InvalidParameterException var7 = new InvalidParameterException(this.getString(2131755305));
            throw var7;
         }

         this.f();
         JiboAccountAsyncClient var2 = EntityData.a(this.getActivity()).a();
         String var6 = this.b;
         AsyncHandler var3 = new AsyncHandler<SendPasswordResetRequest, Account>(this) {
            final ResetPasswordSentFragment a;

            {
               this.a = var1;
            }

            public void a(SendPasswordResetRequest var1, Account var2x) {
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
               this.a.a(var1, "send password reset", true);
            }
         };
         var2.sendPasswordReset(var6, var3);
      } catch (InvalidParameterException var4) {
      } catch (Exception var5) {
         this.g();
         Crashlytics.a(var5);
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

      this.b = var3;
      String var4;
      if (this.getArguments() != null && !TextUtils.isEmpty(this.getArguments().getString("code"))) {
         var4 = this.getArguments().getString("code");
      } else {
         var4 = "";
      }

      this.c = var4;
      this.text_instructions.setText(Html.fromHtml(String.format(this.getString(2131755852), this.b)));
      if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !this.d) {
         this.d = true;
         this.getArguments().clear();
         this.getArguments().putString("email", this.b);
         ((OnBoardingActivity)this.getActivity()).c(this.c);
      }
   }
}
