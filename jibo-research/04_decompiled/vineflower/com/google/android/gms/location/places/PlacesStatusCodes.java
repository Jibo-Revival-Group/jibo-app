package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;

public class PlacesStatusCodes extends CommonStatusCodes {
   public static String b(int var0) {
      String var1;
      switch (var0) {
         case 9000:
            var1 = "PLACES_API_QUOTA_FAILED";
            break;
         case 9001:
            var1 = "PLACES_API_USAGE_LIMIT_EXCEEDED";
            break;
         case 9002:
            var1 = "PLACES_API_KEY_INVALID";
            break;
         case 9003:
            var1 = "PLACES_API_ACCESS_NOT_CONFIGURED";
            break;
         case 9004:
            var1 = "PLACES_API_INVALID_ARGUMENT";
            break;
         case 9005:
            var1 = "PLACES_API_RATE_LIMIT_EXCEEDED";
            break;
         case 9006:
            var1 = "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
            break;
         case 9007:
            var1 = "PLACES_API_KEY_EXPIRED";
            break;
         case 9008:
            var1 = "PLACES_API_INVALID_APP";
            break;
         case 9051:
            var1 = "PLACE_ALIAS_NOT_FOUND";
            break;
         case 9101:
            var1 = "PLACE_PROXIMITY_UNKNOWN";
            break;
         case 9102:
            var1 = "NEARBY_ALERTS_NOT_AVAILABLE";
            break;
         case 9150:
            var1 = "PLACEFENCING_NOT_AVAILABLE";
            break;
         case 9201:
            var1 = "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED";
            break;
         case 9202:
            var1 = "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED";
            break;
         default:
            var1 = CommonStatusCodes.a(var0);
      }

      return var1;
   }

   public static Status c(int var0) {
      String var1 = b(var0);
      zzbq.a((String)var1);
      return new Status(var0, var1);
   }
}
