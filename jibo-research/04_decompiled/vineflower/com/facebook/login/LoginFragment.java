package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.R;

public class LoginFragment extends Fragment {
   static final String EXTRA_REQUEST = "request";
   private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
   static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
   static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
   private static final String SAVED_LOGIN_CLIENT = "loginClient";
   private static final String TAG = "LoginFragment";
   private String callingPackage;
   private LoginClient loginClient;
   private LoginClient.Request request;

   private void initializeCallingPackage(Activity var1) {
      ComponentName var2 = var1.getCallingActivity();
      if (var2 != null) {
         this.callingPackage = var2.getPackageName();
      }
   }

   private void onLoginClientCompleted(LoginClient.Result var1) {
      this.request = null;
      byte var2;
      if (var1.code == LoginClient.Result.Code.CANCEL) {
         var2 = 0;
      } else {
         var2 = -1;
      }

      Bundle var3 = new Bundle();
      var3.putParcelable("com.facebook.LoginFragment:Result", var1);
      Intent var4 = new Intent();
      var4.putExtras(var3);
      if (this.isAdded()) {
         this.getActivity().setResult(var2, var4);
         this.getActivity().finish();
      }
   }

   protected LoginClient createLoginClient() {
      return new LoginClient(this);
   }

   LoginClient getLoginClient() {
      return this.loginClient;
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      this.loginClient.onActivityResult(var1, var2, var3);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.loginClient = (LoginClient)var1.getParcelable("loginClient");
         this.loginClient.setFragment(this);
      } else {
         this.loginClient = this.createLoginClient();
      }

      this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener(this) {
         final LoginFragment this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCompleted(LoginClient.Result var1) {
            this.this$0.onLoginClientCompleted(var1);
         }
      });
      FragmentActivity var2 = this.getActivity();
      if (var2 != null) {
         this.initializeCallingPackage(var2);
         if (var2.getIntent() != null) {
            this.request = (LoginClient.Request)var2.getIntent().getBundleExtra("com.facebook.LoginFragment:Request").getParcelable("request");
         }
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(R.layout.com_facebook_login_fragment, var2, false);
      this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener(this, var4) {
         final LoginFragment this$0;
         final View val$view;

         {
            this.this$0 = var1;
            this.val$view = var2x;
         }

         @Override
         public void onBackgroundProcessingStarted() {
            this.val$view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
         }

         @Override
         public void onBackgroundProcessingStopped() {
            this.val$view.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
         }
      });
      return var4;
   }

   @Override
   public void onDestroy() {
      this.loginClient.cancelCurrentHandler();
      super.onDestroy();
   }

   @Override
   public void onPause() {
      super.onPause();
      this.getActivity().findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.callingPackage == null) {
         Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
         this.getActivity().finish();
      } else {
         this.loginClient.startOrContinueAuth(this.request);
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable("loginClient", this.loginClient);
   }
}
