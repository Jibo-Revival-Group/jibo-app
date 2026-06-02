package com.google.android.gms.common.api;

public class CommonStatusCodes {
   public static String a(int var0) {
      String var1;
      switch (var0) {
         case -1:
            var1 = "SUCCESS_CACHE";
            break;
         case 0:
            var1 = "SUCCESS";
            break;
         case 1:
         case 9:
         case 11:
         case 12:
         default:
            var1 = new StringBuilder(32).append("unknown status code: ").append(var0).toString();
            break;
         case 2:
            var1 = "SERVICE_VERSION_UPDATE_REQUIRED";
            break;
         case 3:
            var1 = "SERVICE_DISABLED";
            break;
         case 4:
            var1 = "SIGN_IN_REQUIRED";
            break;
         case 5:
            var1 = "INVALID_ACCOUNT";
            break;
         case 6:
            var1 = "RESOLUTION_REQUIRED";
            break;
         case 7:
            var1 = "NETWORK_ERROR";
            break;
         case 8:
            var1 = "INTERNAL_ERROR";
            break;
         case 10:
            var1 = "DEVELOPER_ERROR";
            break;
         case 13:
            var1 = "ERROR";
            break;
         case 14:
            var1 = "INTERRUPTED";
            break;
         case 15:
            var1 = "TIMEOUT";
            break;
         case 16:
            var1 = "CANCELED";
            break;
         case 17:
            var1 = "API_NOT_CONNECTED";
            break;
         case 18:
            var1 = "DEAD_CLIENT";
      }

      return var1;
   }
}
