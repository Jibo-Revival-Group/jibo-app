package com.jibo.aws.integration.helpers;

import android.location.Location;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.TimeZone;

public class RobotHelper {
   public static final String FIELD_ADDRESS_LINE = "addressLine";
   public static final String FIELD_AVATAR = "avatar";
   public static final String FIELD_CITY = "city";
   public static final String FIELD_CONNECTED_AT = "connectedAt";
   public static final String FIELD_COUNTRY = "country";
   public static final String FIELD_COUNTRY_CODE = "countryCode";
   public static final String FIELD_LATITUDE = "lat";
   public static final String FIELD_LOCATION_OVERRIDE_OBJECT = "locationOverride";
   public static final String FIELD_LONGITUDE = "lng";
   public static final String FIELD_PLATFORM = "platform";
   public static final String FIELD_REMOTE_ENABLED = "remoteEnabled";
   public static final String FIELD_SERIAL_NUMBER = "serialNumber";
   public static final String FIELD_SSID = "SSID";
   public static final String FIELD_STATE = "state";
   public static final String FIELD_STATE_ABBR = "stateAbbr";
   public static final String FIELD_TIMEZONE = "timezone";
   public static final String FIELD_ZIPCODE = "zipcode";

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String getAddressLine(Robot var0) {
      Object var2 = null;
      String var1 = (String)var2;
      if (var0 != null) {
         var1 = (String)var2;
         if (var0.getPayload().b("locationOverride")) {
            try {
               var5 = var0.getPayload().e("locationOverride");
            } catch (Exception var4) {
               var1 = (String)var2;
               return var1;
            }

            var1 = (String)var2;
            if (var5 != null) {
               var1 = (String)var2;

               try {
                  if (var5.b("addressLine")) {
                     var1 = var5.c("addressLine").c();
                  }
               } catch (Exception var3) {
                  var1 = (String)var2;
               }
            }
         }
      }

      return var1;
   }

   public static int getAvatar(Robot var0) {
      byte var2 = 0;
      int var1;
      if (var0 == null) {
         var1 = var2;
      } else {
         var1 = var2;
         if (var0.getPayload().b("avatar")) {
            try {
               var1 = var0.getPayload().c("avatar").f();
            } catch (Exception var3) {
               var1 = var2;
            }
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String getCountryCode(Robot var0) {
      Object var2 = null;
      String var1 = (String)var2;
      if (var0 != null) {
         var1 = (String)var2;
         if (var0.getPayload().b("locationOverride")) {
            try {
               var5 = var0.getPayload().e("locationOverride");
            } catch (Exception var4) {
               var1 = (String)var2;
               return var1;
            }

            var1 = (String)var2;
            if (var5 != null) {
               var1 = (String)var2;

               try {
                  if (var5.b("countryCode")) {
                     var1 = var5.c("countryCode").c();
                  }
               } catch (Exception var3) {
                  var1 = (String)var2;
               }
            }
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Location getLatLon(Robot var0) {
      Location var6;
      if (var0 != null) {
         if (var0.getPayload().b("locationOverride")) {
            Location var1 = new Location("JIBO_LOCATION");

            JsonObject var2;
            try {
               var2 = var0.getPayload().e("locationOverride");
            } catch (Exception var5) {
               return null;
            }

            if (var2 != null) {
               try {
                  if (var2.b("lat")) {
                     var1.setLatitude(var2.c("lat").d());
                  }
               } catch (Exception var4) {
                  return null;
               }
            }

            var6 = var1;
            if (var2 != null) {
               Location var7 = var1;

               try {
                  if (!var2.b("lng")) {
                     return var7;
                  }

                  var1.setLongitude(var2.c("lng").d());
               } catch (Exception var3) {
                  Object var8 = null;
                  return (Location)var8;
               }

               var6 = var1;
            }
         } else {
            var6 = null;
         }
      } else {
         var6 = null;
      }

      return var6;
   }

   public static String getLocation(Robot var0) {
      String var4;
      if (var0 == null) {
         var4 = "";
      } else {
         StringBuilder var2 = new StringBuilder();
         JsonObject var1 = null;
         if (var0.getPayload().b("locationOverride")) {
            try {
               var1 = var0.getPayload().e("locationOverride");
            } catch (Exception var3) {
               String var5 = var2.toString();
               return var5;
            }
         }

         if (var1 == null) {
            var4 = var2.toString();
         } else {
            if (var1.b("city")) {
               var2.append(var1.c("city").c());
            }

            if (var1.b("state")) {
               var2.append(", ").append(var1.c("state").c());
            }

            if (var1.b("country")) {
               var2.append(", ").append(var1.c("country").c());
            }

            var4 = var2.toString();
         }
      }

      return var4;
   }

   public static String getRobotOS(Robot var0) {
      String var1;
      if (var0 == null) {
         var1 = "";
      } else if (var0.getPayload().b("platform")) {
         var1 = var0.getPayload().c("platform").c();
      } else {
         var1 = null;
      }

      return var1;
   }

   public static String getRobotSerialName(Robot var0) {
      String var1;
      if (var0 == null) {
         var1 = "";
      } else if (var0.getPayload().b("serialNumber")) {
         var1 = var0.getPayload().c("serialNumber").c();
      } else {
         var1 = null;
      }

      return var1;
   }

   public static String getTimeZone(Robot var0) {
      String var1;
      if (var0 == null) {
         var1 = "";
      } else if (var0.getPayload().b("timezone")) {
         var1 = var0.getPayload().c("timezone").c();
      } else {
         var1 = null;
      }

      return var1;
   }

   public static String getTimeZoneFriendly(String var0, String var1) {
      TimeZone var3;
      if (TextUtils.isEmpty(var0)) {
         var3 = null;
      } else {
         var3 = TimeZone.getTimeZone(var0);
      }

      StringBuilder var2 = new StringBuilder();
      if (var3 != null) {
         var2.append(var3.getDisplayName()).append(" (GMT ").append(DateTimeUtils.getHourOffset(var3.getRawOffset())).append(")");
      } else {
         var2.append(var1);
      }

      return var2.toString();
   }

   public static String getWifiName(Robot var0) {
      String var1;
      if (var0 == null) {
         var1 = "";
      } else if (var0.getPayload().b("SSID")) {
         var1 = var0.getPayload().c("SSID").c();
      } else {
         var1 = "";
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String getZipcode(Robot var0) {
      Object var2 = null;
      String var1 = (String)var2;
      if (var0 != null) {
         var1 = (String)var2;
         if (var0.getPayload().b("locationOverride")) {
            try {
               var5 = var0.getPayload().e("locationOverride");
            } catch (Exception var4) {
               var1 = (String)var2;
               return var1;
            }

            var1 = (String)var2;
            if (var5 != null) {
               var1 = (String)var2;

               try {
                  if (var5.b("zipcode")) {
                     var1 = var5.c("zipcode").c();
                  }
               } catch (Exception var3) {
                  var1 = (String)var2;
               }
            }
         }
      }

      return var1;
   }
}
