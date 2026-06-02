package com.jibo.ui.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazonaws.AmazonServiceException;
import com.jibo.JiboAnalytics;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.List;

public class SplashFragment extends BaseFragment {
   public static final String a = SplashFragment.class.getSimpleName();
   private Runnable b = new Runnable(this) {
      final SplashFragment a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         if (this.a.d()) {
            Account var1 = EntityData.a(this.a.getActivity()).i();
            if (var1 != null && !TextUtils.isEmpty(var1.getAccessKeyId()) && !TextUtils.isEmpty(var1.getSecretAccessKey())) {
               JiboAnalytics.a(this.a.getActivity(), var1);
               this.a.i();
               EntityData.a(this.a.getActivity()).a(new Commons.AsyncCallback<Object>(this, var1) {
                  final Account a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.b.a.a(var1, "pull crutial data from server", true);
                     if (var1 instanceof AmazonServiceException) {
                        var1 = var1;
                        if (ErrorHelper.a(var1)) {
                           this.b.a.a();
                        } else if (ErrorHelper.b(var1) || ErrorHelper.c(var1)) {
                           ((JiboApplication)this.b.a.getActivity().getApplication()).b();
                           this.b.a.a();
                        } else if (ErrorHelper.d(var1)) {
                           this.b.a.a(new Runnable(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }

                              @Override
                              public void run() {
                                 ((OnBoardingActivity)this.a.b.a.getActivity()).b(this.a.a.getEmail(), null);
                              }
                           });
                        } else {
                           this.b.a.a();
                        }
                     } else {
                        this.b.a.a();
                     }
                  }

                  @Override
                  public void onSuccess(Object var1) {
                     if (this.b.a.d()) {
                        Account var2 = EntityData.a(this.b.a.getActivity()).i();
                        if (var2.isActive() && !(var1 instanceof Account)) {
                           KeyManager.getInstance(this.b.a.getActivity(), var2.getId());
                           var1 = var1;
                           this.b.a.a(new Runnable(this, var1) {
                              final List a;
                              final <unrepresentable> b;

                              {
                                 this.b = var1;
                                 this.a = var2x;
                              }

                              @Override
                              public void run() {
                                 ((OnBoardingActivity)this.b.b.a.getActivity()).a(this.a, this.b.b.a);
                              }
                           });
                        } else {
                           ((OnBoardingActivity)this.b.a.getActivity()).b(var2.getEmail(), null);
                        }
                     }
                  }
               });
            } else {
               SharedPreferencesUtil.a(this.a.getActivity());
               this.a.a();
            }
         }
      }
   };

   private void a() {
      this.a(new Runnable(this) {
         final SplashFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            try {
               ((OnBoardingActivity)this.a.getActivity()).q();
            } catch (Exception var2) {
               LogUtils.a(SplashFragment.a, "gotoSignupLoginFragment", var2);
            }
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427473, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.c().removeCallbacks(this.b);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.c().removeCallbacks(this.b);
      this.c().postDelayed(this.b, 500L);
   }
}
