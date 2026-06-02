package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger {
   static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
   static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
   static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
   static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
   static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
   static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
   static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
   static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
   static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
   static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
   static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
   static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
   static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
   static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
   static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
   static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
   static final String EVENT_PARAM_CHALLENGE = "7_challenge";
   static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
   static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
   static final String EVENT_PARAM_EXTRAS = "6_extras";
   static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
   static final String EVENT_PARAM_METHOD = "3_method";
   static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
   static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
   static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
   private final AppEventsLogger appEventsLogger;
   private String applicationId;
   private String facebookVersion;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   LoginLogger(Context var1, String var2) {
      this.applicationId = var2;
      this.appEventsLogger = AppEventsLogger.newLogger(var1, var2);

      try {
         var6 = var1.getPackageManager();
      } catch (NameNotFoundException var5) {
         return;
      }

      if (var6 != null) {
         try {
            var7 = var6.getPackageInfo("com.facebook.katana", 0);
         } catch (NameNotFoundException var4) {
            return;
         }

         if (var7 != null) {
            try {
               this.facebookVersion = var7.versionName;
            } catch (NameNotFoundException var3) {
            }
         }
      }
   }

   static Bundle newAuthorizationLoggingBundle(String var0) {
      Bundle var1 = new Bundle();
      var1.putLong("1_timestamp_ms", System.currentTimeMillis());
      var1.putString("0_auth_logger_id", var0);
      var1.putString("3_method", "");
      var1.putString("2_result", "");
      var1.putString("5_error_message", "");
      var1.putString("4_error_code", "");
      var1.putString("6_extras", "");
      return var1;
   }

   public String getApplicationId() {
      return this.applicationId;
   }

   public void logAuthorizationMethodComplete(String var1, String var2, String var3, String var4, String var5, Map<String, String> var6) {
      Bundle var7 = newAuthorizationLoggingBundle(var1);
      if (var3 != null) {
         var7.putString("2_result", var3);
      }

      if (var4 != null) {
         var7.putString("5_error_message", var4);
      }

      if (var5 != null) {
         var7.putString("4_error_code", var5);
      }

      if (var6 != null && !var6.isEmpty()) {
         var7.putString("6_extras", new JSONObject(var6).toString());
      }

      var7.putString("3_method", var2);
      this.appEventsLogger.logSdkEvent("fb_mobile_login_method_complete", null, var7);
   }

   public void logAuthorizationMethodNotTried(String var1, String var2) {
      Bundle var3 = newAuthorizationLoggingBundle(var1);
      var3.putString("3_method", var2);
      this.appEventsLogger.logSdkEvent("fb_mobile_login_method_not_tried", null, var3);
   }

   public void logAuthorizationMethodStart(String var1, String var2) {
      Bundle var3 = newAuthorizationLoggingBundle(var1);
      var3.putString("3_method", var2);
      this.appEventsLogger.logSdkEvent("fb_mobile_login_method_start", null, var3);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void logCompleteLogin(String var1, Map<String, String> var2, LoginClient.Result.Code var3, Map<String, String> var4, Exception var5) {
      Bundle var6 = newAuthorizationLoggingBundle(var1);
      if (var3 != null) {
         var6.putString("2_result", var3.getLoggingValue());
      }

      if (var5 != null && var5.getMessage() != null) {
         var6.putString("5_error_message", var5.getMessage());
      }

      JSONObject var9;
      if (!var2.isEmpty()) {
         var9 = new JSONObject(var2);
      } else {
         var9 = null;
      }

      var10 = var9;
      label46:
      if (var4 != null) {
         if (var9 == null) {
            var9 = new JSONObject();
         }

         try {
            var12 = var4.entrySet().iterator();
         } catch (JSONException var7) {
            var10 = var9;
            break label46;
         }

         while (true) {
            try {
               if (!var12.hasNext()) {
                  break;
               }

               Entry var11 = (Entry)var12.next();
               var9.put((String)var11.getKey(), var11.getValue());
            } catch (JSONException var8) {
               var10 = var9;
               break label46;
            }
         }

         var10 = var9;
      }

      if (var10 != null) {
         var6.putString("6_extras", var10.toString());
      }

      this.appEventsLogger.logSdkEvent("fb_mobile_login_complete", null, var6);
   }

   public void logStartLogin(LoginClient.Request var1) {
      Bundle var2 = newAuthorizationLoggingBundle(var1.getAuthId());

      try {
         JSONObject var3 = new JSONObject();
         var3.put("login_behavior", var1.getLoginBehavior().toString());
         var3.put("request_code", LoginClient.getLoginRequestCode());
         var3.put("permissions", TextUtils.join(",", var1.getPermissions()));
         var3.put("default_audience", var1.getDefaultAudience().toString());
         var3.put("isReauthorize", var1.isRerequest());
         if (this.facebookVersion != null) {
            var3.put("facebookVersion", this.facebookVersion);
         }

         var2.putString("6_extras", var3.toString());
      } catch (JSONException var4) {
      }

      this.appEventsLogger.logSdkEvent("fb_mobile_login_start", null, var2);
   }

   public void logUnexpectedError(String var1, String var2) {
      this.logUnexpectedError(var1, var2, "");
   }

   public void logUnexpectedError(String var1, String var2, String var3) {
      Bundle var4 = newAuthorizationLoggingBundle("");
      var4.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
      var4.putString("5_error_message", var2);
      var4.putString("3_method", var3);
      this.appEventsLogger.logSdkEvent(var1, null, var4);
   }
}
