package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.Validate;

public abstract class AccessTokenTracker {
   private final LocalBroadcastManager broadcastManager;
   private boolean isTracking = false;
   private final BroadcastReceiver receiver;

   public AccessTokenTracker() {
      Validate.sdkInitialized();
      this.receiver = new AccessTokenTracker.CurrentAccessTokenBroadcastReceiver(this);
      this.broadcastManager = LocalBroadcastManager.a(FacebookSdk.getApplicationContext());
      this.startTracking();
   }

   private void addBroadcastReceiver() {
      IntentFilter var1 = new IntentFilter();
      var1.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
      this.broadcastManager.a(this.receiver, var1);
   }

   public boolean isTracking() {
      return this.isTracking;
   }

   protected abstract void onCurrentAccessTokenChanged(AccessToken var1, AccessToken var2);

   public void startTracking() {
      if (!this.isTracking) {
         this.addBroadcastReceiver();
         this.isTracking = true;
      }
   }

   public void stopTracking() {
      if (this.isTracking) {
         this.broadcastManager.a(this.receiver);
         this.isTracking = false;
      }
   }

   private class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
      final AccessTokenTracker this$0;

      private CurrentAccessTokenBroadcastReceiver(AccessTokenTracker var1) {
         this.this$0 = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(var2.getAction())) {
            AccessToken var3 = (AccessToken)var2.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN");
            AccessToken var4 = (AccessToken)var2.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN");
            this.this$0.onCurrentAccessTokenChanged(var3, var4);
         }
      }
   }
}
