package com.jibo.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.jibo.aws.integration.aws.services.exception.ForbiddenRequestException;
import com.jibo.aws.integration.aws.services.exception.InvalidParameterValueException;
import com.jibo.aws.integration.aws.services.exception.InvalidRequestContentException;
import com.jibo.aws.integration.aws.services.exception.MethodNotAllowedException;
import com.jibo.aws.integration.aws.services.exception.NotAcceptableException;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.exception.ServiceException;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.aws.integration.aws.services.exception.UnprocessableEntityException;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import java.util.Arrays;
import java.util.List;

public class ErrorHelper {
   private static String a(Context var0, String var1) {
      Object var3 = null;
      String var6;
      if (TextUtils.isEmpty(var1)) {
         var6 = (String)var3;
      } else {
         List var4 = Arrays.asList(var0.getResources().getStringArray(2130903040));
         List var5 = Arrays.asList(var0.getResources().getStringArray(2130903041));
         int var2 = var4.indexOf(var1);
         var6 = (String)var3;
         if (var2 != -1) {
            var6 = (String)var3;
            if (var2 < var5.size()) {
               var6 = (String)var5.get(var2);
            }
         }
      }

      return var6;
   }

   public static String a(Context var0, Throwable var1) {
      StringBuilder var3 = new StringBuilder();
      String var2;
      if (var1 instanceof AmazonServiceException) {
         var2 = a(var0, ((AmazonServiceException)var1).getErrorCode());
      } else {
         var2 = null;
      }

      if (!TextUtils.isEmpty(var2)) {
         var3.append(var2);
      } else if (var1 instanceof UnprocessableEntityException) {
         var3.append(var0.getString(2131755316));
      } else if (var1 instanceof ServiceException) {
         var3.append(var0.getString(2131755314));
      } else if (!(var1 instanceof NotAcceptableException)
         && !(var1 instanceof MethodNotAllowedException)
         && !(var1 instanceof InvalidRequestContentException)
         && !(var1 instanceof InvalidParameterValueException)
         && !(var1 instanceof ForbiddenRequestException)) {
         if (var1 instanceof AmazonClientException && var1.getMessage().contains("No address associated with hostname")) {
            var3.delete(0, var3.length());
            var3.append(var0.getString(2131755309));
         } else if (var1 instanceof KeyManager.NoKeyForLoopException) {
            String var4;
            if (TextUtils.isEmpty(var1.getLocalizedMessage())) {
               var4 = var1.toString();
            } else {
               var4 = var1.getLocalizedMessage();
            }

            var3.append(var4);
         } else {
            var3.append(var0.getString(2131755310));
         }
      } else {
         var3.append(var0.getString(2131755306));
      }

      return var3.toString();
   }

   public static boolean a(AppCompatActivity var0, Fragment var1, Throwable var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if (var2 instanceof AmazonServiceException) {
         var2 = var2;
         if (a(var2)) {
            if (var1 != null) {
               DialogUtils.c(var1, 100, var1.getString(2131755271), var1.getString(2131755256));
               var3 = true;
               return var3;
            }

            if (var0 != null) {
               DialogUtils.b(null, var0.getSupportFragmentManager(), 100, var0.getString(2131755271), var0.getString(2131755256));
               var3 = true;
               return var3;
            }
         } else {
            if (!b(var2)) {
               var3 = var4;
               if (!c(var2)) {
                  return var3;
               }
            }

            if (var1 != null) {
               var0 = (BaseActivity)var1.getActivity();
            } else {
               var0 = var0;
            }

            Toast.makeText(var0, a(var0, var2.getErrorCode()), 1).show();
            var0.e();
         }

         var3 = true;
      }

      return var3;
   }

   public static boolean a(AmazonServiceException var0) {
      boolean var1;
      if (var0.getStatusCode() == 503 && "MAINTENANCE_MODE".equals(var0.getErrorCode())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean b(AmazonServiceException var0) {
      boolean var1;
      if (var0 instanceof ResourceNotFoundException && "ACCOUNT_NOT_FOUND".equals(var0.getErrorCode())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean c(AmazonServiceException var0) {
      boolean var1;
      if (var0.getStatusCode() == 401 && var0 instanceof UnauthorizedRequestException && "ACCOUNT_NOT_FOUND".equals(var0.getErrorCode())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean d(AmazonServiceException var0) {
      return "ACCOUNT_NOT_ACTIVE".equals(var0.getErrorCode());
   }
}
