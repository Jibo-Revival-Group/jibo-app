package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
   NativeAppLoginMethodHandler(Parcel var1) {
      super(var1);
   }

   NativeAppLoginMethodHandler(LoginClient var1) {
      super(var1);
   }

   private String getError(Bundle var1) {
      String var3 = var1.getString("error");
      String var2 = var3;
      if (var3 == null) {
         var2 = var1.getString("error_type");
      }

      return var2;
   }

   private String getErrorMessage(Bundle var1) {
      String var3 = var1.getString("error_message");
      String var2 = var3;
      if (var3 == null) {
         var2 = var1.getString("error_description");
      }

      return var2;
   }

   private LoginClient.Result handleResultCancel(LoginClient.Request var1, Intent var2) {
      Bundle var6 = var2.getExtras();
      String var3 = this.getError(var6);
      String var4 = var6.getString("error_code");
      LoginClient.Result var5;
      if ("CONNECTION_FAILURE".equals(var4)) {
         var5 = LoginClient.Result.createErrorResult(var1, var3, this.getErrorMessage(var6), var4);
      } else {
         var5 = LoginClient.Result.createCancelResult(var1, var3);
      }

      return var5;
   }

   private LoginClient.Result handleResultOk(LoginClient.Request var1, Intent var2) {
      Object var3 = null;
      Bundle var7 = var2.getExtras();
      String var4 = this.getError(var7);
      String var6 = var7.getString("error_code");
      String var5 = this.getErrorMessage(var7);
      String var9 = var7.getString("e2e");
      if (!Utility.isNullOrEmpty(var9)) {
         this.logWebLoginCompleted(var9);
      }

      LoginClient.Result var10;
      if (var4 == null && var6 == null && var5 == null) {
         try {
            var10 = LoginClient.Result.createTokenResult(
               var1, createAccessTokenFromWebBundle(var1.getPermissions(), var7, AccessTokenSource.FACEBOOK_APPLICATION_WEB, var1.getApplicationId())
            );
         } catch (FacebookException var8) {
            var10 = LoginClient.Result.createErrorResult(var1, null, var8.getMessage());
         }
      } else {
         var10 = (LoginClient.Result)var3;
         if (!ServerProtocol.errorsProxyAuthDisabled.contains(var4)) {
            if (ServerProtocol.errorsUserCanceled.contains(var4)) {
               var10 = LoginClient.Result.createCancelResult(var1, null);
            } else {
               var10 = LoginClient.Result.createErrorResult(var1, var4, var5, var6);
            }
         }
      }

      return var10;
   }

   @Override
   boolean onActivityResult(int var1, int var2, Intent var3) {
      LoginClient.Request var4 = this.loginClient.getPendingRequest();
      LoginClient.Result var5;
      if (var3 == null) {
         var5 = LoginClient.Result.createCancelResult(var4, "Operation canceled");
      } else if (var2 == 0) {
         var5 = this.handleResultCancel(var4, var3);
      } else if (var2 != -1) {
         var5 = LoginClient.Result.createErrorResult(var4, "Unexpected resultCode from authorization.", null);
      } else {
         var5 = this.handleResultOk(var4, var3);
      }

      if (var5 != null) {
         this.loginClient.completeAndValidate(var5);
      } else {
         this.loginClient.tryNextHandler();
      }

      return true;
   }

   @Override
   abstract boolean tryAuthorize(LoginClient.Request var1);

   protected boolean tryIntent(Intent var1, int var2) {
      boolean var3 = false;
      if (var1 != null) {
         try {
            this.loginClient.getFragment().startActivityForResult(var1, var2);
         } catch (ActivityNotFoundException var4) {
            return var3;
         }

         var3 = true;
      }

      return var3;
   }
}
