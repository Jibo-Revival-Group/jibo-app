package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.google.firebase.perf.metrics.AppStartTrace;

public class CustomTabMainActivity extends Activity {
   public static final String EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";
   public static final String EXTRA_PARAMS = CustomTabMainActivity.class.getSimpleName() + ".extra_params";
   public static final String EXTRA_URL = CustomTabMainActivity.class.getSimpleName() + ".extra_url";
   private static final String OAUTH_DIALOG = "oauth";
   public static final String REFRESH_ACTION = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";
   private BroadcastReceiver redirectReceiver;
   private boolean shouldCloseCustomTab = true;

   public static final String getRedirectUrl() {
      return "fb" + FacebookSdk.getApplicationId() + "://authorize";
   }

   private void sendResult(int var1, Intent var2) {
      LocalBroadcastManager.a(this).a(this.redirectReceiver);
      if (var2 != null) {
         this.setResult(var1, var2);
      } else {
         this.setResult(var1);
      }

      this.finish();
   }

   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.facebook.CustomTabMainActivity");
      super.onCreate(var1);
      if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(this.getIntent().getAction())) {
         this.setResult(0);
         this.finish();
      } else if (var1 == null) {
         var1 = this.getIntent().getBundleExtra(EXTRA_PARAMS);
         String var2 = this.getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
         new CustomTab("oauth", var1).openCustomTab(this, var2);
         this.shouldCloseCustomTab = false;
         this.redirectReceiver = new BroadcastReceiver(this) {
            final CustomTabMainActivity this$0;

            {
               this.this$0 = var1;
            }

            public void onReceive(Context var1, Intent var2x) {
               Intent var3 = new Intent(this.this$0, CustomTabMainActivity.class);
               var3.setAction(CustomTabMainActivity.REFRESH_ACTION);
               var3.putExtra(CustomTabMainActivity.EXTRA_URL, var2x.getStringExtra(CustomTabMainActivity.EXTRA_URL));
               var3.addFlags(603979776);
               this.this$0.startActivity(var3);
            }
         };
         LocalBroadcastManager.a(this).a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
      }
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      if (REFRESH_ACTION.equals(var1.getAction())) {
         Intent var2 = new Intent(CustomTabActivity.DESTROY_ACTION);
         LocalBroadcastManager.a(this).a(var2);
         this.sendResult(-1, var1);
      } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(var1.getAction())) {
         this.sendResult(-1, var1);
      }
   }

   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.facebook.CustomTabMainActivity");
      super.onResume();
      if (this.shouldCloseCustomTab) {
         this.sendResult(0, null);
      }

      this.shouldCloseCustomTab = true;
   }

   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.facebook.CustomTabMainActivity");
      super.onStart();
   }
}
