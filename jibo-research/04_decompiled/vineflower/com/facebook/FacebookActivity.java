package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.perf.metrics.AppStartTrace;

public class FacebookActivity extends FragmentActivity {
   private static String FRAGMENT_TAG = "SingleFragment";
   public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
   private static final String TAG = FacebookActivity.class.getName();
   private Fragment singleFragment;

   private void handlePassThroughError() {
      FacebookException var1 = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(this.getIntent()));
      this.setResult(0, NativeProtocol.createProtocolResultIntent(this.getIntent(), null, var1));
      this.finish();
   }

   public Fragment getCurrentFragment() {
      return this.singleFragment;
   }

   protected Fragment getFragment() {
      Intent var4 = this.getIntent();
      FragmentManager var3 = this.getSupportFragmentManager();
      Fragment var2 = var3.a(FRAGMENT_TAG);
      Fragment var1 = var2;
      if (var2 == null) {
         if ("FacebookDialogFragment".equals(var4.getAction())) {
            var1 = new FacebookDialogFragment();
            var1.setRetainInstance(true);
            var1.show(var3, FRAGMENT_TAG);
         } else if ("DeviceShareDialogFragment".equals(var4.getAction())) {
            var1 = new DeviceShareDialogFragment();
            var1.setRetainInstance(true);
            var1.setShareContent((ShareContent)var4.getParcelableExtra("content"));
            var1.show(var3, FRAGMENT_TAG);
         } else {
            var1 = new LoginFragment();
            var1.setRetainInstance(true);
            var3.a().a(R.id.com_facebook_fragment_container, var1, FRAGMENT_TAG).d();
         }
      }

      return var1;
   }

   @Override
   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      if (this.singleFragment != null) {
         this.singleFragment.onConfigurationChanged(var1);
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.facebook.FacebookActivity");
      super.onCreate(var1);
      Intent var2 = this.getIntent();
      if (!FacebookSdk.isInitialized()) {
         Log.d(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
         FacebookSdk.sdkInitialize(this.getApplicationContext());
      }

      this.setContentView(R.layout.com_facebook_activity_layout);
      if (PASS_THROUGH_CANCEL_ACTION.equals(var2.getAction())) {
         this.handlePassThroughError();
      } else {
         this.singleFragment = this.getFragment();
      }
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.facebook.FacebookActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.facebook.FacebookActivity");
      super.onStart();
   }
}
