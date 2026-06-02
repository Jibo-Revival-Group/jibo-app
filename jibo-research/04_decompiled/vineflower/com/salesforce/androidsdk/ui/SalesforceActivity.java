package com.salesforce.androidsdk.ui;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.LogoutCompleteReceiver;
import com.salesforce.androidsdk.util.UserSwitchReceiver;

public abstract class SalesforceActivity extends Activity {
   private PasscodeManager a;
   private UserSwitchReceiver b;
   private LogoutCompleteReceiver c;

   protected void a() {
      if (this.a.b(this)) {
         new ClientManager(this, SalesforceSDKManager.a().B(), SalesforceSDKManager.a().h(), SalesforceSDKManager.a().j())
            .a(this, new ClientManager.RestClientCallback(this) {
               final SalesforceActivity a;

               {
                  this.a = var1;
               }

               @Override
               public void a(RestClient var1) {
                  if (var1 == null) {
                     SalesforceSDKManager.a().a(this.a);
                  } else {
                     this.a.a(var1);
                     EventsObservable.a().a(EventsObservable.EventType.RenditionComplete);
                  }
               }
            });
      }
   }

   public abstract void a(RestClient var1);

   protected void b() {
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.a = SalesforceSDKManager.a().n();
      this.b = new SalesforceActivity.ActivityUserSwitchReceiver(this);
      this.registerReceiver(this.b, new IntentFilter("com.salesforce.USERSWITCHED"));
      this.c = new SalesforceActivity.ActivityLogoutCompleteReceiver(this);
      this.registerReceiver(this.c, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
      EventsObservable.a().a(EventsObservable.EventType.MainActivityCreateComplete, this);
   }

   public void onDestroy() {
      this.unregisterReceiver(this.b);
      this.unregisterReceiver(this.c);
      super.onDestroy();
   }

   public void onPause() {
      super.onPause();
      this.a.a(this);
   }

   public void onResume() {
      super.onResume();
      if (this.a.b(this)) {
         new ClientManager(this, SalesforceSDKManager.a().B(), SalesforceSDKManager.a().h(), SalesforceSDKManager.a().j())
            .a(this, new ClientManager.RestClientCallback(this) {
               final SalesforceActivity a;

               {
                  this.a = var1;
               }

               @Override
               public void a(RestClient var1) {
                  if (var1 == null) {
                     SalesforceSDKManager.a().a(this.a);
                  } else {
                     this.a.a(var1);
                     EventsObservable.a().a(EventsObservable.EventType.RenditionComplete);
                  }
               }
            });
      }
   }

   public void onUserInteraction() {
      this.a.f();
   }

   private class ActivityLogoutCompleteReceiver extends LogoutCompleteReceiver {
      final SalesforceActivity a;

      private ActivityLogoutCompleteReceiver(SalesforceActivity var1) {
         this.a = var1;
      }

      @Override
      protected void a() {
         this.a.b();
      }
   }

   private class ActivityUserSwitchReceiver extends UserSwitchReceiver {
      final SalesforceActivity a;

      private ActivityUserSwitchReceiver(SalesforceActivity var1) {
         this.a = var1;
      }

      @Override
      protected void a() {
         this.a.a();
      }
   }
}
