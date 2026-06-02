package com.salesforce.android.knowledge.core.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserLogoutBroadcastReceiver extends BroadcastReceiver implements MobileSdkUserManager {
   private static final ServiceLogger b = ServiceLogging.a(UserLogoutBroadcastReceiver.class);
   private final SmartStoreSDKManager a;
   private UserAccount c;
   private SmartStore d;
   private HttpClient e;
   private final List<LogoutListener> f = new ArrayList<>();

   protected UserLogoutBroadcastReceiver(UserLogoutBroadcastReceiver.Builder var1) {
      this.a = var1.b();
      if (var1.a() != null && this.a(var1.a())) {
         this.c = var1.a();
         var1.c().registerReceiver(this, new IntentFilter("com.salesforce.USERSWITCHED"));
         var1.c().registerReceiver(this, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
      }

      boolean var2;
      if (this.c != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(var2);
   }

   private void a(boolean var1) {
      if (var1) {
         b.b("Setting up authenticated Kb access.");
         this.e = SalesforceOkHttpClient.a(this.a.E().a(this.c).d());
         this.d = this.a.b(this.c);
      } else {
         b.b("Setting up unauthenticated Kb access.");
         this.e = SalesforceOkHttpClient.a(this.a.E().a().d());
         this.d = this.a.g("anonymous");
      }
   }

   private boolean a(UserAccount var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         List var4 = this.a.o().d();
         var2 = var3;
         if (var4 != null) {
            var2 = var3;
            if (var4.contains(var1)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   private void d() {
      boolean var1 = this.a(this.c);
      if (this.c != null && !var1) {
         this.c = null;
         this.a(false);
         Iterator var2 = this.f.iterator();

         while (var2.hasNext()) {
            ((LogoutListener)var2.next()).a();
         }
      }
   }

   @Override
   public SmartStore a() {
      return this.d;
   }

   public void a(Context var1) {
      if (this.c != null) {
         var1.unregisterReceiver(this);
         this.c = null;
         this.f.clear();
      }
   }

   @Override
   public void a(LogoutListener var1) {
      this.f.add(var1);
   }

   @Override
   public HttpClient b() {
      return this.e;
   }

   @Override
   public void c() {
      if (this.a(this.c)) {
         this.a.c(this.c);
      } else {
         this.a.h("anonymous");
      }
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2 != null && var2.getAction().equals("com.salesforce.LOGOUT_COMPLETE")) {
         this.d();
      }
   }

   public static class Builder {
      private final UserAccount a;
      private SmartStoreSDKManager b;
      private final Context c;

      public Builder(Context var1, UserAccount var2) {
         this.a = var2;
         this.c = var1;
      }

      public UserAccount a() {
         return this.a;
      }

      public SmartStoreSDKManager b() {
         return this.b;
      }

      public Context c() {
         return this.c;
      }

      public UserLogoutBroadcastReceiver d() {
         if (this.b == null) {
            this.b = SmartStoreSDKManager.H();
         }

         return new UserLogoutBroadcastReceiver(this);
      }
   }
}
