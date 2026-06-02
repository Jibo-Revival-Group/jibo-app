package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class LoginMethodHandler implements Parcelable {
   protected LoginClient loginClient;
   Map<String, String> methodLoggingExtras;

   LoginMethodHandler(Parcel var1) {
      this.methodLoggingExtras = Utility.readStringMapFromParcel(var1);
   }

   LoginMethodHandler(LoginClient var1) {
      this.loginClient = var1;
   }

   static AccessToken createAccessTokenFromNativeLogin(Bundle var0, AccessTokenSource var1, String var2) {
      Object var3 = null;
      Date var4 = Utility.getBundleLongAsDate(var0, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
      ArrayList var5 = var0.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
      String var6 = var0.getString("com.facebook.platform.extra.ACCESS_TOKEN");
      AccessToken var7;
      if (Utility.isNullOrEmpty(var6)) {
         var7 = (AccessToken)var3;
      } else {
         var7 = new AccessToken(var6, var2, var0.getString("com.facebook.platform.extra.USER_ID"), var5, null, var1, var4, new Date());
      }

      return var7;
   }

   public static AccessToken createAccessTokenFromWebBundle(Collection<String> var0, Bundle var1, AccessTokenSource var2, String var3) throws FacebookException {
      Object var5 = null;
      Date var6 = Utility.getBundleLongAsDate(var1, "expires_in", new Date());
      String var7 = var1.getString("access_token");
      String var4 = var1.getString("granted_scopes");
      if (!Utility.isNullOrEmpty(var4)) {
         var0 = new ArrayList<>(Arrays.asList(var4.split(",")));
      }

      var4 = var1.getString("denied_scopes");
      ArrayList var10;
      if (!Utility.isNullOrEmpty(var4)) {
         var10 = new ArrayList<>(Arrays.asList(var4.split(",")));
      } else {
         var10 = null;
      }

      AccessToken var8;
      if (Utility.isNullOrEmpty(var7)) {
         var8 = (AccessToken)var5;
      } else {
         var8 = new AccessToken(var7, var3, getUserIDFromSignedRequest(var1.getString("signed_request")), var0, var10, var2, var6, new Date());
      }

      return var8;
   }

   private static String getUserIDFromSignedRequest(String var0) throws FacebookException {
      if (var0 != null && !var0.isEmpty()) {
         try {
            String[] var4 = var0.split("\\.");
            if (var4.length == 2) {
               byte[] var1 = Base64.decode(var4[1], 0);
               var0 = new String(var1, "UTF-8");
               JSONObject var6 = new JSONObject(var0);
               return var6.getString("user_id");
            }
         } catch (UnsupportedEncodingException var2) {
         } catch (JSONException var3) {
         }

         throw new FacebookException("Failed to retrieve user_id from signed_request");
      } else {
         throw new FacebookException("Authorization response does not contain the signed_request");
      }
   }

   protected void addLoggingExtra(String var1, Object var2) {
      if (this.methodLoggingExtras == null) {
         this.methodLoggingExtras = new HashMap<>();
      }

      Map var3 = this.methodLoggingExtras;
      if (var2 == null) {
         var2 = null;
      } else {
         var2 = var2.toString();
      }

      var3.put(var1, var2);
   }

   void cancel() {
   }

   protected String getClientState(String var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("0_auth_logger_id", var1);
         var2.put("3_method", this.getNameForLogging());
         this.putChallengeParam(var2);
      } catch (JSONException var3) {
         Log.w("LoginMethodHandler", "Error creating client state json: " + var3.getMessage());
      }

      return var2.toString();
   }

   abstract String getNameForLogging();

   protected void logWebLoginCompleted(String var1) {
      String var2 = this.loginClient.getPendingRequest().getApplicationId();
      AppEventsLogger var4 = AppEventsLogger.newLogger(this.loginClient.getActivity(), var2);
      Bundle var3 = new Bundle();
      var3.putString("fb_web_login_e2e", var1);
      var3.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
      var3.putString("app_id", var2);
      var4.logSdkEvent("fb_dialogs_web_login_dialog_complete", null, var3);
   }

   boolean needsInternetPermission() {
      return false;
   }

   boolean onActivityResult(int var1, int var2, Intent var3) {
      return false;
   }

   void putChallengeParam(JSONObject var1) throws JSONException {
   }

   void setLoginClient(LoginClient var1) {
      if (this.loginClient != null) {
         throw new FacebookException("Can't set LoginClient if it is already set.");
      }

      this.loginClient = var1;
   }

   abstract boolean tryAuthorize(LoginClient.Request var1);

   public void writeToParcel(Parcel var1, int var2) {
      Utility.writeStringMapToParcel(var1, this.methodLoggingExtras);
   }
}
