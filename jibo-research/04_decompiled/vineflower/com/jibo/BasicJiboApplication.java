package com.jibo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;
import com.crashlytics.android.Crashlytics;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.Commons;
import com.jibo.db.EntityData;
import com.jibo.service.DeviceUnRegistrationService;
import com.jibo.ui.view.proxima.ProximaHelper;

public abstract class BasicJiboApplication extends MultiDexApplication {
   public static FirebaseJobDispatcher a;

   private void c() {
   }

   private void d() {
      a = new FirebaseJobDispatcher(new GooglePlayDriver(this));
   }

   private void e() {
      SharedPreferences var1 = this.getSharedPreferences(this.getString(2131755063), 0);
      Commons.ROOT_ENDPOINT = "api.jibo.com";
      Commons.setRootEndpoint(var1.getString("PREF_END_POINT", Commons.ROOT_ENDPOINT));
   }

   private void f() {
      try {
         EntityData.a(this);
      } catch (Exception var2) {
         Crashlytics.a(var2);
      }
   }

   protected abstract void a();

   public void b() {
      EntityData.a(this).h();
      Intent var1 = new Intent(this, DeviceUnRegistrationService.class);
      var1.putExtra(Account.class.getSimpleName(), EntityData.a(this).i());
      this.startService(var1);
   }

   public void onCreate() {
      super.onCreate();
      Commons._DEBUG_LOG_OUTPUT = false;
      this.c();
      this.d();
      this.e();
      this.f();
      ProximaHelper.a(this.getApplicationContext());
      this.a();
   }
}
