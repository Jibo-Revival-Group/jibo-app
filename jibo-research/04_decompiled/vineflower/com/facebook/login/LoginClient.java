package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient implements Parcelable {
   public static final Creator<LoginClient> CREATOR = new Creator() {
      public LoginClient createFromParcel(Parcel var1) {
         return new LoginClient(var1);
      }

      public LoginClient[] newArray(int var1) {
         return new LoginClient[var1];
      }
   };
   LoginClient.BackgroundProcessingListener backgroundProcessingListener;
   boolean checkedInternetPermission;
   int currentHandler = -1;
   Fragment fragment;
   LoginMethodHandler[] handlersToTry;
   Map<String, String> loggingExtras;
   private LoginLogger loginLogger;
   LoginClient.OnCompletedListener onCompletedListener;
   LoginClient.Request pendingRequest;

   public LoginClient(Parcel var1) {
      Parcelable[] var3 = var1.readParcelableArray(LoginMethodHandler.class.getClassLoader());
      this.handlersToTry = new LoginMethodHandler[var3.length];

      for (int var2 = 0; var2 < var3.length; var2++) {
         this.handlersToTry[var2] = (LoginMethodHandler)var3[var2];
         this.handlersToTry[var2].setLoginClient(this);
      }

      this.currentHandler = var1.readInt();
      this.pendingRequest = (LoginClient.Request)var1.readParcelable(LoginClient.Request.class.getClassLoader());
      this.loggingExtras = Utility.readStringMapFromParcel(var1);
   }

   public LoginClient(Fragment var1) {
      this.fragment = var1;
   }

   private void addLoggingExtra(String var1, String var2, boolean var3) {
      if (this.loggingExtras == null) {
         this.loggingExtras = new HashMap<>();
      }

      String var4 = var2;
      if (this.loggingExtras.containsKey(var1)) {
         var4 = var2;
         if (var3) {
            var4 = this.loggingExtras.get(var1) + "," + var2;
         }
      }

      this.loggingExtras.put(var1, var4);
   }

   private void completeWithFailure() {
      this.complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
   }

   private static AccessToken createFromTokenWithRefreshedPermissions(AccessToken var0, Collection<String> var1, Collection<String> var2) {
      return new AccessToken(var0.getToken(), var0.getApplicationId(), var0.getUserId(), var1, var2, var0.getSource(), var0.getExpires(), var0.getLastRefresh());
   }

   static String getE2E() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("init", System.currentTimeMillis());
      } catch (JSONException var2) {
      }

      return var1.toString();
   }

   private LoginLogger getLogger() {
      if (this.loginLogger == null || !this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())) {
         this.loginLogger = new LoginLogger(this.getActivity(), this.pendingRequest.getApplicationId());
      }

      return this.loginLogger;
   }

   public static int getLoginRequestCode() {
      return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
   }

   private void logAuthorizationMethodComplete(String var1, LoginClient.Result var2, Map<String, String> var3) {
      this.logAuthorizationMethodComplete(var1, var2.code.getLoggingValue(), var2.errorMessage, var2.errorCode, var3);
   }

   private void logAuthorizationMethodComplete(String var1, String var2, String var3, String var4, Map<String, String> var5) {
      if (this.pendingRequest == null) {
         this.getLogger()
            .logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", var1);
      } else {
         this.getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), var1, var2, var3, var4, var5);
      }
   }

   private void notifyOnCompleteListener(LoginClient.Result var1) {
      if (this.onCompletedListener != null) {
         this.onCompletedListener.onCompleted(var1);
      }
   }

   void authorize(LoginClient.Request var1) {
      if (var1 != null) {
         if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
         }

         if (AccessToken.getCurrentAccessToken() == null || this.checkInternetPermission()) {
            this.pendingRequest = var1;
            this.handlersToTry = this.getHandlersToTry(var1);
            this.tryNextHandler();
         }
      }
   }

   void cancelCurrentHandler() {
      if (this.currentHandler >= 0) {
         this.getCurrentHandler().cancel();
      }
   }

   boolean checkInternetPermission() {
      boolean var1 = true;
      if (!this.checkedInternetPermission) {
         if (this.checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity var3 = this.getActivity();
            String var2 = var3.getString(R.string.com_facebook_internet_permission_error_title);
            String var4 = var3.getString(R.string.com_facebook_internet_permission_error_message);
            this.complete(LoginClient.Result.createErrorResult(this.pendingRequest, var2, var4));
            var1 = false;
         } else {
            this.checkedInternetPermission = true;
         }
      }

      return var1;
   }

   int checkPermission(String var1) {
      return this.getActivity().checkCallingOrSelfPermission(var1);
   }

   void complete(LoginClient.Result var1) {
      LoginMethodHandler var2 = this.getCurrentHandler();
      if (var2 != null) {
         this.logAuthorizationMethodComplete(var2.getNameForLogging(), var1, var2.methodLoggingExtras);
      }

      if (this.loggingExtras != null) {
         var1.loggingExtras = this.loggingExtras;
      }

      this.handlersToTry = null;
      this.currentHandler = -1;
      this.pendingRequest = null;
      this.loggingExtras = null;
      this.notifyOnCompleteListener(var1);
   }

   void completeAndValidate(LoginClient.Result var1) {
      if (var1.token != null && AccessToken.getCurrentAccessToken() != null) {
         this.validateSameFbidAndFinish(var1);
      } else {
         this.complete(var1);
      }
   }

   public int describeContents() {
      return 0;
   }

   FragmentActivity getActivity() {
      return this.fragment.getActivity();
   }

   LoginClient.BackgroundProcessingListener getBackgroundProcessingListener() {
      return this.backgroundProcessingListener;
   }

   LoginMethodHandler getCurrentHandler() {
      LoginMethodHandler var1;
      if (this.currentHandler >= 0) {
         var1 = this.handlersToTry[this.currentHandler];
      } else {
         var1 = null;
      }

      return var1;
   }

   public Fragment getFragment() {
      return this.fragment;
   }

   protected LoginMethodHandler[] getHandlersToTry(LoginClient.Request var1) {
      ArrayList var2 = new ArrayList();
      LoginBehavior var3 = var1.getLoginBehavior();
      if (var3.allowsGetTokenAuth()) {
         var2.add(new GetTokenLoginMethodHandler(this));
      }

      if (var3.allowsKatanaAuth()) {
         var2.add(new KatanaProxyLoginMethodHandler(this));
      }

      if (var3.allowsFacebookLiteAuth()) {
         var2.add(new FacebookLiteLoginMethodHandler(this));
      }

      if (var3.allowsCustomTabAuth()) {
         var2.add(new CustomTabLoginMethodHandler(this));
      }

      if (var3.allowsWebViewAuth()) {
         var2.add(new WebViewLoginMethodHandler(this));
      }

      if (var3.allowsDeviceAuth()) {
         var2.add(new DeviceAuthMethodHandler(this));
      }

      LoginMethodHandler[] var4 = new LoginMethodHandler[var2.size()];
      var2.toArray(var4);
      return var4;
   }

   boolean getInProgress() {
      boolean var1;
      if (this.pendingRequest != null && this.currentHandler >= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   LoginClient.OnCompletedListener getOnCompletedListener() {
      return this.onCompletedListener;
   }

   public LoginClient.Request getPendingRequest() {
      return this.pendingRequest;
   }

   void notifyBackgroundProcessingStart() {
      if (this.backgroundProcessingListener != null) {
         this.backgroundProcessingListener.onBackgroundProcessingStarted();
      }
   }

   void notifyBackgroundProcessingStop() {
      if (this.backgroundProcessingListener != null) {
         this.backgroundProcessingListener.onBackgroundProcessingStopped();
      }
   }

   public boolean onActivityResult(int var1, int var2, Intent var3) {
      boolean var4;
      if (this.pendingRequest != null) {
         var4 = this.getCurrentHandler().onActivityResult(var1, var2, var3);
      } else {
         var4 = false;
      }

      return var4;
   }

   void setBackgroundProcessingListener(LoginClient.BackgroundProcessingListener var1) {
      this.backgroundProcessingListener = var1;
   }

   void setFragment(Fragment var1) {
      if (this.fragment != null) {
         throw new FacebookException("Can't set fragment once it is already set.");
      }

      this.fragment = var1;
   }

   void setOnCompletedListener(LoginClient.OnCompletedListener var1) {
      this.onCompletedListener = var1;
   }

   void startOrContinueAuth(LoginClient.Request var1) {
      if (!this.getInProgress()) {
         this.authorize(var1);
      }
   }

   boolean tryCurrentHandler() {
      boolean var1 = false;
      LoginMethodHandler var2 = this.getCurrentHandler();
      if (var2.needsInternetPermission() && !this.checkInternetPermission()) {
         this.addLoggingExtra("no_internet_permission", "1", false);
      } else {
         var1 = var2.tryAuthorize(this.pendingRequest);
         if (var1) {
            this.getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), var2.getNameForLogging());
         } else {
            this.getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), var2.getNameForLogging());
            this.addLoggingExtra("not_tried", var2.getNameForLogging(), true);
         }
      }

      return var1;
   }

   void tryNextHandler() {
      if (this.currentHandler >= 0) {
         this.logAuthorizationMethodComplete(this.getCurrentHandler().getNameForLogging(), "skipped", null, null, this.getCurrentHandler().methodLoggingExtras);
      }

      do {
         if (this.handlersToTry == null || this.currentHandler >= this.handlersToTry.length - 1) {
            if (this.pendingRequest != null) {
               this.completeWithFailure();
            }
            break;
         }

         this.currentHandler++;
      } while (!this.tryCurrentHandler());
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   void validateSameFbidAndFinish(LoginClient.Result var1) {
      if (var1.token == null) {
         throw new FacebookException("Can't validate without a token");
      }

      label36: {
         AccessToken var3 = AccessToken.getCurrentAccessToken();
         AccessToken var2 = var1.token;
         if (var3 != null && var2 != null) {
            try {
               if (var3.getUserId().equals(var2.getUserId())) {
                  var1 = LoginClient.Result.createTokenResult(this.pendingRequest, var1.token);
                  break label36;
               }
            } catch (Exception var6) {
               this.complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Caught exception", var6.getMessage()));
               return;
            }
         }

         try {
            var1 = LoginClient.Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
         } catch (Exception var5) {
            this.complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Caught exception", var5.getMessage()));
            return;
         }
      }

      try {
         this.complete(var1);
      } catch (Exception var4) {
         this.complete(LoginClient.Result.createErrorResult(this.pendingRequest, "Caught exception", var4.getMessage()));
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeParcelableArray(this.handlersToTry, var2);
      var1.writeInt(this.currentHandler);
      var1.writeParcelable(this.pendingRequest, var2);
      Utility.writeStringMapToParcel(var1, this.loggingExtras);
   }

   interface BackgroundProcessingListener {
      void onBackgroundProcessingStarted();

      void onBackgroundProcessingStopped();
   }

   public interface OnCompletedListener {
      void onCompleted(LoginClient.Result var1);
   }

   public static class Request implements Parcelable {
      public static final Creator<LoginClient.Request> CREATOR = new Creator() {
         public LoginClient.Request createFromParcel(Parcel var1) {
            return new LoginClient.Request(var1);
         }

         public LoginClient.Request[] newArray(int var1) {
            return new LoginClient.Request[var1];
         }
      };
      private final String applicationId;
      private final String authId;
      private final DefaultAudience defaultAudience;
      private String deviceRedirectUriString;
      private boolean isRerequest = false;
      private final LoginBehavior loginBehavior;
      private Set<String> permissions;

      private Request(Parcel var1) {
         Object var4 = null;
         super();
         this.isRerequest = false;
         String var3 = var1.readString();
         LoginBehavior var6;
         if (var3 != null) {
            var6 = LoginBehavior.valueOf(var3);
         } else {
            var6 = null;
         }

         this.loginBehavior = var6;
         ArrayList var7 = new ArrayList();
         var1.readStringList(var7);
         this.permissions = new HashSet<>(var7);
         String var5 = var1.readString();
         DefaultAudience var8 = (DefaultAudience)var4;
         if (var5 != null) {
            var8 = DefaultAudience.valueOf(var5);
         }

         this.defaultAudience = var8;
         this.applicationId = var1.readString();
         this.authId = var1.readString();
         boolean var2;
         if (var1.readByte() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.isRerequest = var2;
         this.deviceRedirectUriString = var1.readString();
      }

      Request(LoginBehavior var1, Set<String> var2, DefaultAudience var3, String var4, String var5) {
         this.loginBehavior = var1;
         if (var2 == null) {
            var2 = new HashSet();
         }

         this.permissions = var2;
         this.defaultAudience = var3;
         this.applicationId = var4;
         this.authId = var5;
      }

      public int describeContents() {
         return 0;
      }

      String getApplicationId() {
         return this.applicationId;
      }

      String getAuthId() {
         return this.authId;
      }

      DefaultAudience getDefaultAudience() {
         return this.defaultAudience;
      }

      String getDeviceRedirectUriString() {
         return this.deviceRedirectUriString;
      }

      LoginBehavior getLoginBehavior() {
         return this.loginBehavior;
      }

      Set<String> getPermissions() {
         return this.permissions;
      }

      boolean hasPublishPermission() {
         Iterator var2 = this.permissions.iterator();

         boolean var1;
         while (true) {
            if (var2.hasNext()) {
               if (!LoginManager.isPublishPermission((String)var2.next())) {
                  continue;
               }

               var1 = true;
               break;
            }

            var1 = false;
            break;
         }

         return var1;
      }

      boolean isRerequest() {
         return this.isRerequest;
      }

      void setDeviceRedirectUriString(String var1) {
         this.deviceRedirectUriString = var1;
      }

      void setPermissions(Set<String> var1) {
         Validate.notNull(var1, "permissions");
         this.permissions = var1;
      }

      void setRerequest(boolean var1) {
         this.isRerequest = var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         Object var4 = null;
         String var3;
         if (this.loginBehavior != null) {
            var3 = this.loginBehavior.name();
         } else {
            var3 = null;
         }

         var1.writeString(var3);
         var1.writeStringList(new ArrayList<>(this.permissions));
         var3 = (String)var4;
         if (this.defaultAudience != null) {
            var3 = this.defaultAudience.name();
         }

         var1.writeString(var3);
         var1.writeString(this.applicationId);
         var1.writeString(this.authId);
         byte var5;
         if (this.isRerequest) {
            var5 = 1;
         } else {
            var5 = 0;
         }

         var1.writeByte((byte)var5);
         var1.writeString(this.deviceRedirectUriString);
      }
   }

   public static class Result implements Parcelable {
      public static final Creator<LoginClient.Result> CREATOR = new Creator() {
         public LoginClient.Result createFromParcel(Parcel var1) {
            return new LoginClient.Result(var1);
         }

         public LoginClient.Result[] newArray(int var1) {
            return new LoginClient.Result[var1];
         }
      };
      final LoginClient.Result.Code code;
      final String errorCode;
      final String errorMessage;
      public Map<String, String> loggingExtras;
      final LoginClient.Request request;
      final AccessToken token;

      private Result(Parcel var1) {
         this.code = LoginClient.Result.Code.valueOf(var1.readString());
         this.token = (AccessToken)var1.readParcelable(AccessToken.class.getClassLoader());
         this.errorMessage = var1.readString();
         this.errorCode = var1.readString();
         this.request = (LoginClient.Request)var1.readParcelable(LoginClient.Request.class.getClassLoader());
         this.loggingExtras = Utility.readStringMapFromParcel(var1);
      }

      Result(LoginClient.Request var1, LoginClient.Result.Code var2, AccessToken var3, String var4, String var5) {
         Validate.notNull(var2, "code");
         this.request = var1;
         this.token = var3;
         this.errorMessage = var4;
         this.code = var2;
         this.errorCode = var5;
      }

      static LoginClient.Result createCancelResult(LoginClient.Request var0, String var1) {
         return new LoginClient.Result(var0, LoginClient.Result.Code.CANCEL, null, var1, null);
      }

      static LoginClient.Result createErrorResult(LoginClient.Request var0, String var1, String var2) {
         return createErrorResult(var0, var1, var2, null);
      }

      static LoginClient.Result createErrorResult(LoginClient.Request var0, String var1, String var2, String var3) {
         var1 = TextUtils.join(": ", Utility.asListNoNulls(var1, var2));
         return new LoginClient.Result(var0, LoginClient.Result.Code.ERROR, null, var1, var3);
      }

      static LoginClient.Result createTokenResult(LoginClient.Request var0, AccessToken var1) {
         return new LoginClient.Result(var0, LoginClient.Result.Code.SUCCESS, var1, null, null);
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeString(this.code.name());
         var1.writeParcelable(this.token, var2);
         var1.writeString(this.errorMessage);
         var1.writeString(this.errorCode);
         var1.writeParcelable(this.request, var2);
         Utility.writeStringMapToParcel(var1, this.loggingExtras);
      }

      enum Code {
         CANCEL("cancel"),
         ERROR("error"),
         SUCCESS("success");

         private static final LoginClient.Result.Code[] $VALUES = new LoginClient.Result.Code[]{
            LoginClient.Result.Code.SUCCESS, LoginClient.Result.Code.CANCEL, LoginClient.Result.Code.ERROR
         };
         private final String loggingValue;

         Code(String var3) {
            this.loggingValue = var3;
         }

         String getLoggingValue() {
            return this.loggingValue;
         }
      }
   }
}
