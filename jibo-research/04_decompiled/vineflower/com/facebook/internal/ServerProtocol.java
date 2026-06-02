package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import org.json.JSONException;

public final class ServerProtocol {
   private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
   public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
   public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
   public static final String DIALOG_PARAM_APP_ID = "app_id";
   public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
   public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
   public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
   public static final String DIALOG_PARAM_DISPLAY = "display";
   public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
   public static final String DIALOG_PARAM_E2E = "e2e";
   public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
   public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
   public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
   public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
   public static final String DIALOG_PARAM_SCOPE = "scope";
   public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
   public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
   public static final String DIALOG_PARAM_STATE = "state";
   public static final String DIALOG_PATH = "dialog/";
   public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
   public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
   public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request";
   public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
   public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
   public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
   public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
   public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
   public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
   public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
   public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
   private static final String GRAPH_API_VERSION = "v2.8";
   private static final String GRAPH_URL_FORMAT = "https://graph.%s";
   private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
   private static final String TAG = ServerProtocol.class.getName();
   public static final String errorConnectionFailure = "CONNECTION_FAILURE";
   public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
   public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection("access_denied", "OAuthAccessDeniedException");

   public static final String getDefaultAPIVersion() {
      return "v2.8";
   }

   public static final String getDialogAuthority() {
      return String.format("m.%s", FacebookSdk.getFacebookDomain());
   }

   public static final String getGraphUrlBase() {
      return String.format("https://graph.%s", FacebookSdk.getFacebookDomain());
   }

   public static final String getGraphVideoUrlBase() {
      return String.format("https://graph-video.%s", FacebookSdk.getFacebookDomain());
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String var0, int var1, Bundle var2) {
      Object var3 = null;
      String var5 = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
      Bundle var8;
      if (Utility.isNullOrEmpty(var5)) {
         var8 = (Bundle)var3;
      } else {
         Bundle var4 = new Bundle();
         var4.putString("android_key_hash", var5);
         var4.putString("app_id", FacebookSdk.getApplicationId());
         var4.putInt("version", var1);
         var4.putString("display", "touch");
         Bundle var11 = new Bundle();
         var11.putString("action_id", var0);
         Bundle var9 = var2;
         if (var2 == null) {
            var9 = new Bundle();
         }

         try {
            var10 = BundleJSONConverter.convertToJSON(var11);
            var12 = BundleJSONConverter.convertToJSON(var9);
         } catch (JSONException var7) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + var7);
            Object var13 = null;
            return (Bundle)var13;
         }

         var8 = (Bundle)var3;
         if (var10 != null) {
            var8 = (Bundle)var3;
            if (var12 != null) {
               try {
                  var4.putString("bridge_args", var10.toString());
                  var4.putString("method_args", var12.toString());
               } catch (JSONException var6) {
                  Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + var6);
                  Object var14 = null;
                  return (Bundle)var14;
               }

               var8 = var4;
            }
         }
      }

      return var8;
   }
}
