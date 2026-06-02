package com.jibo.ui.fragment.phone;

import android.os.Bundle;
import android.view.MenuItem;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.view.proxima.CustomFontTextView;

public abstract class PhoneBaseFragment extends BaseFragment {
   public static final String a = PhoneBaseFragment.class.getSimpleName();
   protected MenuItem b;
   protected CustomFontTextView c;
   protected boolean d;
   protected Runnable e = new Runnable(this) {
      final PhoneBaseFragment a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         Bundle var1 = new Bundle();
         var1.putString("PARAM_PHONENUMBER", this.a.a(this.a.b()));
         ((BaseActivity)this.a.getActivity()).a(PhoneConfirmFragment.class, var1);
      }
   };

   protected String a(String var1) {
      return var1.replaceAll(" |\\-|\\(|\\)", "");
   }

   protected abstract void a();

   protected abstract String b();

   protected void b(Runnable var1) {
      this.f();
      this.e();
      EntityData.a(this.getActivity())
         .a()
         .sendPhoneVerificationCode("+1" + this.a(this.b()), new AsyncHandler<SendPhoneVerificationCodeRequest, IdResponse>(this, var1) {
            final Runnable a;
            final PhoneBaseFragment b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void a(SendPhoneVerificationCodeRequest var1, IdResponse var2) {
               this.b.g();
               this.b.a(this.a);
            }

            @Override
            public void onError(Exception var1) {
               this.b.a(var1, "send phone verification code", true);
            }
         });
   }

   @Override
   public void onCreate(Bundle var1) {
      boolean var2 = true;
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
      if (this.getActivity() instanceof OnBoardingActivity) {
         var2 = false;
      }

      this.d = var2;
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a();
   }
}
