package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.WebDialog;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
   public static final Creator<WebViewLoginMethodHandler> CREATOR = new Creator() {
      public WebViewLoginMethodHandler createFromParcel(Parcel var1) {
         return new WebViewLoginMethodHandler(var1);
      }

      public WebViewLoginMethodHandler[] newArray(int var1) {
         return new WebViewLoginMethodHandler[var1];
      }
   };
   private String e2e;
   private WebDialog loginDialog;

   WebViewLoginMethodHandler(Parcel var1) {
      super(var1);
      this.e2e = var1.readString();
   }

   WebViewLoginMethodHandler(LoginClient var1) {
      super(var1);
   }

   @Override
   void cancel() {
      if (this.loginDialog != null) {
         this.loginDialog.cancel();
         this.loginDialog = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   @Override
   String getNameForLogging() {
      return "web_view";
   }

   @Override
   AccessTokenSource getTokenSource() {
      return AccessTokenSource.WEB_VIEW;
   }

   @Override
   boolean needsInternetPermission() {
      return true;
   }

   void onWebDialogComplete(LoginClient.Request var1, Bundle var2, FacebookException var3) {
      super.onComplete(var1, var2, var3);
   }

   @Override
   boolean tryAuthorize(LoginClient.Request var1) {
      Bundle var3 = this.getParameters(var1);
      WebDialog.OnCompleteListener var4 = new WebDialog.OnCompleteListener(this, var1) {
         final WebViewLoginMethodHandler this$0;
         final LoginClient.Request val$request;

         {
            this.this$0 = var1;
            this.val$request = var2;
         }

         @Override
         public void onComplete(Bundle var1, FacebookException var2) {
            this.this$0.onWebDialogComplete(this.val$request, var1, var2);
         }
      };
      this.e2e = LoginClient.getE2E();
      this.addLoggingExtra("e2e", this.e2e);
      FragmentActivity var2 = this.loginClient.getActivity();
      this.loginDialog = new WebViewLoginMethodHandler.AuthDialogBuilder(var2, var1.getApplicationId(), var3)
         .setE2E(this.e2e)
         .setIsRerequest(var1.isRerequest())
         .setOnCompleteListener(var4)
         .build();
      FacebookDialogFragment var5 = new FacebookDialogFragment();
      var5.setRetainInstance(true);
      var5.setDialog(this.loginDialog);
      var5.show(var2.getSupportFragmentManager(), "FacebookDialogFragment");
      return true;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.e2e);
   }

   static class AuthDialogBuilder extends WebDialog.Builder {
      private static final String OAUTH_DIALOG = "oauth";
      static final String REDIRECT_URI = "fbconnect://success";
      private String e2e;
      private boolean isRerequest;

      public AuthDialogBuilder(Context var1, String var2, Bundle var3) {
         super(var1, var2, "oauth", var3);
      }

      @Override
      public WebDialog build() {
         Bundle var1 = this.getParameters();
         var1.putString("redirect_uri", "fbconnect://success");
         var1.putString("client_id", this.getApplicationId());
         var1.putString("e2e", this.e2e);
         var1.putString("response_type", "token,signed_request");
         var1.putString("return_scopes", "true");
         var1.putString("auth_type", "rerequest");
         return new WebDialog(this.getContext(), "oauth", var1, this.getTheme(), this.getListener());
      }

      public WebViewLoginMethodHandler.AuthDialogBuilder setE2E(String var1) {
         this.e2e = var1;
         return this;
      }

      public WebViewLoginMethodHandler.AuthDialogBuilder setIsRerequest(boolean var1) {
         this.isRerequest = var1;
         return this;
      }
   }
}
