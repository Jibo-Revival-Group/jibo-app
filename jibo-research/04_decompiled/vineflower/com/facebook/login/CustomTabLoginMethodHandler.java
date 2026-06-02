package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
   private static final int API_EC_DIALOG_CANCEL = 4201;
   private static final int CHALLENGE_LENGTH = 20;
   private static final String[] CHROME_PACKAGES = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
   public static final Creator<CustomTabLoginMethodHandler> CREATOR = new Creator() {
      public CustomTabLoginMethodHandler createFromParcel(Parcel var1) {
         return new CustomTabLoginMethodHandler(var1);
      }

      public CustomTabLoginMethodHandler[] newArray(int var1) {
         return new CustomTabLoginMethodHandler[var1];
      }
   };
   private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
   private static final int CUSTOM_TAB_REQUEST_CODE = 1;
   private String currentPackage;
   private String expectedChallenge;

   CustomTabLoginMethodHandler(Parcel var1) {
      super(var1);
      this.expectedChallenge = var1.readString();
   }

   CustomTabLoginMethodHandler(LoginClient var1) {
      super(var1);
      this.expectedChallenge = Utility.generateRandomString(20);
   }

   private String getChromePackage() {
      String var1;
      if (this.currentPackage != null) {
         var1 = this.currentPackage;
      } else {
         FragmentActivity var4 = this.loginClient.getActivity();
         Intent var2 = new Intent("android.support.customtabs.action.CustomTabsService");
         List var6 = var4.getPackageManager().queryIntentServices(var2, 0);
         if (var6 != null) {
            HashSet var5 = new HashSet<>(Arrays.asList(CHROME_PACKAGES));
            Iterator var3 = var6.iterator();

            while (var3.hasNext()) {
               ServiceInfo var7 = ((ResolveInfo)var3.next()).serviceInfo;
               if (var7 != null && var5.contains(var7.packageName)) {
                  this.currentPackage = var7.packageName;
                  var1 = this.currentPackage;
                  return var1;
               }
            }
         }

         var1 = null;
      }

      return var1;
   }

   private boolean isCustomTabsAllowed() {
      boolean var1;
      if (this.isCustomTabsEnabled() && this.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean isCustomTabsEnabled() {
      FetchedAppSettings var2 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(Utility.getMetadataApplicationId(this.loginClient.getActivity()));
      boolean var1;
      if (var2 != null && var2.getCustomTabsEnabled()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void onCustomTabComplete(String var1, LoginClient.Request var2) {
      if (var1 != null && var1.startsWith(CustomTabMainActivity.getRedirectUrl())) {
         Uri var8 = Uri.parse(var1);
         Bundle var6 = Utility.parseUrlQueryString(var8.getQuery());
         var6.putAll(Utility.parseUrlQueryString(var8.getFragment()));
         if (!this.validateChallengeParam(var6)) {
            super.onComplete(var2, null, new FacebookException("Invalid state parameter"));
         } else {
            var1 = var6.getString("error");
            String var4 = var1;
            if (var1 == null) {
               var4 = var6.getString("error_type");
            }

            String var5 = var6.getString("error_msg");
            var1 = var5;
            if (var5 == null) {
               var1 = var6.getString("error_message");
            }

            var5 = var1;
            if (var1 == null) {
               var5 = var6.getString("error_description");
            }

            var1 = var6.getString("error_code");
            int var3;
            if (!Utility.isNullOrEmpty(var1)) {
               try {
                  var3 = Integer.parseInt(var1);
               } catch (NumberFormatException var7) {
                  var3 = -1;
               }
            } else {
               var3 = -1;
            }

            if (Utility.isNullOrEmpty(var4) && Utility.isNullOrEmpty(var5) && var3 == -1) {
               super.onComplete(var2, var6, null);
            } else if (var4 == null || !var4.equals("access_denied") && !var4.equals("OAuthAccessDeniedException")) {
               if (var3 == 4201) {
                  super.onComplete(var2, null, new FacebookOperationCanceledException());
               } else {
                  super.onComplete(var2, null, new FacebookServiceException(new FacebookRequestError(var3, var4, var5), var5));
               }
            } else {
               super.onComplete(var2, null, new FacebookOperationCanceledException());
            }
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean validateChallengeParam(Bundle var1) {
      boolean var3 = false;

      try {
         var7 = var1.getString("state");
      } catch (JSONException var6) {
         return var3;
      }

      boolean var2;
      if (var7 == null) {
         var2 = var3;
      } else {
         try {
            JSONObject var4 = new JSONObject(var7);
            var2 = var4.getString("7_challenge").equals(this.expectedChallenge);
         } catch (JSONException var5) {
            var2 = var3;
         }
      }

      return var2;
   }

   public int describeContents() {
      return 0;
   }

   @Override
   String getNameForLogging() {
      return "custom_tab";
   }

   @Override
   protected String getSSODevice() {
      return "chrome_custom_tab";
   }

   @Override
   AccessTokenSource getTokenSource() {
      return AccessTokenSource.CHROME_CUSTOM_TAB;
   }

   @Override
   boolean onActivityResult(int var1, int var2, Intent var3) {
      boolean var4 = true;
      if (var1 != 1) {
         var4 = super.onActivityResult(var1, var2, var3);
      } else {
         LoginClient.Request var5 = this.loginClient.getPendingRequest();
         if (var2 == -1) {
            this.onCustomTabComplete(var3.getStringExtra(CustomTabMainActivity.EXTRA_URL), var5);
         } else {
            super.onComplete(var5, null, new FacebookOperationCanceledException());
            var4 = false;
         }
      }

      return var4;
   }

   @Override
   protected void putChallengeParam(JSONObject var1) throws JSONException {
      var1.put("7_challenge", this.expectedChallenge);
   }

   @Override
   boolean tryAuthorize(LoginClient.Request var1) {
      boolean var2 = true;
      if (!this.isCustomTabsAllowed()) {
         var2 = false;
      } else {
         Bundle var4 = this.addExtraParameters(this.getParameters(var1), var1);
         Intent var3 = new Intent(this.loginClient.getActivity(), CustomTabMainActivity.class);
         var3.putExtra(CustomTabMainActivity.EXTRA_PARAMS, var4);
         var3.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, this.getChromePackage());
         this.loginClient.getFragment().startActivityForResult(var3, 1);
      }

      return var2;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.expectedChallenge);
   }
}
