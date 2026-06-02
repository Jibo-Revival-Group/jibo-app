package com.jibo.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.SplashFragment;
import com.jibo.ui.fragment.onboarding.AboutYouFragment;
import com.jibo.ui.fragment.onboarding.DevSettingsFragment;
import com.jibo.ui.fragment.onboarding.LoginFragment;
import com.jibo.ui.fragment.onboarding.ResetPasswordFragment;
import com.jibo.ui.fragment.onboarding.ResetPasswordNewPasswordFragment;
import com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment;
import com.jibo.ui.fragment.onboarding.SignupCompleteFragment;
import com.jibo.ui.fragment.onboarding.SignupFragment;
import com.jibo.ui.fragment.onboarding.WelcomeFragment;
import com.jibo.ui.fragment.phone.PhoneFillFragment;
import com.jibo.utils.SharedPreferencesUtil;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends BaseActivity implements BaseActivity.OnDoubleBackButtonListener {
   public static final String h = OnBoardingActivity.class.getSimpleName();
   public static final String i = OnBoardingActivity.class.getName() + ".ACTION_RESET_PASSWORD";
   public static final String j = OnBoardingActivity.class.getName() + ".ACTION_LOGIN_OR_SIGNUP";
   public static final String k = OnBoardingActivity.class.getName() + "" + ".ACTION_CUSTOMER_SUPPORT";
   public static final String l = OnBoardingActivity.class.getName() + ".ACTION_DEV_SETTINGS";
   public static String n = null;
   public Bundle m = new Bundle();

   public static void a(Context var0, String var1, boolean var2) {
      Intent var3 = new Intent(var0, OnBoardingActivity.class);
      var3.setAction(var1);
      var0.startActivity(var3);
      if (var2 && var0 instanceof Activity) {
         ((Activity)var0).finish();
      }
   }

   private void a(Uri var1) {
      String var3 = var1.getQueryParameter("loopId");
      if (EntityData.a(this).i() == null) {
         ((JiboApplication)this.getApplication()).b();
         this.q();
      } else {
         Bundle var2 = new Bundle();
         var2.putInt("ARG_TAB_SELECTED", 0);
         var2.putBoolean("ARG_SETTINGS", true);
         var2.putString("ARG_LOOP_ID", var3);
         this.getIntent().putExtra("ARG_EXTRAS", var2);
         this.u();
      }
   }

   private void a(List<Loop> var1) {
      var1 = new ArrayList(var1);
      Intent var2 = new Intent();
      var2.putParcelableArrayListExtra(" ARGS_LOOPS_LIST", var1);
      var2.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", false);
      var2.putExtra("ARG_EXTRAS", this.getIntent().getExtras().getBundle("ARG_EXTRAS"));
      var2.setClass(this, LoopInviteDetailsActivity.class);
      this.startActivity(var2);
      this.finish();
   }

   private void b(Uri var1) {
      String var2 = var1.getQueryParameter("email");
      String var3 = var1.getQueryParameter("code");
      Account var4 = EntityData.a(this).i();
      if (var4 == null) {
         ((JiboApplication)this.getApplication()).b();
         if (TextUtils.isEmpty(var3)) {
            this.q();
         } else {
            this.a(var2, var3);
         }
      } else if (!TextUtils.isEmpty(var2) && var2.equals(var4.getEmail())) {
         Bundle var6 = new Bundle();
         var6.putInt("ARG_TAB_SELECTED", 0);
         this.getIntent().putExtra("ARG_EXTRAS", var6);
         this.u();
      } else if (!TextUtils.isEmpty(var2) && !var2.equals(var4.getEmail())) {
         Bundle var5 = new Bundle();
         var5.putInt("ARG_TAB_SELECTED", 0);
         var5.putString("ARG_TITLE", this.getString(2131755546));
         var5.putString("ARG_MESSAGE", String.format(this.getString(2131755545), var2));
         this.getIntent().putExtra("ARG_EXTRAS", var5);
         this.m.putAll(var5);
         this.u();
      } else {
         this.u();
      }
   }

   private void u() {
      this.m();
      this.a(SplashFragment.class, this.m);
   }

   public void a(String var1) {
      this.m.putString("email", var1);
      this.a(LoginFragment.class, this.m);
   }

   public void a(String var1, String var2) {
      this.m.putString("email", var1);
      this.m.putString("code", var2);
      this.getSupportFragmentManager()
         .a()
         .b(2131296575, Fragment.instantiate(this, SignupFragment.class.getName(), this.m), SignupFragment.a)
         .a(SignupFragment.a)
         .d();
   }

   public void a(List<Loop> var1, BaseFragment var2) {
      Account var3 = EntityData.a(this).i();
      if (var3 == null) {
         this.q();
      } else if (!var3.isActive()) {
         this.b(var3.getEmail(), null);
      } else if (var2 != null && var2 instanceof SignupCompleteFragment) {
         this.r();
      } else if (var3.isIncomplete()) {
         this.r();
      } else if (LoopHelper.hasInvitationsOnly(var1, var3.getEmail())) {
         this.a(var1);
      } else {
         if (SharedPreferencesUtil.g(this.getApplicationContext())) {
            SyncHelper.a(this.getApplicationContext());
         }

         SyncHelper.c(this.getApplicationContext());
         TabbedActivity.a(this, this.getIntent().getExtras().getBundle("ARG_EXTRAS"));
      }
   }

   protected boolean a(Intent var1) {
      if (!SharedPreferencesUtil.c(this)) {
         if (var1.getData() != null && var1.getData().toString() != null) {
            JiboAnalytics.a(this, true);
         } else {
            JiboAnalytics.a(this, false);
         }

         SharedPreferencesUtil.d(this);
      }

      if (i.equals(var1.getAction())) {
         this.c(EntityData.a(this).i().getEmail(), "");
      } else if (j.equals(var1.getAction())) {
         this.q();
      } else if (!k.equals(var1.getAction())) {
         if (l.equals(var1.getAction())) {
            this.t();
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755493))) {
            ((JiboApplication)this.getApplication()).b();
            this.b(var1.getData().getQueryParameter("email"), var1.getData().getQueryParameter("code"));
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755496))) {
            ((JiboApplication)this.getApplication()).b();
            this.c(var1.getData().getQueryParameter("email"), var1.getData().getQueryParameter("code"));
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755494))) {
            this.b(var1.getData());
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755495))) {
            this.b(var1.getData());
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755497))) {
            this.a(var1.getData());
         } else if (var1.getData() != null && var1.getData().toString().contains(this.getString(2131755329))) {
            n = var1.getData().toString();
            this.setResult(-1, var1);
            this.finish();
         } else {
            this.u();
         }
      }

      return false;
   }

   public void b(String var1) {
      this.m.putString("email", var1);
      this.getSupportFragmentManager()
         .a()
         .b(2131296575, Fragment.instantiate(this, ResetPasswordFragment.class.getName(), this.m), ResetPasswordFragment.a)
         .a(ResetPasswordFragment.a)
         .d();
   }

   public void b(String var1, String var2) {
      if (TextUtils.isEmpty(var1)) {
         this.u();
      } else {
         this.m.putString("email", var1);
         this.m.putString("code", var2);
         this.getSupportFragmentManager().d();
         this.e
            .postDelayed(
               new Runnable(this) {
                  final OnBoardingActivity a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a
                        .getSupportFragmentManager()
                        .a()
                        .b(2131296575, Fragment.instantiate(this.a, SignupCompleteFragment.class.getName(), this.a.m), SignupCompleteFragment.a)
                        .a(SignupCompleteFragment.a)
                        .d();
                  }
               },
               500L
            );
      }
   }

   public void c(String var1) {
      this.m.putString("code", var1);
      this.getSupportFragmentManager()
         .a()
         .b(2131296575, Fragment.instantiate(this, ResetPasswordNewPasswordFragment.class.getName(), this.m), ResetPasswordNewPasswordFragment.a)
         .a(ResetPasswordNewPasswordFragment.a)
         .d();
   }

   public void c(String var1, String var2) {
      if (TextUtils.isEmpty(var1)) {
         this.u();
      } else {
         this.m.putString("email", var1);
         this.m.putString("code", var2);
         this.getSupportFragmentManager()
            .a()
            .b(2131296575, Fragment.instantiate(this, ResetPasswordSentFragment.class.getName(), this.m), ResetPasswordSentFragment.a)
            .a(ResetPasswordSentFragment.a)
            .d();
      }
   }

   @Override
   public void e() {
   }

   @Override
   public void onBackPressed() {
      this.l();
      if (this.getSupportFragmentManager().e() == 1) {
         if (this.getSupportFragmentManager().a(SignupCompleteFragment.a) != null
            || this.getSupportFragmentManager().a(LoginFragment.a) != null
            || this.getSupportFragmentManager().a(AboutYouFragment.n) != null) {
            this.q();
            return;
         }

         if (this.getSupportFragmentManager().a(ResetPasswordSentFragment.a) != null
            || this.getSupportFragmentManager().a(ResetPasswordNewPasswordFragment.a) != null) {
            this.m();
            this.a((String)null);
            return;
         }
      }

      super.onBackPressed();
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.OnBoardingActivity");
      this.getIntent().putExtra(BaseActivity.b, 2131427361);
      super.onCreate(var1);
      Fabric.a(this, new Crashlytics());
      if (!"jibo".equals("netposa")) {
         SharedPreferences var2 = this.getSharedPreferences(this.getString(2131755063), 0);
         Commons.setRootEndpoint(Commons.ALLOWED_ENDPOINTS[2]);
         var2.edit().putString("PREF_END_POINT", Commons.ALLOWED_ENDPOINTS[2]).apply();
      }

      if (var1 == null) {
         this.a(this.getIntent());
      }
   }

   @Override
   protected void onNewIntent(Intent var1) {
      this.setIntent(var1);
      if (!this.a(var1)) {
         super.onNewIntent(var1);
      }
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.OnBoardingActivity");
      super.onResume();
   }

   @Override
   protected void onResumeFragments() {
      super.onResumeFragments();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.OnBoardingActivity");
      super.onStart();
   }

   public void q() {
      this.m();
      this.a(WelcomeFragment.class, this.m);
   }

   public void r() {
      this.m();
      this.a(PhoneFillFragment.class, this.m);
   }

   public void s() {
      this.m();
      this.a(AboutYouFragment.class, this.m);
   }

   public void t() {
      this.getSupportFragmentManager()
         .a()
         .b(2131296575, Fragment.instantiate(this, DevSettingsFragment.class.getName(), this.m), DevSettingsFragment.a)
         .a(DevSettingsFragment.a)
         .d();
   }
}
