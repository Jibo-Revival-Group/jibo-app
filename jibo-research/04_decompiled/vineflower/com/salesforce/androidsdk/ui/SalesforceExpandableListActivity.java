package com.salesforce.androidsdk.ui;

import android.app.ExpandableListActivity;
import android.content.IntentFilter;
import android.os.Bundle;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.LogoutCompleteReceiver;
import com.salesforce.androidsdk.util.UserSwitchReceiver;

public abstract class SalesforceExpandableListActivity extends ExpandableListActivity {
   private PasscodeManager a;
   private UserSwitchReceiver b;
   private LogoutCompleteReceiver c;

   protected void a() {
      if (this.a.b(this)) {
         new ClientManager(this, SalesforceSDKManager.a().B(), SalesforceSDKManager.a().h(), SalesforceSDKManager.a().j())
            .a(this, new ClientManager.RestClientCallback(this) {
               final SalesforceExpandableListActivity a;

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
      this.b = new SalesforceExpandableListActivity.ActivityUserSwitchReceiver(this);
      this.registerReceiver(this.b, new IntentFilter("com.salesforce.USERSWITCHED"));
      this.c = new SalesforceExpandableListActivity.ActivityLogoutCompleteReceiver(this);
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
               final SalesforceExpandableListActivity a;

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
      final SalesforceExpandableListActivity a;

      private ActivityLogoutCompleteReceiver(SalesforceExpandableListActivity var1) {
         this.a = var1;
      }

      @Override
      protected void a() {
         this.a.b();
      }
   }

   private class ActivityUserSwitchReceiver extends UserSwitchReceiver {
      final SalesforceExpandableListActivity a;

      private ActivityUserSwitchReceiver(SalesforceExpandableListActivity var1) {
         this.a = var1;
      }

      @Override
      protected void a() {
         this.a.a();
      }
   }
}
