package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler extends LoginMethodHandler {
   public static final Creator<GetTokenLoginMethodHandler> CREATOR = new Creator() {
      public GetTokenLoginMethodHandler createFromParcel(Parcel var1) {
         return new GetTokenLoginMethodHandler(var1);
      }

      public GetTokenLoginMethodHandler[] newArray(int var1) {
         return new GetTokenLoginMethodHandler[var1];
      }
   };
   private GetTokenClient getTokenClient;

   GetTokenLoginMethodHandler(Parcel var1) {
      super(var1);
   }

   GetTokenLoginMethodHandler(LoginClient var1) {
      super(var1);
   }

   @Override
   void cancel() {
      if (this.getTokenClient != null) {
         this.getTokenClient.cancel();
         this.getTokenClient.setCompletedListener(null);
         this.getTokenClient = null;
      }
   }

   void complete(LoginClient.Request var1, Bundle var2) {
      String var3 = var2.getString("com.facebook.platform.extra.USER_ID");
      if (var3 != null && !var3.isEmpty()) {
         this.onComplete(var1, var2);
      } else {
         this.loginClient.notifyBackgroundProcessingStart();
         Utility.getGraphMeRequestWithCacheAsync(
            var2.getString("com.facebook.platform.extra.ACCESS_TOKEN"),
            new Utility.GraphMeRequestWithCacheCallback(this, var2, var1) {
               final GetTokenLoginMethodHandler this$0;
               final LoginClient.Request val$request;
               final Bundle val$result;

               {
                  this.this$0 = var1;
                  this.val$result = var2x;
                  this.val$request = var3x;
               }

               @Override
               public void onFailure(FacebookException var1) {
                  this.this$0
                     .loginClient
                     .complete(LoginClient.Result.createErrorResult(this.this$0.loginClient.getPendingRequest(), "Caught exception", var1.getMessage()));
               }

               @Override
               public void onSuccess(JSONObject var1) {
                  try {
                     String var3x = var1.getString("id");
                     this.val$result.putString("com.facebook.platform.extra.USER_ID", var3x);
                     this.this$0.onComplete(this.val$request, this.val$result);
                  } catch (JSONException var2x) {
                     this.this$0
                        .loginClient
                        .complete(LoginClient.Result.createErrorResult(this.this$0.loginClient.getPendingRequest(), "Caught exception", var2x.getMessage()));
                  }
               }
            }
         );
      }
   }

   public int describeContents() {
      return 0;
   }

   @Override
   String getNameForLogging() {
      return "get_token";
   }

   void getTokenCompleted(LoginClient.Request var1, Bundle var2) {
      if (this.getTokenClient != null) {
         this.getTokenClient.setCompletedListener(null);
      }

      this.getTokenClient = null;
      this.loginClient.notifyBackgroundProcessingStop();
      if (var2 != null) {
         ArrayList var3 = var2.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
         Set var4 = var1.getPermissions();
         if (var3 != null && (var4 == null || var3.containsAll(var4))) {
            this.complete(var1, var2);
            return;
         }

         HashSet var6 = new HashSet();

         for (String var7 : var4) {
            if (!var3.contains(var7)) {
               var6.add(var7);
            }
         }

         if (!var6.isEmpty()) {
            this.addLoggingExtra("new_permissions", TextUtils.join(",", var6));
         }

         var1.setPermissions(var6);
      }

      this.loginClient.tryNextHandler();
   }

   void onComplete(LoginClient.Request var1, Bundle var2) {
      AccessToken var3 = createAccessTokenFromNativeLogin(var2, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, var1.getApplicationId());
      LoginClient.Result var4 = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), var3);
      this.loginClient.completeAndValidate(var4);
   }

   @Override
   boolean tryAuthorize(LoginClient.Request var1) {
      this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), var1.getApplicationId());
      boolean var2;
      if (!this.getTokenClient.start()) {
         var2 = false;
      } else {
         this.loginClient.notifyBackgroundProcessingStart();
         PlatformServiceClient.CompletedListener var3 = new PlatformServiceClient.CompletedListener(this, var1) {
            final GetTokenLoginMethodHandler this$0;
            final LoginClient.Request val$request;

            {
               this.this$0 = var1;
               this.val$request = var2x;
            }

            @Override
            public void completed(Bundle var1) {
               this.this$0.getTokenCompleted(this.val$request, var1);
            }
         };
         this.getTokenClient.setCompletedListener(var3);
         var2 = true;
      }

      return var2;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
   }
}
