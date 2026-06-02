package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class CustomTabActivity extends Activity {
   public static final String CUSTOM_TAB_REDIRECT_ACTION = CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect";
   private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
   public static final String DESTROY_ACTION = CustomTabActivity.class.getSimpleName() + ".action_destroy";
   private BroadcastReceiver closeReceiver;

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == 0) {
         var3 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
         var3.putExtra(CustomTabMainActivity.EXTRA_URL, this.getIntent().getDataString());
         LocalBroadcastManager.a(this).a(var3);
         this.closeReceiver = new BroadcastReceiver(this) {
            final CustomTabActivity this$0;

            {
               this.this$0 = var1;
            }

            public void onReceive(Context var1, Intent var2x) {
               this.this$0.finish();
            }
         };
         LocalBroadcastManager.a(this).a(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Intent var2 = new Intent(this, CustomTabMainActivity.class);
      var2.setAction(CUSTOM_TAB_REDIRECT_ACTION);
      var2.putExtra(CustomTabMainActivity.EXTRA_URL, this.getIntent().getDataString());
      var2.addFlags(603979776);
      this.startActivityForResult(var2, 2);
   }

   protected void onDestroy() {
      LocalBroadcastManager.a(this).a(this.closeReceiver);
      super.onDestroy();
   }
}
