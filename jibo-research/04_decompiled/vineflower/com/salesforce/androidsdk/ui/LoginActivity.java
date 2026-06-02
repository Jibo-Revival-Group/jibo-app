package com.salesforce.androidsdk.ui;

import android.accounts.AccountAuthenticatorActivity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.security.KeyChain;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.util.EventsObservable;
import java.util.List;

public class LoginActivity extends AccountAuthenticatorActivity implements OAuthWebviewHelper.OAuthWebviewHelperEvents {
   private SalesforceR a;
   private boolean b;
   private OAuthWebviewHelper c;

   private void d() {
      SalesforceAnalyticsManager var1 = SalesforceAnalyticsManager.a(SalesforceSDKManager.a().o().b());
      if (var1 != null) {
         var1.b();
      }
   }

   protected OAuthWebviewHelper a(OAuthWebviewHelper.OAuthWebviewHelperEvents var1, ClientManager.LoginOptions var2, WebView var3, Bundle var4) {
      return new OAuthWebviewHelper(this, var1, var2, var3, var4);
   }

   protected void a() {
      if (this.c()) {
         String var1 = RuntimeConfig.a(this).a(RuntimeConfig.ConfigKey.ManagedAppCertAlias);
         KeyChain.choosePrivateKeyAlias(this, this.c, null, null, null, 0, var1);
      } else {
         this.c.g();
      }
   }

   @Override
   public void a(Bundle var1) {
      this.setAccountAuthenticatorResult(var1);
   }

   @Override
   public void a(String var1) {
      ActionBar var2 = this.getActionBar();
      if (var2 != null) {
         var2.setTitle(var1);
      }
   }

   @Override
   public void a(boolean var1) {
      this.setProgressBarIndeterminateVisibility(var1);
      this.setProgressBarIndeterminate(var1);
   }

   protected boolean a(int var1) {
      boolean var2 = true;
      if (var1 == 4) {
         if (SalesforceSDKManager.a().o().d() == null) {
            this.b = true;
            this.moveTaskToBack(true);
         } else {
            this.b = true;
            this.finish();
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   protected void b() {
      this.getWindow().requestFeature(2);
      this.getWindow().requestFeature(5);
   }

   @Override
   public void b(int var1) {
      this.a(false);
      this.setProgress(var1);
   }

   protected boolean c() {
      return RuntimeConfig.a(this).c(RuntimeConfig.ConfigKey.RequireCertAuth);
   }

   @Override
   public void finish() {
      byte var2 = 0;
      this.d();
      UserAccountManager var4 = SalesforceSDKManager.a().o();
      List var3 = var4.d();
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.size();
      }

      byte var5;
      if (var1 == 1) {
         var5 = var2;
      } else if (var1 > 1) {
         var5 = 1;
      } else {
         var5 = -1;
      }

      var4.a(var5, null);
      super.finish();
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if (var1 == 10 && var2 == -1) {
         this.c.g();
      } else if (var1 == 777 && var2 == -1) {
         this.c.c();
      } else {
         super.onActivityResult(var1, var2, var3);
      }
   }

   public void onClearCookiesClick(View var1) {
      this.c.a();
      this.c.g();
   }

   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.LoginActivity");
      super.onCreate(var1);
      this.a = SalesforceSDKManager.a().e();
      ClientManager.LoginOptions var2 = ClientManager.LoginOptions.a(this.getIntent().getExtras());
      this.b();
      this.getWindow().setFlags(8192, 8192);
      this.setContentView(this.a.b());
      WebView var4 = (WebView)this.findViewById(this.a.c());
      WebSettings var3 = var4.getSettings();
      var3.setJavaScriptEnabled(true);
      var3.setAllowFileAccessFromFileURLs(true);
      var3.setJavaScriptCanOpenWindowsAutomatically(true);
      var3.setDatabaseEnabled(true);
      var3.setDomStorageEnabled(true);
      EventsObservable.a().a(EventsObservable.EventType.AuthWebViewCreateComplete, var4);
      this.c = this.a(this, var2, var4, var1);
      EventsObservable.a().a(EventsObservable.EventType.LoginActivityCreateComplete, this);
      this.a();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(this.a.i(), var1);
      return super.onCreateOptionsMenu(var1);
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if (this.a(var1)) {
         var3 = true;
      } else {
         var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var3 = true;
      int var2 = var1.getItemId();
      if (var2 == this.a.j()) {
         this.onClearCookiesClick(null);
      } else if (var2 == this.a.k()) {
         this.onPickServerClick(null);
      } else if (var2 == this.a.l()) {
         this.onReloadClick(null);
      } else {
         var3 = super.onOptionsItemSelected(var1);
      }

      return var3;
   }

   public void onPickServerClick(View var1) {
      this.startActivityForResult(new Intent(this, ServerPickerActivity.class), 10);
   }

   public void onReloadClick(View var1) {
      this.c.g();
   }

   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.LoginActivity");
      super.onResume();
      if (this.b) {
         this.c.b();
         this.c.g();
         this.b = false;
      }
   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      this.c.a(var1);
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.LoginActivity");
      super.onStart();
   }
}
