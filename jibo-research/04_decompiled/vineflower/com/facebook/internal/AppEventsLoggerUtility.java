package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
   private static final Map<AppEventsLoggerUtility.GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new HashMap<AppEventsLoggerUtility.GraphAPIActivityType, String>() {
      {
         this.put(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
         this.put(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
      }
   };

   public static JSONObject getJSONObjectForGraphAPICall(
      AppEventsLoggerUtility.GraphAPIActivityType var0, AttributionIdentifiers var1, String var2, boolean var3, Context var4
   ) throws JSONException {
      JSONObject var5 = new JSONObject();
      var5.put("event", API_ACTIVITY_TYPE_TO_STRING.get(var0));
      Utility.setAppEventAttributionParameters(var5, var1, var2, var3);

      try {
         Utility.setAppEventExtendedDeviceInfoParameters(var5, var4);
      } catch (Exception var6) {
         Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", var6.toString());
      }

      var5.put("application_package_name", var4.getPackageName());
      return var5;
   }

   public enum GraphAPIActivityType {
      CUSTOM_APP_EVENTS,
      MOBILE_INSTALL_EVENT;

      private static final AppEventsLoggerUtility.GraphAPIActivityType[] $VALUES = new AppEventsLoggerUtility.GraphAPIActivityType[]{
         AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS
      };
   }
}
